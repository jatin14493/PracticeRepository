package com.company.Jatin;
import java.util.Comparator;

public class CountrySiverComparator implements Comparator<Country> {
    @Override
    public int compare(Country o1, Country o2) {
        return o2.getSilver() - o1.getSilver();
    }
}
