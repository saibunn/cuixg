import EntrustSearchApi from "../../../api/entrust_service/entrust_search_api";
import Utils from "../../../lib/utils";
import EntrustTaskSheetTypes from "../../event_types/entrust_task_sheet_types";
import axios from 'axios'

const namespaced = true;

const state = {
  searchForm:{},
  taskSheetBatchDetail:{},

  taskSheetBatchServiceAgreementItem:{},

  taskSheetList:[],
  taskSheetIntegratList:[],
  taskSheetBatchList:[],
  taskSheetBatchSelectedList:[],
  taskSheetBatchUnSelectedList:[],
  taskSheetReturnList:[],
  taskSheetExamineReturnList:[],
  pagination: {
    total: 0,
    size: 10,
    currentPage: 1
  },

  returnPagination: {
    total: 0,
    size: Utils.DEFAULT_PAGE_SIZE,
    currentPage: 1
  },
  employeeInfo:{},
  taskSheetDetail:{
    taskSheetId: '',
    taskType: null,
    entrustCityId: null,
    beEntrustCityId:'',
    employeeName: '',
    entrustOrganizationId: '',
    beEntrustOrganizationId: '',
    companyId:'',
    companyName: '',
    employmentDate: '',
    contractStartDate: '',
    contractEndDate: '',
    serviceAgreementTypeLabel:null,
    serviceProductStartDate:null,
    serviceProductEndDate:null,
    fileKeepFee:0,
    fileKeepFeeStartDate:null,
    fileKeepFeeEndDate:null,
    otherFee:0,
    otherFeeStartDate:null,
    otherFeeEndDate:null,
    serviceFee:0,
    serviceProductCost:0,
    billYm:'',
    actualWage:null,
    entrustRemark:null,
    beEntrustRemark:null,
    terminationReason:null,
    terminationDate:null,
    retreatReason:null,
    entrustDate:null,
    createdTime:null,
    executeCityId:null,
    organizationAgreementResponseDTOList:[],
  },
  taskSheetSocialFeeBatchInfo:[],
  taskSheetSocialFeeInfo:[],
  taskSheetSocialInfoList:[],
  taskSheetUndoneReason:[],
  taskSheetHistory:[],
  taskSheetLogInfo:[],
  taskSheetServiceAgreement:{},
  taskSheetAfProductService:[],
  entrustCityServiceProductList:[],
  taskSheetServiceProductList:[],
  formForSubmit:{
    taskSheetId:'',
    serviceAgreementId:'',
    zytServiceOrganizationUserId:'',
    serviceOrganizationUserId:'',
    serviceAgreementType:'',
    beEntrustCityId:'',
    beEntrustCityName:'',
    beEntrustOrganizationId:'',
    beEntrustOrganizationName:'',
    entrustRemark:'',
    entrustRetreatReason:'',
    organizationAgreementProductRelationRequestDTOList:[],
    taskSheetServiceProductFeeSegmentRequestDTOList:[],
    taskSheetSocialFeeSegmentRequestDTOList:[],
  },

  getTaskSheetSocialListItem:{
    taskSheetId:null,
    socialType:null,
    fundType:null,
    supplierId:null,
    executeCityId:null,
  },

  socialSecurityDetailList:[],
  taskSheetBatchServiceAgreementList:[],

  zytTaskSheetSocialInfoList:[],

  sTaskSheetSocialInfoList:[],
  hTaskSheetSocialInfoList:[],
};

