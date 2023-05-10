package springboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.io.Console;
import java.math.BigDecimal;
import org.springframework.web.bind.annotation.RequestMapping;
import springboot.Length_Converter;
import springboot.Mass_Converter;
import springboot.Temp_Converter;

import java.util.Collections;
import java.util.Map;
import java.util.List;

@RestController
// we allow cors requests from our frontend environment
// note the curly braces that creates an array of strings ... required by the annotation
@CrossOrigin(origins =  {"${app.dev.frontend.local}"})
public class HelloController {

    @RequestMapping(value = "/Length/{num}/{str1}/{str2}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> Length(@PathVariable String num, @PathVariable String str1, @PathVariable String str2) {     
        Length_Converter lc = new Length_Converter();
        String result = lc.Convert(num, str1, str2);
        return Collections.singletonMap("message", result);
    }

    @RequestMapping(value = "/Mass/{num}/{str1}/{str2}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> Mass(@PathVariable String num, @PathVariable String str1, @PathVariable String str2) {
        Mass_Converter mc = new Mass_Converter();
        String result = mc.Convert(num, str1, str2);
        return Collections.singletonMap("message", result);
    }

    @RequestMapping(value = "/celsiusToFarenheit/{num}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> celsiusToFarenheit(@PathVariable String num) {        
        String result = Double.toString(Temp_Converter.ConvertCelsiusToFarenheit(Double.parseDouble(num)));
        return Collections.singletonMap("message", result);
    }

    @RequestMapping(value = "/farenheitToCelsius/{num}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> farenheitToCelsius(@PathVariable String num) {        
        String result = Double.toString(Temp_Converter.ConvertFarenheitToCelsius(Double.parseDouble(num)));
        return Collections.singletonMap("message", result);
    }

    @RequestMapping(value = "/supportedImperialLengths", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> supportedImperialLengths() {        
        Length_Converter lc = new Length_Converter();
        List<String> results = lc.SupportedImperialLengths();
        return results;
    }

    @RequestMapping(value = "/supportedMetricLengths", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> supportedMetricLengths() {        
        Length_Converter lc = new Length_Converter();
        List<String> results = lc.SupportedMetricLengths();
        return results;
    }

    @RequestMapping(value = "/supportedImperialMass", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> supportedImperialMass() {        
        Mass_Converter mc = new Mass_Converter();
        List<String> results = mc.SupportedImperialMass();
        return results;
    }

    @RequestMapping(value = "/supportedMetricMass", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> supportedMetricMass() {        
        Mass_Converter mc = new Mass_Converter();
        List<String> results = mc.SupportedMetricMass();
        return results;
    }

    @RequestMapping(value = "/supportedImperialTemp", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> supportedImperialTemp() {        
        List<String> results = Temp_Converter.SupportedImperialTemp();
        return results;
    }

    @RequestMapping(value = "/supportedMetricTemp", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> supportedMetricTemp() {        
        List<String> results = Temp_Converter.SupportedMetricTemp();
        return results;
    }

    public void logToFile(String message) {
        try {
            FileWriter writer = new FileWriter("log.txt", true);
            writer.write(message + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while logging to file.");
            e.printStackTrace();
        }
    }
    
}
