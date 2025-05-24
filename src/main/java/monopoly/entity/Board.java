package monopoly.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import monopoly.entity.cards.Card;
import monopoly.entity.cards.properties.PropertyCard;
import monopoly.entity.cards.properties.PropertyGroup;
import monopoly.entity.roles.Player;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Board {
    private final Map<Integer, Card> board;
    private final Map<Player, Integer> playerPosition;
    private Map<PropertyCard, Player> propertyOwner;
    private List<PropertyGroup> propertyGroups;
    private int maxSize;

    public void addCard(Integer numCard, Card card) {
        board.put(numCard, card);
        maxSize = numCard;
    }

    public Card getCard(Integer numCard) {
        return board.get(numCard);
    }

    public Integer getPlayerPosition(Player player) {
        return playerPosition.get(player);
    }

    public Card getPlayerPositionCard(Player player) {
        return board.get(playerPosition.get(player));
    }

    public void setPlayerPosition(Integer position, Player player) {
        playerPosition.remove(player);
        playerPosition.put(player, position);
    }

    public void setPropertyOwner(PropertyCard propertyCard, Player player) {
        propertyOwner.put(propertyCard, player);
    }

    public Player getPropertyOwner(PropertyCard propertyCard) {
        return propertyOwner.get(propertyCard);
    }
}
