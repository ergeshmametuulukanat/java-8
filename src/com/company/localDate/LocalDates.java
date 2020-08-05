package com.company.localDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDates {
    public static void main(String[] args) {
//        Date date = new Date();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.set(Calendar.MONTH, 2);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        System.out.println(simpleDateFormat.format(date));
//        Date date1 = simpleDateFormat.parse("05/08/2020");

        LocalDate localDate = LocalDate.now();
        localDate = localDate.minusDays(5);
        localDate = localDate.plusMonths(5);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(localDate.format(dateTimeFormatter));
        LocalDate localDate1 = LocalDate.parse("05/08/2020", dateTimeFormatter);
    }
}
