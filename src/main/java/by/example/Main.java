package by.example;

import by.example.domain.Bakery;
import by.example.domain.Manager;
import by.example.domain.ManagerImpl;
import by.example.domain.Pie;
import by.example.infrastructure.Application;
import by.example.infrastructure.ApplicationContext;

import java.util.HashMap;

import static java.util.Map.*;

public class Main {
    public static void main(String[] args) {
//        Bakery bakery = ObjectFactory.getInstance().createObject(Bakery.class);
        ApplicationContext context = Application.run("by.example", new HashMap<>(of(Manager.class, ManagerImpl.class)));
        Bakery bakery = context.getObject(Bakery.class);
        bakery.start(new Pie());

    }
}
