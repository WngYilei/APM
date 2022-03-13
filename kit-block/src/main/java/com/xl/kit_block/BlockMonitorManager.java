package com.xl.kit_block;

import android.os.Looper;


import com.xl.kit_common.LogHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @desc: 卡顿检测管理类
 */
public class BlockMonitorManager {
    private static final String TAG = "BlockMonitorManager";
    private static final int MAX_SIZE = 50;


    private static class Holder {
        private static BlockMonitorManager INSTANCE = new BlockMonitorManager();
    }

    private volatile boolean mIsRunning;
    private MonitorCore mMonitorCore;

    private List<BlockInfo> mBlockInfoList = Collections.synchronizedList(new ArrayList<BlockInfo>());


    public static BlockMonitorManager getInstance() {
        return Holder.INSTANCE;
    }

    private BlockMonitorManager() {

    }

    public void start() {
        if (mIsRunning) {
            LogHelper.e(TAG, "start when manager is running");
            return;
        }

        if (mMonitorCore == null) {
            mMonitorCore = new MonitorCore();
        }
        mIsRunning = true;
        Looper.getMainLooper().setMessageLogging(mMonitorCore);
    }

    public boolean isRunning() {
        return mIsRunning;
    }

    public void stop() {
        if (!mIsRunning) {
            LogHelper.e(TAG, "stop when manager is not running");
            return;
        }
        Looper.getMainLooper().setMessageLogging(null);
        if (mMonitorCore != null) {
            mMonitorCore.shutDown();
            mMonitorCore = null;
        }

        mIsRunning = false;

    }


    /**
     * 通知卡顿
     *
     * @param blockInfo
     */
    void notifyBlockEvent(BlockInfo blockInfo) {
        LogHelper.e(TAG, "发生了卡顿" + blockInfo.toString());
    }

}
