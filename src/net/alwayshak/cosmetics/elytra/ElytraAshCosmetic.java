package net.alwayshak.cosmetics.elytra;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class ElytraAshCosmetic
        extends Cosmetic {
    public ElytraAshCosmetic() {
        super("Motor Problem", "Is there something wrong with your motor?", Category.ELYTRA, Material.ELYTRA, Rarity.COMMON);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.ASH, loc.getX(), loc.getY(), loc.getZ(), 1, 0.3D, 0.0D, 0.3D, 0.0D);
    }
}


