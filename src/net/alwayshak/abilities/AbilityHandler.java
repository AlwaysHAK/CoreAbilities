package net.alwayshak.abilities;

import net.alwayshak.Core;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

public class AbilityHandler implements Listener {
    private final Core core;
    private final List<Ability> abilities = new ArrayList<>();

    private static AbilityHandler handler;

    public AbilityHandler(Core core) {
        this.core = core;
        handler = this;
    }

    public void registerAbility(Ability ability) {
        this.abilities.add(ability);
        Bukkit.getPluginManager().registerEvents(ability, this.core);
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public static AbilityHandler getHandler() {
        return handler;
    }
}
