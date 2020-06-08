package by.example;

import javax.annotation.PostConstruct;

public class ManagerImpl implements Manager {

    @InjectByType
    private Recommendator recommendator;

    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct init() " + recommendator.getClass());
    }

    public void makeStaffGetReady() {
        System.out.println("Get awake, guys!");
    }
}
