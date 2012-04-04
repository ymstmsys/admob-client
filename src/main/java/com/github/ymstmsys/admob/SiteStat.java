package com.github.ymstmsys.admob;

import java.io.Serializable;

/**
 * @author ymstmsys
 */
public class SiteStat implements Serializable {

    private static final long serialVersionUID = 1L;

    private String siteId;

    private long requests;

    private long overallRequests;

    private long houseadRequests;

    private long interstitialRequests;

    private long impressions;

    private long cpcImpressions;

    private long cpmImpressions;

    private long exchangeImpressions;

    private long houseadImpressions;

    private long interstitialImpressions;

    private double fillRate;

    private double houseadFillRate;

    private double overallFillRate;

    private long clicks;

    private long houseadClicks;

    private double ctr;

    private double houseadCtr;

    private double ecpm;

    private double revenue;

    private double cpcRevenue;

    private double cpmRevenue;

    private double exchangeDownloads;

    private String date;

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public long getRequests() {
        return requests;
    }

    public void setRequests(long requests) {
        this.requests = requests;
    }

    public long getOverallRequests() {
        return overallRequests;
    }

    public void setOverallRequests(long overallRequests) {
        this.overallRequests = overallRequests;
    }

    public long getHouseadRequests() {
        return houseadRequests;
    }

    public void setHouseadRequests(long houseadRequests) {
        this.houseadRequests = houseadRequests;
    }

    public long getInterstitialRequests() {
        return interstitialRequests;
    }

    public void setInterstitialRequests(long interstitialRequests) {
        this.interstitialRequests = interstitialRequests;
    }

    public long getImpressions() {
        return impressions;
    }

    public void setImpressions(long impressions) {
        this.impressions = impressions;
    }

    public long getCpcImpressions() {
        return cpcImpressions;
    }

    public void setCpcImpressions(long cpcImpressions) {
        this.cpcImpressions = cpcImpressions;
    }

    public long getCpmImpressions() {
        return cpmImpressions;
    }

    public void setCpmImpressions(long cpmImpressions) {
        this.cpmImpressions = cpmImpressions;
    }

    public long getExchangeImpressions() {
        return exchangeImpressions;
    }

    public void setExchangeImpressions(long exchangeImpressions) {
        this.exchangeImpressions = exchangeImpressions;
    }

    public long getHouseadImpressions() {
        return houseadImpressions;
    }

    public void setHouseadImpressions(long houseadImpressions) {
        this.houseadImpressions = houseadImpressions;
    }

    public long getInterstitialImpressions() {
        return interstitialImpressions;
    }

    public void setInterstitialImpressions(long interstitialImpressions) {
        this.interstitialImpressions = interstitialImpressions;
    }

    public double getFillRate() {
        return fillRate;
    }

    public void setFillRate(double fillRate) {
        this.fillRate = fillRate;
    }

    public double getHouseadFillRate() {
        return houseadFillRate;
    }

    public void setHouseadFillRate(double houseadFillRate) {
        this.houseadFillRate = houseadFillRate;
    }

    public double getOverallFillRate() {
        return overallFillRate;
    }

    public void setOverallFillRate(double overallFillRate) {
        this.overallFillRate = overallFillRate;
    }

    public long getClicks() {
        return clicks;
    }

    public void setClicks(long clicks) {
        this.clicks = clicks;
    }

    public long getHouseadClicks() {
        return houseadClicks;
    }

    public void setHouseadClicks(long houseadClicks) {
        this.houseadClicks = houseadClicks;
    }

    public double getCtr() {
        return ctr;
    }

    public void setCtr(double ctr) {
        this.ctr = ctr;
    }

    public double getHouseadCtr() {
        return houseadCtr;
    }

    public void setHouseadCtr(double houseadCtr) {
        this.houseadCtr = houseadCtr;
    }

    public double getEcpm() {
        return ecpm;
    }

    public void setEcpm(double ecpm) {
        this.ecpm = ecpm;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public double getCpcRevenue() {
        return cpcRevenue;
    }

    public void setCpcRevenue(double cpcRevenue) {
        this.cpcRevenue = cpcRevenue;
    }

    public double getCpmRevenue() {
        return cpmRevenue;
    }

    public void setCpmRevenue(double cpmRevenue) {
        this.cpmRevenue = cpmRevenue;
    }

    public double getExchangeDownloads() {
        return exchangeDownloads;
    }

    public void setExchangeDownloads(double exchangeDownloads) {
        this.exchangeDownloads = exchangeDownloads;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "SiteStat [siteId=" + siteId + ", requests=" + requests + ", overallRequests=" + overallRequests
                + ", houseadRequests=" + houseadRequests + ", interstitialRequests=" + interstitialRequests
                + ", impressions=" + impressions + ", cpcImpressions=" + cpcImpressions + ", cpmImpressions="
                + cpmImpressions + ", exchangeImpressions=" + exchangeImpressions + ", houseadImpressions="
                + houseadImpressions + ", interstitialImpressions=" + interstitialImpressions + ", fillRate="
                + fillRate + ", houseadFillRate=" + houseadFillRate + ", overallFillRate=" + overallFillRate
                + ", clicks=" + clicks + ", houseadClicks=" + houseadClicks + ", ctr=" + ctr + ", houseadCtr="
                + houseadCtr + ", ecpm=" + ecpm + ", revenue=" + revenue + ", cpcRevenue=" + cpcRevenue
                + ", cpmRevenue=" + cpmRevenue + ", exchangeDownloads=" + exchangeDownloads + ", date=" + date + "]";
    }

}
