package monopoly.entity;

import monopoly.entity.cards.Card;
import monopoly.entity.cards.CardAction;
import monopoly.entity.cards.CardStorage;
import monopoly.entity.cards.properties.PropertyCard;

import java.util.HashMap;
import java.util.List;

public class Board<P extends Card> {
    private HashMap<Integer, P> board;

    public Board() {
    }

    public Board(HashMap<Integer, P> board) {
        this.board = board;
    }

    public HashMap<Integer, P> getBoard() {
        return board;
    }

    public void setBoard(HashMap<Integer, P> board) {
        this.board = board;
    }
}
