import { getRequest, postRequest,postCollectionRequest, putRequest, deleteRequest, getRequestWithNoToken, putRequestJSON } from '@/libs/axios';



// 获取雇员任务单列表
const getEmployeeTaskSheetListPage = params => getRequest('/employee/taskSheet/employeeTaskSheetQuery', params);

// 保存雇员基本信息
const saveEmployeeInfo = params => postCollectionRequest('/employee/saveEmployeeInfo', params);

//分页获取雇员基本信息
const getEmployeePage = params => getRequest('/employeeInfo/getEmployeeInfoPage',params);

//按ID查询雇员信息
const getEmployeeId = params =>getRequest('/employeeInfo/getEmployeeId',params);

//修改雇员信息
const updEmployeeInfo = params => putRequestJSON('/employeeInfo/updEmployee',params);

//分页查询雇员入离职信息
const getEMPCompanyPage = params => getRequest('/employee/getEmpCompanyDTOPage',params);

export default {
  getEmployeeTaskSheetListPage,
  saveEmployeeInfo,
  getEmployeePage,
  getEmployeeId,
  updEmployeeInfo,
  getEMPCompanyPage
}
