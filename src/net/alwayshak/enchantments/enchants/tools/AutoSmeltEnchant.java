package net.alwayshak.enchantments.enchants.tools;

import net.alwayshak.enchantments.CustomEnchant;
import net.alwayshak.util.Materials;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

import java.util.Iterator;

public class AutoSmeltEnchant extends CustomEnchant {

    public static AutoSmeltEnchant ENCHANT;
    public AutoSmeltEnchant(String name, String displayName, String description, int maxLevel) {
        super(name, displayName, description, maxLevel);
        ENCHANT = this;
    }

    public boolean conflictsWith(Enchantment enchantment) {
        if (enchantment.getKey().getNamespace() == TelekenisisEnchant.ENCHANT.getKey().getNamespace()) return true;
        return false;
    }

    public boolean canEnchantItem(ItemStack itemStack) {
        for(Enchantment ench : itemStack.getEnchantments().keySet()) {
            if(conflictsWith(ench))
                return false;
        }
        if (Materials.isPickaxe(itemStack)) return true;
        return false;
    }

    @EventHandler
    public void onBlockBreak(BlockDropItemEvent e) {
        Player p = e.getPlayer();
        ItemStack hand = e.getPlayer().getInventory().getItemInMainHand();
        if(hand == null)
            return;

        Iterator<Recipe> recipes = Bukkit.recipeIterator();

        if(hand.getEnchantments().containsKey(this)) {
            while (recipes.hasNext()) {
                Recipe recipe = recipes.next();

                if (recipe instanceof FurnaceRecipe furnacerecipe) {

                    for (int i = 0; i < e.getItems().size(); i++) {
                        ItemStack drop = e.getItems().get(i).getItemStack();

                        if (furnacerecipe.getInputChoice().test(drop)) {
                            ItemStack newdrop = furnacerecipe.getResult();
                            newdrop.setAmount(drop.getAmount());
                            e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0.5D, 0.5D, 0.5D), newdrop);
                            e.setCancelled(true);
                        }
                    }
                }
            }
        }
    }

}