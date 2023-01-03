package net.alwayshak.abilities.season1;

import net.alwayshak.abilities.Ability;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HasteAbility
        extends Ability {
    public HasteAbility(String name, String description) {
        super(name, description);
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (getMembers().contains(e.getPlayer().getUniqueId()))
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1, 10000000, false, false));
    }
}
