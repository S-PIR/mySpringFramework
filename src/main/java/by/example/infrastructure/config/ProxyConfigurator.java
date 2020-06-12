package by.example.infrastructure.config;

public interface ProxyConfigurator {
    Object replaceProxyIfNeeded(Object t, Class implClass);
}
