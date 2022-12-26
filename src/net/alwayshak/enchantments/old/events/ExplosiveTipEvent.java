package net.alwayshak.enchantments.old.events;

import net.alwayshak.enchantments.old.CustomEnchants;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import java.util.ArrayList;
import java.util.List;


public class ExplosiveTipEvent
        implements Listener {
    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {
        if (this.projectiles.contains(e.getEntity())) {
            this.projectiles.remove(e.getEntity());
            Location loc = e.getEntity().getLocation();

            World world = loc.getWorld();
            double x = loc.getX();
            double y = loc.getY();
            double z = loc.getZ();

            world.createExplosion(x, y, z, 3.0F, false, true);
        }
    }


    private final List<Projectile> projectiles = new ArrayList<>();

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent e) {
        if (e.getEntity().getShooter() instanceof Player p && e.getEntity() instanceof org.bukkit.entity.Arrow) {
            if (p.getInventory().getItemInMainHand().getItemMeta().hasEnchant(CustomEnchants.EXPLOSIVETIP))
                this.projectiles.add(e.getEntity());
        }
    }
}


