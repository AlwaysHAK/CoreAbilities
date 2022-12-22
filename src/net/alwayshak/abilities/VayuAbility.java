package net.alwayshak.abilities;

import net.alwayshak.Core;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class VayuAbility extends Ability implements Listener {

    public VayuAbility(String name, String description) {
        super(name, description);
        addMember(UUID.fromString("ac4cbc63-386f-4b4c-8a70-3e54caba0df9"));
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        if(getMembers().contains(e.getPlayer().getUniqueId())) {
            e.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(14);
            //e.getPlayer().setAllowFlight(true);
        }
    }

    boolean busy = false;
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if(getMembers().contains(event.getPlayer().getUniqueId())) {
            if (event.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                Player player = event.getPlayer();

                if(!player.getLocation().subtract(0, 1.5, 0).getBlock().getType().isAir())
                    canDash = true;
                else
                    canDash = false;

                if(player.getVelocity().getY() < -0.08)
                    player.setAllowFlight(false);
                else {
                    if (player.isOnGround() && player.getAllowFlight() == false && !busy) {
                        busy = true;
                        Bukkit.getScheduler().scheduleSyncDelayedTask(Core.getPlugin(Core.class), new Runnable() {
                            @Override
                            public void run() {
                                player.setAllowFlight(true);
                                busy = false;
                            }
                        }, 3l);
                    } else if (player.isFlying()) {
                        player.setAllowFlight(false);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerToggleFlight(PlayerToggleFlightEvent event) {
        if(getMembers().contains(event.getPlayer().getUniqueId())) {
            Player player = event.getPlayer();
            if (player.getGameMode() == GameMode.SURVIVAL && player.getVelocity().getY() > 0) {
                // Player is in survival mode, in the air and is not already flying, and they have not used their double jump yet
                // so allow them to double jump
                player.setAllowFlight(false);
                Vector vel = player.getVelocity();
                vel.setY(vel.getY() + 0.3);
                vel.setX(vel.getX()*2);
                vel.setZ(vel.getZ()*2);
                player.setVelocity(vel);
            }
        }
    }

    boolean canDash = true;

    @EventHandler
    public void onPlayerToggleSneak(PlayerToggleSneakEvent event) {
        if(getMembers().contains(event.getPlayer().getUniqueId())) {
            Player player = event.getPlayer();
            if (event.getPlayer().getGameMode() == GameMode.SURVIVAL && canDash) {
                // Check if the player is in the air
                if (!player.isOnGround()) {
                    // Check if the player is pressing the crouch button
                    if (event.isSneaking()) {
                        // Launch the player forward with a dash
                        Vector velocity = player.getEyeLocation().getDirection().multiply(1);
                        player.setVelocity(velocity);
                    }
                }
            }
        }
    }

}
