package net.alwayshak.enchantments;

import org.bukkit.inventory.ItemStack;

public abstract class CustomEnchant {

    private final String name;
    private final String description;

    public CustomEnchant(String name, String description) {
        this.name = name;
        this.description = description;
    }

    abstract boolean isCompatible(ItemStack stack);

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }
}
