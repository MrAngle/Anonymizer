package com.lipsoft.anonymize.code;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootTest
class EventsTest {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Test
    void applicationEventPublisherTest() {
        applicationEventPublisher.publishEvent(new CustomEvent());
    }
}

@Component
class EventsListener {

    @EventListener
    public List<String> onCustomEvent(CustomEvent customEvent) {
        System.out.println("onCustomEvent: " + customEvent);
        return List.of("Element 1", "Element 2", "Element 3");
    }

    @EventListener
    public void onStringEvent(String event) {
        System.out.println("onStringEvent: " + event);
    }
}

class CustomEvent {}