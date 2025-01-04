package monopoly.entity.cards.properties.characteristics;

import java.util.HashMap;
import java.util.Map;

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

    public Integer getRentByLevel(Integer level) {
        return rentByLevel.get(level);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rent by Level:\n");
        for (Map.Entry<Integer, Integer> entry : rentByLevel.entrySet()) {
            sb.append("Level ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}
