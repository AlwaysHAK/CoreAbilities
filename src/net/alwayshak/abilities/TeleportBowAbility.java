package net.alwayshak.abilities;

import net.alwayshak.Core;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

public class TeleportBowAbility extends Ability {
    private boolean shift;
    private boolean toggled;
    public boolean onCooldown;
    public int cooldownLeft;

    @EventHandler
    public void onShift(PlayerToggleSneakEvent e) {
        if (getMembers().contains(e.getPlayer().getUniqueId()) && e.isSneaking() == true && e.getPlayer().getInventory().getItemInMainHand().getType() == Material.BOW)
            if (!this.shift) {
                this.shift = true;
                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Core.getPlugin(Core.class), new Runnable() {
                    public void run() {
                        TeleportBowAbility.this.shift = false;
                    }
                }, 10L);
            } else {
                this.toggled = !this.toggled;
                if (this.toggled) {
                    sendHotbar(e.getPlayer(), "&aTeleport Bow is toggled on");
                } else {
                    sendHotbar(e.getPlayer(), "&cTeleport Bow is toggled off");
                }
                this.shift = false;
            }
    }

    public TeleportBowAbility(String name, String description) {
        super(name, description);


        this.shift = false;
        this.toggled = true;


        this.onCooldown = false;
        this.cooldownLeft = 0;
        addMember(UUID.fromString("ac4cbc63-386f-4b4c-8a70-3e54caba0df9"));
    }

    @EventHandler
    public void onProjectileLand(ProjectileHitEvent e) {
        if (e.getEntity() instanceof Arrow) {
            Arrow arrow = (Arrow) e.getEntity();
            if (arrow.getShooter() instanceof Player)
                for (Entity entity : arrow.getPassengers())
                    arrow.removePassenger(entity);
        }
    }

    @EventHandler
    public void onBowShoot(EntityShootBowEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (getMembers().contains(p.getUniqueId())) {
                if (e.getProjectile() instanceof Arrow) {
                    Arrow arrow = (Arrow) e.getProjectile();
                    if (this.toggled)
                        if (this.onCooldown) {
                            sendHotbar(p, "&cYou're still on cooldown! " + this.cooldownLeft + 1 + " seconds left.");
                        } else {
                            this.onCooldown = true;
                            this.cooldownLeft = 9;
                            handleCooldown();
                            arrow.addPassenger((Entity) p);
                        }
                    arrow.setPickupStatus(AbstractArrow.PickupStatus.CREATIVE_ONLY);
                }
                e.getConsumable().setAmount(e.getConsumable().getAmount() + 1);
                p.updateInventory();
            }
        }
    }

    private void handleCooldown() {
        Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Core.getPlugin(Core.class), new Runnable() {
            public void run() {
                if (TeleportBowAbility.this.cooldownLeft > 0) {
                    TeleportBowAbility.this.cooldownLeft--;
                    TeleportBowAbility.this.handleCooldown();
                } else {
                    TeleportBowAbility.this.onCooldown = false;
                }
            }
        }, 20L);
    }

    public void sendHotbar(Player p, String msg) {
        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, (BaseComponent) new TextComponent(ChatColor.translateAlternateColorCodes('&', msg)));
    }
}
