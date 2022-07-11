import java.io.File;
import java.util.Scanner;

public class ChangeMaker {

    public static void main(String[] args)
    {
        // Get info from user
        System.out.println("Enter number of coins and values in decreasing order: ");
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();

        // Create denomination array
        int[] denoms = new int[k];
        for(int i = 0; i < k; i++)
            denoms[i] = in.nextInt();

        // Get n
        int n;
        System.out.println("Enter total number of cents to make change for. Enter 0 to quit.");
        n = in.nextInt();

        while(n > 0)
        {
            // Get change and output results
            int[] R = change_DP(n, denoms);
            // Output results
            System.out.printf("DP algorithm results%nAmount: %d%n", n);
            System.out.printf("Optimal distribution: ");
            int count = 0;
            for(int j = 0; j < R.length; j++)
            {
                if(R[j] > 0)
                {
                    if(count == 0)
                        System.out.printf("%d*%dc", R[j], denoms[j]);
                    else
                        System.out.printf(" + %d*%dc", R[j], denoms[j]);
                    count += R[j];
                }
            }
            System.out.printf("%nOptimal coin count: %d%n", count);

            System.out.println("Enter total number of cents to make change for. Enter 0 to quit.");
            n = in.nextInt();
        }
    }

    public static int[] change_DP(int n, int[] d)
    {
        int[] C = new int[n+1];
        int[] A = new int[n+1];

        for(int j = 1; j <= n; j++) // Solve Cj
        {
            int min = 1000000000;
            for(int i = 0; i < d.length; i++)
            {
                if(j >= d[i])
                    if(C[j - d[i]] < min)
                    {
                        min = C[j - d[i]];
                        A[j] = i;
                    }
            }
            C[j] = 1 + min;
        }

        int[] B = new int[d.length];
        while(n > 0)
        {
            B[A[n]] += 1;
            n -= d[A[n]];
        }

        return B;
    }


}
