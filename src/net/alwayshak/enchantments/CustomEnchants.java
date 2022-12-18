package net.alwayshak.enchantments;

import net.alwayshak.Core;
import net.alwayshak.enchantments.events.*;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomEnchants {
    public static final Enchantment EXPLOSIVETIP = new EnchantmentWrapper("explosivetip", "Explosive Tip", 1) {
        public EnchantmentTarget getItemTarget() {
            return EnchantmentTarget.BOW;
        }
    };
    public static final Enchantment CUTCLEAN = new EnchantmentWrapper("cutclean", "Cut Clean", 1) {
        public EnchantmentTarget getItemTarget() {
            return EnchantmentTarget.TOOL;
        }
    };
    public static final Enchantment POSIONPROTRECTION = new EnchantmentWrapper("posionprotection", "Posion Protection", 1) {
        public EnchantmentTarget getItemTarget() {
            return EnchantmentTarget.ARMOR;
        }


        public boolean conflictsWith(Enchantment enchantment) {
            return enchantment == Enchantment.PROTECTION_ENVIRONMENTAL || enchantment == Enchantment.PROTECTION_EXPLOSIONS || enchantment == Enchantment.PROTECTION_FIRE || enchantment == Enchantment.PROTECTION_PROJECTILE;
        }
    };
    public static final Enchantment OBLITERATE = new EnchantmentWrapper("obliterate", "Obliterate", 1) {
        public EnchantmentTarget getItemTarget() {
            return EnchantmentTarget.TOOL;
        }
    };
    public static final Enchantment XPFEEDER = new EnchantmentWrapper("xpfeeder", "XP Feeder", 1) {
        public EnchantmentTarget getItemTarget() {
            return EnchantmentTarget.ARMOR_HEAD;
        }
    };

    public static void register(Core core) {
        registerEnchantment(EXPLOSIVETIP);
        registerEnchantment(CUTCLEAN);
        registerEnchantment(POSIONPROTRECTION);
        registerEnchantment(OBLITERATE);
        registerEnchantment(XPFEEDER);

        Bukkit.getPluginManager().registerEvents((Listener) new AnvilHandler(), core);

        Bukkit.getPluginManager().registerEvents((Listener) new ExplosiveTipEvent(), core);
        Bukkit.getPluginManager().registerEvents(new CutCleanEvent(), core);
        Bukkit.getPluginManager().registerEvents(new PosionProtectionEvent(), core);
        Bukkit.getPluginManager().registerEvents(new ObliterateEvent(), core);
        Bukkit.getPluginManager().registerEvents(new LevelHungerUpEvent(), core);
    }

    public static void registerEnchantment(Enchantment enchantment) {
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


