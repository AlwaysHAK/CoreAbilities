package net.alwayshak.abilities;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.UUID;

public class HasteAbility
        extends Ability {
    public HasteAbility(String name, String description) {
        super(name, description);
        addMember(UUID.fromString("de04afe5-1849-4d6e-a58e-438ffba11d86"));
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (getMembers().contains(e.getPlayer().getUniqueId()))
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1, 10000000, false, false));
    }
}
