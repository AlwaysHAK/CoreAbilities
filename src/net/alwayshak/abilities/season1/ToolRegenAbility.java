package net.alwayshak.abilities.season1;

import net.alwayshak.Core;
import net.alwayshak.abilities.Ability;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

public class ToolRegenAbility extends Ability {
    public ToolRegenAbility(String name, String description) {
        super(name, description);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.getPlugin(Core.class), new Runnable() {
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (ToolRegenAbility.this.getMembers().contains(p.getUniqueId())) {
                        for (ItemStack i : p.getInventory().getContents()) {
                            if (i != null &&
                                    i.getItemMeta() instanceof Damageable m) {
                                if (m.getDamage() != 0) {
                                    m.setDamage(m.getDamage() - 1);
                                    i.setItemMeta(m);
                                }
                            }
                        }

                        for (ItemStack i : p.getInventory().getArmorContents()) {
                            if (i != null &&
                                    i.getItemMeta() instanceof Damageable m) {
                                if (m.getDamage() != 0) {
                                    m.setDamage(m.getDamage() - 1);
                                    i.setItemMeta(m);
                                }
                            }
                        }
                    }
                }
            }
        }, 0L, 100L);
    }
}


