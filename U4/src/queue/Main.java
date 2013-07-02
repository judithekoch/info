package queue;

import listStackChainNode.*;

public class Main {


	public static void main(String[] args) {

		Queue<String> queue = new MyQueue<String>(new QueueNode<String>("Hallo", null));
		queue.enqueue("Welt");
		queue.enqueue("!");
		System.out.println(queue.isEmpty());
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();	
		System.out.println(queue.isEmpty());

		Stack<String> fakeSnake = new FakeSnake<String>(new QueueNode<String>("Hallo", null));
		fakeSnake.push("Welt");
		fakeSnake.push("!");
		System.out.println(fakeSnake.isEmpty());
		fakeSnake.pop();
		fakeSnake.pop();
		fakeSnake.pop();	
		System.out.println(fakeSnake.isEmpty());
	}

}
