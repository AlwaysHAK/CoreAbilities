package net.alwayshak.abilities;

import net.alwayshak.Core;
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

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if(getMembers().contains(event.getPlayer().getUniqueId())) {
            if (event.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                Player player = event.getPlayer();
                if (player.isOnGround()) {
                    // Player is on the ground, so they can jump again
                    player.setAllowFlight(true);
                } else if (player.isFlying()) {
                    // Player is in the air and has double jumped, so they can't jump again
                    player.setAllowFlight(false);
                }
            }
        }
    }

    @EventHandler
    public void onPlayerToggleFlight(PlayerToggleFlightEvent event) {
        if(getMembers().contains(event.getPlayer().getUniqueId())) {
            Player player = event.getPlayer();
            if (player.getGameMode() == GameMode.SURVIVAL && !event.isFlying() && player.getVelocity().getY() > 0 && !player.isFlying() && player.getAllowFlight()) {
                // Player is in survival mode, in the air and is not already flying, and they have not used their double jump yet
                // so allow them to double jump
                Vector velocity = player.getVelocity();
                velocity.setY(velocity.getY() * 1.5);
                player.setVelocity(velocity);
                player.setAllowFlight(false);
            }
        }
    }

    @EventHandler
    public void onPlayerToggleSneak(PlayerToggleSneakEvent event) {
        if(getMembers().contains(event.getPlayer().getUniqueId())) {
            Player player = event.getPlayer();

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
