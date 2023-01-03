package net.alwayshak.enchantments.enchants.tools;

import net.alwayshak.enchantments.CustomEnchant;
import net.alwayshak.util.Materials;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class OxegeniateEnchant extends CustomEnchant {

    public static OxegeniateEnchant ENCHANT;

    public OxegeniateEnchant(String name, String displayName, String description, int maxLevel) {
        super(name, displayName, description, maxLevel);
        ENCHANT = this;
    }

    public boolean conflictsWith(Enchantment enchantment) {
        if (enchantment.getKey().getNamespace() == AutoSmeltEnchant.ENCHANT.getKey().getNamespace()) return true;
        return false;
    }

    public boolean canEnchantItem(ItemStack itemStack) {
        for (Enchantment ench : itemStack.getEnchantments().keySet()) {
            if (conflictsWith(ench))
                return false;
        }
        if (Materials.isPickaxe(itemStack)) return true;
        if (Materials.isAxe(itemStack)) return true;
        if (Materials.isShovel(itemStack)) return true;
        return false;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        ItemStack hand = e.getPlayer().getInventory().getItemInMainHand();
        if (hand == null)
            return;

        if (hand.getEnchantments().containsKey(this)) {
            Block block = e.getBlock();
            player.setRemainingAir(player.getRemainingAir() + 80);
        }
    }
}
