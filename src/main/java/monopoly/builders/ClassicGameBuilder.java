package monopoly.builders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import monopoly.entity.Board;
import monopoly.entity.GameSession;
import monopoly.entity.roles.Player;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class ClassicGameBuilder implements GameBuilder{

    private Set<Player> players;


    @Override
    public GameSession build() {

        return null;
    }

    private Board buildClassicBoard() {
        return new Board(

        );
    }
}
