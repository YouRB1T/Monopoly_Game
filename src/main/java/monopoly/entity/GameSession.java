package monopoly.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import monopoly.events.Event;
import monopoly.entity.roles.Player;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
public class GameSession {
    private final List<Player> players;
    private final Board board;
    private final Set<Event> events;
    private Player currentPlayer;
    private Integer currentPlayerNum;
}
