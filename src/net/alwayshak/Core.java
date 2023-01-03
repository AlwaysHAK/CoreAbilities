package net.alwayshak;

import net.alwayshak.abilities.*;
import net.alwayshak.abilities.season1.*;
import net.alwayshak.abilities.season2.*;
import net.alwayshak.cheat.ResetCosmeticsCMD;
import net.alwayshak.config.ConfigHandler;
import net.alwayshak.config.ReloadConfigCMD;
import net.alwayshak.cosmetics.CosmeticsHandler;
import net.alwayshak.cosmetics.chest.*;
import net.alwayshak.cosmetics.death.KillAnvilCosmetic;
import net.alwayshak.cosmetics.death.KillExplosionCosmetic;
import net.alwayshak.cosmetics.death.KillLightningCosmetic;
import net.alwayshak.cosmetics.elytra.*;
import net.alwayshak.cosmetics.feet.*;
import net.alwayshak.cosmetics.gui.CosmeticsCMD;
import net.alwayshak.cosmetics.gui.CosmeticsGUI;
import net.alwayshak.cosmetics.head.*;
import net.alwayshak.cosmetics.hit.HitAngryCosmetic;
import net.alwayshak.cosmetics.hit.HitBubblesCosmetic;
import net.alwayshak.cosmetics.hit.HitLightningCosmetic;
import net.alwayshak.cosmetics.projectile.*;
import net.alwayshak.cosmetics.special.KillFoxCosmetic;
import net.alwayshak.cosmetics.special.KillHAKCosmetic;
import net.alwayshak.cosmetics.special.KillOazzCosmetic;
import net.alwayshak.enchantments.EnchantCMD;
import net.alwayshak.enchantments.EnchantHandler;
import net.alwayshak.enchantments.enchants.ExperienceEnchant;
import net.alwayshak.enchantments.enchants.shooter.*;
import net.alwayshak.enchantments.enchants.tools.*;
import net.alwayshak.enchantments.enchants.weapons.*;
import net.alwayshak.events.EntityHandler;
import net.alwayshak.events.PlayerHandler;
import net.alwayshak.lootcrate.Lootcrate;
import net.alwayshak.lootcrate.LootcrateCMD;
import net.alwayshak.lootcrate.TokenCMD;
import net.alwayshak.notes.NotesCMD;
import net.alwayshak.notes.NotesGUI;
import net.alwayshak.webserver.WebServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    private AbilityHandler abilityHandler;
    private CosmeticsHandler cosmeticHandler;

    private WebServer webServer;

    public void onEnable() {
        handleConfig();
        handleAbilities();
        handleCosmetics();
        handleEnchantments();
        handleCommands();
        handleNotes();
        handleEvents();

        webServer = new WebServer();
        webServer.start();

        for (Player p : Bukkit.getOnlinePlayers()) {
            this.cosmeticHandler.loadCosmetics(p);
            PlayerHandler.loadTokens(p);
        }
    }

    public void onDisable() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            this.cosmeticHandler.saveCosmetics(p);
            PlayerHandler.saveTokens(p);
        }
        webServer.stop();
    }

    private void handleCommands() {
        registerCommand("reloadconfig", new ReloadConfigCMD(), "coreabilities.reload");
        registerCommand("tokens", new TokenCMD());
        registerCommand("lootcrate", new LootcrateCMD());
        registerCommand("resetcosmetics", new ResetCosmeticsCMD());
        registerCommand("customenchant", new EnchantCMD());
    }

    private void handleAbilities() {
        abilityHandler = new AbilityHandler(this);
        Bukkit.getPluginManager().registerEvents(abilityHandler, this);
        /*
        abilityHandler.registerAbility(new MagnetAbility("Magnet", "You auto-pickup items you mine."));
        abilityHandler.registerAbility(new CatAbility("Cat", "You take half fall damage and creepers don't target you."));
        abilityHandler.registerAbility(new VeinMinerAbility("VeinMiner", "Vein mines ores and trees."));
        abilityHandler.registerAbility(new TeleportBowAbility("DoubleJump", "Makes you do an epic thing yay."));
        abilityHandler.registerAbility(new ToolRegenAbility("ToolRegen", "Regens your tool every X seconds."));
        abilityHandler.registerAbility(new LuckyBastardAbility("LuckyFuck", "You always have fortune 3 (it stacks with the fortune enchantment)."));
        abilityHandler.registerAbility(new InvisibilityAbility("Invisibility", "Turn invisible when sneaking."));
        abilityHandler.registerAbility(new InvKeepAbility("KeepInv", "Keeps your first slot and levels upon dying."));
        abilityHandler.registerAbility(new ReducedCooldownAbility("ReducedCooldown", "Reduces combat cooldown."));
        abilityHandler.registerAbility(new ConduitAbility("Conduit", "You get conduit when in water."));
        abilityHandler.registerAbility(new HasteAbility("Haste", "You have permanent haste!"));
        abilityHandler.registerAbility(new FeedAbility("Feed", "You get fed"));
        abilityHandler.registerAbility(new PhaserAbility("Phaser", "You can phase through blocks"));
        */
        abilityHandler.registerAbility(new VayuAbility("Vayu", "You have can double jump"));
        abilityHandler.registerAbility(new BigBoyAbility("Big Boy", "You get more health and do more damage"));
        abilityHandler.registerAbility(new ZeusAbility("Zeus", "You strike lightning in an x radius"));
        abilityHandler.registerAbility(new MinerAbility("Miner", "You mine in a 3x3 radius"));
        abilityHandler.registerAbility(new ThothAbility("Thoth", "You can manipulate time"));
        abilityHandler.registerAbility(new VexAbility("Vex", "You are a vex"));
    }


    private void handleCosmetics() {
        cosmeticHandler = new CosmeticsHandler(this);
        CosmeticsGUI cosmeticsGUI = new CosmeticsGUI(this, cosmeticHandler);
        registerCommand("cosmetics", new CosmeticsCMD(cosmeticsGUI));
        Bukkit.getPluginManager().registerEvents(this.cosmeticHandler, this);
        Bukkit.getPluginManager().registerEvents(new Lootcrate(), this);

        // Head
        cosmeticHandler.registerCosmetic(new HeadFallingWaterCosmetic());
        cosmeticHandler.registerCosmetic(new HeadFallingLavaCosmetic());
        cosmeticHandler.registerCosmetic(new HeadFallingDripLavaCosmetic());
        cosmeticHandler.registerCosmetic(new HeadFallingDripWaterCosmetic());
        cosmeticHandler.registerCosmetic(new HeadFlameCosmetic());
        cosmeticHandler.registerCosmetic(new HeadSeaCosmetic());
        cosmeticHandler.registerCosmetic(new HeadHeartCosmetic());
        cosmeticHandler.registerCosmetic(new HeadEnderCosmetic());
        cosmeticHandler.registerCosmetic(new HeadDamageCosmetic());
        cosmeticHandler.registerCosmetic(new HeadHaloCosmetic());
        cosmeticHandler.registerCosmetic(new HeadNoteCosmetic());
        cosmeticHandler.registerCosmetic(new HeadRainCosmetic());

        // Chest
        cosmeticHandler.registerCosmetic(new ChestFlameCosmetic());
        cosmeticHandler.registerCosmetic(new ChestSoulFlameCosmetic());
        cosmeticHandler.registerCosmetic(new ChestCryObsidianCosmetic());
        cosmeticHandler.registerCosmetic(new ChestEndCosmetic());
        cosmeticHandler.registerCosmetic(new ChestSmokeCosmetic());
        cosmeticHandler.registerCosmetic(new ChestNoteCosmetic());
        cosmeticHandler.registerCosmetic(new ChestFireworkCosmetic());

        // Feet
        cosmeticHandler.registerCosmetic(new FeetSmokeCosmetic());
        cosmeticHandler.registerCosmetic(new FeetCryObsidianCosmetic());
        cosmeticHandler.registerCosmetic(new FeetMysteryCosmetic());
        cosmeticHandler.registerCosmetic(new FeetDragonBreathCosmetic());
        cosmeticHandler.registerCosmetic(new FeetToxicCosmetic());
        cosmeticHandler.registerCosmetic(new FeetInkCosmetic());
        cosmeticHandler.registerCosmetic(new FeetFlameSquareTrail());
        cosmeticHandler.registerCosmetic(new FeetTotemCosmetic());
        cosmeticHandler.registerCosmetic(new FeetSoulCosmetic());
        cosmeticHandler.registerCosmetic(new FeetFireworkCosmetic());

        // Hit
        cosmeticHandler.registerCosmetic(new HitAngryCosmetic());
        cosmeticHandler.registerCosmetic(new HitLightningCosmetic());
        cosmeticHandler.registerCosmetic(new HitBubblesCosmetic());

        // Kill
        cosmeticHandler.registerCosmetic(new KillLightningCosmetic());
        cosmeticHandler.registerCosmetic(new KillAnvilCosmetic());
        cosmeticHandler.registerCosmetic(new KillFoxCosmetic());
        cosmeticHandler.registerCosmetic(new KillHAKCosmetic());
        cosmeticHandler.registerCosmetic(new KillOazzCosmetic());
        cosmeticHandler.registerCosmetic(new KillExplosionCosmetic());

        // Projectile
        cosmeticHandler.registerCosmetic(new ProjectileWaterCosmetic());
        cosmeticHandler.registerCosmetic(new ProjectileLavaCosmetic());
        cosmeticHandler.registerCosmetic(new ProjectileScrapeCosmetic());
        cosmeticHandler.registerCosmetic(new ProjectileVillagerCosmetic());
        cosmeticHandler.registerCosmetic(new ProjectileCryObsidianTrail());
        cosmeticHandler.registerCosmetic(new ProjectileSlimeItemCosmetic());
        cosmeticHandler.registerCosmetic(new ProjectileDrippingHoneyTrail());
        cosmeticHandler.registerCosmetic(new ProjectileWaxOnTrail());
        cosmeticHandler.registerCosmetic(new ProjectileWaxOffTrail());
        cosmeticHandler.registerCosmetic(new ProjectileFireCosmetic());
        cosmeticHandler.registerCosmetic(new ProjectileSoulFireCosmetic());
        cosmeticHandler.registerCosmetic(new ProjectileLavaTrail());
        cosmeticHandler.registerCosmetic(new ProjectileEntityEffectCosmetic());
        cosmeticHandler.registerCosmetic(new ProjectileSporeBlossemTrail());
        cosmeticHandler.registerCosmetic(new ProjectileStarCosmetic());
        cosmeticHandler.registerCosmetic(new ProjectileGlowCosmetic());
        cosmeticHandler.registerCosmetic(new ProjectileEndTrail());
        cosmeticHandler.registerCosmetic(new ProjectileWitchTrail());
        cosmeticHandler.registerCosmetic(new ProjectileNoteTrail());
        cosmeticHandler.registerCosmetic(new ProjectileFireworkCosmetic());

        // Elytra
        cosmeticHandler.registerCosmetic(new ElytraAshCosmetic());
        cosmeticHandler.registerCosmetic(new ElytraHeartCosmetic());
        cosmeticHandler.registerCosmetic(new ElytraFireCosmetic());
        cosmeticHandler.registerCosmetic(new ElytraWitchCosmetic());
        cosmeticHandler.registerCosmetic(new ElytraSmokeCosmetic());
        cosmeticHandler.registerCosmetic(new ElytraFireworkCosmetic());
        cosmeticHandler.registerCosmetic(new ElytraEndCosmetic());
    }


    private void handleEvents() {
        Bukkit.getPluginManager().registerEvents(new PlayerHandler(), this);
        Bukkit.getPluginManager().registerEvents(new EntityHandler(), this);
    }

    private void handleEnchantments() {
        //enchantHandler = new EnchantHandler();
        EnchantHandler handler = new EnchantHandler();
        handler.register(new TelekenisisEnchant("telekenisis", "Telekenisis","Grab blocks into your inventory", 1));
        handler.register(new AutoSmeltEnchant("autosmelt", "Auto Smelt", "Smelt items automaticly when mined", 1));
        handler.register(new ExplosiveTipEnchant("explosive_tip", "Explosive Tip","Explode on impact", 1));
        handler.register(new BurstEnchantment("burst", "Burst","Shoot more arrows", 3));
        handler.register(new ZeroGravityArrowEnchant("zero_gravity", "Zero Gravity","Give shot arrows not gravity", 1));
        handler.register(new CutCleanEnchant("cut_clean", "Cut Clean","Break glass fast", 1));
        handler.register(new ObsidianDestroyerEnchant("obsidian_destroyer", "Obsidian Destroyer","Break some Obsidian instant", 1));
        handler.register(new FrostArrowEnchant("frost", "Frost","Give the entity hit the frost and slowness effect", 1));
        handler.register(new ViperEnchant("viper", "Viper","Chance to give attacked entity poison", 3));
        handler.register(new VampireEnchant("vampire", "Vampire","Get health back when hitting something", 7));
        handler.register(new ConfusionEnchant("confusion", "Confusion","Chance to give attacked entity nausia", 3));
        handler.register(new BlindEnchant("blind", "Blind","Chance to give attacked entity blindness", 3));
        handler.register(new OxegeniateEnchant("oxegeniate", "Oxegeniate","Get oxygen while mining underwater", 1));
        handler.register(new ExperienceEnchant("experience", "Experience","Get more experience points", 3));
        handler.register(new LightningEnchant("lightning", "Lightning","Chance to spawn lightning on hit", 3));
        handler.register(new ReplantEnchant("replant", "Replant","Replant crops when harvested", 1));
        handler.register(new AquaAspectEnchant("aqua_aspect", "Aqua Aspect","Do more damage against anti-water mobs", 2));
        handler.register(new EnderSlayerEnchant("ender_slayer", "Ender Slayer","Do more damage against end mobs", 5));
        handler.register(new NightOwlEnchant("night_owl", "Night Owl","Do more damage against mobs at night", 5));
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

