package net.alwayshak.enchantments.enchants.shooter;

import net.alwayshak.enchantments.CustomEnchant;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ExplosiveTipEnchant extends CustomEnchant {

    public static ExplosiveTipEnchant ENCHANT;
    public ExplosiveTipEnchant(String name, String displayName, String description, int maxLevel) {
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
        if (itemStack.getType() == Material.BOW)
            return true;
        return false;
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {
        if (this.projectiles.contains(e.getEntity())) {
            this.projectiles.remove(e.getEntity());
            e.getEntity().remove();
            Location loc = e.getEntity().getLocation();

            World world = loc.getWorld();
            double x = loc.getX();
            double y = loc.getY();
            double z = loc.getZ();

            world.createExplosion(x, y, z, 1.5F, false, false);
        }
    }


    private final List<Projectile> projectiles = new ArrayList<>();

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent e) {
        if (e.getEntity().getShooter() instanceof Player p && e.getEntity() instanceof org.bukkit.entity.Arrow) {
            if (p.getInventory().getItemInMainHand().getItemMeta().hasEnchant(this))
                this.projectiles.add(e.getEntity());
        }
    }

}
