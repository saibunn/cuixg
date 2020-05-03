package com.pgyhr.task.entity.enums;

/**
 * 离职原因：1: 辞职,2: 协商解除,3: 公司解聘,4: 合同到期,5: 关闭,6: 出国,7: 退休,8: 工伤死亡,// 9: 取消入职,10: 死亡,11: 转科技人才,12: 转用工单位（翻牌）,13: 公司自行管理, 无需退工,14: 公司自行管理, 需办退工,15: 转其他公司管理, 无需退工,16: 转其他公司管理, 需办退工
 *
 *
 * @author xiaoguang cui
 * @date 2020/5/2
 */
public enum TerminationReasonEnum{

    /**
     * 辞职
     */
    RESIGN(1, "辞职"),

    /**
     * 协商解除
     */
    NEGOTIATED_TERMINATION(2, "协商解除"),


    /**
     * 公司解聘
     */
    DISMISSAL(3, "公司解聘"),

    /**
     * 合同到期
     */
    CONTRACT_EXPIRES(4, "合同到期"),

    /**
     * 关闭
     */
    CLOSE(5, "关闭"),

    /**
     * 出国
     */
    ABROAD(6, "出国"),

    /**
     * 退休
     */
    RETIRED(7, "退休"),

    /**
     * 退休
     */
    WORK_INJURIES(8, "工伤死亡"),

    /**
     * 退休
     */
    CANCELLATION_OF_ENTRY_NOTICE(9, "取消入职通知"),

    /**
     * 退休
     */
    DEATH(10, "死亡"),

    /**
     * 退休
     */
    TRANSFER_SCIENCE(11, "转科技人才"),


    /**
     * 退休
     */
    TRANSFER_UNIT(12, "转用工单位（翻牌）"),

    /**
     * 退休
     */
    SELF_MANAGEMENT_OF_THE_COMPANY(13, "公司自行管理，无需退工"),

    /**
     * 退休
     */
    SELF_MANAGEMENT_OF_THE_COMPANY_RETURN(14, "公司自行管理，需办退工"),

    /**
     * 退休
     */
    TRANSFER_TO_OTHER_COMPANIES(15, "转其他公司管理，无需退工,16: 转其他公司管理，无需退工"),

    /**
     * 转其他公司管理，需办退工
     */
    TRANSFER_TO_OTHER_COMPANIES_RETURN(16, "转其他公司管理，需办退工"),

    /**
     * 转其他公司管理，需办退工
     */
    TRANSFER_TO_OTHER_ORGANIZATION(17, "转其他机构缴纳");

    private int key;

    private String value;

    TerminationReasonEnum(int key, String value) {
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
        for (TerminationReasonEnum ts : TerminationReasonEnum.values()) {
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
        for (TerminationReasonEnum ts : TerminationReasonEnum.values()) {
            if (value.equals(ts.getValue())) {
                return ts.getKey();
            }
        }
        return null;
    }

}