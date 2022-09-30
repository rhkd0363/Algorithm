import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 16235 나무재테크 (BoJ) 봄 : 나무의 나이만큼 양분을 먹고, 나이 1 증가 한 개의 칸에 나무가 여러 그루면 나이가 어린 나무부터
 * 양분을 먹는다. 나이만큼 양분을 못 먹으면 나무는 즉시 죽는다.
 * 
 * 여름 : 봄에 죽은 나무가 양분으로 변한다. 양분 : 죽은 나무의 나이 / 2 (소수점 버림)
 * 
 * 가을 : 나무가 번식한다. 나무의 나이가 5배수 이면 8방으로 나이가 1인 나무가 생긴다.
 * 
 * 겨울 : S2D2가 땅에 양분을 추가한다. 추가되는 양분의 양은 A[r][c] 이다.
 * 
 * K 년 후 상도의 땅에 살아있는 나무의 개수를 구하라.
 */

public class Main {
	static int N, M, K;
	static int[][] A;
	static int[][] energy;
	static List<Tree>[][] map;
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 }, dy = { -1, 0, 1, -1, 1, -1, 0, 1 }; // 8방 탐색 배열

	static class Tree implements Comparable<Tree> {
		int age;

		public Tree(int age) {
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}

		@Override
		public String toString() {
			return "Tree [age=" + age + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 땅의 크기
		M = Integer.parseInt(st.nextToken()); // 심은 나무의 수
		K = Integer.parseInt(st.nextToken()); // 년 수

		A = new int[N][N]; // 겨울에 추가할 양분 정보
		energy = new int[N][N]; // 땅에 양분 정보
		
		for(int i=0;i<N;i++) {
			Arrays.fill(energy[i], 5);
		}
		
		for (int i = 0; i < N; i++) { // 겨울에 추가할 양분 정보 입력
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		map = new ArrayList[N][N]; // 나무가 심어진 땅 배열( N*N 크기)

		for (int i = 0; i < N; i++) { // 나무 심어진 땅 배열 초기화
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < M; i++) { // 심은 나무의 좌표, 나이 정보
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());

			map[r][c].add(new Tree(age));
		}

		for(int i=0;i<K;i++) {
			SpringSummer();
			fall();
			winter();
		}
		
		int treeCount = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < map[i][j].size(); k++) {
					int age = map[i][j].get(k).age;

					if (age == 0)// 죽은 나무의 정보임
						continue;
					
					treeCount++;
				}
			}
		}
		
		System.out.println(treeCount);
		
	}

	// 봄, 여름 : 나무 성장 or 죽음
	static void SpringSummer() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Collections.sort(map[i][j]); // 나무가 여러 그루일 경우 어린 나무부터 양분을 먹기에 정렬
				int deadTree = 0;

				for (int k = 0; k < map[i][j].size(); k++) {
					int age = map[i][j].get(k).age;

					if (age == 0)// 죽은 나무의 정보임
						continue;

					if (energy[i][j] >= age) { // 양분이 충분하다면
						energy[i][j] -= age; // 양분을 먹고
						map[i][j].get(k).age++; // 나이를 먹는다.
					} else { // 나무는 죽는다.
						deadTree += age / 2; // 죽은 나무의 나이/2 가 양분이 된다.
						map[i][j].get(k).age = 0;
					}

				}
				energy[i][j] += deadTree; // 여름에 죽은 나무는 양분이 된다~

				// 죽은 나무 없애기
				for(int k=map[i][j].size()-1;k>=0;k--) {
					if(map[i][j].get(k).age == 0) {
						map[i][j].remove(k);
					}
				}

			}
		}
	}

	// 가을 : 나무번식
	static void fall() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				for (int k = 0; k < map[i][j].size(); k++) {
					int age = map[i][j].get(k).age;

					if (age % 5 != 0)// 나이가 5의 배수가 아니라면 돌아가
						continue;

					for (int l = 0; l < 8; l++) { // 8방으로 나무 심어주기
						int nx = i + dx[l];
						int ny = j + dy[l];

						if (nx >= N || ny >= N || nx < 0 || ny < 0) // 땅의 범위에서 벗어나면 continue
							continue;

						map[nx][ny].add(new Tree(1));
					}
				}
			}
		}
	}
	
	// 겨울 : 양분 추가
	static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				energy[i][j] += A[i][j];
			}
		}
	}
	
}
