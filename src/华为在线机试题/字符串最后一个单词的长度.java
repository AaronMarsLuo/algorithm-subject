package 华为在线机试题;

import java.util.Scanner;

public class 字符串最后一个单词的长度 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int count = 0;
            boolean flag = false;
            for (int i = str.length() - 1; i >= 0; i--) {
                if (str.charAt(i) != ' ') {
                    flag = true;
                    count++;
                }
                if (str.charAt(i) == ' ' && flag) {
                    break;
                }
            }
            System.out.println(count);
        }
    }
}
