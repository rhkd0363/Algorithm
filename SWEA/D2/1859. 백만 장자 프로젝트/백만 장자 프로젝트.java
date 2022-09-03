import java.math.BigDecimal;
import java.util.Scanner;
// 2번째 답안
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tC = sc.nextInt();

		for (int i = 1; i <=tC; i++) {
			int day = sc.nextInt();
			int[] price = new int[day];
			for (int j = 0; j < price.length; j++) {
				price[j] = sc.nextInt();
			}
			double ans = 0;
			int max = 0;
			
			for(int j=day-1;j>=0;j--) {
				if(price[j] < max) {
					ans += max-price[j];
				}else {
					max = Math.max(price[j],max);
				}
			}
			System.out.println("#"+i+" "+new BigDecimal(Double.parseDouble(Double.toString(ans))));
		}
	}
}
// 처음답안
/*import java.math.BigDecimal;
import java.util.Scanner;

//배열로 가격을 받고 높은가격 순으로 인덱스 값을 받음
//현재가격이 미래가격보다 싼 경우 구매
//가장 비쌀때를 확인하여 그 전꺼 다 구매 후 판매, 가장비싼거 다음 높은 범위까지 구매 후 판매
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tC = sc.nextInt();

		for (int i = 1; i <=tC; i++) {
			int day = sc.nextInt();
			int[] price = new int[day];
			for (int j = 0; j < price.length; j++) {
				price[j] = sc.nextInt();
			}
			int sPrice = 0;
			int idx = 0;
			long sum = 0;
			// 가장 높은 값의 인덱스 확인
			for (int j = 0; j < price.length; j++) {
				if (sPrice < price[j]) {
					sPrice = price[j];
					idx = j;
				}
			}
			// 처음부터 가장 높은 인덱스 전까지 계산
			for (int j = 0; j < idx; j++) {
				sum += sPrice - price[j];
			}
			// 인덱스가 배열 길이 -1 이랑 같아질 동안 반복
			while (idx != price.length - 1) {
				sPrice = 0;
				int idx2 = idx + 1;
				for (int j = idx2; j < price.length; j++) {
					if (sPrice < price[j]) {
						sPrice = price[j];
						idx = j;
					}
				}
				for (int j = idx2; j < idx; j++) {
					sum += sPrice - price[j];
				}
			}
			
			System.out.println("#" + i + " "+ new BigDecimal(Double.parseDouble(Double.toString(sum))));
		}
	}
}*/
