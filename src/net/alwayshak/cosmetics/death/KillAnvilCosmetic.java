package net.alwayshak.cosmetics.death;

import net.alwayshak.Core;
import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class KillAnvilCosmetic extends Cosmetic {
    private final List<FallingBlock> fallingBlocks;

    public KillAnvilCosmetic() {
        super("Anvil Fall", "The pressure...", Category.KILL, Material.ANVIL, Rarity.EPIC);


        this.fallingBlocks = new ArrayList<>();
        this.blocks = new ArrayList<>();
    }

    private final List<Block> blocks;

    public void onActivate(Location loc) {
        FallingBlock fallingBlock = loc.getWorld().spawnFallingBlock(loc.add(0.0D, 15.0D, 0.0D), Material.ANVIL.createBlockData());
        fallingBlock.setHurtEntities(false);
        fallingBlock.setDropItem(false);
        this.fallingBlocks.add(fallingBlock);
    }


    @EventHandler
    public void onEntityToBlock(final EntityChangeBlockEvent e) {
        if (this.fallingBlocks.contains(e.getEntity())) {
            this.fallingBlocks.remove(e.getEntity());
            e.getEntity().remove();
            this.blocks.add(e.getBlock());
            Bukkit.getScheduler().scheduleSyncDelayedTask(Core.getPlugin(Core.class), new Runnable() {
                public void run() {
                    e.getBlock().setType(Material.AIR);
                }
            }, 20L);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (this.blocks.contains(e.getBlock()))
            e.setDropItems(false);
    }
}


