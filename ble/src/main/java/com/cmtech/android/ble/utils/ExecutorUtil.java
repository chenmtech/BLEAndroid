package com.cmtech.android.ble.utils;

import com.vise.log.ViseLog;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorUtil {

    // 关闭线程池并等待它终止
    public static void shutdownNowAndAwaitTerminate(ExecutorService pool) {
        if (pool != null) {
            pool.shutdownNow();

            try {
                while (!pool.awaitTermination(1, TimeUnit.SECONDS)) {
                    ViseLog.e("The pool is not terminated. Wait again");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();

                pool.shutdownNow();

                Thread.currentThread().interrupt();
            }
        }
    }
}