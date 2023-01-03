package net.alwayshak.enchantments.enchants.shooter;

import net.alwayshak.enchantments.CustomEnchant;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class FrostArrowEnchant extends CustomEnchant {

    public static FrostArrowEnchant ENCHANT;

    public FrostArrowEnchant(String name, String displayName, String description, int maxLevel) {
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

    private List<Projectile> proj = new ArrayList<>();

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        if (event.getEntity().getShooter() instanceof Player) {
            Player p = (Player) event.getEntity().getShooter();
            ItemStack hand = p.getInventory().getItemInMainHand();
            if (hand == null)
                return;

            if (hand.getEnchantments().containsKey(this)) {
                Projectile projectile = event.getEntity();
                proj.add(projectile);
            }
        }
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {
        if(proj.contains(e.getEntity())) {
            proj.remove(e.getEntity());
            if(e.getHitEntity() != null) {
                Entity entity = e.getHitEntity();
                entity.setFreezeTicks(20*10);
            }
        }
    }
}
