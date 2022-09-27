import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    static int N;
    static int[] arr;
    static boolean[] check;
    static int[] result;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i=1;i<=10;i++) {
        	int t = Integer.parseInt(br.readLine());
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	
        	System.out.println("#"+t+" "+func(N,M));
        }
    }
    
    static int func(int N,int M) {
    	if(M == 1)
    		return N;
    	if(M % 2 == 0) {
    		return func(N,M/2) * func(N,M/2);
    	}else {
    		return func(N,(M-1)/2) *func(N,(M-1)/2) * N;
    	}
    }
}