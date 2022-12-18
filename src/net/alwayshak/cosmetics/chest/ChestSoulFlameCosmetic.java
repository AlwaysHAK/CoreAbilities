package net.alwayshak.cosmetics.chest;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class ChestSoulFlameCosmetic
        extends Cosmetic {
    public ChestSoulFlameCosmetic() {
        super("Soul Flame Trail", "Its too hot behind there?", Category.CHEST, Material.SOUL_SOIL, Rarity.COMMON);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, loc.getX(), loc.getY(), loc.getZ(), 0, 0.0D, 0.0D, 0.0D, 10.0D);
    }
}


