package monopoly.entity.roles;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import monopoly.entity.cards.Card;

import java.util.Set;

@RequiredArgsConstructor
@Getter
@Setter
public class Player extends Role {
    private Integer moneys;
    private Integer totalMoneys;
    private final Set<Card> playerCards;

    public void deleteCard(Card card) {
       playerCards.remove(card);
    }

    public void addCard(Card card) {
        playerCards.add(card);
    }

    public boolean hasCard(Card card) {
        return playerCards.contains(card);
    }

    public void addMoneys(Integer amount) {
        moneys += amount;
        totalMoneys += amount;
    }

    public void subMoneys(Integer amount) {
        moneys -= amount;
        totalMoneys -= amount;
    }

    public void buyCard(Integer amount) {
        moneys -= amount;
    }

    public void addTotalMoneys(Integer amount) {
        totalMoneys += amount;
    }
}
