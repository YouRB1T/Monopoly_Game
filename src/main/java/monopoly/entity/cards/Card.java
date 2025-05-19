package monopoly.entity.cards;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import monopoly.entity.Board;
import monopoly.entity.roles.Player;
import monopoly.entity.events.Event;

@Getter
@Setter
@RequiredArgsConstructor
public abstract class Card {

    private final Event eventOfCard;
    private final String title;
    private final String description;

    /**
        ---------Logic methods-----------------
     */

    public void execute(Player player, Board board) {
        eventOfCard.execute(player, board);
    }

    @Override
    public String toString() {
        return "Card{" +
                "eventOfCard=" + eventOfCard.toString() +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
