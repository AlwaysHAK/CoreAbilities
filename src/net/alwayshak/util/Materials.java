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

    public static boolean isShovel(ItemStack stack) {
        Material t = stack.getType();
        if (t == Material.WOODEN_SHOVEL) return true;
        if (t == Material.STONE_SHOVEL) return true;
        if (t == Material.IRON_SHOVEL) return true;
        if (t == Material.GOLDEN_SHOVEL) return true;
        if (t == Material.DIAMOND_SHOVEL) return true;
        return t == Material.NETHERITE_SHOVEL;
    }

    public static boolean isHoe(ItemStack stack) {
        Material t = stack.getType();
        if (t == Material.WOODEN_HOE) return true;
        if (t == Material.STONE_HOE) return true;
        if (t == Material.IRON_HOE) return true;
        if (t == Material.GOLDEN_HOE) return true;
        if (t == Material.DIAMOND_HOE) return true;
        return t == Material.NETHERITE_HOE;
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

    public static boolean isCrop(Block crop) {
        if(crop == null)
            return false;
        Material mat = crop.getType();
        if(mat == Material.WHEAT_SEEDS) return true;
        if(mat == Material.WHEAT) return true;
        if(mat == Material.BEETROOT_SEEDS) return true;
        if(mat == Material.BEETROOT) return true;
        if(mat == Material.CARROT) return true;
        if(mat == Material.POTATO) return true;
        if(mat == Material.MELON) return true;
        if(mat == Material.MELON_SEEDS) return true;
        if(mat == Material.MELON_STEM) return true;
        if(mat == Material.PUMPKIN) return true;
        if(mat == Material.WHEAT) return true;
        if(mat == Material.WHEAT) return true;
        if(mat == Material.WHEAT) return true;
        if(mat == Material.WHEAT) return true;
        if(mat == Material.WHEAT) return true;
        if(mat == Material.WHEAT) return true;
        if(mat == Material.WHEAT) return true;
        if(mat == Material.WHEAT) return true;
        if(mat == Material.WHEAT) return true;
        if(mat == Material.WHEAT) return true;
        if(mat == Material.WHEAT) return true;
        if(mat == Material.WHEAT) return true;
        if(mat == Material.WHEAT) return true;
        return false;
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

    public static boolean can3x3Mine(Block block, ItemStack hand) {
        if(hand == null)
            return false;
        Material mat = block.getType();
        if(isShovel(hand)) {
            if(mat == Material.GRAVEL) return true;
            if(mat == Material.CLAY) return true;
            if(mat == Material.SNOW_BLOCK) return true;
            if(mat == Material.SAND) return true;
            if(mat == Material.RED_SAND) return true;
            if(mat == Material.SOUL_SAND) return true;
            if(mat == Material.SOUL_SOIL) return true;
            if(mat == Material.GRASS_BLOCK) return true;
            if(mat == Material.MYCELIUM) return true;
            if(mat == Material.PODZOL) return true;
            if(mat == Material.DIRT) return true;
            if(mat == Material.COARSE_DIRT) return true;
            if(mat == Material.DIRT_PATH) return true;
            if(mat == Material.ROOTED_DIRT) return true;
            if(mat == Material.FARMLAND) return true;
            if(mat == Material.MOSS_BLOCK) return true;

            // Concrete
            if(mat == Material.WHITE_CONCRETE_POWDER) return true;
            if(mat == Material.GRAY_CONCRETE_POWDER) return true;
            if(mat == Material.LIGHT_GRAY_CONCRETE_POWDER) return true;
            if(mat == Material.BROWN_CONCRETE_POWDER) return true;
            if(mat == Material.BLACK_CONCRETE_POWDER) return true;
            if(mat == Material.RED_CONCRETE_POWDER) return true;
            if(mat == Material.ORANGE_CONCRETE_POWDER) return true;
            if(mat == Material.YELLOW_CONCRETE_POWDER) return true;
            if(mat == Material.GREEN_CONCRETE_POWDER) return true;
            if(mat == Material.LIME_CONCRETE_POWDER) return true;
            if(mat == Material.BLUE_CONCRETE_POWDER) return true;
            if(mat == Material.CYAN_CONCRETE_POWDER) return true;
            if(mat == Material.LIGHT_BLUE_CONCRETE_POWDER) return true;
            if(mat == Material.PURPLE_CONCRETE_POWDER) return true;
            if(mat == Material.MAGENTA_CONCRETE_POWDER) return true;
            if(mat == Material.PINK_CONCRETE_POWDER) return true;
        }
        if(isPickaxe(hand)) {
            if(isOre(mat)) return true;

            //Basics
            if(mat == Material.STONE) return true;
            if(mat == Material.GRANITE) return true;
            if(mat == Material.POLISHED_GRANITE) return true;
            if(mat == Material.DIORITE) return true;
            if(mat == Material.POLISHED_DIORITE) return true;
            if(mat == Material.ANDESITE) return true;
            if(mat == Material.POLISHED_ANDESITE) return true;
            if(mat == Material.DEEPSLATE) return true;
            if(mat == Material.COBBLED_DEEPSLATE) return true;
            if(mat == Material.POLISHED_DEEPSLATE) return true;
            if(mat == Material.CALCITE) return true;
            if(mat == Material.TUFF) return true;
            if(mat == Material.DRIPSTONE_BLOCK) return true;
            if(mat == Material.COBBLESTONE) return true;
            if(mat == Material.COAL_BLOCK) return true;
            if(mat == Material.RAW_COPPER_BLOCK) return true;
            if(mat == Material.RAW_GOLD_BLOCK) return true;
            if(mat == Material.AMETHYST_BLOCK) return true;
            if(mat == Material.IRON_BLOCK) return true;
            if(mat == Material.COPPER_BLOCK) return true;
            if(mat == Material.GOLD_BLOCK) return true;
            if(mat == Material.DIAMOND_BLOCK) return true;
            if(mat == Material.NETHERITE_BLOCK) return true;

            //Copper Variations
            if(mat == Material.EXPOSED_COPPER) return true;
            if(mat == Material.WEATHERED_COPPER) return true;
            if(mat == Material.OXIDIZED_COPPER) return true;
            if(mat == Material.CUT_COPPER) return true;
            if(mat == Material.EXPOSED_CUT_COPPER) return true;
            if(mat == Material.WEATHERED_CUT_COPPER) return true;
            if(mat == Material.OXIDIZED_CUT_COPPER) return true;
            if(mat == Material.CUT_COPPER_STAIRS) return true;
            if(mat == Material.EXPOSED_CUT_COPPER_STAIRS) return true;
            if(mat == Material.WEATHERED_CUT_COPPER_STAIRS) return true;
            if(mat == Material.OXIDIZED_CUT_COPPER_STAIRS) return true;
            if(mat == Material.CUT_COPPER_SLAB) return true;
            if(mat == Material.EXPOSED_CUT_COPPER_SLAB) return true;
            if(mat == Material.WEATHERED_CUT_COPPER_SLAB) return true;
            if(mat == Material.OXIDIZED_CUT_COPPER_SLAB) return true;
            if(mat == Material.WAXED_COPPER_BLOCK) return true;
            if(mat == Material.WAXED_EXPOSED_COPPER) return true;
            if(mat == Material.WAXED_WEATHERED_COPPER) return true;
            if(mat == Material.WAXED_OXIDIZED_COPPER) return true;
            if(mat == Material.WAXED_CUT_COPPER) return true;
            if(mat == Material.WAXED_EXPOSED_CUT_COPPER) return true;
            if(mat == Material.WAXED_WEATHERED_CUT_COPPER) return true;
            if(mat == Material.WAXED_OXIDIZED_CUT_COPPER) return true;
            if(mat == Material.WAXED_CUT_COPPER_STAIRS) return true;
            if(mat == Material.WAXED_EXPOSED_CUT_COPPER_STAIRS) return true;
            if(mat == Material.WAXED_WEATHERED_CUT_COPPER_STAIRS) return true;
            if(mat == Material.WAXED_OXIDIZED_CUT_COPPER_STAIRS) return true;
            if(mat == Material.WAXED_CUT_COPPER_SLAB) return true;
            if(mat == Material.WAXED_EXPOSED_CUT_COPPER_SLAB) return true;
            if(mat == Material.WAXED_WEATHERED_CUT_COPPER_SLAB) return true;
            if(mat == Material.WAXED_OXIDIZED_CUT_COPPER_SLAB) return true;

            //Mis
            if(mat == Material.SANDSTONE) return true;
            if(mat == Material.CHISELED_SANDSTONE) return true;
            if(mat == Material.CUT_SANDSTONE) return true;
            if(mat == Material.STONE_SLAB) return true;
            if(mat == Material.SMOOTH_STONE_SLAB) return true;
            if(mat == Material.SANDSTONE_SLAB) return true;
            if(mat == Material.CUT_SANDSTONE_SLAB) return true;
            if(mat == Material.COBBLESTONE_SLAB) return true;
            if(mat == Material.BRICK_SLAB) return true;
            if(mat == Material.STONE_BRICK_SLAB) return true;
            if(mat == Material.MUD_BRICK_SLAB) return true;
            if(mat == Material.NETHER_BRICK_SLAB) return true;
            if(mat == Material.QUARTZ_SLAB) return true;
            if(mat == Material.RED_SANDSTONE_SLAB) return true;
            if(mat == Material.CUT_RED_SANDSTONE_SLAB) return true;
            if(mat == Material.PURPUR_SLAB) return true;
            if(mat == Material.PRISMARINE_SLAB) return true;
            if(mat == Material.PRISMARINE_BRICK_SLAB) return true;
            if(mat == Material.SMOOTH_QUARTZ) return true;
            if(mat == Material.SMOOTH_RED_SANDSTONE) return true;
            if(mat == Material.SMOOTH_SANDSTONE) return true;
            if(mat == Material.SMOOTH_STONE) return true;
            if(mat == Material.BRICKS) return true;
            if(mat == Material.MOSSY_COBBLESTONE) return true;
            if(mat == Material.OBSIDIAN) return true;


            if(mat == Material.PURPUR_BLOCK) return true;
            if(mat == Material.PURPUR_PILLAR) return true;
            if(mat == Material.PURPUR_STAIRS) return true;

            //Mis
            if(mat == Material.FURNACE) return true;
            if(mat == Material.COBBLESTONE_STAIRS) return true;

            //Nether
            if(mat == Material.NETHERRACK) return true;
            if(mat == Material.BASALT) return true;
            if(mat == Material.POLISHED_BASALT) return true;
            if(mat == Material.SMOOTH_BASALT) return true;
            if(mat == Material.GLOWSTONE) return true;

            //Infested Blocks
            if(mat == Material.INFESTED_STONE) return true;
            if(mat == Material.INFESTED_COBBLESTONE) return true;
            if(mat == Material.INFESTED_STONE_BRICKS) return true;
            if(mat == Material.INFESTED_MOSSY_STONE_BRICKS) return true;
            if(mat == Material.INFESTED_CRACKED_STONE_BRICKS) return true;
            if(mat == Material.INFESTED_CHISELED_STONE_BRICKS) return true;
            if(mat == Material.INFESTED_DEEPSLATE) return true;

            //Bricks
            if(mat == Material.STONE_BRICKS) return true;
            if(mat == Material.MOSSY_STONE_BRICKS) return true;
            if(mat == Material.CRACKED_STONE_BRICKS) return true;
            if(mat == Material.CHISELED_STONE_BRICKS) return true;

            //Mis
            if(mat == Material.PACKED_MUD) return true;
            if(mat == Material.MUD_BRICKS) return true;
            if(mat == Material.DEEPSLATE_BRICKS) return true;
            if(mat == Material.CRACKED_DEEPSLATE_BRICKS) return true;
            if(mat == Material.DEEPSLATE_TILES) return true;
            if(mat == Material.CRACKED_DEEPSLATE_TILES) return true;
            if(mat == Material.CHISELED_DEEPSLATE) return true;
            if(mat == Material.IRON_BARS) return true;
            if(mat == Material.CHAIN) return true;
            if(mat == Material.BRICK_STAIRS) return true;
            if(mat == Material.STONE_BRICK_STAIRS) return true;
            if(mat == Material.MUD_BRICK_STAIRS) return true;
            if(mat == Material.NETHER_BRICKS) return true;
            if(mat == Material.CRACKED_NETHER_BRICKS) return true;
            if(mat == Material.CHISELED_NETHER_BRICKS) return true;
            if(mat == Material.NETHER_BRICK_FENCE) return true;
            if(mat == Material.NETHER_BRICK_STAIRS) return true;
            if(mat == Material.ENCHANTING_TABLE) return true;
            if(mat == Material.END_STONE) return true;
            if(mat == Material.END_STONE_BRICKS) return true;
            if(mat == Material.SANDSTONE_STAIRS) return true;
            if(mat == Material.ENDER_CHEST) return true;
            if(mat == Material.EMERALD_BLOCK) return true;
            if(mat == Material.BEACON) return true;

            //Walls
            if(mat == Material.COBBLESTONE_WALL) return true;
            if(mat == Material.MOSSY_COBBLESTONE_WALL) return true;
            if(mat == Material.BRICK_WALL) return true;
            if(mat == Material.PRISMARINE_WALL) return true;
            if(mat == Material.RED_SANDSTONE_WALL) return true;
            if(mat == Material.MOSSY_STONE_BRICK_WALL) return true;
            if(mat == Material.GRANITE_WALL) return true;
            if(mat == Material.STONE_BRICK_WALL) return true;
            if(mat == Material.MUD_BRICK_WALL) return true;
            if(mat == Material.GRANITE_WALL) return true;
            if(mat == Material.NETHER_BRICK_WALL) return true;
            if(mat == Material.ANDESITE_WALL) return true;
            if(mat == Material.RED_NETHER_BRICK_WALL) return true;
            if(mat == Material.SANDSTONE_WALL) return true;
            if(mat == Material.END_STONE_BRICK_WALL) return true;
            if(mat == Material.DIORITE_WALL) return true;
            if(mat == Material.BLACKSTONE_WALL) return true;
            if(mat == Material.POLISHED_BLACKSTONE_WALL) return true;
            if(mat == Material.POLISHED_BLACKSTONE_BRICK_WALL) return true;
            if(mat == Material.COBBLED_DEEPSLATE_WALL) return true;
            if(mat == Material.POLISHED_DEEPSLATE_WALL) return true;
            if(mat == Material.DEEPSLATE_BRICK_WALL) return true;
            if(mat == Material.DEEPSLATE_TILE_WALL) return true;

            //Anvil
            if(mat == Material.ANVIL) return true;
            if(mat == Material.CHIPPED_ANVIL) return true;
            if(mat == Material.DAMAGED_ANVIL) return true;

            //Quartz
            if(mat == Material.CHISELED_QUARTZ_BLOCK) return true;
            if(mat == Material.QUARTZ_BLOCK) return true;
            if(mat == Material.QUARTZ_BRICKS) return true;
            if(mat == Material.QUARTZ_PILLAR) return true;
            if(mat == Material.QUARTZ_STAIRS) return true;

            // Terracotta
            if(mat == Material.WHITE_TERRACOTTA) return true;
            if(mat == Material.GRAY_TERRACOTTA) return true;
            if(mat == Material.LIGHT_GRAY_TERRACOTTA) return true;
            if(mat == Material.BROWN_TERRACOTTA) return true;
            if(mat == Material.BLACK_TERRACOTTA) return true;
            if(mat == Material.RED_TERRACOTTA) return true;
            if(mat == Material.ORANGE_TERRACOTTA) return true;
            if(mat == Material.YELLOW_TERRACOTTA) return true;
            if(mat == Material.GREEN_TERRACOTTA) return true;
            if(mat == Material.LIME_TERRACOTTA) return true;
            if(mat == Material.BLUE_TERRACOTTA) return true;
            if(mat == Material.CYAN_TERRACOTTA) return true;
            if(mat == Material.LIGHT_BLUE_TERRACOTTA) return true;
            if(mat == Material.PURPLE_TERRACOTTA) return true;
            if(mat == Material.MAGENTA_TERRACOTTA) return true;
            if(mat == Material.PINK_TERRACOTTA) return true;
            if(mat == Material.TERRACOTTA) return true;

            //Ice
            if(mat == Material.ICE) return true;
            if(mat == Material.BLUE_ICE) return true;
            if(mat == Material.FROSTED_ICE) return true;
            if(mat == Material.PACKED_ICE) return true;

            //Mis
            if(mat == Material.RED_SANDSTONE) return true;
            if(mat == Material.CHISELED_RED_SANDSTONE) return true;
            if(mat == Material.CUT_RED_SANDSTONE) return true;
            if(mat == Material.RED_SANDSTONE_STAIRS) return true;
            if(mat == Material.MAGMA_BLOCK) return true;
            if(mat == Material.RED_NETHER_BRICKS) return true;
            if(mat == Material.BONE_BLOCK) return true;

            // Shulker Box
            if(mat == Material.WHITE_SHULKER_BOX) return true;
            if(mat == Material.GRAY_SHULKER_BOX) return true;
            if(mat == Material.LIGHT_GRAY_SHULKER_BOX) return true;
            if(mat == Material.BROWN_SHULKER_BOX) return true;
            if(mat == Material.BLACK_SHULKER_BOX) return true;
            if(mat == Material.RED_SHULKER_BOX) return true;
            if(mat == Material.ORANGE_SHULKER_BOX) return true;
            if(mat == Material.YELLOW_SHULKER_BOX) return true;
            if(mat == Material.GREEN_SHULKER_BOX) return true;
            if(mat == Material.LIME_SHULKER_BOX) return true;
            if(mat == Material.BLUE_SHULKER_BOX) return true;
            if(mat == Material.CYAN_SHULKER_BOX) return true;
            if(mat == Material.LIGHT_BLUE_SHULKER_BOX) return true;
            if(mat == Material.PURPLE_SHULKER_BOX) return true;
            if(mat == Material.MAGENTA_SHULKER_BOX) return true;
            if(mat == Material.PINK_SHULKER_BOX) return true;
            if(mat == Material.SHULKER_BOX) return true;

            //Glazed Terracotta
            if(mat == Material.WHITE_GLAZED_TERRACOTTA) return true;
            if(mat == Material.GRAY_GLAZED_TERRACOTTA) return true;
            if(mat == Material.LIGHT_GRAY_GLAZED_TERRACOTTA) return true;
            if(mat == Material.BROWN_GLAZED_TERRACOTTA) return true;
            if(mat == Material.BLACK_GLAZED_TERRACOTTA) return true;
            if(mat == Material.RED_GLAZED_TERRACOTTA) return true;
            if(mat == Material.ORANGE_GLAZED_TERRACOTTA) return true;
            if(mat == Material.YELLOW_GLAZED_TERRACOTTA) return true;
            if(mat == Material.GREEN_GLAZED_TERRACOTTA) return true;
            if(mat == Material.LIME_GLAZED_TERRACOTTA) return true;
            if(mat == Material.BLUE_GLAZED_TERRACOTTA) return true;
            if(mat == Material.CYAN_GLAZED_TERRACOTTA) return true;
            if(mat == Material.LIGHT_BLUE_GLAZED_TERRACOTTA) return true;
            if(mat == Material.PURPLE_GLAZED_TERRACOTTA) return true;
            if(mat == Material.MAGENTA_GLAZED_TERRACOTTA) return true;
            if(mat == Material.PINK_GLAZED_TERRACOTTA) return true;

            //Underwater
            if(mat == Material.PRISMARINE) return true;
            if(mat == Material.PRISMARINE_BRICKS) return true;
            if(mat == Material.DARK_PRISMARINE) return true;
            if(mat == Material.PRISMARINE_STAIRS) return true;
            if(mat == Material.PRISMARINE_BRICK_STAIRS) return true;
            if(mat == Material.DARK_PRISMARINE_STAIRS) return true;
            if(mat == Material.SEA_LANTERN) return true;
            if(mat == Material.DEAD_TUBE_CORAL_BLOCK) return true;
            if(mat == Material.DEAD_BRAIN_CORAL_BLOCK) return true;
            if(mat == Material.DEAD_BUBBLE_CORAL_BLOCK) return true;
            if(mat == Material.DEAD_FIRE_CORAL_BLOCK) return true;
            if(mat == Material.DEAD_HORN_CORAL_BLOCK) return true;
            if(mat == Material.TUBE_CORAL_BLOCK) return true;
            if(mat == Material.BRAIN_CORAL_BLOCK) return true;
            if(mat == Material.BUBBLE_CORAL_BLOCK) return true;
            if(mat == Material.FIRE_CORAL_BLOCK) return true;
            if(mat == Material.HORN_CORAL_BLOCK) return true;
            if(mat == Material.CONDUIT) return true;

            //Stairs
            if(mat == Material.POLISHED_GRANITE_STAIRS) return true;
            if(mat == Material.SMOOTH_RED_SANDSTONE_STAIRS) return true;
            if(mat == Material.MOSSY_STONE_BRICK_STAIRS) return true;
            if(mat == Material.POLISHED_DIORITE_STAIRS) return true;
            if(mat == Material.MOSSY_COBBLESTONE_STAIRS) return true;
            if(mat == Material.END_STONE_BRICK_STAIRS) return true;
            if(mat == Material.STONE_STAIRS) return true;
            if(mat == Material.SMOOTH_SANDSTONE_STAIRS) return true;
            if(mat == Material.SMOOTH_QUARTZ_STAIRS) return true;
            if(mat == Material.GRANITE_STAIRS) return true;
            if(mat == Material.ANDESITE_STAIRS) return true;
            if(mat == Material.RED_NETHER_BRICK_STAIRS) return true;
            if(mat == Material.POLISHED_ANDESITE_STAIRS) return true;
            if(mat == Material.DIORITE_STAIRS) return true;
            if(mat == Material.COBBLED_DEEPSLATE_STAIRS) return true;
            if(mat == Material.POLISHED_DEEPSLATE_STAIRS) return true;
            if(mat == Material.DEEPSLATE_BRICK_STAIRS) return true;
            if(mat == Material.DEEPSLATE_TILE_STAIRS) return true;

            //Slabs
            if(mat == Material.POLISHED_GRANITE_SLAB) return true;
            if(mat == Material.SMOOTH_RED_SANDSTONE_SLAB) return true;
            if(mat == Material.MOSSY_STONE_BRICK_SLAB) return true;
            if(mat == Material.POLISHED_DIORITE_SLAB) return true;
            if(mat == Material.MOSSY_COBBLESTONE_SLAB) return true;
            if(mat == Material.END_STONE_BRICK_SLAB) return true;
            if(mat == Material.STONE_SLAB) return true;
            if(mat == Material.SMOOTH_SANDSTONE_SLAB) return true;
            if(mat == Material.SMOOTH_QUARTZ_SLAB) return true;
            if(mat == Material.GRANITE_SLAB) return true;
            if(mat == Material.ANDESITE_SLAB) return true;
            if(mat == Material.RED_NETHER_BRICK_SLAB) return true;
            if(mat == Material.POLISHED_ANDESITE_SLAB) return true;
            if(mat == Material.DIORITE_SLAB) return true;
            if(mat == Material.COBBLED_DEEPSLATE_SLAB) return true;
            if(mat == Material.POLISHED_DEEPSLATE_SLAB) return true;
            if(mat == Material.DEEPSLATE_BRICK_SLAB) return true;
            if(mat == Material.DEEPSLATE_TILE_SLAB) return true;

            //Redstone
            if(mat == Material.REDSTONE_BLOCK) return true;
            if(mat == Material.PISTON) return true;
            if(mat == Material.STICKY_PISTON) return true;
            if(mat == Material.OBSERVER) return true;
            if(mat == Material.HOPPER) return true;
            if(mat == Material.DISPENSER) return true;
            if(mat == Material.DROPPER) return true;
            if(mat == Material.DAYLIGHT_DETECTOR) return true;
            if(mat == Material.STONE_PRESSURE_PLATE) return true;
            if(mat == Material.POLISHED_BLACKSTONE_PRESSURE_PLATE) return true;
            if(mat == Material.LIGHT_WEIGHTED_PRESSURE_PLATE) return true;
            if(mat == Material.HEAVY_WEIGHTED_PRESSURE_PLATE) return true;
            if(mat == Material.IRON_DOOR) return true;
            if(mat == Material.IRON_TRAPDOOR) return true;

            //Working Stations
            if(mat == Material.BREWING_STAND) return true;
            if(mat == Material.CAULDRON) return true;
            if(mat == Material.SMOKER) return true;
            if(mat == Material.BLAST_FURNACE) return true;
            if(mat == Material.GRINDSTONE) return true;
            if(mat == Material.SMITHING_TABLE) return true;
            if(mat == Material.STONECUTTER) return true;
            if(mat == Material.BELL) return true;

            if(mat == Material.LANTERN) return true;

            //Nether
            if(mat == Material.SOUL_LANTERN) return true;
            if(mat == Material.LODESTONE) return true;
            if(mat == Material.CRYING_OBSIDIAN) return true;
            if(mat == Material.BLACKSTONE) return true;
            if(mat == Material.BLACKSTONE_SLAB) return true;
            if(mat == Material.BLACKSTONE_STAIRS) return true;
            if(mat == Material.GILDED_BLACKSTONE) return true;
            if(mat == Material.POLISHED_BLACKSTONE) return true;
            if(mat == Material.POLISHED_BLACKSTONE_SLAB) return true;
            if(mat == Material.POLISHED_BLACKSTONE_STAIRS) return true;
            if(mat == Material.CHISELED_POLISHED_BLACKSTONE) return true;
            if(mat == Material.POLISHED_BLACKSTONE_BRICKS) return true;
            if(mat == Material.POLISHED_BLACKSTONE_BRICK_SLAB) return true;
            if(mat == Material.POLISHED_BLACKSTONE_BRICK_STAIRS) return true;
            if(mat == Material.CRACKED_POLISHED_BLACKSTONE_BRICKS) return true;
            if(mat == Material.RESPAWN_ANCHOR) return true;

            //Froglights
            if(mat == Material.OCHRE_FROGLIGHT) return true;
            if(mat == Material.VERDANT_FROGLIGHT) return true;
            if(mat == Material.PEARLESCENT_FROGLIGHT) return true;

            //Candles
            if(mat == Material.WHITE_CANDLE) return true;
            if(mat == Material.GRAY_CANDLE) return true;
            if(mat == Material.LIGHT_GRAY_CANDLE) return true;
            if(mat == Material.BROWN_CANDLE) return true;
            if(mat == Material.BLACK_CANDLE) return true;
            if(mat == Material.RED_CANDLE) return true;
            if(mat == Material.ORANGE_CANDLE) return true;
            if(mat == Material.YELLOW_CANDLE) return true;
            if(mat == Material.GREEN_CANDLE) return true;
            if(mat == Material.LIME_CANDLE) return true;
            if(mat == Material.BLUE_CANDLE) return true;
            if(mat == Material.CYAN_CANDLE) return true;
            if(mat == Material.LIGHT_BLUE_CANDLE) return true;
            if(mat == Material.PURPLE_CANDLE) return true;
            if(mat == Material.MAGENTA_CANDLE) return true;
            if(mat == Material.PINK_CANDLE) return true;

            // Concrete
            if(mat == Material.WHITE_CONCRETE) return true;
            if(mat == Material.GRAY_CONCRETE) return true;
            if(mat == Material.LIGHT_GRAY_CONCRETE) return true;
            if(mat == Material.BROWN_CONCRETE) return true;
            if(mat == Material.BLACK_CONCRETE) return true;
            if(mat == Material.RED_CONCRETE) return true;
            if(mat == Material.ORANGE_CONCRETE) return true;
            if(mat == Material.YELLOW_CONCRETE) return true;
            if(mat == Material.GREEN_CONCRETE) return true;
            if(mat == Material.LIME_CONCRETE) return true;
            if(mat == Material.BLUE_CONCRETE) return true;
            if(mat == Material.CYAN_CONCRETE) return true;
            if(mat == Material.LIGHT_BLUE_CONCRETE) return true;
            if(mat == Material.PURPLE_CONCRETE) return true;
            if(mat == Material.MAGENTA_CONCRETE) return true;
            if(mat == Material.PINK_CONCRETE) return true;
        }

        return false;
    }
}


