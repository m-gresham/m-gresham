package m0.growinglist;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import timing.Ticker;

public class TestRarrays {

	@Test
	public void testGrowPreservesData() {
		Random r = new Random();
		final int growby = r.nextInt(10)+1;
		System.out.println("Random grow by " + growby);
		final Rarrays arr = new Rarrays() {
			
			private int oldsize = 2;

			@Override
			public int getNewSize() {
				oldsize = oldsize + growby;
				return oldsize;
			}
			
		};
		Ticker t = new Ticker();
		arr.reset(t);
		List<Integer> ints = new LinkedList<Integer>();
		for (int i=0; i < 100; ++i) {
			ints.clear();
			for (int j=0; j < arr.array.length; ++j) {
				int v = r.nextInt();
				ints.add(v);
				arr.array[j] = v;
			}
			checksame("this should never fail", ints, arr.array);
			int oldlength = arr.array.length;
			arr.replaceArrayWithBiggerOne();
			assertEquals("Array should have grown from " + arr.array.length + " by " + growby + " to " + (oldlength+growby),oldlength+growby,arr.array.length);
			checksame("You did not copy the old array to the new one",ints,arr.array);
		}
	}
	
	@Test
	public void testGrowSufficientTicks() {
		Random r = new Random();
		final int growby = r.nextInt(10)+1;
		System.out.println("Random grow by " + growby);
		final Rarrays arr = new Rarrays() {
			
			private int oldsize = 2;

			@Override
			public int getNewSize() {
				oldsize = oldsize + growby;
				return oldsize;
			}
			
		};
		Ticker t = new Ticker();
		arr.reset(t);
		for (int i=0; i < 100; ++i) {
			int oldlength = arr.array.length;
			arr.replaceArrayWithBiggerOne();
			assertTrue("In replaceArrayWithBiggerOne, you must increase ticks by at least the old and new array lengths",
					t.getTickCount() >= oldlength + arr.array.length);
		}
	}

	
	private void checksame(String err,List<Integer> reflist, int[] array) {
		for (int i=0; i < reflist.size(); ++i) {
			assertEquals(err, reflist.get(i), new Integer(array[i]));
		}
		
	}

}
