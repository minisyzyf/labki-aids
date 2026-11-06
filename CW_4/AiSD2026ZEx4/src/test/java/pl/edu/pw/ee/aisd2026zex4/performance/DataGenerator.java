package pl.edu.pw.ee.aisd2026zex4.performance;

import java.util.Random;

public class DataGenerator {
    public String[] generateRandData(int size) {
        validateSize(size);

        Random random = new Random();
        String[] data = new String[size];
        for (int i = 0; i < size; i++) {
            data[i] = String.format("%08d", random.nextInt(99999999));
        }
        return data;
    }

    public String[] generateAscData(int size) {
        validateSize(size);

        String[] data = new String[size];
        for (int i = 0; i < size; i++) {
            data[i] = String.format("%08d", i);
        }
        return data;
    }

    public String[] generateDescData(int size) {
        validateSize(size);

        String[] data = new String[size];
        for (int i = 0; i < size; i++) {
            data[i] = String.format("%08d", size - i - 1);
        }
        return data;
    }

    private void validateSize(int size) {
        if (size <= 0 || size > 99999999) {
            throw new IllegalArgumentException("Size must be positive and less than 100 million");
        }
    }
}
