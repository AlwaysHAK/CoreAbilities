package net.alwayshak.enchantments.events;

import net.alwayshak.enchantments.CustomEnchants;
import org.bukkit.Bukkit;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

import java.util.Iterator;


public class CutCleanEvent
        implements Listener {
    @EventHandler
    public void onBreak(BlockDropItemEvent e) {
        Player p = e.getPlayer();

        if (p.getInventory().getItemInMainHand() == null) {
            return;
        }
        if (!p.getInventory().getItemInMainHand().hasItemMeta()) {
            return;
        }
        if (!p.getInventory().getItemInMainHand().getItemMeta().hasEnchant(CustomEnchants.CUTCLEAN)) {
            return;
        }
        Iterator<Recipe> recipes = Bukkit.recipeIterator();

        while (recipes.hasNext()) {
            Recipe recipe = recipes.next();

            if (recipe instanceof FurnaceRecipe furnacerecipe) {

                for (int i = 0; i < e.getItems().size(); i++) {
                    ItemStack drop = e.getItems().get(i).getItemStack();

                    if (furnacerecipe.getInputChoice().test(drop)) {
                        ItemStack newdrop = furnacerecipe.getResult();
                        newdrop.setAmount(drop.getAmount());
                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0.5D, 0.5D, 0.5D), newdrop);
                    }
                }
            }
        }
    }
}


