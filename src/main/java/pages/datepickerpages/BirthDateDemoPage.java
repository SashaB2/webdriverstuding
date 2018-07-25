package pages.datepickerpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BirthDateDemoPage extends ParentPage{

    public BirthDateDemoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(text(), 'Your Birth Date')]")
    WebElement resultDatePickerXpath;

    public String getDatePickerText(){
        return resultDatePickerXpath.getText();
    }

    public String getDate(){
        String getValues = resultDatePickerXpath.getText();
        String regexDate = "\\d{4}-\\d{2}-\\d{2}";
        Pattern p = Pattern.compile(regexDate);
        Matcher m = p.matcher(getValues);

        String dateValue = "";
        if(m.find()){
            dateValue = m.group();
        }

        char [] digits = new char[8];
        digits[0] = dateValue.charAt(8);
        digits[1] = dateValue.charAt(9);
        digits[2] = dateValue.charAt(5);
        digits[3] = dateValue.charAt(6);
        digits[4] = dateValue.charAt(0);
        digits[5] = dateValue.charAt(1);
        digits[6] = dateValue.charAt(2);
        digits[7] = dateValue.charAt(3);

        StringBuilder convertedDate = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            convertedDate.append(Character.toString(digits[i]));
        }

        return convertedDate.toString();
    }

    public String getTime(){
        String getValues = resultDatePickerXpath.getText();
        String regexTime = "\\d{2}:\\d{2}";
        Pattern p = Pattern.compile(regexTime);
        Matcher m = p.matcher(getValues);

        String timeValue = "";
        if(m.find()){
            timeValue = m.group();
        }

        String hours = Character.toString(timeValue.charAt(0)) + Character.toString(timeValue.charAt(1));
        int hoursInt = Integer.parseInt(hours);

        char hourEtc;
        char etc;
        if(hoursInt >= 0 && hoursInt <= 12){
            hourEtc = String.valueOf(hoursInt).charAt(0);
            etc = "AM".charAt(0);
        }else if(hoursInt > 12 && hoursInt <= 23){
            hourEtc = String.valueOf(hoursInt).charAt(0);
            etc = "PM".charAt(0);
        }else{
            hourEtc = '\u0000';
            etc = '\u0000';
        }

        char [] digits = new char[8];
        digits[0] = hourEtc;
        digits[1] = timeValue.charAt(3);
        digits[2] = timeValue.charAt(4);
        digits[3] = etc;

        StringBuilder convertedTime = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            convertedTime.append(Character.toString(digits[i]));
        }

        return convertedTime.toString();
    }
}
