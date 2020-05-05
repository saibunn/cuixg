package com.pgyhr.task.entity.enums;

/**
 *
 * @author xiaoguang cui
 * @date 2020/5/2
 */
public enum IdCardTypeEnum {

    /**
     * 身份证
     */
    ID(1, "身份证"),

    /**
     * 护照
     */
    PASSPORT(2, "护照"),


    /**
     * 军(警)官证
     */
    OFFICER_CARD(3, "军(警)官证"),

    /**
     * 士兵证
     */
    SOLDBUCH(4, "士兵证"),

    /**
     * 台胞证
     */
    TAIWAN_CARD(5, "台胞证"),

    /**
     * 回乡证
     */
    RETURN_HOME_CARD(6, "回乡证"),

    /**
     * 回乡证
     */
    other(7, "其他");

    private int key;

    private String value;

    IdCardTypeEnum(int key, String value) {
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
        for (IdCardTypeEnum ts : IdCardTypeEnum.values()) {
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
        for (IdCardTypeEnum ts : IdCardTypeEnum.values()) {
            if (value.equals(ts.getValue())) {
                return ts.getKey();
            }
        }
        return null;
    }
}