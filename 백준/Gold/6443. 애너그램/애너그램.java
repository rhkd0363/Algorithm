import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            String input = br.readLine();
            StringBuilder sb = new StringBuilder();
            char[] arr = new char[input.length()];
            for(int j=0; j<arr.length; j++)
                arr[j] = input.charAt(j);
            Arrays.sort(arr);
            for(int j=0; j<arr.length; j++)
                sb.append(arr[j]);
            sb.append("\n");
            while(next_permutation(arr)) {
                for(int j=0; j<arr.length; j++)
                    sb.append(arr[j]);
                sb.append("\n");
            }
            System.out.print(sb.toString());
        }
    }
    public static boolean next_permutation(char[] arr) {
        int i = arr.length-1;
        while(i>0 && arr[i]<=arr[i-1])
            i--;          
        if(i<=0) return false;
        int j = arr.length-1;
        while(arr[i-1]>=arr[j])
            j--;          
        char temp = arr[j];
        arr[j] = arr[i-1];
        arr[i-1] = temp;  
        j = arr.length-1;
        while(i<j) {
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i++;
            j--;
        }
        return true;
    }
}