package com.github.ymstmsys.admob;

import com.github.ymstmsys.admob.impl.AdMobImpl;

/**
 * Factory of AdMob API client.
 * 
 * @author ymstmsys
 */
public class AdMobFactory {

    public static AdMob getInstance(String clientKey, String email, String password) {
        return new AdMobImpl(clientKey, email, password);
    }

}
