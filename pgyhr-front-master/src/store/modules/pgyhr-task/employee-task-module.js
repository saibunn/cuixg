import employeeTaskApi from "../../../api/pgyhr-task/employee_task_api";
import Util from "../../../libs/util";
import employeeTaskSheetTypes from "../../event-types/pgyhr-task/employee_task_sheet_types";
import companyTypes from "../../event-types/pgyhr-company/company-types";
import companyApi from "../../../api/pgyhr-company/company-api";

const namespaced = true;
// UI组件所有状态数据
const state = {
    rows: [], // alias list
    empCompany:[],
    empTaskList:[],

    empTaskPage: {
        total: 0,
        size: Util.DEFAULT_PAGE_SIZE,
        currentPage: 1,
    },
    empCompanyTaskPage: {
        total: 0,
        size: Util.DEFAULT_PAGE_SIZE,
        currentPage: 1,
    },
    searchForm:{},

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
        return employeeTaskApi.getEmployeeTaskSheetListPage(pageParams).then(response => {
                commit(employeeTaskSheetTypes.MUTATE_SEARCH_EMPLOYEE_TASK_SHEET_PAGE, response.result)
            }
        )
    },

    [employeeTaskSheetTypes.SAVE_EMPLOYEE_INFO]({commit}, params){
        console.log("this.SAVE_EMPLOYEE_INFO=================="+JSON.stringify(params));
        return employeeTaskApi.saveEmployeeInfo(params);
    },

    /*模糊查询分页，雇员信息*/
    [employeeTaskSheetTypes.EMPLOYEE_PAGE]({commit}, params){
        console.log("this.EMPLOYEE_PAGE=================="+JSON.stringify(params));
        return employeeTaskApi.getEmployeePage(params).then(response => {
                commit(employeeTaskSheetTypes.EMPLOYEE_PAGE, response.result)
            }
        )
    },

    /*按ID查询雇员信息*/
    [employeeTaskSheetTypes.QUERY_EMPLOYEE_ID]({commit},params){
        console.log("this.QUERY_EMPLOYEE_ID=================="+JSON.stringify(params));
        return employeeTaskApi.getEmployeeId(params);
    },

    /*修改雇员信息*/
    [employeeTaskSheetTypes.UPDATE_EMPLOYEE_INFO]({commit}, params){
        console.log("this.UPDATE_EMPLOYEE_INFO=================="+JSON.stringify(params));
        return employeeTaskApi.updEmployeeInfo(params);
    },

    [employeeTaskSheetTypes.EMPCOMPANY_PAGE]({commit}, params){
        console.log("this.EMPCOMPANY_PAGE=================="+JSON.stringify(params));
        return employeeTaskApi.getEMPCompanyPage(params).then(response => {
                commit(employeeTaskSheetTypes.EMPCOMPANY_PAGE, response.result)
            }
        )
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
    [employeeTaskSheetTypes.EMPLOYEE_PAGE](state, result){
        console.log("EMPLOYEE_PAGE======result============"+JSON.stringify(result));
        var list = result.records;
        state.rows = list;
        console.log("EMPLOYEE_PAGE=========state.rows========="+JSON.stringify(state.rows));
        state.empTaskPage.total = result.total;
    },
    [employeeTaskSheetTypes.EMPCOMPANY_PAGE](state, result){
        console.log("EMPCOMPANY_PAGE======result============"+JSON.stringify(result));
        var list = result.records;
        state.empCompany = list;
        console.log("EMPCOMPANY_PAGE=========state.rows========="+JSON.stringify(state.empCompany));
        state.empCompanyTaskPage.total = result.total;
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
