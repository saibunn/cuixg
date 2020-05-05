package com.pgyhr.task.entity.enums;

/**
 * @author xiaoguang cui
 * @date 2020/5/2
 */
public enum RetreatStatusEnum {

    /**
     * 正常
     */
    RETREAT_NORMAL(0, "正常"),

    /**
     * 未处理
     */
    RETREAT_UNDONE(1, "未处理"),

    /**
     * 已拒绝
     */
    RETREAT_REJECTED(2, "已拒绝"),

    /**
     * 已批退
     */
    ENTRUST_APPROVED(3, "已批退");



    private int key;

    private String value;

    RetreatStatusEnum(int key, String value) {
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
        for (RetreatStatusEnum ts : RetreatStatusEnum.values()) {
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
        for (RetreatStatusEnum ts : RetreatStatusEnum.values()) {
            if (value.equals(ts.getValue())) {
                return ts.getKey();
            }
        }
        return null;
    }
}