package net.alwayshak.enchantments.enchants;

import net.alwayshak.enchantments.CustomEnchant;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class CutCleanEnchant extends CustomEnchant {

    public CutCleanEnchant(String name, String description, int maxLevel) {
        super(name, description, maxLevel);
    }

    public boolean conflictsWith(Enchantment enchantment) {
        return false;
    }

    public boolean canEnchantItem(ItemStack itemStack) {
        return false;
    }


}