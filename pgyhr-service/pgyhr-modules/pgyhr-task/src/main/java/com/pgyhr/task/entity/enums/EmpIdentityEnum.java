package com.pgyhr.task.entity.enums;

/**
 *
 * @author xiaoguang cui
 * @date 2020/5/2
 */
public enum EmpIdentityEnum {

    /**
     * 工人
     */
    WORKERS(1, "工人"),

    /**
     * 原工商业者
     */
    FORMER_INDUSTRIAL_AND_COMMERCIAL_WORKERS(2, "原工商业者"),

    /**
     * 农民
     */
    FARMERS(3, "农民"),

    /**
     * 学生
     */
    STUDENTS(4, "学生"),

    /**
     * 干部
     */
    CADRES(5, "干部"),

    /**
     * 现役军人
     */
    ACTIVE_SERVICEMEN(6, "现役军人"),

    /**
     * 无业人员
     */
    UNEMPLOYED_PERSONS(7, "无业人员"),

    /**
     * 其他
     */
    OTHERS(8, "其他");

    private int key;

    private String value;

    EmpIdentityEnum(int key, String value) {
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
        for (EmpIdentityEnum ts : EmpIdentityEnum.values()) {
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
        for (EmpIdentityEnum ts : EmpIdentityEnum.values()) {
            if (value.equals(ts.getValue())) {
                return ts.getKey();
            }
        }
        return null;
    }
}
