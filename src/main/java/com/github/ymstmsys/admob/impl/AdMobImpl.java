package com.github.ymstmsys.admob.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.github.ymstmsys.admob.AdMob;
import com.github.ymstmsys.admob.AdMobLoginException;
import com.github.ymstmsys.admob.ObjectDimension;
import com.github.ymstmsys.admob.Site;
import com.github.ymstmsys.admob.SiteStat;
import com.github.ymstmsys.admob.TimeDimension;

/**
 * AdMob API client implementation.
 * 
 * @author ymstmsys
 * @author gogoluxecs
 */
public class AdMobImpl implements AdMob {

	private String clientKey;

	private String token;

	private final Logger logger = Logger.getLogger(AdMobImpl.class);

	public AdMobImpl(String clientKey) {
		this.clientKey = clientKey;
	}

	protected boolean isLogin() {
		return token != null;
	}

	public static final String ADMOB_AUTH_LOGIN = "https://api.admob.com/v2/auth/login";

	@Override
	public void login(String email, String password) throws AdMobLoginException {
		String url = "https://api.admob.com/v2/auth/login";
		Map<String, String> entityMap = new LinkedHashMap<String, String>();
		entityMap.put("client_key", clientKey);
		entityMap.put("email", email);
		entityMap.put("password", password);

		String response = requestHttpPost(url, entityMap);

		try {
			JSONObject object = new JSONObject(response).getJSONObject("data");
			token = object.getString("token");
		} catch (JSONException e) {
			throw new AdMobLoginException();
		}
	}

	@Override
	public void logout() {
		if (!isLogin()) {
			return;
		}

		String url = "https://api.admob.com/v2/auth/logout";
		Map<String, String> entityMap = new LinkedHashMap<String, String>();
		entityMap.put("client_key", clientKey);
		entityMap.put("token", token);

		requestHttpPost(url, entityMap);
		token = null;
	}

	/**
	 * {@inheritDoc}
	 * @throws AdMobLoginException 
	 */
	@Override
	public List<Site> siteSearch() throws AdMobLoginException {
		return siteSearch(null, null);
	}

	/**
	 * {@inheritDoc}
	 * @throws AdMobLoginException 
	 */
	@Override
	public List<Site> siteSearch(List<String> siteIds, Boolean includeDeleted) throws AdMobLoginException {
		if (!isLogin()) {
			throw new AdMobLoginException();
		}

		StringBuilder url = new StringBuilder(
				"http://api.admob.com/v2/site/search");
		url.append("?client_key=").append(clientKey);
		url.append("&token=").append(token);
		if (siteIds != null) {
			for (String siteId : siteIds) {
				url.append("&site_id[]=").append(siteId);
			}
		}
		if (includeDeleted != null) {
			url.append("&include_deleted=").append(
					includeDeleted.booleanValue());
		}

		String response = requestHttpGet(url.toString());

		try {
			JSONArray array = new JSONObject(response).getJSONArray("data");
			return toSites(array);
		} catch (JSONException e) {
			logger.info(e.getMessage());
		}

		return null;
	}

