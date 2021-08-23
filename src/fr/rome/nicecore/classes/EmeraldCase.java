package fr.rome.nicecore.classes;

public class EmeraldCase implements  Comparable<EmeraldCase> {

    public String name;
    public int emeralds;

    public EmeraldCase(String name, int emeralds) {
        super();
        this.name = name;
        this.emeralds = emeralds;
    }

    public String getName() {
        return name;
    }

    public int getEmeralds() {
        return emeralds;
    }

    @Override
    public int compareTo(EmeraldCase o) {
        return o.emeralds - this.emeralds;
    }
}
