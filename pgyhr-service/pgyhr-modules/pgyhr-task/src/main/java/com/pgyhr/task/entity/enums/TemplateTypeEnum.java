package com.pgyhr.task.entity.enums;

/**
 * 客户公司服务性质枚举
 * Created by NeoJiang on 2018/1/18.
 *
 * @author NeoJiang
 */
public enum TemplateTypeEnum {

    /**
     * 派遣
     */
    DISPATCH(1, "派遣"),

    /**
     * 代理
     */
    DELEGATE(2, "代理"),

    /**
     * 业务外包
     */
    BUSINESS_OUTSOURCE(3, "业务外包");

    private int key;

    private String value;

    TemplateTypeEnum(int key, String value) {
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
        for (TemplateTypeEnum ts : TemplateTypeEnum.values()) {
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
        for (TemplateTypeEnum ts : TemplateTypeEnum.values()) {
            if (value.equals(ts.getValue())) {
                return ts.getKey();
            }
        }
        return null;
    }
}
