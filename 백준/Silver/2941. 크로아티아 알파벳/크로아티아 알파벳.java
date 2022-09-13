import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//단어가 주어질 때 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력
//목록에 없는 알파벳은 한 글자씩 센다.
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Main main = new Main();
		String str = br.readLine();
		//크로아티아 알파벳으로 변경
		str = main.replace(str);
		
		int cnt = 0;
		//변경된 문자열 검사(i번째 문자가 d,l,n이고 i+1번째 문자가 ž,j,j 일 경우 i++)
		for (int i = 0; i < str.length(); i++) {
			if(i==str.length()-1) {
				cnt++; 
				break;
			}
			if ((str.charAt(i) == 'd' && str.charAt(i + 1) == 'ž') || (str.charAt(i) == 'l' && str.charAt(i + 1) == 'j')
					|| (str.charAt(i) == 'n' && str.charAt(i + 1) == 'j')) {
				i++;
			}
			cnt++;
		}

		System.out.println(cnt);
	}

	public String replace(String str) {
		str = str.replace("c=", "č");
		str = str.replace("c-", "ć");
		str = str.replace("dz=", "dž");
		str = str.replace("d-", "đ");
		str = str.replace("lj", "lj");
		str = str.replace("nj", "nj");
		str = str.replace("s=", "š");
		str = str.replace("z=", "ž");
		return str;
	}
}