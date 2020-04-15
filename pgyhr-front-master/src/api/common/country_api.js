import { getRequest, postRequest, putRequest, deleteRequest, getRequestWithNoToken } from '@/libs/axios';



// 获取全国城市
const getCountryData = params => getRequest('/common/getCountryData');

export default {
  getCountryData,

}


