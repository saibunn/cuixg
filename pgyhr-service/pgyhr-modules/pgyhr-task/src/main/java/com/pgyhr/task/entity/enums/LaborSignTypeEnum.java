package com.pgyhr.task.entity.enums;

/**
 *
 * @author xiaoguang cui
 * @date 2020/5/2
 */
public enum LaborSignTypeEnum {

    /**
     * 新订
     */
    NEW_SIGN(1, "新订"),

    /**
     * 续订
     */
    RENEW(2, "续订"),

    /**
     * 变更
     */
    CHANGE(3, "变更"),

    /**
     * 助理级技术职务
     */
    NOT_SUBSCRIBED(4, "未订");

    private int key;

    private String value;

    LaborSignTypeEnum(int key, String value) {
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
        for (LaborSignTypeEnum ts : LaborSignTypeEnum.values()) {
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
        for (LaborSignTypeEnum ts : LaborSignTypeEnum.values()) {
            if (value.equals(ts.getValue())) {
                return ts.getKey();
            }
        }
        return null;
    }
}
