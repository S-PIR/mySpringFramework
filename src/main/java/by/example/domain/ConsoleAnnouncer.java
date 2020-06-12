package by.example.domain;

import by.example.infrastructure.annotations.InjectByType;

public class ConsoleAnnouncer implements Announcer {
    @InjectByType
    private Recommendator recommendator;

    public void announce(String announcement) {
        System.out.println(announcement);
        recommendator.recommend();
    }
}
