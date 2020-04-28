import axios from 'axios';
import { getMenuList } from '@/api/index';
import lazyLoading from './lazyLoading.js';
import router from '@/router/index';
import Cookies from "js-cookie";
import moment from 'moment'
import {localStorage, sessionStorage} from '../libs/storage'

let util = {
    // 默认分页大小 5
    DEFAULT_PAGE_SIZE: 5,
    DEBUG: true
};

// let math = {
//     _thisMath: require('mathjs'),
//     eval (value) {
//         return this._thisMath.eval(value)
//     },
//     multiply (arg1, arg2) {
//         return this._thisMath.format(this._thisMath.multiply(arg1, arg2), {precision: 14})
//     }
// }

let storage = {
    setItem (key, value) {
        try {
            sessionStorage.setItem(key, value)
        } catch (err) {}
    },
    getItem (key) {
        let returnObj = sessionStorage.getItem(key)
        if (returnObj) {
            return returnObj
        } else {
            return ''
        }
    }
}

let commons = {

    /**
     * [去除JSON数据中需要去除前后空格的字段]
     *
     * @param jsonObj json对象
     * @param paramArr 存储去除空格的字段数组
     */
    filterSpaceForJSON (jsonObj, paramArr) {
        paramArr.forEach((item) => {
            if (jsonObj[item] !== undefined) {
                jsonObj[item] = String(jsonObj[item]).trim()
            }
        })
    },
    /**
     * 判断一个对象是否为空
     * @param v
     * @returns {boolean}
     */
    isEmpty (v) {
        return v === undefined || v === null || v === ''
    }

}

let dateUtils = {
    /**
     * [getFirstDay 获取当前月的第一天]
     *
     * @method getFirstDay
     * @param  {[Date]}    date
     * @return {[Date]}
     */
    getFirstDay (date) {
        let momentDate = moment(date)
        if (momentDate.isValid()) {
            momentDate.startOf('month').startOf('day')
            return momentDate.toDate()
        }
        return new Date(date.getFullYear(), date.getMonth(), 1)
    },
    /**
     * [getLastDay 获取当前月的最后一天]
     *
     * @method getLastDay
     * @param  {[Date]}   date
     * @return {[Date]}
     */
    getLastDay (date) {
        let momentDate = moment(date)
        if (momentDate.isValid()) {
            momentDate.endOf('month').startOf('day')
            return momentDate.toDate()
        }
    },
    /**
     * [addMonth 添加月份]
     *
     * @method addMonth
     * @param  {[Date]} date
     * @param  {[Integer]} step
     */
    addMonth (date, step) {
        let momentDate = moment(date)
        if (momentDate.isValid()) {
            if (step > 0) {
                momentDate.add(step, 'M')
            } else {
                momentDate.subtract(step, 'M')
            }
            return momentDate.toDate()
        }
    },
    /**
     * [check NextMonth]
     *
     * @method checkNextMonth
     * @param  {[Date]}       date
     * @param  {[String]}       nextDay [start or end]
     * @return {[Date]}
     */
    checkNextMonth (date, nextDay) {
        let momentDate = moment(date)
        if (momentDate.isValid()) {
            if (momentDate.date() > 15) {
                momentDate.add(1, 'M')
            }
            if (nextDay) {
                if (nextDay === 'start') {
                    momentDate.startOf('month').startOf('day')
                } else if (nextDay === 'end') {
                    momentDate.endOf('month').startOf('day')
                }
            }
            return momentDate.toDate()
        }
    },

    /**
     * 15号之前上月, 15号之后当月
     * @param date
     * @returns {Date}
     */
    checkCurrentMonth (date) {
        let momentDate = moment(date)
        if (momentDate.isValid()) {
            if (momentDate.date() <= 15) {
                momentDate.add(-1, 'M')
            }
            momentDate.endOf('month').startOf('day')
            return momentDate.toDate()
        }
        return ''
    },

    /**
     * [stdFormatDate 日期格式化]
     *
     * @method stdFormatDate
     * @param  {[Date]} date
     */
    stdFormatDate (date) {
        if (date !== '' && date !== undefined) {
            return moment(date).format('YYYY-MM-DD')
        }
        return ''
    },

    format (date, formatStr) {
        if (date !== '' && date !== undefined) {
            return new Date(date).format(formatStr)
        }
        return ''
    },

    /**
     * 解析日期
     * @param dateString 日期字符串
     * @param fmt 日期格式
     * @returns Date
     */
    parseDate(dateString, fmt) {
        // utc 解决时区问题
        return moment.utc(dateString, fmt);
    },

    /**
     * [stdFormatDate 日期格式化]
     *
     * @method stdFormatDate
     * @param  {[Date]} date
     */
    stdFormatMonth (date) {
        if (date !== '' && date !== undefined) {
            return moment(date).format('YYYYMM')
        }
        return ''
    },
    /**
     * 比较两个日期是否相等
     * @param Date1
     * @param Date2
     * @param dateFormat
     * @returns {boolean}
     */
    isDateEquals (Date1, Date2, dateFormat) {
        let isChange = false
        if (commons.isEmpty(Date1) && commons.isEmpty(Date2)) {
            isChange = true
        } else if ((commons.isEmpty(Date1) && !commons.isEmpty(Date2)) || (!commons.isEmpty(Date1) && commons.isEmpty(Date2))) {
            isChange = false
        } else {
            if (!dateFormat) {
                dateFormat = 'YYYY-MM-DD'
            }
            if (moment(Date1).format(dateFormat) === moment(Date2).format(dateFormat)) {
                isChange = true
            }
        }
        return isChange
    },

    /**
     * 根据出生日期计算年龄
     * @param getAge
     * @returns {number}
     */
    getAge (birthdayDate) {
        let aDate = new Date()
        let thisYear = aDate.getFullYear()
        let bDate = new Date(birthdayDate)
        let brith = bDate.getFullYear()
        let age = (thisYear - brith)
        return age
    }

}

