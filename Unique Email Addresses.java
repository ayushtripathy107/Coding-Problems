import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numUniqueEmails(String[] emails) {
        // Set to store unique canonical email addresses
        Set<String> uniqueEmails = new HashSet<>();
        
        for (String email : emails) {
            // Split the email into local and domain names
            int atIndex = email.indexOf('@');
            String local = email.substring(0, atIndex);
            String domain = email.substring(atIndex); // Keep the '@' with the domain
            
            // Apply Rule 2: Ignore everything after the first '+' sign
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf('+'));
            }
            
            // Apply Rule 1: Remove all '.' periods from the local name
            local = local.replace(".", "");
            
            // Recombine and add to the set
            uniqueEmails.add(local + domain);
        }
        
        // The size of the set represents the number of unique emails
        return uniqueEmails.size();
    }
}
