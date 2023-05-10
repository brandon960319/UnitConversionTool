package springboot;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Mass_Converter extends ConversionBase<Mass_Converter.MetricMass, Mass_Converter.ImperialMass> {

    @Override
    public boolean isMetric(String str) {
        return super.isMetric(Arrays.asList(MetricMass.values()),str);
    }

    public enum MetricMass implements MeasurementInterface {
        MILLIGRAM(0,new BigDecimal("1")),
        GRAM(1,new BigDecimal("1000")),
        KILOGRAM(2,new BigDecimal("1000")),
        TONNE(3,new BigDecimal("1000"));

        private int factorLocation;
        private BigDecimal Factor;

        MetricMass(int factorLocationParam,BigDecimal prevFactorParam)
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
        return super.isImperial(Arrays.asList(ImperialMass.values()),str);
    }

    public enum ImperialMass implements MeasurementInterface {
        OUNCE (0,new BigDecimal("1")),
        POUND(1,new BigDecimal("16")),
        STONE(2,new BigDecimal("14")),
        US_TON(4,new BigDecimal("142.857"));

        private int factorLocation;
        private BigDecimal Factor;

        ImperialMass(int factorLocationParam,BigDecimal prevFactorParam)
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

    public List<String> SupportedImperialMass()
    {
        return super.SupportedImperial(Arrays.asList(Mass_Converter.ImperialMass.values()));
    }

    public List<String> SupportedMetricMass()
    {
        return super.SupportedMetric(Arrays.asList(Mass_Converter.MetricMass.values()));
    }

    public static enum MetricToImperialFactors{
        MILLIGRAM_TO_OUNCE (new BigDecimal("0.00003527396194")),
        MILLIGRAM_TO_POUND (new BigDecimal("0.000002204622621")),
        MILLIGRAM_TO_STONE (new BigDecimal("0.0000001574730444")),
        MILLIGRAM_TO_US_TON (new BigDecimal("0.00000000110231")),

        GRAM_TO_OUNCE (new BigDecimal("0.035274")),
        GRAM_TO_POUND (new BigDecimal("0.00220462")),
        GRAM_TO_STONE (new BigDecimal("0.000157473")),
        GRAM_TO_US_TON (new BigDecimal("0.00000110231")),

        KILOGRAM_TO_OUNCE (new BigDecimal("35.274")),
        KILOGRAM_TO_POUND (new BigDecimal("2.20462")),
        KILOGRAM_TO_STONE (new BigDecimal("0.157473")),
        KILOGRAM_TO_US_TON (new BigDecimal("0.00110231")),

        TONNE_TO_OUNCE (new BigDecimal("35274")),
        TONNE_TO_POUND (new BigDecimal("2204.62")),
        TONNE_TO_STONE (new BigDecimal("157.473")),
        TONNE_TO_US_TON (new BigDecimal("1.10231"));

        public BigDecimal Factor;

        MetricToImperialFactors(BigDecimal conversionFactorParam)
        {
            this.Factor = conversionFactorParam;
        }
    }

    public static enum ImperialToMetricFactors{
        OUNCE_TO_MILLIGRAM (new BigDecimal("28349.5")),
        OUNCE_TO_GRAM (new BigDecimal("28.3495")),
        OUNCE_TO_KILOGRAM (new BigDecimal("0.0283495")),
        OUNCE_TO_TONNE (new BigDecimal("0.0000283495")),

        POUND_TO_MILLIGRAM (new BigDecimal("453592.37")),
        POUND_TO_GRAM (new BigDecimal("453.59237")),
        POUND_TO_KILOGRAM (new BigDecimal("0.45359237")),
        POUND_TO_TONNE (new BigDecimal("0.000453592")),

        STONE_TO_MILLIGRAM (new BigDecimal("6350290")),
        STONE_TO_GRAM (new BigDecimal("6350.29")),
        STONE_TO_KILOGRAM (new BigDecimal("6.35029")),
        STONE_TO_TONNE (new BigDecimal("0.00635029")),

        US_TON_TO_MILLIGRAM (new BigDecimal("907185000")),
        US_TON_TO_GRAM (new BigDecimal("907185")),
        US_TON_TO_KILOGRAM (new BigDecimal("907.185")),
        US_TON_TO_TONNE (new BigDecimal("0.907185"));

        public BigDecimal Factor;

        ImperialToMetricFactors(BigDecimal conversionFactorParam)
        {
            this.Factor = conversionFactorParam;
        }
    }

    private static ImperialMass getImperialMassFromString(String str) {
        try {
            return ImperialMass.valueOf(str);
        } catch (IllegalArgumentException e) {
            // handle the case where the string is not a valid enum value
            return null;
        }
    }

    private static MetricMass getMetricMassFromString(String str) {
        try {
            return MetricMass.valueOf(str);
        } catch (IllegalArgumentException e) {
            // handle the case where the string is not a valid enum value
            return null;
        }
    }

    private static BigDecimal ConvertMetricToImperial(BigDecimal length, MetricMass fromUnit, ImperialMass toUnit)
    {
        BigDecimal result = new BigDecimal("0.00");

        switch(fromUnit)
        {
            case MILLIGRAM:
                switch(toUnit)
                {
                    case OUNCE:
                        result = length.multiply( MetricToImperialFactors.MILLIGRAM_TO_OUNCE.Factor);
                        break;
                    case POUND:
                        result = length.multiply( MetricToImperialFactors.MILLIGRAM_TO_POUND.Factor);
                        break;
                    case STONE:
                        result = length.multiply( MetricToImperialFactors.MILLIGRAM_TO_STONE.Factor);
                        break;
                    case US_TON:
                        result = length.multiply( MetricToImperialFactors.MILLIGRAM_TO_US_TON.Factor);
                        break;
                }
                break;
            case GRAM:
                switch(toUnit)
                {
                    case OUNCE:
                        result = length.multiply( MetricToImperialFactors.GRAM_TO_OUNCE.Factor);
                        break;
                    case POUND:
                        result = length.multiply( MetricToImperialFactors.GRAM_TO_POUND.Factor);
                        break;
                    case STONE:
                        result = length.multiply( MetricToImperialFactors.GRAM_TO_STONE.Factor);
                        break;
                    case US_TON:
                        result = length.multiply( MetricToImperialFactors.GRAM_TO_US_TON.Factor);
                        break;
                }
                break;
            case KILOGRAM:
                switch(toUnit)
                {
                    case OUNCE:
                        result = length.multiply( MetricToImperialFactors.KILOGRAM_TO_OUNCE.Factor);
                        break;
                    case POUND:
                        result = length.multiply( MetricToImperialFactors.KILOGRAM_TO_POUND.Factor);
                        break;
                    case STONE:
                        result = length.multiply( MetricToImperialFactors.KILOGRAM_TO_STONE.Factor);
                        break;
                    case US_TON:
                        result = length.multiply( MetricToImperialFactors.KILOGRAM_TO_US_TON.Factor);
                        break;
                }
                break;
            case TONNE:
                switch(toUnit)
                {
                    case OUNCE:
                        result = length.multiply( MetricToImperialFactors.TONNE_TO_OUNCE.Factor);
                        break;
                    case POUND:
                        result = length.multiply( MetricToImperialFactors.TONNE_TO_POUND.Factor);
                        break;
                    case STONE:
                        result = length.multiply( MetricToImperialFactors.TONNE_TO_STONE.Factor);
                        break;
                    case US_TON:
                        result = length.multiply( MetricToImperialFactors.TONNE_TO_US_TON.Factor);
                        break;
                }
                break;
        }

        return result;
    }

    private static BigDecimal ConvertImperialToMetric(BigDecimal length, ImperialMass fromUnit, MetricMass toUnit)
    {
        BigDecimal result = new BigDecimal("0.00");

        switch(fromUnit)
        {
            case OUNCE:
                switch(toUnit)
                {
                    case MILLIGRAM:
                        result = length.multiply( ImperialToMetricFactors.OUNCE_TO_MILLIGRAM.Factor);
                        break;
                    case GRAM:
                        result = length.multiply( ImperialToMetricFactors.OUNCE_TO_GRAM.Factor);
                        break;
                    case KILOGRAM:
                        result = length.multiply( ImperialToMetricFactors.OUNCE_TO_KILOGRAM.Factor);
                        break;
                    case TONNE:
                        result = length.multiply( ImperialToMetricFactors.OUNCE_TO_TONNE.Factor);
                        break;
                }
                break;
            case POUND:
                switch(toUnit)
                {
                    case MILLIGRAM:
                        result = length.multiply( ImperialToMetricFactors.POUND_TO_MILLIGRAM.Factor);
                        break;
                    case GRAM:
                        result = length.multiply( ImperialToMetricFactors.POUND_TO_GRAM.Factor);
                        break;
                    case KILOGRAM:
                        result = length.multiply( ImperialToMetricFactors.POUND_TO_KILOGRAM.Factor);
                        break;
                    case TONNE:
                        result = length.multiply( ImperialToMetricFactors.POUND_TO_TONNE.Factor);
                        break;
                }
                break;
            case STONE:
                switch(toUnit)
                {
                    case MILLIGRAM:
                        result = length.multiply( ImperialToMetricFactors.STONE_TO_MILLIGRAM.Factor);
                        break;
                    case GRAM:
                        result = length.multiply( ImperialToMetricFactors.STONE_TO_GRAM.Factor);
                        break;
                    case KILOGRAM:
                        result = length.multiply( ImperialToMetricFactors.STONE_TO_KILOGRAM.Factor);
                        break;
                    case TONNE:
                        result = length.multiply( ImperialToMetricFactors.STONE_TO_TONNE.Factor);
                        break;
                }
                break;
            case US_TON:
                switch(toUnit)
                {
                    case MILLIGRAM:
                        result = length.multiply( ImperialToMetricFactors.US_TON_TO_MILLIGRAM.Factor);
                        break;
                    case GRAM:
                        result = length.multiply( ImperialToMetricFactors.US_TON_TO_GRAM.Factor);
                        break;
                    case KILOGRAM:
                        result = length.multiply( ImperialToMetricFactors.US_TON_TO_KILOGRAM.Factor);
                        break;
                    case TONNE:
                        result = length.multiply( ImperialToMetricFactors.US_TON_TO_TONNE.Factor);
                        break;
                }
                break;
        }

        return result;
    }

    public String Convert(String numTemp, String typeConvFrom, String typeConvTo)
    {
        String toReturn = "";
        BigDecimal bd = new BigDecimal(numTemp);
        if(isMetric(typeConvFrom) && isMetric(typeConvTo))  {
            //full metric
            toReturn = MainConvert(bd, getMetricMassFromString(typeConvFrom), getMetricMassFromString(typeConvTo), Mass_Converter.MetricMass.values()).toString();
        }
        else if(isImperial(typeConvFrom) && isImperial(typeConvTo)) {
            //full imperial
            toReturn = MainConvert(bd, getImperialMassFromString(typeConvFrom), getImperialMassFromString(typeConvTo), Mass_Converter.ImperialMass.values()).toString();
        }
        else if(isMetric(typeConvFrom) && isImperial(typeConvTo)) {
            //metric to imperial
            toReturn = ConvertMetricToImperial(bd, getMetricMassFromString(typeConvFrom), getImperialMassFromString(typeConvTo)).toString();
        }
        else if(isImperial(typeConvFrom) && isMetric(typeConvTo)) {
            //imperial to metric
            toReturn = ConvertImperialToMetric(bd, getImperialMassFromString(typeConvFrom), getMetricMassFromString(typeConvTo)).toString();
        }

        return toReturn;
    }

    public static void main(String[] args) {

    }
}
