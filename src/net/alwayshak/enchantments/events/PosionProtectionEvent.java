package net.alwayshak.enchantments.events;

import net.alwayshak.enchantments.CustomEnchants;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;


public class PosionProtectionEvent
        implements Listener {
    @EventHandler
    public void onMagicDamage(EntityDamageEvent e) {
        if ((e.getCause() == EntityDamageEvent.DamageCause.MAGIC || e.getCause() == EntityDamageEvent.DamageCause.POISON) &&
                e.getEntity() instanceof Player p) {

            for (ItemStack stack : p.getInventory().getArmorContents()) {
                if (stack != null &&
                        stack.getItemMeta().hasEnchant(CustomEnchants.POSIONPROTRECTION))
                    e.setCancelled(true);
            }
        }
    }
}


