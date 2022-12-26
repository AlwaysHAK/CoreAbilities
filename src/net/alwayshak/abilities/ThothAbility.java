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
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.UUID;

public class ThothAbility extends Ability {

    private boolean shift = false;

    public ThothAbility(String name, String description) {
        super(name, description);
        addMember(UUID.fromString("ac4cbc63-386f-4b4c-8a70-3e54caba0df9"));
        addMember(UUID.fromString("5c46091f-8b93-48a2-97c1-62d243dcc430"));
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
    private void speedCrops(Player player) {
        //First, get the player's location
        Location playerLocation = player.getLocation();

        //Next, get the blocks in a 10 block radius around the player
        List<Block> blocksInRadius = new ArrayList<Block>();
        for (int x = -10; x <= 10; x++) {
            for (int y = -10; y <= 10; y++) {
                for (int z = -10; z <= 10; z++) {
                    blocksInRadius.add(playerLocation.getBlock().getRelative(x, y, z));
                }
            }
        }

        //Iterate through the blocks and check if they are crops
        for (Block b : blocksInRadius) {
            if (b.getType() == Material.WHEAT) {
                //If the block is a crop, increase its growth level by 50%
                int growthLevel = b.getData();
                growthLevel = (int) Math.ceil(growthLevel * 1.5);
                //Make sure the growth level doesn't exceed 7 (fully grown)
                if (growthLevel > 7) {
                    growthLevel = 7;
                }
                b.setBlockData((byte) growthLevel);
            }
        }

    }
*/
}
