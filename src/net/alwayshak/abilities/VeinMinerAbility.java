package net.alwayshak.abilities;

import net.alwayshak.Core;
import net.alwayshak.events.PlayerHandler;
import net.alwayshak.util.Materials;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VeinMinerAbility extends Ability {
    private boolean shift;
    private boolean toggled;
    private Location toDrop;
    private boolean silkTouch;
    private int xpToDrop;
    private Player p;
    private int totalTokens;

    public VeinMinerAbility(String name, String description) {
        super(name, description);


        this.shift = false;
        this.toggled = true;


        this.xpToDrop = 0;
    }


    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (getMembers().contains(e.getPlayer().getUniqueId())) {
            if (!this.toggled)
                return;
            Player p = e.getPlayer();
            ItemStack hand = p.getInventory().getItemInMainHand();
            this.toDrop = e.getBlock().getLocation();
            this.p = p;
            if (Materials.isAxe(hand)) {
                if (Materials.isLog(e.getBlock().getType())) {
                    handleLog(e.getBlock(), hand);
                    sendHotbar(p, "&a+" + this.totalTokens + " &f(" + PlayerHandler.tokens.get(p) + ")");
                    this.totalTokens = 0;
                }
            } else if (Materials.isPickaxe(hand) &&
                    Materials.isOre(e.getBlock().getType())) {
              this.silkTouch = hand.getEnchantments().containsKey(Enchantment.SILK_TOUCH);
                handleOre(e.getBlock(), hand);
                if (this.xpToDrop > 0 && !this.silkTouch) {
                    ExperienceOrb orb = this.toDrop.getWorld().spawn(this.toDrop, ExperienceOrb.class);
                    orb.setExperience(this.xpToDrop);
                }
                if (this.totalTokens > 0) {
                    sendHotbar(p, "&a+" + this.totalTokens + " &f(" + PlayerHandler.tokens.get(p) + ")");
                }
                this.xpToDrop = 0;
                this.totalTokens = 0;
                this.silkTouch = false;
            }
        }
    }


    public void handleLog(Block origin, ItemStack i) {
        if (!Materials.damageItem(i)) {
            return;
        }
        PlayerHandler.tokens.put(this.p, Integer.valueOf(PlayerHandler.tokens.get(this.p).intValue() + Materials.getTokensForMaterial(origin.getType()) / 2));
        this.totalTokens += Materials.getTokensForMaterial(origin.getType()) / 2;
        List<Block> surroundings = getSurroundings(origin);
        for (ItemStack stack : origin.getDrops(i)) {
            this.toDrop.getWorld().dropItemNaturally(this.toDrop, stack);
        }
        origin.setType(Material.AIR);
        Location loc = origin.getLocation();
        origin.getWorld().spawnParticle(Particle.FLAME, loc.getX() + 0.5D, loc.getY() + 0.5D, loc.getZ() + 0.5D, 1, 0.0D, 0.0D, 0.0D, 0.05D);
        for (Block b : surroundings) {
            if (Materials.isLog(b))
                handleLog(b, i);
        }
    }

    @EventHandler
    public void onShift(PlayerToggleSneakEvent e) {
        if (getMembers().contains(e.getPlayer().getUniqueId()) && e.isSneaking() && (Materials.isPickaxe(e.getPlayer().getInventory().getItemInMainHand()) || Materials.isAxe(e.getPlayer().getInventory().getItemInMainHand())))
            if (!this.shift) {
                this.shift = true;
                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Core.getPlugin(Core.class), new Runnable() {
                    public void run() {
                        VeinMinerAbility.this.shift = false;
                    }
                }, 10L);
            } else {
                this.toggled = !this.toggled;
                if (this.toggled) {
                    sendHotbar(e.getPlayer(), "&aVein Mining is toggled on");
                } else {
                    sendHotbar(e.getPlayer(), "&cVein Mining is toggled off");
                }
                this.shift = false;
            }
    }

    public void handleOre(Block origin, ItemStack i) {
        if (!Materials.damageItem(i)) {
            return;
        }
        PlayerHandler.tokens.put(this.p, Integer.valueOf(PlayerHandler.tokens.get(this.p).intValue() + Materials.getTokensForMaterial(origin.getType())));
        this.totalTokens += Materials.getTokensForMaterial(origin.getType());
        sendHotbar(this.p, "&a+" + Materials.getTokensForMaterial(origin.getType()) + " &f(" + PlayerHandler.tokens.get(this.p) + ")");
        List<Block> surroundings = getSurroundings(origin);
        for (ItemStack stack : origin.getDrops(i)) {
            this.toDrop.getWorld().dropItemNaturally(this.toDrop, stack);
        }
        if (!this.silkTouch) {
            this.xpToDrop += Materials.giveExpForOre(origin);
        }
        origin.setType(Material.AIR);
        Location loc = origin.getLocation();
        origin.getWorld().spawnParticle(Particle.FLAME, loc.getX() + 0.5D, loc.getY() + 0.5D, loc.getZ() + 0.5D, 1, 0.0D, 0.0D, 0.0D, 0.05D);
        for (Block b : surroundings) {
            if (Materials.isOre(b)) {
                handleOre(b, i);
            }
        }
    }


    public List<Block> getSurroundings(Block b) {
        World w = b.getWorld();
        List<Block> blocksAround = new ArrayList<>();
        blocksAround.add(w.getBlockAt(b.getLocation().add(0.0D, 1.0D, 0.0D)));
        blocksAround.add(w.getBlockAt(b.getLocation().add(1.0D, 1.0D, 0.0D)));
        blocksAround.add(w.getBlockAt(b.getLocation().add(0.0D, 1.0D, 1.0D)));
        blocksAround.add(w.getBlockAt(b.getLocation().add(1.0D, 1.0D, 1.0D)));
        blocksAround.add(w.getBlockAt(b.getLocation().add(0.0D, 0.0D, 1.0D)));
        blocksAround.add(w.getBlockAt(b.getLocation().add(1.0D, 0.0D, 1.0D)));
        blocksAround.add(w.getBlockAt(b.getLocation().add(1.0D, 0.0D, 0.0D)));
        blocksAround.add(w.getBlockAt(b.getLocation().add(0.0D, 0.0D, -1.0D)));
        blocksAround.add(w.getBlockAt(b.getLocation().add(-1.0D, 0.0D, -1.0D)));
        blocksAround.add(w.getBlockAt(b.getLocation().add(-1.0D, 0.0D, 0.0D)));
        blocksAround.add(w.getBlockAt(b.getLocation().add(-1.0D, 0.0D, 1.0D)));
        blocksAround.add(w.getBlockAt(b.getLocation().add(1.0D, 0.0D, -1.0D)));
        blocksAround.add(w.getBlockAt(b.getLocation().add(-1.0D, 1.0D, 0.0D)));
        blocksAround.add(w.getBlockAt(b.getLocation().add(0.0D, 1.0D, -1.0D)));
        blocksAround.add(w.getBlockAt(b.getLocation().add(-1.0D, 1.0D, -1.0D)));
        blocksAround.add(w.getBlockAt(b.getLocation().add(1.0D, -1.0D, 0.0D)));
        blocksAround.add(w.getBlockAt(b.getLocation().add(1.0D, -1.0D, 1.0D)));
        blocksAround.add(w.getBlockAt(b.getLocation().add(0.0D, -1.0D, 1.0D)));
        blocksAround.add(w.getBlockAt(b.getLocation().add(1.0D, -1.0D, -1.0D)));
        blocksAround.add(w.getBlockAt(b.getLocation().add(-1.0D, -1.0D, 1.0D)));
        blocksAround.add(w.getBlockAt(b.getLocation().add(1.0D, 1.0D, -1.0D)));
        blocksAround.add(w.getBlockAt(b.getLocation().add(-1.0D, 1.0D, 1.0D)));
        blocksAround.add(w.getBlockAt(b.getLocation().add(0.0D, -1.0D, 0.0D)));
        blocksAround.add(w.getBlockAt(b.getLocation().add(-1.0D, -1.0D, 0.0D)));
        blocksAround.add(w.getBlockAt(b.getLocation().add(0.0D, -1.0D, -1.0D)));
        blocksAround.add(w.getBlockAt(b.getLocation().add(-1.0D, -1.0D, -1.0D)));
        return blocksAround;
    }

    public void sendHotbar(Player p, String msg) {
        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, (BaseComponent) new TextComponent(ChatColor.translateAlternateColorCodes('&', msg)));
    }
}


