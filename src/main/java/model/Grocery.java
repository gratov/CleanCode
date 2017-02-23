package model;

/**
 * Created by paulienl on 23/02/2017.
 */
public class Grocery {
    private String name;

    public Grocery(String name) {
        this.name = name;
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
