package com.github.ymstmsys.admob.impl;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.ymstmsys.admob.AdMob;
import com.github.ymstmsys.admob.ObjectDimension;
import com.github.ymstmsys.admob.SiteStat;
import com.github.ymstmsys.admob.TimeDimension;

/**
 * 
 * @author gogoluxecs
 * 
 */
public class AdMobImplIntegrationTest {

	private AdMob adMob;

	private static final Properties prop = new Properties();
	private String clientKey;
	private String password;
	private String email;

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
		email = prop.getProperty("admob.email");
		password = prop.getProperty("admob.password");

		adMob = new AdMobImpl(clientKey);
	}

	@Test
	public void successfullLogin() {
		adMob.login(email, password);
	}

	@Test(expected = RuntimeException.class)
	public void wrongLoginByEmail() {
		adMob.login(null, password);

	}

	@Test(expected = RuntimeException.class)
	public void wrongLoginByEmailAndPassword() {
		adMob.login(null, null);
	}

	@Test(expected = RuntimeException.class)
	public void wrongLoginByPassword() {
		adMob.login(email, null);
	}

	@Test
	public void siteSearchForAllApplications() {
		adMob.login(email, password);
		Assert.assertNotNull(adMob.siteSearch());
	}

	@Test(expected = RuntimeException.class)
	public void siteSearchWithoutLoginCredentials() {
		adMob.siteSearch();
	}

	@Test
	public void siteStatsWithoutObjectAndTimeDimension() throws ParseException {
		adMob.login(email, password);
		adMob.siteSearch();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d = format.parse("2013-05-14");

		List<SiteStat> siteStats = adMob.siteStats(adMob.siteSearch(), d, d);
		SiteStat siteStat = siteStats.iterator().next();
		Assert.assertNotNull(siteStat.getSiteId());
		Assert.assertTrue(siteStat.getSiteId().isEmpty());
	}

	@Test
	public void siteStatsWithObjectAndTimeDimension() throws ParseException {
		adMob.login(email, password);
		adMob.siteSearch();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d = format.parse("2013-05-14");

		List<SiteStat> siteStats = adMob.siteStats(adMob.siteSearch(), d, d,
				ObjectDimension.SITE, TimeDimension.DAY);
		SiteStat siteStat = siteStats.iterator().next();
		Assert.assertNotNull(siteStat.getSiteId());
		Assert.assertFalse(siteStat.getSiteId().isEmpty());
	}

}
