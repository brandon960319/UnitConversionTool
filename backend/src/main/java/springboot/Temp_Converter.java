package springboot;

import java.util.List;
import java.util.ArrayList;

public class Temp_Converter {
    
    public static double ConvertCelsiusToFarenheit(double length)
    {
        return (length * 9/5) + 32;
    }
    
    public static double ConvertFarenheitToCelsius(double length)
    {        
        return (length - 32) * 5/9;        
    }

    public static List<String> SupportedMetricTemp()
    {
        List<String> lengths = new ArrayList<>() ;        
        lengths.add("CELSIUS");        
        return lengths;
    }

    public static List<String> SupportedImperialTemp()
    {
        List<String> lengths = new ArrayList<>() ;        
        lengths.add("FARENHEIT");        
        return lengths;
    }
    
    public static void main(String[] args) 
    {
        /*
        double temp = 100;
        
        //METRIC CASES                
        System.out.println(temp + " CELSIUS is equal to " + ConvertCelsiusToFarenheit(temp) + " FARENHEIT.");
        
        //IMPERIAL CASES
        System.out.println(temp + " FARENHEIT is equal to " + ConvertFarenheitToCelsius(temp) + " CELSIUS.");
        
        temp = -100;
        
        //METRIC CASES                
        System.out.println(temp + " CELSIUS is equal to " + ConvertCelsiusToFarenheit(temp) + " FARENHEIT.");
        
        //IMPERIAL CASES
        System.out.println(temp + " FARENHEIT is equal to " + ConvertFarenheitToCelsius(temp) + " CELSIUS.");
        
        temp = 0;
        
        //METRIC CASES                
        System.out.println(temp + " CELSIUS is equal to " + ConvertCelsiusToFarenheit(temp) + " FARENHEIT.");
        
        //IMPERIAL CASES
        System.out.println(temp + " FARENHEIT is equal to " + ConvertFarenheitToCelsius(temp) + " CELSIUS.");
        */
    }
}
