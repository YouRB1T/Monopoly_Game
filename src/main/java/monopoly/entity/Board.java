package monopoly.entity;

import monopoly.entity.cards.Card;
import monopoly.entity.cards.CardAction;
import monopoly.entity.cards.CardStorage;
import monopoly.entity.cards.properties.PropertyCard;
import monopoly.entity.cards.properties.PropertyGroup;
import monopoly.entity.roles.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class Board {
    private final HashMap<Integer, Card> board;
    private final HashMap<Player, Integer> playerPosition;
    private final TreeMap<Integer, Player> playersCards;
    private List<PropertyGroup> propertyGroups;
    private int maxSize;

    public Board() {
        board = new HashMap<>();
        playerPosition = new HashMap<>();
        playersCards = new TreeMap<>();
        propertyGroups = new ArrayList<>();
    }

    public Board(HashMap<Integer, Card> board) {
        this.board = board;
        maxSize = 0;
        playerPosition = new HashMap<>();
        playersCards = new TreeMap<>();
        propertyGroups = new ArrayList<>();
    }

    public HashMap<Integer, Card> getBoard() {
        return board;
    }

    public void addCard(Integer numCard, Card card) {
        board.put(numCard, card);
        maxSize = numCard;
    }

    public Card getCard(Integer numCard) {
        return board.get(numCard);
    }

    public int getMaxSize() {
        return maxSize;
    }

    public HashMap<Player, Integer> getPlayerPosition() {
        return playerPosition;
    }

    public TreeMap<Integer, Player> getPlayersCards() {
        return playersCards;
    }

    public List<PropertyGroup> getPropertyGroups() {
        return propertyGroups;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public Integer getPlayerPosition(Player player) {
        return playerPosition.get(player);
    }

    public void setPropertyGroups(List<PropertyGroup> propertyGroups) {
        this.propertyGroups = propertyGroups;
    }

    public void setPlayerPosition(Integer position, Player player) {
        playerPosition.remove(player);
        playerPosition.put(player, position);
    }

    public void setPlayerCard(Integer numCard, Player player) {
        playersCards.put(numCard, player);
    }

    public boolean isFreeCard(Integer numberCard){
        return playersCards.containsKey(numberCard);
    }
}
