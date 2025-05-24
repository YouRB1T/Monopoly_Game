package monopoly.controllers;

import monopoly.builders.GameBuilder;
import monopoly.entity.Board;
import monopoly.entity.roles.Player;

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

        scanner = new Scanner(System.in);

    }


    public void startGame() {
        System.out.println("Rules: C(Classic) / E(Enother)");
        String rules = scanner.nextLine();


        System.out.println("Write nums of players:");

        int playerCount = scanner.nextInt();

        Queue<Player> players = new LinkedList<>();



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
