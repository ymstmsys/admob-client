package com.github.ymstmsys.admob;

/**
 * @author ymstmsys
 */
public enum ObjectDimension {

    SITE("site"),
    
    AD("ad"),
    
    AD_GROUP("ad_group"),
    
    CAMPAIGN("campaign");

    private String value;

    private ObjectDimension(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

}
