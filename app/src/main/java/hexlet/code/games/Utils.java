package hexlet.code.games;

import java.util.Random;

public class Utils {
    public static int createRandomNum(int maxNum, int minNum) {
        Random random = new Random();

        return random.nextInt(maxNum) + minNum;
    }

    public static int createRandomNum(int maxNum) {
        Random random = new Random();

        return random.nextInt(maxNum);
    }
}
