package net.alwayshak.cosmetics.hit;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class HitAngryCosmetic extends Cosmetic {

    public HitAngryCosmetic() {
        super("Angry", "Very angry hits", Category.DAMAGE, Material.VILLAGER_SPAWN_EGG, Rarity.COMMON);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.VILLAGER_ANGRY, loc.getX(), loc.getY() + 2.25D, loc.getZ(), 0, 0.0D, 0.0D, 0.0D, 0.0D);
    }

}


