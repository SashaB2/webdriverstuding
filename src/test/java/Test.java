import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

    public static void main(String[] args) {

    }


    @org.junit.Test
    public void ver() throws IOException {

        Process execution = Runtime.getRuntime().exec("/usr/bin/wget -P /home --no-check-certificate http://demo.guru99.com/test/msgr11us.exe");
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(new String[]{"/bin/bash", "-c", "/usr/bin/wget -P /home --no-check-certificate http://demo.guru99.com/test/msgr11us.exe"});
            int exitValue = process.waitFor();
            System.out.println("exit value: " + exitValue);
            BufferedReader buf = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = buf.readLine()) != null) {
                System.out.println("exec response: " + line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
