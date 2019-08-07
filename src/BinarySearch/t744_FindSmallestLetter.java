package BinarySearch;

/**
 * leetcode 744 Find Smallest Letter Greater Than Target
 * @author xjh 2019.03.11
 * 二分查找的辨析
 */
public class t744_FindSmallestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int n= letters.length-1;
        int l=0,res;
        while (l<=n){
            int mid=l+(n-l)/2;
            if (letters[mid]<=target){
                l=mid+1;
            }else{//letters[mid]>target
                if (mid==0||letters[mid-1]<=target) return letters[mid]; //第一个
                else n=mid-1;   //不是第一个 就右下标减小
            }
        }
        return letters[0];
    }

    public static void main(String[] args) {
        t744_FindSmallestLetter xjh=new t744_FindSmallestLetter();
        char[] letters={'c','f','g'};
        System.out.println(xjh.nextGreatestLetter(letters,'g'));
    }
}
