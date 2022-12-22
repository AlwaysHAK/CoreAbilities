package net.alwayshak.util;

import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

import java.util.Random;

public class Utils {
    public static boolean randomChance(int chance) {
        Random r = new Random();
        return r.nextInt(100) < chance;
    }

    public static boolean isEven(int i) {
        return i % 2 == 0;
    }

    public static BlockFace getPlayerFacing(Player p) {
        if(p.getLocation().getPitch() > 45) return BlockFace.DOWN;
        if(p.getLocation().getPitch() < -45) return BlockFace.UP;
        return p.getFacing();
    }
}


