package by.example;

public interface Config {
    <T> Class<? extends T> getImplClass(Class<T> iface);


}
