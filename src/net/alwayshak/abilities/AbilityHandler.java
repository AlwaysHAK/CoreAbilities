package net.alwayshak.abilities;

import net.alwayshak.Core;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

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

    @EventHandler
    public void onKill(EntityDeathEvent e) {
        if (e.getEntity().getType() == EntityType.SHULKER)
            e.getEntity().getLocation().getWorld().dropItemNaturally(e.getEntity().getLocation(), new ItemStack(Material.SHULKER_SHELL, 1));
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public static AbilityHandler getHandler() {
        return handler;
    }
}
