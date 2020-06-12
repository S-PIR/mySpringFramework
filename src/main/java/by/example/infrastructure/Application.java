package by.example.infrastructure;

import by.example.infrastructure.config.Config;
import by.example.infrastructure.config.JavaConfig;
import by.example.infrastructure.factory.ObjectFactory;

import java.util.Map;

public class Application {
    public static ApplicationContext run(String packageToScan, Map<Class, Class> iface2ToImplClass) {
        Config config = new JavaConfig(packageToScan, iface2ToImplClass);
        ApplicationContext context = new ApplicationContext(config);
        ObjectFactory objectFactory = new ObjectFactory(context);
        //todo init all singleton which are not lazy
        context.setFactory(objectFactory);
        return context;
    }
}
