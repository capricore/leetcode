package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class InsertInterval {

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		if (intervals.size() == 0 || intervals == null) {
			result.add(newInterval);
			return result;
		}
		Comparator<Interval> intevelComparator = new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.start < o2.start) {
					return -1;
				}else if (o1.start > o2.start) {
					return 1;
				}else {
					if (o1.end < o2.end) {
						return -1;
					}else {
						return 1;
					}
				}
			}
		};
		intervals.add(newInterval);
		Collections.sort(intervals, intevelComparator);
		Interval prev = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);
			if (prev.end >= cur.start) {
				prev = new Interval(prev.start,Math.max(prev.end, cur.end));
			}else {
				result.add(prev);
				prev = cur;
			}
		}
		result.add(prev);
		return result;
	}
	
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(12, 16));
		Interval newInterval = new Interval(4,9);
		System.out.println(new InsertInterval().insert(intervals, newInterval));
	}
}
