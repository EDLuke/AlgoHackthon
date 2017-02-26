/*  1.Cost of running a business (difficulty: 5)
    You are running a small business for n months. Each month i, you
    either run it out of your office in New York and incur an operating
    cost Ni, or out of your office in Seattle and incur a cost Si.
    If you move to a different city in month i + 1, you pay a fixed cost M.
    A plan is a sequence of n locations such that the i-th location
    indicates the city you will based in month i. The cost of a plan is the
    sum of all the operating costs plus any moving costs. Give an
    algorithm that computes the plan of minimum cost, and its cost*/

public class ProblemOne {
    private static final int NY = 0;
    private static final int SE = 1;

    private static final int n = 4;
    private static final int m = 10;

    private static int   cost;
    private static int[] plan;

    public static void main(String[] args){
        //Initialize cost map
        int[][] costMap = new int[n][2];
        costMap[0][NY] = 1;
        costMap[1][NY] = 3;
        costMap[2][NY] = 20;
        costMap[3][NY] = 30;
        costMap[0][SE] = 50;
        costMap[1][SE] = 20;
        costMap[2][SE] = 2;
        costMap[3][SE] = 4;

        cost = 0;
        plan = new int[n];

        computeCost(costMap);

        //Print the plan
        for(int i = 0; i < n; i++){
            System.out.print(plan[i] == NY ? "NY" : "SE");
            System.out.print("\t");
        }

        //Print the cost
        System.out.println("\n" + cost);
    }

    private static void computeCost(int[][] costMap){
        int currentCity = -1;
        int currentM_NY = 0;
        int curretnM_SE = 0;

        for(int i = 0; i < n; i++){
            switch (currentCity){
                case -1:
                    currentM_NY = 0;
                    curretnM_SE = 0;
                    break;
                case NY:
                    currentM_NY = 0;
                    curretnM_SE = m;
                    break;
                case SE:
                    currentM_NY = m;
                    curretnM_SE = 0;
                    break;
            }


            if(costMap[i][NY] + currentM_NY > costMap[i][SE] + curretnM_SE){
                currentCity = SE;
                cost    += costMap[i][SE] + curretnM_SE;
                plan[i]  = SE;
            }
            else{
                currentCity = NY;
                cost    += costMap[i][NY] + currentM_NY;
                plan[i]  = NY;
            }

        }
    }
}
