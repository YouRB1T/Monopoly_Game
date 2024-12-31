package monopoly.entity.cards.properties.characteristics;

import java.util.HashMap;

public class Rent {
    private HashMap<Integer, Integer> rentByLevel;

    public Rent() {
    }

    public Rent(HashMap<Integer, Integer> rentByLevel) {
        this.rentByLevel = rentByLevel;
    }

    public HashMap<Integer, Integer> getRentByLevel() {
        return rentByLevel;
    }

    public void setRentByLevel(HashMap<Integer, Integer> rentByLevel) {
        this.rentByLevel = rentByLevel;
    }

    public void setRentOnTheLevel(Integer level, Integer rent) {
        if (rentByLevel.containsKey(level)) {
            rentByLevel.put(level, rent);
        } else {
            rentByLevel.put(level, rent);
        }
    }
}