// 更改组件状态
const mutations = {
  [EntrustTaskSheetTypes.MUTATE_TASK_SHEET_PAGE](state, data){
    const list = data.records;
    state.taskSheetList = list;
    state.pagination.total = data.total;
  },

  [EntrustTaskSheetTypes.MUTATE_TASK_SHEET_RETURN_EXAMINE_PAGE](state, data){
    const list = data.records;
    state.taskSheetExamineReturnList = list;
    state.pagination.total = data.total;
  },

  [EntrustTaskSheetTypes.MUTATE_TASK_SHEET_INTEGRATE](state, data){

    state.taskSheetIntegratList = data;
  },

  [EntrustTaskSheetTypes.MUTATE_TASK_SHEET_BATCH_SERVICE_AGREEMENT](state, data){
    state.taskSheetBatchServiceAgreementList = data;
  },

  [EntrustTaskSheetTypes.MUTATE_TASK_SHEET_BATCH_PAGE](state, data){
    const list = data.records;
    for (var j=0;j<list.length;j++) {
      list[j]._checked = true;
      for (var i=0;i<state.taskSheetBatchUnSelectedList.length;i++) {
        if(list[j].taskSheetId === state.taskSheetBatchUnSelectedList[i].taskSheetId){
          list[j]._checked = false;
          break;
        }
      }
    }

    state.taskSheetBatchList = list;
    state.taskSheetBatchServiceAgreement = [];
    console.log("...state.taskSheetBatchList==========="+JSON.stringify(list));
    state.pagination.total = data.total;
  },

  [EntrustTaskSheetTypes.MUTATE_TASK_SHEET_INTEGRATE_PAGE](state, data){
    const list = data.records;
    state.taskSheetIntegratList = list;

    state.pagination.total = data.total;
  },

  [EntrustTaskSheetTypes.MUTATE_TASK_SHEET_RETURN_PAGE](state, data){
    const list = data.records;
    state.taskSheetReturnList = state.taskSheetReturnList.concat(list);
    state.returnPagination.total = data.total;
  },

  [EntrustTaskSheetTypes.MUTATE_CURRENT_PAGE](state, data){
    state.pagination.currentPage = data;
  },
  [EntrustTaskSheetTypes.MUTATE_PAGE_SIZE](state, data){
    state.pagination.size = data;
  },

  [EntrustTaskSheetTypes.MUTATE_SELECTION_BATCH_ALL_DATA](state, data){
    state.taskSheetBatchSelectedList = data;
  },

  [EntrustTaskSheetTypes.MUTATE_CANCEL_SELECTION_BATCH_ALL_DATA](state, data){
    state.taskSheetBatchUnSelectedList = data;
  },

  [EntrustTaskSheetTypes.MUTATE_RETURN_CURRENT_PAGE](state, data){
    state.returnPagination.currentPage = data;
  },
  [EntrustTaskSheetTypes.MUTATE_RETURN_PAGE_SIZE](state, data){
    state.returnPagination.size = data;
  },

  [EntrustTaskSheetTypes.MUTATE_SEARCH_FORM](state, data){
    state.searchForm = data;
  },

  [EntrustTaskSheetTypes.MUTATE_TASK_SHEET_BATCH_SUBMIT_ITEM](state, data){
    state.taskSheetBatchDetail = data;
  },

  [EntrustTaskSheetTypes.MUTATE_TASK_SHEET_DETAIL](state, data){
    state.taskSheetDetail = data;
  },
  [EntrustTaskSheetTypes.MUTATE_TASK_SHEET_EMPLOYEE_INFO](state, data){
    state.employeeInfo = data;
  },
  [EntrustTaskSheetTypes.MUTATE_TASK_SHEET_SOCIAL_FEE_INFO](state, data){
    state.taskSheetSocialFeeInfo = data;
  },
  [EntrustTaskSheetTypes.MUTATE_TASK_SHEET_SOCIAL_INFO_LIST](state, data){
    state.sTaskSheetSocialInfoList = data.ssPolicyDetailExtDTOList;
    state.hTaskSheetSocialInfoList = data.hsPolicyDetailExtDTOList;
    console.log("GET_TASK_SHEET_SOCIAL_INFO_LIST"+JSON.stringify(state.taskSheetSocialInfoList));
  },
  [EntrustTaskSheetTypes.MUTATE_TASK_SHEET_SOCIAL_FEE_BATCH_INFO](state, data){
    state.taskSheetSocialFeeBatchInfo = data;
  },
  [EntrustTaskSheetTypes.MUTATE_TASK_SHEET_UNDONE_REASON](state, data){
    state.taskSheetUndoneReason = data;
  },
  [EntrustTaskSheetTypes.MUTATE_TASK_SHEET_HISTORY](state, data){
    state.taskSheetHistory = data;
  },
  [EntrustTaskSheetTypes.MUTATE_TASK_SHEET_LOG_INFO](state, data){
    state.taskSheetLogInfo = data;
  },
  [EntrustTaskSheetTypes.MUTATE_TASK_SHEET_SERVICE_AGREEMENT](state, data){
    state.taskSheetServiceAgreement = data;
  },
  [EntrustTaskSheetTypes.MUTATE_TASK_SHEET_AF_SERVICE_PRODUCT](state, data){
    state.taskSheetAfProductService = data;
  },
  [EntrustTaskSheetTypes.MUTATE_SERVICE_PRODUCT_BY_TASK_SHEET_CITY](state, data){
    state.entrustCityServiceProductList = data;
  },
  [EntrustTaskSheetTypes.MUTATE_TASK_SHEET_SERVICE_PRODUCT](state, data){
    state.taskSheetServiceProductList = data != null ? [...data] : [];
    console.log("MUTATE_TASK_SHEET_SERVICE_PRODUCT111"+JSON.stringify(state.taskSheetServiceProductList));

    if(state.taskSheetServiceProductList.length>0){

      //state.taskSheetDetail.serviceProductCost  = Utils.sumBy(state.taskSheetServiceProductList,"serviceProductAmount");
      state.taskSheetDetail.serviceProductCost = parseFloat(_.sumBy(state.taskSheetServiceProductList, i => {
        if(i.serviceProductAmount != null){
          return i.serviceProductAmount;
        }else{
          return 0;
        }
      }).toFixed(2));

      if(state.taskSheetAfProductService.length>0){
        state.taskSheetDetail.serviceProductStartDate = state.taskSheetAfProductService[0].startDate;
        state.taskSheetDetail.serviceProductEndDate = state.taskSheetAfProductService[0].endDate;
      }
    }

  },
  [EntrustTaskSheetTypes.MUTATE_TASK_SHEET_SERVICE_PRODUCT_AMOUNT](state, payload){
    console.log("MUTATE_TASK_SHEET_SERVICE_PRODUCT_AMOUNT"+JSON.stringify(payload));
    state.taskSheetServiceProductList[payload.index].serviceProductAmount = payload.amount;
  },
  [EntrustTaskSheetTypes.DELETE_TASK_SHEET_SERVICE_PRODUCT](state, index){
    state.taskSheetServiceProductList.splice(index, 1);

    if(state.taskSheetServiceProductList.length>0){

      //state.taskSheetDetail.serviceProductCost  = Utils.sumBy(state.taskSheetServiceProductList,"serviceProductAmount");
      state.taskSheetDetail.serviceProductCost = parseFloat(_.sumBy(state.taskSheetServiceProductList, i => {
        if(i.serviceProductAmount != null){
          return i.serviceProductAmount;
        }else{
          return 0;
        }
      }).toFixed(2));

      if(state.taskSheetAfProductService.length>0){
        state.taskSheetDetail.serviceProductStartDate = state.taskSheetAfProductService[0].startDate;
        state.taskSheetDetail.serviceProductEndDate = state.taskSheetAfProductService[0].endDate;
      }
    }else{
      state.taskSheetDetail.serviceProductCost = 0;
      state.taskSheetDetail.serviceProductStartDate = "";
      state.taskSheetDetail.serviceProductEndDate = "";
    }
  },
  [EntrustTaskSheetTypes.MUTATE_SUBMIT_SERVICE_AGREEMENT_TYPE](state, payload){
    state.formForSubmit.serviceAgreementType = payload;
  },
  [EntrustTaskSheetTypes.MUTATE_SUBMIT_SERVICE_AGREEMENT_ID](state, payload){
    console.log("MUTATE_SUBMIT_SERVICE_AGREEMENT_ID"+JSON.stringify(payload));
    state.formForSubmit.serviceAgreementId = payload.agreementId;
    state.formForSubmit.beEntrustCityId = payload.cityCode;
    state.formForSubmit.beEntrustCityName = payload.cityName;
    state.formForSubmit.beEntrustOrganizationId = payload.supplierId;
    state.formForSubmit.beEntrustOrganizationName = payload.supplierName;
    state.formForSubmit.serviceOrganizationUserId = payload.operatorId;
    state.formForSubmit.zytServiceOrganizationUserId = payload.zytServiceOrganizationUserId;
    state.formForSubmit.organizationAgreementProductRelationRequestDTOList = payload.organizationAgreementProductRelationResponseDTOList;

    state.getTaskSheetSocialListItem.supplierId = payload.supplierId;
  },

  [EntrustTaskSheetTypes.MUTATE_SUBMIT_BATCH_SERVICE_AGREEMENT_ID](state, payload){
    console.log("MUTATE_SUBMIT_BATCH_SERVICE_AGREEMENT_ID"+JSON.stringify(payload));
    state.taskSheetBatchServiceAgreementItem = payload;
    state.taskSheetBatchServiceAgreementItem.organizationAgreementProductRelationRequestDTOList = payload.organizationAgreementProductRelationResponseDTOList;
  },

  [EntrustTaskSheetTypes.MUTATE_SUBMIT_ENTRUST_REMARK](state, payload){
    state.formForSubmit.entrustRemark = payload;
  },
  [EntrustTaskSheetTypes.MUTATE_SUBMIT_ENTRUST_RETREAT_REASON](state, payload){
    state.formForSubmit.entrustRetreatReason = payload;
    console.log("...state.formForSubmit.entrustRetreatReason"+state.formForSubmit.entrustRetreatReason);
  },
  [EntrustTaskSheetTypes.MUTATE_SOCIAL_SECURITY_DETAILS](state, data){
    state.socialSecurityDetailList = data;
  },
};

