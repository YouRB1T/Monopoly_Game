package monopoly.events.engine;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import monopoly.entity.GameSession;
import monopoly.entity.roles.Player;

import java.util.Random;

@Getter
@Setter
@RequiredArgsConstructor
public class PlayerMoveEvent extends EngineEvent{
    private Player player;
    private final GameSession gameSession;
    private boolean isSameRoll = false;
    private final PreRollEvent preRollEvent = new PreRollEvent();
    private final PostRollEvent postRollEvent = new PostRollEvent();

    @Override
    public void execute() {
        preRollEvent.execute();
        rollDice();
        postRollEvent.execute();
        setNextPlayer();
        isSameRoll = false;
    }

    private Integer rollDice() {
        Random random = new Random();
        int firstRoll = random.nextInt(6) + 1;
        int secondRoll = random.nextInt(6) + 1;

        if (firstRoll == secondRoll) {
            isSameRoll = true;
        } else {
            isSameRoll = false;
        }

        return firstRoll;
    }

    public boolean isSameRoll() {
        return isSameRoll;
    }

    private void setNextPlayer() {
        if (!isSameRoll){
            gameSession.setCurrentPlayerNum(
                    (getGameSession().getCurrentPlayerNum() + 1) % gameSession.getPlayers().size()
            );
            gameSession.setCurrentPlayer(
                    gameSession.getPlayers().get(gameSession.getCurrentPlayerNum())
            );
        }
    }
}
