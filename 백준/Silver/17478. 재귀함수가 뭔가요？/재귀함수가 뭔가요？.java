import java.io.*;

public class Main {
	static StringBuilder SB = new StringBuilder();
	static String[] str;
	static String tmpStr = "";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = new String[8];
				
		str[0] = "____";
		str[1] = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
		str[2] = "\"재귀함수가 뭔가요?\"\n";
		str[3] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
		str[4] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
		str[5] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
		str[6] = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
		str[7] = "라고 답변하였지.\n";
		
		int N = Integer.parseInt(br.readLine());
		
		SB.append(str[1]);
		chatBot(0, N);
		
		System.out.println(SB);
	}

	public static void chatBot(int num,int N) {
		if(num == N) {
			SB.append(tmpStr+str[2]);
			SB.append(tmpStr+str[6]);
			SB.append(tmpStr+str[7]);
			
			for(int i=num;i>=1;i--) {
				tmpStr = tmpStr.substring(0,tmpStr.length()-4);
				SB.append(tmpStr+str[7]);
			}
			return;
		}
		for(int i=2;i<=5;i++) {
			SB.append(tmpStr+str[i]);
		}
		tmpStr += str[0];
		num++;
		
		chatBot(num, N);
	}
}