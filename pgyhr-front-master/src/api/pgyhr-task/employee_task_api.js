import { getRequest, postRequest,postCollectionRequest, putRequest, deleteRequest, getRequestWithNoToken } from '@/libs/axios';



// 获取雇员任务单列表
const getEmployeeTaskSheetListPage = params => getRequest('/employee/taskSheet/employeeTaskSheetQuery', params);

export default {
  getEmployeeTaskSheetListPage,

}
