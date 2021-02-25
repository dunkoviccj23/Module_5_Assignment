package edu.wctc;

import java.util.Scanner;

public class Main {
    private static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter first name: ");
        String firstName = keyboard.nextLine();

        System.out.print("Enter middle initial: ");
        String middleInitial = keyboard.nextLine();

        System.out.print("Enter last name: ");
        String lastName = keyboard.nextLine();

        System.out.print("Enter birth year (####): ");
        String birthYear = keyboard.nextLine();

        System.out.print("Enter birth month (1-12): ");
        int birthMonth = Integer.parseInt(keyboard.nextLine());

        System.out.print("Enter day of birth (1-31): ");
        int dayOfBirth = Integer.parseInt(keyboard.nextLine());

        System.out.print("Enter gender code (M or F): ");
        char gender = Character.toUpperCase(keyboard.nextLine().charAt(0));

        try {
            DriversLicense license = new DriversLicense();

            FirstNameUtility firstNameUtility = new FirstNameUtility();
            license.setFFF(firstNameUtility.encodeFirstName(firstName, middleInitial));

            LastNameUtility lastNameUtility = new LastNameUtility();
            license.setSSSS(lastNameUtility.encodeLastName(lastName));


            MonthDayGenderUtility monthDayGenderUtility = new MonthDayGenderUtility();
            license.setDDD(monthDayGenderUtility.encodeMonthDayGender(Integer.parseInt(birthYear), birthMonth, dayOfBirth, gender));

            license.setYY(Integer.parseInt(birthYear.substring(2, 4)));

            FloridaFormatter floridaFormatter = new FloridaFormatter();
            System.out.println(floridaFormatter.formatLicenseNumber(license));

            WisconsinFormatter wisconsinFormatter = new WisconsinFormatter();
            System.out.println(wisconsinFormatter.formatLicenseNumber(license));
        } catch (MissingNameException e) {
            e.printStackTrace();
        } catch (InvalidBirthdayException e) {
            e.printStackTrace();
        } catch (UnknownGenderCodeException e) {
            e.printStackTrace();
        }
    }
}
