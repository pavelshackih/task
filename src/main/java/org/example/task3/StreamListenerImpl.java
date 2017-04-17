package org.example.task3;

import org.example.task3.model.Event;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class StreamListenerImpl implements StreamListener {

    private static final long PERIOD = TimeUnit.MINUTES.toMillis(10);

    private final Map<String, Event> events = new ConcurrentHashMap<>();

    private static boolean isInPeriod(long now, Event event) {
        return now - event.getTimestamp() < PERIOD;
    }

    public void onNewEvent(Event event) {
        synchronized (events) {
            long now = System.currentTimeMillis();
            if (isInPeriod(now, event)) {
                if (events.containsKey(event.getName())) {
                    Event oldEvent = events.get(event.getName());
                    if (isInPeriod(now, oldEvent)) {
                        if (event.getValue() > oldEvent.getValue()) {
                            events.remove(event.getName());
                            events.put(event.getName(), event);
                        }
                    } else {
                        events.remove(oldEvent.getName());
                        events.put(event.getName(), event);
                    }
                } else {
                    events.put(event.getName(), event);
                }
            }
        }
    }

    @Nullable
    public Event getMaxFor(String name) {
        synchronized (events) {
            if (events.containsKey(name)) {
                Event event = events.get(name);
                long now = System.currentTimeMillis();
                if (isInPeriod(now, event)) {
                    return events.get(name);
                } else {
                    events.remove(name);
                    return null;
                }
            } else {
                return null;
            }
        }
    }

    public List<Event> getEvents() {
        List<Event> result = new ArrayList<>();
        List<Event> copy = new ArrayList<>(events.values());
        for (Event event : copy) {
            Event c = getMaxFor(event.getName());
            if (c != null) {
                result.add(c);
            }
        }
        return result;
    }
}
