import java.io.*;
import java.util.*;

public class Main {
	static int[] segmentTree, value;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		segmentTree = new int[N * 4];
		value = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		for (int i = 1; i <= N; i++) {
			value[i] = Integer.parseInt(st.nextToken());
		}
		setTree(1, 1, N);
		int M = Integer.parseInt(br.readLine());
        
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			if (Integer.parseInt(st.nextToken()) == 1) {
				int index = Integer.parseInt(st.nextToken());
				value[index] = Integer.parseInt(st.nextToken());
				updateTree(1, index, 1, N);
			} else {
				sb.append(segmentTree[1]).append('\n');
			}
		}
		System.out.println(sb);
	}

	static int setTree(int node, int start, int end) {
		if (start == end) {
			return segmentTree[node] = start;
		}
		int mid = (start + end) / 2;
		int left = setTree(node * 2, start, mid);
		int right = setTree(node * 2 + 1, mid + 1, end);
		if (value[left] <= value[right]) {
			return segmentTree[node] = left;
		}
		return segmentTree[node] = right;
	}

	static int updateTree(int node, int idx, int start, int end) {
		if (start == end) {
			return start;
		}
		if (start <= idx && idx <= end) {
			int mid = (start + end) / 2;
			int left = updateTree(node * 2, idx, start, mid);
			int right = updateTree(node * 2 + 1, idx, mid + 1, end);
			if (value[left] <= value[right]) {
				return segmentTree[node] = left;
			}
			return segmentTree[node] = right;
		}
		return segmentTree[node];
	}
}