package in.action.day908.pm.sogou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class T1HARD {
	public static void main(String[] args) throws NumberFormatException, IOException {
		double[] points = null;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		points = new double[Integer.valueOf(bf.readLine())];
		for (int i = 0; i < points.length; i++) {
			points[i] = Double.valueOf(bf.readLine());
		}
		System.out.println(compute1(points));
		System.out.println(compute2(points));
	}

	// 我的答案 n^2 90%
	public static double compute1(double[] points) {
		double max = points[1] - points[0], det = 0;
		int res;
		for (int i = 0; i < points.length; i++) {
			res = Arrays.binarySearch(points, points[i] + max);
			if (res < 0)
				res = -res - 1;
			else
				res++;
			for (int j = res; j < points.length; j++) {
				det = Math.abs(points[j] - points[i]);
				if (det > 180) {
					det = 360 - det;
				}
				if (det >= max) {
					max = det;
				} else {
					break;
				}
			}
		}
		return max;
	}

	// 陈大才 nlogn 100%
	public static double compute2(double[] points) {
		double max = 0, s1, s2, cur;
		for (double curPoint : points) {
			double candidi = curPoint >= 180 ? curPoint - 180 : 180 + curPoint;
			int i = Arrays.binarySearch(points, candidi);
			if (i >= 0)
				return 180;
			i = -(i + 1);
			s1 = distance(points[i % points.length], curPoint);
			s2 = distance(points[(i - 1 + points.length) % points.length], curPoint);
			cur = s1 > s2 ? s1 : s2;
			if (cur > max)
				max = cur;
		}
		return max;
	}

	public static double distance(double a, double b) {
		double diff = a - b;
		if (diff < 180)
			return diff;
		return 360 - diff;
	}
}
