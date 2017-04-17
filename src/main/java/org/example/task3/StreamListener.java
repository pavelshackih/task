package org.example.task3;

import org.example.task3.model.Event;

public interface StreamListener {

    void onNewEvent(Event event);
}
