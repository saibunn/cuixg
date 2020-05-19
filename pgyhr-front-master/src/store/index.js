import Vue from 'vue';
import Vuex from 'vuex';

import app from './modules/app';
import user from './modules/user';
import dict from './modules/dict';

import companyModule from './modules/pgyhr-company/company_module';
import areaModule from './modules/common/area_module';
import countryModule from './modules/common/country_module';
import employeeTaskModule from './modules/pgyhr-task/employee-task-module';
import employeeFrontTaskModule from './modules/pgyhr-task/employee_front_task_module';
import socialPolicyModule from './modules/pgyhr-task/social_policy_module';
import empFrontTaskSheetSocialFeeSegmentModule from './modules/pgyhr-task/emp_front_task_sheet_social_fee_segment_module';
import employeeBackTaskSheetModule from './modules/pgyhr-task/employee_back_task_sheet_module.js';
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
        employeeFrontTaskModule: employeeFrontTaskModule,
        socialPolicyModule: socialPolicyModule,
        empFrontTaskSheetSocialFeeSegmentModule: empFrontTaskSheetSocialFeeSegmentModule,
        employeeBackTaskSheetModule: employeeBackTaskSheetModule,
        app,
        user,
        dict
    }
});

export default store;
