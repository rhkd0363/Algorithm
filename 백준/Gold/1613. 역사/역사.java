import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[][] arr = new int[n + 1][n + 1];

    for (int i = 0; i < k; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      arr[x][y] = -1;
      arr[y][x] = 1;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        for (int l = 1; l <= n; l++) {
          if (arr[j][i] == -1 && arr[i][l] == -1) {
            arr[j][l] = -1;
            arr[l][j] = 1;
          }
        }
      }
    }

    int s = sc.nextInt();
    for (int i = 0; i < s; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      
      if(x < 1 || y < 1 || x > n || y > n) {
    	  System.out.println(0);
      }else {
    	  System.out.println(arr[x][y]);
      }
    }
  }
}