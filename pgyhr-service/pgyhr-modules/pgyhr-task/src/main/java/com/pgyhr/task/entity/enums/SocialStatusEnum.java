package com.pgyhr.task.entity.enums;

/**
 * @author xiaoguang cui
 * @date 2020/5/9
 */
public enum SocialStatusEnum {

    /**
     * 取消办理
     */
    PROCESS_CANCEL(0, "取消办理"),

    /**
     * 办理成功
     */
    PROCESS_DONE(1, "办理成功"),

    /**
     * 办理中
     */
    IN_PROCESS(2, "办理中");


    private int key;

    private String value;

    SocialStatusEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public static Integer getKeyByValue(Object value) {
        if (value == null) {
            return null;
        }

        for (SocialStatusEnum ts : SocialStatusEnum.values()) {
            if (ts.getValue().equals(value)) {
                return ts.getKey();
            }
        }
        return null;
    }

    public static String getValueByKey(Integer key) {
        if (key == null) {
            return null;
        }
        for (SocialStatusEnum ts : SocialStatusEnum.values()) {
            if (ts.getKey() == key) {
                return ts.getValue();
            }
        }
        return null;
    }
}
