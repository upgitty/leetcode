/**
 * 
 */
package algorithms.n0057.InsertInterval;

import java.util.ArrayList;
import java.util.List;

import algorithms.n0056.MergeIntervals.Interval;

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
		intervals.add(new Interval(1,2));
		intervals.add(new Interval(3,5));
		intervals.add(new Interval(6,7));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(12,16));
		System.out.println(solution.insert(intervals, new Interval(4,9)));

	}

	/**
	 * Time Complexity : O(n)
	 * 
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		
		for(Interval interval : intervals) {
			if(interval.end < newInterval.start) {
				//new interval starts and ends AFTER this one: No intersection 
				result.add(interval);
			}else if(interval.start > newInterval.end) {
				//new interval start and ends BEFORE this one: No intersection 
				result.add(newInterval);
				newInterval = interval;
			}else if(interval.end >= newInterval.start || interval.start <= newInterval.end) {
				//new interval has some intersection: Merge them into new interval
				newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end));
			}
		}
		
		//Add the new last interval
		result.add(newInterval);
		return result;
	}
	
}
