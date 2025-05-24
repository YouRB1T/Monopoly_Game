package monopoly.service;

import lombok.RequiredArgsConstructor;
import monopoly.entity.GameSession;
import monopoly.events.engine.EndGameEvent;
import monopoly.events.engine.PlayerMoveEvent;
import monopoly.events.engine.StartGameEvent;

@RequiredArgsConstructor
public class GameSessionService {
    private final GameSession gameSession;
    private final StartGameEvent startGameEvent = new StartGameEvent(gameSession);
    private final PlayerMoveEvent playerMoveEvent = new PlayerMoveEvent(gameSession);
    private final EndGameEvent endGameEvent = new EndGameEvent();

    public void startGame() {
        startGameEvent.execute();

    }
}
