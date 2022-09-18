import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 단어 수 입력
		int N  = Integer.parseInt(br.readLine());
		
		//중복 제거를 위해 Set으로 값 입력
		Set<String> set = new HashSet<>();		
		//값 입력
		for(int i=0;i<N;i++) {
			set.add(br.readLine());
		}
		
		//Collections.sort를 위해 Set을 List로 바꿈
		List<String> list = new ArrayList<>(set);
		
		//글자 길이, 사전 순으로 정렬하기 위해 Comparator 사용
		Collections.sort(list,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
                //길이가 같을 경우 compareTo를 통해 비교
				if(o1.length() == o2.length())
					return o1.compareTo(o2);
				return o1.length()-o2.length();
			}					
		});
		
		for(String s : list) 
			sb.append(s).append('\n');
		
		System.out.print(sb);
		
	}
}