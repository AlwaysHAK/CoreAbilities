package net.alwayshak.lootcrate;

import net.alwayshak.events.PlayerHandler;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
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
            if(args.length == 3) {
                if(!isInt(args[1])) {
                    s.sendMessage(c("&cInvalid."));
                    return true;
                }
                if(args[0].equalsIgnoreCase("add")) {
                    int tokens = Integer.parseInt(args[1]);
                    Player tp = null;
                    for(Player p : Bukkit.getOnlinePlayers()) {
                        if(p.getName().equalsIgnoreCase(args[2])) {
                            tp = p;
                            break;
                        }
                    }
                    if(tp != null) {
                        PlayerHandler.tokens.put(tp, PlayerHandler.tokens.get(tp) + tokens);
                    } else {
                        s.sendMessage(c("&cInvalid."));
                        return true;
                    }
                }
                if(args[0].equalsIgnoreCase("remove")) {
                    int tokens = Integer.parseInt(args[1]);
                    Player tp = null;
                    for(Player p : Bukkit.getOnlinePlayers()) {
                        if(p.getName().equalsIgnoreCase(args[2])) {
                            tp = p;
                            break;
                        }
                    }
                    if(tp != null) {
                        PlayerHandler.tokens.put(tp, PlayerHandler.tokens.get(tp) - tokens);
                    } else {
                        s.sendMessage(c("&cInvalid."));
                        return true;
                    }
                }
                if(args[0].equalsIgnoreCase("set")) {
                    int tokens = Integer.parseInt(args[1]);
                    Player tp = null;
                    for(Player p : Bukkit.getOnlinePlayers()) {
                        if(p.getName().equalsIgnoreCase(args[2])) {
                            tp = p;
                            break;
                        }
                    }
                    if(tp != null) {
                        PlayerHandler.tokens.put(tp, tokens);
                    } else {
                        s.sendMessage(c("&cInvalid."));
                        return true;
                    }
                }
            }
            if(args.length == 0) {
                sendHotbar((Player) s, "&aYou have &f" + PlayerHandler.tokens.get(s) + " &atokens.");
            }
        }
        return true;
    }

    public List<String> onTabComplete(CommandSender s, Command cmd, String arg, String[] args) {
        List<String> array = new ArrayList<>();
        if(s.hasPermission("coreabilities.cheat")) {
            if(args.length == 1) {
                array.add("add");
                array.add("set");
                array.add("remove");
            }
            if(args.length == 2) {
                array.add("<tokens>");
            }
            if(args.length == 3) {
                for(Player p : Bukkit.getOnlinePlayers()) {
                    array.add(p.getName());
                }
            }
        }
        return array;
    }

    private boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void sendHotbar(Player p, String msg) {
        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes('&', msg)));
    }

    public String c(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}


