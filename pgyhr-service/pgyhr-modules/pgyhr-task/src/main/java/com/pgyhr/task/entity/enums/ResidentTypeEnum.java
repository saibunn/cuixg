package com.pgyhr.task.entity.enums;

/**
 * package: com.ciicsh.gto.agentcenter.site.service.entity.enums
 * describe: TODO
 * creat_user: cuixiaoguang
 * creat_date: 2020/5/19
 * creat_time: 15:24
 **/
public enum ResidentTypeEnum {

    /**
     * 非农业户口
     */
    LOCAL_TOWN(1, "本地城镇"),

    /**
     * 省内市外
     */
    PROVINCE(2, "省内市外"),

    /**
     * 本地农业
     */
    LOCAL_AGRICULTURE(3, "本地农业"),

    /**
     * 外省
     */
    OUTSIDE_PROVINCE(4, "外省"),

    /**
     * 其他
     */
    OTHER(5, "其他");

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