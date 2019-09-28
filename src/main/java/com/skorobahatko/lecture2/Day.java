package com.skorobahatko.lecture2;

import java.util.Arrays;

public enum Day {

    MONDAY(1, false),
    TUESDAY(2, false),
    WEDNESDAY(3, false),
    THURSDAY(4, false),
    FRIDAY(5, false),
    SATURDAY(6, true),
    SUNDAY(7, true);

    private final int number;
    private final boolean holiday;

    private Day(int number, boolean holiday) {
        this.number = number;
        this.holiday = holiday;
    }

    public static Day getDayByNumber(int number) {
        return Arrays
                .stream(Day.values())
                .filter((d) -> d.getNumber() == number)
                .findFirst()
                .orElse(null);
    }

    public int getNumber() {
        return number;
    }

    public boolean isHoliday() {
        return holiday;
    }

}
