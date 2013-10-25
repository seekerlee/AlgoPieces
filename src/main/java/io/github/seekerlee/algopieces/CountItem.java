package io.github.seekerlee.algopieces;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;


public class CountItem {

    public void readFile(Hashtable<Long,ArrayList<Integer>> ht ) throws IOException
    {
        InputStream in = CountItem.class.getClassLoader().getResourceAsStream("algo1-programming_prob-2sum.txt");
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr);
        String strLine;
        int index=0;
        while((strLine=br.readLine())!=null)
        {
            long num = Long.parseLong(strLine);

            ArrayList<Integer> al = ht.containsKey(num) ? ht.get(num) : new ArrayList<Integer>();
            al.add(index);
            ht.put(num,al);
            index = index+1;
        }

    }

    public void CountItem() throws IOException
    {
        Hashtable<Long,ArrayList<Integer>> ht = new Hashtable<Long,ArrayList<Integer>>();
        readFile(ht);
        int item=0;
        for(long i=-10000;i<=10000;i++)
        {
            System.out.println("i= "+i + " item= "+item);
            for(Long s : ht.keySet())
            {

                long left = i - s;
                if(ht.containsKey(left))
                {
                    if(left*2==i && ht.get(left).size()==1)
                    {

                    }else
                    {
                        item = item +1;
                        break;
                    }
                }
            }
        }

        System.out.println(item);
    }

    public static void main(String[] args) throws IOException
    {
        System.out.println("test");
        CountItem ci = new CountItem();
        ci.CountItem();
    }

}