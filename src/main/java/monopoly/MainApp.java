package monopoly;

import monopoly.controllers.GameController;

import java.util.Scanner;

public class MainApp {

    private static Scanner scanner = new Scanner(System.in);
    private static GameController gameController = new GameController();

    public static void main(String[] args) {

        System.out.println("Do you want to play monopoly?");
        System.out.println("Y / N");
        if (scanner.nextLine().equals("Y")) {
            gameController.startGame();
        }

    }
}
