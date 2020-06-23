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
        int[] binary1 = new int[10000];
        int[] binary2 = new int[10000];
        int[] addToNext = new int[10001];
        int[] preSum = new int[10001];
        int[] binarySum = new int[10000];
        Scanner sc = new Scanner(System.in);
        str1 = sc.nextLine();
        str2 = sc.nextLine();
        int b1Length = str1.length();
        int b2Length = str2.length();
        for (int i = 0; i < str1.length(); i++) {
            binary1[i] = Integer.parseInt(String.valueOf(str1.charAt(i)));
        }
        for (int i = 0; i < str2.length(); i++) {
            binary2[i] = Integer.parseInt(String.valueOf(str2.charAt(i)));
        }
        if (b1Length >= b2Length) {
            binarySum = addOn(binary1, binary2);
        }else {
            binarySum = addOn(binary2, binary1);
        }
        System.out.println(binarySum);
    }
    public static int[] addOn(int[] binary1, int[] binary2){
        int[] addToNext = new int[10001];
        int[] preSum = new int[10001];
        for (int i = binary1.length -1, j = binary2.length -1,k = 0; i >=0; i--, j--, k++) {
            if ((binary1[i] == 1) && (binary2[j] ==1)) {
                addToNext[k+1] = 1;
                preSum[k] = 0;
            }else if(((binary1[i] == 1)&& (binary2[j] ==0)) || ((binary1[i] == 0)&& (binary2[j] ==1))){
                preSum[k] = 1;
            }else{
                preSum[k] = 0;
            }
        }
        int[] binarySum = new int[10001];
       //int[] binarySum = addOn(addToNext,preSum);
        return  binarySum;
    }
/*
    复杂度分析：

    时间复杂度：O(\max(M,N))O(max(M,N))，这里 MM 是字符串 a 的长度，NN 是字符串 b 的长度。
    空间复杂度：O(\max(M,N))O(max(M,N))，保存结果需要 \max(M,N)max(M,N) 长度的可变字符序列对象，
    如果最高位需要进位，还需要加 1，不过在复杂度计算中忽略这个 1。
    上面的代码“翻转”了两次，显得有点啰嗦，我们可以使用两个指针，
    分别从字符串的末尾开始向前遍历，同时在借用 StringBuilder 对象的 insert 方法，
    从右向左依次得出计算结果，就真的非常接近我们手写“竖式加法”的过程了。下面是参考代码。
*/
    public String addBinary(String a, String b){
        int i = a.length() -1;
        int j = b.length() -1;
        StringBuilder res = new StringBuilder();
        int currentSum;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            currentSum = carry;
            if (i>=0) {
                currentSum += a.charAt(i) - '0';
                i--;
            }
            if (j>=0) {
                currentSum += b.charAt(j) - '0';
                j--;
            }
            //判断是否需要进位，如果currentSum > 1 则进位，currentSum清零，carry进位符 = 1
            if (currentSum > 1) {
                currentSum -= 2;
                carry = 1;
            }else{
                carry = 0;
            }
            //只写结果的值，进位作为下一轮的初始值
            res.insert(0, currentSum);
        }
        if (carry == 1){
            res.insert(0,1);
        }
        return res.toString();
    }
}