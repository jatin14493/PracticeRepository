package com.company.Jatin;

import java.util.Comparator;

public class CountryBronzeComparator implements Comparator<Country> {
    @Override
    public int compare(Country o1, Country o2) {
        return o2.getBronze() - o1.getBronze();
    }
}
