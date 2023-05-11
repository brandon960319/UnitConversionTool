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
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

@RestController
// we allow cors requests from our frontend environment
// note the curly braces that creates an array of strings ... required by the annotation
@CrossOrigin(origins =  {"${app.dev.frontend.local}"})
public class HelloController {

    @RequestMapping(value = "/Length/{num}/{str1}/{str2}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> Length(@PathVariable String num, @PathVariable String str1, @PathVariable String str2) {     
        try
        {
            Length_Converter lc = new Length_Converter();
            String result = lc.Convert(num, str1, str2);
            return ResponseEntity.ok(Collections.singletonMap("message", result));
        } catch (IllegalArgumentException e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Invalid request parameters: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }  catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "An unexpected error occurred: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @RequestMapping(value = "/Mass/{num}/{str1}/{str2}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> Mass(@PathVariable String num, @PathVariable String str1, @PathVariable String str2) {
        try
        {
            Mass_Converter mc = new Mass_Converter();
            String result = mc.Convert(num, str1, str2);
            return ResponseEntity.ok(Collections.singletonMap("message", result));
        } catch (IllegalArgumentException e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Invalid request parameters: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }  catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "An unexpected error occurred: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @RequestMapping(value = "/celsiusToFarenheit/{num}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> celsiusToFarenheit(@PathVariable String num) {        
        try
        {
            String result = Double.toString(Temp_Converter.ConvertCelsiusToFarenheit(Double.parseDouble(num)));
            return ResponseEntity.ok(Collections.singletonMap("message", result));
        } catch (IllegalArgumentException e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Invalid request parameters: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }  catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "An unexpected error occurred: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @RequestMapping(value = "/farenheitToCelsius/{num}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> farenheitToCelsius(@PathVariable String num) { 
        try
        {
            String result = Double.toString(Temp_Converter.ConvertFarenheitToCelsius(Double.parseDouble(num)));
            return ResponseEntity.ok(Collections.singletonMap("message", result));
        } catch (IllegalArgumentException e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Invalid request parameters: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }  catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "An unexpected error occurred: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @RequestMapping(value = "/supportedImperialLengths", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> supportedImperialLengths() {  
        try 
        {
            Length_Converter lc = new Length_Converter();
            List<String> results = lc.SupportedImperialLengths();
            return ResponseEntity.ok(results);
        } catch (IllegalArgumentException e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Invalid request parameters: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }  catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "An unexpected error occurred: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @RequestMapping(value = "/supportedMetricLengths", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> supportedMetricLengths() { 
        try 
        {
            Length_Converter lc = new Length_Converter();
            List<String> results = lc.SupportedMetricLengths();
            return ResponseEntity.ok(results);
        } catch (IllegalArgumentException e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Invalid request parameters: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }  catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "An unexpected error occurred: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @RequestMapping(value = "/supportedImperialMass", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> supportedImperialMass() {    
        try 
        {
            Mass_Converter mc = new Mass_Converter();
            List<String> results = mc.SupportedImperialMass();
            return ResponseEntity.ok(results);
        } catch (IllegalArgumentException e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Invalid request parameters: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }  catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "An unexpected error occurred: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @RequestMapping(value = "/supportedMetricMass", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> supportedMetricMass() {    
        try 
        {
            Mass_Converter mc = new Mass_Converter();
            List<String> results = mc.SupportedMetricMass();
            return ResponseEntity.ok(results);
        } catch (IllegalArgumentException e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Invalid request parameters: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }  catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "An unexpected error occurred: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @RequestMapping(value = "/supportedImperialTemp", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> supportedImperialTemp() {     
        try 
        {
            List<String> results = Temp_Converter.SupportedImperialTemp();
        return ResponseEntity.ok(results);
        } catch (IllegalArgumentException e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Invalid request parameters: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }  catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "An unexpected error occurred: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @RequestMapping(value = "/supportedMetricTemp", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> supportedMetricTemp() {     
        try 
        {
            List<String> results = Temp_Converter.SupportedMetricTemp();
            return ResponseEntity.ok(results);
        } catch (IllegalArgumentException e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Invalid request parameters: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }  catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "An unexpected error occurred: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
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
