/**
 * 
 */
package algorithms.n0056.MergeIntervals;

/**
 * @author upgitty
 *
 */
public class Interval {
	public int start;
	public int end;

	public Interval(int s, int e) {
		start = s;
		end = e;
	}

	@Override
	public String toString() {
		return "[" + start + ", " + end + "]";
	}
	
}