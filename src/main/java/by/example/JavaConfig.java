package by.example;

import lombok.Getter;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class JavaConfig implements Config {
    @Getter
    private Reflections scanner;
    private Map<Class, Class> iface2ImplClass;

    public JavaConfig(String packageToScan, Map<Class, Class> iface2ImplClass) {
        this.iface2ImplClass = iface2ImplClass;
        this.scanner = new Reflections(packageToScan);
    }

    public <T> Class<? extends T> getImplClass(Class<T> iface) {
        return iface2ImplClass.computeIfAbsent(iface, aClass -> {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(iface);
            if (classes.size() != 1) {
                throw new RuntimeException(iface + " has 0 or more than one implementation. Update your config.");
            }
            return classes.iterator().next();
        });

    }
}
