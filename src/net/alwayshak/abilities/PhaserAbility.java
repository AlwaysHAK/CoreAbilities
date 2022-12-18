package net.alwayshak.abilities;
import net.alwayshak.Core;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PhaserAbility extends Ability {

    public PhaserAbility(String name, String description) {
        super(name, description);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if(getMembers().contains(event.getPlayer().getUniqueId())) {
            Player player = event.getPlayer();
            Block block = event.getClickedBlock();
            player.sendMessage("Member Done");
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
            }
        }
    }

}
