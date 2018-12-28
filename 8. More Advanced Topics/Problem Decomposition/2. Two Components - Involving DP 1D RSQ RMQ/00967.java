import java.util.*;
import java.io.*;

public class Main{
    public static BufferedReader br;
    public static PrintWriter pr;
    public static BufferedReader getInput(String arg[])throws IOException{
        if(arg.length==0){
            return new BufferedReader(new InputStreamReader(System.in));
        }else{
            return new BufferedReader(new FileReader(arg[0]));
        }        
    }
    public static boolean composite[] = new boolean[1000000];
    public static ArrayList<Integer> prime = new ArrayList<>(); 
    public static ArrayList<Integer> cp = new ArrayList<>();
    public static void soe(int up){
        int sqrt = (int)Math.sqrt(up);
        for(int i=2;i<=sqrt;i++){
            if(!composite[i]){
                prime.add(i);
                for(int j=i*i;j<=up;j+=i){
                    composite[j] = true;
                }
            }
        }
        for(int i=sqrt+1;i<=up;i++){
            prime.add(i);
        }
    }
    public static boolean circularPrime(int num){
        int digit = (int)Math.floor(Math.log10(num)+1);
        boolean circular = true;
        int count = digit;
        while(count>0){
            if(composite[num]){
               circular = false;
               break; 
            }
            int r = num%10;
            num = (num/10)+(int)Math.pow(10,digit-1)*r;
            count--;
        }
        return circular;
    }
    public static void gencp(){
        for(int i:prime){
            if(circularPrime(i)){
                cp.add(i);
            }
        }
    }
    public static void main(String arg[])throws IOException{
        br = getInput(arg);
        pr = new PrintWriter(System.out);
        soe(999999);
        circularPrime(41);
        gencp();
        int arr[] = new int[10000000];
        for(int i:cp){
            arr[i] = 1;
        }
        RMQ rmq = new RMQ();
        rmq.constructST(arr,arr.length);
        String s;
        while((s=br.readLine())!=null){
            if(s.equals("-1")){
                break;
            }
            StringTokenizer st = new StringTokenizer(s);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int ans = rmq.rmq(arr.length, a, b);
            if(ans==0){
                pr.println("No Circular Primes.");
            }else if(ans==1){
                pr.println("1 Circular Prime.");
            }else{
                pr.printf("%d Circular Primes.\n",ans);
            }
        }
        pr.close();
    }
}

class RMQ{
    int tree[];
    int constructSTUtil(int arr[],int ss,int se,int i){
        if(ss==se){
            tree[i] = arr[ss];
            return tree[i];
        }
        int mid = ss+(se-ss)/2;
        tree[i] = constructSTUtil(arr, ss, mid, 2*i+1)
            + constructSTUtil(arr, mid+1, se, 2*i+2);
        return tree[i];
    }
    void constructST(int arr[],int n){
        int x = (int)Math.ceil(Math.log(n)/Math.log(2));
        int max = 2*(int)Math.pow(2,x)-1;
        tree = new int[max];
        constructSTUtil(arr,0,n-1,0);
    }
    int rmqUtil(int ss,int se,int qs,int qe,int i){
        if(qs<=ss && qe>=se){
            return tree[i];
        }
        if(se<qs||ss>qe){
            return 0;
        }
        int mid = ss+(se-ss)/2;
        int ans = rmqUtil(ss,mid,qs,qe,2*i+1)
            + rmqUtil(mid+1,se,qs,qe,2*i+2);
        return ans;
    }
    int rmq(int n,int qs,int qe){
        return rmqUtil(0,n-1,qs,qe,0);
    }
}