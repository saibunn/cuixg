import { getRequest, postRequest,postCollectionRequest, putRequest, deleteRequest, getRequestWithNoToken } from '@/libs/axios';


const getQueryEmployeeBackTaskSheetListPage = params => getRequest("/back/task/queryEmployeeBackTaskSheetPage", params);

const getEmployeeBackTaskSheetDetail = params => getRequest("/back/task/getEmployeeBackTaskSheetDetail",params);

// 后道客服确认
const submitBackServiceConfirm = params => postCollectionRequest('/back/task/submitBackServiceConfirm', params);

// 后道专员确认
const submitBackCommissionerConfirm = params => postCollectionRequest('/back/task/submitBackCommissionerConfirm', params);

// 后道退单
const rejectBackTaskSheetToFront = params => postCollectionRequest('/back/task/rejectBackTaskSheetToFront', params);

// 后道雇员任务单提交
const submitEmpBackTaskSheetInfo = params => postCollectionRequest('/back/task/submitEmpBackTaskSheetInfo', params);

export default {
  getQueryEmployeeBackTaskSheetListPage,
  getEmployeeBackTaskSheetDetail,
  submitBackServiceConfirm,
  submitBackCommissionerConfirm,
  rejectBackTaskSheetToFront,
  submitEmpBackTaskSheetInfo,
}
