package net.alwayshak.cosmetics.gui;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CosmeticsCMD
        implements TabExecutor {
    private final CosmeticsGUI cosmeticsGUI;

    public CosmeticsCMD(CosmeticsGUI gui) {
        this.cosmeticsGUI = gui;
    }

    public boolean onCommand(CommandSender s, Command cmd, String arg, String[] args) {
        if (s instanceof Player p) {
            this.cosmeticsGUI.open(p);
        }
        return true;
    }

    public List<String> onTabComplete(CommandSender s, Command cmd, String arg, String[] args) {
        return new ArrayList<>();
    }
}


