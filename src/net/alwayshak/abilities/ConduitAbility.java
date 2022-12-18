package net.alwayshak.abilities;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.UUID;


public class ConduitAbility extends Ability {
    public ConduitAbility(String name, String description) {
        super(name, description);
        addMember(UUID.fromString("705540d8-2ee8-41b3-9322-ae907c9a1ed8"));
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (getMembers().contains(e.getPlayer().getUniqueId())) {
            Player p = e.getPlayer();
            if (p.getWorld().getBlockAt(p.getLocation()).getType() == Material.WATER || p.getWorld().getBlockAt(p.getLocation()).getBlockData() instanceof org.bukkit.block.data.Waterlogged) {
                for (PotionEffect effect : p.getActivePotionEffects()) {
                    if (effect.getType() == PotionEffectType.CONDUIT_POWER) {
                        return;
                    }
                }
                p.addPotionEffect(new PotionEffect(PotionEffectType.CONDUIT_POWER, 100000000, 1, false, false));
            } else {
                p.removePotionEffect(PotionEffectType.CONDUIT_POWER);
            }
        }
    }
}
