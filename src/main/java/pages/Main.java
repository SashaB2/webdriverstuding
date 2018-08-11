package pages;


import java.io.IOException;

public class Main {

    public static void runLinCom()throws IOException {
        Process execution = Runtime.getRuntime().exec("wget -P /home --no-check-certificate http://demo.guru99.com/test/msgr11us.exe");
//        Process execution = Runtime.getRuntime().exec("C:\\\\CV\\\\webdriverstuding\\\\drivers\\\\wget\\\\wget.exe -P C:\\\\CV --no-check-certificate http://demo.guru99.com/test/msgr11us.exe");
    }


}
