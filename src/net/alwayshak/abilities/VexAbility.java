package net.alwayshak.abilities;

import net.alwayshak.Core;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.UUID;

public class VexAbility extends Ability {

    public VexAbility(String name, String description) {
        super(name, description);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.getPlugin(Core.class), new Runnable() {
            @Override
            public void run() {
                for(Player p : Bukkit.getOnlinePlayers()) {
                    if(getMembers().contains(p.getUniqueId())) {
                        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100, 1, false, false));
                    }
                }
            }
        },0,60);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (getMembers().contains(e.getPlayer().getUniqueId())) {
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100, 1, false, false));
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (getMembers().contains(event.getPlayer().getUniqueId())) {
            Player player = event.getPlayer();
            if (player.isSneaking()) {
                event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 2, 1, false, false));
            }
        }
    }

    @EventHandler
    public void onPlayerAttack(EntityDamageByEntityEvent event) {
        if(event.getDamager() instanceof Player) {
            Player p = (Player) event.getDamager();
            if(getMembers().contains(p.getUniqueId())) {
                Entity damagedEntity = event.getEntity();
                damagedEntity.setGlowing(true);
                Bukkit.getScheduler().runTaskLater(Core.getPlugin(Core.class), new Runnable() {
                    public void run() {
                        damagedEntity.setGlowing(false);
                    }
                }, 200L);
                Entity entity = event.getEntity();
                if (entity.isGlowing()) {
                    event.setDamage(event.getDamage() * 1.5);
                }
            }
        }
    }
}
