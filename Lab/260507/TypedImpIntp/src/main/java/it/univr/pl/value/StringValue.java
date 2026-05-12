package it.univr.pl.value;

public class StringValue extends ExpValue<String> {

    public StringValue(String value) {
        super(value);
    }

    @Override
    public String toString() {
        return "'" + super.toString() + "'";
    }
}
