package net.alwayshak.enchantments.enchants.shooter;

import net.alwayshak.Core;
import net.alwayshak.enchantments.CustomEnchant;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;

public class ZeroGravityArrowEnchant extends CustomEnchant {

    public static ZeroGravityArrowEnchant ENCHANT;

    public ZeroGravityArrowEnchant(String name, String displayName, String description, int maxLevel) {
        super(name, displayName, description, maxLevel);
        ENCHANT = this;
    }

    public boolean conflictsWith(Enchantment enchantment) {
        return false;
    }

    public boolean canEnchantItem(ItemStack itemStack) {
        for (Enchantment ench : itemStack.getEnchantments().keySet())
            if (conflictsWith(ench))
                return false;
        if (itemStack.getType() == Material.BOW) return true;
        return false;
    }

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        if (event.getEntity().getShooter() instanceof Player) {
            Player p = (Player) event.getEntity().getShooter();
            ItemStack hand = p.getInventory().getItemInMainHand();
            if (hand == null)
                return;

            if (hand.getEnchantments().containsKey(this)) {
                Projectile projectile = event.getEntity();
                if (projectile instanceof Arrow) {
                    Arrow arrow = (Arrow) projectile;
                    arrow.setGravity(false);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Core.getPlugin(Core.class), new Runnable() {
                        public void run() {
                            if (arrow != null) {
                                arrow.setGravity(true);
                            }
                        }
                    }, 5 * 20);
                }
            }
        }
    }
}
