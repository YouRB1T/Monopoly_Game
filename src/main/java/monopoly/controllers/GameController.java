package monopoly.controllers;

import monopoly.builders.ClassicGameBuilder;
import monopoly.builders.GameBuilder;
import monopoly.entity.Board;
import monopoly.entity.roles.Player;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GameController {
    private boolean gameOver;
    private GameBuilder gameBuilder;
    private Board board;
    private Scanner scanner;
    private PlayerController playerController;


    public GameController() {
        gameOver = false;
        board = new Board();
        scanner = new Scanner(System.in);

    }


    public void startGame() {
        System.out.println("Rules: C(Classic) / E(Enother)");
        String rules = scanner.nextLine();
        switch (rules) {
            case "C":
                gameBuilder = new ClassicGameBuilder();
                board = gameBuilder.getBoard();
            case "E":
                System.out.println("Someday new rules will be invented.");
        }

        System.out.println("Write nums of players:");

        int playerCount = scanner.nextInt();

        Queue<Player> players = new LinkedList<>();

        for (int i = 0; i < playerCount; i++) {
            System.out.println("Print nickname " + i + " player:");
            String name = scanner.nextLine();
            players.offer(new Player(name));
        }

        playerController = new PlayerController(players);

        System.out.println("Все игроки");
        players.forEach(player -> {
            System.out.println(player.getName());
        });

        while (!gameOver) {
            // Стартует игра по определенным правилам
            game(board, players);
        }
    }

    public void game(Board board, Queue<Player> players) {

    }
}
