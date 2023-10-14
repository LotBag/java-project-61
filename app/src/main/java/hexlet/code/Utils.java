package hexlet.code;

import java.util.Random;

public class Utils {
    private static final Random RANDOM = new Random();
    public static int createRandomNum(int maxNum, int minNum) {
        return RANDOM.nextInt(maxNum) + minNum;
    }

    public static int createRandomNum(int maxNum) {
        return RANDOM.nextInt(maxNum);
    }
}
