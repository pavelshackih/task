package org.example.task3;

import org.example.task3.model.Event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class EventGenerator implements Runnable {

    private final int maxEvents;

    private final AtomicInteger counter = new AtomicInteger(0);
    private final List<StreamListener> listeners = new ArrayList<>();
    private final List<String> sampleTags = Arrays.asList("tag1", "tag2");
    private final Random random = new Random();

    public EventGenerator(int maxEvents) {
        this.maxEvents = maxEvents;
    }

    public void addListener(StreamListener listener) {
        listeners.add(listener);
    }

    public void removeListener(StreamListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void run() {
        while (true) {
            if (counter.get() > maxEvents) {
                break;
            }
            long t = System.currentTimeMillis();
            Event event = new Event();
            event.setName("Name:" + random.nextInt(10));
            event.setTimestamp(t);
            event.setTags(getTags());
            event.setValue(random.nextInt(100));
            System.out.println("Generate event: " + event);
            counter.incrementAndGet();
            for (StreamListener listener : listeners) {
                listener.onNewEvent(event);
            }
        }
    }

    private List<String> getTags() {
        return sampleTags;
    }
}
