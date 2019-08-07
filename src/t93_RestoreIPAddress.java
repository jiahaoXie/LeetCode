

import java.util.ArrayList;
import java.util.List;
/**
 * leetcode 93. Restore IP Addresses
 * @author xjh 2019.03.25
 */
public class t93_RestoreIPAddress {
    public static void main(String[] args) {
        t93_RestoreIPAddress xjh=new t93_RestoreIPAddress();
        String s="25525511123";
        List<String> address=xjh.restoreIpAddresses(s);
        for (String str:address)
            System.out.print(str+"; ");
        System.out.println();
    }

    //方法1 字符拆拆解成四段 每一段都有效则为有效的ip地址
    //不用dfs 暴力破解 快于84.59%
    public List<String> restoreIpAddresses(String s) {
        List<String> address=new ArrayList<>();
        int n=s.length();
        //i j k三个值将字符串分解为4段 每段判断是否有效
        for (int i=1;i<4&&i<n-2;i++){
            for (int j=i+1;j<i+4&&j<n-1;j++){
                for (int k=j+1;k<j+4&&k<n;k++){
                    String s1=s.substring(0,i),s2=s.substring(i,j),s3=s.substring(j,k),s4=s.substring(k,n);
                    //substring(start,end) 截取是包含start 不包含end
                    if (isValid(s1)&&isValid(s2)&&isValid(s3)&&isValid(s4)) address.add(s1+"."+s2+"."+s3+"."+s4);
                }
            }
        }
        return address;
    }
    public boolean isValid(String s){
        if (s.length()>3||s.length()==0||(s.charAt(0)=='0'&&s.length()>1)||Integer.valueOf(s)>255) return false;
        return true;
    }

}

