package monopoly.entity.cards;

import java.util.*;

public class CardStorage<C> {
    private Set<C> cards;

    public CardStorage() {
        cards = new HashSet<>();
    }

    public CardStorage(Set<C> cards) {
        this.cards = cards;
    }


    /*private static class ReadOnlyProxySet<T> implements Set<T> {
        private final Set<T> original;

        public ReadOnlyProxySet(Set<T> original) {
            this.original = original;
        }

    }*/

    public Set<C> getCards() {
        return  cards;
    }

    public void setCards(HashSet<C> cards) {
        this.cards = cards;
    }

    public CardStorage(CardStorage<C> other) {

    }

    public void addCard(C card) {
        cards.add(card);
    }

    public boolean isCardInside(C card) {
        return cards.contains(card);
    }

    public void deleteCard(C card) {
        if (cards.remove(card)) {
            System.out.println("DELETED: " + card.toString());
        } else {
            System.out.println("NOT INCLUDED: " + card.toString());
        }
    }
}