	protected List<Site> toSites(JSONArray array) throws JSONException {
		List<Site> sites = new ArrayList<Site>();

		for (int i = 0; i < array.length(); i++) {
			JSONObject object = array.getJSONObject(i);

			Site site = new Site();
			site.setId(object.optString("id"));
			site.setName(object.optString("name"));
			site.setUrl(object.optString("url"));
			site.setDescription(object.optString("description"));
			sites.add(site);
		}

		return sites;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws AdMobLoginException
	 */
	@Override
	public List<SiteStat> siteStats(List<String> siteIds, String startDate,
			String endDate) throws AdMobLoginException {
		return siteStats(siteIds, startDate, endDate, null, null);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws AdMobLoginException
	 */
	@Override
	public List<SiteStat> siteStats(List<String> siteIds, String startDate,
			String endDate, ObjectDimension objectDimension,
			TimeDimension timeDimension) throws AdMobLoginException {
		if (!isLogin()) {
			throw new AdMobLoginException();
		}

		if (siteIds.size() == 0) {
			return new ArrayList<SiteStat>();
		}

		StringBuilder url = new StringBuilder(
				"http://api.admob.com/v2/site/stats");
		url.append("?client_key=").append(clientKey);
		url.append("&token=").append(token);
		for (String siteId : siteIds) {
			url.append("&site_id[]=").append(siteId);
		}
		url.append("&start_date=").append(startDate);
		url.append("&end_date=").append(endDate);
		if (objectDimension != null) {
			url.append("&object_dimension=").append(objectDimension.value());
		}
		if (timeDimension != null) {
			url.append("&time_dimension=").append(timeDimension.value());
		}
		String response = requestHttpGet(url.toString());

		try {
			JSONArray array = new JSONObject(response).getJSONArray("data");
			return toSiteStats(array);
		} catch (JSONException e) {
			logger.debug("Failed to fetch AdMob data with response: "
					+ response);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.ymstmsys.admob.AdMob#siteStats(java.util.List,
	 * java.util.Date, java.util.Date)
	 */
	@Override
	public List<SiteStat> siteStats(List<Site> siteIds, Date startDate,
			Date endDate) throws AdMobLoginException {

		List<String> sites = sitesToSiteIds(siteIds);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String start = format.format(startDate);
		String end = format.format(endDate);

		return siteStats(sites, start, end, null, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.ymstmsys.admob.AdMob#siteStats(java.util.List,
	 * java.util.Date, java.util.Date,
	 * com.github.ymstmsys.admob.ObjectDimension,
	 * com.github.ymstmsys.admob.TimeDimension)
	 */
	@Override
	public List<SiteStat> siteStats(List<Site> siteIds, Date startDate,
			Date endDate, ObjectDimension objectDimension,
			TimeDimension timeDimension) throws AdMobLoginException {
		List<String> sites = sitesToSiteIds(siteIds);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String start = format.format(startDate);
		String end = format.format(endDate);

		return siteStats(sites, start, end, objectDimension, timeDimension);
	}

	/**
	 * Builds SiteStat object from JSON data.
	 * 
	 * @param data
	 * @return
	 * @throws JSONException
	 */
	protected List<SiteStat> toSiteStats(JSONArray data) throws JSONException {
		List<SiteStat> stats = new ArrayList<SiteStat>();
		for (int i = 0; i < data.length(); i++) {
			JSONObject site = data.getJSONObject(i);

			SiteStat stat = new SiteStat();
			stat.setSiteId(site.optString("site_id"));
			stat.setRequests(site.optLong("requests"));
			stat.setOverallRequests(site.optLong("overall_requests"));
			stat.setHouseadRequests(site.optLong("housead_requests"));
			stat.setInterstitialRequests(site.optLong("interstitial_requests"));
			stat.setImpressions(site.optLong("impressions"));
			stat.setCpcImpressions(site.optLong("cpc_impressions"));
			stat.setCpmImpressions(site.optLong("cpm_impressions"));
			stat.setExchangeImpressions(site.optLong("exchange_impressions"));
			stat.setHouseadImpressions(site.optLong("housead_impressions"));
			stat.setInterstitialImpressions(site
					.optLong("interstitial_impressions"));
			stat.setFillRate(new BigDecimal(site.optDouble("fill_rate")));
			stat.setHouseadFillRate(new BigDecimal(site
					.optDouble("housead_fill_rate")));
			stat.setOverallFillRate(new BigDecimal(site
					.optDouble("overall_fill_rate")));
			stat.setClicks(site.optLong("clicks"));
			stat.setHouseadClicks(site.optLong("housead_clicks"));
			stat.setCtr(new BigDecimal(site.optDouble("ctr")));
			stat.setHouseadCtr(new BigDecimal(site.optDouble("housead_ctr")));
			stat.setEcpm(new BigDecimal(site.optDouble("ecpm")));
			stat.setRevenue(new BigDecimal(site.optDouble("revenue")));
			stat.setCpcRevenue(new BigDecimal(site.optDouble("cpc_revenue")));
			stat.setCpmRevenue(new BigDecimal(site.optDouble("cpm_revenue")));
			stat.setExchangeDownloads(new BigDecimal(site
					.optDouble("exchange_downloads")));
			stat.setDate(site.optString("date"));

			stats.add(stat);
		}

		return stats;
	}

	/**
	 * Converts sites object to list from siteIds.
	 * 
	 * @param sites
	 * @return
	 */
	protected List<String> sitesToSiteIds(List<Site> sites) {
		List<String> siteIds = new ArrayList<String>();
		for (Site site : sites) {
			siteIds.add(site.getId());
		}

		return siteIds;
	}

	/**
	 * Performs HTTP get request.
	 * 
	 * @param url
	 * @return
	 */
	protected String requestHttpGet(String url) {
		HttpClient client = new DefaultHttpClient();
		try {
			HttpGet request = new HttpGet(url);
			String response = client.execute(request,
					new ResponseHandler<String>() {
						@Override
						public String handleResponse(HttpResponse response)
								throws ClientProtocolException, IOException {
							switch (response.getStatusLine().getStatusCode()) {
							case HttpStatus.SC_OK:
								return EntityUtils.toString(
										response.getEntity(), "UTF-8");
							default:
								return null;
							}
						}
					});

			return response;

		} catch (IOException e) {
			// ignore
		} finally {
			client.getConnectionManager().shutdown();
		}

		return null;
	}

	/**
	 * Performs HTTP post request.
	 * 
	 * @param url
	 * @param entityMap
	 * @return
	 */
	protected String requestHttpPost(String url, Map<String, String> entityMap) {
		HttpClient client = new DefaultHttpClient();
		try {
			HttpPost request = new HttpPost(url);
			List<NameValuePair> pairs = new ArrayList<NameValuePair>();
			for (Map.Entry<String, String> entity : entityMap.entrySet()) {
				pairs.add(new BasicNameValuePair(entity.getKey(), entity
						.getValue()));
			}
			request.setEntity(new UrlEncodedFormEntity(pairs, "UTF-8"));

			String response = client.execute(request,
					new ResponseHandler<String>() {
						@Override
						public String handleResponse(HttpResponse response)
								throws ClientProtocolException, IOException {
							switch (response.getStatusLine().getStatusCode()) {
							case HttpStatus.SC_OK:
								return EntityUtils.toString(
										response.getEntity(), "UTF-8");
							default:
								return null;
							}
						}
					});

			return response;

		} catch (IOException e) {
			// ignore
		} finally {
			client.getConnectionManager().shutdown();
		}

		return null;
	}

}
