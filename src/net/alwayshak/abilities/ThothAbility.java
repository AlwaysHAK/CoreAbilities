package net.alwayshak.abilities;

import net.alwayshak.Core;
import net.alwayshak.util.Materials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.material.Crops;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;
import org.checkerframework.checker.units.qual.C;

import java.util.*;

public class ThothAbility extends Ability {

    private boolean shift = false;

    public ThothAbility(String name, String description) {
        super(name, description);
        addMember(UUID.fromString("ac4cbc63-386f-4b4c-8a70-3e54caba0df9"));
        //addMember(UUID.fromString("5c46091f-8b93-48a2-97c1-62d243dcc430"));

    }

    public boolean onCooldown = false;

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent e) {
        if (getMembers().contains(e.getPlayer().getUniqueId()) && e.isSneaking()) {
            if (!this.shift) {
                this.shift = true;
                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Core.getPlugin(Core.class), new Runnable() {
                    public void run() {
                        ThothAbility.this.shift = false;
                    }
                }, 10L);
            } else {
                if (!onCooldown) {
                    // Do the thingamajig
                    freezeEntities(e.getPlayer());
                    onCooldown = true;
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Core.getPlugin(Core.class), new Runnable() {
                        @Override
                        public void run() {
                            onCooldown = false;
                        }
                    }, 3600);
                } else {
                    e.getPlayer().sendMessage("You're on cooldown");
                }
                this.shift = false;
            }
        }
    }

    //public List<LivingEntity> frozenEntities = new ArrayList<>();

    private void freezeEntities(Player p) {
        /*if(!frozenEntities.isEmpty())
            return;*/
        Location loc = p.getLocation();
        World w = loc.getWorld();
        List<LivingEntity> entities = w.getLivingEntities();
        for (LivingEntity entity : entities) {
            if (entity.getLocation().distance(loc) <= 11) {
                if (entity.getType() != EntityType.PLAYER) {
                    if (entity.hasAI() && entity.hasGravity()) {
                        //frozenEntities.add(entity);
                        entity.setAI(false);
                        entity.setGravity(false);
                        entity.setVelocity(new Vector(0, 0, 0));
                        Bukkit.getScheduler().scheduleSyncDelayedTask(Core.getPlugin(Core.class), new Runnable() {
                            @Override
                            public void run() {
                                entity.setAI(true);
                                entity.setGravity(true);
                            }
                        }, 200l);
                    }
                }
            }
        }
    }
    /*
    //Brawl Stars Max Ability
    @EventHandler
    public void onPlayerCrouch(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        if (!player.isOnGround()) {
            int taskId = Bukkit.getScheduler().scheduleSyncDelayedTask(Core.getPlugin(Core.class), new Runnable() {
                Location previousLocation = player.getLocation();
                @Override
                public void run() {
                    Location currentLocation = player.getLocation();
                    player.teleport(previousLocation);
                    previousLocation = currentLocation;
                }
            }, 200L);
        }
    }

     */
}
