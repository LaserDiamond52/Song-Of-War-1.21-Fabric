package net.laserdiamond.util;

import java.util.Random;

public class SOWMath {

    public static int getRandomInt(int max, boolean inclusive)
    {
        Random random = new Random();
        if (inclusive)
        {
            return random.nextInt(max + 1);
        }
        return random.nextInt(max);
    }
}
