package com.github.ymstmsys.admob;

import java.util.Date;
import java.util.List;

/**
 * AdMob API client interface.
 * 
 * @author ymstmsys
 */
public interface AdMob {

	/**
	 * Logs in user to AdMob oAuth.
	 * 
	 * @param email
	 * @param password
	 */
	public void login(String email, String password);

	/**
	 * Logs out user from AdMob.
	 */
	public void logout();

	/**
	 * Retrieves all sites.
	 * 
	 * @return
	 */
	public List<Site> siteSearch();

	/**
	 * Retrieves specific sites with option to include or remove deleted.
	 * 
	 * @param siteIds
	 * @param includeDeleted
	 * @return
	 */
	public List<Site> siteSearch(List<String> siteIds, Boolean includeDeleted);

	/**
	 * Retrieves site statistics for given period.
	 * 
	 * @param siteIds
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<SiteStat> siteStats(List<String> siteIds, String startDate,
			String endDate);

	/**
	 * Retrieves site statistics for given period.
	 * 
	 * @param sites
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<SiteStat> siteStats(List<Site> sites, Date startDate,
			Date endDate);

	/**
	 * Retrieves site statistics for give period.
	 * 
	 * <ul>
	 * <li>ObjectDimension - Pass this parameter to group stats by site. If this
	 * parameter is not passed, stats will be totaled across all sites.</li>
	 * <li>TimeDimension - Pass this parameter to group stats by day, week, or
	 * month. If this parameter is not passed, stats will be totaled across the
	 * entire date range.</li>
	 * </ul>
	 * 
	 * @param siteIds
	 * @param startDate
	 * @param endDate
	 * @param objectDimension
	 * @param timeDimension
	 * @return
	 */
	public List<SiteStat> siteStats(List<String> siteIds, String startDate,
			String endDate, ObjectDimension objectDimension,
			TimeDimension timeDimension);

	/**
	 * Retrieves site statistics for give period.
	 * 
	 * <ul>
	 * <li>ObjectDimension - Pass this parameter to group stats by site. If this
	 * parameter is not passed, stats will be totaled across all sites.</li>
	 * <li>TimeDimension - Pass this parameter to group stats by day, week, or
	 * month. If this parameter is not passed, stats will be totaled across the
	 * entire date range.</li>
	 * </ul>
	 * 
	 * @param siteIds
	 * @param startDate
	 * @param endDate
	 * @param objectDimension
	 * @param timeDimension
	 * @return
	 */
	public List<SiteStat> siteStats(List<Site> siteIds, Date startDate,
			Date endDate, ObjectDimension objectDimension,
			TimeDimension timeDimension);

}
