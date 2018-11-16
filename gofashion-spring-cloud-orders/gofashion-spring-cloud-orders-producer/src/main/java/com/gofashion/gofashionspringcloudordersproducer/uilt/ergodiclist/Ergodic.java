package com.gofashion.gofashionspringcloudordersproducer.uilt.ergodiclist;

import java.util.*;

public class Ergodic {
    public static List<String> ergodic(List<String> stringList){
        List<String> stringList1 = new ArrayList<>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String item: stringList){
            if(map.containsKey(item)){
                map.put(item, map.get(item).intValue() + 1);
            }else{
                map.put(item, new Integer(1));
            }
        }
        Iterator<String> keys = map.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
//            System.out.print(key + ":" + map.get(key).intValue() + ", ");
            stringList1.add(key);
        }
        return stringList1;
    }
}
