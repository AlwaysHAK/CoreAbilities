package net.alwayshak.abilities.season1;

import net.alwayshak.Core;
import net.alwayshak.abilities.Ability;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class FeedAbility
        extends Ability {
    public FeedAbility(String name, String description) {
        super(name, description);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(Core.getPlugin(Core.class), new Runnable() {
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (FeedAbility.this.getMembers().contains(p.getUniqueId())) {
                        p.setExhaustion(p.getExhaustion() + 2.0F);
                        p.setSaturation(p.getSaturation() + 2.0F);
                        p.setFoodLevel(p.getFoodLevel() + 2);
                    }
                }
            }
        }, 0L, 200L);
    }
}