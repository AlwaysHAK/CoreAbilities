package net.alwayshak.lootcrate;

import net.alwayshak.events.PlayerHandler;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TokenCMD
        implements TabExecutor {
    public boolean onCommand(CommandSender s, Command cmd, String arg, String[] args) {
        if (s instanceof Player) {
            sendHotbar((Player) s, "&aYou have &f" + PlayerHandler.tokens.get(s) + " &atokens.");
        }
        return true;
    }

    public List<String> onTabComplete(CommandSender s, Command cmd, String arg, String[] argss) {
        return new ArrayList<>();
    }

    public void sendHotbar(Player p, String msg) {
        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes('&', msg)));
    }
}


