package com.pgyhr.task.entity.enums;

/**
 * 任务单状态
 *
 * @author xiaoguang cui
 * @date 2020/5/2
 */
public enum TaskStatusEnum {

    /**
     * 委托批退
     */
    ENTRUST_RETURN(0, "委托批退"),

    /**
     * 前道提交
     */
    CSC_SUBMIT(1, "前道提交"),

    /**
     * 委托提交
     */
    ENTRUST_SUBMIT(2, "委托提交"),

    /**
     * 受托批退
     */
    BE_ENTRUST_RETURN(3, "受托批退"),

    /**
     * 受托处理
     */
    BE_ENTRUST_DISPOSE(4, "受托处理"),

    /**
     * 受托部分完成
     */
    BE_ENTRUST_PART_COMPLETED(5, "受托部分完成"),

    /**
     * 受托完成
     */
    BE_ENTRUST_COMPLETED(6, "受托完成");


    private int key;

    private String value;

    TaskStatusEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public static Integer getKeyByValue(Object value) {
        if (value == null) {
            return null;
        }
        for (TaskStatusEnum ts : TaskStatusEnum.values()) {
            if (ts.getValue().equals(value)) {
                return ts.getKey();
            }
        }
        return null;
    }

    public static String getValueByKey(Integer key) {
        if (key == null) {
            return null;
        }
        for (TaskStatusEnum ts : TaskStatusEnum.values()) {
            if (ts.getKey() == key) {
                return ts.getValue();
            }
        }
        return null;
    }

}
