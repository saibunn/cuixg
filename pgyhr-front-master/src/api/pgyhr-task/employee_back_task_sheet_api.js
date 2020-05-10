import { getRequest, postRequest,postCollectionRequest, putRequest, deleteRequest, getRequestWithNoToken } from '@/libs/axios';


const getQueryEmployeeBackTaskSheetListPage = params => getRequest("/back/task/queryEmployeeBackTaskSheetPage", params);

const getEmployeeBackTaskSheetDetail = params => getRequest("/back/task/getEmployeeBackTaskSheetDetail",params);

// 后道客服确认
const submitBackServiceConfirm = params => postCollectionRequest('/back/task/submitBackServiceConfirm', params);

// 后道专员确认
const submitBackCommissionerConfirm = params => postCollectionRequest('/back/task/submitBackCommissionerConfirm', params);

// 后道退单
const rejectBackTaskSheetToFront = params => postCollectionRequest('/back/task/rejectBackTaskSheetToFront', params);

export default {
  getQueryEmployeeBackTaskSheetListPage,
  getEmployeeBackTaskSheetDetail,
  submitBackServiceConfirm,
  submitBackCommissionerConfirm,
  rejectBackTaskSheetToFront,

}
