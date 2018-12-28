import java.util.*;
import java.io.*;
public class Main {
    public static int index(String [] name, String target){
        for(int i=0;i<name.length;i++){
            if(target.equals(name[i])){
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args)throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String s;
         int line = 0;
         while((s=br.readLine())!=null){
             line++;
             
             if(line!=1)
                 System.out.println("");
             
             int n = Integer.parseInt(s);
             String name[] = new String[n];
             int account[] = new int[n];
             
             StringTokenizer st = new StringTokenizer(br.readLine());
             
             for(int i=0;i<n;i++){
                 name[i] = st.nextToken();
             }
             
             for(int i=0;i<n;i++){
                 StringTokenizer st2 = new StringTokenizer(br.readLine());
                
                 int accountNo = index(name,st2.nextToken());
                 int loss = Integer.parseInt(st2.nextToken());
                 int ppl = Integer.parseInt(st2.nextToken());
                 
                 
                 if(ppl!=0){
                    account [accountNo] -= loss-(loss%ppl);
                    String acceptor[] = new String[ppl];
                    
                    for(int j=0;j<ppl;j++){
                        acceptor[j] = st2.nextToken();
                    }
                    
                    for(int j=0;j<ppl;j++){
                        for(int k=0;k<n;k++){
                            if(name[k].equals(acceptor[j])){
                                account[k] += loss/ppl;
                                break;
                            }
                        }
                    }
                 }
             }
             
             for(int i=0;i<n;i++){
                 System.out.printf("%s %d\n",name[i],account[i]);
             }
             
         }             
    }
}