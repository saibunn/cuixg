<template>
  <div id="empProductGroupList" class="smList demo-spin-article">
    <emp-social-fund-amount-total v-if="configs.showContent === 'both' && configs.edit != 'edit'"
                                  ref="empSocialFundAmountTotal"
                                  v-bind:amountTotal="socialFundAmountTotal"></emp-social-fund-amount-total>
    <Tabs :value="configs.tabValue">
      <TabPane v-if="configs.edit === 'edit'" label="社保公积金" name="0">
        <Card>
          <emp-social-list ref="empSocialList"
                           v-bind:importSocialData="configs.totalSocialData"
                           v-bind:socialBase="configs.salary"
                           v-bind:allEqualsBase=configs.allEqualsBase
                           v-bind:socialStartDate="this.$dateUtils.checkNextMonth(new Date(configs.socialStartDate), 'start')"
                           v-bind:socialUnit="configs.socialUnit"
                           v-bind:fundUnit="configs.fundUnit"
                           v-bind:companyDefPayWay="configs.companyDefPayWay"
                           :configs="configs.socialConfigs"
                           :socialPolicyCode="configs.socialPolicyCode"
                           :fundlPolicyCode="configs.fundlPolicyCode"
          ></emp-social-list>
        </Card>
      </TabPane>
    </Tabs>

    <Spin size="large" fix v-if="spinShow"></Spin>
  </div>
</template>

