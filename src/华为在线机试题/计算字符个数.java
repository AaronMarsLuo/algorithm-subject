package 华为在线机试题;

import java.util.Scanner;

public class 计算字符个数 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine().toLowerCase();
        char letter=scanner.nextLine().toLowerCase().charAt(0);
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==letter){
                count++;
            }
        }
        System.out.println(count);
    }
}
