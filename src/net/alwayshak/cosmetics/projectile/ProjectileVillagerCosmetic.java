package net.alwayshak.cosmetics.projectile;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class ProjectileVillagerCosmetic
        extends Cosmetic {
    public ProjectileVillagerCosmetic() {
        super("Angry Villager Trail", "Why did u hit it?", Category.ARROW, Material.VILLAGER_SPAWN_EGG, Rarity.COMMON);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.VILLAGER_ANGRY, loc.getX(), loc.getY(), loc.getZ(), 0, 0.0D, 0.0D, 0.0D, 0.0D);
    }
}


