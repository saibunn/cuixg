import countryApi from "../../../api/common/country_api.js";
import Util from "../../../libs/util";
import countryTypes from "../../event-types/common/country_types";

const namespaced = true;

// UI组件所有状态数据
const state = {
  countryData: [],
};

// 收集UI组件的所有事件，可以同步也可以异步提交
const actions = {
  [countryTypes.COUNTRY_DATA]({commit}, params){
    console.log("get COUNTRY_DATA==="+params);
    return countryApi.getCountryData(params).then(response => {
      commit(countryTypes.COUNTRY_DATA, response.result)
    })
  },
};

// 更改组件状态
const mutations = {
  [countryTypes.COUNTRY_DATA](state, data){
    console.log("result COUNTRY_DATA==="+JSON.stringify(data));


    state.countryData = data;
    // const list = data;
    // list.forEach(i => {
    //   state.countryData.push({
    //     value: i.code,
    //     label: i.name,
    //   });
    //
    //
    //
    // });

    console.log("COUNTRY_DATA==="+JSON.stringify(state.countryData));
  },
};

// UI 组件数据
const getters = {
  getRows: state => state.countryData,
};

export default {
  namespaced: namespaced,
  state,
  actions,
  mutations,
  getters,
};
