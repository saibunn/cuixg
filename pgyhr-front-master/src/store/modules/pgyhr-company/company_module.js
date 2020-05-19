import companyApi from "../../../api/pgyhr-company/company-api";
import Util from "../../../libs/util";
import companyTypes from "../../event-types/pgyhr-company/company-types";

const namespaced = true;
// UI组件所有状态数据
const state = {
    rows: [], // alias list
    companyList:[],

    companyPage: {
        total: 0,
        size: Util.DEFAULT_PAGE_SIZE,
        currentPage: 1,
    },

    title: "客户公司",
};

// 收集UI组件的所有事件，可以同步也可以异步提交
const actions = {

    [companyTypes.ALL_COMPANY]({commit},params){
        console.log("this.ALL_COMPANY=================="+JSON.stringify(params));
        return companyApi.getCompanyAll(params).then(response => {
                commit(companyTypes.ALL_COMPANY, response.result)
            }
        )
    },
    [companyTypes.ADD_COMPANY]({commit}, params){
        console.log("this.ADD_COMPANY=================="+JSON.stringify(params));
        return companyApi.saveCompany(params);
    },
    [companyTypes.COMPANY_PAGE]({commit}, params){
        console.log("this.COMPANY_PAGE=================="+JSON.stringify(params));
        return companyApi.getCompanyPage(params).then(response => {
                commit(companyTypes.COMPANY_PAGE, response.result)
            }
        )
    },
    [companyTypes.COMPANY_LEVEL]({commit}, params){
        console.log("this.COMPANY_LEVEL=================="+JSON.stringify(params));
        return companyApi.getCompanyLevel(params);
    },
    [companyTypes.COMPANY_CODE]({commit}, params){
        console.log("this.COMPANY_CODE=================="+JSON.stringify(params));
        return companyApi.getCompanyCode(params);
    },
    [companyTypes.UPDATE_COMPANY]({commit}, params){
        console.log("this.UPDATE_COMPANY=================="+JSON.stringify(params));
        return companyApi.updCompany(params);
    },
    [companyTypes.DELETE_COMANY]({commit}, params){
        console.log("this.DELETE_COMANY=================="+JSON.stringify(params));
        return companyApi.delCompany(params);
    },

};

// 更改组件状态
const mutations = {
    [companyTypes.ALL_COMPANY](state, result){
        console.log("ALL_COMPANY======result============"+JSON.stringify(result));
        state.companyList = result;
    },
    [companyTypes.COMPANY_PAGE](state, result){
        console.log("COMPANY_PAGE======result============"+JSON.stringify(result));
        var list = result.records;
        state.rows = list;
        console.log("COMPANY_PAGE=========state.rows========="+JSON.stringify(state.rows));
        state.companyPage.total = result.total;
    }
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
