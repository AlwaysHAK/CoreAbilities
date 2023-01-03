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

    public static String toRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLetters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder roman = new StringBuilder();
        for(int i=0;i<values.length;i++)
        {
            while(num >= values[i])
            {
                num = num - values[i];
                roman.append(romanLetters[i]);
            }
        }
        return roman.toString();
    }

    public static BlockFace getPlayerFacing(Player p) {
        if(p.getLocation().getPitch() > 45) return BlockFace.DOWN;
        if(p.getLocation().getPitch() < -45) return BlockFace.UP;
        return p.getFacing();
    }
}


