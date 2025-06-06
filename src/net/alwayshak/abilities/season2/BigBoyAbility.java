package net.alwayshak.abilities.season2;

import net.alwayshak.abilities.Ability;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class BigBoyAbility extends Ability {

    public BigBoyAbility(String name, String description) {
        super(name, description);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if(getMembers().contains(e.getPlayer().getUniqueId())) {
            e.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(30);
            //e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 99999999, 0, false, false));
        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent e) {
        if(e.getDamager().getType() == EntityType.PLAYER) {
            Player p = (Player) e.getDamager();
            if(getMembers().contains(p.getUniqueId())) {
                p.sendMessage(String.valueOf(e.getDamage()));
                e.setDamage(e.getDamage() * 1.3);
                p.sendMessage(String.valueOf(e.getDamage()));
            }
        }
    }
}