let local = {
    // edits: false, //新建or编辑
    // typeName: [],
    save(key, value) {
        localStorage.setItem(key, value)
        //
    },
    fetch(key) {
        return localStorage.getItem(key) || {}
    },
    back(vm, step) {
        window.history.go(-1)
        //  window.history.back();
    },
    fuzzyQuery(query, source, type) {
        if (query !== '') {
            const list = source.map(item => {
                return {
                    value: item[type],
                    label: item[type]
                }
            })
            return list.filter(item => item.label.toLowerCase().indexOf(query.toLowerCase()) > -1)
        } else {
            return []
        }
    },
    titleCase(str) {
        // 将字符串分解为数组并将其小写化
        let convertToArray = str.toLowerCase().split(' ')
        for (let i = 0; i < convertToArray.length; i++) {
            let char = convertToArray[i].charAt(0)
            // 使用 replace()方法将数组中的每个首字母大写化
            convertToArray[i] = convertToArray[i].replace(char, function replace(char) {
                return char.toUpperCase()
            })
        }
        return convertToArray.join(' ')
    },
    addClasses(obj, cls) {
        if (!this.hasClass(obj, cls)) obj.className += ' ' + cls
    }
};


util.title = function (title) {
    title = title || 'pgyhr前后端分离开发平台';
    window.document.title = title;
};

util.inOf = function (arr, targetArr) {
    let res = true;
    arr.forEach(item => {
        if (targetArr.indexOf(item) < 0) {
            res = false;
        }
    });
    return res;
};

util.oneOf = function (ele, targetArr) {
    if (targetArr.indexOf(ele) >= 0) {
        return true;
    } else {
        return false;
    }
};

util.getRouterObjByName = function (routers, name) {
    if (!name || !routers || !routers.length) {
        return null;
    }
    // debugger;
    let routerObj = null;
    for (let item of routers) {
        if (item.name == name) {
            return item;
        }
        routerObj = util.getRouterObjByName(item.children, name);
        if (routerObj) {
            return routerObj;
        }
    }
    return null;
};

util.handleTitle = function (vm, item) {
    if (typeof item.title == 'object') {
        return vm.$t(item.title.i18n);
    } else {
        return item.title;
    }
};

