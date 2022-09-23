import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    static int ans;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ans = 0;
        int[] arr = new int[N];
        
        for(int i=0;i<N;i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i=arr.length-1;i>=0;i--){
        	while(true) {
        		if(arr[i] <= K) {
        			K -=arr[i];
        			ans++;
        		}else {
        			break;
        		}
        	}
        }
        
        System.out.println(ans);
        
    }
}