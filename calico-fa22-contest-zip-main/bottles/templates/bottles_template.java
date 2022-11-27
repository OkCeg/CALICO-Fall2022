import java.io.*;
import java.util.*;

class Template {
    /**
    * Output the minimum total wait time on the first line.
    * Output the optimal new permutation on the second line.
    * 
    * N: the number of students in line
    * C: the list of the bottle capacities, in liters, for each student
    */
    static void solve (int N, int[] C) {
        Set<Integer> checked = new HashSet<Integer>();
        int[] sortedIndex = new int[N];
        String test = "";
        int sum = 0;
        for (int i = 0; i < N; i++)
        {
            int minIndex = -1;
            int min = 1000000001;
            for (int j = N-1; j >= 0; j--)
            {
                if (!checked.contains(j))
                {
                    if (C[j] < min)
                    {
                        min = C[j];
                        minIndex = j;
                    }
                    else if (C[j] == min)
                    {
                        if (i == j)
                        {
                            min = C[j];
                            minIndex = j;
                        }
                    }
                }
            }
            checked.add(minIndex);
            sortedIndex[i] = minIndex;
            sum += C[minIndex] * (N-i);
            test += sortedIndex[i]+1 + " ";
        }
        System.out.println(sum);
        System.out.println(test.substring(0, test.length()));
    }
    
    static BufferedReader in = new BufferedReader(
        new InputStreamReader(System.in)
    );
    static PrintWriter out = new PrintWriter(System.out);

    public static void main (String[] args) throws IOException {
        int T = Integer.parseInt(in.readLine());
        for (int i = 0; i < T; ++i) {
            int N = Integer.parseInt(in.readLine());
            String[] Cs = in.readLine().split(" ");
            int[] C = new int[N];
            for (int j = 0; j < N; ++j) C[j] = Integer.parseInt(Cs[j]);
            solve(N, C);
        }
        out.flush();
    }
}