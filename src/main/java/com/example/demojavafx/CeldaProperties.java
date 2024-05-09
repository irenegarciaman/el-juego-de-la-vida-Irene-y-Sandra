package com.example.demojavafx;

public class CeldaProperties {
    protected Celda[][] original;

    protected Celda[][] properties;

    public CeldaProperties(Celda[][] original) {}

    public Celda[][] getOriginal() {
        return original;
    }
    public void setOriginal(Celda[][] original) {
        this.original = original;
    }
    public Celda[][] getProperties() {
        return properties;
    }
    public void setProperties(Celda[][] properties) {
        this.properties = properties;
    }
    public void commit(){
        original = properties;
    }
    public void rollback(){
        properties = original;
    }

}
