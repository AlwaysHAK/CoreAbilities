package net.alwayshak.cheat;

import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.CosmeticsHandler;
import net.alwayshak.util.GUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CheatGUI
        implements Listener {
    private static final HashMap<Player, Integer> page = new HashMap<>();
    private static final List<List<ItemStack>> pages = new ArrayList<>();

    public static void loadPages() {
        int count = 0;
        List<ItemStack> list = new ArrayList<>();
        for (Cosmetic cosmetic : CosmeticsHandler.instance.getCosmetics()) {
            if (count < 28) {
                count++;
                list.add(cosmetic.getItem());
                continue;
            }
            pages.add(list);
            list = new ArrayList<>();
            list.add(cosmetic.getItem());
            count = 1;
        }


        System.out.println(pages.size());
    }

    public static void openAllCosmetics(Player p, int page) {
        Inventory inv = GUI.getBordersFullSized("All Cosmetics");

        int i = 0;
        for (ItemStack stack : pages.get(page)) {
            inv.addItem(stack);
            i++;
        }

        System.out.println(i);

        p.openInventory(inv);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        InventoryView view = e.getView();

        if (view.getTitle().equalsIgnoreCase("All Cosmetics")) {
            e.setCancelled(true);
        }
    }
}

