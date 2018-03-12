// 3 attempts done, logic incorrect!
public class LongestPalindromicSubstring {
    public static void main(String args[]){
        String test = "flsuqzhtcahnyickkgtfnlyzwjuiwqiexthpzvcweqzeqpmqwkydhsfipcdrsjkefehhesubkirhalgnevjugfohwnlhbjfewiunlgmomxkafuuokesvfmcnvseixkkzekuinmcbmttzgsqeqbrtlwyqgiquyylaswlgfflrezaxtjobltcnpjsaslyviviosxorjsfncqirsjpkgajkfpoxxmvsyynbbovieoothpjgncfwcvpkvjcmrcuoronrfjcppbisqbzkgpnycqljpjlgeciaqrnqyxzedzkqpqsszovkgtcgxqgkflpmrikksaupukdvkzbltvefitdegnlmzeirotrfeaueqpzppnsjpspgomyezrlxsqlfcjrkglyvzvqakhtvfmeootbtbwfhqucbnuwznigoyatvkocqmbtqghybwrhmyvvuchjpvjckiryvjfxabezchynfxnpqaeampvaapgmvoylyutymdhvhqfmrlmzkhuhupizqiujpwzarnszrexpvgdmtoxvjygjpmiadzdcxtggwamkbwrkeplesupagievwsaaletcuxtpsxmbmeztcylsjxvhzrqizdmgjfyftpzpgxateopwvynljzffszkzzqgofdlwyknqfruhdkvmvrrjpijcjomnrjjubfccaypkpfokohvkqndptciqqiscvmpozlyyrwobeuazsawtimnawquogrohcrnmexiwvjxgwhmtpykqlcfacuadyhaotmmxevqwarppknoxthsmrrknu";
        LPSSolution obj = new LPSSolution();
        String res = obj.longestPalindrome("abbd");
        System.out.println("The Longest Palindrmic Substring is: "+res);
    }
}

class LPSSolution {
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
}
