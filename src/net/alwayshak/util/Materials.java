package net.alwayshak.util;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Materials {
    public static boolean isAxe(ItemStack stack) {
        Material t = stack.getType();
        if (t == Material.WOODEN_AXE) return true;
        if (t == Material.STONE_AXE) return true;
        if (t == Material.IRON_AXE) return true;
        if (t == Material.GOLDEN_AXE) return true;
        if (t == Material.DIAMOND_AXE) return true;
        return t == Material.NETHERITE_AXE;
    }

    public static boolean isPickaxe(ItemStack stack) {
        Material t = stack.getType();
        if (t == Material.WOODEN_PICKAXE) return true;
        if (t == Material.STONE_PICKAXE) return true;
        if (t == Material.IRON_PICKAXE) return true;
        if (t == Material.GOLDEN_PICKAXE) return true;
        if (t == Material.DIAMOND_PICKAXE) return true;
        return t == Material.NETHERITE_PICKAXE;
    }

    public static boolean isOre(ItemStack stack) {
        Material t = stack.getType();
        if (t == Material.COAL_ORE) return true;
        if (t == Material.DEEPSLATE_COAL_ORE) return true;
        if (t == Material.IRON_ORE) return true;
        if (t == Material.DEEPSLATE_IRON_ORE) return true;
        if (t == Material.GOLD_ORE) return true;
        if (t == Material.DEEPSLATE_GOLD_ORE) return true;
        if (t == Material.NETHER_GOLD_ORE) return true;
        if (t == Material.LAPIS_ORE) return true;
        if (t == Material.DEEPSLATE_LAPIS_ORE) return true;
        if (t == Material.DIAMOND_ORE) return true;
        if (t == Material.DEEPSLATE_DIAMOND_ORE) return true;
        if (t == Material.EMERALD_ORE) return true;
        if (t == Material.DEEPSLATE_EMERALD_ORE) return true;
        if (t == Material.COPPER_ORE) return true;
        if (t == Material.DEEPSLATE_COPPER_ORE) return true;
        if (t == Material.REDSTONE_ORE) return true;
        if (t == Material.DEEPSLATE_REDSTONE_ORE) return true;
        return t == Material.ANCIENT_DEBRIS;
    }

    public static boolean isLog(ItemStack stack) {
        Material t = stack.getType();
        if (t == Material.ACACIA_LOG) return true;
        if (t == Material.BIRCH_LOG) return true;
        if (t == Material.JUNGLE_LOG) return true;
        if (t == Material.DARK_OAK_LOG) return true;
        if (t == Material.OAK_LOG) return true;
        if (t == Material.SPRUCE_LOG) return true;
        if (t == Material.CRIMSON_STEM) return true;
        return t == Material.WARPED_STEM;
    }

    public static boolean isOre(Material t) {
        if (t == Material.COAL_ORE) return true;
        if (t == Material.DEEPSLATE_COAL_ORE) return true;
        if (t == Material.IRON_ORE) return true;
        if (t == Material.DEEPSLATE_IRON_ORE) return true;
        if (t == Material.GOLD_ORE) return true;
        if (t == Material.DEEPSLATE_GOLD_ORE) return true;
        if (t == Material.NETHER_GOLD_ORE) return true;
        if (t == Material.LAPIS_ORE) return true;
        if (t == Material.DEEPSLATE_LAPIS_ORE) return true;
        if (t == Material.DIAMOND_ORE) return true;
        if (t == Material.DEEPSLATE_DIAMOND_ORE) return true;
        if (t == Material.EMERALD_ORE) return true;
        if (t == Material.DEEPSLATE_EMERALD_ORE) return true;
        if (t == Material.COPPER_ORE) return true;
        if (t == Material.DEEPSLATE_COPPER_ORE) return true;
        if (t == Material.REDSTONE_ORE) return true;
        if (t == Material.DEEPSLATE_REDSTONE_ORE) return true;
        if (t == Material.ANCIENT_DEBRIS) return true;
        return t == Material.NETHER_QUARTZ_ORE;
    }

    public static boolean isLog(Material t) {
        if (t == Material.ACACIA_LOG) return true;
        if (t == Material.BIRCH_LOG) return true;
        if (t == Material.JUNGLE_LOG) return true;
        if (t == Material.DARK_OAK_LOG) return true;
        if (t == Material.OAK_LOG) return true;
        if (t == Material.SPRUCE_LOG) return true;
        if (t == Material.CRIMSON_STEM) return true;
        return t == Material.WARPED_STEM;
    }

    public static boolean isOre(Block stack) {
        Material t = stack.getType();
        if (t == Material.COAL_ORE) return true;
        if (t == Material.DEEPSLATE_COAL_ORE) return true;
        if (t == Material.IRON_ORE) return true;
        if (t == Material.DEEPSLATE_IRON_ORE) return true;
        if (t == Material.GOLD_ORE) return true;
        if (t == Material.DEEPSLATE_GOLD_ORE) return true;
        if (t == Material.NETHER_GOLD_ORE) return true;
        if (t == Material.LAPIS_ORE) return true;
        if (t == Material.DEEPSLATE_LAPIS_ORE) return true;
        if (t == Material.DIAMOND_ORE) return true;
        if (t == Material.DEEPSLATE_DIAMOND_ORE) return true;
        if (t == Material.EMERALD_ORE) return true;
        if (t == Material.DEEPSLATE_EMERALD_ORE) return true;
        if (t == Material.COPPER_ORE) return true;
        if (t == Material.DEEPSLATE_COPPER_ORE) return true;
        if (t == Material.REDSTONE_ORE) return true;
        if (t == Material.DEEPSLATE_REDSTONE_ORE) return true;
        if (t == Material.ANCIENT_DEBRIS) return true;
        return t == Material.NETHER_QUARTZ_ORE;
    }

    public static boolean isLog(Block stack) {
        Material t = stack.getType();
        if (t == Material.ACACIA_LOG) return true;
        if (t == Material.BIRCH_LOG) return true;
        if (t == Material.JUNGLE_LOG) return true;
        if (t == Material.DARK_OAK_LOG) return true;
        if (t == Material.OAK_LOG) return true;
        if (t == Material.SPRUCE_LOG) return true;
        if (t == Material.CRIMSON_STEM) return true;
        return t == Material.WARPED_STEM;
    }

    public static boolean damageItem(ItemStack i) {
        if (i == null) return false;
        if (i.getItemMeta() instanceof Damageable meta) {
            int chance = 100 / (meta.getEnchantLevel(Enchantment.DURABILITY) + 1);
            int random = (new Random()).nextInt(101);
            if (random < chance) {
                meta.setDamage(meta.getDamage() + 1);
                if (i.getType().getMaxDurability() - meta.getDamage() < 0) {
                    i.setAmount(0);
                    return false;
                }
            }
            i.setItemMeta(meta);
            return true;
        }
        return false;
    }

    public static int giveExpForOre(Block b) {
        Random r = new Random();
        int xp = 0;
        Material t = b.getType();
        if (t == Material.COAL_ORE || t == Material.DEEPSLATE_COAL_ORE) {
            xp = r.nextInt(3);
        } else if (t == Material.NETHER_GOLD_ORE) {
            xp = r.nextInt(2);
        } else if (t == Material.DIAMOND_ORE || t == Material.EMERALD_ORE || t == Material.DEEPSLATE_DIAMOND_ORE || t == Material.DEEPSLATE_EMERALD_ORE) {
            xp = r.nextInt(5) + 3;
        } else if (t == Material.LAPIS_ORE || t == Material.NETHER_QUARTZ_ORE || t == Material.DEEPSLATE_LAPIS_ORE) {
            xp = r.nextInt(4) + 2;
        } else if (t == Material.REDSTONE_ORE || t == Material.DEEPSLATE_REDSTONE_ORE) {
            xp = r.nextInt(5) + 1;
        }
        return xp;
    }

    public static int getTokensForMaterial(Material mat) {
        if (mat == Material.STONE)
            return 1;
        if (mat == Material.NETHERRACK)
            return 1;
        if (mat == Material.DEEPSLATE)
            return 2;
        if (mat == Material.TERRACOTTA)
            return 1;
        if (mat == Material.END_STONE)
            return 3;
        if (mat == Material.GRANITE)
            return 1;
        if (mat == Material.DIORITE)
            return 1;
        if (mat == Material.ANDESITE)
            return 1;
        if (mat == Material.OBSIDIAN)
            return 35;
        if (isLog(mat))
            return 2;
        if (mat == Material.COAL_ORE || mat == Material.DEEPSLATE_COAL_ORE)
            return 15;
        if (mat == Material.IRON_ORE || mat == Material.DEEPSLATE_IRON_ORE)
            return 15;
        if (mat == Material.GOLD_ORE || mat == Material.DEEPSLATE_GOLD_ORE)
            return 30;
        if (mat == Material.COPPER_ORE || mat == Material.DEEPSLATE_COPPER_ORE)
            return 15;
        if (mat == Material.LAPIS_ORE || mat == Material.DEEPSLATE_LAPIS_ORE)
            return 50;
        if (mat == Material.DIAMOND_ORE || mat == Material.DEEPSLATE_DIAMOND_ORE)
            return 70;
        if (mat == Material.EMERALD_ORE || mat == Material.DEEPSLATE_EMERALD_ORE)
            return 90;
        if (mat == Material.ANCIENT_DEBRIS)
            return 300;
        if (mat == Material.NETHER_QUARTZ_ORE)
            return 20;
        if (mat == Material.NETHER_GOLD_ORE)
            return 20;
        if (mat == Material.SPAWNER)
            return 10000;
        if (mat == Material.BEDROCK) {
            return 69420;
        }
        return 0;
    }

    public static ItemStack getSimpleItem(String name, List<String> lore, Material material) {
        ItemStack stack = new ItemStack(material);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        List<String> coloredLore = new ArrayList<>();
        for (String str : lore) {
            coloredLore.add(ChatColor.translateAlternateColorCodes('&', str));
        }
        meta.setLore(coloredLore);
        stack.setItemMeta(meta);
        return stack;
    }

    public static ItemStack getSimpleItem(String name, Material material, String... lore) {
        ItemStack stack = new ItemStack(material);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        List<String> coloredLore = new ArrayList<>();
        for (String str : lore) {
            coloredLore.add(ChatColor.translateAlternateColorCodes('&', str));
        }
        meta.setLore(coloredLore);
        stack.setItemMeta(meta);
        return stack;
    }

    public static ItemStack getSimpleItem(String name, Material material) {
        ItemStack stack = new ItemStack(material);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        stack.setItemMeta(meta);
        return stack;
    }
}


