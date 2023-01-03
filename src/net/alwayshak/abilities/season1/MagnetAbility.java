package net.alwayshak.abilities.season1;

import net.alwayshak.abilities.Ability;
import org.bukkit.block.Container;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ListIterator;
import java.util.Map;


public class MagnetAbility
        extends Ability {
    public MagnetAbility(String name, String description) {
        super(name, description);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (getMembers().contains(e.getPlayer().getUniqueId())) {
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
