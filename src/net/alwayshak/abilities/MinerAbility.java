package net.alwayshak.abilities;

import net.alwayshak.Core;
import net.alwayshak.util.Materials;
import net.alwayshak.util.Utils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MinerAbility extends Ability {

    private boolean shift;
    private boolean toggled;

    public MinerAbility(String name, String description) {
        super(name, description);

        this.shift = false;
        this.toggled = true;

        addMember(UUID.fromString("5c46091f-8b93-48a2-97c1-62d243dcc430"));
    }

    @EventHandler
    public void onBreakBlock(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if(getMembers().contains(p.getUniqueId()) && toggled && p.getGameMode() == GameMode.SURVIVAL) {
            ItemStack hand = p.getInventory().getItemInMainHand();
            Block b = e.getBlock();
            BlockFace dir = Utils.getPlayerFacing(p);
            if(!Materials.can3x3Mine(b, hand))
                return;
            List<Block> blocksToBeRemoved = new ArrayList<>();
            if(dir == BlockFace.SOUTH || dir == BlockFace.NORTH) {

                blocksToBeRemoved.add(b.getWorld().getBlockAt(b.getLocation().add(-1,0,0)));
                blocksToBeRemoved.add(b.getWorld().getBlockAt(b.getLocation().add(1,0,0)));

                blocksToBeRemoved.add(b.getWorld().getBlockAt(b.getLocation().add(0,1,0)));
                blocksToBeRemoved.add(b.getWorld().getBlockAt(b.getLocation().add(-1,1,0)));
                blocksToBeRemoved.add(b.getWorld().getBlockAt(b.getLocation().add(1,1,0)));

                blocksToBeRemoved.add(b.getWorld().getBlockAt(b.getLocation().add(0,-1,0)));
                blocksToBeRemoved.add(b.getWorld().getBlockAt(b.getLocation().add(-1,-1,0)));
                blocksToBeRemoved.add(b.getWorld().getBlockAt(b.getLocation().add(1,-1,0)));
            }
            if(dir == BlockFace.EAST || dir == BlockFace.WEST) {

                blocksToBeRemoved.add(b.getWorld().getBlockAt(b.getLocation().add(0,0,-1)));
                blocksToBeRemoved.add(b.getWorld().getBlockAt(b.getLocation().add(0,0,1)));

                blocksToBeRemoved.add(b.getWorld().getBlockAt(b.getLocation().add(0,1,0)));
                blocksToBeRemoved.add(b.getWorld().getBlockAt(b.getLocation().add(0,1,-1)));
                blocksToBeRemoved.add(b.getWorld().getBlockAt(b.getLocation().add(0,1,1)));

                blocksToBeRemoved.add(b.getWorld().getBlockAt(b.getLocation().add(0,-1,0)));
                blocksToBeRemoved.add(b.getWorld().getBlockAt(b.getLocation().add(0,-1,-1)));
                blocksToBeRemoved.add(b.getWorld().getBlockAt(b.getLocation().add(0,-1,1)));
            }
            if(dir == BlockFace.DOWN || dir == BlockFace.UP) {

                blocksToBeRemoved.add(b.getWorld().getBlockAt(b.getLocation().add(0,0,-1)));
                blocksToBeRemoved.add(b.getWorld().getBlockAt(b.getLocation().add(0,0,1)));

                blocksToBeRemoved.add(b.getWorld().getBlockAt(b.getLocation().add(-1,0,0)));
                blocksToBeRemoved.add(b.getWorld().getBlockAt(b.getLocation().add(-1,0,-1)));
                blocksToBeRemoved.add(b.getWorld().getBlockAt(b.getLocation().add(-1,0,1)));

                blocksToBeRemoved.add(b.getWorld().getBlockAt(b.getLocation().add(1,0,0)));
                blocksToBeRemoved.add(b.getWorld().getBlockAt(b.getLocation().add(1,0,-1)));
                blocksToBeRemoved.add(b.getWorld().getBlockAt(b.getLocation().add(1,0,1)));

            }
            for(Block br : blocksToBeRemoved) {
                if(Materials.can3x3Mine(br, hand)) {
                    br.breakNaturally(hand);
                }
            }
        }
    }

    @EventHandler
    public void onShift(PlayerToggleSneakEvent e) {
        if(e.getPlayer().getGameMode() != GameMode.SURVIVAL)
            return;
        if (getMembers().contains(e.getPlayer().getUniqueId()) && e.isSneaking() && (Materials.isPickaxe(e.getPlayer().getInventory().getItemInMainHand()) || Materials.isShovel(e.getPlayer().getInventory().getItemInMainHand())))
            if (!this.shift) {
                this.shift = true;
                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Core.getPlugin(Core.class), new Runnable() {
                    public void run() {
                        MinerAbility.this.shift = false;
                    }
                }, 10L);
            } else {
                this.toggled = !this.toggled;
                if (this.toggled) {
                    sendHotbar(e.getPlayer(), "&a3x3 Mining is toggled on");
                } else {
                    sendHotbar(e.getPlayer(), "&c3x3 Mining is toggled off");
                }
                this.shift = false;
            }
    }

    public void sendHotbar(Player p, String msg) {
        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, (BaseComponent) new TextComponent(ChatColor.translateAlternateColorCodes('&', msg)));
    }
}
