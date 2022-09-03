import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 스위치 개수
		int num = Integer.parseInt(br.readLine());
		// 스위치 상태 나타낼 배열
		boolean[] switchState = new boolean[num];
		// 스위치 상태 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num; i++) {
			if (Integer.parseInt(st.nextToken()) == 1)
				switchState[i] = true;
			else
				switchState[i] = false;
		}

		// 학생 수
		int stNumber = Integer.parseInt(br.readLine());
		// 학생 정보(성별, 스위치 번호) 받을 배열
		Student[] student = new Student[stNumber];

		// 학생정보(성별, 스위치번호) 입력
		for (int i = 0; i < stNumber; i++) {
			st = new StringTokenizer(br.readLine());
			student[i] = new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < student.length; i++) {
			// 성별이 남자라면
			if (student[i].gender == 1) {
				// 스위치 번호가 배수인 스위치의 상태를 변경해 준다.
				for (int j = 0; j < switchState.length; j++) {
					// j+1 이 스위치 번호의 배수이면 상태 반전시켜준다.
					if ((j + 1) % (student[i].switchNum) == 0) {
						switchState[j] = !switchState[j];
					}
				}
			}
			// 성별이 여자라면
			else {
				// 스위치 번호를 기준으로 대칭 확인
				int cnt = 0;
				for (int j = 1; j < switchState.length; j++) {
					// 배열 범위에 포함되는지 확인
					if (student[i].switchNum - 1 - j < 0 || student[i].switchNum - 1 + j >= switchState.length) {
						break;
					}
					// 좌우 대칭 확인 and 좌우 대칭이 아닐 시 break;
					if (switchState[student[i].switchNum - 1 - j] == switchState[student[i].switchNum - 1 + j]) {
						cnt = j;
					}else {
						break;
					}
				}
				// 상태변경
				for (int j = student[i].switchNum - 1 - cnt; j <= student[i].switchNum - 1 + cnt; j++) {
					switchState[j] = !switchState[j];
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < switchState.length; i++) {
			sb.append(switchState[i] ? 1 : 0).append(" ");
			if((i+1)%20 == 0) sb.append("\n"); 
		}
		System.out.println(sb);
	}
}

class Student {
	int gender;
	int switchNum;

	public Student(int gender, int switchNum) {
		this.gender = gender;
		this.switchNum = switchNum;
	}
}
