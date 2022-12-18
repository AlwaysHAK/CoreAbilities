package net.alwayshak.abilities;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetEvent;

import java.util.UUID;


public class CatAbility extends Ability {
    public CatAbility(String name, String description) {
        super(name, description);
        addMember(UUID.fromString("319c76cb-0c0c-4570-8abc-07a7b502cc74"));
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntityType() == EntityType.PLAYER) {
            Player p = (Player) e.getEntity();
            if (getMembers().contains(p.getUniqueId()) && e.getCause() == EntityDamageEvent.DamageCause.FALL) {
                e.setDamage(e.getDamage() * 0.5D);
                drawCircle(p.getLocation(), 1.5F, Particle.CLOUD);
            }
        }
    }


    @EventHandler
    public void onMobTarget(EntityTargetEvent e) {
        if (e.getEntity() instanceof org.bukkit.entity.Creeper && e.getTarget() instanceof Player p) {
            if (getMembers().contains(p.getUniqueId())) {
                e.setCancelled(true);
            }
        }
    }

    private void drawCircle(Location loc, float radius, Particle particle) {
        double t;
        for (t = 0.0D; t < 50.0D; t += 0.5D) {
            float x = radius * (float) Math.sin(t);
            float z = radius * (float) Math.cos(t);
            loc.getWorld().spawnParticle(particle, ((float) loc.getX() + x), (float) loc.getY(), ((float) loc.getZ() + z), 0, 0.0D, 0.0D, 0.0D, 1.0D);
        }
    }
}