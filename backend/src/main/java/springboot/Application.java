package springboot;

import com.jayway.jsonpath.internal.function.text.Length;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.math.BigDecimal;
import java.util.Collections;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(Application.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
        app.run(args);
        

/*
        Mass_Converter mc = new Mass_Converter();
        Length_Converter lc = new Length_Converter();

        BigDecimal meters = new BigDecimal("100");

        
        

        Boolean b = mc.isMetric("MICROGRAM");
        if (b)
        {
            System.out.println("MICROGRAM IS METRIC");
        }
        else {
            System.out.println("MICROGRAM IS NOT METRIC");
        }

        b = mc.isImperial("MICROGRAM");
        if (b)
        {
            System.out.println("MICROGRAM IS Imperial");
        }
        else {
            System.out.println("MICROGRAM IS NOT Imperial");
        }

        b = mc.isMetric("OUNCE");
        if (b)
        {
            System.out.println("OUNCE IS METRIC");
        }
        else {
            System.out.println("OUNCE IS NOT METRIC");
        }

        b = mc.isImperial("OUNCE");
        if (b)
        {
            System.out.println("OUNCE IS Imperial");
        }
        else {
            System.out.println("OUNCE IS NOT Imperial");
        }

        Boolean c = lc.isMetric("MILLIMETERS");
        if (c)
        {
            System.out.println("MILLIMETERS IS METRIC");
        }
        else {
            System.out.println("MILLIMETERS IS NOT METRIC");
        }

        c = lc.isImperial("MILLIMETERS");
        if (c)
        {
            System.out.println("MILLIMETERS IS Imperial");
        }
        else {
            System.out.println("MILLIMETERS IS NOT Imperial");
        }



        c = lc.isMetric("INCHES");
        if (c)
        {
            System.out.println("INCHES IS METRIC");
        }
        else {
            System.out.println("INCHES IS NOT METRIC");
        }

        c = lc.isImperial("INCHES");
        if (c)
        {
            System.out.println("INCHES IS Imperial");
        }
        else {
            System.out.println("INCHES IS NOT Imperial");
        }

        System.out.println("--------------------------");
        System.out.println("Supported metric lengths");
        System.out.println(lc.SupportedImperialLengths());
        System.out.println("Supported imperial lengths");
        System.out.println(lc.SupportedMetricLengths());

        System.out.println("--------------------------");
        System.out.println("Supported metric mass");
        System.out.println(mc.SupportedImperialMass());
        System.out.println("Supported imperial mass");
        System.out.println(mc.SupportedMetricMass());
*/
        

        // MASS


        //METRIC CASES
/*
        System.out.println(meters + " MILLIGRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.MILLIGRAM.toString(), Mass_Converter.MetricMass.MILLIGRAM.toString()) + " MILLIGRAM.");
        System.out.println(meters + " MILLIGRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.MILLIGRAM.toString(), Mass_Converter.MetricMass.GRAM.toString()) + " GRAM.");
        System.out.println(meters + " MILLIGRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.MILLIGRAM.toString(), Mass_Converter.MetricMass.KILOGRAM.toString()) + " KILOGRAM.");
        System.out.println(meters + " MILLIGRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.MILLIGRAM.toString(), Mass_Converter.MetricMass.TONNE.toString()) + " TONNE.");

        System.out.println(meters + " MILLIGRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.MILLIGRAM.toString(), Mass_Converter.MetricMass.MILLIGRAM.toString()) + " MILLIGRAM.");
        System.out.println(meters + " GRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.GRAM.toString(), Mass_Converter.MetricMass.MILLIGRAM.toString()) + " MILLIGRAM.");
        System.out.println(meters + " KILOGRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.KILOGRAM.toString(), Mass_Converter.MetricMass.MILLIGRAM.toString()) + " MILLIGRAM.");
        System.out.println(meters + " TONNE is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.TONNE.toString(), Mass_Converter.MetricMass.MILLIGRAM.toString()) + " MILLIGRAM.");

        System.out.println(meters + " GRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.GRAM.toString(), Mass_Converter.MetricMass.MILLIGRAM.toString()) + " MILLIGRAM.");
        System.out.println(meters + " GRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.GRAM.toString(), Mass_Converter.MetricMass.GRAM.toString()) + " GRAM.");
        System.out.println(meters + " GRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.GRAM.toString(), Mass_Converter.MetricMass.KILOGRAM.toString()) + " KILOGRAM.");
        System.out.println(meters + " GRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.GRAM.toString(), Mass_Converter.MetricMass.TONNE.toString()) + " TONNE.");

        System.out.println(meters + " MILLIGRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.MILLIGRAM.toString(), Mass_Converter.MetricMass.GRAM.toString()) + " GRAM.");
        System.out.println(meters + " GRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.GRAM.toString(), Mass_Converter.MetricMass.GRAM.toString()) + " GRAM.");
        System.out.println(meters + " KILOGRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.KILOGRAM.toString(), Mass_Converter.MetricMass.GRAM.toString()) + " GRAM.");
        System.out.println(meters + " TONNE is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.TONNE.toString(), Mass_Converter.MetricMass.GRAM.toString()) + " GRAM.");

        System.out.println(meters + " KILOGRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.KILOGRAM.toString(), Mass_Converter.MetricMass.MILLIGRAM.toString()) + " MILLIGRAM.");
        System.out.println(meters + " KILOGRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.KILOGRAM.toString(), Mass_Converter.MetricMass.GRAM.toString()) + " GRAM.");
        System.out.println(meters + " KILOGRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.KILOGRAM.toString(), Mass_Converter.MetricMass.KILOGRAM.toString()) + " KILOGRAM.");
        System.out.println(meters + " KILOGRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.KILOGRAM.toString(), Mass_Converter.MetricMass.TONNE.toString()) + " TONNE.");

        System.out.println(meters + " MILLIGRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.MILLIGRAM.toString(), Mass_Converter.MetricMass.KILOGRAM.toString()) + " KILOGRAM.");
        System.out.println(meters + " GRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.GRAM.toString(), Mass_Converter.MetricMass.KILOGRAM.toString()) + " KILOGRAM.");
        System.out.println(meters + " KILOGRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.KILOGRAM.toString(), Mass_Converter.MetricMass.KILOGRAM.toString()) + " KILOGRAM.");
        System.out.println(meters + " TONNE is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.TONNE.toString(), Mass_Converter.MetricMass.KILOGRAM.toString()) + " KILOGRAM.");

        System.out.println(meters + " TONNE is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.TONNE.toString(), Mass_Converter.MetricMass.MILLIGRAM.toString()) + " MILLIGRAM.");
        System.out.println(meters + " TONNE is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.TONNE.toString(), Mass_Converter.MetricMass.GRAM.toString()) + " GRAM.");
        System.out.println(meters + " TONNE is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.TONNE.toString(), Mass_Converter.MetricMass.KILOGRAM.toString()) + " KILOGRAM.");
        System.out.println(meters + " TONNE is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.TONNE.toString(), Mass_Converter.MetricMass.TONNE.toString()) + " TONNE.");

        System.out.println(meters + " MILLIGRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.MILLIGRAM.toString(), Mass_Converter.MetricMass.TONNE.toString()) + " TONNE.");
        System.out.println(meters + " GRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.GRAM.toString(), Mass_Converter.MetricMass.TONNE.toString()) + " TONNE.");
        System.out.println(meters + " KILOGRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.KILOGRAM.toString(), Mass_Converter.MetricMass.TONNE.toString()) + " TONNE.");
        System.out.println(meters + " TONNE is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.TONNE.toString(), Mass_Converter.MetricMass.TONNE.toString()) + " TONNE.");
          */



        //IMPERIAL CASES
/*
        System.out.println(meters + " OUNCE is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.OUNCE.toString(), Mass_Converter.ImperialMass.OUNCE.toString()) + " OUNCE.");
        System.out.println(meters + " POUND is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.POUND.toString(), Mass_Converter.ImperialMass.OUNCE.toString()) + " OUNCE.");
        System.out.println(meters + " STONE is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.STONE.toString(), Mass_Converter.ImperialMass.OUNCE.toString()) + " OUNCE.");
        System.out.println(meters + " US_TON is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.US_TON.toString(), Mass_Converter.ImperialMass.OUNCE.toString()) + " OUNCE.");

        System.out.println(meters + " OUNCE is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.OUNCE.toString(), Mass_Converter.ImperialMass.OUNCE.toString()) + " OUNCE.");
        System.out.println(meters + " OUNCE is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.OUNCE.toString(), Mass_Converter.ImperialMass.POUND.toString()) + " POUND.");
        System.out.println(meters + " OUNCE is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.OUNCE.toString(), Mass_Converter.ImperialMass.STONE.toString()) + " STONE.");
        System.out.println(meters + " OUNCE is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.OUNCE.toString(), Mass_Converter.ImperialMass.US_TON.toString()) + " US_TON.");

        System.out.println(meters + " OUNCE is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.OUNCE.toString(), Mass_Converter.ImperialMass.POUND.toString()) + " POUND.");
        System.out.println(meters + " POUND is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.POUND.toString(), Mass_Converter.ImperialMass.POUND.toString()) + " POUND.");
        System.out.println(meters + " STONE is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.STONE.toString(), Mass_Converter.ImperialMass.POUND.toString()) + " POUND.");
        System.out.println(meters + " US_TON is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.US_TON.toString(), Mass_Converter.ImperialMass.POUND.toString()) + " POUND.");

        System.out.println(meters + " POUND is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.POUND.toString(), Mass_Converter.ImperialMass.OUNCE.toString()) + " OUNCE.");
        System.out.println(meters + " POUND is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.POUND.toString(), Mass_Converter.ImperialMass.POUND.toString()) + " POUND.");
        System.out.println(meters + " POUND is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.POUND.toString(), Mass_Converter.ImperialMass.STONE.toString()) + " STONE.");
        System.out.println(meters + " POUND is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.POUND.toString(), Mass_Converter.ImperialMass.US_TON.toString()) + " US_TON.");

        System.out.println(meters + " OUNCE is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.OUNCE.toString(), Mass_Converter.ImperialMass.STONE.toString()) + " STONE.");
        System.out.println(meters + " POUND is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.POUND.toString(), Mass_Converter.ImperialMass.STONE.toString()) + " STONE.");
        System.out.println(meters + " STONE is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.STONE.toString(), Mass_Converter.ImperialMass.STONE.toString()) + " STONE.");
        System.out.println(meters + " US_TON is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.US_TON.toString(), Mass_Converter.ImperialMass.STONE.toString()) + " STONE.");

        System.out.println(meters + " STONE is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.STONE.toString(), Mass_Converter.ImperialMass.OUNCE.toString()) + " OUNCE.");
        System.out.println(meters + " STONE is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.STONE.toString(), Mass_Converter.ImperialMass.POUND.toString()) + " POUND.");
        System.out.println(meters + " STONE is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.STONE.toString(), Mass_Converter.ImperialMass.STONE.toString()) + " STONE.");
        System.out.println(meters + " STONE is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.STONE.toString(), Mass_Converter.ImperialMass.US_TON.toString()) + " US_TON.");

        System.out.println(meters + " OUNCE is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.OUNCE.toString(), Mass_Converter.ImperialMass.US_TON.toString()) + " US_TON.");
        System.out.println(meters + " POUND is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.POUND.toString(), Mass_Converter.ImperialMass.US_TON.toString()) + " US_TON.");
        System.out.println(meters + " STONE is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.STONE.toString(), Mass_Converter.ImperialMass.US_TON.toString()) + " US_TON.");
        System.out.println(meters + " US_TON is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.US_TON.toString(), Mass_Converter.ImperialMass.US_TON.toString()) + " US_TON.");

        System.out.println(meters + " US_TON is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.US_TON.toString(), Mass_Converter.ImperialMass.OUNCE.toString()) + " OUNCE.");
        System.out.println(meters + " US_TON is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.US_TON.toString(), Mass_Converter.ImperialMass.POUND.toString()) + " POUND.");
        System.out.println(meters + " US_TON is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.US_TON.toString(), Mass_Converter.ImperialMass.STONE.toString()) + " STONE.");
        System.out.println(meters + " US_TON is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.US_TON.toString(), Mass_Converter.ImperialMass.US_TON.toString()) + " US_TON.");
        */



        //METRIC TO IMPERIAL
/*
        System.out.println(meters + " MILLIGRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.MILLIGRAM.toString(), Mass_Converter.ImperialMass.OUNCE.toString()) + " OUNCE.");
        System.out.println(meters + " MILLIGRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.MILLIGRAM.toString(), Mass_Converter.ImperialMass.POUND.toString()) + " POUND.");
        System.out.println(meters + " MILLIGRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.MILLIGRAM.toString(), Mass_Converter.ImperialMass.STONE.toString()) + " STONE.");
        System.out.println(meters + " MILLIGRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.MILLIGRAM.toString(), Mass_Converter.ImperialMass.US_TON.toString()) + " US_TON.");

        System.out.println(meters + " GRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.GRAM.toString(), Mass_Converter.ImperialMass.OUNCE.toString()) + " OUNCE.");
        System.out.println(meters + " GRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.GRAM.toString(), Mass_Converter.ImperialMass.POUND.toString()) + " POUND.");
        System.out.println(meters + " GRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.GRAM.toString(), Mass_Converter.ImperialMass.STONE.toString()) + " STONE.");
        System.out.println(meters + " GRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.GRAM.toString(), Mass_Converter.ImperialMass.US_TON.toString()) + " US_TON.");

        System.out.println(meters + " KILOGRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.KILOGRAM.toString(), Mass_Converter.ImperialMass.OUNCE.toString()) + " OUNCE.");
        System.out.println(meters + " KILOGRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.KILOGRAM.toString(), Mass_Converter.ImperialMass.POUND.toString()) + " POUND.");
        System.out.println(meters + " KILOGRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.KILOGRAM.toString(), Mass_Converter.ImperialMass.STONE.toString()) + " STONE.");
        System.out.println(meters + " KILOGRAM is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.KILOGRAM.toString(), Mass_Converter.ImperialMass.US_TON.toString()) + " US_TON.");

        System.out.println(meters + " TONNE is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.TONNE.toString(), Mass_Converter.ImperialMass.OUNCE.toString()) + " OUNCE.");
        System.out.println(meters + " TONNE is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.TONNE.toString(), Mass_Converter.ImperialMass.POUND.toString()) + " POUND.");
        System.out.println(meters + " TONNE is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.TONNE.toString(), Mass_Converter.ImperialMass.STONE.toString()) + " STONE.");
        System.out.println(meters + " TONNE is equal to " + mc.Convert(meters.toString(), Mass_Converter.MetricMass.TONNE.toString(), Mass_Converter.ImperialMass.US_TON.toString()) + " US_TON.");
        */



        //IMPERIAL TO METRIC
/*
        System.out.println(meters + " OUNCE is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.OUNCE.toString(), Mass_Converter.MetricMass.MILLIGRAM.toString()) + " MILLIGRAM.");
        System.out.println(meters + " POUND is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.POUND.toString(), Mass_Converter.MetricMass.MILLIGRAM.toString()) + " MILLIGRAM.");
        System.out.println(meters + " STONE is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.STONE.toString(), Mass_Converter.MetricMass.MILLIGRAM.toString()) + " MILLIGRAM.");
        System.out.println(meters + " US_TON is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.US_TON.toString(), Mass_Converter.MetricMass.MILLIGRAM.toString()) + " MILLIGRAM.");

        System.out.println(meters + " OUNCE is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.OUNCE.toString(), Mass_Converter.MetricMass.GRAM.toString()) + " GRAM.");
        System.out.println(meters + " POUND is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.POUND.toString(), Mass_Converter.MetricMass.GRAM.toString()) + " GRAM.");
        System.out.println(meters + " STONE is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.STONE.toString(), Mass_Converter.MetricMass.GRAM.toString()) + " GRAM.");
        System.out.println(meters + " US_TON is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.US_TON.toString(), Mass_Converter.MetricMass.GRAM.toString()) + " GRAM.");

        System.out.println(meters + " OUNCE is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.OUNCE.toString(), Mass_Converter.MetricMass.KILOGRAM.toString()) + " KILOGRAM.");
        System.out.println(meters + " POUND is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.POUND.toString(), Mass_Converter.MetricMass.KILOGRAM.toString()) + " KILOGRAM.");
        System.out.println(meters + " STONE is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.STONE.toString(), Mass_Converter.MetricMass.KILOGRAM.toString()) + " KILOGRAM.");
        System.out.println(meters + " US_TON is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.US_TON.toString(), Mass_Converter.MetricMass.KILOGRAM.toString()) + " KILOGRAM.");

        System.out.println(meters + " OUNCE is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.OUNCE.toString(), Mass_Converter.MetricMass.TONNE.toString()) + " TONNE.");
        System.out.println(meters + " POUND is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.POUND.toString(), Mass_Converter.MetricMass.TONNE.toString()) + " TONNE.");
        System.out.println(meters + " STONE is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.STONE.toString(), Mass_Converter.MetricMass.TONNE.toString()) + " TONNE.");
        System.out.println(meters + " US_TON is equal to " + mc.Convert(meters.toString(), Mass_Converter.ImperialMass.US_TON.toString(), Mass_Converter.MetricMass.TONNE.toString()) + " TONNE.");

        */


        //LENGTH
/*
        //METRIC CASES
        System.out.println(meters + " mm is equal to " + lc.Convert(meters.toString(), Length_Converter.MetricLengths.MILLIMETERS.toString(), Length_Converter.MetricLengths.MILLIMETERS.toString()) + " mm.");
        System.out.println(meters + " mm is equal to " + lc.Convert(meters.toString(), Length_Converter.MetricLengths.MILLIMETERS.toString(), Length_Converter.MetricLengths.CENTIMETERS.toString()) + " cm.");
        System.out.println(meters + " mm is equal to " + lc.Convert(meters.toString(), Length_Converter.MetricLengths.MILLIMETERS.toString(), Length_Converter.MetricLengths.METERS.toString()) + " m.");
        System.out.println(meters + " mm is equal to " + lc.Convert(meters.toString(), Length_Converter.MetricLengths.MILLIMETERS.toString(), Length_Converter.MetricLengths.KILOMETER.toString()) + " km.");

        System.out.println(meters + " mm is equal to " + lc.Convert(meters.toString(), Length_Converter.MetricLengths.MILLIMETERS.toString(), Length_Converter.MetricLengths.MILLIMETERS.toString()) + " mm.");
        System.out.println(meters + " cm is equal to " + lc.Convert(meters.toString(), Length_Converter.MetricLengths.CENTIMETERS.toString(), Length_Converter.MetricLengths.MILLIMETERS.toString()) + " mm.");
        System.out.println(meters + " m is equal to " + lc.Convert(meters.toString(), Length_Converter.MetricLengths.METERS.toString(), Length_Converter.MetricLengths.MILLIMETERS.toString()) + " mm.");
        System.out.println(meters + " km is equal to " + lc.Convert(meters.toString(), Length_Converter.MetricLengths.KILOMETER.toString(), Length_Converter.MetricLengths.MILLIMETERS.toString()) + " mm.");
  */
        //IMPERIAL CASES
/*
        System.out.println(meters + " INCHES is equal to " + lc.Convert(meters.toString(), Length_Converter.ImperialLengths.INCHES.toString(), Length_Converter.ImperialLengths.INCHES.toString()) + " inches.");
        System.out.println(meters + " INCHES is equal to " + lc.Convert(meters.toString(), Length_Converter.ImperialLengths.INCHES.toString(), Length_Converter.ImperialLengths.HANDS.toString()) + " hands.");
        System.out.println(meters + " INCHES is equal to " + lc.Convert(meters.toString(), Length_Converter.ImperialLengths.INCHES.toString(), Length_Converter.ImperialLengths.FEET.toString()) + " feet.");
        System.out.println(meters + " INCHES is equal to " + lc.Convert(meters.toString(), Length_Converter.ImperialLengths.INCHES.toString(), Length_Converter.ImperialLengths.YARDS.toString()) + " yards.");
        System.out.println(meters + " INCHES is equal to " + lc.Convert(meters.toString(), Length_Converter.ImperialLengths.INCHES.toString(), Length_Converter.ImperialLengths.MILES.toString()) + " miles.");

        System.out.println(meters + " inches is equal to " +     lc.Convert(meters.toString(), Length_Converter.ImperialLengths.INCHES.toString(), Length_Converter.ImperialLengths.INCHES.toString()) + " INCHES.");
        System.out.println(meters + " hands is equal to " +      lc.Convert(meters.toString(), Length_Converter.ImperialLengths.HANDS.toString(), Length_Converter.ImperialLengths.INCHES.toString()) + " INCHES.");
        System.out.println(meters + " feet is equal to " +       lc.Convert(meters.toString(), Length_Converter.ImperialLengths.FEET.toString(), Length_Converter.ImperialLengths.INCHES.toString()) + " INCHES.");
        System.out.println(meters + " yards is equal to " +      lc.Convert(meters.toString(), Length_Converter.ImperialLengths.YARDS.toString(), Length_Converter.ImperialLengths.INCHES.toString()) + " INCHES.");
        System.out.println(meters + " miles is equal to " +      lc.Convert(meters.toString(), Length_Converter.ImperialLengths.MILES.toString(), Length_Converter.ImperialLengths.INCHES.toString()) + " INCHES.");

        System.out.println(meters + " HANDS is equal to " + lc.Convert(meters.toString(), Length_Converter.ImperialLengths.HANDS.toString(), Length_Converter.ImperialLengths.INCHES.toString()) + " inches.");
        System.out.println(meters + " HANDS is equal to " + lc.Convert(meters.toString(), Length_Converter.ImperialLengths.HANDS.toString(), Length_Converter.ImperialLengths.HANDS.toString()) + " hands.");
        System.out.println(meters + " HANDS is equal to " + lc.Convert(meters.toString(), Length_Converter.ImperialLengths.HANDS.toString(), Length_Converter.ImperialLengths.FEET.toString()) + " feet.");
        System.out.println(meters + " HANDS is equal to " + lc.Convert(meters.toString(), Length_Converter.ImperialLengths.HANDS.toString(), Length_Converter.ImperialLengths.YARDS.toString()) + " yards.");
        System.out.println(meters + " HANDS is equal to " + lc.Convert(meters.toString(), Length_Converter.ImperialLengths.HANDS.toString(), Length_Converter.ImperialLengths.MILES.toString()) + " miles.");

        System.out.println(meters + " inches is equal to " +     lc.Convert(meters.toString(), Length_Converter.ImperialLengths.INCHES.toString(), Length_Converter.ImperialLengths.HANDS.toString()) + " HANDS.");
        System.out.println(meters + " hands is equal to " +      lc.Convert(meters.toString(), Length_Converter.ImperialLengths.HANDS.toString(), Length_Converter.ImperialLengths.HANDS.toString()) + " HANDS.");
        System.out.println(meters + " feet is equal to " +       lc.Convert(meters.toString(), Length_Converter.ImperialLengths.FEET.toString(), Length_Converter.ImperialLengths.HANDS.toString()) + " HANDS.");
        System.out.println(meters + " yards is equal to " +      lc.Convert(meters.toString(), Length_Converter.ImperialLengths.YARDS.toString(), Length_Converter.ImperialLengths.HANDS.toString()) + " HANDS.");
        System.out.println(meters + " miles is equal to " +      lc.Convert(meters.toString(), Length_Converter.ImperialLengths.MILES.toString(), Length_Converter.ImperialLengths.HANDS.toString()) + " HANDS.");

        System.out.println(meters + " FEET is equal to " + lc.Convert(meters.toString(), Length_Converter.ImperialLengths.FEET.toString(), Length_Converter.ImperialLengths.INCHES.toString()) + " inches.");
        System.out.println(meters + " FEET is equal to " + lc.Convert(meters.toString(), Length_Converter.ImperialLengths.FEET.toString(), Length_Converter.ImperialLengths.HANDS.toString()) + " hands.");
        System.out.println(meters + " FEET is equal to " + lc.Convert(meters.toString(), Length_Converter.ImperialLengths.FEET.toString(), Length_Converter.ImperialLengths.FEET.toString()) + " feet.");
        System.out.println(meters + " FEET is equal to " + lc.Convert(meters.toString(), Length_Converter.ImperialLengths.FEET.toString(), Length_Converter.ImperialLengths.YARDS.toString()) + " yards.");
        System.out.println(meters + " FEET is equal to " + lc.Convert(meters.toString(), Length_Converter.ImperialLengths.FEET.toString(), Length_Converter.ImperialLengths.MILES.toString()) + " miles.");

        System.out.println(meters + " inches is equal to " +     lc.Convert(meters.toString(), Length_Converter.ImperialLengths.INCHES.toString(), Length_Converter.ImperialLengths.FEET.toString()) + " FEET.");
        System.out.println(meters + " hands is equal to " +      lc.Convert(meters.toString(), Length_Converter.ImperialLengths.HANDS.toString(), Length_Converter.ImperialLengths.FEET.toString()) + " FEET.");
        System.out.println(meters + " feet is equal to " +       lc.Convert(meters.toString(), Length_Converter.ImperialLengths.FEET.toString(), Length_Converter.ImperialLengths.FEET.toString()) + " FEET.");
        System.out.println(meters + " yards is equal to " +      lc.Convert(meters.toString(), Length_Converter.ImperialLengths.YARDS.toString(), Length_Converter.ImperialLengths.FEET.toString()) + " FEET.");
        System.out.println(meters + " miles is equal to " +      lc.Convert(meters.toString(), Length_Converter.ImperialLengths.MILES.toString(), Length_Converter.ImperialLengths.FEET.toString()) + " FEET.");

        System.out.println(meters + " YARDS is equal to " + lc.Convert(meters.toString(), Length_Converter.ImperialLengths.YARDS.toString(), Length_Converter.ImperialLengths.INCHES.toString()) + " inches.");
        System.out.println(meters + " YARDS is equal to " + lc.Convert(meters.toString(), Length_Converter.ImperialLengths.YARDS.toString(), Length_Converter.ImperialLengths.HANDS.toString()) + " hands.");
        System.out.println(meters + " YARDS is equal to " + lc.Convert(meters.toString(), Length_Converter.ImperialLengths.YARDS.toString(), Length_Converter.ImperialLengths.FEET.toString()) + " feet.");
        System.out.println(meters + " YARDS is equal to " + lc.Convert(meters.toString(), Length_Converter.ImperialLengths.YARDS.toString(), Length_Converter.ImperialLengths.YARDS.toString()) + " yards.");
        System.out.println(meters + " YARDS is equal to " + lc.Convert(meters.toString(), Length_Converter.ImperialLengths.YARDS.toString(), Length_Converter.ImperialLengths.MILES.toString()) + " miles.");

        System.out.println(meters + " inches is equal to " +     lc.Convert(meters.toString(), Length_Converter.ImperialLengths.INCHES.toString(), Length_Converter.ImperialLengths.YARDS.toString()) + " YARDS.");
        System.out.println(meters + " hands is equal to " +      lc.Convert(meters.toString(), Length_Converter.ImperialLengths.HANDS.toString(), Length_Converter.ImperialLengths.YARDS.toString()) + " YARDS.");
        System.out.println(meters + " feet is equal to " +       lc.Convert(meters.toString(), Length_Converter.ImperialLengths.FEET.toString(), Length_Converter.ImperialLengths.YARDS.toString()) + " YARDS.");
        System.out.println(meters + " yards is equal to " +      lc.Convert(meters.toString(), Length_Converter.ImperialLengths.YARDS.toString(), Length_Converter.ImperialLengths.YARDS.toString()) + " YARDS.");
        System.out.println(meters + " miles is equal to " +      lc.Convert(meters.toString(), Length_Converter.ImperialLengths.MILES.toString(), Length_Converter.ImperialLengths.YARDS.toString()) + " YARDS.");

        System.out.println(meters + " MILES is equal to " + lc.Convert(meters.toString(), Length_Converter.ImperialLengths.MILES.toString(), Length_Converter.ImperialLengths.INCHES.toString()) + " inches.");
        System.out.println(meters + " MILES is equal to " + lc.Convert(meters.toString(), Length_Converter.ImperialLengths.MILES.toString(), Length_Converter.ImperialLengths.HANDS.toString()) + " hands.");
        System.out.println(meters + " MILES is equal to " + lc.Convert(meters.toString(), Length_Converter.ImperialLengths.MILES.toString(), Length_Converter.ImperialLengths.FEET.toString()) + " feet.");
        System.out.println(meters + " MILES is equal to " + lc.Convert(meters.toString(), Length_Converter.ImperialLengths.MILES.toString(), Length_Converter.ImperialLengths.YARDS.toString()) + " yards.");
        System.out.println(meters + " MILES is equal to " + lc.Convert(meters.toString(), Length_Converter.ImperialLengths.MILES.toString(), Length_Converter.ImperialLengths.MILES.toString()) + " miles.");

        System.out.println(meters + " inches is equal to " +     lc.Convert(meters.toString(), Length_Converter.ImperialLengths.INCHES.toString(), Length_Converter.ImperialLengths.MILES.toString()) + " MILES.");
        System.out.println(meters + " hands is equal to " +      lc.Convert(meters.toString(), Length_Converter.ImperialLengths.HANDS.toString(), Length_Converter.ImperialLengths.MILES.toString()) + " MILES.");
        System.out.println(meters + " feet is equal to " +       lc.Convert(meters.toString(), Length_Converter.ImperialLengths.FEET.toString(), Length_Converter.ImperialLengths.MILES.toString()) + " MILES.");
        System.out.println(meters + " yards is equal to " +      lc.Convert(meters.toString(), Length_Converter.ImperialLengths.YARDS.toString(), Length_Converter.ImperialLengths.MILES.toString()) + " MILES.");
        System.out.println(meters + " miles is equal to " +      lc.Convert(meters.toString(), Length_Converter.ImperialLengths.MILES.toString(), Length_Converter.ImperialLengths.MILES.toString()) + " MILES.");

   */

/*
        //METRIC TO IMPERIAL

        System.out.println(meters + " INCHES is equal to " + lc.Convert(meters.toString(),Length_Converter.MetricLengths.MILLIMETERS.toString() , Length_Converter.ImperialLengths.INCHES.toString()) + " mm.");
        System.out.println(meters + " INCHES is equal to " + lc.Convert(meters.toString(),Length_Converter.MetricLengths.CENTIMETERS.toString(), Length_Converter.ImperialLengths.INCHES.toString() ) + " cm.");
        System.out.println(meters + " INCHES is equal to " + lc.Convert(meters.toString(),Length_Converter.MetricLengths.METERS.toString(), Length_Converter.ImperialLengths.INCHES.toString() ) + " m.");
        System.out.println(meters + " INCHES is equal to " + lc.Convert(meters.toString(),Length_Converter.MetricLengths.KILOMETER.toString(), Length_Converter.ImperialLengths.INCHES.toString() ) + " km.");

        System.out.println(meters + " HANDS is equal to " + lc.Convert(meters.toString(),Length_Converter.MetricLengths.MILLIMETERS.toString() , Length_Converter.ImperialLengths.HANDS.toString()) + " mm.");
        System.out.println(meters + " HANDS is equal to " + lc.Convert(meters.toString(),Length_Converter.MetricLengths.CENTIMETERS.toString(), Length_Converter.ImperialLengths.HANDS.toString() ) + " cm.");
        System.out.println(meters + " HANDS is equal to " + lc.Convert(meters.toString(),Length_Converter.MetricLengths.METERS.toString(), Length_Converter.ImperialLengths.HANDS.toString() ) + " m.");
        System.out.println(meters + " HANDS is equal to " + lc.Convert(meters.toString(),Length_Converter.MetricLengths.KILOMETER.toString(), Length_Converter.ImperialLengths.HANDS.toString() ) + " km.");

        System.out.println(meters + " FEET is equal to " + lc.Convert(meters.toString(),Length_Converter.MetricLengths.MILLIMETERS.toString() , Length_Converter.ImperialLengths.FEET.toString()) + " mm.");
        System.out.println(meters + " FEET is equal to " + lc.Convert(meters.toString(),Length_Converter.MetricLengths.CENTIMETERS.toString(), Length_Converter.ImperialLengths.FEET.toString() ) + " cm.");
        System.out.println(meters + " FEET is equal to " + lc.Convert(meters.toString(),Length_Converter.MetricLengths.METERS.toString(), Length_Converter.ImperialLengths.FEET.toString() ) + " m.");
        System.out.println(meters + " FEET is equal to " + lc.Convert(meters.toString(),Length_Converter.MetricLengths.KILOMETER.toString(), Length_Converter.ImperialLengths.FEET.toString() ) + " km.");

        System.out.println(meters + " YARDS is equal to " + lc.Convert(meters.toString(),Length_Converter.MetricLengths.MILLIMETERS.toString() , Length_Converter.ImperialLengths.YARDS.toString()) + " mm.");
        System.out.println(meters + " YARDS is equal to " + lc.Convert(meters.toString(),Length_Converter.MetricLengths.CENTIMETERS.toString(), Length_Converter.ImperialLengths.YARDS.toString() ) + " cm.");
        System.out.println(meters + " YARDS is equal to " + lc.Convert(meters.toString(),Length_Converter.MetricLengths.METERS.toString(), Length_Converter.ImperialLengths.YARDS.toString() ) + " m.");
        System.out.println(meters + " YARDS is equal to " + lc.Convert(meters.toString(),Length_Converter.MetricLengths.KILOMETER.toString(), Length_Converter.ImperialLengths.YARDS.toString() ) + " km.");

        System.out.println(meters + " MILES is equal to " + lc.Convert(meters.toString(),Length_Converter.MetricLengths.MILLIMETERS.toString() , Length_Converter.ImperialLengths.MILES.toString()) + " mm.");
        System.out.println(meters + " MILES is equal to " + lc.Convert(meters.toString(),Length_Converter.MetricLengths.CENTIMETERS.toString(), Length_Converter.ImperialLengths.MILES.toString() ) + " cm.");
        System.out.println(meters + " MILES is equal to " + lc.Convert(meters.toString(),Length_Converter.MetricLengths.METERS.toString(), Length_Converter.ImperialLengths.MILES.toString() ) + " m.");
        System.out.println(meters + " MILES is equal to " + lc.Convert(meters.toString(),Length_Converter.MetricLengths.KILOMETER.toString(), Length_Converter.ImperialLengths.MILES.toString() ) + " km.");
 */



 

        //IMPERIAL TO METRIC
/*
        System.out.println(meters + " mm is equal to " +       lc.Convert(meters.toString(), Length_Converter.ImperialLengths.INCHES.toString(), Length_Converter.MetricLengths.MILLIMETERS.toString()) + " INCHES.");
        System.out.println(meters + " cm is equal to " +       lc.Convert(meters.toString(), Length_Converter.ImperialLengths.INCHES.toString(), Length_Converter.MetricLengths.CENTIMETERS.toString()) + " INCHES.");
        System.out.println(meters + " m is equal to " +       lc.Convert(meters.toString(), Length_Converter.ImperialLengths.INCHES.toString(), Length_Converter.MetricLengths.METERS.toString()) + " INCHES.");
        System.out.println(meters + " km is equal to " +       lc.Convert(meters.toString(), Length_Converter.ImperialLengths.INCHES.toString(), Length_Converter.MetricLengths.KILOMETER.toString()) + " INCHES.");

        System.out.println(meters + " mm is equal to " +       lc.Convert(meters.toString(), Length_Converter.ImperialLengths.HANDS.toString(), Length_Converter.MetricLengths.MILLIMETERS.toString()) + " .HANDS.");
        System.out.println(meters + " cm is equal to " +       lc.Convert(meters.toString(), Length_Converter.ImperialLengths.HANDS.toString(), Length_Converter.MetricLengths.CENTIMETERS.toString()) + " .HANDS.");
        System.out.println(meters + " m is equal to " +       lc.Convert(meters.toString(), Length_Converter.ImperialLengths.HANDS.toString(), Length_Converter.MetricLengths.METERS.toString()) + " .HANDS.");
        System.out.println(meters + " km is equal to " +       lc.Convert(meters.toString(), Length_Converter.ImperialLengths.HANDS.toString(), Length_Converter.MetricLengths.KILOMETER.toString()) + " .HANDS.");

        System.out.println(meters + " mm is equal to " +       lc.Convert(meters.toString(), Length_Converter.ImperialLengths.FEET.toString(), Length_Converter.MetricLengths.MILLIMETERS.toString()) + " .FEET.");
        System.out.println(meters + " cm is equal to " +       lc.Convert(meters.toString(), Length_Converter.ImperialLengths.FEET.toString(), Length_Converter.MetricLengths.CENTIMETERS.toString()) + " .FEET.");
        System.out.println(meters + " m is equal to " +       lc.Convert(meters.toString(), Length_Converter.ImperialLengths.FEET.toString(), Length_Converter.MetricLengths.METERS.toString()) + " .FEET.");
        System.out.println(meters + " km is equal to " +       lc.Convert(meters.toString(), Length_Converter.ImperialLengths.FEET.toString(), Length_Converter.MetricLengths.KILOMETER.toString()) + " .FEET.");

        System.out.println(meters + " mm is equal to " +       lc.Convert(meters.toString(), Length_Converter.ImperialLengths.YARDS.toString(), Length_Converter.MetricLengths.MILLIMETERS.toString()) + " .YARDS.");
        System.out.println(meters + " cm is equal to " +       lc.Convert(meters.toString(), Length_Converter.ImperialLengths.YARDS.toString(), Length_Converter.MetricLengths.CENTIMETERS.toString()) + " .YARDS.");
        System.out.println(meters + " m is equal to " +       lc.Convert(meters.toString(), Length_Converter.ImperialLengths.YARDS.toString(), Length_Converter.MetricLengths.METERS.toString()) + " .YARDS.");
        System.out.println(meters + " km is equal to " +       lc.Convert(meters.toString(), Length_Converter.ImperialLengths.YARDS.toString(), Length_Converter.MetricLengths.KILOMETER.toString()) + " .YARDS.");

        System.out.println(meters + " mm is equal to " +       lc.Convert(meters.toString(), Length_Converter.ImperialLengths.MILES.toString(), Length_Converter.MetricLengths.MILLIMETERS.toString()) + " .MILES.");
        System.out.println(meters + " cm is equal to " +       lc.Convert(meters.toString(), Length_Converter.ImperialLengths.MILES.toString(), Length_Converter.MetricLengths.CENTIMETERS.toString()) + " .MILES.");
        System.out.println(meters + " m is equal to " +       lc.Convert(meters.toString(), Length_Converter.ImperialLengths.MILES.toString(), Length_Converter.MetricLengths.METERS.toString()) + " .MILES.");
        System.out.println(meters + " km is equal to " +       lc.Convert(meters.toString(), Length_Converter.ImperialLengths.MILES.toString(), Length_Converter.MetricLengths.KILOMETER.toString()) + " .MILES.");
   */



    }
}
