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
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

public class KillFoxCosmetic
        extends Cosmetic {
    public KillFoxCosmetic() {
        super("Firefox", "Very colorful", Category.KILL, Material.FIREWORK_ROCKET, Rarity.SPECIAL);
    }

    public void onActivate(Location loc) {
        Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();

        fwm.setPower(1);
        fwm.addEffect(FireworkEffect.builder().withColor(Color.FUCHSIA, Color.LIME).trail(true).with(FireworkEffect.Type.BALL).build());
        fwm.addEffect(FireworkEffect.builder().withColor(Color.FUCHSIA, Color.LIME).withFade(new Color[]{Color.RED, Color.WHITE}).with(FireworkEffect.Type.BALL_LARGE).build());
        fw.setMetadata("nodamage", new FixedMetadataValue(Core.getPlugin(Core.class), Boolean.valueOf(true)));
        fw.setFireworkMeta(fwm);
    }
}


