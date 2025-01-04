package monopoly.builders;

import monopoly.entity.Board;

public class ClassicGameBuilder {
    private final Board board;
    private String[] titles;

    public ClassicGameBuilder(Board board) {
        this.board = board;
        titles = new String[]{"Полянка", };
    }

    public Board getBoard() {
        return board;
    }

    public void constructBoard() {

    }
}
