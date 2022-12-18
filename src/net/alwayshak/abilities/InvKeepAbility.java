package net.alwayshak.abilities;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class InvKeepAbility
        extends Ability {
    private ItemStack stack;

    public InvKeepAbility(String name, String description) {
        super(name, description);
        addMember(UUID.fromString("7ec204f3-c64c-4dfd-b43b-15152c65b005"));
    }


    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        if (getMembers().contains(e.getEntity().getUniqueId())) {
            Player p = e.getEntity();
            this.stack = p.getInventory().getItem(0).clone();
            p.getInventory().setItem(0, new ItemStack(Material.AIR, 0));
            e.setKeepLevel(true);
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        if (getMembers().contains(e.getPlayer().getUniqueId()) &&
                this.stack != null) {
            e.getPlayer().getInventory().setItem(0, this.stack);
            this.stack = null;
        }
    }
}
