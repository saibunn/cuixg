import areaApi from "../../../api/common/area_api.js";
import Util from "../../../libs/util";
import areaTypes from "../../event-types/common/area_types";

const namespaced = true;

// UI组件所有状态数据
const state = {
  areaData: [],
  // areaAllData: [],
  // areaUserData: [],
};

// 收集UI组件的所有事件，可以同步也可以异步提交
const actions = {
  [areaTypes.AREA_DATA]({commit}, params){
    console.log("get area_DATA==="+params);
    return areaApi.getAreaData(params).then(response => {
      commit(areaTypes.AREA_DATA, response.result)
    })
  },
  //
  // [areaTypes.area_ALL_DATA]({commit}, params){
  //   return commonApi.getAllareaList(params).then(response => {
  //     commit(areaTypes.MUTATE_area_ALL_DATA, response.data)
  //   })
  // },
  //
  // [areaTypes.area_USER_DATA]({commit}, params){
  //   return commonApi.getUserareaList(params).then(response => {
  //     commit(areaTypes.MUTATE_area_USER_DATA, response.data)
  //   })
  // },
};

// 更改组件状态
const mutations = {
  [areaTypes.AREA_DATA](state, data){
    console.log("result AREA_DATA==="+JSON.stringify(data));


    state.areaData = [];
    const list = data;
    list.forEach(i => {
      const areaArr=[];
      const areaList = i.areaDTOList;
      areaList.forEach(j => {
        areaArr.push({
          value: j.areaCode,
          label: j.areaName,
        })
      });
      state.areaData.push({
        value: i.areaCode,
        label: i.areaName,
        children: areaArr
      });



    });

    console.log("area_DATA1123543==="+JSON.stringify(state.areaData));
  },

  // [areaTypes.MUTATE_area_ALL_DATA](state, data){
  //   if (data.code === 0) {
  //     state.areaAllData = data.object;
  //   }
  // },
  // [areaTypes.MUTATE_area_USER_DATA](state, data){
  //   if (data.code === 0) {
  //     state.areaUserData = data.object;
  //     console.log("state.areaUserData=========="+JSON.stringify(state.areaUserData));
  //   }
  // }
};

// UI 组件数据
const getters = {
  getRows: state => state.areaData,
};

export default {
  namespaced: namespaced,
  state,
  actions,
  mutations,
  getters,
};
