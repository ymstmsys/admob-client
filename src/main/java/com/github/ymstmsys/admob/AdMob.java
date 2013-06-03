package com.github.ymstmsys.admob;

import java.util.Date;
import java.util.List;

import org.json.JSONException;

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
	 * @throws JSONException
	 * @throws AdMobLoginException
	 */
	public void login(String email, String password) throws AdMobLoginException;

	/**
	 * Logs out user from AdMob.
	 */
	public void logout();

	/**
	 * Retrieves all sites.
	 * 
	 * @return
	 * @throws AdMobLoginException 
	 */
	public List<Site> siteSearch() throws AdMobLoginException;

	/**
	 * Retrieves specific sites with option to include or remove deleted.
	 * 
	 * @param siteIds
	 * @param includeDeleted
	 * @return
	 * @throws AdMobLoginException 
	 */
	public List<Site> siteSearch(List<String> siteIds, Boolean includeDeleted) throws AdMobLoginException;

	/**
	 * Retrieves site statistics for given period.
	 * 
	 * @param siteIds
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws AdMobLoginException
	 */
	public List<SiteStat> siteStats(List<String> siteIds, String startDate,
			String endDate) throws AdMobLoginException;

	/**
	 * Retrieves site statistics for given period.
	 * 
	 * @param sites
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws AdMobLoginException
	 */
	public List<SiteStat> siteStats(List<Site> sites, Date startDate,
			Date endDate) throws AdMobLoginException;

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
	 * @throws AdMobLoginException
	 */
	public List<SiteStat> siteStats(List<String> siteIds, String startDate,
			String endDate, ObjectDimension objectDimension,
			TimeDimension timeDimension) throws AdMobLoginException;

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
	 * @throws AdMobLoginException
	 */
	public List<SiteStat> siteStats(List<Site> siteIds, Date startDate,
			Date endDate, ObjectDimension objectDimension,
			TimeDimension timeDimension) throws AdMobLoginException;

}
