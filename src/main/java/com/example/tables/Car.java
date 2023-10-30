package com.example.tables;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Car {
    SimpleStringProperty model;
    SimpleStringProperty color;
    SimpleIntegerProperty speed;

    public Car(String model, String color, int speed) {
        this.model = new SimpleStringProperty(model);
        this.color = new SimpleStringProperty(color);
        this.speed = new SimpleIntegerProperty(speed);

        this.model.addListener((val, oldval, newval)-> System.out.println("изменилось "+oldval+" стало "+newval));
        this.color.addListener((val, oldval, newval)-> System.out.println("изменилось "+oldval+" стало "+newval));
        this.speed.addListener((val, oldval, newval)-> System.out.println("изменилось "+oldval+" стало "+newval));
    }

    public String getModel() {
        return model.get();
    }

    public SimpleStringProperty modelProperty() {
        return model;
    }

    public void setModel(String model) {
        this.model.set(model);
    }

    public String getColor() {
        return color.get();
    }

    public SimpleStringProperty colorProperty() {
        return color;
    }

    public void setColor(String color) {
        this.color.set(color);
    }

    public int getSpeed() {
        return speed.get();
    }

    public SimpleIntegerProperty speedProperty() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed.set(speed);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model=" + model +
                ", color=" + color +
                ", speed=" + speed +
                '}';
    }
}
