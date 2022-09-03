import java.util.Scanner;
//public class 농작물수확 {  
public class Solution {
	static Scanner 스캐너 = new Scanner(System.in);
	static int 길이;
	static int[][] 맵;
    
	public static void main(String[] args) {	
		int 테스트케이스수 = 스캐너.nextInt();
        
		for(int 테스트케이스=1;테스트케이스<=테스트케이스수;테스트케이스++) {
			길이 = 스캐너.nextInt();
			맵 = new int[길이][길이];
            
			농작물가치입력();		
			System.out.println("#"+테스트케이스+" "+가치합산());
		}
	}
	
	static void 농작물가치입력() {
		for(int 행=0;행<길이;행++) {
			String 행정보 = 스캐너.next();
			for(int 열=0;열<길이;열++) {
				맵[행][열] = 행정보.charAt(열)-'0';
			}
		}
	}
	
	static int 가치합산() {
		int 가치 = 0;
		for(int 행=0;행<길이;행++) {
			int 범위 = 길이/2-Math.abs(길이/2-행);
			for(int 열 =길이/2-범위;열<=길이/2+범위;열++) {
				가치 += 맵[행][열];
			}
		}
		return 가치;
	}
}
