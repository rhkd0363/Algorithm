import java.util.Arrays;
import java.util.Scanner;
 
public class Solution {
    static int[] map = new int[100];
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        for (int t = 1; t <= 10; t++) {
            //평탄화 횟수
            int dump = sc.nextInt();
            int cnt = 0;
            //높이 입력
            for (int i = 0; i < 100; i++) {
                map[i] = sc.nextInt();
            }
             
            for (int n = 0; n < dump; n++) {
                //평탄화
                flattenMax();
                flattenMin();
                cnt++;
            }
            Arrays.sort(map);
            System.out.println("#"+t+" "+(map[map.length-1]-map[0]));
        }
    }
 
    static void flattenMax() {
        int max = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] > max) {
                max = map[i];
                idx = i;
            }
        }
        map[idx]--; 
    }
    static void flattenMin() {
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] < min) {
                min = map[i];
                idx = i;
            }
        }
        map[idx]++; 
    }
}