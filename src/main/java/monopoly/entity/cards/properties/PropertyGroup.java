package monopoly.entity.cards.properties;

import monopoly.entity.cards.Card;
import monopoly.entity.cards.CardStorage;
import monopoly.entity.roles.Player;

import java.util.HashSet;
import java.util.Set;

public class PropertyGroup {
    private String name;
    private CardStorage<Card> cardStorage;

    public PropertyGroup(String name) {
        this.name = name;
        this.cardStorage = new CardStorage(new HashSet<>());
    }

    public String getName() {
        return name;
    }

    public void addCard(Card card) {
        cardStorage.addCard(card);
    }

    public boolean hasAllCards(Player player) {
        for (Card card : cardStorage.getCards()) {
            if (!player.hasCard(card)) {
                return false;
            }
        }
        return true;
    }

    public Set<Card> getCards() {
        return cardStorage.getCards();
    }

    public void deleteCard(Card card) {
        cardStorage.deleteCard(card);
    }
}

