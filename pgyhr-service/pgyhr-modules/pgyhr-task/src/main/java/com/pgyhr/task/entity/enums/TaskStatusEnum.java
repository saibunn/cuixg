package com.pgyhr.task.entity.enums;

/**
 * @author xiaoguang cui
 * @date 2020/5/2
 */
public enum TaskStatusEnum {

    /**
     * 取消委托
     */
    ENTRUST_CANCEL(0, "取消委托"),

    /**
     * 委托成功
     */
    ENTRUST_DONE(1, "委托成功"),

    /**
     * 委托办理
     */
    ENTRUST_PROCESS(2, "委托办理");

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