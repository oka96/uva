import java.util.*;
import java.io.*;
public class Main {   
    public static int suit(String c){
        switch(c.charAt(1)){
            case 'S': return 0;
            case 'H': return 1;
            case 'D': return 2;
            case 'C': return 3;
            default : return -1;
        }
    }
    
    public static int value(String c){
        switch(c.charAt(0)){
            case 'A': return 0;
            case 'T': return 9;
            case 'J': return 10;
            case 'Q': return 11;
            case 'K': return 12;
            default : return c.charAt(0)-'1';
        }
    }
    
    public static int getMax(int [] suit){
        int index = 0;
        int max = suit[index];
        for(int i=1;i<4;i++){
            if(max<suit[i]){
                index = i;
                max = suit[i];
            }
        }
        return index;
    }    
    
    public static void main(String[] args)throws IOException{    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        
        while((s=br.readLine())!=null&&!s.isEmpty()){
           
            StringTokenizer st = new StringTokenizer(s);
            String card[] = new String[13];
            int suit[] = new int[4];
            int count[] = new int[13];// A -> 0, 2 -> 1, K -> 12
            int sum = 0;
            
            
            for(int i=0;i<13;i++){
                card[i] = st.nextToken();
                suit[suit(card[i])]++; 
                count[value(card[i])]++;
            }
            
            sum += count[0]*4 + count[12]*3 + count[11]*2 + count[10];// rule 1
            
            // rule 2 - 4
            for(int i=0;i<13;i++){
                if(value(card[i])>=10){
                    if(suit[suit(card[i])]<=13-value(card[i])){
                        sum--;
                    }
                }
            }
            
            // suit stop
            boolean suitStop[] = new boolean[4];
            for(int i=0;i<13;i++){
                switch(value(card[i])){
                    case 0:     suitStop[suit(card[i])] = true; break;
                    case 11:    if(suit[suit(card[i])]>2){
                                    suitStop[suit(card[i])] = true;
                                }
                                break;
                    case 12:    if(suit[suit(card[i])]>1){
                                    suitStop[suit(card[i])] = true;
                                }
                                break;
                }
            }
            
            boolean allSuit = suitStop[0]&&suitStop[1]&&suitStop[2]&&suitStop[3];
            // rule 5,6,7
            if(!(allSuit&&sum>=16)){
                for(int i=0;i<4;i++){
                    if(suit[i]==2){
                        sum++;
                    }else if(suit[i]<=1){
                        sum+=2;
                    }          
                }
                if(sum<14){
                    System.out.println("PASS");
                }else{
                    String result;
                    switch(getMax(suit)){
                        case 0:     result = "S";   break; 
                        case 1:     result = "H";   break;
                        case 2:     result = "D";   break;
                        default:    result = "C";   break;
                    }
                    System.out.println("BID "+result);
                }
            }else{
                System.out.println("BID NO-TRUMP");
            }
            
        }
    }
}