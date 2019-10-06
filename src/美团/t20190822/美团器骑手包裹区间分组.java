package 美团.t20190822;

import java.util.*;

public class 美团器骑手包裹区间分组 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String string = in.next();
        char[] charArray = string.toCharArray();
        ArrayList<Integer> result = new ArrayList<Integer>();
        int sum = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < charArray.length; i++){
            if(map.get(charArray[i]) == null){
                map.put(charArray[i], 1);
                continue;
            }
            map.put(charArray[i], map.get(charArray[i])+1);
        }

        Set<Character> temp = new HashSet<>();
        for(int i = 0; i < charArray.length; i++){
            temp.add(charArray[i]);
            Integer integer = map.get(charArray[i]);
            if(integer > 1){
                sum++;
                map.put(charArray[i], integer-1);
            }else if(integer == 1){
                sum++;
                boolean flag = true;
                map.remove(charArray[i]);
                for(char j : temp){
                    if(map.get(j) != null){
                        flag = false;
                    }
                }
                if(flag){
                    temp.clear();
                    result.add(sum);
                    sum = 0;
                }else {
                    continue;
                }
            }
        }
        for(int i : result){
            if (i==result.size()-1) System.out.println(i);
            else System.out.print(i+" ");
        }
    }
}
