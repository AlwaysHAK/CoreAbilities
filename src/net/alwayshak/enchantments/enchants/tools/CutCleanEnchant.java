package net.alwayshak.enchantments.enchants.tools;

import net.alwayshak.enchantments.CustomEnchant;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class CutCleanEnchant extends CustomEnchant {

    public static CutCleanEnchant ENCHANT;
    public CutCleanEnchant(String name, String displayName, String description, int maxLevel) {
        super(name, displayName, description, maxLevel);
        ENCHANT = this;
    }

    public boolean conflictsWith(Enchantment enchantment) {
        return false;
    }

    public boolean canEnchantItem(ItemStack itemStack) {
        return false;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        ItemStack hand = event.getPlayer().getInventory().getItemInMainHand();
        if(hand == null)
            return;

        if(hand.getEnchantments().containsKey(this)) {
            ItemStack item = event.getItem();
            if (item != null && item.getType().name().contains("SHEARS")) {
                Block block = event.getClickedBlock();
                if (block != null && block.getType().name().contains("GLASS")) {
                    block.breakNaturally();
                }
            }
        }
    }
}
