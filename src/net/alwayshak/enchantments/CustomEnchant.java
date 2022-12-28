package net.alwayshak.enchantments;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public abstract class CustomEnchant extends Enchantment implements Listener {

    private final String name;
    private final String description;
    private final int maxLevel;

    public CustomEnchant(String name, String description, int maxLevel) {
        super(NamespacedKey.minecraft(name));
        this.name = name;
        this.description = description;
        this.maxLevel = maxLevel;
    }

    public String getName() {
        return null;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public int getStartLevel() {
        return 1;
    }

    public EnchantmentTarget getItemTarget() {
        return null;
    }

    public boolean isTreasure() {
        return false;
    }

    public boolean isCursed() {
        return false;
    }

    public abstract boolean conflictsWith(Enchantment enchantment);

    public abstract boolean canEnchantItem(ItemStack itemStack);
}
