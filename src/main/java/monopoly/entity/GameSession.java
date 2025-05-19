package monopoly.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import monopoly.entity.events.Event;
import monopoly.entity.roles.Player;

import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
public class GameSession {
    private final Set<Player> players;
    private final Board board;
    private final Set<Event> events;

}
