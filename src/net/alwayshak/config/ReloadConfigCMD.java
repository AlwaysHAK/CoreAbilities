package net.alwayshak.config;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.ArrayList;
import java.util.List;


public class ReloadConfigCMD
        implements TabExecutor {
    public boolean onCommand(CommandSender s, Command cmd, String arg, String[] args) {
        ConfigHandler.getInstance().loadNotesConfig();
        ConfigHandler.getInstance().loadNotesConfig();
        ConfigHandler.getInstance().loadPlayerConfig();
        s.sendMessage("" + ChatColor.GREEN + "Reloaded config.");
        return true;
    }

    public List<String> onTabComplete(CommandSender s, Command cmd, String arg, String[] argss) {
        return new ArrayList<>();
    }
}


