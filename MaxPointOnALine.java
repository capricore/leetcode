import java.util.HashMap;

class Point
{
	int x;
	int y;

	Point()
	{
		x = 0;
		y = 0;
	}

	Point(int a, int b)
	{
		x = a;
		y = b;
	}
}

public class MaxPointOnALine
{
	public int maxPoints(Point[] points)
	{
		int result = 0;
		HashMap<Double, Integer> slopHashMap = new HashMap<Double,Integer>();
		for (int i = 0; i < points.length; i++)
		{
			slopHashMap.clear();
			int samePoint = 0;
			int maxPoint = 1;
			for (int j = i+1; j < points.length; j++)
			{
				double slop;
				if (points[i].x == points[j].x)
				{
					slop = Double.MAX_VALUE;
					if (points[i].y == points[j].y)
					{
						samePoint++;
						continue;
					}
				}else {
					if (points[i].y == points[j].y)
					{
						slop =0.0;
					}else {
						slop = (double)(points[i].y - points[j].y)/(points[i].x - points[j].x);
					}
				}
				int count = 0;
				if (slopHashMap.containsKey(slop))
				{
					count = slopHashMap.get(slop);
					slopHashMap.put(slop, ++count);
				}else {
					count = 2;
					slopHashMap.put(slop, count);
				}
				if (maxPoint < count)
				{
					maxPoint = count;
				}
			}
			result = Math.max(maxPoint+samePoint, result);
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		MaxPointOnALine maxPointOnALine = new MaxPointOnALine();
		Point[] points = {new Point(2,3) ,new Point(3,3),  new Point(-5,3)};
		System.out.println(maxPointOnALine.maxPoints(points));
	}
}
