/*
    4. Longest monotonically increasing subsequence (difficulty: 5)
    Give an efficient algorithm to compute the length of the longest
    increasing subsequence of a sequence of numbers a1, . . . , an.
    A subsequence is any subset of these numbers taken in order, of
    the form ai1, ai2, . . . , aik, where 1 ≤ i1 < i2 < . . . < ik ≤ n. An
    increasing subsequence is one in which the numbers are getting strictly larger.
    Example
    Input: 5, 2, 8, 6, 3, 6, 7
    Output: 4 (corresponding to subsequence 2, 3, 6, 7)
*/

public class ProblemFour {
    public static void main(String[] args){
        //Initialize the input
        int[] input = new int[]{5, 2, 8, 6, 3, 6, 7};

        int max = computeLongest(input);
        System.out.println(max);
    }

    private static int computeLongest(int[] input){
        int[] dp = new int[input.length];

        for(int i = 0; i < input.length; i++)
            dp[i] = 1;

        for(int i = 1; i < input.length; i++){
            for(int j = 0; j < i; j++){
                if(input[i] > input[j] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < dp.length; i++)
            max = Math.max(max, dp[i]);

        return max;
    }
}
