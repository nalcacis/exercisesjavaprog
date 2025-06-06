package be.abis.exercise.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Locale;

public class TestDateTime {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusYears(3).plusMonths(2).plusDays(15);
        System.out.println("Future Date:" + futureDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        LocalDate birthDate = LocalDate.of(1995, 05, 8);
        System.out.println(birthDate.format(DateTimeFormatter.ofPattern("EEEE", new Locale("tr" ))) + " gununde dogdunuz.");

        long daysOld = ChronoUnit.DAYS.between(birthDate, today);
        System.out.println("You are "  + daysOld + " days old.");
    }
}