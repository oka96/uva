// refer yyk's code
import java.util.*;
import java.io.*;
public class Main {    
    
    public static void main(String[] args)throws IOException{    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        HashMap<String,String> m = new HashMap<>();
        
        m.put("+x+y","+y");
        m.put("+x-y","-y");
        m.put("+x+z","+z");
        m.put("+x-z","-z");
        
        m.put("-x+y","-y");
        m.put("-x-y","+y");
        m.put("-x+z","-z");
        m.put("-x-z","+z");
        
        m.put("+y+y","-x");
        m.put("+y-y","+x");
        m.put("+y+z","+y");
        m.put("+y-z","+y");
        
        m.put("-y+y","+x");
        m.put("-y-y","-x");
        m.put("-y+z","-y");
        m.put("-y-z","-y");
        
        m.put("+z+y","+z");
        m.put("+z-y","+z");
        m.put("+z+z","-x");
        m.put("+z-z","+x");
        
        m.put("-z+y","-z");
        m.put("-z-y","-z");
        m.put("-z+z","+x");
        m.put("-z-z","-x");
                
        
        while(!(s=br.readLine()).equals("0")){
            int n = Integer.parseInt(s);
            StringTokenizer st = new StringTokenizer(br.readLine());
            String dir = "+x";
            
            for(int i=0;i<n-1;i++){
                String next = st.nextToken();
                if(!next.equals("No")){
                    dir = m.get(dir+next);
                }
            }         
            System.out.println(dir);
        }
    }
}