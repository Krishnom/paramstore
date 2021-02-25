package com.krishnom.paramstore.entities;

import java.util.Objects;

public class Parameter {
    private String name;
    private String value;
    private String defaultValue;
    private String description;

    public Parameter() throws Exception {
        super();
//        throw new Exception("Default Constructor cannot be called for paramter object");
    }

    public Parameter(String name, String value, String defaultValue, String description) {
        this.name = name;
        this.value = value;
        this.defaultValue = defaultValue;
        this.description = description;
    }

    public Parameter(String name, String value, String description) {
        this(name, value, null, description);
    }

    public Parameter(String name, String value) {
        this(name, value, null, "No Description");
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", defaultValue='" + defaultValue + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parameter parameter = (Parameter) o;
        return Objects.equals(name, parameter.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void setValue(String value) {
        this.value = value;
    }
}
