package net.alwayshak.cosmetics.elytra;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class ElytraSmokeCosmetic
        extends Cosmetic {
    public ElytraSmokeCosmetic() {
        super("Smoke Plane", "Poop out smoke", Category.ELYTRA, Material.ELYTRA, Rarity.LEGENDARY);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.SMOKE_LARGE, loc.getX(), loc.getY(), loc.getZ(), 5, 0.3D, 0.0D, 0.3D, 0.0D);
    }
}


