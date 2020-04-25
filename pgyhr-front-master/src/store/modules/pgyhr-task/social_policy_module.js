import socialPolicyApi from "../../../api/pgyhr-task/social_policy_api";
import Util from "../../../libs/util";
import socialPolicytypes from "../../event-types/pgyhr-task/social_policy_types";

const namespaced = true;
// UI组件所有状态数据
const state = {
    rows: [], // alias list
    socialPolicyList:[],
    socialPolicyParam:{
        cityCode:''
    },
    searchForm:{},

    title: "社保字典",
};

// 收集UI组件的所有事件，可以同步也可以异步提交
const actions = {

    // [socialPolicytypes.SEARCH_SOCIAL_POLICY_BY_PARAM]({commit}, params){
    //     return socialPolicyApi.getSocialPolicyByParam(params).then(response => {
    //         commit(socialPolicytypes.SEARCH_SOCIAL_POLICY_BY_PARAM, response.result)
    //     })
    // },

    [socialPolicytypes.SEARCH_SOCIAL_POLICY_BY_PARAM]({commit, state}, payload){
        console.log("SEARCH_SOCIAL_POLICY_BY_PARAM======result============"+payload);
        state.socialPolicyParam.cityCode = payload;
        socialPolicyApi.getSocialPolicyByParam(state.socialPolicyParam)
            .then(response => {
                //console.log("SEARCH_SOCIAL_POLICY_BY_PARAM======result============"+JSON.stringify(response.result));
                if (response.code == 200) {
                    commit(socialPolicytypes.MUTATE_SEARCH_SOCIAL_POLICY_BY_PARAM, response.result)
                } else {
                    throw(response.message);
                }
            }).catch(error => {
            console.log(error)
        });
    },

};

// 更改组件状态
const mutations = {
    [socialPolicytypes.MUTATE_SEARCH_SOCIAL_POLICY_BY_PARAM](state, result){
        //console.log("MUTATE_SEARCH_SOCIAL_POLICY_BY_PARAM======result============"+JSON.stringify(result));
        // var list = result;
        // state.empTaskList = list;
        // console.log("COMPANY_PAGE=========state.rows========="+JSON.stringify(state.rows));
        state.socialPolicyList = result;
    },

    // [socialPolicytypes.MUTATE_SOCIAL_POLICY_PARAM_CHANGE](state, data){
    //     state.socialPolicyParam = data;
    // },
};

// UI 组件数据
const getters = {
    getRows: state => state.rows,
};

export default {
    namespaced: namespaced,
    state,
    actions,
    mutations,
    getters,
};
