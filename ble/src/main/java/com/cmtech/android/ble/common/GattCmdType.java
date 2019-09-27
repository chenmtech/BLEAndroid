package com.cmtech.android.ble.common;


public enum GattCmdType {
    GATT_CMD_READ(0x01),
    GATT_CMD_WRITE(0x02),
    GATT_CMD_NOTIFY(0x04),
    GATT_CMD_INDICATE(0x08),
    GATT_CMD_INSTANTRUN(0x10); //即时命令属性，即不需要等待蓝牙响应，立即执行回调的命令

    private int code;

    GattCmdType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
