import Vue from 'vue';
import Vuex from 'vuex';

import app from './modules/app';
import user from './modules/user';
import dict from './modules/dict';

import companyModule from './modules/pgyhr-company/company-module';

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
        app,
        user,
        dict
    }
});

export default store;
