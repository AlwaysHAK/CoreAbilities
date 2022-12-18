package net.alwayshak.util;

import java.util.Random;

public class Utils {
    public static boolean randomChance(int chance) {
        Random r = new Random();
        return r.nextInt(100) < chance;
    }

    public static boolean isEven(int i) {
        return i % 2 == 0;
    }
}


