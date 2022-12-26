package net.alwayshak.enchantments.old.events;

import net.alwayshak.enchantments.old.CustomEnchants;
import net.alwayshak.util.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.inventory.ItemStack;

public class LevelHungerUpEvent
        implements Listener {
    @EventHandler
    public void onXpLevelGain(PlayerLevelChangeEvent e) {
        Player p = e.getPlayer();
        if (e.getNewLevel() > e.getOldLevel())
            for (ItemStack stack : p.getInventory().getArmorContents()) {
                if (stack != null &&
                        stack.getItemMeta().hasEnchant(CustomEnchants.XPFEEDER) &&
                        Utils.randomChance(500))
                    p.setFoodLevel(p.getFoodLevel() + 2);
            }
    }
}


