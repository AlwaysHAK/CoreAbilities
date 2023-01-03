package net.alwayshak.abilities.season2;

import net.alwayshak.abilities.Ability;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PhaserAbility extends Ability {

    public PhaserAbility(String name, String description) {
        super(name, description);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Block b = e.getClickedBlock();
        if(b == null)
            return;
        if(getMembers().contains(p.getUniqueId()) && e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            BlockFace bf = e.getBlockFace();

            /*player.sendMessage("Member Done");
            if(block == null)
                return;
            if (player.isSneaking() && block.getType().isSolid()) {
                Block blockInFront = block.getRelative(event.getBlockFace());
                Location location = player.getLocation();
                location.setX(location.getX() + event.getBlockFace().getModX() * -2);
                location.setY(location.getY() + event.getBlockFace().getModY() * -2);
                location.setZ(location.getZ() + event.getBlockFace().getModZ() * -2);
                player.teleport(location);
                player.sendMessage("Teleport Done");

                Block blockTwoInFront = blockInFront.getRelative(event.getBlockFace());
                if (blockTwoInFront.getType().isSolid()) {
                    player.sendMessage("Return Done");
                    // There are more than two solid blocks in a row, do not allow the player to phase through
                    return;
                }
            }*/
        }
    }

}
