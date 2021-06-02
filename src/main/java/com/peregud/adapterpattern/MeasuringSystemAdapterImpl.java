package com.peregud.adapterpattern;

public class MeasuringSystemAdapterImpl extends TwoWaysCalculatorAdapter implements MeasuringSystemAdapter {

    public MeasuringSystemAdapterImpl(ShapeType shapeType) {
        super(shapeType);
    }

    @Override
    public double calculatePerimeter() {
        double cm = super.calculatePerimeter();
        return RoundUtil.up(convertCMtoInch(cm));
    }

    @Override
    public double calculateArea() {
        double cm = super.calculateArea();
        return RoundUtil.up(convertCMtoInch(cm));
    }

    @Override
    public double calculateVolume() {
        double cm = super.calculateVolume();
        return RoundUtil.up(convertCMtoInch(cm));
    }

    private double convertCMtoInch(double cm) {
        return cm * 0.39;
    }
}
