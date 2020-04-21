import { getRequest, postRequest,postCollectionRequest, putRequest, deleteRequest, getRequestWithNoToken } from '@/libs/axios';



// 获取雇员任务单列表
const getEmployeeTaskSheetListPage = params => getRequest('/employee/taskSheet/employeeTaskSheetQuery', params);

// 保存雇员基本信息
const saveEmployeeInfo = params => getRequest('/employee/taskSheet/saveEmployeeInfo', params);

export default {
  getEmployeeTaskSheetListPage,
  saveEmployeeInfo,
}
