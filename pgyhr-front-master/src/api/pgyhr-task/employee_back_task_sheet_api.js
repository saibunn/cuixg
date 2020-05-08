import { getRequest, postRequest,postCollectionRequest, putRequest, deleteRequest, getRequestWithNoToken } from '@/libs/axios';


const getqueryEmployeeBackTaskSheetListPage = params => getRequest("/back/task//queryEmployeeBackTaskSheetPage", params);

const getEntrustTaskSheetBatchListPage = params => postCollectionRequest("/back/task//entrustTaskSheetBatchQuery", params);

const getEntrustTaskSheetIntegrateListPage = params => postCollectionRequest("/back/task//entrustTaskSheetIntegrateQuery", params);

const getEntrustTaskSheetIntegrateReturnListPage = params => postCollectionRequest("/back/task//entrustTaskSheetIntegrateReturnQuery", params);

const getEntrustTaskSheetReturnExamineListPage = params => postCollectionRequest("/back/task//entrustTaskSheetReturnExamineQuery", params);

const getTaskSheetDetail = params => getRequest("/back/task//taskSheetDetail/" + params);

const getTaskSheetSocialFeeInfo  = params => getRequest("/back/task//socialFeeInfo", params);

const getTaskSheetSocialInfoList = params => postCollectionRequest("/back/task//getTaskSheetSocialInfoList", params);

const getTaskSheetSocialFeeBatchInfo  = params => getRequest("/back/task//socialFeeBatchInfo", params);

const getTaskSheetUndoneReason  = params => getRequest("/back/task//undoneReason", params);

const getTaskSheetHistory  = params => getRequest("/back/task//completedTaskSheet", params);

const getTaskSheetLogInfo  = params => getRequest("/back/task//logInfo", params);

const getTaskSheetServiceAgreement  = params => getRequest("/back/task//serviceAgreement", params);

const getTaskSheetAfServiceProduct  = params => getRequest("/back/task//afServiceProduct", params);

const getServiceProductByTaskSheetCity  = params => getRequest("/back/task//serviceProduct", params);

const getTaskSheetServiceProduct  = params => getRequest("/back/task//taskSheetServiceProduct", params);

const getTaskSheetEmployeeInfo  = params => getRequest("/back/task//employeeInfo", params);

const getServiceAgreementTypes  = params => getRequest("/back/task//serviceAgreementType");

const submitTaskSheet = params => postCollectionRequest("/back/task//submitTaskSheet", params);

const submitTaskSheetBatch = params => postCollectionRequest("/back/task//submitTaskSheetBatch", params);

const submitTaskSheetReturnApply = params => postCollectionRequest("/back/task//submitTaskSheetReturnApply", params);

const submitTaskSheetReturnRefuse = params => postCollectionRequest("/back/task//submitTaskSheetReturnRefuse", params);

const backTaskSheetToAf = params => postCollectionRequest("/back/task//backTaskSheetToAf", params);

const backTaskSheetBatchToAf = params => postCollectionRequest("/back/task//backTaskSheetBatchToAf", params);

const getEntrustTaskSheetList =  params => ajax.post("/back/task//entrustTaskSheetFullQuery", params);

const getEntrustTaskSheetBatchList =  params => ajax.post("/api/entrust;/taskSheet/entrustTaskSheetBatchFullQuery", params);

const getEntrustTaskSheetIntegrateList =  params => ajax.post("/back/task//entrustTaskSheetIntegrateFullQuery", params);

const getEntrustTaskSheetBatchServiceAgreementList =  params => ajax.post("/back/task//entrustTaskSheetBatchServiceAgreementQuery", params);

const getEntrustTaskSheetIntegrateReturnList =  params => ajax.post("/back/task//entrustTaskSheetIntegrateReturnFullQuery", params);

const getTaskStatusEnums  = params => getRequest("/back/task//taskStatus");

const getTaskTypeEnums  = params => getRequest("/back/task//taskType");

const getRemarkTypeEnums  = params => getRequest("/back/task//remarkType");

const getEntrustConfirmTypeEnums  = params => getRequest("/back/task//entrustConfirmType");

const getSocialSecurityDetailByCity  = params => getRequest("/back/task//socialSecurityDetail", params);

const getOrganizationServiceAgreement  = params => getRequest("/back/task//getOrganizationServiceAgreement", params);




export default {
  getqueryEmployeeBackTaskSheetListPage,
  getEntrustTaskSheetBatchListPage,
  getEntrustTaskSheetIntegrateListPage,
  getEntrustTaskSheetIntegrateReturnListPage,
  getEntrustTaskSheetReturnExamineListPage,
  getTaskSheetDetail,
  getEntrustTaskSheetBatchServiceAgreementList,
  getTaskSheetSocialFeeInfo,
  getTaskSheetSocialFeeBatchInfo,
  getTaskSheetUndoneReason,
  getTaskSheetHistory,
  getTaskSheetLogInfo,
  getTaskSheetEmployeeInfo,
  getTaskSheetServiceAgreement,
  getTaskSheetAfServiceProduct,
  getServiceProductByTaskSheetCity,
  getTaskSheetServiceProduct,
  getServiceAgreementTypes,
  submitTaskSheet,
  backTaskSheetToAf,
  getTaskSheetSocialInfoList,
  submitTaskSheetBatch,
  backTaskSheetBatchToAf,
  getEntrustTaskSheetList,
  getEntrustTaskSheetIntegrateList,
  getEntrustTaskSheetIntegrateReturnList,
  getEntrustTaskSheetBatchList,
  getTaskStatusEnums,
  getTaskTypeEnums,
  getRemarkTypeEnums,
  getEntrustConfirmTypeEnums,
  submitTaskSheetReturnApply,
  submitTaskSheetReturnRefuse,
  getSocialSecurityDetailByCity,
  getOrganizationServiceAgreement

}
