package net.alwayshak.enchantments;

import net.alwayshak.Core;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnchantHandler {


    public void register(CustomEnchant enchant) {
        registerEnchantment(enchant);
        Bukkit.getPluginManager().registerEvents(enchant, Core.getPlugin(Core.class));
    }

    private void registerEnchantment(Enchantment enchantment) {
        if (!((List) Arrays.<Enchantment>stream(Enchantment.values()).collect(Collectors.toList())).contains(enchantment))
            try {
                Field f = Enchantment.class.getDeclaredField("acceptingNew");
                f.setAccessible(true);
                f.set(null, Boolean.valueOf(true));
                Enchantment.registerEnchantment(enchantment);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}


