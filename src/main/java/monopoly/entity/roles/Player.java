package monopoly.entity.roles;

import monopoly.entity.cards.Card;
import monopoly.entity.cards.CardStorage;

public class Player {
    private CardStorage playerCards;

    public boolean hasCard(Card card) {
        return playerCards.isCardInside(card);
    }
}
