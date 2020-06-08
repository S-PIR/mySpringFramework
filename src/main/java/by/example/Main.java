package by.example;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.*;

public class Main {
    public static void main(String[] args) {
//        Bakery bakery = ObjectFactory.getInstance().createObject(Bakery.class);
        ApplicationContext context = Application.run("by.example", new HashMap<>(of(Manager.class, ManagerImpl.class)));
        Bakery bakery = context.getObject(Bakery.class);
        bakery.start(new Pie());

    }
}
