package 其他;

public class KMP算法 {
    public void getNext(int[] next,String str){
        next[0]=-1;
        int i=-1,j=0;
        while(j<str.length()-1){
            if(i==-1 || str.charAt(i)==str.charAt(j)){
                i++;
                j++;
                next[j]=i;
            }else{
                i=next[i];
            }
        }
    }
    public static int KMP(String txt,String str){
        if(null==txt || null==str){
            return -1;
        }
        if(str.equals("")){
            return 0;
        }
        int[] next=new int[str.length()];
        calNext(next,str);
        int i=0,j=0;
        while(i<str.length() && j<txt.length()){
            if(i==-1 || str.charAt(i)==txt.charAt(j)){
                i++;
                j++;
            }else{
                i=next[i];
            }
        }
        if(i==str.length()){
            return j-i;
        }else{
            return -1;
        }
    }
    public static void calNext(int[] next,String str){
        next[0]=-1;
        if(next.length==1){
            return;
        }
        next[1]=0;
        int i=2;
        int m=next[i-1];
        while(i<str.length()){
            if(m==-1 || str.charAt(i-1)==str.charAt(m)){
                next[i]=m+1;
                m++;
                i++;
            }else{
                m=next[m];
            }
        }
    }

    public static void main(String[] args) {
        String str="abcdabc";
        int[] next=new int[str.length()];
        calNext(next,str);
        for(int i=0;i<str.length();i++){
            System.out.print(str.charAt(i)+" ");
        }
        System.out.println();
        for (int i=0;i<next.length;i++){
            System.out.print(next[i]+" ");
        }
        System.out.println();
        String str1="ABCDEFg";
        String str2="ABC";
        System.out.println(KMP(str1,str2));
        String str3="EFG";
        System.out.println(KMP(str1,str3));
        String str4="EFg";
        System.out.println(KMP(str1,str4));
        String str5="g";
        System.out.println(KMP(str1,str5));
        String str6="CEF";
        System.out.println(KMP(str1,str6));
        String str7="";
        System.out.println(KMP(str1,str7));
        String str8="ABCDEFg";
        System.out.println(KMP(str1,str8));

    }
}
