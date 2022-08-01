package revensto.lc.ez;

public class Solution {
    public String generateTheString(int n) {
        String str = "";
        if(n%2==1){
            for(int i=0;i<n;i++){
                str+="a";
            }
        }else{
            for(int i=0;i<n-1;i++){
                str+="a";
            }
            str+="b";
        }
        return str;
    }
}
