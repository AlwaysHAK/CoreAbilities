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

public class ResetCosmeticsCMD
        implements TabExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player p) {
            for (Cosmetic cosmetic : CosmeticsHandler.instance.getUnlockedCosmetics(p)) {
                cosmetic.removeMember(p);
                cosmetic.removeUnlocked(p);
                p.sendMessage("" + ChatColor.GRAY + "You just lost " + ChatColor.GRAY + ChatColor.RED);
            }

            p.sendMessage("");
            p.sendMessage("" + ChatColor.RED + "You just reset all of your cosmetics..");
        }
        return true;
    }

    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return new ArrayList<>();
    }
}


