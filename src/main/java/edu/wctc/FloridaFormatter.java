package edu.wctc;

public class FloridaFormatter extends DriversLicense implements DriversLicenseFormatter{
    public String formatLicenseNumber(DriversLicense driversLicense) {
        return driversLicense.getSSSS() + "-" + driversLicense.getFFF() + "-" + driversLicense.getYY() + "-" + driversLicense.getDDD() + "-" + "0";
    }
}
