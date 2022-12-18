package net.alwayshak.events;

import net.alwayshak.config.ConfigHandler;
import net.alwayshak.util.Materials;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;

public class PlayerHandler
        implements Listener {
    private static final ConfigHandler configHandler = ConfigHandler.getInstance();
    private static final FileConfiguration config = ConfigHandler.getInstance().getPlayer();

    public static HashMap<Player, Integer> tokens = new HashMap<>();

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        Location loc = p.getLocation();
        p.sendMessage(c("&cYou died at &f" + loc.getBlockX() + " " + loc.getBlockY() + " " + loc.getBlockZ()));
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (e.getPlayer().getGameMode() == GameMode.SURVIVAL) {
            if (Materials.getTokensForMaterial(e.getBlock().getType()) == 0)
                return;
            tokens.put(e.getPlayer(), Integer.valueOf(tokens.get(e.getPlayer()).intValue() + Materials.getTokensForMaterial(e.getBlock().getType())));
            sendHotbar(e.getPlayer(), "&a+" + Materials.getTokensForMaterial(e.getBlock().getType()) + " &f(" + tokens.get(e.getPlayer()) + ")");
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Firework fw) {
            if (fw.hasMetadata("nodamage")) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if (e.getBlock().getType() == Material.BARRIER && e.getPlayer().getGameMode() == GameMode.SURVIVAL)
            e.setCancelled(true);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        tokens.put(e.getPlayer(), Integer.valueOf(config.getInt("" + e.getPlayer().getUniqueId() + ".tokens")));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        config.set("" + e.getPlayer().getUniqueId() + ".tokens", tokens.get(e.getPlayer()));
        configHandler.savePlayerConfig();
    }

    public static void saveTokens(Player p) {
        config.set("" + p.getUniqueId() + ".tokens", tokens.get(p));
        configHandler.savePlayerConfig();
    }

    public static void loadTokens(Player p) {
        tokens.put(p, Integer.valueOf(config.getInt("" + p.getUniqueId() + ".tokens")));
    }

    private String c(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public void sendHotbar(Player p, String msg) {
        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes('&', msg)));
    }
}


