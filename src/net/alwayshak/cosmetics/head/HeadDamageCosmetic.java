package net.alwayshak.cosmetics.head;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class HeadDamageCosmetic
        extends Cosmetic {
    public HeadDamageCosmetic() {
        super("Damage Indicator", "Its clear how much damage it did", Category.HEAD, Material.DIAMOND_SWORD, Rarity.EPIC);
        setSpin(true);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.DAMAGE_INDICATOR, loc, 1, 0.0D, 0.0D, 0.0D, 0.0D, Integer.valueOf(0));
    }
}


