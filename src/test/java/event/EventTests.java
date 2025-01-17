package event;

import monopoly.entity.Board;
import monopoly.entity.cards.StartCard;
import monopoly.entity.cards.properties.PropertyCard;
import monopoly.entity.cards.properties.characteristics.Rent;
import monopoly.entity.cards.properties.characteristics.RentUtils;
import monopoly.entity.events.*;
import monopoly.entity.roles.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EventTests {
    private Board board;
    private Player player;
    private PropertyCard propertyCard;
    private BuyPropertyEvent buyPropertyEvent;
    private PayRentEvent payRentEvent;
    private EventOnProperty eventOnProperty;

    @BeforeEach
    void setUp() {
        board = new Board();
        player = new Player("Test Player");
        propertyCard = new PropertyCard("Test Property", 200);
        board.addCard(1, propertyCard);
        board.setPlayerPosition(1, player);
        buyPropertyEvent = new BuyPropertyEvent();
        payRentEvent = new PayRentEvent();
        eventOnProperty = new EventOnProperty("Test Event", payRentEvent, buyPropertyEvent, new ChooseEvent());
    }

    @Test
    void testBuyPropertyEvent() {
        player.addMoneys(300);
        buyPropertyEvent.execute(player, board);
        assertTrue(player.hasCard(propertyCard));
        assertEquals(100, player.getMoneys());
    }

    @Test
    void testPayRentEvent() {
        player.addMoneys(300);
        Rent rent = new Rent();
        RentUtils.fillRent(rent, 5);
        propertyCard.setRent(rent);
        propertyCard.setCurrLevel(3);
        payRentEvent.execute(player, board);
        assertEquals(0, player.getMoneys());
    }

    @Test
    void testEventOnPropertyBuy() {
        player.addMoneys(300);
        Rent rent = new Rent();
        RentUtils.fillRent(rent, 5);
        propertyCard.setRent(rent);
        propertyCard.setCurrLevel(2);
        eventOnProperty.execute(player, board);
        assertTrue(!player.hasCard(propertyCard));
        assertEquals(100, player.getMoneys());
    }

    @Test
    void testEventOnPropertyPayRent() {
        player.addMoneys(300);
        Player newPlayer = new Player("Other Player");
        newPlayer.addCard(propertyCard);
        Rent rent = new Rent();
        RentUtils.fillRent(rent, 5);
        propertyCard.setRent(rent);
        propertyCard.setCurrLevel(1);
        eventOnProperty.execute(player, board);
        assertEquals(200, player.getMoneys());
    }

    @Test
    void testEndGameEvent() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Player 1"));
        players.add(new Player("Player 2"));
        players.get(0).addMoneys(100);
        players.get(1).addMoneys(200);

        EndGameEvent endGameEvent = new EndGameEvent();
        Player winner = endGameEvent.executeEnd(players);
        assertEquals("Player 2", winner.getName());
    }

    // Методы, которые тестятся, работают правильно, тест может быть не пройден из-за рандомной следующей
    // позиции, которая присваивается игроку.
    @Test
    void testPlayerMoveEvent() {
        PlayerMoveEvent playerMoveEvent = new PlayerMoveEvent();
        player.addMoneys(300);
        board = new Board();
        board.addCard(1, new StartCard(new StartGameEvent(), "Start Card", "Give All Players 200"));
        board.addCard(2, new PropertyCard(new EventOnProperty("Событие на Полянке",
                payRentEvent, buyPropertyEvent, new ChooseEvent()
        ), "Полянка", "Первая карточка"));
        board.setPlayerPosition(2, player);
        playerMoveEvent.execute(player, board);
        assertEquals(1, board.getPlayerPosition(player));
    }
}
