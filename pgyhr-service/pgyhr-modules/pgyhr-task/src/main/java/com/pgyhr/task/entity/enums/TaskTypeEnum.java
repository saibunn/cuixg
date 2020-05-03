package com.pgyhr.task.entity.enums;

/**
 * 任务单类型:0-新增,1-调整,2-年度调整,3-终止,4-一次性费用,5-服务费调整
 *
 * @author xiaoguang cui
 * @date 2020/5/2
 */
public enum TaskTypeEnum {

    NEW(0, "新增"),

    ADJUST(1, "调整"),

    ANNUAL_ADJUST(2, "年度调整"),

    TERMINATION(3, "终止"),

    ONCE_FEE(4, "一次性费用"),

    SERVICE_FEE_ADJUST(5, "服务费调整");

    private int key;

    private String value;

    TaskTypeEnum(int key, String value) {
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
        for (TaskTypeEnum ts : TaskTypeEnum.values()) {
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
        for (TaskTypeEnum ts : TaskTypeEnum.values()) {
            if (value.equals(ts.getValue())) {
                return ts.getKey();
            }
        }
        return null;
    }

}
