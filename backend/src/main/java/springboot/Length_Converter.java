package springboot;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Length_Converter extends ConversionBase<Length_Converter.MetricLengths,Length_Converter.ImperialLengths>  {

    @Override
    public boolean isMetric(String str) {
        return super.isMetric(Arrays.asList(Length_Converter.MetricLengths.values()), str);
    }

    public enum MetricLengths implements MeasurementInterface {
        MILLIMETERS(0,new BigDecimal(1)),
        CENTIMETERS(1,new BigDecimal(10)),
        METERS(2,new BigDecimal(100)),
        KILOMETER(3,new BigDecimal(1000));

        private int factorLocation;
        private BigDecimal Factor;

        MetricLengths(int factorLocationParam,BigDecimal prevFactorParam)
        {
            this.factorLocation = factorLocationParam;
            this.Factor = prevFactorParam;
        }

        public int getFactorLocation() {
            return factorLocation;
        }

        public BigDecimal getFactor() {
            return Factor;
        }
    }

    @Override
    public boolean isImperial(String str) {
        return super.isImperial(Arrays.asList(Length_Converter.ImperialLengths.values()), str);
    }

    public enum ImperialLengths implements MeasurementInterface{
        INCHES(0,new BigDecimal(1)),
        HANDS(1,new BigDecimal(4)),
        FEET(2,new BigDecimal(3)),
        YARDS(3,new BigDecimal(3)),
        MILES(4,new BigDecimal(1760));

        private int factorLocation;
        private BigDecimal Factor;

        ImperialLengths(int factorLocationParam,BigDecimal prevFactorParam)
        {
            this.factorLocation = factorLocationParam;
            this.Factor = prevFactorParam;
        }

        public int getFactorLocation() {
            return factorLocation;
        }

        public BigDecimal getFactor() {
            return Factor;
        }
    }

    public List<String> SupportedImperialLengths()
    {
        return super.SupportedImperial(Arrays.asList(Length_Converter.ImperialLengths.values()));
    }

    public List<String> SupportedMetricLengths()
    {
        return super.SupportedMetric(Arrays.asList(Length_Converter.MetricLengths.values()));
    }

    public static enum ImperialToMetricFactors{

        INCHES_TO_MILLIMETER(new BigDecimal("25.4")),
        INCHES_TO_CENTIMETER(new BigDecimal("2.54")),
        INCHES_TO_METER(new BigDecimal("0.0254")),
        INCHES_TO_KILOMETER(new BigDecimal("0.0000254")),

        HANDS_TO_MILLIMETER(new BigDecimal("101.6")),
        HANDS_TO_CENTIMETER(new BigDecimal("10.16")),
        HANDS_TO_METER(new BigDecimal("0.1016")),
        HANDS_TO_KILOMETER(new BigDecimal("0.0001016")),

        FEET_TO_MILLIMETER(new BigDecimal("304.8")),
        FEET_TO_CENTIMETER(new BigDecimal("30.48")),
        FEET_TO_METER(new BigDecimal("0.3048")),
        FEET_TO_KILOMETER(new BigDecimal("0.0003048")),

        YARDS_TO_MILLIMETER(new BigDecimal("914.4")),
        YARDS_TO_CENTIMETER(new BigDecimal("91.44")),
        YARDS_TO_METER(new BigDecimal("0.9144")),
        YARDS_TO_KILOMETER(new BigDecimal("0.0009144")),

        MILES_TO_MILLIMETER(new BigDecimal("1609340")),
        MILES_TO_CENTIMETER(new BigDecimal("160934")),
        MILES_TO_METER(new BigDecimal("1609.34")),
        MILES_TO_KILOMETER(new BigDecimal("1.60934"));

        public BigDecimal Factor;

        ImperialToMetricFactors(BigDecimal conversionFactorParam)
        {
            this.Factor = conversionFactorParam;
        }
    }

    public static enum MetricToImperialFactors{

        MILLIMETER_TO_INCHES(new BigDecimal("25.4000508")),
        MILLIMETER_TO_HANDS(new BigDecimal("101.6")),
        MILLIMETER_TO_FEET(new BigDecimal("304.8")),
        MILLIMETER_TO_YARDS(new BigDecimal("914.4")),
        MILLIMETER_TO_MILES(new BigDecimal("1609347.2187")),

        CENTIMETER_TO_INCHES(new BigDecimal("2.54")),
        CENTIMETER_TO_HANDS(new BigDecimal("10.16")),
        CENTIMETER_TO_FEET(new BigDecimal("30.48")),
        CENTIMETER_TO_YARDS(new BigDecimal("91.44")),
        CENTIMETER_TO_MILES(new BigDecimal("160934.72187")),

        METER_TO_INCHES(new BigDecimal("0.0254")),
        METER_TO_HANDS(new BigDecimal("0.1016")),
        METER_TO_FEET(new BigDecimal("0.3048")),
        METER_TO_YARDS(new BigDecimal("0.9144")),
        METER_TO_MILES(new BigDecimal("1609.344")),

        KILOMETER_TO_INCHES(new BigDecimal("0.0000254")),
        KILOMETER_TO_HANDS(new BigDecimal("0.0001016")),
        KILOMETER_TO_FEET(new BigDecimal("0.0003048")),
        KILOMETER_TO_YARDS(new BigDecimal("0.0009144")),
        KILOMETER_TO_MILES(new BigDecimal("1.609344"));

        public BigDecimal Factor;

        MetricToImperialFactors(BigDecimal conversionFactorParam)
        {
            this.Factor = conversionFactorParam;
        }
    }

    private static ImperialLengths getImperialLengthsFromString(String str) {
        try {
            return ImperialLengths.valueOf(str);
        } catch (IllegalArgumentException e) {
            // handle the case where the string is not a valid enum value
            return null;
        }
    }

    private static MetricLengths getMetricLengthsFromString(String str) {
        try {
            return MetricLengths.valueOf(str);
        } catch (IllegalArgumentException e) {
            // handle the case where the string is not a valid enum value
            return null;
        }
    }

    public String Convert(String numTemp, String typeConvFrom, String typeConvTo)
    {
        String toReturn = "";
        BigDecimal bd = new BigDecimal(numTemp);
        if(isMetric(typeConvFrom) && isMetric(typeConvTo)  ) {
            //full metric
            toReturn = MainConvert(bd, getMetricLengthsFromString(typeConvFrom), getMetricLengthsFromString(typeConvTo), Length_Converter.MetricLengths.values()).toString();
        }
        else if(isImperial(typeConvFrom) && isImperial(typeConvTo)) {
            //full imperial
            toReturn = MainConvert(bd, getImperialLengthsFromString(typeConvFrom), getImperialLengthsFromString(typeConvTo), Length_Converter.ImperialLengths.values()).toString();
        }
        else if(isMetric(typeConvFrom) && isImperial(typeConvTo)) {
            //metric to imperial
            toReturn = ConvertMetricToImperial(bd, getMetricLengthsFromString(typeConvFrom), getImperialLengthsFromString(typeConvTo)).toString();
        }
        else if(isImperial(typeConvFrom) && isMetric(typeConvTo)) {
            //imperial to metric
            toReturn = ConvertImperialToMetric(bd, getImperialLengthsFromString(typeConvFrom), getMetricLengthsFromString(typeConvTo)).toString();
        }

        return toReturn;
    }

    private static BigDecimal ConvertMetricToImperial(BigDecimal length, MetricLengths fromUnit, ImperialLengths toUnit)
    {
        BigDecimal result = new BigDecimal("0.00");

        switch(fromUnit)
        {
            case MILLIMETERS:
                switch(toUnit)
                {
                    case INCHES:
                        result = length.multiply( MetricToImperialFactors.MILLIMETER_TO_INCHES.Factor);
                        break;
                    case HANDS:
                        result = length.multiply( MetricToImperialFactors.MILLIMETER_TO_HANDS.Factor);
                        break;
                    case FEET:
                        result = length.multiply( MetricToImperialFactors.MILLIMETER_TO_FEET.Factor);
                        break;
                    case YARDS:
                        result = length.multiply( MetricToImperialFactors.MILLIMETER_TO_YARDS.Factor);
                        break;
                    case MILES:
                        result = length.multiply( MetricToImperialFactors.MILLIMETER_TO_MILES.Factor);
                        break;
                }
                break;
            case CENTIMETERS:
                switch(toUnit)
                {
                    case INCHES:
                        result = length.multiply( MetricToImperialFactors.CENTIMETER_TO_INCHES.Factor);
                        break;
                    case HANDS:
                        result = length.multiply( MetricToImperialFactors.CENTIMETER_TO_HANDS.Factor);
                        break;
                    case FEET:
                        result = length.multiply( MetricToImperialFactors.CENTIMETER_TO_FEET.Factor);
                        break;
                    case YARDS:
                        result = length.multiply( MetricToImperialFactors.CENTIMETER_TO_YARDS.Factor);
                        break;
                    case MILES:
                        result = length.multiply( MetricToImperialFactors.CENTIMETER_TO_MILES.Factor);
                        break;
                }
                break;
            case METERS:
                switch(toUnit)
                {
                    case INCHES:
                        result = length.multiply( MetricToImperialFactors.METER_TO_INCHES.Factor);
                        break;
                    case HANDS:
                        result = length.multiply( MetricToImperialFactors.METER_TO_HANDS.Factor);
                        break;
                    case FEET:
                        result = length.multiply( MetricToImperialFactors.METER_TO_FEET.Factor);
                        break;
                    case YARDS:
                        result = length.multiply( MetricToImperialFactors.METER_TO_YARDS.Factor);
                        break;
                    case MILES:
                        result = length.multiply( MetricToImperialFactors.METER_TO_MILES.Factor);
                        break;
                }
                break;
            case KILOMETER:
                switch(toUnit)
                {
                    case INCHES:
                        result = length.multiply( MetricToImperialFactors.KILOMETER_TO_INCHES.Factor);
                        break;
                    case HANDS:
                        result = length.multiply( MetricToImperialFactors.KILOMETER_TO_HANDS.Factor);
                        break;
                    case FEET:
                        result = length.multiply( MetricToImperialFactors.KILOMETER_TO_FEET.Factor);
                        break;
                    case YARDS:
                        result = length.multiply( MetricToImperialFactors.KILOMETER_TO_YARDS.Factor);
                        break;
                    case MILES:
                        result = length.multiply( MetricToImperialFactors.KILOMETER_TO_MILES.Factor);
                        break;
                }
                break;
        }

        return result;
    }


    private static BigDecimal ConvertImperialToMetric(BigDecimal length, ImperialLengths fromUnit, MetricLengths toUnit)
    {
        BigDecimal result = new BigDecimal("0.00");

        switch(fromUnit)
        {
            case INCHES:
                switch(toUnit)
                {
                    case MILLIMETERS:
                        result = length.multiply( ImperialToMetricFactors.INCHES_TO_MILLIMETER.Factor);
                        break;
                    case CENTIMETERS:
                        result = length.multiply( ImperialToMetricFactors.INCHES_TO_CENTIMETER.Factor);
                        break;
                    case METERS:
                        result = length.multiply( ImperialToMetricFactors.INCHES_TO_METER.Factor);
                        break;
                    case KILOMETER:
                        result = length.multiply( ImperialToMetricFactors.INCHES_TO_KILOMETER.Factor);
                        break;
                }
                break;
            case HANDS:
                switch(toUnit)
                {
                    case MILLIMETERS:
                        result = length.multiply( ImperialToMetricFactors.HANDS_TO_MILLIMETER.Factor);
                        break;
                    case CENTIMETERS:
                        result = length.multiply( ImperialToMetricFactors.HANDS_TO_CENTIMETER.Factor);
                        break;
                    case METERS:
                        result = length.multiply( ImperialToMetricFactors.HANDS_TO_METER.Factor);
                        break;
                    case KILOMETER:
                        result = length.multiply( ImperialToMetricFactors.HANDS_TO_KILOMETER.Factor);
                        break;
                }
                break;
            case FEET:
                switch(toUnit)
                {
                    case MILLIMETERS:
                        result = length.multiply( ImperialToMetricFactors.FEET_TO_MILLIMETER.Factor);
                        break;
                    case CENTIMETERS:
                        result = length.multiply( ImperialToMetricFactors.FEET_TO_CENTIMETER.Factor);
                        break;
                    case METERS:
                        result = length.multiply( ImperialToMetricFactors.FEET_TO_METER.Factor);
                        break;
                    case KILOMETER:
                        result = length.multiply( ImperialToMetricFactors.FEET_TO_KILOMETER.Factor);
                        break;
                }
                break;
            case YARDS:
                switch(toUnit)
                {
                    case MILLIMETERS:
                        result = length.multiply( ImperialToMetricFactors.YARDS_TO_MILLIMETER.Factor);
                        break;
                    case CENTIMETERS:
                        result = length.multiply( ImperialToMetricFactors.YARDS_TO_CENTIMETER.Factor);
                        break;
                    case METERS:
                        result = length.multiply( ImperialToMetricFactors.YARDS_TO_METER.Factor);
                        break;
                    case KILOMETER:
                        result = length.multiply( ImperialToMetricFactors.YARDS_TO_KILOMETER.Factor);
                        break;
                }
                break;
            case MILES:
                switch(toUnit)
                {
                    case MILLIMETERS:
                        result = length.multiply( ImperialToMetricFactors.MILES_TO_MILLIMETER.Factor);
                        break;
                    case CENTIMETERS:
                        result = length.multiply( ImperialToMetricFactors.MILES_TO_CENTIMETER.Factor);
                        break;
                    case METERS:
                        result = length.multiply( ImperialToMetricFactors.MILES_TO_METER.Factor);
                        break;
                    case KILOMETER:
                        result = length.multiply( ImperialToMetricFactors.MILES_TO_KILOMETER.Factor);
                        break;
                }
                break;
        }

        return result;
    }


    public static void main(String[] args) {

    }

}