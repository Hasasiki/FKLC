import java.util.Scanner;

public class AddBinary67 {
/*    Given two binary strings, return their sum (also a binary string).
    The input strings are both non-empty and contains only characters 1 or 0.
https://leetcode-cn.com/problems/add-binary
输入: a = "11", b = "1"
输出: "100"
输入: a = "1010", b = "1011"
输出: "10101"
*/
    public static void main(String[] args) {
        String str1;
        String str2;
        int[] binary1 = {};
        int[] binary2 = {};
        int[] binarySum = {};
        Scanner sc = new Scanner(System.in);
        str1 = sc.nextLine();
        str2 = sc.nextLine();
        int b1Length = str1.length();
        int b2Length = str2.length();
        for (int i = 0; i < str1.length(); i++) {
            binary1[i] = str1.charAt(i);
        }
        for (int i = 0; i < str2.length(); i++) {
            binary2[i] = str2.charAt(i);
        }
    }
}