package net.alwayshak.cosmetics.hit;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import net.alwayshak.util.Utils;
import org.bukkit.Location;
import org.bukkit.Material;

public class HitLightningCosmetic
        extends Cosmetic {
    public HitLightningCosmetic() {
        super("Electricity", "STRIKE", Category.DAMAGE, Material.LIGHTNING_ROD, Rarity.EPIC);
    }

    public void onActivate(Location loc) {
        if (Utils.randomChance(50))
            loc.getWorld().strikeLightningEffect(loc);
    }
}


