package edu.iu.habahram.ducksservice.model;

public record DuckData(int id, String type) implements Comparable {

    public String toLine() {
        return String.format("%1$s,%2$s", id(), type());
    }

    public static DuckData fromLine(String line) {
        String[] tokens = line.split(",");
        return new DuckData(Integer.parseInt(tokens[0]), tokens[1]);
    }

    @Override
    public int compareTo(Object object) {
        Duck otherDuck = (Duck)object;

        if (this.type.compareTo(otherDuck.getType().toString()) < 0) {
            return -1;
        }
        else if (this.type.compareTo(otherDuck.getType().toString()) == 0) {
            return 0;
        }
        else {
            return 1;
        }
    }
}
