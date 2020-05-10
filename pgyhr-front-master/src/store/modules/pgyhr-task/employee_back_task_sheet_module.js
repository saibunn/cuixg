import employeeBackTaskSheetApi from "../../../api/pgyhr-task/employee_back_task_sheet_api";
import Util from "../../../libs/util";
import empBackTaskSheetTypes from "../../event-types/pgyhr-task/emp_back_task_sheet_types";
import axios from 'axios';
import employeeTaskApi from "../../../api/pgyhr-task/employee_front_task_api";

const namespaced = true;

const state = {
  searchForm:{},
  selectedEmpBackTaskInfo:{},
  pagination: {
    total: 0,
    size: 10,
    currentPage: 1
  },

  employeeInfo:{},
  taskSheetDetail:{
    taskStatus:1,
  },

  formForSubmit:{
  },

  taskSheetList:[],

  empBackTaskSheetDetail: {
    taskStatus:1,
  },
  empBackTaskSheetSocialFeeInfo: [],


};


// 收集UI组件的所有事件，可以同步也可以异步提交
const actions = {

  [empBackTaskSheetTypes.SEARCH_TASK_SHEET_PAGE]({commit}, params){
    const pageParams = {
      ...state.searchForm,
      size: state.pagination.size,
      currentPage: state.pagination.currentPage
    };
    console.log("...state.searchForm.currentPage"+JSON.stringify(pageParams));

    return employeeBackTaskSheetApi.getQueryEmployeeBackTaskSheetListPage(pageParams).then(response => {
          commit(empBackTaskSheetTypes.MUTATE_SEARCH_TASK_SHEET_PAGE, response.result)
        }
    )

  },

  [empBackTaskSheetTypes.GET_EMPLOYEE_BACK_TASK_SHEET_DETAIL] ({state, commit}) {

    console.log("GET_EMPLOYEE_BACK_TASK_SHEET_DETAIL"+JSON.stringify(state.selectedEmpBackTaskInfo));
    return employeeBackTaskSheetApi.getEmployeeBackTaskSheetDetail(state.selectedEmpBackTaskInfo).then(response => {
          commit(empBackTaskSheetTypes.MUTATE_GET_EMPLOYEE_BACK_TASK_SHEET_DETAIL, response.result)
        }
    )
  },


  [empBackTaskSheetTypes.BACK_SERVICE_CONFIRM_BACK_TASK_SHEET] ({state, commit}) {

    //console.log("BACK_SERVICE_CONFIRM_BACK_TASK_SHEET"+JSON.stringify(state.selectedEmpBackTaskInfo));
    return employeeBackTaskSheetApi.submitBackServiceConfirm(state.selectedEmpBackTaskInfo);
  },

  [empBackTaskSheetTypes.BACK_COMMISSIONER_CONFIRM_BACK_TASK_SHEET] ({state, commit}) {

    //console.log("BACK_COMMISSIONER_CONFIRM_BACK_TASK_SHEET"+JSON.stringify(state.selectedEmpBackTaskInfo));
    return employeeBackTaskSheetApi.subBackCommissionerConfirm(state.selectedEmpBackTaskInfo);
  },




  [empBackTaskSheetTypes.SUBMIT_TASK_SHEET]({commit, state}, payload){
    let params = state.formForSubmit;
    params.taskSheetId = state.taskSheetDetail.taskSheetId;
    params.taskSheetServiceProductFeeSegmentRequestDTOList = state.taskSheetServiceProductList;
    params.taskSheetSocialFeeSegmentRequestDTOList = state.taskSheetSocialFeeInfo;
    console.log("params.taskSheetServiceProductList==="+JSON.stringify(state.taskSheetServiceProductList));
    console.log("params.taskSheetServiceProductFeeSegmentRequestDTOList111==="+JSON.stringify(params.taskSheetServiceProductFeeSegmentRequestDTOList));

    return employeeBackTaskSheetApi.submitTaskSheet(params);
  },

  [empBackTaskSheetTypes.BACK_TASK_SHEET_TO_FRONT]({state, commit}) {
    return employeeBackTaskSheetApi.rejectBackTaskSheetToFront(state.selectedEmpBackTaskInfo);
  },

};

// 更改组件状态
const mutations = {

  [empBackTaskSheetTypes.MUTATE_SEARCH_TASK_SHEET_PAGE](state, result){
    //console.log("MUTATE_SEARCH_TASK_SHEET_PAGE======result=====aaaaaqqq======="+JSON.stringify(result));
    const list = result;
    state.taskSheetList = list.records;
    state.pagination.total = result.total;

  },

  [empBackTaskSheetTypes.MUTATE_SELECTED_EMPLOYEE_BACK_TASK_SHEET_INFO](state, data){
    state.selectedEmpBackTaskInfo = data;
  },


  [empBackTaskSheetTypes.MUTATE_SUBMIT_BACK_TASK_SHEET_RETREAT_REASON](state, payload){
    state.selectedEmpBackTaskInfo.retreatReason = payload;
  },

  [empBackTaskSheetTypes.MUTATE_CURRENT_PAGE](state, data){
    state.pagination.currentPage = data;
  },
  [empBackTaskSheetTypes.MUTATE_PAGE_SIZE](state, data){
    state.pagination.size = data;
  },

  [empBackTaskSheetTypes.MUTATE_GET_EMPLOYEE_BACK_TASK_SHEET_DETAIL](state, data){
    state.empBackTaskSheetDetail = data.empBackTaskSheetResponseDTO;
    state.empBackTaskSheetSocialFeeInfo = data.empBackTaskSheetSocialFeeSegmentResponseDTOList;
    state.employeeInfo = data.employeeInfoResponseDTO;
    //console.log("MUTATE_GET_EMPLOYEE_BACK_TASK_SHEET_DETAIL======result============"+JSON.stringify(data.empBackTaskSheetSocialFeeSegmentResponseDTOList));

  },

  [empBackTaskSheetTypes.MUTATE_SEARCH_FORM](state, data){
    state.searchForm = data;
  },

};

// UI 组件数据
const getters = {
  socialYearList: state => {
    const yearList = [...state.socialSecurityDetailList].map(i => {
      const year = i.effectiveMonth.toString().substr(0,4);
      return year;
    }).sort((a, b) => {
      return a.year - b.year;
    });
    return Array.from(new Set(yearList));
  }
};


export default {
  namespaced: namespaced,
  state,
  actions,
  mutations,
  getters,
}
