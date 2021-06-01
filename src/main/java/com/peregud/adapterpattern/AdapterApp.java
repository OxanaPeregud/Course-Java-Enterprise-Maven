package com.peregud.adapterpattern;

public class AdapterApp {

    public static void main(String[] args) {

        CalculatingVolume calculating = new CalculatingVolume();
        calculating.addShape(new TwoWaysAdapter(ShapeType.CIRCLE));
        calculating.addShape(new TwoWaysAdapter(ShapeType.CUBE));
        calculating.addShape(new TwoWaysAdapter(ShapeType.CYLINDER));
        calculating.addShape(new TwoWaysAdapter(ShapeType.RECTANGLE));
        calculating.calculatingVolume();
    }
}
