package monopoly.controllers;

import monopoly.entity.roles.Player;

import java.util.LinkedList;
import java.util.Queue;

public class PlayerController {
    private final Queue<Player> players;

    public PlayerController() {
        players = new LinkedList<>();
    }

    public PlayerController(Queue<Player> players) {
        this.players = players;
    }

    public Queue<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.offer(player);
    }

   public void deleteFirstPlayer() {
        players.poll();
   }

   public void executePlayerMove() {

   }
}
