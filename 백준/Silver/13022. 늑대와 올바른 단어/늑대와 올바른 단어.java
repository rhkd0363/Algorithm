import java.io.*;
import java.util.*;

public class Main {
	static int N, result;
	static int[] choice;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		char prevChar = 'f';
		boolean flag = true;
		
		int prevLength = 1;
		int currLength = 1;
		
		loop : for(int i=0;i<input.length();i++) {
			char currChar = input.charAt(i);

			if(input.charAt(i) != prevChar) {
				switch (currChar) {
					case 'w':{
						if(prevChar == 'f' && prevLength == currLength) {
							prevLength = currLength;
							currLength = 0;
							prevChar = 'w';
						}else {
							flag = false;
							break loop;
						}
						break;
					}
					case 'o':{
						if(prevChar == 'w') {
							prevLength = currLength;
							currLength = 0;
							prevChar = 'o';
						}else {
							flag = false;
							break loop;
						}
						break;
					}
					case 'l':{
						if(prevChar == 'o' && prevLength == currLength) {
							prevLength = currLength;
							currLength = 0;
							prevChar = 'l';
						}else {
							flag = false;
							break loop;
						}
						break;
					}
					case 'f':{
						if(prevChar == 'l' && prevLength == currLength) {
							prevLength = currLength;
							currLength = 0;
							prevChar = 'f';
						}else {
							flag = false;
							break loop;
						}
						break;
					}
					default :{
						flag = false;
						break loop;
					}
				}
			}
			
			currLength++;
		}
		
		if(prevChar != 'f' || prevLength != currLength)
			flag = false;
		
		System.out.println(flag ? 1 : 0);
	}
}
