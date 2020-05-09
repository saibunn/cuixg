package com.pgyhr.task.entity.enums;

/**
 * @author xiaoguang cui
 * @date 2020/5/2
 */
public enum TaskStatusEnum {

    /**
     * 后道批退
     */
    BACK_REJECTE(0, "后道批退"),

    /**
     * 前道提交
     */
    FRONT_SEND(1, "前道提交"),

    /**
     * 后道客服确认
     */
    BACK_SERVICE_CONFIRM(2, "后道客服确认"),

    /**
     * 后道专员确认
     */
    BACK_COMMISSIONER_CONFIRM(3, "后道专员确认"),

    /**
     * 后道部分完成
     */
    BACK_PARTIALLY_COMPLETE(4, "后道部分完成"),

    /**
     * 后道完成
     */
    BACK_COMPLETE(5, "后道完成");

    private int key;

    private String value;

    TaskStatusEnum(int key, String value) {
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
        for (TaskStatusEnum ts : TaskStatusEnum.values()) {
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
        for (TaskStatusEnum ts : TaskStatusEnum.values()) {
            if (value.equals(ts.getValue())) {
                return ts.getKey();
            }
        }
        return null;
    }
}