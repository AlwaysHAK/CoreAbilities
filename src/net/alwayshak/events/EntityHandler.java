package net.alwayshak.events;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class EntityHandler implements Listener {

    @EventHandler
    public void onKill(EntityDeathEvent e) {
        if (e.getEntity().getType() == EntityType.SHULKER)
            e.getEntity().getLocation().getWorld().dropItemNaturally(e.getEntity().getLocation(), new ItemStack(Material.SHULKER_SHELL, 1));
    }
}
