package net.alwayshak.lootcrate;

import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.CosmeticsHandler;
import net.alwayshak.cosmetics.Rarity;
import net.alwayshak.events.PlayerHandler;
import net.alwayshak.util.GUI;
import net.alwayshak.util.Materials;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;


public class Lootcrate
        implements Listener {
    private static final CosmeticsHandler handler = CosmeticsHandler.instance;

    public static void openChoose(Player p) {
        Inventory inv = GUI.getFullHalfSized("Choose Rarity");

        String pattern = "###,###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        int tokens = PlayerHandler.tokens.get(p).intValue();

        inv.setItem(4, Materials.getSimpleItem("&7Tokens", Material.PAPER, "&fYou have &a" + decimalFormat.format(tokens)));

        inv.setItem(11, Materials.getSimpleItem("&7Common", (tokens < 10000) ? Material.BARRIER : Material.LIGHT_GRAY_WOOL, "&fCosts &a10,000 &ftokens"));
        inv.setItem(12, Materials.getSimpleItem("&8Uncommon", (tokens < 25000) ? Material.BARRIER : Material.GRAY_WOOL, "&fCosts &a25,000 &ftokens"));
        inv.setItem(13, Materials.getSimpleItem("&9Rare", (tokens < 50000) ? Material.BARRIER : Material.CYAN_WOOL, "&fCosts &a50,000 &ftokens"));
        inv.setItem(14, Materials.getSimpleItem("&5Epic", (tokens < 100000) ? Material.BARRIER : Material.PURPLE_WOOL, "&fCosts &a100,000 &ftokens"));
        inv.setItem(15, Materials.getSimpleItem("&6Legendary", (tokens < 500000) ? Material.BARRIER : Material.YELLOW_WOOL, "&fCosts &a500,000 &ftokens"));

        p.openInventory(inv);
    }

    public static void open(Player p, Rarity rarity) {
        Inventory inv = GUI.getLootCrateInventory(rarity.getMat1(), rarity.getMat2(), ChatColor.stripColor(rarity.getName()));
        ItemStack stack = getItemForBox(p, rarity);
        inv.setItem(13, stack);
        Cosmetic byName = handler.getCosmeticByName(stack.getItemMeta().getDisplayName());
        if (byName != null) {
            byName.addUnlocked(p);
        } else {
            int stripTokens = Integer.valueOf(ChatColor.stripColor(stack.getItemMeta().getDisplayName()).split(" ")[0]).intValue();
            PlayerHandler.tokens.put(p, Integer.valueOf(PlayerHandler.tokens.get(p).intValue() + stripTokens));
        }
        p.openInventory(inv);
    }

    public static ItemStack getItemForBox(Player p, Rarity rarity) {
        Random random = new Random();
        if (rarity == Rarity.COMMON) {
            int tokenChance = random.nextInt(10);
            if (tokenChance < 2) {
                int tokens = getRandomTokenAmount(1000, 8000);
                return Materials.getSimpleItem("&a" + tokens + " tokens", Material.PAPER);
            }
            int cosmeticChance = random.nextInt(100000);
            if (cosmeticChance < 1 && handler.getLockedCosmetics(p, Rarity.LEGENDARY).size() > 0) {
                List<Cosmetic> unlockables = handler.getLockedCosmetics(p, Rarity.LEGENDARY);
                return unlockables.get(random.nextInt(unlockables.size())).getItem();
            }
            if (cosmeticChance < 2001 && handler.getLockedCosmetics(p, Rarity.EPIC).size() > 0) {
                List<Cosmetic> unlockables = handler.getLockedCosmetics(p, Rarity.EPIC);
                return unlockables.get(random.nextInt(unlockables.size())).getItem();
            }
            if (cosmeticChance < 10000 && handler.getLockedCosmetics(p, Rarity.RARE).size() > 0) {
                List<Cosmetic> unlockables = handler.getLockedCosmetics(p, Rarity.RARE);
                return unlockables.get(random.nextInt(unlockables.size())).getItem();
            }
            if (cosmeticChance < 39901 && handler.getLockedCosmetics(p, Rarity.UNCOMMON).size() > 0) {
                List<Cosmetic> unlockables = handler.getLockedCosmetics(p, Rarity.UNCOMMON);
                return unlockables.get(random.nextInt(unlockables.size())).getItem();
            }
            if (cosmeticChance < 98101 && handler.getLockedCosmetics(p, Rarity.COMMON).size() > 0) {
                List<Cosmetic> unlockables = handler.getLockedCosmetics(p, Rarity.COMMON);
                return unlockables.get(random.nextInt(unlockables.size())).getItem();
            }

        } else if (rarity == Rarity.UNCOMMON) {
            int tokenChance = random.nextInt(10);
            if (tokenChance < 1) {
                int tokens = getRandomTokenAmount(10000, 40000);
                return Materials.getSimpleItem("&a" + tokens + " tokens", Material.PAPER);
            }
            int cosmeticChance = random.nextInt(10000);
            if (cosmeticChance < 1 && handler.getLockedCosmetics(p, Rarity.LEGENDARY).size() > 0) {
                List<Cosmetic> unlockables = handler.getLockedCosmetics(p, Rarity.LEGENDARY);
                return unlockables.get(random.nextInt(unlockables.size())).getItem();
            }
            if (cosmeticChance < 501 && handler.getLockedCosmetics(p, Rarity.EPIC).size() > 0) {
                List<Cosmetic> unlockables = handler.getLockedCosmetics(p, Rarity.EPIC);
                return unlockables.get(random.nextInt(unlockables.size())).getItem();
            }
            if (cosmeticChance < 1500 && handler.getLockedCosmetics(p, Rarity.RARE).size() > 0) {
                List<Cosmetic> unlockables = handler.getLockedCosmetics(p, Rarity.RARE);
                return unlockables.get(random.nextInt(unlockables.size())).getItem();
            }
            if (cosmeticChance < 4000 && handler.getLockedCosmetics(p, Rarity.COMMON).size() > 0) {
                List<Cosmetic> unlockables = handler.getLockedCosmetics(p, Rarity.COMMON);
                return unlockables.get(random.nextInt(unlockables.size())).getItem();
            }
            if (cosmeticChance < 10000 && handler.getLockedCosmetics(p, Rarity.UNCOMMON).size() > 0) {
                List<Cosmetic> unlockables = handler.getLockedCosmetics(p, Rarity.UNCOMMON);
                return unlockables.get(random.nextInt(unlockables.size())).getItem();
            }

        } else if (rarity == Rarity.EPIC) {
            int tokenChance = random.nextInt(10);
            if (tokenChance < 1) {
                int tokens = getRandomTokenAmount(40000, 80000);
                return Materials.getSimpleItem("&a" + tokens + " tokens", Material.PAPER);
            }
            int cosmeticChance = random.nextInt(1000);
            if (cosmeticChance < 50 && handler.getLockedCosmetics(p, Rarity.LEGENDARY).size() > 0) {
                List<Cosmetic> unlockables = handler.getLockedCosmetics(p, Rarity.LEGENDARY);
                return unlockables.get(random.nextInt(unlockables.size())).getItem();
            }
            if (cosmeticChance < 100 && handler.getLockedCosmetics(p, Rarity.COMMON).size() > 0) {
                List<Cosmetic> unlockables = handler.getLockedCosmetics(p, Rarity.COMMON);
                return unlockables.get(random.nextInt(unlockables.size())).getItem();
            }
            if (cosmeticChance < 200 && handler.getLockedCosmetics(p, Rarity.UNCOMMON).size() > 0) {
                List<Cosmetic> unlockables = handler.getLockedCosmetics(p, Rarity.UNCOMMON);
                return unlockables.get(random.nextInt(unlockables.size())).getItem();
            }
            if (cosmeticChance < 400 && handler.getLockedCosmetics(p, Rarity.RARE).size() > 0) {
                List<Cosmetic> unlockables = handler.getLockedCosmetics(p, Rarity.RARE);
                return unlockables.get(random.nextInt(unlockables.size())).getItem();
            }
            if (cosmeticChance < 1000 && handler.getLockedCosmetics(p, Rarity.EPIC).size() > 0) {
                List<Cosmetic> unlockables = handler.getLockedCosmetics(p, Rarity.EPIC);
                return unlockables.get(random.nextInt(unlockables.size())).getItem();
            }

        } else if (rarity == Rarity.RARE) {
            int tokenChance = random.nextInt(10);
            if (tokenChance < 1) {
                int tokens = getRandomTokenAmount(100000, 180000);
                return Materials.getSimpleItem("&a" + tokens + " tokens", Material.PAPER);
            }
            int cosmeticChance = random.nextInt(1000);
            if (cosmeticChance < 1 && handler.getLockedCosmetics(p, Rarity.LEGENDARY).size() > 0) {
                List<Cosmetic> unlockables = handler.getLockedCosmetics(p, Rarity.LEGENDARY);
                return unlockables.get(random.nextInt(unlockables.size())).getItem();
            }
            if (cosmeticChance < 100 && handler.getLockedCosmetics(p, Rarity.EPIC).size() > 0) {
                List<Cosmetic> unlockables = handler.getLockedCosmetics(p, Rarity.EPIC);
                return unlockables.get(random.nextInt(unlockables.size())).getItem();
            }
            if (cosmeticChance < 200 && handler.getLockedCosmetics(p, Rarity.COMMON).size() > 0) {
                List<Cosmetic> unlockables = handler.getLockedCosmetics(p, Rarity.COMMON);
                return unlockables.get(random.nextInt(unlockables.size())).getItem();
            }
            if (cosmeticChance < 400 && handler.getLockedCosmetics(p, Rarity.UNCOMMON).size() > 0) {
                List<Cosmetic> unlockables = handler.getLockedCosmetics(p, Rarity.UNCOMMON);
                return unlockables.get(random.nextInt(unlockables.size())).getItem();
            }
            if (cosmeticChance < 1000 && handler.getLockedCosmetics(p, Rarity.RARE).size() > 0) {
                List<Cosmetic> unlockables = handler.getLockedCosmetics(p, Rarity.RARE);
                return unlockables.get(random.nextInt(unlockables.size())).getItem();
            }

        } else if (rarity == Rarity.LEGENDARY) {
            int cosmeticChance = random.nextInt(100);
            if (cosmeticChance < 98) {
                List<Cosmetic> unlockables = handler.getLockedCosmetics(p, Rarity.LEGENDARY);
                return unlockables.get(random.nextInt(unlockables.size())).getItem();
            }
            if (cosmeticChance < 99) {
                List<Cosmetic> unlockables = handler.getLockedCosmetics(p, Rarity.EPIC);
                return unlockables.get(random.nextInt(unlockables.size())).getItem();
            }
        }
        return Materials.getSimpleItem("&a50000 tokens", Material.PAPER);
    }

    public static int getRandomTokenAmount(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min) + min;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        String title = e.getView().getTitle();
        if (title.equalsIgnoreCase("UNCOMMON") || title.equalsIgnoreCase("COMMON") || title.equalsIgnoreCase("RARE") || title.equalsIgnoreCase("EPIC") || title.equalsIgnoreCase("LEGENDARY") || title.equalsIgnoreCase("LIMITED")) {
            e.setCancelled(true);
        } else if (title.equalsIgnoreCase("Choose Rarity")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
                ItemStack stack = e.getCurrentItem();
                ItemMeta meta = stack.getItemMeta();

                if (meta.getDisplayName().equalsIgnoreCase(c("&cClose"))) {
                    e.getWhoClicked().closeInventory();
                }

                if (meta.hasLore()) {
                    if (e.getCurrentItem().getType() == Material.LIGHT_GRAY_WOOL) {
                        open((Player) e.getWhoClicked(), Rarity.COMMON);
                        PlayerHandler.tokens.put((Player) e.getWhoClicked(), Integer.valueOf(PlayerHandler.tokens.get(e.getWhoClicked()).intValue() - 10000));
                    } else if (e.getCurrentItem().getType() == Material.GRAY_WOOL) {
                        open((Player) e.getWhoClicked(), Rarity.UNCOMMON);
                        PlayerHandler.tokens.put((Player) e.getWhoClicked(), Integer.valueOf(PlayerHandler.tokens.get(e.getWhoClicked()).intValue() - 25000));
                    }
                    if (e.getCurrentItem().getType() == Material.CYAN_WOOL) {
                        open((Player) e.getWhoClicked(), Rarity.RARE);
                        PlayerHandler.tokens.put((Player) e.getWhoClicked(), Integer.valueOf(PlayerHandler.tokens.get(e.getWhoClicked()).intValue() - 50000));
                    }
                    if (e.getCurrentItem().getType() == Material.PURPLE_WOOL) {
                        open((Player) e.getWhoClicked(), Rarity.EPIC);
                        PlayerHandler.tokens.put((Player) e.getWhoClicked(), Integer.valueOf(PlayerHandler.tokens.get(e.getWhoClicked()).intValue() - 100000));
                    }
                    if (e.getCurrentItem().getType() == Material.YELLOW_WOOL) {
                        open((Player) e.getWhoClicked(), Rarity.LEGENDARY);
                        PlayerHandler.tokens.put((Player) e.getWhoClicked(), Integer.valueOf(PlayerHandler.tokens.get(e.getWhoClicked()).intValue() - 500000));
                    }
                }
            }
        }
    }

    private String c(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}


