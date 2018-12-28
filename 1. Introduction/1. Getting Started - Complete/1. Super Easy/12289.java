import java.util.*;
import java.io.*;
public class Main {
    public static boolean check(String a,String b){
        int diff = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i))
                diff++;
        }
        if(diff>1)
            return false;
        else 
            return true;
    }    
    
    public static int recognize(String s){
        if(s.length()==3){
            if(check(s,"one")){
                return 1;
            }else if(check(s,"two")){
                return 2;
            }else{
                return 6;
            }
        }else if(s.length()==4){
            if(check(s,"zero")){
                return 0;
            }else if(check(s,"four")){
                return 4;
            }else if(check(s,"five")){
                return 5;
            }else{
                return 9;
            }
        }else{
            if(check(s,"three")){
                return 3;
            }else if(check(s,"seven")){
                return 7;
            }else{
                return 8;
            }
        }
    }
    
    public static void main(String[] args){
       Scanner in = new Scanner(System.in);
       
       int n = in.nextInt();
       
       for(int i=0;i<n;i++){
           System.out.println(recognize(in.next()));
       }
       
    }
}
