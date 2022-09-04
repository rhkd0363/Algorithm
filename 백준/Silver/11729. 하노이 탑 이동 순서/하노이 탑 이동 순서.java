import java.io.*;
// 하노이 탑
public class Main {
	static StringBuilder SB = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 원판의 수
        int N = Integer.parseInt(br.readLine());
        // 옮기는 횟수는 2의 N제곱 - 1
        // N : 1, 2, 3 ... => 1, 3, 7, ...
        SB.append((int)Math.pow(2,N)-1 + "\n");
        
        hanoi(N,1,3,2);
        
        System.out.print(SB);
    }    
    // 매개변수 : 원판의 수 , 시작 기둥, 목적 기둥, 보조 기둥
    public static void hanoi(int n, int str_pos,int end_pos,int sub_pos) {
    	// 원판의 개수가 1개이면 시작 기둥 => 목적 기둥로 바로 옮기면 됨
    	if(n == 1) {
    		SB.append(str_pos+" "+end_pos+"\n");
    		return;
    	}
    	// n-1개의 원판을 보조 기둥으로 옮김
    	hanoi(n-1,str_pos,sub_pos,end_pos);
    	// 제일 큰 원판을 목적 기둥으로 옮김
    	SB.append(str_pos+" "+end_pos+"\n");
    	// 보조기둥에 있던 n-1개의 원판을 목적지 기둥으로 옮김
    	hanoi(n-1,sub_pos,end_pos,str_pos);
    }
}