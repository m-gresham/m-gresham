package m3.test;

import m3.OrderedArray;
import m3.PriorityQueue;

public class TestOrderedArray extends TestBase {

	@Override
	public PriorityQueue<Integer> genHeap(int size) {
		return new OrderedArray<Integer>(size);
	}

}
