package easyproblems;

import java.util.HashMap;

// Took 1 attempt
// Time Taken To Solve: 31 mins
class UniqueEmailsSolution {
    public int numUniqueEmails(String[] emails) {
        if(emails == null || emails.length == 0) {
        	return 0;
        }
        HashMap<String, String> mailList = new HashMap<String, String>();
        for(String id : emails) {
        	String[] parts = id.split("@");
        	String beforePlus = parts[0].split("\\+")[0];
			StringBuilder mail = new StringBuilder();
        	for(char c : beforePlus.toCharArray()) {
        		if(c != '.') {
					mail.append(c);
        		}
        	}
        	mail.append(parts[1]);
        	mailList.put(mail.toString(), id);
        }
        return mailList.size();
    }
}

public class UniqueEmails {
	public static void main(String args[]) {
		UniqueEmailsSolution obj = new UniqueEmailsSolution();
		String[] arr = {"shash.shetty@le.et.com", "sha.shs.het.ty@leet.com", "sh.xyz@leet.com", "sshetty@lv.co"};
		System.out.println(obj.numUniqueEmails(arr));
	}
}