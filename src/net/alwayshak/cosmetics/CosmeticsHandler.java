package net.alwayshak.cosmetics;

import net.alwayshak.Core;
import net.alwayshak.config.ConfigHandler;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;


public class CosmeticsHandler
        implements Listener {
    private Core core;
    private final ConfigHandler configHandler = ConfigHandler.getInstance();
    private final FileConfiguration cosmeticsConfig = ConfigHandler.getInstance().getCosmetics();

    private List<Cosmetic> cosmetics;

    public static CosmeticsHandler instance;
    private int headCycle;
    private final int cycleSpeed = 5;


    private int cycleTimer;


    private List<Vector> circle;


    private List<Projectile> projectiles;


    public List<Cosmetic> getEnabledCosmetics(Player p) {
        List<Cosmetic> enabledCosmetics = new ArrayList<>();
        for (Cosmetic cosmetic : this.cosmetics) {
            if (cosmetic.hasMember(p))
                enabledCosmetics.add(cosmetic);
        }
        return enabledCosmetics;
    }

    public List<Cosmetic> getUnlockedCosmetics(Player p) {
        List<Cosmetic> unlockedCosmetics = new ArrayList<>();
        for (Cosmetic cosmetic : this.cosmetics) {
            if (cosmetic.hasUnlocked(p))
                unlockedCosmetics.add(cosmetic);
        }
        return unlockedCosmetics;
    }

    public void registerCosmetic(Cosmetic cosmetic) {
        this.cosmetics.add(cosmetic);
        Bukkit.getPluginManager().registerEvents(cosmetic, this.core);
    }

    public List<Cosmetic> getCosmetics() {
        return this.cosmetics;
    }


    private void genCircle(float radius) {
        this.circle = new ArrayList<>();
        for (double t = 0.0D; t < 50.0D; t += 0.5D) {
            float x = radius * (float) Math.sin(t);
            float z = radius * (float) Math.cos(t);
            this.circle.add(new Vector(x, 0.0F, z));
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (e.getTo().getX() == e.getFrom().getX() && e.getTo().getY() == e.getFrom().getY() && e.getTo().getZ() == e.getFrom().getZ())
            return;
        for (Cosmetic cosmetic : this.cosmetics) {
            if (cosmetic.hasMember(e.getPlayer()) && e.getPlayer().getGameMode() != GameMode.SPECTATOR) {
                if (cosmetic.getCategory() == Category.FEET || cosmetic.getCategory() == Category.CHEST) {
                    if (!e.getPlayer().isGliding()) {
                        if (cosmetic.getCategory() == Category.CHEST) {
                            if (cosmetic.hasSpin()) {
                                cosmetic.onActivate(e.getFrom().clone().add(0.0D, 1.3D, 0.0D).add(this.circle.get(this.headCycle)));
                                continue;
                            }
                            cosmetic.onActivate(e.getFrom().clone().add(0.0D, 1.3D, 0.0D));
                            continue;
                        }
                        if (cosmetic.hasSpin()) {
                            cosmetic.onActivate(e.getFrom().clone().add(this.circle.get(this.headCycle)));
                            continue;
                        }
                        cosmetic.onActivate(e.getFrom().clone());
                    }
                    continue;
                }
                if (cosmetic.getCategory() == Category.ELYTRA &&
                        e.getPlayer().isGliding()) {
                    if (cosmetic.hasSpin()) {
                        cosmetic.onActivate(e.getFrom().clone().add(this.circle.get(this.headCycle)));
                        continue;
                    }
                    cosmetic.onActivate(e.getFrom().clone());
                }
            }
        }
    }

    public CosmeticsHandler(Core core) {
        this.projectiles = new ArrayList<>();
        instance = this;
        this.core = core;
        this.cosmetics = new ArrayList<>();
        genCircle(0.75F);
        Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin) core, new Runnable() {
            public void run() {
                CosmeticsHandler.this.headCycle++;
                if (CosmeticsHandler.this.headCycle >= CosmeticsHandler.this.circle.size())
                    CosmeticsHandler.this.headCycle = 0;
                for (Cosmetic cosmetic : CosmeticsHandler.this.cosmetics) {
                    if (cosmetic.getCategory() == Category.HEAD)
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            if (cosmetic.getMembers().contains(p.getUniqueId()) && p.getGameMode() != GameMode.SPECTATOR) {
                                if (cosmetic.hasSpin()) {
                                    cosmetic.onActivate(p.getLocation().clone().add(0.0D, 2.25D, 0.0D).add(CosmeticsHandler.this.circle.get(CosmeticsHandler.this.headCycle)));
                                    continue;
                                }
                                cosmetic.onActivate(p.getLocation().clone().add(0.0D, 2.25D, 0.0D));
                            }
                        }
                    if (cosmetic.getCategory() == Category.ARROW)
                        for (Projectile projectile : CosmeticsHandler.this.projectiles) {
                            if (projectile.getTicksLived() > 6000) {
                                CosmeticsHandler.this.projectiles.remove(projectile);
                                continue;
                            }
                            Player p = (Player) projectile.getShooter();
                            if (cosmetic.getMembers().contains(p.getUniqueId()) && p.getGameMode() != GameMode.SPECTATOR) {
                                if (cosmetic.hasSpin()) {
                                    cosmetic.onActivate(projectile.getLocation().add(CosmeticsHandler.this.circle.get(CosmeticsHandler.this.headCycle)));
                                    continue;
                                }
                                cosmetic.onActivate(projectile.getLocation());
                            }
                        }
                }
            }
        }, 0L, 1L);
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {
        this.projectiles.remove(e.getEntity());
    }


    @EventHandler
    public void onProjectileShoot(ProjectileLaunchEvent e) {
        if (e.getEntity() instanceof org.bukkit.entity.Firework)
            return;
        if (e.getEntity().getShooter() instanceof Player p) {
            this.projectiles.add(e.getEntity());
        }
    }

    @EventHandler
    public void onEntityDamageEntity(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Projectile projectile) {
            if (projectile.getShooter() instanceof Player p) {
                LivingEntity entity = (LivingEntity) e.getEntity();
                if (entity.getHealth() - e.getDamage() < 0.0D) {
                    for (Cosmetic cosmetic : this.cosmetics) {
                        if (cosmetic.getCategory() == Category.KILL &&
                                cosmetic.hasMember(p)) {
                            if (cosmetic.hasSpin()) {
                                cosmetic.onActivate(e.getEntity().getLocation().clone().add(this.circle.get(this.headCycle)));
                                continue;
                            }
                            cosmetic.onActivate(e.getEntity().getLocation().clone());
                        }
                    }
                } else {

                    for (Cosmetic cosmetic : this.cosmetics) {
                        if (cosmetic.getCategory() == Category.DAMAGE &&
                                cosmetic.hasMember(p)) {
                            if (cosmetic.hasSpin()) {
                                cosmetic.onActivate(e.getEntity().getLocation().clone().add(this.circle.get(this.headCycle)));
                                continue;
                            }
                            cosmetic.onActivate(e.getEntity().getLocation().clone());
                        }
                    }
                }
            }
        }

        if (e.getDamager() instanceof Player p && e.getEntity() instanceof LivingEntity entity) {
            if (entity.getHealth() - e.getDamage() < 0.0D) {
                for (Cosmetic cosmetic : this.cosmetics) {
                    if (cosmetic.getCategory() == Category.KILL &&
                            cosmetic.hasMember(p)) {
                        if (cosmetic.hasSpin()) {
                            cosmetic.onActivate(e.getEntity().getLocation().clone().add(this.circle.get(this.headCycle)));
                            continue;
                        }
                        cosmetic.onActivate(e.getEntity().getLocation().clone());
                    }
                }
            } else {

                for (Cosmetic cosmetic : this.cosmetics) {
                    if (cosmetic.getCategory() == Category.DAMAGE &&
                            cosmetic.hasMember(p)) {
                        if (cosmetic.hasSpin()) {
                            cosmetic.onActivate(e.getEntity().getLocation().clone().add(this.circle.get(this.headCycle)));
                            continue;
                        }
                        cosmetic.onActivate(e.getEntity().getLocation().clone());
                    }
                }
            }
        }
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        loadCosmetics(e.getPlayer());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        saveCosmetics(e.getPlayer());
    }

    public Cosmetic getCosmeticByName(String name) {
        for (Cosmetic cosmetic : this.cosmetics) {
            if (cosmetic.getName().equals(name)) {
                return cosmetic;
            }
        }
        return null;
    }

    public void loadCosmetics(Player p) {
        if (this.cosmeticsConfig.contains("" + p.getUniqueId() + ".unlocked")) {
            for (String name : this.cosmeticsConfig.getStringList("" + p.getUniqueId() + ".unlocked")) {
                Cosmetic cosmetic = getCosmeticByName(name);
                if (cosmetic != null &&
                        !cosmetic.hasUnlocked(p)) {
                    cosmetic.addUnlocked(p);
                }
            }
        }
        if (this.cosmeticsConfig.contains("" + p.getUniqueId() + ".enabled")) {
            for (String name : this.cosmeticsConfig.getStringList("" + p.getUniqueId() + ".enabled")) {
                Cosmetic cosmetic = getCosmeticByName(name);
                if (cosmetic != null &&
                        !cosmetic.hasMember(p)) {
                    cosmetic.addMember(p);
                }
            }
        }


        if (p.getName().equalsIgnoreCase("LegendFoxGaming")) {
            getCosmeticByName("Firefox").addUnlocked(p);
        }
        if (p.getName().equalsIgnoreCase("AlwaysHAK")) {
            getCosmeticByName("FireHAK").addUnlocked(p);
        }
        if (p.getName().equalsIgnoreCase("Oazzies"))
            getCosmeticByName("Starazzies").addUnlocked(p);
    }

    public void saveCosmetics(Player p) {
        List<String> enabled = new ArrayList<>();
        List<String> unlocked = new ArrayList<>();
        for (Cosmetic cosmetic : this.cosmetics) {
            if (cosmetic.hasUnlocked(p))
                unlocked.add(cosmetic.getName());
            if (cosmetic.hasMember(p))
                enabled.add(cosmetic.getName());
        }
        this.cosmeticsConfig.set("" + p.getUniqueId() + ".enabled", enabled);
        this.cosmeticsConfig.set("" + p.getUniqueId() + ".unlocked", unlocked);
        this.configHandler.saveCosmeticsConfig();
    }

    public List<Cosmetic> getLockedCosmetics(Player p) {
        List<Cosmetic> locked = new ArrayList<>();
        for (Cosmetic cosmetic : this.cosmetics) {
            if (!cosmetic.hasUnlocked(p))
                locked.add(cosmetic);
        }
        return locked;
    }

    public List<Cosmetic> getLockedCosmetics(Player p, Rarity rarity) {
        List<Cosmetic> locked = new ArrayList<>();
        for (Cosmetic cosmetic : this.cosmetics) {
            if (!cosmetic.hasUnlocked(p) && cosmetic.getRarity() == rarity)
                locked.add(cosmetic);
        }
        return locked;
    }
}


