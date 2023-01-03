package net.alwayshak.enchantments.enchants;

import net.alwayshak.enchantments.CustomEnchant;
import net.alwayshak.enchantments.enchants.weapons.BlindEnchant;
import net.alwayshak.util.Materials;
import net.alwayshak.util.Utils;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ExperienceEnchant extends CustomEnchant {

    public static ExperienceEnchant ENCHANT;

    public ExperienceEnchant(String name, String displayName, String description, int maxLevel) {
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
        if (Materials.isPickaxe(itemStack)) return true;
        if (Materials.isSword(itemStack)) return true;
        return false;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Block b = e.getBlock();
        Location loc = e.getBlock().getLocation();

        ItemStack hand = p.getInventory().getItemInMainHand();

        if (Materials.giveXp(b)) {

            if (hand == null)
                return;
            if (!p.getInventory().getItemInMainHand().hasItemMeta())
                return;

            if (hand.getEnchantments().containsKey(this)) {
                int level = hand.getEnchantments().get(this);
                if (level == 1) {
                    if (Utils.randomChance(20)) {
                        e.setExpToDrop((int)(e.getExpToDrop() * 1.2));
                    }
                }
                if (level == 2) {
                    if (Utils.randomChance(25)) {
                        e.setExpToDrop((int)(e.getExpToDrop() * 1.5));
                    }
                }
                if (level == 3) {
                    if (Utils.randomChance(33)) {
                        loc.getWorld().spawn(loc, ExperienceOrb.class).setExperience(6);
                        e.setExpToDrop((int)(e.getExpToDrop() * 1.8));
                    }
                }
            }
        }
    }
}
