package by.example;

public class ObjectFactory {
    private static ObjectFactory instance = new ObjectFactory();
    private Config config = new JavaConfig("by.example");

    public static ObjectFactory getInstance() {
        return instance;
    }

    private ObjectFactory() {}

    public <T> T createObject(Class<T> type) {
        Class<? extends T> implClass = type;
        if (type.isInterface()) {
            implClass = config.getImplClass(type);

        }
        return T t;
    }
}
