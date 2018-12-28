import java.util.*;
import java.io.*;
public class Main {     
    public static void main(String[] args){   
        Scanner in = new Scanner(System.in);
        int n;
        int line = 0;
        while((n=in.nextInt())!=0){
            line++;
            int d[] = new int[n];
            for(int i=0;i<n;i++){
                d[i] = in.nextInt();
            }
            int m = in.nextInt();
            System.out.printf("Case %d:\n",line);
            for(int x=0;x<m;x++){
                int m1 = in.nextInt();
                int min = Integer.MAX_VALUE;
                int hold = -1;
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if(i!=j){
                            if(Math.abs(d[i]+d[j]-m1)<min){
                                hold = d[i]+d[j];
                                min = Math.min(min,Math.abs(d[i]+d[j]-m1));
                            }
                        }
                    }
                }
                System.out.printf("Closest sum to %d is %d.\n",m1,hold);
            }
        }
    }
}