package net.alwayshak.abilities.season1;

import net.alwayshak.abilities.Ability;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class InvisibilityAbility extends Ability {
    private int duration;

    public InvisibilityAbility(String name, String description) {
        super(name, description);
    }


    @EventHandler
    public void onSneak(PlayerToggleSneakEvent e) {
        Player p = e.getPlayer();
        if (getMembers().contains(p.getUniqueId()))
            if (e.isSneaking()) {
                for (PotionEffect effect : p.getActivePotionEffects()) {
                    if (effect.getType().getName().equals("INVISIBILITY")) {
                        this.duration = effect.getDuration();
                        p.removePotionEffect(PotionEffectType.INVISIBILITY);
                    }
                }
                p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 20000000, 0, false, false, false));
            } else {
                p.removePotionEffect(PotionEffectType.INVISIBILITY);
                if (this.duration > 0) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, this.duration, 0, true, true, true));
                    this.duration = 0;
                }
            }
    }
}