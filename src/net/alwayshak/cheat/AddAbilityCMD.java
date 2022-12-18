package net.alwayshak.cheat;

import net.alwayshak.abilities.AbilityHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AddAbilityCMD implements TabExecutor {

    public AbilityHandler handler;

    public AddAbilityCMD() {
        handler = AbilityHandler.getHandler();
    }

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String arg, String[] args) {


        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender s, Command cmd, String arg, String[] args) {
        List<String> abilities = new ArrayList<>();
        if(args.length == 1) {

        }
        return abilities;
    }
}
