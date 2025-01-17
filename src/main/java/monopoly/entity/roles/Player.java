package monopoly.entity.roles;

import monopoly.entity.cards.Card;
import monopoly.entity.cards.CardStorage;
import monopoly.entity.cards.properties.Priced;

public class Player extends Role {
    private Integer moneys;
    private Integer totalMoneys;
    private final CardStorage playerCards;

    public Player() {
        this.playerCards = new CardStorage();
        this.moneys = 0;
        this.totalMoneys = 0;
    }

    public Player(String name) {
        super(name);
        this.playerCards = new CardStorage();
        totalMoneys = 0;
        moneys = 0;
    }

    public Integer getMoneys() {
        return moneys;
    }

    public void setMoneys(Integer moneys) {
        this.moneys = moneys;
    }

    public Integer getTotalMoneys() {
        return totalMoneys;
    }

    public void deleteCard(Card card) {
        if (card instanceof Priced) {
            totalMoneys -= ((Priced) card).getPrice();
        }
        playerCards.deleteCard(card);
    }

    public void addCard(Card card) {
        if (card instanceof Priced) {
            totalMoneys += ((Priced) card).getPrice();
        }
        playerCards.addCard(card);
    }

    public boolean hasCard(Card card) {
        return playerCards.isCardInside(card);
    }

    public void addMoneys(Integer amount) {
        moneys += amount;
        totalMoneys += amount;
    }

    public void subMoneys(Integer amount) {
        moneys -= amount;
        totalMoneys -= amount;
    }

    public String getName() {
        return super.getName();
    }
}
