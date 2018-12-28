import java.util.*;
import java.io.*;
public class Main{                  
    public static int bin[] = new int[9];
    public static int position[] = new int[3];
    public static int min;
    public static int hold;
    public static int minPosition[] = new int[3];
    
    public static boolean place(int p,int d){
        for(int i=0;i<d;i++){
            if(position[i]==p+1){
                return false;
            }
        }
        return true;
    }
    
    public static void backtrack(int d){
        if(d<3){
            for(int i=0;i<=2;i++){
                int count = 0;
                
                for(int j=0;j<3;j++){
                    if(j!=d){
                        count += bin[j*3+i];
                    }
                }         
                
                if(place(i,d)&&hold+count<min){
                    hold += count;
                    position[d] = i+1;
                    backtrack(d+1);
                    position[d] = 0;
                    hold -= count;
                }
            }
        }else{
            if(hold<min){
                min = hold;
                for(int i=0;i<3;i++){
                    minPosition[i] = position[i];
                }
            }
        }
    }
    
    public static void main(String[] args)throws IOException{   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=br.readLine())!=null&&!s.isEmpty()){
            StringTokenizer st = new StringTokenizer(s);
            for(int i=0;i<9;i++){
                int c = (3-(i%3))%3;
                bin[(i/3)*3+c] = Integer.parseInt(st.nextToken());
            }
            min = Integer.MAX_VALUE;
            hold = 0;
            backtrack(0);
            for(int i=0;i<3;i++){
                if(minPosition[i]==1) System.out.print("B");
                else if(minPosition[i]==2) System.out.print("C");
                else System.out.print("G");
            }
            System.out.println(" "+min);
        }
    }
}
