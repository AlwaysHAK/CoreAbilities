package net.alwayshak.cosmetics.head;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class HeadEnderCosmetic
        extends Cosmetic {
    public HeadEnderCosmetic() {
        super("Ender Head", "Teleport around the world", Category.HEAD, Material.ENDER_PEARL, Rarity.EPIC);
        setSpin(true);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.SPELL_WITCH, loc, 1);
    }
}


