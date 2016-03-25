/*L57 insert interval
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.
Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
//思路1：利用L56 merge算法，newInterval加入到intervals中，merge，但是时间复杂度较高。
//思路2：既然已经有序，只要插入，无需排序，再merge即可。但是时间复杂度非常高。
//思路3：边merge边插入。时间复杂度比较低。
import java.util.*;

public class L57 {
	/*
	//思路3：
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();  
   
        for(Interval interval: intervals){  
            if(interval.end < newInterval.start){  
                result.add(interval);  
            }else if(interval.start > newInterval.end){  
                result.add(newInterval);  
                newInterval = interval;          
            }else if(interval.end >= newInterval.start || interval.start <= newInterval.end){  
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(newInterval.end, interval.end));  
            }  
        }  
   
        result.add(newInterval);   
   
        return result; 
    }
	 */	
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	List<Interval> result = new LinkedList<Interval>();
    	if(newInterval == null) return intervals;
    	if(intervals.size() < 1 && newInterval != null) {
    		result.add(newInterval);
    		return result;
    	}
    	
    	
    	//思路2的做法。
//    	boolean flag = false;
//    	
//    	for(int i = 0; i < intervals.size(); i ++) {
//    		if(newInterval.start < intervals.get(i).start && !flag) {
//    			result.add(newInterval);
//    			flag = true;
//    		}
//    		result.add(intervals.get(i));
//    	}
//    	if(flag == false) result.add(newInterval);
    	
    	
    	
    	intervals.add(newInterval);
    	
    	result = merge(intervals);
    	
    	return result;
    }
    
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
		Interval i1 = new Interval(1,5);
		Interval i2 = new Interval(6,9);
		Interval i3 = new Interval(2,7);
//		Interval i4 = new Interval(15,18);
		List<Interval> intervals = new LinkedList<Interval>();
		intervals.add(i1);
		intervals.add(i2);
//		intervals.add(i3);
//		intervals.add(i4);
		
		L57 test = new L57();
		
		List<Interval> result = test.insert(intervals, i3);
		
		for(int i = 0; i < result.size(); i ++) {
			System.out.println(result.get(i).start + ", " + result.get(i).end);
		}
	}
}
