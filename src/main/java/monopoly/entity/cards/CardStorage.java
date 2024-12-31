package monopoly.entity.cards;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CardStorage {
    private HashSet<Card> cards;

    public CardStorage() {
    }

    public CardStorage(HashSet<Card> cards) {
        this.cards = cards;
    }

    public HashSet<Card> getCards() {
        return cards;
    }

    public void setCards(HashSet<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public boolean isCardInside(Card card) {
        return cards.contains(card);
    }

    public void deleteCard(Card card) {
        if (cards.remove(card)) {
            System.out.println("DELETED: " + card.toString());
        } else {
            System.out.println("NOT INCLUDED: " + card.toString());
        }
    }
}