<script>
  import empSocialList from './emp-social-list'
  import empSocialFundAmountTotal from './emp-social-fund-amount-total'
  //import productApi from './../../../api/pgyhr-task/productutils'

  export default {
    components: {
      'emp-social-list': empSocialList,
      'emp-social-fund-amount-total': empSocialFundAmountTotal,
    },
    props: {
      configs: {
        type: Object,
        required: true
      },
      showStyle: String,
      empAgreementId: '',
      empAgreementInfo: Object,
      importProductDataList: Array,
      importPackageDataList: Array
    },
    data: function () {
      const unitMap = {
        '1': '元/户/次',
        '2': '元/户/月',
        '3': '元/人/次',
        '4': '元/人/月',
        '5': '元/人/天',
        '6': '元/人/年',
        '7': '元/户/天',
        '8': '元/户/年'
      }

      return {
        isShowImportSocialData: false,
        spinShow: false,
        groupBySocial: [],
        groupSelectValue: '',
        updateDateForm: {
          updateProductData: Object,
          startDate: '',
          productTo: '',
          endDate: ''
        },
        updateDateFormRule: {
          startDate: [
            {
              type: 'date',
              required: true,
              message: '请输入收费开始月',
              trigger: 'change'
            }
          ]
        },
        isEndDateDisabled: false,
        selectProductFrom: '',
        defSelectedIds: [],
        contentSetup: {
          trigger: 'hover',
          content: '',
          width: 400,
          placement: 'right-end'
        },
        selectProducts: [],
        isFristAmount: false,
        socialFundAmountTotal: '',
        importPackageData: [],
        importSocialData: [],
        productData: {
          personalOutsourcingData: [],
          healthManagementData: [],
          elasticWelfareData: []
        },
        batchUpdateDayModal: false,
        batchUpdateMonthModal: false
      }
    },
    methods: {
      async loadGroupData(empAgreementId) {
        if (empAgreementId) {
          this.spinShow = true
          // this.$Spin.show()
          this.configs.queryDetailParams.empAgreementId = empAgreementId

          let url = this.$store.SITE_PORT + '/afCompanyCenter/employeeAgreement/getSocialProdcutGroupByDate'
          if (this.configs.queryDetailParams.changeType === 'empAdjustYearly') {
            url = this.$store.SITE_PORT + '/afCompanyCenter/employeeAgreement/getAnnualAdjustGroupByDate'
          }

          let self = this
          await this.axios.post(url, this.configs.queryDetailParams)
            .then(function (response) {
              if (response.data) {
                if (response.data.errorCode == '500') {
                  self.$Notice.error({title: '系统提示', desc: response.data.errorMsg})
                  return
                }
                // 历史服务协议隐藏首月折算段和末月折算段
                if (self.empAgreementInfo && self.empAgreementInfo.isAvailable !== 2) {
                  self.groupBySocial = response.data.filter(item => item.groupName !== '首月折算' && item.groupName !== '末月折算')
                } else {
                  self.groupBySocial = response.data
                }
                if (self.groupBySocial && self.groupBySocial.length > 0) {
                  self.tabsClick(self.groupBySocial.length - 1)
                }
              }
            }).catch(function (error) {
              self.$Notice.error({title: '系统提示', desc: error})
            })
          this.spinShow = false
          // self.$Spin.hide()
        }
      },
      /**
       * 构建列表
       * @param list
       */
      importProductDataListFun: function (list) {
        let self = this
        self.productData.healthManagementData = []
        self.productData.elasticWelfareData = []
        self.productData.personalOutsourcingData = []
        list.forEach(function (productItem) {
          if (productItem.targetPrice) {
            productItem.keyValue = productItem.targetPrice
          }
          // 将产品开始时间临时保存, 用来判断是否修改了产品开始时间
          if (!productItem.isChange && !productItem.isYearDataChange) {
            productItem.oldProductFrom = productItem.productFrom
            productItem.oldStartDate = productItem.startDate
            productItem.oldProductTo = productItem.productTo
            productItem.oldEndDate = productItem.endDate
          }

          if (productItem.productPriceUnit === '6') {
            productItem.isYearDataChange = false
          }

          switch (productItem.productCategoryId) {
            case 6:
              self.productData.healthManagementData.push(productItem)
              break
            case 7:
            case 16:
              self.productData.elasticWelfareData.push(productItem)
              break
            default:
              self.productData.personalOutsourcingData.push(productItem)
              break
          }
        })
      },
      /**
       * 构建列表
       * @param list
       */
      importPackageDataListFun: function (list) {
        if (list) {
          list.forEach(function (item) {
            // 将产品开始时间临时保存, 用来判断是否修改了产品开始时间
            if (!item.isChange && !item.isYearDataChange) {
              item.oldProductFrom = item.productFrom
              item.oldStartDate = item.startDate
              item.oldProductTo = item.productTo
              item.oldEndDate = item.endDate
            }
            if (item.productPriceUnit === '6') {
              item.isYearDataChange = false
            }
          })
        }
        this.importPackageData = list
      },
      /**
       * 按配置信息去除不显示的列
       */
      setHideColumns: function () {
        let self = this
        if (this.configs !== undefined) {
          if (this.configs.socialHideColums !== undefined) {
            this.configs.socialHideColums.forEach(function (hideItem) {
              self.socialInfoColumns.forEach(function (columnItem, index) {
                if (columnItem.key === hideItem) {
                  self.socialInfoColumns.splice(index, 1)
                }
              })
            })
          }
        }
      },
      rowClassName(row, index) {
        if (row.endDate) {
          // 产品缴纳开始时间
          let startTime = new Date(Date.parse(row.startDate))
          // 产品缴纳结束时间
          let endTime = new Date(Date.parse(row.endDate))
          if (startTime > endTime) {
            return 'demo-table-red-row'
          }
        }

        if (row.productType === 5) {
          return 'demo-table-blue-row'
        }
      },
      validateAmount(amount) {
        let returnVal = true
        if (amount != null && amount != '') {
          if (!/^(([1-9]\d*)|0)(\.\d{1,2})?$/.test(amount)) {
            returnVal = false
          }
        }
        return returnVal
      },
      operationButton(h, params, dataObject) {
        let self = this
        let btnArr = []
        // 倒置数据不显示任何按钮, 除了新倒置的除外
        if (self.$commons.isEmpty(params.row.endDate) ||
          (!self.$commons.isEmpty(params.row.endDate) && self.$moment(params.row.startDate).isBefore(self.$moment(params.row.endDate))) ||
          (!self.$commons.isEmpty(params.row.isChange) && params.row.isChange) || params.row.productPriceUnit === '6') {
          let updateBtn = h('Button', {
            props: {
              type: 'primary',
              size: 'small'
            },
            style: {
              marginRight: '10px'
            },
            on: {
              click: () => {
                this.updateDateForm.updateProductData = dataObject[params.index]

                if (dataObject[params.index].productFrom) {
                  this.updateDateForm.productFrom = dataObject[params.index].productFrom
                }

                if (dataObject[params.index].productTo) {
                  this.updateDateForm.productTo = dataObject[params.index].productTo
                }

                if (dataObject[params.index].startDate) {
                  this.updateDateForm.startDate = dataObject[params.index].startDate
                }

                if (dataObject[params.index].endDate) {
                  this.updateDateForm.endDate = dataObject[params.index].endDate
                }

                // 只有元人月 和 元人年 可以修改结束时间, 元人次不能修改
                if (dataObject[params.index].productPriceUnit === '4' || dataObject[params.index].productPriceUnit === '6') {
                  this.isEndDateDisabled = false
                } else {
                  this.isEndDateDisabled = true
                }
                this.selectProductFrom = ''
                this.selectProductFrom = params.row.productFrom
              }
            }
          }, '修改')

          let restoreBtn = h('Button', {
            props: {
              type: 'success',
              size: 'small'
            },
            style: {
              marginRight: '10px'
            },
            on: {
              click: () => {
                // 已存在与还原数据一样的产品新添加产品时提示先删除
                let isExistNewProduct = false
                if (dataObject) {
                  isExistNewProduct = dataObject.some(item => {
                    if (!self.$commons.isEmpty(item.quotationProductId) && item.quotationProductId === dataObject[params.index].quotationProductId && self.$commons.isEmpty(item.id)) {
                      return true
                    }
                    if (!self.$commons.isEmpty(item.quotationPackageId) && item.quotationPackageId === dataObject[params.index].quotationPackageId && self.$commons.isEmpty(item.id)) {
                      return true
                    }
                  })
                }
                if (isExistNewProduct) {
                  self.$Message.error({content: '请先删除添加的本条产品', duration: 3})
                } else {
                  dataObject[params.index].productFrom = dataObject[params.index].oldProductFrom
//                dataObject[params.index].productTo = dataObject[params.index].oldProductTo
                  // 批量后不能还原修改
                  if (dataObject[params.index].hasOwnProperty('productTo')) {
                    dataObject[params.index].productTo = dataObject[params.index].oldProductTo
                  }
                  dataObject[params.index].startDate = dataObject[params.index].oldStartDate
//                dataObject[params.index].endDate = dataObject[params.index].oldEndDate
                  if (dataObject[params.index].hasOwnProperty('endDate')) {
                    dataObject[params.index].endDate = dataObject[params.index].oldEndDate
                  }
                  dataObject[params.index].firstDelete = false
                  if (params.row.productPriceUnit === '6') {
                    dataObject[params.index].isYearDataChange = false
                  } else {
                    dataObject[params.index].isChange = false
                  }
                }
              }
            }
          }, '还原')

          let deleteBtn = h('Button', {
            props: {
              type: 'error',
              size: 'small'
            },
            style: {
              marginRight: '10px'
            },
            on: {
              click: () => {
                if (params.row.isHistory) {
                  dataObject[params.index].isYearDataChange = true
                  dataObject[params.index].startDate = dataObject[params.index].oldStartDate
                  const endDate_ = self.$moment(params.row.oldStartDate).subtract(1, 'days').format('YYYY-MM-DD')
                  dataObject[params.index].endDate = endDate_
                } else {
                  dataObject.splice(params.index, 1)
                }
              }
            }
          }, '删除')

          // 是否老数据
          if (params.row.isHistory) {
            // 是否元人年
            if (params.row.productPriceUnit === '6') {
              // 元人年是否改变
              if (params.row.isYearDataChange) {
                btnArr.push(restoreBtn)
              } else {
                btnArr.push(deleteBtn)
              }
            } else {
              // 非元人年数据
              if (params.row.isChange) {
                btnArr.push(restoreBtn)
              } else {
                if (!params.row.endDate) {
                  btnArr.push(updateBtn)
                }
              }
            }
          } else {
            btnArr.push(deleteBtn)
          }
        }
        return h('div', btnArr)
      },
      updateDateOk() {
        let self = this
        this.$refs['updateDateForm'].validate((valid) => {
          if (valid) {
            self.updateDateForm.updateProductData.productFrom = this.updateDateForm.productFrom
            self.updateDateForm.updateProductData.productTo = this.updateDateForm.productTo
            self.updateDateForm.updateProductData.startDate = this.$dateUtils.getFirstDay(this.updateDateForm.startDate)
            self.updateDateForm.updateProductData.endDate = this.$dateUtils.getLastDay(this.updateDateForm.endDate)

            // 存在首月金额时, 弹出确认对话框
            if (self.updateDateForm.updateProductData.isExistFirstAmount) {
              const endDate = self.$moment(new Date(self.updateDateForm.endDate)).format('YYYYMM')
              const inDate = self.$moment(new Date(self.$parent.empCompanyInfo.inDate)).format('YYYYMM')
              // 判断收费结束月与入职日期是否在同一个月内
              if (endDate === inDate) {
                self.$Modal.confirm({
                  title: '操作提示',
                  content: '<p>该产品已经在首月段中存在,是否需要一并删除?</p>',
                  onOk: () => {
                    self.updateDateForm.updateProductData.firstDelete = true
                  },
                  onCancel: () => {
                    self.$Modal.remove()
                  }
                })
              } else if (inDate > endDate) {
                // 如果收费结束月小于入职日期, 则直接删除产品对应的首月金额
                self.updateDateForm.updateProductData.firstDelete = true
              }
            }

            // 判断产品的(收费)开始日期和产品(收费)结束日期是否发生改变, 若改变则显示还原按钮
            let tempData = self.updateDateForm.updateProductData
            let isChange = (
              self.$dateUtils.isDateEquals(tempData.oldProductFrom, tempData.productFrom) &&
              self.$dateUtils.isDateEquals(tempData.oldStartDate, tempData.startDate) &&
              self.$dateUtils.isDateEquals(tempData.oldProductTo, tempData.productTo) &&
              self.$dateUtils.isDateEquals(tempData.oldEndDate, tempData.endDate)
            )
            self.updateDateForm.updateProductData.isChange = !isChange

            self.$refs['updateDateForm'].resetFields()
          }
        })
      },
      autoCalculate: function () {
        let tempSocialData = JSON.parse(JSON.stringify(this.importSocialData))
        tempSocialData.forEach(item => {
          item.companyBase = item.companyConfirmBase
          item.companyAmount = item.companyConfirmAmount
          item.personalBase = item.personalConfirmBase
          item.personalAmount = item.personalConfirmAmount
        })
        const self = this
        this.axios.post(this.$store.SITE_PORT + '/afCompanyCenter/afEmployee/getSocTotalAmountItems', tempSocialData).then(function (response) {
          if (!self.$commons.isEmpty(response.data)) {
            self.importSocialData.forEach(function (infoItem) {
              self.$set(infoItem, 'ssTotal', response.data[infoItem.itemCode])
            })
            self.isShowImportSocialData = true
          } else {
            self.$Modal.warning({
              title: '系统提示',
              content: response.data.message
            })
          }
        })
      },
      tabsClick(index) {
        this.importSocialData = this.arrayIsEmpty(this.groupBySocial[index].afEmpSocialList)
        if (this.configs.isDetail && this.configs.isDetail) {
          this.autoCalculate()
        } else {
          this.isShowImportSocialData = true
        }
        //this.importSocialData = productApi.sortSocialData(this.importSocialData)

        this.productData.personalOutsourcingData = this.arrayIsEmpty(this.groupBySocial[index].afEmpProductList)
        this.productData.healthManagementData = this.arrayIsEmpty(this.groupBySocial[index].afEmpInsuranceList)
        this.productData.elasticWelfareData = this.arrayIsEmpty(this.groupBySocial[index].afEmpWelfareList)
        this.importPackageData = this.arrayIsEmpty(this.groupBySocial[index].afEmpPackageList)

        let newAmount = {}
        newAmount.socialTotal = this.groupBySocial[index].socialSumPrice
        newAmount.fundTotal = this.groupBySocial[index].fundSumPrice
        newAmount.healthTotal = this.groupBySocial[index].insuranceSumPrice
        newAmount.productTotal = this.groupBySocial[index].productSumPrice
        newAmount.welfareTotal = this.groupBySocial[index].welfareSumPrice
        newAmount.packageTotal = this.groupBySocial[index].packageSumPrice
        newAmount.productTaxRate = this.groupBySocial[index].productTaxRate
        newAmount.productExtraRate = this.groupBySocial[index].productExtraRate
        newAmount.allTotal = this.groupBySocial[index].sumPrice
        this.socialFundAmountTotal = newAmount
        this.groupSelectValue = '' + index
      },
      returnTabName(val) {
        return '' + val
      },
      arrayIsEmpty(arr) {
        if (!this.$commons.isEmpty(arr) && arr.length > 0) {
          return arr
        } else {
          return new Array()
        }
      },
      productFromChange(value) {
        // 用户修改了老数据的产品开始时间后, 则把产品结束时间和收费结束时间置为只读
        if (this.updateDateForm.updateProductData.isHistory) {
          let oldProductFrom = this.$moment(this.updateDateForm.updateProductData.oldProductFrom).format('YYYY-MM-DD')
          let newProductFrom = this.$moment(value).format('YYYY-MM-DD')
          if (oldProductFrom === newProductFrom) {
            this.isEndDateDisabled = false
          } else {
            this.isEndDateDisabled = true
            this.updateDateForm.productTo = ''
            this.updateDateForm.endDate = ''
          }
        }
      },
      productToChange(value) {
        if (this.$commons.isEmpty(this.updateDateForm.endDate)) {
          this.updateDateForm.endDate = value
        }
      },
      updateProductFrom(cardName, columnName, params) {
        if (this.configs.batchUpdateFlag !== undefined) {
          if (columnName === 'productTo') {
            this.$refs.batchUpdateDayModalRef.setCardTabName(cardName)
            this.batchUpdateDayModal = true
          } else if (columnName === 'endDate') {//人事外包收费开始月
            this.$refs.batchUpdateMonthModalRef.setCardTabName(cardName)
            this.batchUpdateMonthModal = true
          }
        }
      },
      batchUpdateDayModalClose(params) {
        if (params.flag) {
          if (params.cardTabName === '1') {
            this.productData.personalOutsourcingData.forEach(item => {
              this.batchUpdateProductToDate(item, params)
            })
          } else if (params.cardTabName === '2') {
            this.productData.healthManagementData.forEach(item => {
              this.batchUpdateProductToDate(item, params)
            })
          } else if (params.cardTabName === '3') {
            this.productData.elasticWelfareData.forEach(item => {
              this.batchUpdateProductToDate(item, params)
            })
          } else if (params.cardTabName === '4') {
            this.importPackageData.forEach(item => {
              this.batchUpdateProductToDate(item, params)
            })
          }
        }
        this.batchUpdateDayModal = false
      },
      batchUpdateMonthModalClose(params) {
        if (params.flag) {
          if (params.cardTabName === '1') {
            this.productData.personalOutsourcingData.forEach(item => {
              this.batchUpdateEndDate(item, params)
            })
          } else if (params.cardTabName === '2') {
            this.productData.healthManagementData.forEach(item => {
              this.batchUpdateEndDate(item, params)
            })
          } else if (params.cardTabName === '3') {
            this.productData.elasticWelfareData.forEach(item => {
              this.batchUpdateEndDate(item, params)
            })
          } else if (params.cardTabName === '4') {
            this.importPackageData.forEach(item => {
              this.batchUpdateEndDate(item, params)
            })
          }
        }
        this.batchUpdateMonthModal = false
      },
      batchUpdateProductToDate(item, params) {
        //如果是新增的数据不修改
        if (!item.isHistory) {
          return false
        }
        //收费方式为:元/人/年的不修改
        if (item.productPriceUnit === '6') {
          return false
        }
        if (item.hasOwnProperty('allowUpdate')) {
          if (!item.hasOwnProperty('productTo')) {
            this.$set(item, 'productTo', params.dateWithDay)
          } else {
            item.productTo = params.dateWithDay
          }
          item.isChange = true
        } else {
          if (!item.hasOwnProperty('productTo')) {
            this.$set(item, 'productTo', params.dateWithDay)
            this.$set(item, 'allowUpdate', true)
            item.isChange = true
          } else {
            if (!item.hasOwnProperty('endDate')) {
              item.productTo = params.dateWithDay
              item.isChange = true
            } else if (this.isNeedUpdateDate(item, params)) {
              item.productTo = params.dateWithDay
              item.isChange = true
            }
          }
        }
      },
      batchUpdateEndDate(item, params) {
        //如果是新增的数据不修改
        if (!item.isHistory) {
          return false
        }
        //收费方式为:元/人/年的不修改
        if (item.productPriceUnit === '6') {
          return false
        }
        if (item.hasOwnProperty('allowUpdate')) {
          if (!item.hasOwnProperty('endDate')) {
            this.$set(item, 'endDate', params.dateWithMonth)
            item.isChange = true
          } else {
            item.endDate = params.dateWithMonth
            item.isChange = true
          }
        } else {
          if (!item.hasOwnProperty('endDate')) {
            this.$set(item, 'endDate', params.dateWithMonth)
            this.$set(item, 'allowUpdate', true)
            item.isChange = true
          } else if (this.isNeedUpdateDate(item, params)) {
            item.endDate = params.dateWithMonth
            item.isChange = true
          }
        }
      },
      //验证是否需要修改产品结束时间和
      isNeedUpdateDate(item, params) {
        let _self = this
        //判断对应页签列表中是否有新增的该产品项
        let isExistNewProduct = false
        if (params.cardTabName === '1') {
          isExistNewProduct = _self.productData.personalOutsourcingData.some(product => {
            return _self.isExistNewProduct(product, item)
          })
        } else if (params.cardTabName === '2') {
          isExistNewProduct = _self.productData.healthManagementData.some(product => {
            return _self.isExistNewProduct(product, item)
          })
        } else if (params.cardTabName === '3') {
          isExistNewProduct = _self.productData.elasticWelfareData.some(product => {
            return _self.isExistNewProduct(product, item)
          })
        } else if (params.cardTabName === '4') {
          isExistNewProduct = _self.importPackageData.some(packageDate => {
            return _self.isExistNewPackage(packageDate, item)
          })
        }
        // 已存在与还原数据一样的产品新添加产品时提示先删除
        if ((item.endDate === null || item.endDate === '' || item.endDate === undefined || item.isChange) && !isExistNewProduct) {
          return true
        } else {
          return false
        }
      },
      //验证是否含有新产品
      isExistNewProduct(product, item) {
        let _self = this
        if (!_self.$commons.isEmpty(product.quotationProductId) && product.quotationProductId === item.quotationProductId && _self.$commons.isEmpty(product.id)) {
          return true
        }
      },
      //验证是否含有新产品
      isExistNewPackage(packageDate, item) {
        let _self = this
        if (!_self.$commons.isEmpty(packageDate.quotationPackageId) && packageDate.quotationPackageId === item.quotationPackageId && _self.$commons.isEmpty(packageDate.id)) {
          return true
        }
      }
    },
    mounted() {
      this.setHideColumns()
      if (this.configs.queryDetailParams && this.configs.showContent === 'both') {
        this.loadGroupData(this.configs.queryDetailParams.empAgreementId)
      }
    },
    computed: {
      /**
       * 产品开始时间只能前调, 此处做限制
       */
      productStartOptions: function () {
        let self = this
        return {
          disabledDate(date) {
            if (self.selectProductFrom) {
              let momentDate = self.$moment(self.selectProductFrom)
              let currentDate = self.$moment(date)
              return date && momentDate.isBefore(currentDate)
            }
            return true
          }
        }
      }
    },
    watch: {
      /**
       * @param empAgreementId
       */
      'empAgreementId': function (empAgreementId) {
        if (empAgreementId && this.configs.showContent === 'both') {
          // 查看不同的服务协议时, 重置数据列表
          this.productData.personalOutsourcingData = []
          this.productData.healthManagementData = []
          this.productData.elasticWelfareData = []
          this.importPackageData = []
          this.importSocialData = []
          this.loadGroupData(empAgreementId)
        }
      }
    }
  }
</script>
<style>
  .demo-table-red-row div {
    color: #ed4014;
  }
  .demo-table-blue-row div {
    color: #0080ff;
  }
  #empProductGroupList .ivu-table-cell {
    padding-left: 2px;
    padding-right: 2px;
  }
  .policyBox {
    display: table!important;
    width: 100%;
  }
  .policyName {
    text-align: center;
    vertical-align: middle;
    display: table-cell;
    border-right: 1px dashed #dddee1;
  }
  .policyName:last-child {
    border-right: none;
  }
  .cellChapter, .cellContent {
    text-align: center;
    vertical-align: middle;
    line-height: 28px;
    overflow: visible;
    width: 100%;
    min-height: 28px;
    border-bottom: 1px dashed #dddee1;
  }
  .cellChapter:last-child, .cellContent:last-child {
    border-bottom: none;
  }
  .tblue {
    color: #515a6e!important;
  }
</style>
