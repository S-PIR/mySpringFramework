package by.example;

@Deprecated
public class Bakery {

    @InjectByType
    private Announcer announcer;
    @InjectByType
    private Manager manager;

    public void start(Pie pie) {
        announcer.announce("Getting started!");
        manager.makeStaffGetReady();
        bake(pie);
        announcer.announce("Pie is ready.");
    }

    private void bake(Pie pie) {
        System.out.println("Pie is baking...");
    }
}
