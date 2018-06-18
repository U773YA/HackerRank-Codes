//Dynamic array problem
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the dynamicArray function below.
     */
    static int[] dynamicArray(int n, int[][] queries) {
        /*
         * Write your code here.
         */
        List<Integer>[] arr=new List[n];
        int i,lastAns=0,seq,l=0;
        for(i=0;i<n;i++)
        	arr[i]=new ArrayList<>();
        for(i=0;i<queries.length;i++)
            if(queries[i][0]==2)
                l++;
        int result[]=new int[l];
        l=0;
        for(i=0;i<queries.length;i++)
        {
            if(queries[i][0]==1)
            {
                seq=(queries[i][1]^lastAns)%n;
                arr[seq].add(queries[i][2]);
            }
            else
            {
                seq=(queries[i][1]^lastAns)%n;
                lastAns=arr[seq].get(queries[i][2]%(arr[seq].size()));
                result[l++]=lastAns;
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       

        String[] nq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nq[0].trim());

        int q = Integer.parseInt(nq[1].trim());

        int[][] queries = new int[q][3];

        for (int queriesRowItr = 0; queriesRowItr < q; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 3; queriesColumnItr++) {
                int queriesItem = Integer.parseInt(queriesRowItems[queriesColumnItr].trim());
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = dynamicArray(n, queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
        	System.out.print(result[resultItr]);

            if (resultItr != result.length - 1) {
            	System.out.println("");
            }
        }
    }
}
