import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        List<String> list = new ArrayList<>();
        for(int i=1;i<input.length()-1;i++){
            String head = new StringBuilder(input.substring(0,i)).reverse().toString();
            for(int j=i+1;j<input.length();j++){
                String body = new StringBuilder(input.substring(i,j)).reverse().toString();
                String tail = new StringBuilder(input.substring(j,input.length())).reverse().toString();

                list.add(head+body+tail);
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}