// UI 组件数据
const getters = {
  serviceAgreementTransform: state => {
    const serviceAgreement = state.taskSheetServiceAgreement;
  },
  isTaskSheetProcessed: state => {
    return state.taskSheetDetail.taskStatus != 1;
  },
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

// 收集UI组件的所有事件，可以同步也可以异步提交
const actions = {
  [EntrustTaskSheetTypes.SEARCH_TASK_SHEET_PAGE]({state, commit}){
    const params = {
      ...state.searchForm,
      size: state.pagination.size,
      currentPage: state.pagination.currentPage
    };
    console.log("...state.searchForm.currentPage"+JSON.stringify(params));
    EntrustSearchApi.getEntrustTaskSheetListPage(params)
      .then(response => {
        console.log(response);
        const responseData = response.data;
        if (responseData.code === 0) {
          commit(EntrustTaskSheetTypes.MUTATE_TASK_SHEET_PAGE, responseData.object)
        } else {
          throw(responseData.message);
        }
      }).catch(error => {
        console.log(error)
      })
  },

  [EntrustTaskSheetTypes.SEARCH_TASK_SHEET_BATCH_PAGE]({state, commit}){
    const params = {
      ...state.searchForm,
      size: state.pagination.size,
      currentPage: state.pagination.currentPage
    };
    console.log("...state.SEARCH_TASK_SHEET_BATCH_PAGE.currentPage"+JSON.stringify(params));
    EntrustSearchApi.getEntrustTaskSheetBatchListPage(params)
      .then(response => {
        console.log(response);
        const responseData = response.data;
        if (responseData.code === 0) {
          commit(EntrustTaskSheetTypes.MUTATE_TASK_SHEET_BATCH_PAGE, responseData.object)
        } else {
          throw(responseData.message);
        }
      }).catch(error => {
      console.log(error)
    })
  },


  [EntrustTaskSheetTypes.SEARCH_TASK_SHEET_RETURN_EXAMINE]({state, commit}){
    const params = {
      ...state.searchForm,
      size: state.pagination.size,
      currentPage: state.pagination.currentPage
    };
    console.log("...state.searchForm.currentPage"+JSON.stringify(params));
    EntrustSearchApi.getEntrustTaskSheetReturnExamineListPage(params)
      .then(response => {
        console.log(response);
        const responseData = response.data;
        if (responseData.code === 0) {
          commit(EntrustTaskSheetTypes.MUTATE_TASK_SHEET_RETURN_EXAMINE_PAGE, responseData.object)
        } else {
          throw(responseData.message);
        }
      }).catch(error => {
      console.log(error)
    })
  },

  [EntrustTaskSheetTypes.SEARCH_TASK_SHEET_BATCH_SERVICE_AGREEMENT]({state, commit}){
    const params = {
      ...state.searchForm
    };
    console.log("...state.searchForm.SEARCH_TASK_SHEET_BATCH_SERVICE_AGREEMENT"+JSON.stringify(params));
    EntrustSearchApi.getEntrustTaskSheetBatchServiceAgreementList(params)
      .then(response => {
        console.log(response);
        const responseData = response.data;
        if (responseData.code === 0) {
          commit(EntrustTaskSheetTypes.MUTATE_TASK_SHEET_BATCH_SERVICE_AGREEMENT, responseData.object)
        } else {
          throw(responseData.message);
        }
      }).catch(error => {
      console.log(error)
    })
  },

  [EntrustTaskSheetTypes.TASK_SHEET_RETURN_APPLY]({commit}, params){
    return EntrustSearchApi.submitTaskSheetReturnApply(params)
  },

  [EntrustTaskSheetTypes.TASK_SHEET_RETURN_REFUSE]({commit}, params){
    return EntrustSearchApi.submitTaskSheetReturnRefuse(params)
  },

  [EntrustTaskSheetTypes.SEARCH_TASK_SHEET_INTEGRATE]({state, commit}){
    const params = {
      ...state.searchForm
    };
    console.log("...state.searchForm.SEARCH_TASK_SHEET_INTEGRATE"+JSON.stringify(params));
    EntrustSearchApi.getEntrustTaskSheetIntegrateList(params)
      .then(response => {
        console.log(response);
        const responseData = response.data;
        if (responseData.code === 0) {
          commit(EntrustTaskSheetTypes.MUTATE_TASK_SHEET_INTEGRATE, responseData.object)
        } else {
          throw(responseData.message);
        }
      }).catch(error => {
      console.log(error)
    })
  },

  [EntrustTaskSheetTypes.SEARCH_TASK_SHEET_INTEGRATE_PAGE]({state, commit}){
    const params = {
      ...state.searchForm,
      size: state.pagination.size,
      currentPage: state.pagination.currentPage
    };
    console.log("...state.searchForm.currentPage"+JSON.stringify(params));
    EntrustSearchApi.getEntrustTaskSheetIntegrateListPage(params)
      .then(response => {
        console.log(response);
        const responseData = response.data;
        if (responseData.code === 0) {
          commit(EntrustTaskSheetTypes.MUTATE_TASK_SHEET_INTEGRATE_PAGE, responseData.object)
        } else {
          throw(responseData.message);
        }
      }).catch(error => {
      console.log(error)
    })
  },

  [EntrustTaskSheetTypes.SEARCH_TASK_SHEET_INTEGRATE_RETURN_PAGE]({state, commit}){
    const params = {
      ...state.searchForm,
      size: state.pagination.size,
      currentPage: state.returnPagination.currentPage
    };
    console.log("...state.searchForm.currentPage"+JSON.stringify(params));
    EntrustSearchApi.getEntrustTaskSheetIntegrateReturnListPage(params)
      .then(response => {
        console.log(response);
        const responseData = response.data;
        if (responseData.code === 0) {
          commit(EntrustTaskSheetTypes.MUTATE_TASK_SHEET_RETURN_PAGE, responseData.object)
        } else {
          throw(responseData.message);
        }
      }).catch(error => {
      console.log(error)
    })
  },

  [EntrustTaskSheetTypes.GET_TASK_SHEET_DETAIL]({commit}, payload){
    const id = payload;
    return EntrustSearchApi.getTaskSheetDetail(id)
      .then(response => {
        console.log("MUTATE_TASK_SHEET_DETAIL"+response);
        const responseData = response.data;
        if (responseData.code === 0) {
          commit(EntrustTaskSheetTypes.MUTATE_TASK_SHEET_DETAIL, responseData.object)
        } else {
          throw(responseData.message);
        }
        return response;
      })
  },

  [EntrustTaskSheetTypes.GET_TASK_SHEET_SOCIAL_FEE_INFO]({commit}, payload){
    const config = {
      params:{
        taskSheetId: payload
      }
    };
    EntrustSearchApi.getTaskSheetSocialFeeInfo(config)
      .then(response => {
        const responseData = response.data;
        console.log("GET_TASK_SHEET_SOCIAL_FEE_INFO"+JSON.stringify(responseData));
        if (responseData.code === 0) {
          commit(EntrustTaskSheetTypes.MUTATE_TASK_SHEET_SOCIAL_FEE_INFO, responseData.object)
        } else {
          throw(responseData.message);
        }
      }).catch(error => {
        console.log(error)
      })
  },

  [EntrustTaskSheetTypes.GET_TASK_SHEET_SOCIAL_INFO_LIST]({commit}, payload){

    state.getTaskSheetSocialListItem.taskSheetId = state.taskSheetDetail.taskSheetId;
    state.getTaskSheetSocialListItem.socialType = state.taskSheetServiceAgreement.socialType;
    state.getTaskSheetSocialListItem.fundType = state.taskSheetServiceAgreement.fundType;
    state.getTaskSheetSocialListItem.executeCityId = state.taskSheetDetail.executeCityId;

    const params = {
      ...state.getTaskSheetSocialListItem,
      size: state.pagination.size,
      currentPage: state.returnPagination.currentPage
    };

    EntrustSearchApi.getTaskSheetSocialInfoList(params)
      .then(response => {
        const responseData = response.data;
        console.log("GET_TASK_SHEET_SOCIAL_INFO_LIST"+JSON.stringify(responseData));
        if (responseData.code === 0) {
          commit(EntrustTaskSheetTypes.MUTATE_TASK_SHEET_SOCIAL_INFO_LIST, responseData.object)
        } else {
          throw(responseData.message);
        }
      }).catch(error => {
      console.log(error)
    })
  },

  [EntrustTaskSheetTypes.GET_TASK_SHEET_SOCIAL_FEE_BATCH_INFO]({commit}, payload){
    const config = {
      params:{
        taskSheetId: "",
      }
    };
    EntrustSearchApi.getTaskSheetSocialFeeBatchInfo(config)
      .then(response => {
        const responseData = response.data;
        console.log("GET_TASK_SHEET_SOCIAL_FEE_BATCH_INFO"+JSON.stringify(responseData));
        if (responseData.code === 0) {
          commit(EntrustTaskSheetTypes.MUTATE_TASK_SHEET_SOCIAL_FEE_BATCH_INFO, responseData.object)
        } else {
          throw(responseData.message);
        }
      }).catch(error => {
      console.log(error)
    })
  },

  [EntrustTaskSheetTypes.GET_TASK_SHEET_UNDONE_REASON]({commit}, payload){
    const config = {
      params:{
        taskSheetId: payload
      }
    };
    EntrustSearchApi.getTaskSheetUndoneReason(config)
      .then(response => {
        const responseData = response.data
        if (responseData.code === 0) {
          commit(EntrustTaskSheetTypes.MUTATE_TASK_SHEET_UNDONE_REASON, responseData.object)
        } else {
          throw(responseData.message);
        }
      }).catch(error => {
        console.log(error)
      })
  },

  [EntrustTaskSheetTypes.GET_TASK_SHEET_HISTORY]({state, commit}, payload){
    const config = {
      params:{
        employeeId: state.taskSheetDetail.employeeId,
        entrustCityId: state.taskSheetDetail.entrustCityId
      }
    };
    console.log("getTaskSheetHistory"+JSON.stringify(config));
    EntrustSearchApi.getTaskSheetHistory(config)
      .then(response => {
        const responseData = response.data
        if (responseData.code === 0) {
          commit(EntrustTaskSheetTypes.MUTATE_TASK_SHEET_HISTORY, responseData.object)
        } else {
          throw(responseData.message);
        }
      }).catch(error => {
        console.log(error)
      })
  },

  [EntrustTaskSheetTypes.GET_TASK_SHEET_LOG_INFO]({commit}, payload){
    const config = {
      params:{
        taskSheetId: payload
      }
    };
    EntrustSearchApi.getTaskSheetLogInfo(config)
      .then(response => {
        const responseData = response.data
        if (responseData.code === 0) {
          commit(EntrustTaskSheetTypes.MUTATE_TASK_SHEET_LOG_INFO, responseData.object)
        } else {
          throw(responseData.message);
        }
      }).catch(error => {
        console.log(error)
      })
  },

  [EntrustTaskSheetTypes.GET_TASK_SHEET_SERVICE_AGREEMENT]({commit}, payload){
    const config = {
      params:{
        taskSheetId: payload
      }
    };
    EntrustSearchApi.getTaskSheetServiceAgreement(config)
      .then(response => {
        const responseData = response.data;
        if (responseData.code === 0) {
          commit(EntrustTaskSheetTypes.MUTATE_TASK_SHEET_SERVICE_AGREEMENT, responseData.object[0])
        } else {
          throw(responseData.message);
        }
      }).catch(error => {
      console.log(error)
    })
  },

  [EntrustTaskSheetTypes.GET_TASK_SHEET_AF_SERVICE_PRODUCT]({commit}, payload){
    const config = {
      params:{
        taskSheetId: payload
      }
    };
    EntrustSearchApi.getTaskSheetAfServiceProduct(config)
      .then(response => {
        const responseData = response.data
        if (responseData.code === 0) {
          commit(EntrustTaskSheetTypes.MUTATE_TASK_SHEET_AF_SERVICE_PRODUCT, responseData.object)
        } else {
          throw(responseData.message);
        }
      }).catch(error => {
        console.log(error)
      })
  },

  [EntrustTaskSheetTypes.GET_SERVICE_PRODUCT_BY_TASK_SHEET_CITY]({commit, state}, payload){
    const config = {
      params:{
        cityId: state.taskSheetDetail.executeCityId
      }
    };
    EntrustSearchApi.getServiceProductByTaskSheetCity(config)
      .then(response => {
        const responseData = response.data
        if (responseData.code === 0) {
          commit(EntrustTaskSheetTypes.MUTATE_SERVICE_PRODUCT_BY_TASK_SHEET_CITY, responseData.object)
        } else {
          throw(responseData.message);
        }
      }).catch(error => {
        console.log(error)
      })
  },

  [EntrustTaskSheetTypes.GET_TASK_SHEET_SERVICE_PRODUCT]({commit, state}, payload){
    const config = {
      params:{
        taskSheetId: payload
      }
    };
    EntrustSearchApi.getTaskSheetServiceProduct(config)
      .then(response => {
        const responseData = response.data;
        if (responseData.code === 0) {
          commit(EntrustTaskSheetTypes.MUTATE_TASK_SHEET_SERVICE_PRODUCT, responseData.object)
        } else {
          throw(responseData.message);
        }
      }).catch(error => {
      console.log(error)
    })
  },

  [EntrustTaskSheetTypes.GET_TASK_SHEET_EMPLOYEE_INFO]({commit, state}, payload){
    const config = {
      params:{
        taskSheetId: payload
      }
    };
    EntrustSearchApi.getTaskSheetEmployeeInfo(config)
      .then(response => {
        const responseData = response.data;
        if (responseData.code === 0) {
          commit(EntrustTaskSheetTypes.MUTATE_TASK_SHEET_EMPLOYEE_INFO, responseData.object)
        } else {
          throw(responseData.message);
        }
      }).catch(error => {
      console.log(error)
    })
  },

  [EntrustTaskSheetTypes.SUBMIT_TASK_SHEET]({commit, state}, payload){
    let params = state.formForSubmit;
    params.taskSheetId = state.taskSheetDetail.taskSheetId;
    params.taskSheetServiceProductFeeSegmentRequestDTOList = state.taskSheetServiceProductList;
    params.taskSheetSocialFeeSegmentRequestDTOList = state.taskSheetSocialFeeInfo;
    console.log("params.taskSheetServiceProductList==="+JSON.stringify(state.taskSheetServiceProductList));
    console.log("params.taskSheetServiceProductFeeSegmentRequestDTOList111==="+JSON.stringify(params.taskSheetServiceProductFeeSegmentRequestDTOList));

    return EntrustSearchApi.submitTaskSheet(params);
  },

  [EntrustTaskSheetTypes.BACK_TASK_SHEET_TO_AF]({commit, state}, payload){
    let params = state.formForSubmit;
    params.taskSheetId = state.taskSheetDetail.taskSheetId;
    return EntrustSearchApi.backTaskSheetToAf(params);
  },

  [EntrustTaskSheetTypes.SUBMIT_TASK_SHEET_BATCH]({commit, state}, payload){
    let params = state.taskSheetBatchDetail;
    params.cancelTaskSheetRequestDTOList = state.taskSheetBatchUnSelectedList;
    params.taskSheetSearchItem = state.searchForm;
    params.taskSheetSocialFeeSegmentRequestDTOList = state.taskSheetSocialFeeBatchInfo;
    params.organizationAgreementRequestDTO = state.taskSheetBatchServiceAgreementItem;
    return EntrustSearchApi.submitTaskSheetBatch(params);
  },

  [EntrustTaskSheetTypes.BACK_TASK_SHEET_BATCH_TO_AF]({commit, state}, payload){
    let params = state.taskSheetBatchDetail;
    params.cancelTaskSheetRequestDTOList = state.taskSheetBatchUnSelectedList;
    params.taskSheetSearchItem = state.searchForm;
    return EntrustSearchApi.backTaskSheetBatchToAf(params);
  },

  [EntrustTaskSheetTypes.SEARCH_TASK_SHEET]({commit, state}, payload){
    const params = {...state.searchForm};
    return EntrustSearchApi.getEntrustTaskSheetList(params);
  },

  // [EntrustTaskSheetTypes.SEARCH_TASK_SHEET_INTEGRATE]({commit,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            state}, payload){
  //   const params = {...state.searchForm};
  //   return EntrustSearchApi.getEntrustTaskSheetIntegrateList(params);
  // },

  [EntrustTaskSheetTypes.SEARCH_TASK_SHEET_INTEGRATE_RETURN]({commit, state}, payload){
    const params = {...state.searchForm};
    return EntrustSearchApi.getEntrustTaskSheetIntegrateReturnList(params);
  },

  [EntrustTaskSheetTypes.DOWNLOAD_TASK_SHEET_LIST]({commit, state}, payload){
    const params = {...state.searchForm};
    return EntrustSearchApi.downloadEntrustTaskSheetList(params);
  },

  [EntrustTaskSheetTypes.GET_SOCIAL_SECURITY_DETAILS]({commit, state}, payload){
    const config = {
      params:{
        cityCode: state.taskSheetDetail.executeCityId
      }
    };
    EntrustSearchApi.getSocialSecurityDetailByCity(config)
      .then(response => {
        const responseData = response.data
        if (responseData.code === 0) {
          commit(EntrustTaskSheetTypes.MUTATE_SOCIAL_SECURITY_DETAILS, responseData.object)
        } else {
          throw(responseData.message);
        }
      }).catch(error => {
        console.log(error)
      });
  },

};


export default {
  namespaced: namespaced,
  state,
  actions,
  mutations,
  getters,
}
