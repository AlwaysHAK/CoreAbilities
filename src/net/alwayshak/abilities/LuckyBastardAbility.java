package net.alwayshak.abilities;

import net.alwayshak.util.Materials;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.UUID;


public class LuckyBastardAbility
        extends Ability {
    public LuckyBastardAbility(String name, String description) {
        super(name, description);
    }


    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (getMembers().contains(e.getPlayer().getUniqueId())) {
            PlayerInventory inv = e.getPlayer().getInventory();
            ItemStack mainHand = inv.getItemInMainHand();
            if (Materials.isOre(e.getBlock()) &&
                    mainHand != null && Materials.isPickaxe(mainHand)) {
                ItemStack clonedItem = mainHand.clone();
                clonedItem.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, mainHand.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) + 3);
                for (ItemStack stack : e.getBlock().getDrops(clonedItem))
                    e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), stack);
                clonedItem.setAmount(0);
                e.setDropItems(false);
            }
        }
    }
}

