class Solution {

    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;


        for (int[] s : squares) {
            double y = s[1];
            double l = s[2];
            totalArea += l * l;
            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }

        double target = totalArea / 2.0;
        while (high - low > 1e-6) {
            double mid = low + (high - low) / 2.0;
            double areaBelow = areaBelow(mid, squares);

            if (areaBelow < target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private double areaBelow(double h, int[][] squares) {
        double area = 0;

        for (int[] s : squares) {
            double y = s[1];
            double l = s[2];

            if (h <= y) {
                continue;
            } else if (h >= y + l) {
                area += l * l;
            } else {
                area += l * (h - y);
            }
        }

        return area;
    }
}
