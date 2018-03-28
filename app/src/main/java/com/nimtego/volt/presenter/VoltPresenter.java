package com.nimtego.volt.presenter;

import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.nimtego.volt.R;
import com.nimtego.volt.model.Entity;
import com.nimtego.volt.view.VoltView;

/**
 * Created by nimtego_loc on 18.03.2018.
 */

public class VoltPresenter extends AbstractBasePresenter<VoltView> {
    private Entity mEntity;

    public VoltPresenter() {
        mEntity = new Entity();
    }

    @Override
    public void onClick(View view) {
        Log.v(this.getClass().getSimpleName(), "method onClick");

        if (R.id.result_button == view.getId()) {
            float current = Float.parseFloat(((EditText)commonView.getCurrent()).getText().toString());
            float voltage = Float.parseFloat(((EditText)commonView.getVoltage()).getText().toString());
            float power = Float.parseFloat(((EditText)commonView.getPower()).getText().toString());
            mEntity.setCurrent(current);
            mEntity.setPower(power);
            mEntity.setVoltage(voltage);
            calculate();
        }
    }

    @Override
    public void viewIsReady() {

    }

    private void calculate() {

        mEntity.setCalculate(mEntity.getCurrent()*mEntity.getPower()*mEntity.getVoltage());
        String str = String.valueOf(mEntity.getCalculate());
        commonView.setResult(str);
    }
}
