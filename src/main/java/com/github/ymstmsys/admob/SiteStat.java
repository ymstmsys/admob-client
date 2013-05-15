package com.github.ymstmsys.admob;

import java.io.Serializable;
import java.math.BigDecimal;

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

    private BigDecimal fillRate;

    private BigDecimal houseadFillRate;

    private BigDecimal overallFillRate;

    private long clicks;

    private long houseadClicks;

    private BigDecimal ctr;

    private BigDecimal houseadCtr;

    private BigDecimal ecpm;

    private BigDecimal revenue;

    private BigDecimal cpcRevenue;

    private BigDecimal cpmRevenue;

    private BigDecimal exchangeDownloads;

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

    public BigDecimal getFillRate() {
        return fillRate;
    }

    public void setFillRate(BigDecimal fillRate) {
        this.fillRate = fillRate;
    }

    public BigDecimal getHouseadFillRate() {
        return houseadFillRate;
    }

    public void setHouseadFillRate(BigDecimal houseadFillRate) {
        this.houseadFillRate = houseadFillRate;
    }

    public BigDecimal getOverallFillRate() {
        return overallFillRate;
    }

    public void setOverallFillRate(BigDecimal overallFillRate) {
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

    public BigDecimal getCtr() {
        return ctr;
    }

    public void setCtr(BigDecimal ctr) {
        this.ctr = ctr;
    }

    public BigDecimal getHouseadCtr() {
        return houseadCtr;
    }

    public void setHouseadCtr(BigDecimal houseadCtr) {
        this.houseadCtr = houseadCtr;
    }

    public BigDecimal getEcpm() {
        return ecpm;
    }

    public void setEcpm(BigDecimal ecpm) {
        this.ecpm = ecpm;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }

    public BigDecimal getCpcRevenue() {
        return cpcRevenue;
    }

    public void setCpcRevenue(BigDecimal cpcRevenue) {
        this.cpcRevenue = cpcRevenue;
    }

    public BigDecimal getCpmRevenue() {
        return cpmRevenue;
    }

    public void setCpmRevenue(BigDecimal cpmRevenue) {
        this.cpmRevenue = cpmRevenue;
    }

    public BigDecimal getExchangeDownloads() {
        return exchangeDownloads;
    }

    public void setExchangeDownloads(BigDecimal exchangeDownloads) {
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
