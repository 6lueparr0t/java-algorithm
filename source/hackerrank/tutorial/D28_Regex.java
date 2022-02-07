package source.hackerrank.tutorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

class Address {
    String firstName;
    String emailID;
 
    Address (String firstName, String emailID) {
        this.firstName = firstName;
        this.emailID = emailID;
    }
}

public class D28_Regex {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());
        
        List<Address> addressList = new ArrayList<Address>();
        IntStream.range(0, N).forEach(NItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                String firstName = firstMultipleInput[0];
                String emailID = firstMultipleInput[1];
                
                Address address = new Address(firstName, emailID);
                addressList.add(address);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        
        getNameList(addressList);

        bufferedReader.close();
    }
    
    public static void getNameList (List<? extends Address> addressList) {
        int addressListCount = addressList.size();
        List<String> matchedList = new ArrayList<String>();
 
        for (int i = 0; i < addressListCount; i++) {
            Address address = addressList.get(i);
            String firstName = address.firstName;
            String emailID = address.emailID;
            boolean isMatch = false;
 
            //Each of the first names consists of lower case letters  only.
            // The length of the first name is no longer than 20.
            Pattern firstNamePattern = Pattern.compile("[a-z]{1,20}");
            Matcher firstNameMatcher = firstNamePattern.matcher(firstName);
 
            //Each of the email IDs consists of lower case letters[a-z] ,@  and . only.
            //The length of the email ID is no longer than 50.
            Pattern emailIdPattern = Pattern.compile("([a-z]{1,40})@gmail\\.com");
            Matcher emailIdMatcher = emailIdPattern.matcher(emailID);
 
            if (firstNameMatcher.find() && emailIdMatcher.find()) {
                isMatch = true;
            } else {
                isMatch = false;
            }
 
            if (isMatch) {
                matchedList.add(firstName);
            }
        }
 
        //alphabetically sorting
        String[] nameList = new String[matchedList.size()];
        nameList = matchedList.toArray(nameList);
        Arrays.sort(nameList);
 
        for(String name : nameList) {
            System.out.println(name);
        }
    }
}
