package net.alwayshak.cosmetics.head;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class HeadNoteCosmetic
        extends Cosmetic {
    public HeadNoteCosmetic() {
        super("Music Head", "Ya like Jazz?", Category.HEAD, Material.NOTE_BLOCK, Rarity.LEGENDARY);
        setSpin(true);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.NOTE, loc, 1);
    }
}


