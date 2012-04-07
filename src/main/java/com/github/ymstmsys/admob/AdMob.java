package com.github.ymstmsys.admob;

import java.util.List;

/**
 * AdMob API client interface.
 * 
 * @author ymstmsys
 */
public interface AdMob {

    public void login(String email, String password);

    public void logout();

    public List<Site> siteSearch();

    public List<Site> siteSearch(List<String> siteIds, Boolean includeDeleted);

    public List<SiteStat> siteStats(List<String> siteIds, String startDate, String endDate);

    public List<SiteStat> siteStats(List<String> siteIds, String startDate, String endDate,
            ObjectDimension objectDimension, TimeDimension timeDimension);

}
