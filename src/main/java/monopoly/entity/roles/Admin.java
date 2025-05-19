package monopoly.entity.roles;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import monopoly.entity.cards.Card;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Getter
@Setter
public class Admin {
    private Integer moneys;
    private Integer totalMoneys;
    private final Set<Card> playerCards;
    private final List<Player> players;

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
}
