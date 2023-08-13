import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstInput = br.readLine();
        String secondInput = br.readLine();

        int[][] LCS = new int[firstInput.length()][secondInput.length()];

        for (int i = 0; i < firstInput.length(); i++) {
            for (int j = 0; j < secondInput.length(); j++) {
                if (firstInput.charAt(i) == secondInput.charAt(j)) {
                    if (i == 0 || j == 0) LCS[i][j] = 1;
                    else LCS[i][j] = LCS[i - 1][j - 1] + 1;
                } else {
                    if (i == 0 && j == 0) continue;
                    else if (i == 0) LCS[i][j] = LCS[i][j - 1];
                    else if (j == 0) LCS[i][j] = LCS[i - 1][j];
                    else LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        int count = LCS[LCS.length - 1][LCS[0].length - 1];
        int x = LCS.length - 1;
        int y = LCS[0].length - 1;

        while (!(x == 0 && y == 0) && count > 0) {
            while (x > 0 && LCS[x - 1][y] == count)
                x--;
            while (y > 0 && LCS[x][y - 1] == count)
                y--;


            sb.append(secondInput.charAt(y--));
            count--;
        }

        if (count != 0)
            sb.append(secondInput.charAt(0));

        System.out.println(sb.length());
        if (sb.length() != 0)
            System.out.println(sb.reverse());
    }
}