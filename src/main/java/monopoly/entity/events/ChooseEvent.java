package monopoly.entity.events;

import java.util.Scanner;

public class ChooseEvent {
    public boolean choose(String text) {

        System.out.println(text);
        System.out.println("Y / N");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext("Y")) {
            return true;
        } else {
            return false;
        }
    }
}
