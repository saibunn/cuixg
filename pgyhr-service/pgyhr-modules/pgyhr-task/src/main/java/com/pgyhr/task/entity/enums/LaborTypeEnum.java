package com.pgyhr.task.entity.enums;

/**
 *
 * @author xiaoguang cui
 * @date 2020/5/2
 */
public enum LaborTypeEnum {

    /**
     * 固定期限劳动合同
     */
    FIXED_TERM_LABOR_CONTRACT(1, "固定期限劳动合同"),

    /**
     * 无固定期限劳动合同
     */
    UNFIXED_TERM_LABOR_CONTRACT(2, "无固定期限劳动合同"),

    /**
     * 完成一定工作为期限劳动合同
     */
    TERM_LABOR_CONTRACT_FOR_COMPLETING_CERTAIN_WORK(3, "完成一定工作为期限劳动合同"),

    /**
     * 非全日制劳动合同
     */
    PART_TIME_LABOR_CONTRACT(4, "非全日制劳动合同");

    private int key;

    private String value;

    LaborTypeEnum(int key, String value) {
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
        for (LaborTypeEnum ts : LaborTypeEnum.values()) {
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
        for (LaborTypeEnum ts : LaborTypeEnum.values()) {
            if (value.equals(ts.getValue())) {
                return ts.getKey();
            }
        }
        return null;
    }
}
