package com.company.Jatin;
import java.util.Comparator;

public class CountryGoldComparator implements Comparator<Country> {
    @Override
    public int compare(Country o1, Country o2) {
        return o2.getGold() - o1.getGold();
    }
}
