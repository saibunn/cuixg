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
    addEmployeeInfo:{},
    employeeInfo:{},

    selectedEmpTaskInfo:{},

    empFrontTaskForSubmit:{
        organizationAgreementProductRelationRequestDTOList:[],
        taskSheetServiceProductFeeSegmentRequestDTOList:[],
        taskSheetSocialFeeSegmentRequestDTOList:[],
    },

    empFrontTaskSheetDetail: {

    },

    empFrontTaskSheetSocialFeeSegment: [],

    title: "雇员任务单",
};

// 收集UI组件的所有事件，可以同步也可以异步提交
const actions = {

    // [employeeTaskSheetTypes.SEARCH_EMPLOYEE_TASK_SHEET_PAGE]({state, commit}){
    //     const params = {
    //         ...state.searchForm,
    //         size: state.empTaskPage.size,
    //         currentPage: state.empTaskPage.currentPage
    //     };
    //     console.log("...state.searchForm.currentPage"+JSON.stringify(params));
    //     EntrustSearchApi.getEntrustTaskSheetListPage(params)
    //         .then(response => {
    //             console.log(response);
    //             const responseData = response.data;
    //             if (responseData.code === 0) {
    //                 commit(EntrustTaskSheetTypes.MUTATE_TASK_SHEET_PAGE, responseData.object)
    //             } else {
    //                 throw(responseData.message);
    //             }
    //         }).catch(error => {
    //         console.log(error)
    //     })
    // },

    [employeeTaskSheetTypes.SEARCH_EMPLOYEE_TASK_SHEET_PAGE]({commit}, params){
        const pageParams = {
            ...state.searchForm,
            size: state.empTaskPage.size,
            currentPage: state.empTaskPage.currentPage
        };

        console.log("this.SEARCH_EMPLOYEE_TASK_SHEET_PAGE==rrrrrrr================"+JSON.stringify(pageParams));
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

    [employeeTaskSheetTypes.GET_EMP_TASK_SHEET_EMPLOYEE_INFO]({state, commit}) {
        const config = {
            params: {
                selectedEmpTaskInfo: state.selectedEmpTaskInfo,
            }
        }
        employeeTaskApi.getEmployeeInfo(config)
            .then(response => {
                const responseData = response.result;
                if (responseData.code === 200) {
                    commit(employeeTaskSheetTypes.MUTATE_GET_EMP_TASK_SHEET_EMPLOYEE_INFO, response.result);
                } else {
                    throw (responseData.message)
                }
            }).catch(error => {
            console.log(error)
        })
    },

    [employeeTaskSheetTypes.GET_EMPLOYEE_TASK_SHEET_DETAIL] ({state, commit}) {
        const config = {
            params: {
                selectedEmpTaskInfo: state.selectedEmpTaskInfo,
            }
        };

        return employeeTaskApi.getEmployeeTaskSheetDetail(state.selectedEmpTaskInfo).then(response => {
                commit(employeeTaskSheetTypes.MUTATE_GET_EMPLOYEE_TASK_SHEET_DETAIL, response.result)
            }
        )
    },

    [employeeTaskSheetTypes.GET_EMPLOYEE_TASK_SHEET_SOCIAL_FEE_SEGMENT]({state, commit}) {
        const config = {
            params: {
                selectedEmpTaskInfo: state.selectedEmpTaskInfo,
            }
        };
        employeeTaskApi.getEmployeeTaskSheetSocialFeeSegment(config)
            .then(response => {
                const responseData = response.result;
                if (responseData.code ===200) {
                    commit(employeeTaskSheetTypes.MUTATE_GET_EMPLOYEE_TASK_SHEET_SOCIAL_FEE_SEGMENT, responseData)
                } else {
                    throw (responseData.message)
                }
            }).catch(error => {
            console.log(error)
        })
    },

};

// 更改组件状态
const mutations = {
    [employeeTaskSheetTypes.MUTATE_SEARCH_EMPLOYEE_TASK_SHEET_PAGE](state, result){

        var list = result;
        state.empTaskList = list.records;
        state.empTaskPage.total = result.total;
        console.log("MUTATE_SEARCH_EMPLOYEE_TASK_SHEET_PAGE======result=====aaaaaqqq======="+JSON.stringify(list));
    },


    [employeeTaskSheetTypes.MUTATE_ADD_EMPLOYEE_INFO](state, data){
        state.addEmployeeInfo = data;
    },

    [employeeTaskSheetTypes.MUTATE_SEARCH_EMPLOYEE_TASK_SHEET_PARAM](state, data){
        console.log("MUTATE_SEARCH_EMPLOYEE_TASK_SHEET_PARAM======result============"+JSON.stringify(data));
        state.searchForm = data;
    },

    [employeeTaskSheetTypes.MUTATE_SELECTED_EMPLOYEE_TASK_SHEET_INFO](state, data){
        state.selectedEmpTaskInfo = data;
    },

    [employeeTaskSheetTypes.MUTATE_EMPLOYEE_TASK_SHEET_CURRENT_PAGE](state, data){
        state.empTaskPage.currentPage = data;
    },

    [employeeTaskSheetTypes.MUTATE_GET_EMPLOYEE_TASK_SHEET_DETAIL] (state, data) {
        //console.log("MUTATE_GET_EMPLOYEE_TASK_SHEET_DETAIL======result============"+JSON.stringify(data));
        state.empFrontTaskSheetDetail = data.empFrontTaskSheetResponseDTO;
        state.taskSheetSocialFeeInfo = data.empFrontTaskSheetSocialFeeSegmentResponseDTOList;
        state.employeeInfo = data.employeeInfoResponseDTO;
        console.log("taskSheetSocialFeeInfo======result============"+JSON.stringify(state.taskSheetSocialFeeInfo));


    },

    [employeeTaskSheetTypes.GET_EMPLOYEE_TASK_SHEET_SOCIAL_FEE_SEGMENT] (state, data) {
        state.taskSheetSocialFeeInfo = data
    },

    [employeeTaskSheetTypes.MUTATE_GET_EMP_TASK_SHEET_EMPLOYEE_INFO] (state, data) {
        state.employeeInfo = data
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
