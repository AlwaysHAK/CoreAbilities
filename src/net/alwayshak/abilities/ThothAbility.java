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
import org.bukkit.util.Vector;

import java.util.List;
import java.util.UUID;

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

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if(getMembers().contains(player.getUniqueId())) {
            Location playerLocation = player.getLocation();
            int radius = 10;
            for (int x = -radius; x <= radius; x++) {
                for (int y = -radius; y <= radius; y++) {
                    for (int z = -radius; z <= radius; z++) {
                        Block block = playerLocation.add(x, y, z).getBlock();
                        if (block.getBlockData() instanceof Ageable) {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cAGEABLE"));
                            Ageable crop = (Ageable) block.getBlockData();
                            crop.setAge(crop.getMaximumAge());
                        }
                    }
                }
            }
        }
    }

}
