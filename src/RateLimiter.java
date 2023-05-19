import java.util.Arrays;
import java.util.Random;

public class RateLimiter {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int maximumNumberOfRequests = Integer.parseInt(input.nextLine());
//        int slidingWindowPeriod = Integer.parseInt(input.nextLine());
//        String[] timeStampSequence = input.nextLine().split(" ");
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int maximumNumberOfRequests = random.nextInt(10) + 1;
            int slidingWindowPeriod = random.nextInt(10) + 1;

            int sequenceLength = random.nextInt(20) + 1;
            StringBuilder sequenceBuilder = new StringBuilder();

            for (int j = 0; j < sequenceLength; j++) {
                sequenceBuilder.append(random.nextInt(20) + 1).append(" ");
            }

            String[] sequence = sequenceBuilder.toString().trim().split(" ");
            Arrays.sort(sequence);

            System.out.println("Test Case " + (i + 1) + ":");
            System.out.println("Maximum Number of Requests: " + maximumNumberOfRequests);
            System.out.println("Sliding Window Period: " + slidingWindowPeriod);
            System.out.println("Timestamp Sequence: " + Arrays.toString(sequence));
            System.out.println("Expected Output:");

            findRateLimit(sequence, maximumNumberOfRequests, slidingWindowPeriod);
            System.out.println("----------------------------------------");
        }

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