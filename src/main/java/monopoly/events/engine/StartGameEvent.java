package monopoly.events.engine;

import lombok.RequiredArgsConstructor;
import monopoly.entity.GameSession;
import monopoly.entity.roles.Player;

import java.util.Collections;
import java.util.List;


@RequiredArgsConstructor
public class StartGameEvent extends EngineEvent {
    private final Integer START_MONEY = 2500;

    private final GameSession gameSession;

    @Override
    public void execute() {
        System.out.println("Start game event");
        List<Player> players = gameSession.getPlayers();
        giveStartMoney(players);
        gameSession.setCurrentPlayer(chooseFirstPlayer(players));
        gameSession.setCurrentPlayerNum(0);
    }

    private void giveStartMoney(List<Player> players) {
        for (Player player : players) {
            player.addMoneys(START_MONEY);
        }
    }

    private Player chooseFirstPlayer(List<Player> players) {
        Collections.shuffle(players);
        return players.get(0);
    }


}
