package examples;// Priority Queue and Simulation

// examples.CarMaker is a examples.Car object generator.
// examples.CarMaker produces a new examples.Car Object each time it runs.
// examples.CarMaker reschedules itself randomly based on the average arrival interval.
// The method run() simulates the arrival of vehicles into the system.
// examples.Car objects contain the time they were created and their service time.
// examples.Car objects are immediately queued.
// Implements the examples.Event (examples.Event.java) interface.

public class CarMaker implements Event {

    // constructor

    public CarMaker(int intval, int[] servDist) {
        interval = intval;
        serviceDist = new int[servDist.length];
        System.arraycopy(servDist, 0, serviceDist, 0, servDist.length);
    }

    // methods

    private int intRandomInterval(int low, int high) {
        return (int) Math.floor((high - low) * Math.random() + low + 0.5);
    }

    private double selectServiceTime() {
        return serviceDist[intRandomInterval(0, serviceDist.length - 1)];
    }

    public void run() {
        CarSim.agenda.add(new CarMaker(interval, serviceDist),
                          intRandomInterval(0, 2 * interval));
        Car newCar = new Car(CarSim.agenda.getCurrentTime(), 
                             selectServiceTime());
    }

    private int interval;
    private int[] serviceDist;

}  // examples.CarMaker class
