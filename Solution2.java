import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution2 {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }
        leftRotate(a,d,n);
        for(int i=0;i<n;i++)
        	System.out.print(a[i]+" ");

        scanner.close();
    }
    
    static void leftRotate(int arr[], int d, int n)
    {
      for (int i = 0; i < gcd(d, n); i++)
      {
        /* move i-th values of blocks */
        int temp = arr[i];
        int j = i;
         
        while(true)
        {
          int k = j + d;
          if (k >= n)
            k = k - n;
             
          if (k == i)
            break;
             
          arr[j] = arr[k];
          j = k;
        }
        arr[j] = temp;
      }
    }
    static int gcd(int a,int b)
    {
        if(b == 0)
        return a;
         
        else
        return gcd(b, a%b);
    }
}
