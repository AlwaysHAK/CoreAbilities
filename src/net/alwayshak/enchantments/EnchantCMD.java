package net.alwayshak.enchantments;

import net.alwayshak.enchantments.enchants.ExperienceEnchant;
import net.alwayshak.enchantments.enchants.shooter.FrostArrowEnchant;
import net.alwayshak.enchantments.enchants.tools.CutCleanEnchant;
import net.alwayshak.enchantments.enchants.tools.ObsidianDestroyerEnchant;
import net.alwayshak.enchantments.enchants.tools.TelekenisisEnchant;
import net.alwayshak.enchantments.enchants.weapons.BlindEnchant;
import net.alwayshak.enchantments.enchants.weapons.ConfusionEnchant;
import net.alwayshak.enchantments.enchants.weapons.ViperEnchant;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class EnchantCMD implements TabExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String arg, String[] args) {
        if(args.length == 2 || args.length == 3) {
            Player p = Bukkit.getPlayer(args[0]);
            CustomEnchant ench = EnchantHandler.getEnchant(args[1].toLowerCase());

            if(p != null) {
                if(ench != null) {
                    if(args.length == 2) {
                        if(p.getInventory().getItemInMainHand() != null) {
                            ItemStack stack = p.getInventory().getItemInMainHand();
                            //if(ench.canEnchantItem(stack)) {
                                if(EnchantHandler.addEnchantment(stack, ench, 1))
                                    s.sendMessage(c("&aApplied enchantment."));
                                else
                                    s.sendMessage(c("&cCannot apply the specified enchantment."));
                            //} else
                            //    s.sendMessage(c("&cCannot apply the specified enchantment."));
                        } else
                            s.sendMessage(c("&cCannot apply the specified enchantment."));
                    } else {
                        if(isInt(args[2])) {
                            int level = Integer.valueOf(args[2]);
                            if(level > 0 && level <= ench.getMaxLevel()) {
                                if(p.getInventory().getItemInMainHand() != null) {
                                    ItemStack stack = p.getInventory().getItemInMainHand();
                                    if(ench.canEnchantItem(stack)) {
                                        if(EnchantHandler.addEnchantment(stack, ench, level))
                                            s.sendMessage(c("&aApplied enchantment."));
                                        else
                                            s.sendMessage(c("&cCannot apply the specified enchantment."));
                                    } else
                                        s.sendMessage(c("&cCannot apply the specified enchantment."));
                                } else
                                    s.sendMessage(c("&cCannot apply the specified enchantment."));
                            } else
                                s.sendMessage(c("&cThat is not a valid level."));
                        } else
                            s.sendMessage(c("&cThat is not a valid level."));
                    }
                } else
                    s.sendMessage(c("&cThat is not a valid enchantment."));
            } else
                s.sendMessage(c("&cThat player is not online."));
        } else
            s.sendMessage(c("&cInvalid arguments."));
        /*if(s instanceof Player) {
            Player p = (Player) s;

            ItemStack pickaxestack = new ItemStack(Material.NETHERITE_PICKAXE, 1);
            EnchantHandler.addEnchantment(pickaxestack, TelekenisisEnchant.ENCHANT, 1);
            EnchantHandler.addEnchantment(pickaxestack, ObsidianDestroyerEnchant.ENCHANT, 1);
            EnchantHandler.addEnchantment(pickaxestack, ExperienceEnchant.ENCHANT, 3);
            p.getInventory().addItem(pickaxestack);

            ItemStack bowstack = new ItemStack(Material.BOW, 1);
            //bowstack.addUnsafeEnchantment(ExplosiveTipEnchant.ENCHANT, 1);
            //bowstack.addUnsafeEnchantment(ZeroGravityArrowEnchant.ENCHANT, 1);
            EnchantHandler.addEnchantment(bowstack, FrostArrowEnchant.ENCHANT, 1);
            p.getInventory().addItem(bowstack);

            ItemStack swordstack = new ItemStack(Material.NETHERITE_SWORD, 1);
            EnchantHandler.addEnchantment(swordstack, BlindEnchant.ENCHANT, 3);
            EnchantHandler.addEnchantment(swordstack, ExperienceEnchant.ENCHANT, 3);
            p.getInventory().addItem(swordstack);

            ItemStack shearstack = new ItemStack(Material.SHEARS, 1);
            EnchantHandler.addEnchantment(shearstack, CutCleanEnchant.ENCHANT, 1);
            p.getInventory().addItem(shearstack);
        }*/
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender s, Command cmd, String arg, String[] args) {
        List<String> list = new ArrayList<>();
        if(args.length == 1) {
            for(Player p : Bukkit.getOnlinePlayers()) {
                if(p.getName().toLowerCase().startsWith(args[0].toLowerCase()))
                    list.add(p.getName());
            }
        }
        if(args.length == 2) {
            for(CustomEnchant ench : EnchantHandler.getEnchantments()) {
                if(ench.getName().toLowerCase().startsWith(args[1].toLowerCase()))
                    list.add(ench.getName());
            }
        }
        if(args.length == 3) {
            CustomEnchant ench = EnchantHandler.getEnchant(args[1].toLowerCase());
            if(ench != null) {
                for(int i = 1; i <= ench.getMaxLevel(); i++) {
                    list.add(String.valueOf(i));
                }
            }
        }
        return list;
    }

    private boolean isInt(String str) {
        try{
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String c(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
