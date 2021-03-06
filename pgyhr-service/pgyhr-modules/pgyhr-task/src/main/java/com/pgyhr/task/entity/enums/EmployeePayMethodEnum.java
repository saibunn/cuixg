package com.pgyhr.task.entity.enums;

/**
 *
 * @author xiaoguang cui
 * @date 2020/5/2
 */
public enum EmployeePayMethodEnum{

    /**
     * 服务费
     */
    SERVICE_FEE(1, "服务费"),

    /**
     * 公司自付
     */
    COMPANY_PAY(2, "公司自付"),

    /**
     * 个人工资自付
     */
    PERSONAL_WAGE(3, "个人工资自付");

    private int key;

    private String value;

    EmployeePayMethodEnum(int key, String value) {
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
        for (EmployeePayMethodEnum ts : EmployeePayMethodEnum.values()) {
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
        for (EmployeePayMethodEnum ts : EmployeePayMethodEnum.values()) {
            if (value.equals(ts.getValue())) {
                return ts.getKey();
            }
        }
        return null;
    }
}
