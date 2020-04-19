import { getRequest, postRequest, putRequest, deleteRequest, getRequestWithNoToken } from '@/libs/axios';



// 获取全国城市 级联
const getAreaData = params => getRequest('/common/getAreaData');

// 获取全国城市 非级联
const getAllAreaData = params => getRequest('/common/getAllAreaData');

export default {
  getAreaData,
  getAllAreaData,

}


