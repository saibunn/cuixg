import { getRequest, postRequest, putRequest, deleteRequest, getRequestWithNoToken } from '@/libs/axios';



// 获取全国城市
const getAreaData = params => getRequest('/common/getAreaData');

export default {
  getAreaData,

}


