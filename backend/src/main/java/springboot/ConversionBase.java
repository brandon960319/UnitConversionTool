package springboot;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public abstract class ConversionBase <T extends Enum<T>, X extends Enum<X>> {

    public BigDecimal MainConvert(BigDecimal length, Enum<?> fromUnit, Enum<?> toUnit, Enum<?>[] units) {
        BigDecimal result = new BigDecimal("0.00");
        if (fromUnit == toUnit) {
            return length;
        }
        if (fromUnit.ordinal() < toUnit.ordinal()) {
            // Iterate forward and divide
            result = length;
            boolean bDiv = false;
            boolean bBreakAfter = false;
            for (Enum<?> tempUnit : units) {
                if (tempUnit == fromUnit) {
                    bDiv = true;
                } else if (tempUnit == toUnit) {
                    bBreakAfter = true;
                }
                if (bDiv) {
                    result = result.divide(((MeasurementInterface)tempUnit).getFactor(), 15, RoundingMode.HALF_UP);
                    if (bBreakAfter) {
                        break;
                    }
                } else {
                    if (bBreakAfter) {
                        break;
                    }
                }
            }
        } else {
            // Iterate backwards and multiply
            result = length;
            boolean shouldDivide = false;
            for (int i = units.length - 1; i >= 0; i--) {
                Enum<?> tempUnit = units[i];
                if (tempUnit == fromUnit) {
                    shouldDivide = true;
                } else if (tempUnit == toUnit) {
                    break;
                }
                if (shouldDivide) {
                    result = result.multiply(((MeasurementInterface)tempUnit).getFactor());
                }
            }
        }
        return result;
    }

    public abstract boolean isMetric(String str);
    public abstract boolean isImperial(String str);

    public boolean isMetric(List<T> metrics, String str){
        for (T e : metrics) {
            if (e.name().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean isImperial(List<X> metrics, String str){
        for (X e : metrics) {
            if (e.name().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public List<String> SupportedImperial(List<X> imperials)
    {
        List<String> lengths = new ArrayList<>();
        for (X e : imperials) {
            lengths.add(e.name());
        }
        return lengths;
    }

    public List<String> SupportedMetric(List<T> metrics)
    {
        List<String> lengths = new ArrayList<>();
        for (T e : metrics) {
            lengths.add(e.name());
        }
        return lengths;
    }

}
