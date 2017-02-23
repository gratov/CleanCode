package model;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by paulienl on 23/02/2017.
 */
public class Grocery {
    private String name;
    private LocalDate dateBought;

    public Grocery(String name) {
        this.name = name;
        this.dateBought = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public DayOfWeek dayBought() {
        return dateBought.getDayOfWeek();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grocery grocery = (Grocery) o;

        return name != null ? name.equals(grocery.name) : grocery.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
