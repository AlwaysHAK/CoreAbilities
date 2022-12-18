package net.alwayshak.cosmetics.chest;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class ChestFlameCosmetic
        extends Cosmetic {
    public ChestFlameCosmetic() {
        super("Flame Trail", "Bit hot behind you?", Category.CHEST, Material.BLAZE_POWDER, Rarity.COMMON);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.FLAME, loc.getX(), loc.getY(), loc.getZ(), 0, 0.0D, 0.0D, 0.0D, 10.0D);
    }
}


