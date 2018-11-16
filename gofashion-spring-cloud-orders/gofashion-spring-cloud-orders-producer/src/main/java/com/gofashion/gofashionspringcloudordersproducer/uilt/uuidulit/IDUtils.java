package com.gofashion.gofashionspringcloudordersproducer.uilt.uuidulit;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.UUID;


/**
 * 时间戳加8位随机数
 */
public class IDUtils {
    private static byte[] lock = new byte[0];
    // 位数，默认是8位
    private final static long w = 100000000;

    public synchronized static String createID() {
        long r = 0;
        synchronized (lock) {
            r = (long) ((Math.random() + 1) * w);
        }
        String yyyyMMddHHmmss = dateToString((new Date(System.currentTimeMillis())), "yyyyMM");
//        System.out.println(yyyyMMddHHmmss);
//        System.out.println(String.valueOf(r).substring(1));
//        return yyyyMMddHHmmss + String.valueOf(r).substring(1);
        String time = System.currentTimeMillis() + "";
        String substring = time.substring(4);
        Integer x=(int)(Math.random()*100);
        String format = String.format("%02d", x);//如果不足两位，前面补0
        return yyyyMMddHHmmss + substring + format;
    }

    public static String result(){
        //定义一个集合用于存放数字
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random r = new Random();
        int number = r.nextInt(100)+1;//随机生成1个1-100的数字
        list.add(number);//生成的一个数放在集合里
        for(int a = 0;a<9;a++){//0-9表示循环9次,加上行已经生成一个随机数放在集合中,所以最终结果会产生1-100里不同的十个数
            int number2 = r.nextInt(100)+1;//生成一个随机数
            if(list.contains(number2)){//判断生成的数字number2与集合里已经存在的数number比较,如果有重复的数字,a--表示该次数不算数接着再来生成随机数
                a--;
            }
            else{
                list.add(number2);//产生的随机与集合里的数字不一样,就放在集合里
            }
        }
        return "";
    }
    /*
     * Date、String、Long三种日期类型之间的相互转换
     * date类型转换为String类型
     * */
    // formatType格式为yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
    // data Date类型的时间
    private static String dateToString(Date data, String formatType) {
        return new SimpleDateFormat(formatType).format(data);
    }

    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };

    /**
     * 生成8位UUID
     * @return 8位UUID
     */
    public static String generateShortUuid() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();
    }
}
