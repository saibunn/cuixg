package com.pgyhr.task.entity.enums;

/**
 *
 * @author xiaoguang cui
 * @date 2020/5/2
 */
public enum EmpTypeEnum {

    /**
     * 新成长失业人员
     */
    NEW_GROWTH_UNEMPLOYED(1, "新成长失业人员"),

    /**
     * 就业转失业人员
     */
    EMPLOYMENT_TO_UNEMPLOYED(2, "就业转失业人员"),

    /**
     * 其他失业人员
     */
    OTHER_UNEMPLOYED(3, "其他失业人员"),

    /**
     * 在业人员
     */
    EMPLOYED(4, "在业人员"),

    /**
     * 退休人员
     */
    RETIREES(5, "退休人员"),

    /**
     * 在学人员
     */
    STUDENTS(6, "在学人员"),

    /**
     * 退伍军人
     */
    VETERANS(7, "退伍军人"),

    /**
     * 农村劳动力
     */
    RURAL_LABOR(8, "农村劳动力"),

    /**
     * 外来劳动力
     */
    MIGRANT_LABOR(9, "外来劳动力"),

    /**
     * 其他
     */
    OTHERS(10, "其他");

    private int key;

    private String value;

    EmpTypeEnum(int key, String value) {
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
        for (EmpTypeEnum ts : EmpTypeEnum.values()) {
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
        for (EmpTypeEnum ts : EmpTypeEnum.values()) {
            if (value.equals(ts.getValue())) {
                return ts.getKey();
            }
        }
        return null;
    }
}
