import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//슈퍼마리오 앞에 버섯 10개가 일렬로 놓여져 있다.
//중간에 버섯 먹는것을 중단하면 그 후의 버섯은 먹을 수 없다.
//점수 합을 100에 가깝게 만들려고 한다.
//100에 가까운 수가 2개라면 큰 값을 선택한다.
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//점수 합
		int sum = 0;
		
		//버섯 10개 수 만큼 반복
		for(int i=0;i<10;i++) {
			int n = Integer.parseInt(br.readLine());
			//점수 비교를 통해 100에 가까운 수를 확인
			//만약 100에 가까운 수가 2개라면 더 큰 값을 선택하기 위해 >= 연산자와 
			//Math.abs를 통한 100을 초과하는 값을 절대값으로 비교
			if(100 - sum >= Math.abs(100 - (sum+n))) {
				sum += n;				
			}else {
				break;
			}
		}
		System.out.println(sum);
	}
}