/**
 * 
 */
package algorithms.n0056.MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author upgitty
 *
 */
public class Solution {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(2,6));
		intervals.add(new Interval(15,18));
		System.out.println(solution.merge(intervals));
	}

	/**
	 * Time Complexity : O(nlog n)
	 * 
	 * @param intervals
	 * @return
	 */
	public List<Interval> merge(List<Interval> intervals) {
        
		if(intervals == null || intervals.isEmpty()) {
			return intervals;
		}
		
		//Sort the intervals by their start
		Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
			
		});
		
		List<Interval> result = new ArrayList<>();
		Interval previous = intervals.get(0);
		
		for(int i=1; i<intervals.size(); i++) {
			Interval current = intervals.get(i);
			
			if(previous.end >= current.start) {
				//merge
				Interval merged = new Interval(previous.start, Math.max(previous.end, current.end));
				previous = merged;
			}else {
				result.add(previous);
				previous = current;
			}
		}
		
		//add the last one
		result.add(previous);
		
		return result;
    }
}
