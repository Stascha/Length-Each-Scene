/** Created by stasa on 1.2.2018  */

import java.util.*;

public class Runner
{
    public static void main(String[] args)
    {
        List<Character> a = new ArrayList<Character>();

        // This is a test case:
        String s = "ababcbacadefegdehijhklij";

        for (int i=0; i<s.length(); i++)
            a.add(s.charAt(i));

        System.out.println((new Solution()).lengthEachScene(a));
      
    }
}
