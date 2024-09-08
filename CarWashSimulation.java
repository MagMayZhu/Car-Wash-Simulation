import java.util.Random;
import java.util.ArrayList;

/**
 *  This class is a template, or starting point, for
 *  a class that will manage the simulation of cars arriving at a car
 *  wash, waiting in line, and going through the wash cycle.
 *
 */
public class CarWashSimulation
{
    int currentTime;        // how many minutes the car wash has been open
    int closingTime;        // when the car wash should close
    Bay bay;                // car wash bay
    KQueue waitingLine;     // line of cars waiting to be washed

    double totalWaitingTime;   // total time spent waiting by all cars
    int numCars;            // how many cars were washed
    double numTenMinWaits;
    Random randGen;     // random number generator

    LLQueues <Car> queue;
    /* Construct a car wash simulation object. */
    public CarWashSimulation (int time)    {
        bay = new Bay(time);
        waitingLine = new LLQueues();
        randGen = new Random();
        queue= new LLQueues<>(); 

    }

    /** Execute a single step of the simulation.
     */    
    public void step ()
    {
        Car car=null;// Setting the car object to null

        if (Math.random() > 0.25 && currentTime < closingTime) {// .25 chance for a car wash to happen per minute
            Car newCar = new Car(currentTime);//Gettimg the current time of a new car 
            queue.enqueue(newCar);// Adding car to queue
            numCars++; // Incrementing the total car wash 
        }
        // Creating if=else statement 
        if(!queue.isEmpty() && bay.isEmpty()){
            car= queue.dequeue();// remove a car from the queue.

            int waitTime = currentTime- car.getArrival(); // Intilizing the waitTime Variable
            totalWaitingTime += waitTime;
            numCars++;// Incrementing number of cars
            bay.startWash();// using the startWashing method.
            // Check if there are cars that watied linger then 10 min 
            if(waitTime >= 10) {
                numTenMinWaits++; // adding then together 

            }
            

        }
        else{
                bay.keepWashing(); // otherwise keep wahsing 
            }

        currentTime++;// Adding time up 
    }    

   
    /** Run the simulation for a specified number of minutes (or whatever the
     *  unit for a single step of the simulation is).
     *  @param minutesToRun the number of steps of the simulation to run
     */    
    public void run (int runTime)
    {
        closingTime = runTime;
        // Find the time for 
        for ( int i=0 ; i < runTime; i++){
            step();
        }

        while(!queue.isEmpty()){// If queue is not empty

            step(); //step
        }

        double getAverageWaitingTime = totalWaitingTime / numCars; 
        // Print out results. 
        System.out.println("The total number of cars washed:" +numCars);
        System.out.println("The total wait time of a car:" + totalWaitingTime);
        System.out.println("The average waiting time of a car:" + getAverageWaitingTime);
        System.out.println("The number of ten minutes waits:" + numTenMinWaits);

    }
    
    
}    // end CarWashSimulation class
    
  