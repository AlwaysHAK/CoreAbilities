package net.alwayshak.cosmetics.elytra;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class ElytraWitchCosmetic
        extends Cosmetic {
    public ElytraWitchCosmetic() {
        super("Ender Trail", "The flying enderman?", Category.ELYTRA, Material.ENDER_PEARL, Rarity.EPIC);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.SPELL_WITCH, loc.getX(), loc.getY(), loc.getZ(), 1, 0.3D, 0.0D, 0.3D, 0.0D);
    }
}


