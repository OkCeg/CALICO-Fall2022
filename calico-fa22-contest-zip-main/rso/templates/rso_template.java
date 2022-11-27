import java.io.*;

class Solution {
    /**
     * Determine if the RSO name for an entry is valid. Return True if it is and
     * return False otherwise.
     * 
     * Y: the year the RSO was established
     * N: the name the RSO registered with
     */
    static boolean solve(int Y, String N) {
        if (N.length() > 50)
        {
            return false;
        }
        if (Y >= 2010)
        {
            String[] arrOfStr = N.split(" ");
            String[] arr = {"CALIFORNIA", "CAL", "BERKELEY"};
            for (String test : arr)
            {
                if (arrOfStr[0].toUpperCase().equals(test))
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(in.readLine());
        for (int i = 0; i < T; i++) {
            int Y = Integer.parseInt(in.readLine());
            String N = in.readLine();
            out.println(solve(Y, N) ? "VALID" : "INVALID");
        }
        out.flush();
    }
}
