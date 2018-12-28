import java.util.*;
import java.io.*;
public class Main{     
    public static void main(String[] args)throws IOException{   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while(!(s=br.readLine()).equals("0")){
            StringTokenizer st = new StringTokenizer(s);
            int f = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int front[] = new int[f];
            int rear[] = new int[r];
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int i=0;i<f;i++){
                front[i] = Integer.parseInt(st2.nextToken());
            }
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            for(int i=0;i<r;i++){
                rear[i] = Integer.parseInt(st3.nextToken());
            }
            
            ArrayList<Double> d = new ArrayList<>();
            
            for(int i=0;i<f;i++){
                for(int j=0;j<r;j++){
                    Double d1 = Double.valueOf(rear[j])/front[i];  
                    if(!d.contains(d1)){
                        d.add(d1);
                    }
                }
            }
            Collections.sort(d);
            Double max = 1.0;//if d1=d2
            for(int i=0;i<d.size()-1;i++){
                max = Math.max(max,d.get(i+1)/d.get(i));
            }
            System.out.printf("%.2f\n",max);          
        }        
    }
}