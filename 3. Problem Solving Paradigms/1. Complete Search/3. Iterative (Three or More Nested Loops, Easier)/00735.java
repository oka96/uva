import java.util.*;
import java.io.*;

public class Main {
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static int comb[] = new int[1000];
    public static int perm[] = new int[1000];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        arr.add(0);
        arr.add(50);
        for(int i=1;i<=3;i++){
            for(int j=1;j<=20;j++){
                int total = i*j;
                if(!arr.contains(total)){
                    arr.add(total);
                }
            }
        }
        Collections.sort(arr,new Comparator<Integer>(){
            @Override
            public int compare(Integer a,Integer b){
                return b-a;
            }
        });
        for(int i=0;i<arr.size();i++){
            for(int j=i;j<arr.size();j++){
                for(int k=j;k<arr.size();k++){
                    int sum = arr.get(i)+arr.get(j)+arr.get(k);
                    if(i==j&&j==k){
                        perm[sum]++;
                    }else if(i==j||j==k){
                        perm[sum]+=3;
                    }else{
                        perm[sum]+=6;
                    }
                    comb[sum]++;
                }
            }
        }
        while((s=br.readLine())!=null){
            int N = Integer.parseInt(s);
            if(N<=0){
                break;
            }
            if(comb[N]==0){
                System.out.printf("THE SCORE OF %d CANNOT BE MADE WITH THREE DARTS.\n",N);
            }else{
                System.out.printf("NUMBER OF COMBINATIONS THAT SCORES %d IS %d.\n",N,comb[N]);
                System.out.printf("NUMBER OF PERMUTATIONS THAT SCORES %d IS %d.\n",N,perm[N]);
            }
            for(int i=0;i<70;i++){
                System.out.printf("*");
            }
            System.out.println();
        }
        System.out.println("END OF OUTPUT");
    }
}