package monopoly.entity.cards;

import monopoly.events.board.EventOnBoard;

public class CardAction extends Card{
    public CardAction(EventOnBoard eventOfCard, String title, String description) {
        super(eventOfCard, title, description);
    }
}
