package com.github.ymstmsys.admob;

/**
 * @author ymstmsys
 */
public enum TimeDimension {

    DAY("day"),

    WEEK("week"),

    MONTH("month");

    private String value;

    private TimeDimension(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

}
