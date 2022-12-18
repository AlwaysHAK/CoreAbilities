package net.alwayshak.cosmetics.chest;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class ChestNoteCosmetic
        extends Cosmetic {
    public ChestNoteCosmetic() {
        super("Note Trail", "The music follows you", Category.CHEST, Material.NOTE_BLOCK, Rarity.EPIC);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.NOTE, loc.getX(), loc.getY(), loc.getZ(), 1, 0.0D, 0.0D, 0.0D, 10.0D);
    }
}


