import java.util.*;
public class LongestSubsequence{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        sc.close();

        System.out.println(longestCommonSubsequence(s1,s2));

    }

    private static int longestCommonSubsequence(String s1,String s2){
        return -1;
    }
}