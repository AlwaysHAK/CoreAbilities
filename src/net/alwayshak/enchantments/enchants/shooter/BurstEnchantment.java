package net.alwayshak.enchantments.enchants.shooter;

import net.alwayshak.Core;
import net.alwayshak.enchantments.CustomEnchant;
import net.alwayshak.enchantments.EnchantHandler;
import net.alwayshak.util.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class BurstEnchantment extends CustomEnchant {

    public static BurstEnchantment ENCHANT;

    public BurstEnchantment(String name, String displayName, String description, int maxLevel) {
        super(name, displayName, description, maxLevel);
        ENCHANT = this;
    }

    public boolean conflictsWith(Enchantment enchantment) {
        if (enchantment.getKey().getNamespace() == ZeroGravityArrowEnchant.ENCHANT.getKey().getNamespace()) return true;
        return false;
    }

    public boolean canEnchantItem(ItemStack itemStack) {
        for (Enchantment ench : itemStack.getEnchantments().keySet())
            if (conflictsWith(ench))
                return false;
        if (itemStack.getType() == Material.BOW)
            return true;
        return false;
    }

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent e) {
        Player shooter = (Player) e.getEntity().getShooter();
        Player p = (Player) e.getEntity().getShooter();
        ItemStack hand = p.getInventory().getItemInMainHand();
        int level = EnchantHandler.hasEnchant(hand, this);
        if(level == 1) {
            Arrow arrow = (Arrow) e.getEntity();
            Vector velocity = arrow.getVelocity();
            World world = arrow.getWorld();
            Location location = arrow.getLocation();
            Arrow arrow2 = world.spawnArrow(location, velocity, 1.0f, 0.0f);
            arrow2.setShooter(shooter);
            arrow2.setVelocity(velocity);
        }
        if(level == 2) {
            Arrow arrow = (Arrow) e.getEntity();
            Vector velocity = arrow.getVelocity();
            World world = arrow.getWorld();
            Location location = arrow.getLocation();
            Arrow arrow2 = world.spawnArrow(location, velocity, 1.0F, 0.0F);
            arrow2.setShooter(shooter);
            arrow2.setVelocity(velocity);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.getPlugin(Core.class), new Runnable() {
                public void run() {
                    Arrow arrow3 = world.spawnArrow(location, velocity, 1.0f, 0.0f);
                    arrow3.setShooter(shooter);
                    arrow3.setVelocity(velocity);
                }
            }, 4);

        }
        if(level == 3) {
            Arrow arrow = (Arrow) e.getEntity();
            Vector velocity = arrow.getVelocity();
            World world = arrow.getWorld();
            Location location = arrow.getLocation();
            Arrow arrow2 = world.spawnArrow(location, velocity, 1.0f, 0.0f);
            arrow2.setShooter(shooter);
            arrow2.setVelocity(velocity);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.getPlugin(Core.class), new Runnable() {
                public void run() {
                    Arrow arrow3 = world.spawnArrow(location, velocity, 1.0f, 0.0f);
                    arrow3.setShooter(shooter);
                    arrow3.setVelocity(velocity);
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.getPlugin(Core.class), new Runnable() {
                        public void run() {
                            Arrow arrow4 = world.spawnArrow(location, velocity, 1.0f, 0.0f);
                            arrow4.setShooter(shooter);
                            arrow4.setVelocity(velocity);
                        }
                    }, 4);
                }
            }, 4);

        }

    }


}
