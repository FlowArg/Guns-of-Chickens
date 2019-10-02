package fr.flowarg.gunsofchickens.utils.handlers;

import net.minecraft.util.IStringSerializable;

public class EnumHandler
{
    public enum EnumType implements IStringSerializable
    {
        CHICKEN(0, "chicken"),
        CHICKEN_DIAMOND(1, "chicken_diamond"),
        CHICKEN_COAL(2, "chicken_coal");

        private static final EnumType[] META_LOOP = new EnumType[values().length];
        private final int meta;
        private final String name, unlocalizedName;

        EnumType(int meta, String name)
        {
            this(meta, name, name);
        }

        EnumType(int meta, String name, String unlocalizedName)
        {
            this.meta = meta;
            this.name = name;
            this.unlocalizedName = unlocalizedName;
        }

        @Override
        public String getName()
        {
            return this.name;
        }

        public int getMeta()
        {
            return this.meta;
        }

        public String getUnlocalizedName()
        {
            return this.unlocalizedName;
        }

        @Override
        public String toString()
        {
            return this.name;
        }

        public static EnumType byMetadata(int meta)
        {
            return META_LOOP[meta];
        }

        static
        {
            for (EnumType enumType : values())
            {
                META_LOOP[enumType.getMeta()] = enumType;
            }
        }
    }
}
