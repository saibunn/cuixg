import employeeTaskApi from "../../../api/pgyhr-task/employee_task_api";
import Util from "../../../libs/util";
import empFrontTaskSheetSocialFeeSegmentTypes from "../../event-types/pgyhr-task/emp_front_task_sheet_social_fee_segment_types";

const namespaced = true;
// UI组件所有状态数据
const state = {
    rows: [], // alias list
    empFrontTaskSheetSocialFeeSegmentList:[],
    empFrontTaskSheetSocialFeeSegmentParam:{
        cityCode:''
    },
    searchForm:{},

    title: "雇员前道任务单社保明细",
};

// 收集UI组件的所有事件，可以同步也可以异步提交
const actions = {

    // [socialPolicytypes.SEARCH_SOCIAL_POLICY_BY_PARAM]({commit}, params){
    //     return socialPolicyApi.getSocialPolicyByParam(params).then(response => {
    //         commit(socialPolicytypes.SEARCH_SOCIAL_POLICY_BY_PARAM, response.result)
    //     })
    // },

    [empFrontTaskSheetSocialFeeSegmentTypes.SEARCH_EMP_FRONT_TASK_SHEET_SOCIAL_FEE_SEGMENT]({commit, state}, payload){
        employeeTaskApi.getEmpFrontTaskSheetSocialFeeSegmentByParam(payload)
            .then(response => {
                //console.log("SEARCH_SOCIAL_POLICY_BY_PARAM======result============"+JSON.stringify(response.result));
                if (response.code == 200) {
                    commit(empFrontTaskSheetSocialFeeSegmentTypes.MUTATE_SEARCH_EMP_FRONT_TASK_SHEET_SOCIAL_FEE_SEGMENT, response.result)
                } else {
                    throw(response.message);
                }
            }).catch(error => {
            console.log(error)
        });
    },

};

// 更改组件状态
const mutations = {
    [empFrontTaskSheetSocialFeeSegmentTypes.MUTATE_SEARCH_EMP_FRONT_TASK_SHEET_SOCIAL_FEE_SEGMENT](state, result){

        state.empFrontTaskSheetSocialFeeSegmentList = result;
        console.log("MUTATE_SEARCH_EMP_FRONT_TASK_SHEET_SOCIAL_FEE_SEGMENT======result============"+JSON.stringify(state.empFrontTaskSheetSocialFeeSegmentList));
    },

};

// UI 组件数据
const getters = {
    getRows: state => state.rows,
};

export default {
    namespaced: namespaced,
    state,
    actions,
    mutations,
    getters,
};
