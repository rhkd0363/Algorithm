import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<String> pStr = new ArrayList<String>();
		String[][] cStr = new String[n][2];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String s = st.nextToken();
			String ps = st.nextToken();
			String ns = st.nextToken();
			
			pStr.add(s);
			cStr[i][0] = ps;
			cStr[i][1] = ns;
		}
		
		prevPrint(pStr,cStr,0);
		System.out.println();
		Print(pStr,cStr,0);
		System.out.println();
		nextPrint(pStr,cStr,0);
		
		
	}
	//num ==0
	public static void prevPrint(ArrayList<String> pStr,String[][] cStr,int num) {
		if(!pStr.get(num).equals(".")) {
			System.out.print(pStr.get(num));
			
			if(pStr.indexOf(cStr[num][0]) != -1)
				prevPrint(pStr, cStr, pStr.indexOf(cStr[num][0]));
			
			if(pStr.indexOf(cStr[num][1]) != -1)
				prevPrint(pStr, cStr, pStr.indexOf(cStr[num][1]));
		}
	}
	public static void Print(ArrayList<String> pStr,String[][] cStr,int num) {
		if(!pStr.get(num).equals(".")) {
			if(pStr.indexOf(cStr[num][0]) != -1)
				Print(pStr, cStr, pStr.indexOf(cStr[num][0]));
			
			System.out.print(pStr.get(num));
			
			if(pStr.indexOf(cStr[num][1]) != -1)
				Print(pStr, cStr, pStr.indexOf(cStr[num][1]));
		}
	}
	public static void nextPrint(ArrayList<String> pStr,String[][] cStr,int num) {
		if(!pStr.get(num).equals(".")) {
			if(pStr.indexOf(cStr[num][0]) != -1)
				nextPrint(pStr, cStr, pStr.indexOf(cStr[num][0]));
			
			if(pStr.indexOf(cStr[num][1]) != -1)
				nextPrint(pStr, cStr, pStr.indexOf(cStr[num][1]));
			
			System.out.print(pStr.get(num));
		}
	}
	
}
