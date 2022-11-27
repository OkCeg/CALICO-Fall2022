import java.io.*;

class Template {
    /**
     * Return the minimum cost to convert all of the paint into a single color.
     * 
     * W: non-negative number of buckets of white paint
     * O: non-negative number of buckets of orange paint
     * B: non-negative number of buckets of brown paint
     * Cow: positive cost to convert between a bucket of orange and white paint
     * Cbo: positive cost to convert between a bucket of brown and orange paint
     * Cbw: positive cost to convert between a bucket of brown and white paint
     */
    static int solve(int W, int O, int B, int Cow, int Cbo, int Cbw) {
        int[] possibilities = new int[3];
        int sum = 0;
        // all to white
        if (Cbo + Cbw < Cow)
        {
            sum += O * (Cbo + Cbw);
        }
        else
        {
            sum += O * (Cow);
        }
        if (Cbo + Cow < Cbw)
        {
            sum += B * (Cbo + Cow);
        }
        else
        {
            sum += B * (Cbw);
        }
        possibilities[0] = sum;

        sum = 0;
        // all to orange
        if (Cbw + Cbo < Cow)
        {
            sum += W * (Cbo + Cbw);
        }
        else
        {
            sum += W * (Cow);
        }
        if (Cbw + Cow < Cbo)
        {
            sum += B * (Cbw + Cow);
        }
        else
        {
            sum += B * (Cbo);
        }
        possibilities[1] = sum;

        sum = 0;
        // all to brown
        if (Cow + Cbo < Cbw)
        {
            sum += W * (Cow + Cbo);
        }
        else
        {
            sum += W * (Cbw);
        }
        if (Cbw + Cow < Cbo)
        {
            sum += O * (Cbw + Cow);
        }
        else
        {
            sum += O * (Cbo);
        }
        possibilities[2] = sum;

        int min = possibilities[0];
        for (int i : possibilities)
        {
            if (min > i)
            {
                min = i;
            }
        }
        
        return min;
    }
    
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(in.readLine());
        for (int i = 0; i < T; i++) {
            String[] line = in.readLine().split(" ");
            int W = Integer.parseInt(line[0]);
            int O = Integer.parseInt(line[1]);
            int B = Integer.parseInt(line[2]);
            int Cow = Integer.parseInt(line[3]);
            int Cbo = Integer.parseInt(line[4]);
            int Cbw = Integer.parseInt(line[5]);
            out.println(solve(W, O, B, Cow, Cbo, Cbw));
        }
        out.flush();
    }
}
