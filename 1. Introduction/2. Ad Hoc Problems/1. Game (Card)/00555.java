import java.util.*;
import java.io.*;
public class Main {   
    public static int get(String dir){
        switch(dir){
            case "S": return 0;
            case "W": return 1;
            case "N": return 2;
            case "E": return 3;
            default : return -1;
        }
    }
 
    public static int value(char suit,char num){
        int v = 0;
        
        switch(suit){
            case 'C': v +=  0; break;
            case 'D': v += 13; break;
            case 'S': v += 26; break;
            case 'H': v += 39; break;
        }
        
        switch(num){
            case 'T': v +=  8; break; 
            case 'J': v +=  9; break;
            case 'Q': v += 10; break;
            case 'K': v += 11; break;
            case 'A': v += 12; break;
            default : v += num-'2';           
        }
        
        return v;
    }
    
    public static String card(int n){
        String card = "";
        
        switch(n/13){
            case 0: card += 'C'; break;
            case 1: card += 'D'; break;
            case 2: card += 'S'; break;
            case 3: card += 'H'; break;
        }
        
        switch(n%13){
            case  8: card += 'T'; break;
            case  9: card += 'J'; break;
            case 10: card += 'Q'; break;
            case 11: card += 'K'; break;
            case 12: card += 'A'; break;
            default: card += (char)((n%13)+'2'); 
        }
        return card;
    }
    
    public static void main(String[] args)throws IOException{    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while(!(s=br.readLine()).equals("#")){
            int turn = (get(s)+1)%4;
            int r[] =  new int[4];
            int value[][] = new int[4][13];
            for(int f=0;f<2;f++){
                String c = br.readLine();
                for(int i=0;i<26;i++){
                    char suit = c.charAt(2*i);
                    char num = c.charAt(2*i+1);
                    value[turn][r[turn]]= value(suit,num);
                    r[turn]++;
                    turn = (turn+1)%4;
                }           
            }
            
            for(int i=0;i<4;i++){
                Arrays.sort(value[i]);
            }

            char suit[] = {'S','W','N','E'};

            for(int i=0;i<4;i++){
                System.out.print(suit[i]+":");
                for(int j=0;j<13;j++){
                    System.out.print(" "+card(value[i][j]));
                }
                System.out.println("");
            }
        }             
    }
}