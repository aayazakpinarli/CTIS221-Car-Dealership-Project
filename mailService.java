//package OtherClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class mailService {
    
    public static void sendMail(String body, String mail) {
    	 try {
             
             // using the Runtime exec method:
             Process p = Runtime.getRuntime().exec(new String[] {"python", "mailService.py", "Dealership System Password", body, mail});
            
             InputStream stdout = p.getInputStream();
             BufferedReader reader = new BufferedReader(new
             InputStreamReader(stdout));

             String line;
             while ((line = reader.readLine()) != null) {
                 System.out.println("Python Output: " + line);
             }
         }
         catch (IOException e) {
             System.out.println("exception happened - here's what I know: ");
             e.printStackTrace();
             System.exit(-1);
         }
    }
}