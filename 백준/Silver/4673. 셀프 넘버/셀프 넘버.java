public class Main {
	static int[] arr = new int[10001];

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= 10000; i++) {
			arr[i] = i;
		}
		for (int i = 1; i < 10001; i++) {
			selfNum(arr[i]);
		}
		for (int i = 1; i < 10001; i++) {
			if (arr[i] != 0)
				sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}

	public static void selfNum(int number) {
		if (number == 0)
			return;
		int result = number;
		while (number != 0) {
			result += number % 10;
			number /= 10;
		}
		if (result <= 10000) {
			selfNum(result);
			arr[result] = 0;
		}

	}
}