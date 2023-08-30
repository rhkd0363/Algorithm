import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String upBridge = br.readLine();
        String downBridge = br.readLine();
        int[][] upDp = new int[input.length() + 1][upBridge.length() + 1];
        int[][] downDp = new int[input.length() + 1][downBridge.length() + 1];
        Arrays.fill(upDp[0], 1);
        Arrays.fill(downDp[0], 1);
        for (int i = 0; i < upBridge.length(); i++) {
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == upBridge.charAt(i) && downDp[j][i] != 0) {
                    upDp[j + 1][i + 1] = upDp[j + 1][i] + downDp[j][i];
                } else {
                    upDp[j + 1][i + 1] = upDp[j + 1][i];
                }
                if (input.charAt(j) == downBridge.charAt(i) && upDp[j][i] != 0) {
                    downDp[j + 1][i + 1] = downDp[j + 1][i] + upDp[j][i];
                } else {
                    downDp[j + 1][i + 1] = downDp[j + 1][i];
                }
            }
        }
        System.out.println(upDp[input.length()][downBridge.length()] + downDp[input.length()][downBridge.length()]);
    }
}