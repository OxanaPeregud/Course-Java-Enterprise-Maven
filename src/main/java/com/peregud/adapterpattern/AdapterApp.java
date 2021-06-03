package com.peregud.adapterpattern;

public class AdapterApp {

    public static void main(String[] args) {

        CalculatingVolume calculating = new CalculatingVolume();
        calculating.addShape(new TwoWaysCalculatorAdapter(ShapeType.CIRCLE));
        calculating.addShape(new TwoWaysCalculatorAdapter(ShapeType.CUBE));
        calculating.addShape(new TwoWaysCalculatorAdapter(ShapeType.CYLINDER));
        calculating.addShape(new TwoWaysCalculatorAdapter(ShapeType.RECTANGLE));
        calculating.calculatingVolume();

        MeasuringSystemAdapter measuringSystemAdapter = new MeasuringSystemAdapterImpl(ShapeType.RECTANGLE);
        measuringSystemAdapter.calculateVolume();
    }
}
