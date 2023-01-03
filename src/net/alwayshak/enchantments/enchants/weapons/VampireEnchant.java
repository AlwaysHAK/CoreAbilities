package net.alwayshak.enchantments.enchants.weapons;

import net.alwayshak.enchantments.CustomEnchant;
import net.alwayshak.util.Materials;
import net.alwayshak.util.Utils;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class VampireEnchant extends CustomEnchant {

    public static VampireEnchant ENCHANT;

    public VampireEnchant(String name, String displayName, String description, int maxLevel) {
        super(name, displayName, description, maxLevel);
        ENCHANT = this;
    }

    public boolean conflictsWith(Enchantment enchantment) {
        return false;
    }

    public boolean canEnchantItem(ItemStack itemStack) {
        for(Enchantment ench : itemStack.getEnchantments().keySet()) {
            if(conflictsWith(ench))
                return false;
        }
        if (Materials.isSword(itemStack)) return true;
        return false;
    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent e) {
        if(!(e.getDamager() instanceof Player))
            return;
        if(!(e.getEntity() instanceof LivingEntity))
            return;

        Player p = (Player) e.getDamager();
        LivingEntity entity = (LivingEntity) e.getEntity();

        ItemStack hand = p.getInventory().getItemInMainHand();

        if (hand == null)
            return;
        if (!p.getInventory().getItemInMainHand().hasItemMeta())
            return;

        if(hand.getEnchantments().containsKey(this)) {
            int level = hand.getEnchantments().get(this);
            if(level == 1) {
                if(Utils.randomChance(10)) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 40, 1));
                }
            }
            if(level == 2) {
                if(Utils.randomChance(20)) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 60, 1));
                }
            }
            if(level == 3) {
                if(Utils.randomChance(30)) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 60, 1));
                }
            }
            if(level == 4) {
                if(Utils.randomChance(40)) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 60, 1));
                }
            }
            if(level == 5) {
                if(Utils.randomChance(50)) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 60, 1));
                }
            }
            if(level == 6) {
                if(Utils.randomChance(60)) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 60, 1));
                }
            }
            if(level == 7) {
                if(Utils.randomChance(70)) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 60, 1));
                }
            }
        }
    }
}
