package net.alwayshak.enchantments.enchants.tools;

import net.alwayshak.Core;
import net.alwayshak.enchantments.CustomEnchant;
import net.alwayshak.enchantments.EnchantHandler;
import net.alwayshak.util.Materials;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

public class ReplantEnchant extends CustomEnchant {

    public static ReplantEnchant ENCHANT;
    public ReplantEnchant(String name, String displayName, String description, int maxLevel) {
        super(name, displayName, description, maxLevel);
        ENCHANT = this;
    }

    public boolean conflictsWith(Enchantment enchantment) {
        return false;
    }

    public boolean canEnchantItem(ItemStack itemStack) {
        for(Enchantment ench : itemStack.getEnchantments().keySet()) {
            if(conflictsWith(ench))
                return false;
        }
        if (Materials.isHoe(itemStack)) return true;
        return false;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if(EnchantHandler.hasEnchant(e.getPlayer().getInventory().getItemInMainHand(), this) > 0) {
            Block block = e.getBlock();
            boolean isCrop = block.getBlockData().getMaterial().equals(Material.WHEAT)
                    || block.getBlockData().getMaterial().equals(Material.BEETROOTS)
                    || block.getBlockData().getMaterial().equals(Material.CARROTS)
                    || block.getBlockData().getMaterial().equals(Material.POTATOES)
                    || block.getBlockData().getMaterial().equals(Material.NETHER_WART);
            Material getSeedType = e.getBlock().getType();
            switch (getSeedType) {
                case WHEAT:
                    getSeedType = Material.WHEAT_SEEDS;
                    break;
                case BEETROOTS:
                    getSeedType = Material.BEETROOT_SEEDS;
                    break;
                case CARROTS:
                    getSeedType = Material.CARROT;
                    break;
                case POTATOES:
                    getSeedType = Material.POTATO;
                    break;
                case NETHER_WART:
                    getSeedType = Material.NETHER_WART;
                    break;
                default:
                    getSeedType = null;
                    break;
            }
            if(isCrop) {
                Material crop = getSeedType;
                Material blockT = e.getBlock().getType();
                if(hasSeeds(e.getPlayer(), crop)) {
                    HashMap<Integer, ? extends ItemStack> map = e.getPlayer().getInventory().all(crop);
                    if (map.isEmpty()) {
                        return;
                    }
                    for (HashMap.Entry<Integer, ? extends ItemStack> entry : map.entrySet()) {
                        if (entry.getValue().getAmount() != 0) {
                            if (entry.getValue().getAmount() == 1) {
                                e.getPlayer().getInventory().setItem(entry.getKey(), null);
                            } else {
                                entry.getValue().setAmount(entry.getValue().getAmount() - 1);
                                e.getPlayer().getInventory().setItem(entry.getKey(), entry.getValue());
                            }
                            break;
                        }
                    }
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Core.getPlugin(Core.class), new Runnable() {
                        @Override
                        public void run() {
                            e.getBlock().setType(blockT);
                        }
                    }, 5l);
                }
            }
        }
    }

    private boolean hasSeeds(Player player, Material seedType) {
        if (seedType == null) {
            return false;
        }
        /*HashMap<Integer, ? extends ItemStack> map = player.getInventory().all(seedType);
        if(map.size() > 0)
            return true;*/
        ItemStack is = new ItemStack(seedType);
        if (player.getInventory().containsAtLeast(is, 1)) {
            return true;
        }
        return false;
    }
}
