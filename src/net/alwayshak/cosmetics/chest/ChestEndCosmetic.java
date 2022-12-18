package net.alwayshak.cosmetics.chest;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class ChestEndCosmetic
        extends Cosmetic {
    public ChestEndCosmetic() {
        super("End Trail", "The end stalks you", Category.CHEST, Material.END_ROD, Rarity.COMMON);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.END_ROD, loc.getX(), loc.getY(), loc.getZ(), 0, 0.0D, 0.0D, 0.0D, 10.0D);
    }
}


