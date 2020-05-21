package com.pgyhr.task.entity.enums;

/**
 *
 * @author xiaoguang cui
 * @date 2020/5/2
 */
public enum TechnicalPostEnum {

    /**
     * 正高级技术职务
     */
    SENIOR_TECHNICAL_POSITION(1, "正高级技术职务"),

    /**
     * 副高级技术职务
     */
    DEPUTY_SENIOR_TECHNICAL_POSITION(2, "副高级技术职务"),

    /**
     * 中级技术职务
     */
    INTERMEDIATE_TECHNICAL_POSITION(3, "中级技术职务"),

    /**
     * 助理级技术职务
     */
    ASSISTANT_TECHNICAL_POSITION(4, "助理级技术职务"),

    /**
     * 员级技术职务
     */
    PERSONNEL_TECHNICAL_POSITION(5, "员级技术职务"),

    /**
     * 职改前工程师
     */
    ENGINEER_BEFORE_JOB_CHANGE(6, "职改前工程师"),

    /**
     * 未评定技术职务
     */
    NOT_EVALUATED_TECHNICAL_POSITION(7, "未评定技术职务");

    private int key;

    private String value;

    TechnicalPostEnum(int key, String value) {
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
        for (TechnicalPostEnum ts : TechnicalPostEnum.values()) {
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
        for (TechnicalPostEnum ts : TechnicalPostEnum.values()) {
            if (value.equals(ts.getValue())) {
                return ts.getKey();
            }
        }
        return null;
    }
}
