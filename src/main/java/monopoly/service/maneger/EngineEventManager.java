package monopoly.service.maneger;

import lombok.RequiredArgsConstructor;
import monopoly.entity.GameSession;
import monopoly.events.engine.EndGameEvent;
import monopoly.events.engine.PlayerMoveEvent;
import monopoly.events.engine.StartGameEvent;

@RequiredArgsConstructor
public class EngineEventManager {
    private final GameSession gameSession;
    private final StartGameEvent startGameEvent = new StartGameEvent(gameSession);
    private final EndGameEvent endGameEvent = new EndGameEvent();
    private PlayerMoveEvent playerMoveEvent;



}
