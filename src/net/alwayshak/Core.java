package net.alwayshak;

import net.alwayshak.abilities.*;
import net.alwayshak.cheat.CheatGUI;
import net.alwayshak.cheat.CheatMenuCMD;
import net.alwayshak.cheat.ResetCosmeticsCMD;
import net.alwayshak.config.ConfigHandler;
import net.alwayshak.config.ReloadConfigCMD;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.CosmeticsHandler;
import net.alwayshak.cosmetics.chest.*;
import net.alwayshak.cosmetics.death.KillAnvilCosmetic;
import net.alwayshak.cosmetics.death.KillLightningCosmetic;
import net.alwayshak.cosmetics.elytra.*;
import net.alwayshak.cosmetics.feet.*;
import net.alwayshak.cosmetics.gui.CosmeticsCMD;
import net.alwayshak.cosmetics.gui.CosmeticsGUI;
import net.alwayshak.cosmetics.head.*;
import net.alwayshak.cosmetics.hit.HitAngryCosmetic;
import net.alwayshak.cosmetics.hit.HitLightningCosmetic;
import net.alwayshak.cosmetics.projectile.*;
import net.alwayshak.cosmetics.special.KillFoxCosmetic;
import net.alwayshak.cosmetics.special.KillHAKCosmetic;
import net.alwayshak.cosmetics.special.KillOazzCosmetic;
import net.alwayshak.enchantments.CustomEnchants;
import net.alwayshak.enchantments.commands.CustomEnchantmentsCMD;
import net.alwayshak.events.PlayerHandler;
import net.alwayshak.lootcrate.Lootcrate;
import net.alwayshak.lootcrate.LootcrateCMD;
import net.alwayshak.lootcrate.TokenCMD;
import net.alwayshak.notes.NotesCMD;
import net.alwayshak.notes.NotesGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {
    public void onEnable() {
        handleConfig();
        handleAbilities();
        handleCosmetics();
        handleCommands();
        handleNotes();
        handleEvents();


        for (Player p : Bukkit.getOnlinePlayers()) {
            this.cosmeticHandler.loadCosmetics(p);
            PlayerHandler.loadTokens(p);
        }
    }

    private CosmeticsHandler cosmeticHandler;

    public void onDisable() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            this.cosmeticHandler.saveCosmetics(p);
            PlayerHandler.saveTokens(p);
        }
    }

    private void handleCommands() {
        registerCommand("reloadconfig", new ReloadConfigCMD(), "coreabilities.reload");
        registerCommand("cheatmenu", new CheatMenuCMD(), "coreabilities.cheatmenu");
        registerCommand("tokens", new TokenCMD());
        registerCommand("lootcrate", new LootcrateCMD());
        registerCommand("resetcosmetics", new ResetCosmeticsCMD());
    }

    private void handleAbilities() {
        AbilityHandler manager = new AbilityHandler(this);
        Bukkit.getPluginManager().registerEvents(manager, this);
        manager.registerAbility(new MagnetAbility("Magnet", "You auto-pickup items you mine."));
        manager.registerAbility(new CatAbility("Cat", "You take half fall damage and creepers don't target you."));
        manager.registerAbility(new VeinMinerAbility("VeinMiner", "Vein mines ores and trees."));
        manager.registerAbility(new TeleportBowAbility("DoubleJump", "Makes you do an epic thing yay."));
        manager.registerAbility(new ToolRegenAbility("ToolRegen", "Regens your tool every X seconds."));
        manager.registerAbility(new LuckyBastardAbility("LuckyFuck", "You always have fortune 3 (it stacks with the fortune enchantment)."));
        manager.registerAbility(new InvisibilityAbility("Invisibility", "Turn invisible when sneaking."));
        manager.registerAbility(new InvKeepAbility("KeepInv", "Keeps your first slot and levels upon dying."));
        manager.registerAbility(new ReducedCooldownAbility("ReducedCooldown", "Reduces combat cooldown."));
        manager.registerAbility(new ConduitAbility("Conduit", "You get conduit when in water."));
        manager.registerAbility(new HasteAbility("Haste", "You have permanent haste!"));
        manager.registerAbility(new FeedAbility("Feed", "You get fed"));
        manager.registerAbility(new PhaserAbility("Phaser", "You can phase through blocks"));
        manager.registerAbility(new VayuAbility("Vayu", "i am god"));
        manager.registerAbility(new BigBoyAbility("Big Boy", "more health and shit"));
        manager.registerAbility(new ZeusAbility("Zeus", "god 2.0"));
    }


    private void handleCosmetics() {
        this.cosmeticHandler = new CosmeticsHandler(this);
        CosmeticsGUI cosmeticsGUI = new CosmeticsGUI(this, this.cosmeticHandler);
        registerCommand("cosmetics", new CosmeticsCMD(cosmeticsGUI));
        Bukkit.getPluginManager().registerEvents(this.cosmeticHandler, this);
        Bukkit.getPluginManager().registerEvents(new Lootcrate(), this);


        this.cosmeticHandler.registerCosmetic(new HeadFallingWaterCosmetic());
        this.cosmeticHandler.registerCosmetic(new HeadFallingLavaCosmetic());
        this.cosmeticHandler.registerCosmetic(new HeadFallingDripLavaCosmetic());
        this.cosmeticHandler.registerCosmetic(new HeadFallingDripWaterCosmetic());
        this.cosmeticHandler.registerCosmetic(new HeadFlameCosmetic());
        this.cosmeticHandler.registerCosmetic(new HeadSeaCosmetic());
        this.cosmeticHandler.registerCosmetic(new HeadHeartCosmetic());
        this.cosmeticHandler.registerCosmetic(new HeadEnderCosmetic());
        this.cosmeticHandler.registerCosmetic(new HeadDamageCosmetic());
        this.cosmeticHandler.registerCosmetic(new HeadHaloCosmetic());
        this.cosmeticHandler.registerCosmetic(new HeadNoteCosmetic());
        this.cosmeticHandler.registerCosmetic(new HeadRainCosmetic());


        this.cosmeticHandler.registerCosmetic(new ChestFlameCosmetic());
        this.cosmeticHandler.registerCosmetic(new ChestSoulFlameCosmetic());
        this.cosmeticHandler.registerCosmetic(new ChestCryObsidianCosmetic());
        this.cosmeticHandler.registerCosmetic(new ChestEndCosmetic());
        this.cosmeticHandler.registerCosmetic(new ChestSmokeCosmetic());
        this.cosmeticHandler.registerCosmetic(new ChestNoteCosmetic());
        this.cosmeticHandler.registerCosmetic(new ChestFireworkCosmetic());


        this.cosmeticHandler.registerCosmetic(new FeetSmokeCosmetic());
        this.cosmeticHandler.registerCosmetic(new FeetCryObsidianCosmetic());
        this.cosmeticHandler.registerCosmetic(new FeetMysteryCosmetic());
        this.cosmeticHandler.registerCosmetic(new FeetDragonBreathCosmetic());
        this.cosmeticHandler.registerCosmetic(new FeetToxicCosmetic());
        this.cosmeticHandler.registerCosmetic(new FeetInkCosmetic());
        this.cosmeticHandler.registerCosmetic(new FeetFlameSquareTrail());
        this.cosmeticHandler.registerCosmetic(new FeetTotemCosmetic());
        this.cosmeticHandler.registerCosmetic(new FeetSoulCosmetic());
        this.cosmeticHandler.registerCosmetic(new FeetFireworkCosmetic());


        this.cosmeticHandler.registerCosmetic(new HitAngryCosmetic());
        this.cosmeticHandler.registerCosmetic(new HitLightningCosmetic());


        this.cosmeticHandler.registerCosmetic(new KillLightningCosmetic());
        this.cosmeticHandler.registerCosmetic(new KillAnvilCosmetic());
        this.cosmeticHandler.registerCosmetic(new KillFoxCosmetic());
        this.cosmeticHandler.registerCosmetic(new KillHAKCosmetic());
        this.cosmeticHandler.registerCosmetic(new KillOazzCosmetic());


        this.cosmeticHandler.registerCosmetic(new ProjectileWaterCosmetic());
        this.cosmeticHandler.registerCosmetic(new ProjectileLavaCosmetic());
        this.cosmeticHandler.registerCosmetic(new ProjectileScrapeCosmetic());
        this.cosmeticHandler.registerCosmetic(new ProjectileVillagerCosmetic());
        this.cosmeticHandler.registerCosmetic(new ProjectileCryObsidianTrail());
        this.cosmeticHandler.registerCosmetic(new ProjectileSlimeItemCosmetic());
        this.cosmeticHandler.registerCosmetic(new ProjectileDrippingHoneyTrail());
        this.cosmeticHandler.registerCosmetic(new ProjectileWaxOnTrail());
        this.cosmeticHandler.registerCosmetic(new ProjectileWaxOffTrail());
        this.cosmeticHandler.registerCosmetic(new ProjectileFireCosmetic());
        this.cosmeticHandler.registerCosmetic(new ProjectileSoulFireCosmetic());
        this.cosmeticHandler.registerCosmetic(new ProjectileLavaTrail());
        this.cosmeticHandler.registerCosmetic(new ProjectileEntityEffectCosmetic());
        this.cosmeticHandler.registerCosmetic(new ProjectileSporeBlossemTrail());
        this.cosmeticHandler.registerCosmetic(new ProjectileStarCosmetic());
        this.cosmeticHandler.registerCosmetic(new ProjectileGlowCosmetic());
        this.cosmeticHandler.registerCosmetic(new ProjectileEndTrail());
        this.cosmeticHandler.registerCosmetic(new ProjectileWitchTrail());
        this.cosmeticHandler.registerCosmetic(new ProjectileNoteTrail());
        this.cosmeticHandler.registerCosmetic(new ProjectileFireworkCosmetic());


        this.cosmeticHandler.registerCosmetic(new ElytraAshCosmetic());
        this.cosmeticHandler.registerCosmetic(new ElytraHeartCosmetic());
        this.cosmeticHandler.registerCosmetic(new ElytraFireCosmetic());
        this.cosmeticHandler.registerCosmetic(new ElytraWitchCosmetic());
        this.cosmeticHandler.registerCosmetic(new ElytraSmokeCosmetic());
        this.cosmeticHandler.registerCosmetic(new ElytraFireworkCosmetic());
    }


    private void handleEvents() {
        Bukkit.getPluginManager().registerEvents(new PlayerHandler(), this);
        Bukkit.getPluginManager().registerEvents(new CheatGUI(), this);
        CheatGUI.loadPages();
    }

    private void handleEnchantments() {
        CustomEnchants.register(this);
        CustomEnchantmentsCMD cecmd = new CustomEnchantmentsCMD();
        getCommand("customenchantments").setExecutor(cecmd);
        getCommand("customenchantments").setTabCompleter(cecmd);
    }

    private void handleNotes() {
        NotesGUI notesGUI = new NotesGUI(this);
        Bukkit.getPluginManager().registerEvents(notesGUI, this);
        registerCommand("notes", new NotesCMD(notesGUI));
    }

    private void handleConfig() {
        new ConfigHandler(this);
    }

    private PluginCommand registerCommand(String name, TabExecutor exec) {
        getCommand(name).setExecutor(exec);
        getCommand(name).setTabCompleter(exec);
        return getCommand(name);
    }

    private PluginCommand registerCommand(String name, TabExecutor exec, String permission) {
        PluginCommand command = registerCommand(name, exec);
        command.setPermission(permission);
        command.setPermissionMessage("" + ChatColor.RED + "No permission.");
        return command;
    }
}

