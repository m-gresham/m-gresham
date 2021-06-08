package m3.test;

import m3.PriorityQueue;
import m3.UnorderedList;

public class TestUnorderedList extends TestBase {

	@Override
	public PriorityQueue<Integer> genHeap(int size) {
		return new UnorderedList<Integer>();
	}

}
