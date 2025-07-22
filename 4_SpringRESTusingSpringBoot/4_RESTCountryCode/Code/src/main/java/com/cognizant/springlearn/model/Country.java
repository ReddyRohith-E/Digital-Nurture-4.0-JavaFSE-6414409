package com.cognizant.springlearn.model;

/**
 * Country model class representing country details
 */
public class Country {
    private String countryCode;
    private String countryName;
    private String capital;
    private long population;
    private String currency;
    private String region;
    private String subRegion;
    private double area;
    
    // Default constructor
    public Country() {
    }
    
    // Parameterized constructor
    public Country(String countryCode, String countryName, String capital, 
                   long population, String currency, String region, 
                   String subRegion, double area) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.capital = capital;
        this.population = population;
        this.currency = currency;
        this.region = region;
        this.subRegion = subRegion;
        this.area = area;
    }
    
    // Getters and Setters
    public String getCountryCode() {
        return countryCode;
    }
    
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    
    public String getCountryName() {
        return countryName;
    }
    
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    
    public String getCapital() {
        return capital;
    }
    
    public void setCapital(String capital) {
        this.capital = capital;
    }
    
    public long getPopulation() {
        return population;
    }
    
    public void setPopulation(long population) {
        this.population = population;
    }
    
    public String getCurrency() {
        return currency;
    }
    
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
    public String getRegion() {
        return region;
    }
    
    public void setRegion(String region) {
        this.region = region;
    }
    
    public String getSubRegion() {
        return subRegion;
    }
    
    public void setSubRegion(String subRegion) {
        this.subRegion = subRegion;
    }
    
    public double getArea() {
        return area;
    }
    
    public void setArea(double area) {
        this.area = area;
    }
    
    @Override
    public String toString() {
        return "Country{" +
                "countryCode='" + countryCode + '\'' +
                ", countryName='" + countryName + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                ", currency='" + currency + '\'' +
                ", region='" + region + '\'' +
                ", subRegion='" + subRegion + '\'' +
                ", area=" + area +
                '}';
    }
}
