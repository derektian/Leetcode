/*L56. Merge Intervals
Given a collection of intervals, merge all overlapping intervals.
For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/

/*
 * debug records: null []
 * [1,4] [0,4] 需要考虑start也需要变化
 * [1,4] [0,0] 还是利用comparator进行排序吧...
 * 
 */

import java.util.*;
public class L56 {
	public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() < 2) return intervals;
		
        Collections.sort(intervals, new IntervalComparator());
        
		List<Interval> result = new LinkedList<Interval>();
        
        Interval temp = intervals.get(0);
        int index = 1;
        while(index  < intervals.size()) {
        	if(temp.end >= intervals.get(index).start) {
        		//[1,4][2,3]这种包含的情况
        		temp.end = Math.max(intervals.get(index).end, temp.end);
        		index ++;
        	} else {
        		result.add(temp);
        		temp = intervals.get(index);
        		index ++;
        	}
        }
        result.add(temp);
		return result;
    }
	
	class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval prev, Interval curr) {
			if(prev.start > curr.start) {
				return 1;
			} else if(prev.start == curr.start) {
				return 0;
			} else {
				return -1;
			}
		}
	}
	
	public static void main(String[] args) {
		Interval i1 = new Interval(1,4);
		Interval i2 = new Interval(0,0);
//		Interval i3 = new Interval(2,6);
//		Interval i4 = new Interval(15,18);
		List<Interval> intervals = new LinkedList<Interval>();
		intervals.add(i1);
		intervals.add(i2);
//		intervals.add(i3);
//		intervals.add(i4);
		L56 test = new L56();
		
		List<Interval> result = test.merge(intervals);
		
		for(int i = 0; i < result.size(); i ++) {
			System.out.println(result.get(i).start + ", " + result.get(i).end);
		}
	}
}


