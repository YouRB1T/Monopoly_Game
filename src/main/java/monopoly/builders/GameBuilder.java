package monopoly.builders;

import monopoly.entity.Board;

public interface GameBuilder {
    void constructBoard();
    Board getBoard();
}
