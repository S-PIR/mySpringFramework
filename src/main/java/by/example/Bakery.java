package by.example;

public class Bakery {

    private Announcer announcer = ObjectFactory.getInstance(Announcer.class);

    private Manager manager = ObjectFactory.getInstance(Manager.class);



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
