/*  2. Travel Planning (difficulty: 5)
    You are going on a long trip. You start on the road at mile post
    0. Along the way there are n hotels, at mile posts
    a1 < a2 < · · · < an, where each ai is measured from the starting
    point. The only places you are allowed to stop are at these
    hotels, but you can choose which of the hotels you stop at.
    Your destination is the final hotel (at distance an) and you
    must stop there.
    You’d ideally like to travel 200 miles a day, but this may not be
    possible, depending on the spacing of the hotels. If you travel x
    miles during a day, the penalty for that day is (200 − x)^2. Your
    task is to give an efficient algorithm that minimizes the total
    penalty —that is, the sum, over all travel days, of the daily
    penalties.*/

import java.util.Random;

public class ProblemTwo {
    private static int n = 10;
    private static int MILES_PER_DAY = 200;

    public static void main(String[] args){
        //Initialize hotels
        Random rand = new Random();
        int[] hotels = new int[n];
        hotels[0] = rand.nextInt(MILES_PER_DAY);
        for(int i = 1; i < n; i++)
            hotels[i] = hotels[i - 1] + rand.nextInt(MILES_PER_DAY);

        int[] cost = computeCost(hotels);

        //Print the cost at hotel n
        System.out.println(cost[n - 1]);
    }

    public static int[] computeCost(int[] hotels){
        //Build the DP array
        int[] cost = new int[n];
        cost[0] = 0;

        for(int i = 1; i < n; i++){
            int minCost = Integer.MAX_VALUE;
            for(int k = 0; k < i; k++){
                int currentCost = cost[k] +
                                 (int)(Math.pow(MILES_PER_DAY - (hotels[i] - hotels[k]), 2));
                if(currentCost < minCost)
                    minCost = currentCost;
            }
            cost[i] = minCost;
        }

        return cost;
    }
}
