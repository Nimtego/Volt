package com.nimtego.volt.presenter;

import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.nimtego.volt.R;
import com.nimtego.volt.view.AmountsActivity;
import com.nimtego.volt.view.VoltActivity;
import com.nimtego.volt.model.Entity;

/**
 * Created by nimtego_loc on 18.03.2018.
 */

public class VoltPresenter implements Presenter {
    private Entity mEntity;
    private VoltActivity mVoltActivity;

    public VoltPresenter(VoltActivity voltActivity) {
        mVoltActivity = voltActivity;
        mEntity = new Entity();
    }

    @Override
    public void onClick(View view) {
        Log.v(this.getClass().getSimpleName(), "method onClick");

        if (R.id.result_button == view.getId()) {
            float current = Float.parseFloat(((EditText)mVoltActivity.getCurrent()).getText().toString());
            float voltage = Float.parseFloat(((EditText)mVoltActivity.getVoltage()).getText().toString());
            float power = Float.parseFloat(((EditText)mVoltActivity.getPower()).getText().toString());
            mEntity.setCurrent(current);
            mEntity.setPower(power);
            mEntity.setVoltage(voltage);
            calculate();
        }
    }

    @Override
    public void attachView(AmountsActivity amountsActivity) {
        if (amountsActivity instanceof VoltActivity)
            mVoltActivity = (VoltActivity) amountsActivity;
    }
    @Override
    public void detachView() {
        mVoltActivity = null;
    }

    private void calculate() {

        mEntity.setCalculate(mEntity.getCurrent()*mEntity.getPower()*mEntity.getVoltage());
        String str = String.valueOf(mEntity.getCalculate());
        mVoltActivity.setResult(str);
    }
}
