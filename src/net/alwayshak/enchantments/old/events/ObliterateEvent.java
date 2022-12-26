package net.alwayshak.enchantments.old.events;

import net.alwayshak.enchantments.old.CustomEnchants;
import net.alwayshak.util.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;


public class ObliterateEvent
        implements Listener {
    @EventHandler
    public void onInterract(BlockDamageEvent e) {
        Player p = e.getPlayer();
        if (p.getInventory().getItemInMainHand() == null) {
            return;
        }
        if (!p.getInventory().getItemInMainHand().hasItemMeta()) {
            return;
        }
        if (!p.getInventory().getItemInMainHand().getItemMeta().hasEnchant(CustomEnchants.OBLITERATE)) {
            return;
        }
        if (Utils.randomChance(10))
            e.setInstaBreak(true);
    }
}


