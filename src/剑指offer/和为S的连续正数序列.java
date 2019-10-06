package 剑指offer;
import java.util.ArrayList;

/**
 * 注意题目要求是连续正数序列！！！
 * 这道题用双指针法 需要点技巧 low high分别表示和为S的连续正数序列的首尾下标指针
 * @author xjh 2019.04.22
 */
public class 和为S的连续正数序列 {
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        int low=1,high=2;
        while (low<high){
            int temp=(low+high)*(high-low+1)/2; //因为连续序列是一个d=1的等差序列
            if (temp==sum){
                ArrayList<Integer> t=new ArrayList<>();
                for (int i=low;i<=high;i++){
                    t.add(i);
                }
                res.add(t);
                low++;
            }else if (temp<sum){
                //和小于sum 尾指针向后移动 增加连续序列的总和
                high++;
            }else low++;    //和大于sum 头指针向后移动
        }
        return res;
    }

    public static void main(String[] args) {
        int sum=100;
        ArrayList<ArrayList<Integer>> res=FindContinuousSequence(sum);
        for (ArrayList<Integer> t:res)
            System.out.println(t);
    }
}
