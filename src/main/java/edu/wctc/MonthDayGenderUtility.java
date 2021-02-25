package edu.wctc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MonthDayGenderUtility {
    private	final int MOD_MALE = 0;
    private	final int MOD_FEMALE = 500;
    private	final char CODE_MALE = 'M';
    private	final char CODE_FEMALE = 'F';

    public int encodeMonthDayGender(int year, int month, int day, char genderCode) throws UnknownGenderCodeException, InvalidBirthdayException {
        if (genderCode != CODE_MALE && genderCode != CODE_FEMALE) {
            throw new UnknownGenderCodeException(genderCode);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            String parsedMonth = Integer.toString(month);
            if (month < 10) {
                parsedMonth = "0" + parsedMonth;
            }
            LocalDate.parse(year + "-" + parsedMonth + "-" + day);

            if (genderCode == CODE_MALE) {
                return (month - 1) * 40 + day + MOD_MALE;
            }
            return (month - 1) * 40 + day + MOD_FEMALE;
        } catch (Error e) {
            throw new InvalidBirthdayException(year, month, day);
        }
    }
}
