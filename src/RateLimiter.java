import java.util.Arrays;
import java.util.Scanner;

public class RateLimiter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int maximumNumberOfRequests = Integer.parseInt(input.nextLine());
        int slidingWindowPeriod = Integer.parseInt(input.nextLine());
        String[] timeStampSequence = input.nextLine().split(" ");
        findRateLimit(timeStampSequence, maximumNumberOfRequests, slidingWindowPeriod);
    }

    static void findRateLimit(String[] timeStampSequence,int maximumNumberOfRequests,int slidingWindowPeriod){
        int index = 0 ;
        for (String timeStamp : timeStampSequence) {
            if (index == slidingWindowPeriod) {
                index = 0;
            }
            if (index < maximumNumberOfRequests) {
                System.out.println(timeStamp + " Allowed");
            } else {
                System.out.println(timeStamp + " Blocked");
            }
            index++;
        }
    }
}