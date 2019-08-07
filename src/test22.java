import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses(生成括号)
 * @author xjh 2018.12.17
 */
public class test22 {
    //利用递归的方法 实现时间复杂度为O(2^n)
    //判断初始非法的输入
    //左右括号计数
    public List<String> generateParenthesis(int n) {
        List<String> list= new ArrayList();
        gp(0,0,n,"",list);
        return list;
    }
    public void gp(int left,int right,int n,String sub,List<String> list){
        if(left==n&&right==n){
            list.add(sub);
            return;
        }
        if(left<n){
            gp(left+1,right,n,sub+"(",list);
        }
        if(left>right){
            //匹配时 合法输入始终时先是左括号 再是右括号
            gp(left,right+1,n,sub+")",list);
        }
    }
}
