package by.example.domain;

import by.example.infrastructure.annotations.InjectProperty;
import by.example.infrastructure.annotations.Singleton;

@Singleton
//@Deprecated
public class RecommendatorImpl implements Recommendator {
    @InjectProperty("wisky")
    private String product;

    public RecommendatorImpl() {
        System.out.println("recommendator was created");
    }

    @Override
    public void recommend() {
        System.out.println("some advertisement of " + product);
    }
}
