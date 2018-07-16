class StrStrSolution {
    public int strStr(String haystack, String needle) {
    	if(needle.equals("")){
    		return 0;
    	}
        int l1 = haystack.length();
        int l2 = needle.length();
        for(int i = 0; i <= l1 - l2; i++){
        	int s = i;
        	boolean flag = true;
        	for(int j = 0; j < l2; j++){
        		if(haystack.charAt(s) != needle.charAt(j)){
        			flag = false;
        			break;
        		}
        		s++;
        	}
        	if(flag){
        		return i;
        	}
        }
        return -1;
    }
}

public class StrStr{
	public static void main(String args[]){
		String s1 = "hello";
		String s2 =  "how";
		StrStrSolution obj = new StrStrSolution();
		System.out.println(obj.strStr(s1, s2));
	}
}