package monopoly.entity.cards;

import monopoly.entity.Board;
import monopoly.entity.roles.Player;
import monopoly.entity.events.Event;

public abstract class Card {

    private Event eventOfCard;
    private String title;
    private String description;

    public Card() {
    }

    public Card(String title) {
        this.title = title;
    }

    public Card(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Card(Event eventOfCard, String title, String description) {
        this.eventOfCard = eventOfCard;
        this.title = title;
        this.description = description;
    }

    /**
        ---------Logic methods-----------------
     */

    public void executeActon(Player player, Board board) {
        eventOfCard.execute(player, board);
    }

    /**
        ----------Getters and Setters----------
     */

    public Event getEventOfCard() {
        return eventOfCard;
    }

    public void setEventOfCard(Event eventOfCard) {
        this.eventOfCard = eventOfCard;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    /**
        -----------TO STRING--------------
     */
    @Override
    public String toString() {
        return "Card{" +
                "eventOfCard=" + eventOfCard.toString() +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