util.setCurrentPath = function (vm, name) {
    let title = '';
    let isOtherRouter = false;
    vm.$store.state.app.routers.forEach(item => {
        if (item.children.length == 1) {
            if (item.children[0].name == name) {
                title = util.handleTitle(vm, item);
                if (item.name == 'otherRouter') {
                    isOtherRouter = true;
                }
            }
        } else {
            item.children.forEach(child => {
                if (child.name == name) {
                    title = util.handleTitle(vm, child);
                    if (item.name == 'otherRouter') {
                        isOtherRouter = true;
                    }
                }
            });
        }
    });
    let currentPathArr = [];
    if (name == 'home_index') {
        currentPathArr = [
            {
                title: util.handleTitle(vm, util.getRouterObjByName(vm.$store.state.app.routers, 'home_index')),
                path: '',
                name: 'home_index'
            }
        ];
    } else if ((name.indexOf('_index') >= 0 || isOtherRouter) && name !== 'home_index') {
        currentPathArr = [
            {
                title: util.handleTitle(vm, util.getRouterObjByName(vm.$store.state.app.routers, 'home_index')),
                path: '/home',
                name: 'home_index'
            },
            {
                title: title,
                path: '',
                name: name
            }
        ];
    } else {
        let currentPathObj = vm.$store.state.app.routers.filter(item => {
            if (item.children.length <= 1) {
                return item.children[0].name == name;
            } else {
                let i = 0;
                let childArr = item.children;
                let len = childArr.length;
                while (i < len) {
                    if (childArr[i].name == name) {
                        return true;
                    }
                    i++;
                }
                return false;
            }
        })[0];
        console.log("currentPathObj======result============"+currentPathObj.title);
        if (currentPathObj.children.length <= 1 && currentPathObj.name == 'home') {
            currentPathArr = [
                {
                    title: '首页',
                    path: '',
                    name: 'home_index'
                }
            ];
        } else if (currentPathObj.children.length <= 1 && currentPathObj.name !== 'home') {
            currentPathArr = [
                {
                    title: '首页',
                    path: '/home',
                    name: 'home_index'
                },
                {
                    title: currentPathObj.title,
                    path: '',
                    name: name
                }
            ];
        } else {
            let childObj = currentPathObj.children.filter((child) => {
                return child.name == name;
            })[0];
            currentPathArr = [
                {
                    title: '首页',
                    path: '/home',
                    name: 'home_index'
                },
                {
                    title: currentPathObj.title,
                    path: '',
                    name: currentPathObj.name
                },
                {
                    title: childObj.title,
                    path: currentPathObj.path + '/' + childObj.path,
                    name: name
                }
            ];
        }
    }
    vm.$store.commit('setCurrentPath', currentPathArr);

    return currentPathArr;
};

util.openNewPage = function (vm, name, argu, query) {
    if(!vm.$store){
        return;
    }
    let pageOpenedList = vm.$store.state.app.pageOpenedList;
    let openedPageLen = pageOpenedList.length;
    let i = 0;
    let tagHasOpened = false;
    while (i < openedPageLen) {
        if (name == pageOpenedList[i].name) { // 页面已经打开
            vm.$store.commit('pageOpenedList', {
                index: i,
                argu: argu,
                query: query
            });
            tagHasOpened = true;
            break;
        }
        i++;
    }
    if (!tagHasOpened) {
        let tag = vm.$store.state.app.tagsList.filter((item) => {
            if (item.children) {
                return name == item.children[0].name;
            } else {
                return name == item.name;
            }
        });
        tag = tag[0];
        if (tag) {
            tag = tag.children ? tag.children[0] : tag;
            if (argu) {
                tag.argu = argu;
            }
            if (query) {
                tag.query = query;
            }
            vm.$store.commit('increateTag', tag);
        }
    }
    vm.$store.commit('setCurrentPageName', name);
};

util.toDefaultPage = function (routers, name, route, next) {
    let len = routers.length;
    let i = 0;
    let notHandle = true;
    while (i < len) {
        if (routers[i].name == name && routers[i].children && routers[i].redirect == undefined) {
            route.replace({
                name: routers[i].children[0].name
            });
            notHandle = false;
            next();
            break;
        }
        i++;
    }
    if (notHandle) {
        next();
    }
};

util.fullscreenEvent = function (vm) {
    vm.$store.commit('initCachepage');
};

