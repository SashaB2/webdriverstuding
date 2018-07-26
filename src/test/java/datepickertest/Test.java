package datepickertest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ParentPage;
import pages.datepickerpages.BirthDateDemoPage;

import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test{

    public static void main(String[] args) {


            System.out.println(getTime("12:00"));

    }


    static String getTime(String time){

        String getValues = time;
        String regexTime = "\\d{2}:\\d{2}";
        Pattern p = Pattern.compile(regexTime);
        Matcher m = p.matcher(getValues);

        String timeValue = "";
        if(m.find()){
            timeValue = m.group();
        }

        String hours = Character.toString(timeValue.charAt(0)) + Character.toString(timeValue.charAt(1));
        int hoursInt = Integer.parseInt(hours);

        String minutes = Character.toString(timeValue.charAt(3)) + Character.toString(timeValue.charAt(4));





        String hoursEtc = "";
        final String am = "AM";
        final String pm = "PM";

        if(hoursInt >= 0 && hoursInt < 12){
            if(hoursInt >= 0 && hoursInt < 1){
                hoursEtc = "12";
            }
            else{
                hoursEtc = "0" + hoursInt;
            }

            minutes += am;
        }
        else if(hoursInt >= 12 && hoursInt <= 23){
            if(hoursInt >= 12 && hoursInt < 13){
                hoursEtc = "" + hoursInt;
            }
            else if(hoursInt >= 13 && hoursInt <= 21){
                hoursEtc = "0" + (hoursInt - 12);
            }
            else if(hoursInt >= 22 && hoursInt <= 23){
                hoursEtc = "" + (hoursInt - 12);
            }

            minutes += pm;
        }

        StringBuilder convertedTime = new StringBuilder();
        convertedTime.append(hoursEtc);
        convertedTime.append(minutes);
        return convertedTime.toString();
    }


    void t (){



    }


}
