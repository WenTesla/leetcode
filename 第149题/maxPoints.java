
/*
给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
输入：points = [[1,1],[2,2],[3,3]]
输出：3

输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
输出：4

 */
public class maxPoints {
    /*
    执行用时：70 ms, 在所有 Java 提交中击败了5.10%的用户
    内存消耗：39 MB, 在所有 Java 提交中击败了86.18%的用户
     */
    public int maxPoints(int[][] points) {
        int count=0;
        int temp=0;
        int[] a;
        int[] b;
        int n=points.length;
//        if(points[0].equals(new int[]{0,0,}))
//            return 0;
        if (n <= 2) {
            return n;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                a=points[i];
                b=points[j];
                temp= countLine(a,b,points);
                count=Math.max(temp,count);
            }
        }
        return count;
    }

    private int countLine(int[] a, int[] b, int[][] points) {
        /*
        a(x1,y1)
        b(x2,y2)
         */
        int k_;
        int b_;
        int count=0;
        if (a[0]==b[0]) {//竖直线
            for (int i = 0; i < points.length; i++) {
                if (points[i][0] == a[0])
                    count++;
            }
            return count;
        }
        //非直线
        for (int i = 0; i < points.length; i++) {
            if (isLine(a,b,points[i]))//判断是否共线
                count++;
        }
        return count;
    }

    private boolean isLine(int[] a, int[] b, int[] point) {//判断三个点是否共线
        /*
        y2-y1/x2-x1 == y3-y1/x3-x1 ->>> (x2-x1)*(y3-y1) == (y2-y1)*(x3-x1)
         */
       double s1=(b[0]-a[0])*(point[1]-a[1]);
       double s2=(b[1]-a[1])*(point[0]-a[0]);
       if (s2 == s1)
           return true;
       return false;
    }

}
class maxPointTest{
    public static void main(String[] args) {
        maxPoints points = new maxPoints();
        System.out.println(points.maxPoints(new int[][]{{1,1},{2,2},{3,3}}));
        System.out.println(points.maxPoints(new int[][]{
                        {1,1},
                        {3,2},
                        {5,3},
                        {4,1},
                        {2,3},
                        {1,4}
        }));
        System.out.println(points.maxPoints(new int[][]{{0,0}}));
        System.out.println(points.maxPoints(new int[][]{
                        {-6,-1},
                        {3,1},
                        {12,3}}));
    }
}
