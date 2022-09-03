import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			int cN = sc.nextInt();
			int speed = 0; // 속도
			int distance = 0; // 거리
			for (int j = 1; j <= cN; j++) {
				int command = sc.nextInt();// 커맨드
				int accel = 0;
				if(command !=0){
					accel = sc.nextInt();
				}
				// 커맨드 1 가속 2 감속
				if (command == 1) {
					speed += accel;
				}
				else if (command == 2) {
					speed -= accel;
				}
				if(speed < 0) speed =0;
				
				distance += speed;
			}
			System.out.println("#"+i+" "+distance);
		}
	}
}
