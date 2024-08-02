public class PalindromicSubstring {
    public String findStr(String s){
        if (s == null || s.length() == 0) return "";

        int n = s.length();
        boolean [][]isPalindrome = new boolean[n][n];
        int startInd = 0;
        int maxLen = 0;

        for(int i=0; i <n; i++){
            isPalindrome[i][i] = true;
            maxLen = 1;
        }

        for(int i=0; i<n-1; i++){
            if(s.charAt(i)==s.charAt(i+1)){
                isPalindrome[i][i+1]= true;
                maxLen = 2;
                startInd = i;
            }
        }

        for(int len=3; len<=n; len++){
            for(int i=0; i<=n-len; i++){
                int j = len +i -1;
                if(s.charAt(i)==s.charAt(j) && isPalindrome[i+1][j-1]){
                    isPalindrome[i][j]= true;
                    maxLen = len;
                    startInd = i;
                }
            }
        }
        return s.substring(startInd,startInd+maxLen);
    }

    public static void main(String[] args) {
        PalindromicSubstring testObj = new PalindromicSubstring();
        System.out.println(testObj.findStr("ijmadamji"));


    }
}

