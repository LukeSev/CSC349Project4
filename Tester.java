public class Tester {

    public static void main(String[] args)
    {
        // Create denomination lists
        int d1[] = {100, 50, 25, 10, 5, 1};
        int d2[] = {100, 50, 20, 15, 10, 5, 3, 2, 1};
        int d3[] = {64, 32, 16, 8, 4, 2, 1};
        int d4[] = {100, 50, 25, 10, 1};
        int d5[] = {66, 35, 27, 18, 10, 1};

        int d[][] = {d1, d2, d3, d4, d5};

        int[] dp, greedy;
        // Start tests
        System.out.println("Testing change_DP and change_greedy algorithms");

        for(int k = 0; k < 5; k++)
        {
            int count = 0;
            int dp_coins = 0, greedy_coins = 0;
            for(int i = 1; i < 201; i++)
            {
                dp = ChangeMaker.change_DP(i, d[k]);
                greedy = ChangeMaker.change_greedy(i, d[k]);
                dp_coins = 0;
                greedy_coins = 0;
                for(int j = 0; j < d[k].length; j++)
                {
                    if(dp[j] != 0)
                        dp_coins += dp[j];
                    if(greedy[j] != 0)
                        greedy_coins += greedy[j];
                }
                if(dp_coins == greedy_coins)
                    count++;
                else
                    count += 0;
            }
            System.out.printf("Testing set%d: %d matches in 200 tests%n", k+1, count);
        }

    }


}
