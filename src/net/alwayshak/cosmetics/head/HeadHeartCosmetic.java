package net.alwayshak.cosmetics.head;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class HeadHeartCosmetic
        extends Cosmetic {
    public HeadHeartCosmetic() {
        super("Hearts", "Spread some love above your head.", Category.HEAD, Material.BEETROOT, Rarity.EPIC);
        setSpin(true);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.HEART, loc, 1);
    }
}


