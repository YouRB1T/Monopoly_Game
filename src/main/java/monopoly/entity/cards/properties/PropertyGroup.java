package monopoly.entity.cards.properties;

import monopoly.entity.cards.Card;
import monopoly.entity.cards.CardStorage;
import monopoly.entity.roles.Player;

import java.util.HashSet;
import java.util.Set;

public class PropertyGroup {
    private String name;
    private Set<Card> cardStorage;

    public void addCard(Card card) {
        cardStorage.add(card);
    }

    public boolean hasAllCards(Player player) {
        for (Object card : cardStorage.toArray()) {
            if (!player.hasCard((Card) card)) {
                return false;
            }
        }
        return true;
    }

    public void deleteCard(Card card) {
        cardStorage.remove(card);
    }
}

