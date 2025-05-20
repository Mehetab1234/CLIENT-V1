package com.crazeclient;

public class CPSCounter {
    private long[] clicks = new long[100];

    public void registerClick() {
        long time = System.currentTimeMillis();
        System.arraycopy(clicks, 1, clicks, 0, clicks.length - 1);
        clicks[clicks.length - 1] = time;
    }

    public int getCPS() {
        long time = System.currentTimeMillis();
        int cps = 0;
        for (long click : clicks) {
            if (time - click < 1000) cps++;
        }
        return cps;
    }
}