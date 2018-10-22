package org.yarnandtail.andhow.valuetype;

import org.yarnandtail.andhow.api.ParsingException;

import java.math.BigDecimal;

/**
 * Type representation of Java BigDecimal objects.
 *
 * This class is threadsafe and uses a singleton pattern to prevent  multiple
 * instances, since all users can safely use the same instance.
 *
 * @author chace86
 */
public class BigDecType extends BaseValueType<BigDecimal> {

    private static final BigDecType INSTANCE = new BigDecType();

    private BigDecType() {
        super(BigDecimal.class);
    }

    public static BigDecType instance() {
        return INSTANCE;
    }

    @Override
    public BigDecimal parse(String sourceValue) throws ParsingException {
        if (sourceValue == null) {
            return null;
        }
        try {
            return new BigDecimal(sourceValue);
        } catch (Exception e) {
            throw new ParsingException("Unable to convert to a BigDecimal numeric value", sourceValue, e);
        }
    }

    @Override
    public BigDecimal cast(Object o) throws RuntimeException {
        return (BigDecimal)o;
    }
}
