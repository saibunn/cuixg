import moment from 'moment'

export default {
  install (Vue, store, options) {
    /**
     * 公共数据字典
     */
    Vue.prototype.baseDic = {

      employFeedbackList: {
        0: '空',
        3: '用工成功',
        10: '用工已办查无档',
        4: '用工失败',
        11: 'Ukey外借',
        5: '前道要求撤销用工',
        12: '用工成功,重复任务单',
        13: '用工已办,前道已中止'
      },
      employStyle: {
        1: '合同制职工（企业险）',
        2: '行业统筹省编',
        3: '行业统筹地编'
      },
      resignFeedback: {
        1: '退工任务单签收',
        2: '档未到先退工',
        3: '退工盖章未返回',
        4: '退工失败',
        5: '前道要求批退',
        6: '撤销退工',
        7: '等修改备案表',
        8: '自开退工单,未交',
        9: '用工已办未反馈',
        10: '等翻牌联系单',
        11: '退工Ukey外借',
        12: '单项服务,原退工成功',
        13: '转外地社保,原退工成功',
        14: '转人员性质无需退工',
        15: '退工成功,改社保',
        16: '重复任务单'
      },
      companyLicenseType: {
        1: '三证',
        2: '三证合一',
        3: '其他'
      },
      activeType: {
        'empMakeUp': 70,
        'empAgreementAdjust': 50,
        'empAgreementUpdate': 40,
        'empAdjustYearly': 100
      },
      productProperty: {
        0: '通用', 1: '派遣', 2: '代理'
      },
      isTax: {
        0: '不含税', 1: '含税'
      },
      idCardType: {
        1: '身份证', 2: '护照', 3: '军(警)官证', 4: '士兵证', 5: '台胞证', 6: '回乡证', 7: '其他'
      },
      // idCardType: [
      //   {value: 1, label: '身份证'},
      //   {value: 2, label: '护照'},
      //   {value: 3, label: '军(警)官证'},
      //   {value: 4, label: '士兵证'},
      //   {value: 5, label: '台胞证'},
      //   {value: 5, label: '回乡证'},
      //   {value: 5, label: '其他'},
      // ],
      gender: {
        1: '男', 0: '女'
      },
      genderTrueOrFalse: {
        true: '男', false: '女'
      },
      marriageStatus: {
        1: '未婚', 2: '已婚'
      },
      residentType: {
        1: '本地城镇', 2: '省内市外',3: '本地农业', 4: '外省',5: '其他'
      },
      trueOrFalse: {
        0: '否', 1: '是'
      },
      trueOrFalseStr: {
        'false': '否', 'true': '是'
      },
      salaryPayType: {
        0: '用工单位', 1: '蒲公英'
      },
      workType: {
        0: '标准工时', 1: '不定时工时', 2: '综合工时'
      },
      employeeStatus: {
        0: '预增', 1: '报入职', 2: '在职', 3: '报离职', 4: '离职'
      },
      templateTypes: {
        1: '派遣', 2: '代理', 3: '业务外包'
      },
      postType: {
        1: '常规入职', 2: '集体转入'
      },
      socialType: {
        1: '社保', 2: '公积金'
      },
      laborSide: {
        1: '蒲公英', 2: '蒲公英外包', 3: '客户代签', 4: '客户自签'
      },
      laborType: {
        1: '固定期限劳动合同', 2: '无固定期限劳动合同', 3: '完成一定工作为期限劳动合同', 4: '非全日制劳动合同'
      },
      laborSignType: {
        1: '新订', 2: '续订', 3: '变更', 4: '未订'
      },
      technicalPost:{
        1: '正高级技术职务', 2: '副高级技术职务', 3: '中级技术职务', 4: '助理级技术职务', 5: '员级技术职务', 6: '职改前工程师', 7: '未评定技术职务'
      },
      administrativePost:{
        1: '无行政职务级别', 2: '部长级', 3: '相当部长级', 4: '副部长级', 5: '相当副部长级', 6: '司局级', 7: '巡视员', 8: '相当司局级', 9: '副司局级',
        10: '助理巡视员', 11: '相当副司局级', 12: '处级'
      },
      eduLevel:{
        1: '博士后', 2: '博士研究生', 3: '硕士', 4: '硕士研究生', 5: '大学本科', 6: '大学专科', 7: '中专', 8: '中等专科', 9: '职业高中',
        10: '技工学校', 11: '技校', 12: '普通高中', 13: '职高', 14: '职专', 15: '初中', 16: '小学', 17: '文盲或半文盲', 18: '其他'
      },
      empType:{
        1: '新成长失业人员', 2: '就业转失业人员', 3: '其他失业人员', 4: '在业人员', 5: '退休人员', 6: '在学人员', 7: '退伍军人', 8: '农村劳动力', 9: '外来劳动力', 10: '其他'
      },
      empIdentity:{
        1: '工人', 2: '原工商业者', 3: '农民', 4: '学生', 5: '干部', 6: '现役军人', 7: '无业人员', 8: '无业人员'
      },
      unitMap: {
        1: '独立户', 2: '大库'
      },
      agreementStatus: {
        1: '历史', 2: '在用', 3: '将来'
      },
      agreementChangeType: {
        1: '新增', 2: '更正', 3: '补缴', 4: '调整', 5: '首月金额', 6: '翻牌', 7: '末月金额', 8: '取消离职', 9: '取消末月金额', 10: '还原数据', 11: '取消入职', 12: '取消首月金额', 13: '年调', 14: '换机构'
      },
      outReason: {
        1: '辞职',
        2: '协商解除',
        3: '公司解聘',
        4: '合同到期',
        5: '关闭',
        6: '出国',
        7: '退休',
        8: '工伤死亡',
        // '9': '取消入职',
        10: '死亡',
        11: '转科技人才',
        12: '转用工单位（翻牌）',
        13: '公司自行管理, 无需退工',
        14: '公司自行管理, 需办退工',
        15: '转其他公司管理, 无需退工',
        16: '转其他公司管理, 需办退工'
      },
      outPolicyType: {
        1: '转出', 2: '封存'
      },
      relationShip: {
        1: '配偶', 2: '子女', 3: '父母', 4: '其他'
      },
      childName: {
        1: '无子女', 2: '独生子女', 3: '有子女但非独生子女'
      },
      healthName: {
        1: '健康或良好', 2: '残疾', 3: '一般或软弱', 4: '有疾病', 5: '有生理缺陷'
      },
      policy: {
        0: '团员', 1: '党员', 2: '群众', 3: '民主党派'
      },
      roundType: [
        {
          value:8 ,
          label : '四舍五入到分'
        },
        {
          value:9 ,
          label : '四舍五入到角'
        },
        {
          value: 10,
          label : '四舍五入到元'
        },
        {
          value:1 ,
          label : '见分进角'
        },
        {
          value:2 ,
          label : '见角进元'
        },
        {
          value:3 ,
          label : '进位到元'
        },
        {
          value:4 ,
          label : '进位偶数'
        },
        {
          value:5 ,
          label : '舍去角'
        },
        {
          value:6 ,
          label : '舍去分'
        },
        {
          value:7 ,
          label : '舍去厘'
        }
      ],
      //民族
      nationData: [
        {id:1 ,name:'汉族'},
        {id:2 ,name:'蒙古族'},
        {id:3 ,name:'回族'},
        {id:4 ,name:'藏族'},
        {id:5 ,name:'维吾尔族'},
        {id:6 ,name:'苗族'},
        {id:7 ,name:'彝族'},
        {id:8 ,name:'壮族'},
        {id:9 ,name:'布依族'},
        {id:10,name:'朝鲜族'},
        {id:11,name:'满族'},
        {id:12,name:'侗族'},
        {id:13,name:'瑶族'},
        {id:14,name:'白族'},
        {id:15,name:'土家族'},
        {id:16,name:'哈尼族'},
        {id:17,name:'哈萨克族'},
        {id:18,name:'傣族'},
        {id:19,name:'黎族'},
        {id:20,name:'傈僳族'},
        {id:21,name:'佤族'},
        {id:22,name:'畲族'},
        {id:23,name:'高山族'},
        {id:24,name:'拉祜族'},
        {id:25,name:'水族'},
        {id:26,name:'东乡族'},
        {id:27,name:'纳西族'},
        {id:28,name:'景颇族'},
        {id:29,name:'柯尔克孜族'},
        {id:30,name:'土族'},
        {id:31,name:'达翰尔族'},
        {id:32,name:'么佬族'},
        {id:33,name:'羌族'},
        {id:34,name:'布朗族'},
        {id:35,name:'撒拉族'},
        {id:36,name:'毛南族'},
        {id:37,name:'仡佬族'},
        {id:38,name:'锡伯族'},
        {id:39,name:'阿昌族'},
        {id:40,name:'普米族'},
        {id:41,name:'塔吉克族'},
        {id:42,name:'怒族'},
        {id:43,name:'乌孜别克族'},
        {id:44,name:'俄罗斯族'},
        {id:45,name:'鄂温克族'},
        {id:46,name:'德昂族'},
        {id:47,name:'保安族'},
        {id:48,name:'裕固族'},
        {id:49,name:'京族'},
        {id:50,name:'塔塔尔族'},
        {id:51,name:'独龙族'},
        {id:52,name:'鄂伦春族'},
        {id:53,name:'赫哲族'},
        {id:54,name:'门巴族'},
        {id:55,name:'珞巴族'},
        {id:56,name:'基诺族'},
      ],

      proDefKey: {
        'emp_in': '雇员新增',
        'emp_agreement_adjust': '雇员调整',
        'emp_agreement_update': '雇员更正',
        'emp_out': '雇员终止',
        'emp_company_change': '翻牌',
        'emp_make_up': '补缴',
        'emp_adjust_yearly': '年调',
        'emp_once_hire_info_update': '用工变更',
        'emp_once_fire_info_update': '退工变更'
      },
      status: {
        0: '未处理',
        1: '已处理',
        2: '驳回'
      },
      managementSource: {
        0: '未知',
        1: '自主开发',
        2: '客户介绍',
        3: '来电来访',
        4: '中智注册',
        5: '电话销售',
        6: '市场商机导入'
      },
      taskDefKey: {
        'emp_info_confirm': '雇员信息确认',
        'hire_info_confirm': '用工信息确认',
        'hire_material_recieve': '入职材料收集',
        'agreement_sign': '签订雇员劳动合同',
        'fund_info_confirm': '公积金信息确认',
        'add_fund_info_confirm': '补充公积金信息确认',
        'social_info_confirm': '社保信息确认',
        'insurance_info_confirm': '投保信息确认',
        'health_exam_info_confirm': '体检信息确认',
        'nonlocal_social_new': '新增社保委托',
        'nonlocal_fund_new': '新增公积金委托',
        'nonlocal_add_fund_new': '新增补充公积金委托',
        'nonlocal_product_new': '新增产品委托',
        'hire': '用工',
        'fund_new': '公积金办理',
        'add_fund_new': '补充公积金办理',
        'social_new': '社保办理',
        'insurance_new': '投保',
        'health_exam_new': '新增体检',
        'nonlocal_social_stop': '社保终止委托',
        'nonlocal_fund_stop': '公积金终止委托',
        'nonlocal_add_fund_stop': '补充公积金终止委托',
        'nonlocal_product_stop': '产品终止委托',
        'fire': '退工',
        'social_stop': '社保停办',
        'fund_stop': '公积金停办',
        'add_fund_stop': '补充公积金停办',
        'insurance_stop': '退保',
        'health_exam_stop': '终止体检',
        'nonlocal_social_make_up': '社保补缴委托',
        'nonlocal_fund_make_up': '公积金补缴委托',
        'nonlocal_add_fund_make_up': '补充公积金补缴委托',
        'fund_make_up': '公积金补缴',
        'add_fund_make_up': '补充公积金补缴',
        'social_make_up': '社保补缴',
        'fire_material': '退工材料交接',
        'social_adjust_yearly': '社保年调',
        'fund_adjust_yearly': '公积金年调',
        'add_fund_adjust_yearly': '补充公积金年调',
        'nonlocal_social_adjust_yearly': '外地委托社保年调',
        'nonlocal_fund_adjust_yearly': '外地委托公积金年调',
        'nonlocal_add_fund_adjust_yearly': '外地委托补充公积金年调'
      },
      guarantee: {
        1: '无',
        2: '用工信息确认',
        3: '需提供押金'
      },
      payWay: {
        1: '管理费',
        2: '公司自付',
        3: '个人工资自付'
      },
      companyPayWay: {
        1: '管理费',
        2: '公司自付',
      },
      personalpayWay: {
        1: '管理费',
        3: '个人工资自付'
      },
      materialStatus: {
        1: '待签收 ',
        2: '已签收',
        3: '已签收',
        4: '已批退',
        5: '申请借用',
        6: '已借出（内）',
        7: '拒绝借用',
        8: '已归还（内）',
        9: '已借出（外）',
        10: '已归还（外）',
        11: '已编辑'
      },
      materialFromThirdDesc: {
        'sheet': '任务单',
        'wx': '微信'
      },
      materialTransferContent:{
        1: '入职材料',
        2: '归档材料'
      },
      materialTaskStatus: {
        1: '新建', 2: '提交', 3: '完成'
      },
      materialHandOverStatus: {
        0: '新建', 1: '提交', 2: '签收', 3: '批退'
      },
      arrivalMonth: {
        0: '当月', 1: '第二月', 2: '第三月', 3: '第四月'
      }
    };
    /**
     *
     * @param dicCode
     * @param key
     * @param targetKey
     * @returns {*}
     */
    Vue.prototype.baseDic.getBaseDicValue = function (dicCode, key, targetKey) {
      if (key == null || key === '') {
        return ''
      }
      let rsObj = this[dicCode][key]
      if (rsObj) {
        if (targetKey) {
          if (rsObj[targetKey]) {
            return rsObj[targetKey]
          } else {
            return rsObj
          }
        } else {
          return rsObj
        }
      }
      return key
    }

    Vue.prototype.$local = local;
    Vue.prototype.$dateUtils = dateUtils;
    Vue.prototype.$commons = commons;
    Vue.prototype.$storage = storage;
    Vue.prototype.$math = math;
  }
}

