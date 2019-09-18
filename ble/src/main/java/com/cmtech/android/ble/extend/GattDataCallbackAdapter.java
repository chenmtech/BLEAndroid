package com.cmtech.android.ble.extend;

import com.cmtech.android.ble.callback.IBleDataCallback;
import com.cmtech.android.ble.exception.BleException;
import com.cmtech.android.ble.model.BluetoothLeDevice;


/**
  *
  * ClassName:      GattDataCallbackAdapter
  * Description:    Gatt数据操作回调适配器，将IGattDataOpCallback适配为ViseBle包所需的IBleCallback
  * Author:         chenm
  * CreateDate:     2018-03-01 16:51
  * UpdateUser:     chenm
  * UpdateDate:     2019-06-22 16:51
  * UpdateRemark:   更新说明
  * Version:        1.0
 */

class GattDataCallbackAdapter implements IBleDataCallback {
    private IGattDataCallback dataOpCallback;

    private GattDataCallbackAdapter(IGattDataCallback gattDataCallback) {
        if(gattDataCallback == null) {
            throw new NullPointerException("The gattDataCallback adapted to IBleDataCallback must not be null");
        }

        this.dataOpCallback = gattDataCallback;
    }

    public static GattDataCallbackAdapter create(IGattDataCallback gattDataCallback) {
        return (gattDataCallback == null) ? null : new GattDataCallbackAdapter(gattDataCallback);
    }

    @Override
    public void onSuccess(byte[] data, BleGattChannel bleGattChannel, BluetoothLeDevice bluetoothLeDevice) {
        dataOpCallback.onSuccess(data);
    }

    @Override
    public void onFailure(BleException exception) {
        dataOpCallback.onFailure(new GattDataException(exception));
    }

}
