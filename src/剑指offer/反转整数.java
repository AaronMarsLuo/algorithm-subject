package 剑指offer;

import org.omg.PortableInterceptor.INACTIVE;

public class 反转整数 {
    public static Integer reverseInt(int num){
        int result=0;
        int p=Math.abs(num);
        while(p>0){
            if(result> (Integer.MAX_VALUE-(p%10))/10){
                return null;
            }
            result=result*10+p%10;
            p=p/10;
        }
        return num<0?-1*result:result;
    }
    public static void main(String[] args) {
        java.lang.String t="t";
        String m="sdfa";
        System.out.println(reverseInt(2147483647));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
