import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] rList = new int[][]{{987654321, 987654321, 987654321}, {0, 0, 0}};
        int[][] gList = new int[][]{{987654321, 987654321, 987654321}, {0, 0, 0}};
        int[][] bList = new int[][]{{987654321, 987654321, 987654321}, {0, 0, 0}};

        StringTokenizer st = new StringTokenizer(br.readLine());

        rList[0][0] = Integer.parseInt(st.nextToken());
        gList[0][1] = Integer.parseInt(st.nextToken());
        bList[0][2] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int cost = Integer.parseInt(st.nextToken());
                calCost(rList, cost, j);
                calCost(gList, cost, j);
                calCost(bList, cost, j);
            }
            fixCost(rList);
            fixCost(gList);
            fixCost(bList);
        }
        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        rList[1][0] = 987654321;
        rList[1][1] = Math.min(rList[0][0],rList[0][2]) + g;
        rList[1][2] = Math.min(rList[0][0],rList[0][1]) + b;

        gList[1][0] = Math.min(gList[0][1],gList[0][2]) + r;
        gList[1][1] = 987654321;
        gList[1][2] = Math.min(gList[0][0],gList[0][1]) + b;

        bList[1][0] = Math.min(bList[0][1],bList[0][2]) + r;
        bList[1][1] = Math.min(bList[0][0],bList[0][2]) + g;
        bList[1][2] = 987654321;

        List<Integer> answer = new ArrayList<>();
        for(int i=0;i<3;i++){
            answer.add(rList[1][i]);
            answer.add(gList[1][i]);
            answer.add(bList[1][i]);
        }
        Collections.sort(answer);
        System.out.println(answer.get(0));
    }
    static void calCost(int[][] list, int cost, int index) {
        switch (index) {
            case 0:
                list[1][index] = Math.min(list[0][1], list[0][2]) + cost;
                break;
            case 1:
                list[1][index] = Math.min(list[0][0], list[0][2]) + cost;
                break;
            default:
                list[1][index] = Math.min(list[0][0], list[0][1]) + cost;
        }
    }
    static void fixCost(int[][] list) {
        list[0][0] = list[1][0];
        list[0][1] = list[1][1];
        list[0][2] = list[1][2];
    }
}