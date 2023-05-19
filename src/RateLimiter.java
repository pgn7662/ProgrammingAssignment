import java.util.Arrays;
import java.util.Scanner;

public class RateLimiter { //Each Java program starts with a class
    public static void main(String[] args) { // Start of the program
        Scanner input = new Scanner(System.in); // Used to get input from the console, A scanner instance is created
        int maximumNumberOfRequests = Integer.parseInt(input.nextLine()); //R
        int slidingWindowPeriod = Integer.parseInt(input.nextLine());  //S
        String[] timeStampSequence = input.nextLine().split(" "); // TimeStampSequence
        long[] timeStampArray = new long[timeStampSequence.length];
        for(int index = 0; index < timeStampSequence.length; index++){
            timeStampArray[index] = Long.parseLong(timeStampSequence[index]); // Converitng string to long value
        }
        findRateLimit(timeStampArray, maximumNumberOfRequests, slidingWindowPeriod);//function call to find the rate limit
    }

    static void findRateLimit(long[] timeStampSequence,int maximumNumberOfRequests,int slidingWindowPeriod){//static function defined to find the rate limit
        int index = 0 ; //variable to check maximumNumberOfRequests
        for (long timeStamp : timeStampSequence) { // loop to iterate through the timeStampSequence
            if (index == slidingWindowPeriod) { //condition to limit the number of requests for each period
                index = 0; //reset the index
            }
            if (index < maximumNumberOfRequests) { //limit the maximum number of requests for each period
                System.out.println(timeStamp + " Allowed"); //Prints
            } else {
                System.out.println(timeStamp + " Blocked");
            }
            index++; //updating the index for each iteration
        }
    }
}