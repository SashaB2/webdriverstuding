import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

    Logger log;

 public Test(){
     log = Logger.getLogger(getClass());
 }

    @org.junit.Test
    public void ver() throws IOException {

        Process execution = Runtime.getRuntime().exec("wget -P /home --no-check-certificate http://demo.guru99.com/test/msgr11us.exe");


        log.info("Error steam");

        BufferedReader buf = new BufferedReader(new InputStreamReader(execution.getErrorStream()));
        String line = "";
        while ((line = buf.readLine()) != null) {
            log.info("exec response: " + line);
        }

        log.info("Inpt steam");

        BufferedReader buf1 = new BufferedReader(new InputStreamReader(execution.getInputStream()));
        String line1 = "";
        while ((line1 = buf1.readLine()) != null) {
            log.info("exec response: " + line1);
        }


//        try {
//            Runtime runtime = Runtime.getRuntime();
//            Process process = runtime.exec(new String[]{"/bin/bash", "-c", "wget -P /home --no-check-certificate http://demo.guru99.com/test/msgr11us.exe"});
//            int exitValue = process.waitFor();
//            System.out.println("exit value: " + exitValue);
//            BufferedReader buf = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String line = "";
//            while ((line = buf.readLine()) != null) {
//                log.info("exec response: " + line);
//                System.out.println("exec response: " + line);
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }

}
