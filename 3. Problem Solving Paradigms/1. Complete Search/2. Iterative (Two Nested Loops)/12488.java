import java.util.*;
import java.io.*;
public class Main{     
    //Mapping start and finish number, calculate total intersect point
    public static void main(String[] args)throws IOException{   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=br.readLine())!=null&&!s.isEmpty()){
            int n = Integer.parseInt(s);
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start[] = new int[n];
            int finish[] = new int[n];
            for(int i=0;i<n;i++){
                start[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=0;i<n;i++){
                finish[i] = Integer.parseInt(st2.nextToken());
            }
            int sum = 0;
            for(int i=0;i<n;i++){
                int pos = -1;
                for(int j=0;j<n;j++){
                    if(start[i]==finish[j]){
                        pos = j;
                        break;
                    }
                }
                for(int j=i+1;j<n;j++){
                    for(int k=0;k<pos;k++){
                        if(start[j]==finish[k]){
                            sum++;
                            break;
                        }
                    }
                }
            }
            System.out.println(sum);
        }
    }
}