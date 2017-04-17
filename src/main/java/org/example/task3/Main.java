package org.example.task3;

import org.example.task3.model.Event;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        EventGenerator generator = new EventGenerator(100);
        StreamListenerImpl streamListener = new StreamListenerImpl();
        generator.addListener(streamListener);
        // generating events
        System.out.println("Generating events...");
        generator.run();
        generator.removeListener(streamListener);
        System.out.println("Printing max...");
        List<Event> list = streamListener.getEvents();
        list.forEach(System.out::println);
    }
}
