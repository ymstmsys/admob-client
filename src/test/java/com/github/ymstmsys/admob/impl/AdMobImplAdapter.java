package com.github.ymstmsys.admob.impl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import com.github.ymstmsys.admob.SiteStat;

/**
 * Mocking role for {@link AdMobImpl}.
 * 
 * @author gogoluxecs
 * 
 */
public class AdMobImplAdapter extends AdMobImpl {

	public AdMobImplAdapter(String clientKey) {
		super(clientKey);
	}

	/**
	 * Mockup ready.
	 */
	@Override
	public String requestHttpGet(String url) {
		return this.requestHttpGet(url);
	}

	/**
	 * Mockup ready.
	 */
	public List<SiteStat> toMockSiteStats(JSONArray data) throws JSONException {
		return this.toSiteStats(data);
	}

}
