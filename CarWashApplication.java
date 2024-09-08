import java.util.Random; 
import java.util.ArrayList;

/**
 *class that keeps track of a car's arrival time. Have your main method loop a number of times (e.g., 20 times). 
 *In each step, print a timestamp and implement the random arrival of a car, putting cars in a queue.
 *
 * @author Maggie Zhu
 * @version 5-6-24
 */
public class CarWashApplication
{
    // instance variables - replace the example below with your own

    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main(String[] args)
    {
        // put your code here
        
        
        for(int i=0 ; i<7 ; i++){// result for 4 min wash for 7 days 
        CarWashSimulation simulation = new CarWashSimulation(4);
        System.out.println("Results for 4 min Day " + i );
        simulation.run(600);
            
        }
        
        for(int i=0 ; i<7 ; i++){// results for 3 min wash for 7 days. 
            CarWashSimulation simulation = new CarWashSimulation(3);
        System.out.println("Results for 3 min Day " + i );
        simulation.run(600);
            
        }
        
        
    }
}
