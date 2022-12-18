package net.alwayshak.lootcrate;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;


public class LootcrateCMD
        implements TabExecutor {
    public boolean onCommand(CommandSender s, Command cmd, String arg, String[] args) {
        if (s instanceof Player) {
            Lootcrate.openChoose((Player) s);
        }
        return true;
    }

    public List<String> onTabComplete(CommandSender s, Command cmd, String arg, String[] argss) {
        return new ArrayList<>();
    }
}


