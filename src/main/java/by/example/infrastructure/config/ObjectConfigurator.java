package by.example.infrastructure.config;

import by.example.infrastructure.ApplicationContext;

public interface ObjectConfigurator {
    void configure(Object t, ApplicationContext context);
}
