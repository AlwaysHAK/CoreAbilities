package net.alwayshak.cheat;

import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.CosmeticsHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CheatMenuCMD implements TabExecutor {

    private final CheatGUI cheatGUI;

    public CheatMenuCMD(CheatGUI gui) {
        this.cheatGUI = gui;
    }

    public boolean onCommand(CommandSender s, Command cmd, String arg, String[] args) {
        if (s instanceof Player p) {
            if (args.length == 0) {
                Player player = (Player) s;
                for (Cosmetic cosmetic : CosmeticsHandler.instance.getLockedCosmetics(player))
                    cosmetic.addUnlocked(player);
                player.sendMessage("" + ChatColor.GRAY + "Unlocked all cosmetics.");
                return true;
            }
            CheatGUI.openAllCosmetics(p, Integer.parseInt(args[0]));
        }
        return true;
    }

    public List<String> onTabComplete(CommandSender s, Command cmd, String arg, String[] args) {
        List<String> tab = new ArrayList<>();
        return tab;
    }
}

            /*
            if (args.length == 0) {
                Player player = (Player) s;
                for (Cosmetic cosmetic : CosmeticsHandler.instance.getLockedCosmetics(player))
                    cosmetic.addUnlocked(player);
                player.sendMessage("" + ChatColor.GRAY + "Unlocked all cosmetics.");
                return true;
            }
            CheatGUI.openAllCosmetics(p, Integer.parseInt(args[0]));
            */


