package monopoly.events.engine;

import monopoly.events.Event;

public abstract class EngineEvent implements Event {

    public abstract void execute();
}
