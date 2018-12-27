import java.util.*;
import java.io.*;

public class Main {
    public static int arr[];
    public static int path[] = new int[6];
    public static void recursive(int start,int n){
        if(n==0){
            System.out.println(path[0]+" "+path[1]+" "+path[2]
                                +" "+path[3]+" "+path[4]+" "+path[5]);
            return;
        }
        if(arr.length-start<n){
            return;
        }
        for(int i=start;i<arr.length;i++){
            path[6-n] = arr[i];
            recursive(i+1,n-1);
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int T=0;
        while((s=br.readLine())!=null){
            if(s.equals("0")){
                break;
            }
            T++;
            if(T>1)
                System.out.println();
            StringTokenizer st = new StringTokenizer(s);
            int k = Integer.parseInt(st.nextToken());
            arr = new int[k];
            for(int i=0;i<k;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            recursive(0,6);
        }
    }
}