package by.example;

@Singleton
//@Deprecated
public class RecommendatorImpl implements Recommendator {
    @InjectProperty("wiskey")
    private String product;

    public RecommendatorImpl() {
        System.out.println("recommendator was created");
    }

    @Override
    public void recommend() {
        System.out.println("some advertisement of " + product);
    }
}
