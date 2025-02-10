public class isPalindrome {

        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }

            long reversed = 0;
            long temp = x;

            while (temp != 0) {
                int digit = (int) (temp % 10);
                reversed = reversed * 10 + digit;
                temp /= 10;
            }

            return (reversed == x);
        }
    public static void main(String[] args) {
        isPalindrome testObj  = new isPalindrome();
        System.out.println(testObj.isPalindrome(16761));
    }

}
