/*  3. A game with stones (difficulty: 5)
    You’re playing a game with stones. At the beginning of the
    game, there are n piles of stones, each of size pi ≥ 1, in a line.
    Your goal is to merge the stones in one big pile subject to the
    following rules of the game:
    1. At each step, you can merge two adjacent piles of sizes x, y to obtain a new pile of size x + y.
    2. The cost of merging a pile of size x with a pile of size y is x + y.
    Your goal is to merge all the stones in one big pile so that the
    total cost is minimized. Design an algorithm for this task.*/

import java.util.Random;

public class ProblemThree {
    private static int n = 10;

    public static void main(String[] args){
        //Initialize piles of stones
        int[] piles = new int[n];
        Random rand = new Random();

        for(int i = 0; i < n; i++)
            piles[i] = rand.nextInt(99) + 1;

        int[][] cost = computeCost(piles);

        System.out.println(cost[1][n - 1]);
    }

    public static int[][] computeCost(int[] piles){
        //Initialize cost of merging two piles
        int[][] costMerge = new int[n][n];

        for(int i = 0; i < n; i++){
            costMerge[i][i] = piles[i];

            for(int j = i + 1; j < n; j++)
                costMerge[i][j] = costMerge[i][j - 1] + piles[j];

        }

        //Compute DP 2D array
        int[][] cost = new int[n][n];
        for(int i = 0; i < n; i++)
            cost[i][i] = 0;

        for(int length = 2; length <= n; length++){
            for(int i = 0; i + length - 1 < n; i++){
                int j = i + length - 1;
                int currentMin = Integer.MAX_VALUE;

                for(int k = i; k < j; k++)
                    currentMin = Math.min(currentMin, cost[i][k] + cost[k + 1][j]);

                cost[i][j] = currentMin + costMerge[i][j];
            }
        }

        return cost;
    }
}