util.initRouter = function (vm) {
    const constRoutes = [];
    const otherRoutes = [];

    // 404路由需要和动态路由一起加载
    const otherRouter = [{
        path: '/*',
        name: 'error-404',
        meta: {
            title: '404-页面不存在'
        },
        component: 'error-page/404'
    }];
    // 判断用户是否登录
    let userInfo = Cookies.get('userInfo')
    if (!userInfo) {
        // 未登录
        return;
    }
    // 第一次加载 读取数据
    let accessToken = window.localStorage.getItem('accessToken');
    // 加载菜单
    axios.get(getMenuList, { headers: { 'accessToken': accessToken } }).then(res => {
        let menuData = res.result;
        if (!menuData) {
            return;
        }
        util.initAllMenuData(constRoutes, menuData);
        util.initRouterNode(otherRoutes, otherRouter);
        // 添加所有主界面路由
        vm.$store.commit('updateAppRouter', constRoutes.filter(item => item.children.length > 0));
        // 添加全局路由
        vm.$store.commit('updateDefaultRouter', otherRoutes);
        // 添加菜单路由
        util.initMenuData(vm, menuData);
        // 缓存数据 修改加载标识
        window.localStorage.setItem('menuData', JSON.stringify(menuData));
        vm.$store.commit('setAdded', true);
    });
    // if (!vm.$store.state.app.added) {
    //     // 第一次加载 读取数据
    //     let accessToken = window.localStorage.getItem('accessToken');
    //     // 加载菜单
    //     axios.get(getMenuList, { headers: { 'accessToken': accessToken } }).then(res => {
    //         let menuData = res.result;
    //         if (!menuData) {
    //             return;
    //         }
    //         util.initAllMenuData(constRoutes, menuData);
    //         util.initRouterNode(otherRoutes, otherRouter);
    //         // 添加所有主界面路由
    //         vm.$store.commit('updateAppRouter', constRoutes.filter(item => item.children.length > 0));
    //         // 添加全局路由
    //         vm.$store.commit('updateDefaultRouter', otherRoutes);
    //         // 添加菜单路由
    //         util.initMenuData(vm, menuData);
    //         // 缓存数据 修改加载标识
    //         window.localStorage.setItem('menuData', JSON.stringify(menuData));
    //         vm.$store.commit('setAdded', true);
    //     });
    // } else {
    //     // 读取缓存数据
    //     let data = window.localStorage.getItem('menuData');
    //     if(!data){
    //         vm.$store.commit('setAdded', false);
    //         return;
    //     }
    //     let menuData = JSON.parse(data);
    //     // 添加菜单路由
    //     util.initMenuData(vm, menuData);
    // }
};

// 添加所有顶部导航栏下的菜单路由
util.initAllMenuData = function (constRoutes, data) {

    let allMenuData = [];
    data.forEach(e => {
        if(e.type==-1){
            e.children.forEach(item=>{
                allMenuData.push(item);
            })
        }
    })
    util.initRouterNode(constRoutes, allMenuData);
}

// 生成菜单格式数据
util.initMenuData = function (vm, data) {
    const menuRoutes = [];
    let menuData = data;
    // 顶部菜单
    let navList = [];
    menuData.forEach(e => {
        let nav = {
            name: e.name,
            title: e.title,
            icon: e.icon
        }
        navList.push(nav);
    })
    if (navList.length < 1) {
        return;
    }
    // 存入vuex
    vm.$store.commit('setNavList', navList);
    let currNav = window.localStorage.getItem('currNav')
    if (currNav) {
        // 读取缓存title
        for (var item of navList) {
            if (item.name == currNav) {
                vm.$store.commit('setCurrNavTitle', item.title);
                break;
            }
        }
    } else {
        // 默认第一个
        currNav = navList[0].name;
        vm.$store.commit('setCurrNavTitle', navList[0].title);
    }
    vm.$store.commit('setCurrNav', currNav);
    for (var item of menuData) {
        if (item.name == currNav) {
            // 过滤
            menuData = item.children;
            break;
        }
    }
    util.initRouterNode(menuRoutes, menuData);
    // 刷新界面菜单
    vm.$store.commit('updateMenulist', menuRoutes.filter(item => item.children.length > 0));

    let tagsList = [];
    vm.$store.state.app.routers.map((item) => {
        if (item.children.length <= 1) {
            tagsList.push(item.children[0]);
        } else {
            tagsList.push(...item.children);
        }
    });
    vm.$store.commit('setTagsList', tagsList);
};

// 生成路由节点
util.initRouterNode = function (routers, data) {

    for (var item of data) {
        let menu = Object.assign({}, item);
        // menu.component = import(`@/views/${menu.component}.vue`);
        menu.component = lazyLoading(menu.component);

        if (item.children && item.children.length > 0) {
            menu.children = [];
            util.initRouterNode(menu.children, item.children);
        }

        let meta = {};
        // 给页面添加权限、标题、第三方网页链接
        meta.permTypes = menu.permTypes ? menu.permTypes : null;
        meta.title = menu.title ? menu.title + " - pgyhr前后端分离开发平台" : null;
        meta.url = menu.url ? menu.url : null;
        menu.meta = meta;

        routers.push(menu);
    }
};

export default util;
