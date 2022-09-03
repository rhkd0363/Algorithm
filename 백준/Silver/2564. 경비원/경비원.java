import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 가로 세로 길이 입력
		st = new StringTokenizer(br.readLine());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		// Map 만들어주기
		int[][] iMap = new int[height][width];
		// 상점 개수
		int N = Integer.parseInt(br.readLine());

		// 상점 위치 값 담을 거 추가
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();

		// 동서남북 키 값으로 해서 만들어줌
		for (int i = 1; i <= 4; i++) {
			map.put(i, new ArrayList<Integer>());
		}

		// 상점 위치 추가
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int key = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			map.get(key).add(value);
		}

		// 경비원 위치 ( 경비 위치 동서남북, 위치)
		st = new StringTokenizer(br.readLine());
		int sPlace = Integer.parseInt(st.nextToken());
		int sValue = Integer.parseInt(st.nextToken());

		int totalDistance = 0;

		for (int i = 1; i <= 4; i++) {
			for (int X : map.get(i)) {
				// 같은 라인에 위치한다면 최단거리 : 절!대!값
				if (sPlace == i) {
					totalDistance += Math.abs(sValue - X);
				}
				// 경비가가 1,2 일 때 3,4 는 이웃 라인
				else if ((sPlace == 1 || sPlace == 2) && (i == 3 || i == 4)) {
					if (sPlace == 1 && i == 3) {
						totalDistance += X + sValue;
					} else if (sPlace == 1 && i == 4) {
						totalDistance += X + (width - sValue);
					} else if (sPlace == 2 && i == 3) {
						totalDistance += (height - X) + sValue;
					} else if (sPlace == 2 && i == 4) {
						totalDistance += (height - X) + (width - sValue);
					}
				}
				// 경비가가 3,4일 때 1,2 는 이웃 라인
				else if ((sPlace == 3 || sPlace == 4) && (i == 1 || i == 2)) {
					if (sPlace == 3 && i == 1) {
						totalDistance += X + sValue;
					} else if (sPlace == 3 && i == 2) {
						totalDistance += X + (height - sValue);
					} else if (sPlace == 4 && i == 1) {
						totalDistance += (width - X) + sValue;
					} else if (sPlace == 4 && i == 2) {
						totalDistance += (width - X) + (height - sValue);
					}
				}
				// 반대편일때
				else {
					if (sPlace == 1 || sPlace == 2) {
						// 오른쪽으로
						int a = (width - sValue) + height + (width - X);
						// 왼쪽
						int b = sValue + height + X;
						totalDistance += a > b ? b : a;
					} else if (sPlace == 3 || sPlace == 4) {
						// 아래쪽
						int a = (height - sValue) + width + (height - X);
						// 위쪽
						int b = sValue + width + X;
						totalDistance += a > b ? b : a;
					}
				}
			}

		}
		System.out.println(totalDistance);
	}
}
