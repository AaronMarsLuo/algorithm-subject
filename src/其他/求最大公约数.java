package 其他;

public class 求最大公约数 {
    //辗转相除法
    public static int gcd1(int a, int b) {
        int l = Math.max(a, b);
        int s = Math.min(a, b);
        while (s != 0) {
            int r = l % s;
            l = s;
            s = r;
        }
        return l;
    }

    //更相减损术
    public static int gcd2(int a, int b) {
        int l = Math.max(a, b);
        int s = Math.min(a, b);
        int r = l - s;
        while (s != r) {
            l = Math.max(s, r);
            s = Math.min(s, r);
            r = l - s;
        }
        return r;
    }

    //更相减损术改进
    public static int gcd3(int a, int b) {
        int l = Math.max(a, b);
        int s = Math.min(a, b);
        int r = l - s;
        int multi = 1;
        while (s != r) {
            if ((l & 1) == 0 && (s & 1) == 0) {
                l = l >> 1;
                s = s >> 1;
                multi <<= 1;
            } else if ((l & 1) == 0 && (s & 1) != 0) {
                l = l >> 1;
                if (l < s) {
                    int p = l;
                    l = s;
                    s = p;
                }
            } else if ((l & 1) != 0 && (s & 1) == 0) {
                s = s >> 1;
            } else {
                l = Math.max(s, r);
                s = Math.min(s, r);
            }
            r = l - s;
        }
        return r * multi;
    }

    public static void main(String[] args) {
        System.out.println(gcd1(155, 65));
        System.out.println(gcd2(155, 65));
        System.out.println(gcd3(27, 14));
        System.out.println(gcd3(100, 80));
        System.out.println(gcd3(9999999, 1));
        System.out.println(gcd3(121, 11));
        System.out.println(gcd3(12, 6));
    }
}
