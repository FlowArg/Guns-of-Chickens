package fr.flowarg.gunsofchickens.blocks.tileentities;

import fr.flowarg.gunsofchickens.blocks.machines.chickenfurnace.ChickenFurnace;
import fr.flowarg.gunsofchickens.blocks.machines.chickenfurnace.ChickenFurnaceRecipes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityChickenFurnace extends TileEntity implements IInventory,ITickable
{
    private NonNullList<ItemStack> inventory = NonNullList.<ItemStack>withSize(4, ItemStack.EMPTY);
    private String customName;
    private int burnTime;
    private int currentBurnTime;
    private int cookTime;
    private int totalCookTime;

    @Override
    public String getName()
    {
        return this.hasCustomName() ? this.customName : "container.chicken_furnace";
    }

    @Override
    public boolean hasCustomName()
    {
        return this.customName != null && !this.customName.isEmpty();
    }

    public void setCustomName(String customName)
    {
        this.customName = customName;
    }

    @Override
    public ITextComponent getDisplayName()
    {
        return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
    }

    @Override
    public int getSizeInventory()
    {
        return this.inventory.size();
    }

    @Override
    public boolean isEmpty()
    {
        for (ItemStack stack : this.inventory)
        {
            if (!stack.isEmpty()) return false;
        }
        return true;
    }

    @Override
    public ItemStack getStackInSlot(int index)
    {
        return (ItemStack)this.inventory.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count)
    {
        return ItemStackHelper.getAndSplit(this.inventory, index, count);
    }

    @Override
    public ItemStack removeStackFromSlot(int index)
    {
        return ItemStackHelper.getAndRemove(this.inventory, index);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack)
    {
        ItemStack itemStack = (ItemStack)this.inventory.get(index);
        boolean flag = !stack.isEmpty() && stack.isItemEqual(itemStack) && ItemStack.areItemStacksEqualUsingNBTShareTag(stack, itemStack);
        this.inventory.set(index, stack);

        if (stack.getCount() > this.getInventoryStackLimit()) stack.setCount(this.getInventoryStackLimit());

        if (index == 0 && !flag)
        {
            ItemStack stack1 = (ItemStack)this.inventory.get(index + 1);
            this.totalCookTime = this.getCookTime(stack, stack1);
            this.cookTime = 0;
            this.markDirty();
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.inventory = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.inventory);
        this.burnTime = compound.getInteger("BurnTime");
        this.cookTime = compound.getInteger("CookTime");
        this.totalCookTime = compound.getInteger("TotalCookTime");
        this.currentBurnTime = getItemBurnTime((ItemStack)this.inventory.get(2));

        if (compound.hasKey("CustomChickenFurnaceName", 8)) this.setCustomName(compound.getString("CustomChickenFurnaceName"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setInteger("BurnTime", (short)this.burnTime);
        compound.setInteger("CookTime", (short)this.cookTime);
        compound.setInteger("TotalCookTime", (short)this.totalCookTime);
        ItemStackHelper.saveAllItems(compound, this.inventory);

        if (this.hasCustomName()) compound.setString("CustomChickenFurnaceName", this.customName);

        return compound;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    public boolean isBurning()
    {
        return this.burnTime > 0;
    }

    @SideOnly(Side.CLIENT)
    public static boolean isBurning(IInventory inventory)
    {
        return inventory.getField(0) > 0;
    }

    @Override
    public void update()
    {
        boolean flag = this.isBurning();
        boolean flag1 = false;

        if (this.isBurning())
        {
            --this.burnTime;
            ChickenFurnace.setState(true, this.world, this.pos);
        }

        if (!this.world.isRemote)
        {
            ItemStack fuel = (ItemStack)this.inventory.get(2);

            if (this.isBurning() || !fuel.isEmpty() && ((((ItemStack)this.inventory.get(0)).isEmpty()) || ((ItemStack)this.inventory.get(1)).isEmpty()))
            {
                if (!this.isBurning() && this.canSmelt())
                {
                    this.burnTime = getItemBurnTime(fuel);
                    this.currentBurnTime = this.burnTime;

                    if (this.isBurning())
                    {
                        flag1 = true;

                        if (!fuel.isEmpty())
                        {
                            Item item = fuel.getItem();
                            fuel.shrink(1);

                            if (fuel.isEmpty())
                            {
                                ItemStack item1 = item.getContainerItem(fuel);
                                this.inventory.set(2, item1);
                            }
                        }
                    }
                }
                if (this.isBurning() && this.canSmelt() && this.cookTime > 0)
                {
                    this.cookTime++;

                    if (this.cookTime == this.totalCookTime)
                    {
                        this.cookTime = 0;
                        this.totalCookTime = this.getCookTime((ItemStack)this.inventory.get(0), (ItemStack)this.inventory.get(2));
                        System.out.println("update : do smelt");
                        this.smeltItem();
                        System.out.println("update : doed smelt");
                        flag1 = true;
                    }
                }
                else this.cookTime = 0;
            }
            else if (!this.isBurning() && this.cookTime > 0)
            {
                this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, this.totalCookTime);
            }
            if (flag != this.isBurning())
            {
                flag1 = true;
                ChickenFurnace.setState(this.isBurning(), this.world, this.pos);
            }
            if (flag1)
            {
                this.markDirty();
            }
        }
    }

    public int getCookTime(ItemStack input1, ItemStack input2)
    {
        return 200;
    }

    private boolean canSmelt()
    {
        if (((ItemStack)this.inventory.get(0)).isEmpty() || ((ItemStack)this.inventory.get(1)).isEmpty()) return false;
        else
        {
            ItemStack result = ChickenFurnaceRecipes.getInstance().getSmeltingResult((ItemStack)this.inventory.get(0), (ItemStack)this.inventory.get(1));
            if (result.isEmpty()) return false;
            else
            {
                ItemStack output = (ItemStack)this.inventory.get(3);
                if (output.isEmpty()) return true;
                if (!output.isItemEqual(result)) return false;
                int res = output.getCount() + result.getCount();
                return res <= this.getInventoryStackLimit() && res <= output.getMaxStackSize();
            }
        }
    }

    public void smeltItem()
    {
        System.out.println("smeltitem ?");
        if (this.canSmelt())
        {
            System.out.println("Method called : cansmelt");
            ItemStack input1 = (ItemStack)this.inventory.get(0);
            ItemStack input2 = (ItemStack)this.inventory.get(1);
            ItemStack result = ChickenFurnaceRecipes.getInstance().getSmeltingResult(input1, input2);
            ItemStack output = (ItemStack)this.inventory.get(3);

            System.out.println("smelting...");
            if (output.isEmpty()) this.inventory.set(3, result.copy());
            else if(output.getItem() == result.getItem()) output.grow(result.getCount());
            System.out.println("Grow items");

            input1.shrink(1);
            System.out.println("shrink 1");
            input2.shrink(1);
            System.out.println("shrink 2");
        }
    }

    public static int getItemBurnTime(ItemStack fuel)
    {
        if (fuel.isEmpty()) return 0;
        else return ForgeEventFactory.getItemBurnTime(fuel);
    }

    public static boolean isItemFuel(ItemStack fuel)
    {
        return getItemBurnTime(fuel) > 0;
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player)
    {
        return getWorld().getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)getPos().getX() + 0.5d, (double)getPos().getY() + 0.5d, (double)getPos().getZ() + 0.5d) <= 64;
    }

    @Override
    public void openInventory(EntityPlayer player)
    {

    }

    @Override
    public void closeInventory(EntityPlayer player)
    {
        InventoryHelper.dropInventoryItems(this.getWorld(), this.getPos(), this);
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack)
    {
        if (index == 3) return false;
        else if (index != 2) return true;
        else return isItemFuel(stack);
    }

    @Override
    public int getField(int id)
    {
        switch (id)
        {
            case 0:
                return this.burnTime;
            case 1:
                return this.currentBurnTime;
            case 2:
                return this.cookTime;
            case 3:
                return this.totalCookTime;
            default:
                return 0;
        }
    }

    @Override
    public void setField(int id, int value)
    {
        switch (id)
        {
            case 0:
                this.burnTime = value;
                break;
            case 1:
                this.currentBurnTime = value;
                break;
            case 2:
                this.cookTime = value;
                break;
            case 3:
                this.totalCookTime = value;
                break;
        }
    }

    @Override
    public int getFieldCount()
    {
        return 4;
    }

    @Override
    public void clear()
    {
        this.inventory.clear();
    }
}
