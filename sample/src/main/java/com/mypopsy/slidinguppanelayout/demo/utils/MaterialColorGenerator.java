package com.mypopsy.slidinguppanelayout.demo.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MaterialColorGenerator {

    public static MaterialColorGenerator MATERIAL;

    static {
        MATERIAL = create(Arrays.asList(
                0xffe57373,
                0xfff06292,
                0xffba68c8,
                0xff9575cd,
                0xff7986cb,
                0xff64b5f6,
                0xff4fc3f7,
                0xff4dd0e1,
                0xff4db6ac,
                0xff81c784,
                0xffaed581,
                0xffff8a65,
                0xffd4e157,
                0xffffd54f,
                0xffffb74d,
                0xffa1887f,
                0xff90a4ae
        ));
    }

    private final List<Integer> mColors;
    private Random mRandom;

    public static MaterialColorGenerator getInstance() {
        return MATERIAL;
    }

    public static MaterialColorGenerator create(List<Integer> colorList) {
        return new MaterialColorGenerator(colorList);
    }

    private MaterialColorGenerator(List<Integer> colorList) {
        mColors = colorList;
        mRandom = new Random(System.currentTimeMillis());
    }

    public int getRandomColor() {
        return mColors.get(mRandom.nextInt(mColors.size()));
    }

    public int getColor(Object key) {
        return mColors.get(Math.abs(key.hashCode()) % mColors.size());
    }
}