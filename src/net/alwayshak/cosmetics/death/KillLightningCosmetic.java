package net.alwayshak.cosmetics.death;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;

public class KillLightningCosmetic
        extends Cosmetic {
    public KillLightningCosmetic() {
        super("Lightning", "Last Strike", Category.KILL, Material.LIGHTNING_ROD, Rarity.RARE);
    }

    public void onActivate(Location loc) {
        loc.getWorld().strikeLightningEffect(loc);
    }
}


