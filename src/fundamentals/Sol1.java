package fundamentals;

import java.util.EmptyStackException;

import edu.princeton.cs.introcs.In;
import util.PrintUtil;

public class Sol1 {
	// https://github.com/aistrate/AlgorithmsSedgewick

	public static void main(String[] args) {

		 testCircularQueue();
		// testQueueLinked();
		// testStack();
		// testResizeableQueue();
		// evaluatePostfix();
		// infixToPostfix();
		// correctParathesis();
		// validateParatheses();
		// transposeMatrix();
	}

	private static void testCircularQueue() {
		CircularQueue<String> q = new CircularQueue<String>();
		q.enqueue("1");
		q.enqueue("2");
		q.enqueue("3");
		q.enqueue("4");

		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}

	private static void testQueueLinked() {
		QueueLinked<String> q = new QueueLinked<String>();
		q.enqueue("1");
		q.enqueue("2");
		q.enqueue("3");
		q.enqueue("4");

		// q.delete(5);
		System.out.println(q.find("6"));

		for (String item : q) {
			System.out.println(item);
		}
	}

	private static void testStack() {
		Stack<String> s = new Stack<String>();
		s.push("1");
		s.push("2");
		s.push("3");
		s.push("4");

		for (String item : s) {
			System.out.println(item);
		}

		// System.out.println(s.isEmpty());
		// System.out.println(s.pop());
		// System.out.println(s.pop());
		// System.out.println(s.pop());
		// System.out.println(s.pop());
		// System.out.println(s.isEmpty());
	}

	/**
	 * 1.3.14
	 */
	private static void testResizeableQueue() {
		ResizeableQueue q = new ResizeableQueue();
		q.enQueue("1");
		q.enQueue("2");
		q.enQueue("3");
		q.enQueue("4");
		System.out.println(q.isEmpty());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.isEmpty());
	}

	/**
	 * 1.3.11
	 */
	private static void evaluatePostfix() {
		String[] input = "( ( 4 ( 2 3 + ) * ) 4 / )".split(" ");

		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();

		for (String i : input) {
			if (i.equals("(")) {
				// Skip '('.
			} else if (i.equals("+")) {
				ops.push(i);
			} else if (i.equals("*")) {
				ops.push(i);
			} else if (i.equals("-")) {
				ops.push(i);
			} else if (i.equals("/")) {
				ops.push(i);
			} else if (i.equals(")")) {
				String op = ops.pop();
				Double val = vals.pop();

				switch (op) {
				case "+":
					vals.push(vals.pop() + val);
					break;
				case "-":
					vals.push(vals.pop() - val);
					break;
				case "*":
					vals.push(vals.pop() * val);
					break;
				case "/":
					vals.push(vals.pop() / val);
					break;
				}
			} else {
				vals.push(Double.parseDouble(i));
			}
		}
		System.out.println(vals.pop().intValue());
	}

	/**
	 * 1.3.10
	 */
	private static void infixToPostfix() {
		String[] input = "( ( A * ( B + C ) ) / D )".split(" ");

		Stack<String> vals = new Stack<String>();
		Stack<String> ops = new Stack<String>();

		for (String i : input) {
			if (i.equals("(")) {
				// Do nothing.
			} else if (i.equals("+")) {
				ops.push(i);
			} else if (i.equals("*")) {
				ops.push(i);
			} else if (i.equals("-")) {
				ops.push(i);
			} else if (i.equals("/")) {
				ops.push(i);
			} else if (i.equals(")")) {
				String op = ops.pop();
				String val = vals.pop();
				String temp = String.format("(%s %s %s)", vals.pop(), val, op);
				vals.push(temp);
			} else {
				vals.push(i);
			}
		}
		System.out.println(vals.pop());
	}

	/**
	 * 1.3.9
	 */
	private static void correctParathesis() {
		String[] input = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )".split(" ");

		Stack<String> vals = new Stack<String>();
		Stack<String> ops = new Stack<String>();

		for (String i : input) {
			if (i.equals("(")) {
				// just to be safe. Input btw should not contain '('.
			} else if (i.equals("+")) {
				ops.push(i);
			} else if (i.equals("*")) {
				ops.push(i);
			} else if (i.equals("-")) {
				ops.push(i);
			} else if (i.equals("/")) {
				ops.push(i);
			} else if (i.equals(")")) {
				String op = ops.pop();
				String val = vals.pop();
				String temp = String.format("(%s %s %s)", vals.pop(), op, val);
				vals.push(temp);
			} else {
				vals.push(i);
			}
		}
		System.out.println(vals.pop());
	}

	/**
	 * 1.3.4
	 */
	private static void validateParatheses() {
		In in = new In("/resources/stdin");
		String[] a = in.readAllStrings();

		String success = "Paratheses are properly balanced";
		String failure = "Paratheses NOT properly balanced";
		String result = success;

		Stack<String> paratheses = new Stack<String>();
		try {
			for (String input : a) {
				if (input.equals(")")) {
					if (!paratheses.pop().equals("(")) {
						result = failure;
						break;
					}
				} else if (input.equals("]")) {
					if (!paratheses.pop().equals("[")) {
						result = failure;
						break;
					}
				} else if (input.equals("}")) {
					if (!paratheses.pop().equals("{")) {
						result = failure;
						break;
					}
				} else {
					paratheses.push(input);
				}
			}
		} catch (EmptyStackException e) {
			result = failure;//
		}
		System.out.println(result);
	}

	/**
	 * 1.1.13
	 */
	public static void transposeMatrix() {
		int a[][] = { { 1, 2 }, { 1, 2 } };
		int inputRows = a.length;
		int inputCols = a[0].length;
		int result[][] = new int[inputCols][inputRows];

		for (int i = 0; i < inputRows; i++) {
			for (int j = 0; j < inputCols; j++) {
				result[j][i] = a[i][j];
			}
		}

		PrintUtil.printArray(a);
		PrintUtil.printArray(result);
	}

}
