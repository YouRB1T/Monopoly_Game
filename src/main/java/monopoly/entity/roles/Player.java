package monopoly.entity.roles;

import monopoly.entity.cards.Card;
import monopoly.entity.cards.CardStorage;
import monopoly.entity.events.Event;

public class Player extends Role {
    private Event event;
    private Integer moneys;
    private CardStorage playerCards;

    public Player() {
    }



    public void deleteCard(Card card) {
        playerCards.deleteCard(card);
    }

    public void addCard(Card card) {
        playerCards.addCard(card);
    }

    public boolean hasCard(Card card) {
        return playerCards.isCardInside(card);
    }
}
