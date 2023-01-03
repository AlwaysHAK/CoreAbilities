package net.alwayshak.enchantments.enchants.weapons;

import net.alwayshak.enchantments.CustomEnchant;
import net.alwayshak.util.Materials;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class AquaAspectEnchant extends CustomEnchant {

    public static AquaAspectEnchant ENCHANT;

    public AquaAspectEnchant(String name, String displayName, String description, int maxLevel) {
        super(name, displayName, description, maxLevel);
        ENCHANT = this;
    }

    public boolean conflictsWith(Enchantment enchantment) {
        if (enchantment.getKey().getNamespace() == FIRE_ASPECT.getKey().getNamespace()) return true;
        return false;
    }

    public boolean canEnchantItem(ItemStack itemStack) {
        for (Enchantment ench : itemStack.getEnchantments().keySet()) {
            if (conflictsWith(ench))
                return false;
        }
        if (Materials.isSword(itemStack)) return true;
        return false;
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player && event.getEntity() instanceof LivingEntity) {
            Player player = (Player) event.getDamager();
            ItemStack hand = ((Player) event.getDamager()).getPlayer().getInventory().getItemInMainHand();
            if (hand == null)
                return;

            if (hand.getEnchantments().containsKey(this)) {
                int level = hand.getEnchantments().get(this);
                EntityType entityType = event.getEntity().getType();
                if (level == 1) {
                    if (entityType == EntityType.ENDERMAN || entityType == EntityType.BLAZE || entityType == EntityType.MAGMA_CUBE) {
                        event.setDamage(event.getDamage() * 1.5);
                    }

                }
                if (level == 2) {
                    if (entityType == EntityType.ENDERMAN || entityType == EntityType.BLAZE || entityType == EntityType.MAGMA_CUBE) {
                        event.setDamage(event.getDamage() * 2);
                    }

                }


            }
        }
    }
}
