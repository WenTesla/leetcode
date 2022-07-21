
import java.util.HashSet;

/*
编写一个算法来判断一个数 n 是不是快乐数。

「快乐数」定义为：

对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
如果这个过程 结果为1，那么这个数就是快乐数。
如果 n 是 快乐数 就返回 true ；不是，则返回 false 。

输入：n = 19
输出：true
解释：
1*1+9*9=82
8*8+2*2=68
6*6+8*8=100
1*1+0*0+0*0=1

输入：n = 2
输出：false
 */
public class isHappy {
    /*
    常规方法：
    使用hashset记录每一个数字，如果数字存在则表示不为快乐数
    执行用时：1 ms, 在所有 Java 提交中击败了79.06%的用户
    内存消耗：38.5 MB, 在所有 Java 提交中击败了72.47%的用户
     */
//    public boolean isHappy(int n) {
//        HashSet<Integer> set = new HashSet<>();
//        int x=n;
//        set.add(n);
//        while (true){
//            x=mulAndplus(x);
//            if (x == 1)
//                return true;
//            if (x>=Integer.MAX_VALUE)
//                break;
//            if (!set.add(x))
//                return false;
//        }
////        mulAndplus(19);
//        return false;
//    }

    public boolean isHappy(int n){
        int slow=n;
        int fast=n;
        do{
            slow=mulAndplus(slow);
            fast=mulAndplus(fast);
            fast=mulAndplus(fast);
        }while (slow!=fast);
        //跳出循环
        return (slow == 1);
    }
    public int mulAndplus(int n){
        int x=n;
        int plus=0;
        int temp=1;
        while (x>0){
            temp=x%10;
            x/=10;
            temp*=temp;
            plus+=temp;
        }
//        System.out.println(plus);
        return plus;
    }
}
class isHappyTest{
    public static void main(String[] args) {
        isHappy a = new isHappy();
        System.out.println(a.isHappy(19));
    }
}
