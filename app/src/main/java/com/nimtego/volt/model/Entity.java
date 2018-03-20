package com.nimtego.volt.model;

/**
 * Created by nimtego_loc on 18.03.2018.
 */

public class Entity {
    private float mVoltage;
    private float mCurrent;
    private float mPower;
    private float mCalculate;

    public Entity() {
        this(0f,0f,0f);
    }
    public Entity(float voltage, float current, float power) {
        mVoltage = voltage;
        mCurrent = current;
        mPower = power;
    }

    public float getVoltage() {
        return mVoltage;
    }

    public void setVoltage(float voltage) {
        mVoltage = voltage;
    }

    public float getCurrent() {
        return mCurrent;
    }

    public void setCurrent(float current) {
        mCurrent = current;
    }

    public float getPower() {
        return mPower;
    }

    public void setPower(float power) {
        mPower = power;
    }

    public float getCalculate() {
        return mCalculate;
    }

    public void setCalculate(float calculate) {
        mCalculate = calculate;
    }
}
