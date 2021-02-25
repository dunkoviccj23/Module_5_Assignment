package edu.wctc;

public class WisconsinFormatter extends DriversLicense implements DriversLicenseFormatter {
    public String formatLicenseNumber(DriversLicense driversLicense) {
        String fffAsString = Integer.toString(driversLicense.getYY());
        return driversLicense.getSSSS() + "-" + driversLicense.getFFF() + fffAsString.charAt(0) + "-" + fffAsString.charAt(1) + driversLicense.getDDD() + "-" + "00";
    }
}
