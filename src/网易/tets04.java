package 网易;

import java.util.*;

public class tets04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] ss = s.split(" ");
        int n = Integer.parseInt(ss[0]);
        String account = ss[1];
        String[] log = new String[n];
        for (int i = 0; i < log.length; i++) {
            log[i] = in.nextLine();   //接收每行输入
        }
        Map<Map<String, String>, Integer> res = new HashMap<>(); //保存玩家账号和设备
//        Set<String> set=new HashSet<>();
        Map<String, String> sss = new HashMap<>();
        Set<Map.Entry<String, String>> set = new HashSet<>();
        List<Map<String, String>> list = new ArrayList<>();

        List<String> user = new ArrayList<>();
        List<String> device = new ArrayList<>();
        //统计用户 在每个设备有效的次数count
        int count = 0;
        for (int i = 0; i < log.length; i++) {
            //每行进行判断
            String[] temp = log[i].split(" ");
            //首先消除无效的输入
            if (!temp[1].equals("logout") || Integer.parseInt(temp[4]) < 60) continue;
//            user.add(temp[2]);
//            device.add(temp[3]);

        }

        for (int i = 1; i < user.size(); i++) {
            for (int j = 0; j < i; j++) {
//                if (user.get(i).equals(user.get(j))&&device.get(i).equals(device.get(j)))
            }
        }


//        List<String> result=new ArrayList<>();
////        for (Map.Entry<Map<String,String>,Integer> x:res.entrySet()){
////            if (x.getValue()<3) continue;   //过滤小于3的值
////            //剩下合适的
////            list.add(x.getKey());
////        }
////        for (int i=0;i<list.size();i++){
////            System.out.println(list.get(i));
////        }

//        for (Map<String,String> ttt:res.keySet()){
//            for (Map.Entry<String,String> aaa:ttt.entrySet()){
//                System.out.println(aaa.getKey()+" "+aaa.getValue());
//            }
//        }
    }
}
