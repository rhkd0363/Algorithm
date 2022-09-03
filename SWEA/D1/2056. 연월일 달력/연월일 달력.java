import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Tn = sc.nextInt();
		
		for (int i= 1;i<Tn+1;i++) {
			String date = sc.next();
			
			System.out.print("#"+i+" ");
			
			int year = Character.getNumericValue(date.charAt(0))*1000+Character.getNumericValue(date.charAt(1))*100+Character.getNumericValue(date.charAt(2))*10+Character.getNumericValue(date.charAt(3));
			int month = Character.getNumericValue(date.charAt(4))*10+Character.getNumericValue(date.charAt(5));
			int day = Character.getNumericValue(date.charAt(6))*10+Character.getNumericValue(date.charAt(7));
			
			
			if (month>=1 && month<=12) {
				if (month == 1 ||month ==3||month ==5||month ==7||month ==8||month ==10||month ==12)
					if(day>=1 && day<=31)
						System.out.printf("%04d/%02d/%02d\n",year,month,day);
					else
						System.out.println("-1");
				else if (month == 4 ||month ==6||month ==9||month ==11)
					if(day>=1 && day<=30)
						System.out.printf("%04d/%02d/%02d\n",year,month,day);
					else
						System.out.println("-1");
				else if (month == 2)
					if(day>=1 && day<=28)
						System.out.printf("%04d/%02d/%02d\n",year,month,day);
					else
						System.out.println("-1");
			else
				System.out.println("-1");
		}else
                System.out.println("-1");
	}
	}
}
