package net.alwayshak.enchantments.old;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class EnchantmentWrapper
        extends Enchantment {
    private final String name;
    private final int maxLvl;

    public EnchantmentWrapper(String namespace, String name, int lvl) {
        super(NamespacedKey.minecraft(namespace));
        this.name = name;
        this.maxLvl = lvl;
    }


    public String getName() {
        return this.name;
    }


    public int getMaxLevel() {
        return this.maxLvl;
    }


    public int getStartLevel() {
        return 0;
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


    public boolean conflictsWith(Enchantment enchantment) {
        return false;
    }


    public boolean canEnchantItem(ItemStack itemStack) {
        return false;
    }
}


