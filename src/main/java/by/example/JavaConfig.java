package by.example;

import org.reflections.Reflections;

import java.util.Set;

public class JavaConfig implements Config {
    private Reflections scanner;

    public JavaConfig(String packageToScan) {
        this.scanner = new Reflections(packageToScan);
    }

    public <T> Class<? extends T> getImplClass(Class<T> iface) {
        Set<Class<? extends T>> classes = scanner.getSubTypesOf(iface);
        if (classes.size() != 1) {
            throw new RuntimeException(iface + " has 0 or more than one implementation.");
        }

        return classes.iterator().next();
    }
}
