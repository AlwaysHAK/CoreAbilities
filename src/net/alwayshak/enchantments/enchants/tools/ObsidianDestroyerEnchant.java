package net.alwayshak.enchantments.enchants.tools;

import net.alwayshak.enchantments.CustomEnchant;
import net.alwayshak.util.Materials;
import net.alwayshak.util.Utils;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.inventory.ItemStack;

public class ObsidianDestroyerEnchant extends CustomEnchant {

    public static ObsidianDestroyerEnchant ENCHANT;
    public ObsidianDestroyerEnchant(String name, String displayName, String description, int maxLevel) {
        super(name, displayName, description, maxLevel);
        ENCHANT = this;
    }

    public boolean conflictsWith(Enchantment enchantment) {
        return false;
    }

    public boolean canEnchantItem(ItemStack itemStack) {
        for(Enchantment ench : itemStack.getEnchantments().keySet()) {
            if(conflictsWith(ench))
                return false;
        }
        if (Materials.isPickaxe(itemStack)) return true;
        return false;
    }

    @EventHandler
    public void onInteract(BlockDamageEvent e) {
        Player p = e.getPlayer();
        if (p.getInventory().getItemInMainHand() == null) {
            return;
        }
        if (!p.getInventory().getItemInMainHand().hasItemMeta()) {
            return;
        }
        if (!p.getInventory().getItemInMainHand().getItemMeta().hasEnchant(this)) {
            return;
        }
        if (Utils.randomChance(10) && e.getBlock().getType() == Material.OBSIDIAN)
            e.setInstaBreak(true);
    }
}
