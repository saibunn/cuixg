import { getRequest, postRequest, putRequest, deleteRequest, getRequestWithNoToken } from '@/libs/axios';



// export const getCompanyPage = (params) => {
//     return getRequest('/company/getCompanyPage', params)
// };
// 获取客户公司列表
const getCompanyPage = params => getRequest('/company/getCompanyPage', params);

export default {
    getCompanyPage,

}


