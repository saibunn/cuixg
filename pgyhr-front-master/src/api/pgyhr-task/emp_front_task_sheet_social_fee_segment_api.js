import { getRequest, postRequest,postCollectionRequest, putRequest, deleteRequest, getRequestWithNoToken } from '@/libs/axios';



// 根据条件获取社保字典
const getSocialPolicyByParam = params => getRequest('/socialPolicy/getSocialPolicyByParam', params);


export default {
  getSocialPolicyByParam
}
