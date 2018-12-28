import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main{
    public static boolean composite[] = new boolean[1000001];
    public static ArrayList<Integer> pn = new ArrayList<>();
    public static int sod(int num){
        int total = 0;
        while(num>0){
            total += num%10;
            num /= 10;
        }
        return total;
    }
    public static boolean valid(int num){
        int sod = sod(num);
        return !composite[sod];
    }
    public static void soe(int up){
        int sqrt = (int)Math.sqrt(up);
        for(int i=2;i<=sqrt;i++){
            if(!composite[i]){
                if(valid(i)){
                    pn.add(i);
                }
                for(int j=i*i;j<=up;j+=i){
                    composite[j] = true;
                }
            }
        }
        for(int i=sqrt+1;i<=up;i++){
            if(composite[i]){
                continue;
            }
            if(!valid(i)){
                continue;
            }
            pn.add(i);
        }
    }

    public static void main(String arg[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("a.in"));
        PrintWriter pr = new PrintWriter(System.out);
        soe(1000000);
        int arr[] = new int[1000001];
        for(int i:pn){
            arr[i] = 1;
        }
        RMQ rmq = new RMQ();
        rmq.constructST(arr,arr.length);
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(rmq.RMQ(arr.length,a,b));
        }
        pr.close();
    }
}

class RMQ{
    int tree[];
    int getMid(int a,int b){
        return a+(b-a)/2;
    }
    int constructSTUtil(int arr[],int ss,int se,int index){
        if(ss==se){
            tree[index] = arr[ss];
            return tree[index];
        }
        int mid = getMid(ss,se);
        tree[index] = constructSTUtil(arr, ss, mid, 2*index+1)
                +constructSTUtil(arr, mid+1, se, 2*index+2);
        return tree[index];
    }
    void constructST(int arr[],int n){
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2))); 
        int max_size = 2 * (int) Math.pow(2, x) - 1; 
        tree = new int[max_size]; 
        constructSTUtil(arr,0,n-1,0);
    }
    int RMQUtil(int ss,int se,int qs,int qe,int index){
        if(qs<=ss && qe>= se){
            return tree[index];
        }
        if(se<qs||ss>qe){
            return 0;
        }
        int mid = getMid(ss,se);
        int ans = RMQUtil(ss,mid,qs,qe,2*index+1)+RMQUtil(mid+1,se,qs,qe,2*index+2);
        return ans;
    }
    int RMQ(int n,int qs,int qe){
        if(qs<0||qe>n-1||qs>qe){
            return -1;
        }
        return RMQUtil(0,n-1,qs,qe,0);
    }
}