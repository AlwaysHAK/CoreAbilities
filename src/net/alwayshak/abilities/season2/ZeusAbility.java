package net.alwayshak.abilities.season2;

import net.alwayshak.abilities.Ability;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class ZeusAbility extends Ability implements Listener {

    long lastUseTime;

    public ZeusAbility(String name, String description) {
        super(name, description);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if(getMembers().contains(e.getPlayer().getUniqueId())) {
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 99999999, 1, false, false));
        }
    }

    // Event listener for PlayerToggleSneakEvent
    @EventHandler
    public void onPlayerSneak(PlayerToggleSneakEvent event) {
        if(getMembers().contains(event.getPlayer().getUniqueId())) {
            Player player = event.getPlayer();
            if (event.isSneaking() && player.getLocation().getBlock().isEmpty()) {
                World world = player.getWorld();
                long currentTime = System.currentTimeMillis();
                if (currentTime - lastUseTime >= 300000) { // 300000 milliseconds = 5 minutes
                    lastUseTime = currentTime;
                    List<Entity> entities = world.getEntities();
                    for (Entity entity : entities) {
                        if (entity.getLocation().distance(player.getLocation()) <= 5) {
                            world.strikeLightning(entity.getLocation());
                        }
                    }
                } else {
                    player.sendMessage("This ability is on cooldown. Please wait " + (300000 - (currentTime - lastUseTime)) / 1000 + " seconds before using it again.");
                }
            }
        }
    }
}
