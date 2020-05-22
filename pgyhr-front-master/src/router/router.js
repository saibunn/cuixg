import Main from '@/views/Main.vue';

// 不作为Main组件的子页面展示的页面单独写，如下
export const loginRouter = {
    path: '/login',
    name: 'login',
    meta: {
        title: '登录 蒲公英HR系统 '
    },
    component: () => import('@/views/login.vue')
};

export const registRouter = {
    path: '/regist',
    name: 'regist',
    meta: {
        title: '注册 蒲公英HR系统'
    },
    component: () => import('@/views/regist.vue')
};

export const registResult = {
    path: '/regist-result',
    name: 'regist-result',
    meta: {
        title: '注册结果 蒲公英HR系统'
    },
    component: () => import('@/views/regist-result.vue')
};

export const authorizeRouter = {
    path: '/authorize',
    name: 'authorize',
    meta: {
        title: '统一认证平台'
    },
    component: () => import('@/views/authorize.vue')
};

// export const page404 = {
//     path: '/*',
//     name: 'error-404',
//     meta: {
//         title: '404-页面不存在'
//     },
//     component: () => import('@/views/error-page/404.vue')
// };

export const page403 = {
    path: '/403',
    meta: {
        title: '403-权限不足'
    },
    name: 'error-403',
    component: () => import('@/views/error-page/403.vue')
};

export const page500 = {
    path: '/500',
    meta: {
        title: '500-服务端错误'
    },
    name: 'error-500',
    component: () => import('@/views/error-page/500.vue')
};

export const locking = {
    path: '/locking',
    name: 'locking',
    component: () => import('@/views/main-components/lockscreen/components/locking-page.vue')
};

// 作为Main组件的子页面展示但是不在左侧菜单显示的路由写在otherRouter里
export const otherRouter = {
    path: '/',
    name: 'otherRouter',
    redirect: '/home',
    component: Main,
    children: [
        { path: 'home', title: { i18n: 'home' }, name: 'home_index', component: () => import('@/views/home/home.vue') },
        { path: 'ownspace', title: '个人中心', name: 'ownspace_index', component: () => import('@/views/own-space/own-space.vue') },
        { path: 'change-pass', title: '修改密码', name: 'change_pass', component: () => import('@/views/change-pass/change-pass.vue') },
        { path: 'message-send-detail', title: '消息发送详情', name: 'message_send_detail', component: () => import('@/views/sys/message-manage/messageSendDetail.vue') }
    ]
};

// 客户管理
export const companyRouter = {
    path: '/',
    name: 'companyRouter',
    redirect: '/home',
    component: Main,
    children: [
        { path: 'add-company-info', title: '新增客户', name: 'add-company-info', component: () => import('@/views/pgyhr-company/companydetail.vue') },
    ]
};

// 雇员前道管理
export const employeeFrontRouter = {
    path: '/',
    name: 'employeeFrontRouter',
    redirect: '/home',
    component: Main,
    children: [
        { path: 'add-employee-info', title: '新增雇员', name: 'add_employee_info', component: () => import('@/views/pgyhr-task/front-task-components/add-employee-info.vue') },
        { path: 'employee-front-task-sheet-items', title: '雇员前道新增任务单', name: 'employee_front_task_sheet_items', component: () => import('@/views/pgyhr-task/front-task-components/employee-front-task-sheet-items.vue') },
        { path: 'employ-front-task-sheet-detail', title: '雇员前道任务单明细', name: 'employ_front_task_sheet_detail', component: () => import('@/views/pgyhr-task/employ-front-task-sheet-detail.vue') },
    ]
};

// 雇员后道管理
export const employeeBackRouter = {
    path: '/',
    name: 'employeeBackRouter',
    redirect: '/home',
    component: Main,
    children: [
        { path: 'employee-back-task-sheet-detail', title: '雇员后道任务单明细', name: 'employee_back_task_sheet_detail', component: () => import('@/views/pgyhr-task/back-task-components/employee-back-task-sheet-detail.vue') },
    ]
};

export const appRouter = [];

// 所有上面定义的路由都要写在下面的routers里
export const routers = [
    loginRouter,
    registRouter,
    registResult,
    authorizeRouter,
    otherRouter,
    companyRouter,
    employeeFrontRouter,
    employeeBackRouter,
    locking,
    ...appRouter,
    page500,
    page403
];
