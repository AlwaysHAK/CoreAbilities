package net.alwayshak.cosmetics.special;

import net.alwayshak.Core;
import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.metadata.FixedMetadataValue;

public class KillOazzCosmetic extends Cosmetic {
    public KillOazzCosmetic() {
        super("Starazzies", "Starrier that TrudoStar", Category.KILL, Material.FIREWORK_ROCKET, Rarity.SPECIAL);
    }

    public void onActivate(Location loc) {
        Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();

        fwm.setPower(1);
        fwm.addEffect(FireworkEffect.builder().with(FireworkEffect.Type.STAR).withColor(Color.WHITE, Color.AQUA).trail(true).build());
        fw.setMetadata("nodamage", new FixedMetadataValue(Core.getPlugin(Core.class), Boolean.valueOf(true)));
        fw.setFireworkMeta(fwm);
    }
}


