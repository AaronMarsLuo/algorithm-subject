package 剑指offer;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 保证base和exponent不同时为0
 */
public class 值的整数次方 {
    public static double Power(double base, int exponent) {
        if(base==0){
            return 0;
        }
        if(exponent==0){
            return 1;
        }
        int exp=Math.abs(exponent);
        double result=1.0;
        double baseMulti=base;
        while(exp!=0){
            if((exp&1)==1){
                result*=baseMulti;
            }
            baseMulti*=baseMulti;
            exp=exp>>>1;
        }
        return exponent<0?1.0/result:result;
    }

    public static void main(String[] args) {
        System.out.println(Power(0,23));
        System.out.println(Power(2.3,0));
        System.out.println(Power(2.0,10));
        System.out.println(Power(2.0,-10));
        System.out.println(Power(3.0,5));
    }
}
