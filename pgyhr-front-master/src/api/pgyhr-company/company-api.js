import { getRequest, postRequest, putRequest, deleteRequest, getRequestWithNoToken, postRequestQs, postRequestJSON, putRequestJSON } from '@/libs/axios';



// export const getCompanyPage = (params) => {
//     return getRequest('/company/getCompanyPage', params)
// };

const getCompanyAll = params => getRequest('/company/getCompanyAll', params);
// 获取客户公司列表
const getCompanyPage = params => getRequest('/company/getCompanyPage', params);
///新增客户
const saveCompany = params => postRequestJSON('/company/saveCompany', params);
//根据公司级别获取客户
const getCompanyLevel = params => getRequest('/company/getCompanyLevel', params);
//根据公司code查询公司主从表信息
const getCompanyCode = params => getRequest('/company/getCompanyCode', params);
///修改客户信息
const updCompany = params => putRequestJSON('/company/updCompany', params);
//根据客户code删除主从表信息
const delCompany = params => deleteRequest('/company/delCompany', params);

export default {
    getCompanyAll,
    getCompanyPage,
    saveCompany,
    getCompanyLevel,
    getCompanyCode,
    updCompany,
    delCompany
}


