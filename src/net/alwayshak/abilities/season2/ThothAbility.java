package net.alwayshak.abilities;

import net.alwayshak.Core;
import net.alwayshak.abilities.Ability;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ThothAbility extends Ability {

    private boolean shift = false;

    private HashMap<UUID, ArrayList<Location>> locations = new HashMap<>();

    boolean onCooldownTP = false;

    public ThothAbility(String name, String description) {
        super(name, description);
        addMember(UUID.fromString("ac4cbc63-386f-4b4c-8a70-3e54caba0df9"));

        for(Player p : Bukkit.getOnlinePlayers()) {
            if (getMembers().contains(p.getUniqueId())) {
                locations.put(p.getUniqueId(), new ArrayList<>());
            }
        }
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.getPlugin(Core.class), new Runnable() {
            @Override
            public void run() {
                for (UUID uuid : ThothAbility.super.getMembers()) {
                    if (Bukkit.getPlayer(uuid) == null) {
                        locations.remove(uuid);
                        continue;
                    }
                    ArrayList<Location> loc = locations.get(uuid);
                    if (loc != null) {
                        loc.add(Bukkit.getPlayer(uuid).getLocation());
                        if (loc.size() > 10) {
                            loc.remove(0);
                        }
                    }
                }
            }
        }, 0l, 20l);
    }

    public boolean onCooldown = false;

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (getMembers().contains(e.getPlayer().getUniqueId())) {
            locations.put(e.getPlayer().getUniqueId(), new ArrayList<>());
        }
    }

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent e) {
        if (getMembers().contains(e.getPlayer().getUniqueId()) && e.isSneaking()) {
            if (e.isSneaking() && !e.getPlayer().isOnGround()) {
                if (!onCooldownTP && locations.get(e.getPlayer().getUniqueId()) != null) {
                    if (locations.get(e.getPlayer().getUniqueId()).size() == 10) {
                        e.getPlayer().teleport(locations.get(e.getPlayer().getUniqueId()).get(0));
                        onCooldownTP = true;
                        Bukkit.getScheduler().scheduleSyncDelayedTask(Core.getPlugin(Core.class), new Runnable() {
                            @Override
                            public void run() {
                                onCooldownTP = false;
                            }
                        }, 120l);
                    }
                } else
                    e.getPlayer().sendMessage("You're on cooldown");

            }
            if (!this.shift) {
                this.shift = true;
                Bukkit.getScheduler().scheduleSyncDelayedTask(Core.getPlugin(Core.class), new Runnable() {
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
