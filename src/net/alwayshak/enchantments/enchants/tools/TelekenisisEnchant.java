package net.alwayshak.enchantments.enchants.tools;

import net.alwayshak.enchantments.CustomEnchant;
import net.alwayshak.util.Materials;
import org.bukkit.Material;
import org.bukkit.block.Container;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ListIterator;
import java.util.Map;

public class TelekenisisEnchant extends CustomEnchant {

    public static TelekenisisEnchant ENCHANT;
    public TelekenisisEnchant(String name, String displayName, String description, int maxLevel) {
        super(name, displayName, description, maxLevel);
        ENCHANT = this;
    }

    public boolean conflictsWith(Enchantment enchantment) {
        if (enchantment.getKey().getNamespace() == AutoSmeltEnchant.ENCHANT.getKey().getNamespace()) return true;
        return false;
    }

    public boolean canEnchantItem(ItemStack itemStack) {
        for(Enchantment ench : itemStack.getEnchantments().keySet()) {
            if(conflictsWith(ench))
                return false;
        }
        if (Materials.isSword(itemStack)) return true;
        if (Materials.isPickaxe(itemStack)) return true;
        if (Materials.isAxe(itemStack)) return true;
        if (Materials.isHoe(itemStack)) return true;
        if (Materials.isShovel(itemStack)) return true;
        if (Material.SHEARS == itemStack.getType());

        return false;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        ItemStack hand = e.getPlayer().getInventory().getItemInMainHand();
        if(hand == null)
            return;

        if(hand.getEnchantments().containsKey(this)) {
            for (ItemStack stack : e.getBlock().getDrops(e.getPlayer().getInventory().getItemInMainHand())) {
                if (stack.getType().isAir())
                    continue;
                Map<Integer, ItemStack> stackMap = e.getPlayer().getInventory().addItem(stack);
                for (ItemStack remains : stackMap.values()) {
                    if (!remains.getType().isAir())
                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), remains);
                }
            }
            if (e.getBlock().getState() instanceof Container &&
                    !e.getBlock().getType().name().toLowerCase().contains("shulker")) {
                for (ListIterator<ItemStack> listIterator = ((Container) e.getBlock().getState()).getInventory().iterator(); listIterator.hasNext(); ) {
                    ItemStack stack = listIterator.next();
                    if (stack == null)
                        continue;
                    Map<Integer, ItemStack> stackMap = e.getPlayer().getInventory().addItem(stack);
                    for (ItemStack remains : stackMap.values()) {
                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), remains);
                    }
                }

                ((Container) e.getBlock().getState()).getInventory().clear();
            }

            e.getPlayer().giveExp(e.getExpToDrop());
            e.setDropItems(false);
            e.setExpToDrop(0);
        }
    }
}
