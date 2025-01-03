package monopoly.entity.events;

import monopoly.entity.Board;
import monopoly.entity.roles.Player;

public class PayRentEvent extends Event {

    public PayRentEvent() {
        super();
    }

    public PayRentEvent(String description) {
        super(description);
    }

    @Override
    public void execute(Player player) {

    }

    @Override
    public String getDescription() {
        return "Pay Rent Event";
    }
}
