package com.pgyhr.task.entity.enums;

/**
 *
 * @author xiaoguang cui
 * @date 2020/5/2
 */
public enum GenderTypeEnum{

    /**
     * 女
     */
    FEMALE(0, "女"),

    /**
     * 男
     */
    MALE(1, "男");

    private int key;

    private String value;

    GenderTypeEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public static String getValueByKey(Integer key) {
        if (key == null) {
            return null;
        }
        for (GenderTypeEnum ts : GenderTypeEnum.values()) {
            if (ts.getKey() == key) {
                return ts.getValue();
            }
        }
        return null;
    }

    public static Integer getKeyByValue(String value) {
        if (value == null) {
            return null;
        }
        for (GenderTypeEnum ts : GenderTypeEnum.values()) {
            if (value.equals(ts.getValue())) {
                return ts.getKey();
            }
        }
        return null;
    }
}