import Vue from 'vue';
import Vuex from 'vuex';

import app from './modules/app';
import user from './modules/user';
import dict from './modules/dict';

import companyModule from './modules/pgyhr-company/company-module';
import areaModule from './modules/common/area_module';
import countryModule from './modules/common/country_module';
import employeeTaskModule from './modules/pgyhr-task/employee-task-module';
import socialPolicyModule from './modules/pgyhr-task/social_policy_module';
Vue.use(Vuex);

const store = new Vuex.Store({
    state: {
        // 状态

    },
    mutations: {
        // 改变方法
    },
    actions: {

    },
    modules: {
        companyModule: companyModule,
        areaModule: areaModule,
        countryModule: countryModule,
        employeeTaskModule: employeeTaskModule,
        socialPolicyModule: socialPolicyModule,
        app,
        user,
        dict
    }
});

export default store;
