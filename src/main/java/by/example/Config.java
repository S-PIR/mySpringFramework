package by.example;

import org.reflections.Reflections;

public interface Config {
    <T> Class<? extends T> getImplClass(Class<T> iface);

    Reflections getScanner();

}
