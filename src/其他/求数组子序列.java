package 其他;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class 求数组子序列 {

    public static List<List<Integer>>  getSubArray(int[] arr) throws IOException,ClassNotFoundException{
        if(arr.length==0){
            return new ArrayList<>();
        }
        List<List<Integer>> all=new ArrayList<>();
        List<List<Integer>> subArray=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            subArray.add(new ArrayList<>());
            for(int j=0;j<subArray.size();j++){
                subArray.get(j).add(arr[i]);
                List<Integer> copy=(List<Integer>) deepCopy(subArray.get(j));
                all.add(copy);
            }
        }
        return all;
    }

    public static List deepCopy(List src) throws IOException,ClassNotFoundException{
        ByteArrayOutputStream byteout = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteout);
        out.writeObject(src);
        ByteArrayInputStream bytein = new ByteArrayInputStream(byteout.toByteArray());
        ObjectInputStream in = new ObjectInputStream(bytein);
        List dest = (List) in.readObject();
        return dest;
    }

    public static void main(String[] args) throws IOException,ClassNotFoundException{
        int[] arr=new int[]{1,3,5,2,7};
        List<List<Integer>> L=getSubArray(arr);
        for (int i=0;i<L.size();i++){
            System.out.println(L.get(i));
        }
    }
}
