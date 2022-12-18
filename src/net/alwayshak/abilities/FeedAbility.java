package net.alwayshak.abilities;

import net.alwayshak.Core;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

public class FeedAbility
        extends Ability {
    public FeedAbility(String name, String description) {
        super(name, description);
        addMember(UUID.fromString("f53c22c0-69cb-4fcb-96db-855312bca519"));

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