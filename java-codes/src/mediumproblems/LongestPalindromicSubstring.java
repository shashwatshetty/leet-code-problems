package mediumproblems;

// Took 2 attempts Before Referring Solution
// Took 4 attempts After Referring Solution
// Time Taken To Solve: 73 mins
class LPSSolution {
    /*
        Below approach reverses the string and checks for the Longest Common Substring in the
        two strings, however this logic fails when the palindrome of a substring is present in
        some other part of the string.
        e.g. "abcdxvdfrtdcba" has "dcba" separately which is the palindrome of "abcd"
    */
    /*
    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        StringBuilder rev = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--){
            rev.append(s.charAt(i));
        }
        int[][] table = new int[s.length()][s.length()];
        String reverse = rev.toString();
        String longestPalindrome = "";
        int longest = 0;
        int lastIndex = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(i) == reverse.charAt(j)){
                    if(i == 0 || j == 0){
                        table[i][j] = 1;
                    }else{
                        table[i][j] = table[i - 1][j - 1] + 1;
                        if(table[i][j] > longest){
                            longest = table[i][j];
                            lastIndex = i;
                        }
                    }
                }else{
                    table[i][j] = 0;
                }
            }
        }
        int start = lastIndex - longest + 1;
        if(start == s.length() - 1){
            start--;
        }
        System.out.println("Longest: "+longest+" LastIndex: "+lastIndex+" start: "+start);
        longestPalindrome = s.substring(start, lastIndex + 1);
        return longestPalindrome;
    }
    */

    /*
        Below approach takes advantage of the fact that the palindrome mirrors at its center.
        The first loop, gets all such centers, i.e. palindromes with odd length have one index
        as the center and palindromes with even length have 2 indices at the center.
        The expandAroundCenter function, starts from the center and returns the length of the
        palindrome till it exceeds the strings' bounds. end and start are used to maintain the
        indices of the longest palindrome found in the process.
    */
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            int l1 = expandAroundCenter(s, i, i);
            int l2 = expandAroundCenter(s, i, i+1);
            int maxL = l1 > l2 ? l1 : l2;
            if(maxL > (end - start)){
                start = i - (maxL - 1)/2;
                end = i + maxL/2;
            }
        }
        String palin = s.substring(start, end + 1);
        return palin;
    }

    public int expandAroundCenter(String s, int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return r - l - 1;
    }
}

public class LongestPalindromicSubstring {
    public static void main(String args[]){
        String test = "flsuqzhtcahnyickkgtfnlyzwjuiwqiexthpzvcweqzeqpmqwkydhsfipcdrsjkefehhesubkirhalgnevjugfohwnlhbjfewiunlgmomxkafuuokesvfmcnvseixkkzekuinmcbmttzgsqeqbrtlwyqgiquyylaswlgfflrezaxtjobltcnpjsaslyviviosxorjsfncqirsjpkgajkfpoxxmvsyynbbovieoothpjgncfwcvpkvjcmrcuoronrfjcppbisqbzkgpnycqljpjlgeciaqrnqyxzedzkqpqsszovkgtcgxqgkflpmrikksaupukdvkzbltvefitdegnlmzeirotrfeaueqpzppnsjpspgomyezrlxsqlfcjrkglyvzvqakhtvfmeootbtbwfhqucbnuwznigoyatvkocqmbtqghybwrhmyvvuchjpvjckiryvjfxabezchynfxnpqaeampvaapgmvoylyutymdhvhqfmrlmzkhuhupizqiujpwzarnszrexpvgdmtoxvjygjpmiadzdcxtggwamkbwrkeplesupagievwsaaletcuxtpsxmbmeztcylsjxvhzrqizdmgjfyftpzpgxateopwvynljzffszkzzqgofdlwyknqfruhdkvmvrrjpijcjomnrjjubfccaypkpfokohvkqndptciqqiscvmpozlyyrwobeuazsawtimnawquogrohcrnmexiwvjxgwhmtpykqlcfacuadyhaotmmxevqwarppknoxthsmrrknu";
        LPSSolution obj = new LPSSolution();
        String res = obj.longestPalindrome(test);
        System.out.println("The Longest Palindrmic Substring is: "+res);
    }
}