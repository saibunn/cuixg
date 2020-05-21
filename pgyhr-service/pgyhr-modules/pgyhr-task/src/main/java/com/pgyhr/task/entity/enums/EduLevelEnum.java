package com.pgyhr.task.entity.enums;

/**
 *
 * @author xiaoguang cui
 * @date 2020/5/2
 */
public enum EduLevelEnum {

    /**
     * 博士后
     */
    POSTDOCTORAL(1, "博士后"),

    /**
     * 博士研究生
     */
    DOCTORAL(2, "博士研究生"),

    /**
     * 硕士
     */
    MASTERS(3, "硕士"),

    /**
     * 硕士研究生
     */
    POSTGRADUATE(4, "硕士研究生"),

    /**
     * 大学本科
     */
    UNDERGRADUATE(5, "大学本科"),

    /**
     * 大学专科
     */
    SPECIALTY_COLLEGE(6, "大学专科"),

    /**
     * 中专
     */
    SECONDARY_COLLEGE(7, "中专"),

    /**
     * 中等专科
     */
    JUNIOR_COLLEGE(8, "中等专科"),

    /**
     * 职业高中
     */
    VOCATIONAL_HIGH_SCHOOL(9, "职业高中"),

    /**
     * 技工学校
     */
    TECHNICAL_SCHOOL(10, "技工学校"),

    /**
     * 技校
     */
    TECHNICAL(11, "技校"),

    /**
     * 普通高中
     */
    GENERAL_HIGH_SCHOOL(12, "普通高中"),

    /**
     * 职高
     */
    VOCATIONAL_HIGH(13, "职高"),

    /**
     * '职专
     */
    VOCATIONAL_SCHOOL(14, "'职专"),

    /**
     * 初中
     */
    JUNIOR_HIGH_SCHOOL(15, "初中"),

    /**
     * 小学
     */
    PRIMARY_SCHOOL(16, "小学"),

    /**
     * 文盲或半文盲
     */
    ILLITERATE_OR_SEMI_ILLITERATE(17, "文盲或半文盲"),

    /**
     * 其他
     */
    OTHERS(18, "其他");

    private int key;

    private String value;

    EduLevelEnum(int key, String value) {
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
        for (EduLevelEnum ts : EduLevelEnum.values()) {
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
        for (EduLevelEnum ts : EduLevelEnum.values()) {
            if (value.equals(ts.getValue())) {
                return ts.getKey();
            }
        }
        return null;
    }
}
