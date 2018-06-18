import java.io.*;
import java.util.*;

public class kthfact {
    
	static int[] sort(int[] a)
    {
        int n=a.length;
        int i,j,temp=0;
        for(i=0;i<n;i++){
            for(j=1;j<n-i;j++){
                if(a[j-1]>a[j]){
                    temp=a[j-1];
                    a[j-1]=a[j];
                    a[j]=temp;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        int a[]=new int[k];
        int b[] = new int[100];
        int i,c;
        for(i=0;i<k;i++)
            a[i]=in.nextInt();
        a=sort(a);
        i=k-1;
        c=0;
        while(i>=0){
            if(n%a[i]!=0)
                i--;
            else{
            	System.out.println(n+" ");
            	b[c++]=n;
                n=n/a[i];
            }
        }
        System.out.print("1 ");
        for(i=c-1;i>=0;i--){
        	System.out.print(b[i]+" ");
        }
    }
}