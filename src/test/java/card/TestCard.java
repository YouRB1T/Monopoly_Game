package card;

import monopoly.entity.Board;
import monopoly.entity.roles.Player;
import monopoly.entity.cards.Card;
import monopoly.entity.events.Event;

public class TestCard extends Card {
    public TestCard(String title, String description) {
        super(title, description);
    }

    public TestCard(Event eventOfCard, String title, String description) {
        super(eventOfCard, title, description);
    }

    @Override
    public void executeActon(Player player, Board board) {

    }
}
