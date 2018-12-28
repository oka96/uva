import java.util.*;
import java.io.*;

public class Main {
    public static int cell[][];
    public static ArrayList<Coordinate>start;
    public static ArrayList<Coordinate>end;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=br.readLine())!=null){
            if(s.isEmpty())
                break;
            int M = Integer.parseInt(s);
            cell = new int[M][M];
            start = new ArrayList<>();
            end = new ArrayList<>();

            for(int i=0;i<M;i++){
                s = br.readLine();
                for(int j=0;j<M;j++){
                    cell[i][j] = s.charAt(j)-'0';
                    if(cell[i][j]==1){
                        start.add(new Coordinate(i,j));
                    }else if(cell[i][j]==3){
                        end.add(new Coordinate(i,j));
                    }
                }
            }
            int max = -1;
            for(int i=0;i<start.size();i++){
                int min = Integer.MAX_VALUE;
                for(int j=0;j<end.size();j++){
                    Coordinate c1 = start.get(i);
                    Coordinate c2 = end.get(j);
                    int dist = Math.abs(c1.c-c2.c)+Math.abs(c1.r-c2.r);
                    min = Math.min(min,dist);
                }
                max = Math.max(max,min);
            }
            System.out.println(max);
        }
    }
}

class Coordinate{
    int r;
    int c;
    Coordinate(int r,int c){
        this.r = r;
        this.c = c;
    }
}