import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static class Node {
		int data;
		Node link;

		public Node(int data) {
			this.data = data;
			this.link = null;
		}
	}

	static class LinkedQueue {
		Node front;
		Node rear;
		int size;

		public LinkedQueue() {
			this.front = null;
			this.rear = null;
			this.size = 0;
		}
		
		public boolean isEmpty() {
			if(size == 0) return true;
			return false;
		}
		
		public void enQueue(int data) {
			Node node = new Node(data);
			if(size == 0) {
				front = node;
				rear = node;
				size++;
				return;
			}
			rear.link = node;
			rear = node;
			size++;
		}
		
		public int deQueue() {
			if(size == 0) return -1;
			int data = front.data;
			front = front.link;
			if(size == 1) {
				rear =null;
			}
			size--;
			return data;
		}
		public void printQueue() {
			Node curr;
			
			curr = front;
			for(int i =0;i<size;i++) {
				System.out.print(curr.data+" ");
				curr = curr.link;
			}
			System.out.println();
		}
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t=1;t<=10;t++) {
			int tn = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			LinkedQueue queue = new LinkedQueue();
			
			while(st.hasMoreTokens()) {
				queue.enQueue(Integer.parseInt(st.nextToken()));
//				queue.printQueue();
			}
			
			wh : while(true) {
				for(int i=1;i<=5;i++) {
					int data =queue.deQueue()-i;
					if(data <= 0) {
						queue.enQueue(0);
						break wh;
					}
					queue.enQueue(data);
//					queue.printQueue();
				}
			}
			
			System.out.print("#"+t+" ");queue.printQueue();
		}
	}
}
