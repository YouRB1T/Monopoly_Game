package monopoly.builders;

import monopoly.entity.Board;
import monopoly.entity.cards.Card;
import monopoly.entity.cards.StartCard;
import monopoly.entity.cards.properties.PropertyCard;
import monopoly.entity.cards.properties.PropertyGroup;
import monopoly.entity.cards.properties.characteristics.Rent;
import monopoly.entity.cards.properties.characteristics.RentUtils;
import monopoly.entity.events.*;

import java.util.HashMap;
import java.util.List;

public class ClassicGameBuilder implements GameBuilder{
    private final Board board;
    private final EventOnProperty eventOnProperty;
    private final String[] titles;
    private final PropertyGroup[] propertyGroups;

    public ClassicGameBuilder() {
        this.board = new Board();
        titles = new String[]{"Нагатинская", "Огарева", "Полянка", "Вавилова", "Тверская", "Щусева", "Арбат"};

        propertyGroups = new PropertyGroup[]{
                new PropertyGroup("Коричневые"), new PropertyGroup("Голубые"),
                new PropertyGroup("Розовые"), new PropertyGroup("Оранжевые"),
                new PropertyGroup("Красные"), new PropertyGroup("Зеленые"),
                new PropertyGroup("Синие")};

        eventOnProperty = new EventOnProperty("Срабатывание ивента на карточке собственности",
                new PayRentEvent(), new BuyPropertyEvent(), new ChooseEvent());

    }

    @Override
    public void constructBoard() {

        board.addCard(1, new StartCard(
            new StartGameEvent(), "СТАРТ", "Стартовая карточка поля"
        ));

        int positionCard = 2;
        int price = 100;
        for (int i = 0; i < propertyGroups.length; i++) {
            Rent rent = new Rent();
            RentUtils.fillRentWithBasePrice(rent, 5, price / 4);

            PropertyCard propertyCard = new PropertyCard(
                    eventOnProperty, titles[i], "Карточка собственности", price, rent, 1
            );
            board.addCard(positionCard, propertyCard);
            propertyGroups[i].addCard(propertyCard);

            price += 100;
            positionCard++;
        }

        board.setPropertyGroups(List.of(propertyGroups));
    }

    public Board getBoard() {
        return board;
    }

    public String[] getTitles() {
        return titles;
    }

    public PropertyGroup[] getPropertyGroups() {
        return propertyGroups;
    }

}
