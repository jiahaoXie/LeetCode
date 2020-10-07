package 京东;

import java.util.*;

/**
 *
 */
public class test {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("d", "10");
        map.put("c", "30");
        map.put("a", "80");
        map.put("b", "44");


        System.out.println(map);
        List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
            //升序排序
            public int compare(Map.Entry<String, String> o1,
                               Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }

        });
        System.out.println(list);
//        for(Map.Entry<String,String> mapping:list){
//            System.out.println(mapping.getKey()+":"+mapping.getValue());
//        }
    }
}
