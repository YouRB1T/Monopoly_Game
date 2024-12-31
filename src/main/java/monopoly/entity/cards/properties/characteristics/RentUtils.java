package monopoly.entity.cards.properties.characteristics;

import java.util.HashMap;

import java.util.HashMap;
import java.util.function.Function;

public class RentUtils {

    public static void fillRent(Rent rent, int maxLevel) {
        HashMap<Integer, Integer> rentMap = new HashMap<>();

        for (int level = 1; level <= maxLevel; level++) {
            int rentValue = calculateRent(level);
            rentMap.put(level, rentValue);
        }

        rent.setRentByLevel(rentMap);
    }

    private static int calculateRent(int level) {
        return level * 100;
    }

    public void fillTestRent(Rent rent) {
        HashMap<Integer, Integer> rentMap = new HashMap<>();

        rentMap.put(1, 100);
        rentMap.put(2, 200);
        rentMap.put(3, 300);
        rentMap.put(4, 400);
        rentMap.put(5, 500);

        rent.setRentByLevel(rentMap);
    }

    public static void fillRentWithBasePrice(Rent rent, int maxLevel, int basePrice) {
        HashMap<Integer, Integer> rentMap = new HashMap<>();

        for (int level = 1; level <= maxLevel; level++) {
            int rentValue = level * basePrice;
            rentMap.put(level, rentValue);
        }

        rent.setRentByLevel(rentMap);
    }

    public static void fillRentWithCustomCalculation(Rent rent, int maxLevel,
                                                     Function<Integer, Integer> rentCalculator) {
        HashMap<Integer, Integer> rentMap = new HashMap<>();

        for (int level = 1; level <= maxLevel; level++) {
            int rentValue = rentCalculator.apply(level);
            rentMap.put(level, rentValue);
        }

        rent.setRentByLevel(rentMap);
    }
}