let math = {
  _thisMath: require('mathjs'),
  eval (value) {
    return this._thisMath.eval(value)
  },
  multiply (arg1, arg2) {
    return this._thisMath.format(this._thisMath.multiply(arg1, arg2), {precision: 14})
  }
}

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
    if (date != '' && date != undefined) {
      return moment(date).format('YYYY-MM-DD')
    }
    return ''
  },

  /**
   * [stdFormatDate 日期格式化]
   *
   * @method stdFormatDate
   * @param  {[Date]} date
   */
  stdFormatDateByFormat (date,formatStr) {
    if (date !== '' && date !== undefined) {
      return moment(date).format(formatStr)
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
  save (key, value) {
    localStorage.setItem(key, value)
    //
  },
  fetch (key) {
    return localStorage.getItem(key) || {}
  },
  back (vm, step) {
    window.history.go(-1)
    //  window.history.back();
  },
  fuzzyQuery (query, source, type) {
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
  titleCase (str) {
    // 将字符串分解为数组并将其小写化
    let convertToArray = str.toLowerCase().split(' ')
    for (let i = 0; i < convertToArray.length; i++) {
      let char = convertToArray[i].charAt(0)
      // 使用 replace()方法将数组中的每个首字母大写化
      convertToArray[i] = convertToArray[i].replace(char, function replace (char) {
        return char.toUpperCase()
      })
    }
    return convertToArray.join(' ')
  },
  addClasses (obj, cls) {
    if (!this.hasClass(obj, cls)) obj.className += ' ' + cls
  }
}
