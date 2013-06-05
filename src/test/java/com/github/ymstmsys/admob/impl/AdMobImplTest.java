package com.github.ymstmsys.admob.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import junit.framework.Assert;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.ymstmsys.admob.SiteStat;

/**
 * 
 * @author gogoluxecs
 * 
 */
public class AdMobImplTest {

	private AdMobImplAdapter adapter;
	private static final Properties prop = new Properties();
	private String clientKey;

	@BeforeClass
	public static void init() throws IOException {
		InputStream in = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("admob.properties");
		Assert.assertNotNull(in);
		prop.load(in);
		in.close();

		Assert.assertNotNull(prop.getProperty("admob.clientkey"));
		Assert.assertNotNull(prop.getProperty("admob.email"));
		Assert.assertNotNull(prop.getProperty("admob.password"));
	}

	@Before
	public void setUp() {
		clientKey = prop.getProperty("admob.clientkey");
		adapter = new AdMobImplAdapter(clientKey);
	}

	@Test
	public void jsonStatsMapping() throws JSONException, IOException {
		FileInputStream stream = new FileInputStream(new File(
				"src/test/resources/admob.response"));
		String response = IOUtils.toString(stream, "UTF-8");
		stream.close();

		JSONArray array = new JSONObject(response).getJSONArray("data");
		List<SiteStat> siteStats = adapter.toMockSiteStats(array);

		SiteStat firstApp = siteStats.iterator().next();
		Assert.assertEquals("a22222222222222", firstApp.getSiteId());
		Assert.assertEquals(3975183, firstApp.getRequests());

		SiteStat secondApp = siteStats.get(1);
		Assert.assertEquals("a22222222222222", secondApp.getSiteId());
		Assert.assertEquals(3333404, secondApp.getRequests());
	}

}
