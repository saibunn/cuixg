import { getRequest, postRequest,postCollectionRequest, putRequest, deleteRequest, getRequestWithNoToken } from '@/libs/axios';



// 获取雇员任务单列表
const getEmployeeTaskSheetListPage = params => getRequest('/employee/taskSheet/employeeTaskSheetQuery', params);

// 保存雇员基本信息
const saveEmployeeInfo = params => postCollectionRequest('/employee/saveEmployeeInfo', params);

// 根据条件获取社保字典
const getEmpFrontTaskSheetSocialFeeSegmentByParam = params => getRequest('/front/task/getEmpFrontTaskSheetSocialFeeSegmentByParam', params);

// 新增雇员前道任务单
const saveNewEmployeeTaskSheetInfo = params => postCollectionRequest('/front/task/saveNewEmployeeTaskSheetInfo', params);

export default {
  getEmployeeTaskSheetListPage,
  saveEmployeeInfo,
  getEmpFrontTaskSheetSocialFeeSegmentByParam,
  saveNewEmployeeTaskSheetInfo,

}

