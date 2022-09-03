import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int T, H, W, N, X, Y;
	static char[][] map;
	static char[] command, move = {'^','v','<','>'};
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H + 2][W + 2];
			insertMap();

			N = Integer.parseInt(br.readLine());
			command = new char[N];
			insertCommand();

			play();

			printMap(tc);
		}

	}

	// 맵 정보 입력
	static void insertMap() throws IOException {
		for (int i = 1; i <= H; i++) {
			String mapInfo = br.readLine();
			for (int j = 1; j <= W; j++) {
				char info = mapInfo.charAt(j - 1);
				map[i][j] = info;
				if (info == '^' || info == 'v' || info == '<' || info == '>') {
					X = i;
					Y = j;
				}
			}
		}
	}

	// 명령어 입력
	static void insertCommand() throws IOException {
		String commandInfo = br.readLine();
		for (int i = 0; i < N; i++) {
			command[i] = commandInfo.charAt(i);
		}
	}

	// 게임 시작
	static void play() {
		for (int i = 0; i < N; i++) {
			executeCommand(command[i]);
		}
	}

	// 명령 실행
	static void executeCommand(char command) {
		switch(command) {
		case 'U':
			move(0);
			break;
		case 'D':
			move(1);
			break;
		case 'L':
			move(2);
			break;
		case 'R':
			move(3);
			break;
		default:
			switch (map[X][Y]) {
			case '^':
				shoot(0);
				break;
			case 'v':
				shoot(1);
				break;
			case '<':
				shoot(2);
				break;
			case '>':
				shoot(3);
				break;
			}
		}
	}

	// 이동
	static void move(int num) {
		int nx = X + dx[num];
		int ny = Y + dy[num];
		if (map[nx][ny] == '.') {
			map[X][Y] = '.';
			X = nx;
			Y = ny;
		}
		map[X][Y] = move[num];
	}

	// 대포 발사
	static void shoot(int num) {
		int nx = X;
		int ny = Y;
		int i = 1;
		while (map[nx][ny] != '\u0000' && map[nx][ny] != '#') {
			nx = X + dx[num] * i;
			ny = Y + dy[num] * i;
			i++;
			if (map[nx][ny] == '*') {
				map[nx][ny] = '.';
				break;
			}
		}
	}

	// 결과 출력
	static void printMap(int testCase) {
		StringBuilder sb = new StringBuilder();
		sb.append("#" + testCase + " ");
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= W; j++) {
				sb.append(map[i][j]);
			}
            sb.append("\n");
		}
        sb.delete(sb.length()-1, sb.length());
		System.out.println(sb);
	}
}
