package com.pgyhr.task.entity.enums;

/**
 *
 * @author xiaoguang cui
 * @date 2020/5/2
 */
public enum AdministrativePostEnum {

    /**
     * 无行政职务级别
     */
    NO_ADMINISTRATIVE_POST_LEVEL(1, "无行政职务级别"),

    /**
     * 部长级
     */
    MINISTERIAL_LEVEL(2, "部长级"),

    /**
     * 相当部长级
     */
    EQUIVALENT_MINISTERIAL_LEVEL(3, "相当部长级"),

    /**
     * 副部长级
     */
    DEPUTY_MINISTERIAL_LEVEL(4, "副部长级"),

    /**
     * 相当副部长级
     */
    EQUIVALENT_DEPUTY_MINISTERIAL_LEVEL(5, "相当副部长级"),

    /**
     * 司局级
     */
    DEPARTMENT_LEVEL(6, "司局级"),

    /**
     * 巡视员
     */
    INSPECTOR(7, "巡视员"),

    /**
     * 相当司局级
     */
    EQUIVALENT_DEPARTMENT_LEVEL(8, "相当司局级"),

    /**
     * 副司局级
     */
    DEPUTY_DEPARTMENT_LEVEL(9, "副司局级"),

    /**
     * 助理巡视员
     */
    ASSISTANT_INSPECTOR(10, "助理巡视员"),

    /**
     * 相当副司局级
     */
    DEPARTMENT_AND_BUREAU(11, "相当副司局级"),

    /**
     * 处级
     */
    RANK_OF_SECTION_CHIEF(12, "处级");

    private int key;

    private String value;

    AdministrativePostEnum(int key, String value) {
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
        for (AdministrativePostEnum ts : AdministrativePostEnum.values()) {
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
        for (AdministrativePostEnum ts : AdministrativePostEnum.values()) {
            if (value.equals(ts.getValue())) {
                return ts.getKey();
            }
        }
        return null;
    }
}
