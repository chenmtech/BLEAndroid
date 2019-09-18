package com.cmtech.android.ble.callback;

import com.cmtech.android.ble.extend.BleGattChannel;
import com.cmtech.android.ble.exception.BleException;
import com.cmtech.android.ble.model.BluetoothLeDevice;

/**
 * @Description: 操作数据回调
 * @author: <a href="http://xiaoyaoyou1212.360doc.com">DAWI</a>
 * @date: 2017/10/17 19:42
 */
public interface IBleDataCallback {
    void onSuccess(byte[] data, BleGattChannel bleGattChannel, BluetoothLeDevice bluetoothLeDevice);

    void onFailure(BleException exception);
}
