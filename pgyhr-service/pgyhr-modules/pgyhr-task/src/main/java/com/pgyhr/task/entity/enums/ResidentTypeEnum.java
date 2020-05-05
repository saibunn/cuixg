package com.pgyhr.task.entity.enums;

/**
 * package: com.ciicsh.gto.agentcenter.site.service.entity.enums
 * describe: TODO
 * creat_user: cuixiaoguang
 * creat_date: 2018/2/5
 * creat_time: 15:24
 **/
public enum ResidentTypeEnum {

    /**
     * 非农业户口
     */
    NON_AGRICULTURE(1, "非农业户口"),

    /**
     * 农业户口
     */
    AGRICULTURE(2, "农业户口");

    private int key;

    private String value;

    ResidentTypeEnum(int key, String value) {
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
        for (ResidentTypeEnum ts : ResidentTypeEnum.values()) {
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
        for (ResidentTypeEnum ts : ResidentTypeEnum.values()) {
            if (value.equals(ts.getValue())) {
                return ts.getKey();
            }
        }
        return null;
    }
}