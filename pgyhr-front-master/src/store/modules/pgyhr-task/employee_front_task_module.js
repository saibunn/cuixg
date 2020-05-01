import employeeTaskApi from "../../../api/pgyhr-task/employee_front_task_api";
import Util from "../../../libs/util";
import employeeTaskSheetTypes from "../../event-types/pgyhr-task/employee_front_task_sheet_types";

const namespaced = true;
// UI组件所有状态数据
const state = {
    rows: [], // alias list
    empTaskList:[],

    empTaskPage: {
        total: 0,
        size: Util.DEFAULT_PAGE_SIZE,
        currentPage: 1,
    },
    searchForm:{},


    empFrontTaskForSubmit:{
        organizationAgreementProductRelationRequestDTOList:[],
        taskSheetServiceProductFeeSegmentRequestDTOList:[],
        taskSheetSocialFeeSegmentRequestDTOList:[],
    },

    title: "雇员任务单",
};

// 收集UI组件的所有事件，可以同步也可以异步提交
const actions = {

    [employeeTaskSheetTypes.SEARCH_EMPLOYEE_TASK_SHEET_PAGE]({commit}, params){
        const pageParams = {
            ...state.searchForm,
            size: state.empTaskPage.size,
            currentPage: state.empTaskPage.currentPage
        };

        console.log("this.SEARCH_EMPLOYEE_TASK_SHEET_PAGE=================="+JSON.stringify(pageParams));
        return employeeTaskApi.getEmployeeTaskSheetListPage(params).then(response => {
                commit(employeeTaskSheetTypes.MUTATE_SEARCH_EMPLOYEE_TASK_SHEET_PAGE, response.result)
            }
        )
    },

    [employeeTaskSheetTypes.SAVE_EMPLOYEE_INFO]({commit}, params){
        console.log("this.SAVE_EMPLOYEE_INFO=================="+JSON.stringify(params));
        return employeeTaskApi.saveEmployeeInfo(params);
    },

    [employeeTaskSheetTypes.SAVE_EMPLOYEE_TASK_SHEET_INFO]({commit}, params){
        console.log("this.SAVE_EMPLOYEE_TASK_SHEET_INFO=================="+JSON.stringify(params));
        return employeeTaskApi.saveNewEmployeeTaskSheetInfo(params);
    },

};

// 更改组件状态
const mutations = {
    [employeeTaskSheetTypes.MUTATE_SEARCH_EMPLOYEE_TASK_SHEET_PAGE](state, result){
        console.log("MUTATE_SEARCH_EMPLOYEE_TASK_SHEET_PAGE======result============"+JSON.stringify(result));
        // var list = result;
        // state.empTaskList = list;
        // console.log("COMPANY_PAGE=========state.rows========="+JSON.stringify(state.rows));
        // state.empTaskPage.total = result.total;
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
