<template>
  <div id="newEmpSocialList">
    <Form :label-width="120">
      <Row>
        <template v-if="configs.readonly">
          <i-col :sm="{span: 7}" class="tr">
            <Form-item label="企业收费方式:">
              <Select @on-change="companyPayWayChange" class="w100p" transfer>
                <Option v-for="(value,key) in this.baseDic.payWay" :value="key" :key="key">{{value}}</Option>
              </Select>
            </Form-item>
          </i-col>
          <i-col :sm="{span: 7}" class="tr">
            <Form-item label="个人收费方式:">
              <Select @on-change="personalPayWayChange" class="w100p" transfer>
                <Option v-for="(value,key) in this.baseDic.payWay" :value="key" :key="key">{{ value }}</Option>
              </Select>
            </Form-item>
          </i-col>
          <i-col :sm="{span: 10}" class="tr">
            <Button type="primary" @click="autoCalculate">自动计算</Button>
          </i-col>
        </template>
        <i-col :sm="{span: 24}" v-if="!configs.readonly" align="right" class="mb10">
          <Button type="primary" @click="autoCalculate">自动计算</Button>
        </i-col>
      </Row>
    </Form>
    <Table border stripe :row-class-name="rowClassName" :columns="socialInfoColumns" :data="importSocialData">
    </Table>
    <emp-product-component ref="empProductComponent"></emp-product-component>
  </div>
</template>
<script>
  import math from 'mathjs'
  import empProductComponent from './emp-product-component'

  export default {
    components: {
      'emp-product-component': empProductComponent
    },
    computed: {

    },
    props: {
      configs: {
        type: Object,
        required: true
      },
      disabledEndDate: Boolean,
      changeType: String,
      // 社保产品信息
      importSocialData: Array,
      // 社保基数
      socialBase: [String, Number],
      fundBase: String,
      // 是否是险种合一
      allEqualsBase: Boolean,
      socialStartDate: Date,
      socialEndDate: Date,
      socialUnit: [String, Number],
      fundUnit: [String, Number],
      minSocialMonth: Array,
      socialRuleId: [String, Number],
      oldSocialRuleId: [String, Number],
      fundRuleId: [String, Number],
      oldFundRuleId: [String, Number],
      companyDefPayWay: String,
      agreementChangeType: String,
      inDate: Date,
      tempSocialData: []
    },
    data: function () {
      return {
        companyPayWayDisable:false,
        companyPayWayRowDisable:false,
        // 判断公积金或补充公积金是否联动变化过
        fundBaseChange: 0,
        fundBaseChangeCompamy: 0,
        fundBaseChangePersonal: 0,
        // 社保信息表格列
        socialInfoColumns: [
          {
            title: '名称',
            key: 'policyName',
            minWidth: 65,
            align: 'center'
          },
          {
            title: '雇员基数',
            title: '雇员基数',
            key: 'empCompanyBase',
            minWidth: 55,
            align: 'center',
            render: (h, params) => {
              if (!this.$commons.isEmpty(this.socialStartDate)) {
                let self = this
                return h('div', [
                  h('Input', {
                    props: {
                      value: self.$math.eval(params.row.empCompanyBase)
                    },
                    on: {
                      'on-blur': (val) => {
                        // 如果是险种合一 统一修改社保类基数
                        if (self.allEqualsBase && params.row.policyType == '1') {
                          self.importSocialData.forEach(function (infoItem) {
                            if (infoItem.policyType === params.row.policyType) {
                              infoItem.empCompanyBase = val.target.value
                              infoItem.companyBase = val.target.value
                              infoItem.personalBase = val.target.value
                            }
                          })
                        } else {
                          self.importSocialData[params.index].empCompanyBase = val.target.value
                          self.importSocialData[params.index].companyBase = val.target.value
                          self.importSocialData[params.index].personalBase = val.target.value
                        }
                        self.syncFundBase(params.row, 'all', val.target.value)
                      }
                    }
                  })
                ])
              } else {
                return h('div', [
                  h('span', params.row.empCompanyBase)
                ])
              }
            }
          },
          {
            title: '企业基数',
            key: 'companyBase',
            minWidth: 55,
            align: 'center',
            render: (h, params) => {
              if (!this.$commons.isEmpty(this.socialStartDate)) {
                let self = this
                return h('div', [
                  h('Input', {
                    props: {
                      value: self.$math.eval(params.row.companyBase)
                    },
                    on: {
                      'on-blur': (val) => {
                        if (this.changeType == 'empAgreementUpdate' && val.target.value == 0) {
                          val.target.value = self.$math.eval(params.row.companyBase)
                          this.$Notice.error({title: '系统提示', desc: '雇员基数不能为0'})
                          return
                        }
                        // 如果是险种合一 统一修改社保类基数
                        if (self.allEqualsBase && params.row.policyType == '1') {
                          self.importSocialData.forEach(function (infoItem) {
                            if (infoItem.policyType === params.row.policyType) {
                              infoItem.companyBase = val.target.value
                            }
                          })
                        } else {
                          self.importSocialData[params.index].companyBase = val.target.value
                        }

                        self.syncFundBase(params.row, 'company', val.target.value)
                      }
                    }
                  })
                ])
              } else {
                return h('div', [
                  h('span', params.row.companyBase)
                ])
              }
            }
          },
          {
            title: '企业比例',
            key: 'companyRatio',
            minWidth: 60,
            align: 'center',
            render: (h, params) => {
              let self = this
              if (!this.$commons.isEmpty(this.socialStartDate) && params.row.companyRatioList && params.row.companyRatioList.indexOf(',') !== -1) {
                // 组装下拉
                let optionList = []
                params.row.companyRatioList.split(',').forEach(function (item) {
                  optionList.push(
                    h('Option', {
                      props: {
                        value: parseFloat(item),
                        label: self.$math.multiply(item, 100) + '%',
                        transfer: true
                      }
                    })
                  )
                })
                return h('Select', {
                  props: {
                    value: self.importSocialData[params.index].companyRatio,
                    transfer: true
                  },
                  on: {
                    'on-change': (val) => {
                      self.importSocialData[params.index].companyRatio = val
                    }
                  }
                }, optionList)
              } else {
                return h('div', [
                  h('span', self.$math.multiply(params.row.companyRatio, 100) + '%')
                ])
              }
            }
          },
          {
            title: '企业收费方式',
            key: 'companyPayWay',
            minWidth: 80,
            align: 'center',
            render: (h, params) => {
              if (this.configs && !this.configs.readonly) {
                return h('div', [
                  h('span', this.baseDic.payWay[this.importSocialData[params.index].companyPayWay])
                ])
              } else {
                // 组装下拉
                let optionList = []
                for (let key in this.baseDic.payWay) {
                  optionList.push(
                    h('Option', {
                      props: {
                        value: key,
                        label: this.baseDic.payWay[key],
                        transfer: true
                      }
                    })
                  )
                }
                return h('Select', {
                  props: {
                    value: this.importSocialData[params.index].companyPayWay,
                    disabled:this.importSocialData[params.index].policyType == 1 && this.companyPayWayRowDisable
                  },
                  on: {
                    'on-change': (val) => {
                      this.importSocialData[params.index].companyPayWay = val
                    }
                  }
                }, optionList)
              }
            }

          },
          {
            title: '企业金额',
            key: 'companyAmount',
            minWidth: 55,
            align: 'center'
          },
          {
            title: '个人基数',
            key: 'personalBase',
            minWidth: 55,
            align: 'center',
            render: (h, params) => {
              if (!this.$commons.isEmpty(this.socialStartDate)) {
                let self = this
                return h('div', [
                  h('Input', {
                    props: {
                      value: self.$math.eval(params.row.personalBase)
                    },
                    on: {
                      'on-blur': (val) => {
                        if (this.changeType == 'empAgreementUpdate' && val.target.value == 0) {
                          val.target.value = self.$math.eval(params.row.personalBase)
                          this.$Notice.error({title: '系统提示', desc: '雇员基数不能为0'})
                          return
                        }
                        // 如果是险种合一 统一修改社保类基数
                        if (self.allEqualsBase && params.row.policyType == '1') {
                          self.importSocialData.forEach(function (infoItem) {
                            if (infoItem.policyType === params.row.policyType) {
                              infoItem.personalBase = val.target.value
                            }
                          })
                        } else {
                          self.importSocialData[params.index].personalBase = val.target.value
                        }

                        self.syncFundBase(params.row, 'personal', val.target.value)
                      }
                    }
                  })
                ])
              } else {
                return h('div', [
                  h('span', params.row.personalBase)
                ])
              }
            }
          },
          {
            title: '个人比例',
            key: 'personalRatio',
            minWidth: 60,
            align: 'center',
            render: (h, params) => {
              let self = this
              if (!this.$commons.isEmpty(this.socialStartDate) && params.row.personalRatioList && params.row.personalRatioList.indexOf(',') !== -1) {
                // 组装下拉
                let optionList = []
                params.row.personalRatioList.split(',').forEach(function (item) {
                  optionList.push(
                    h('Option', {
                      props: {
                        value: parseFloat(item),
                        label: self.$math.multiply(item, 100) + '%',
                        transfer: true
                      }
                    })
                  )
                })
                return h('Select', {
                  props: {
                    value: self.importSocialData[params.index].personalRatio,
                    transfer: true
                  },
                  on: {
                    'on-change': (val) => {
                      self.importSocialData[params.index].personalRatio = val
                    }
                  }
                }, optionList)
              } else {
                return h('div', [
                  h('span', self.$math.multiply(params.row.personalRatio, 100) + '%')
                ])
              }
            }
          },
          {
            title: '个人收费方式',
            key: 'personalPayWay',
            minWidth: 80,
            align: 'center',
            render: (h, params) => {
              let self = this
              if (this.configs && !this.configs.readonly) {
                return h('div', [
                  h('span', this.baseDic.payWay[this.importSocialData[params.index].personalPayWay])
                ])
              } else {
                // 组装下拉
                let optionList = []
                for (let key in this.baseDic.payWay) {
                  optionList.push(
                    h('Option', {
                      props: {
                        value: key,
                        label: this.baseDic.payWay[key],
                        transfer: true
                      }
                    })
                  )
                }
                return h('Select', {
                  props: {
                    value: this.importSocialData[params.index].personalPayWay
                  },
                  on: {
                    'on-change': (val) => {
                      self.importSocialData[params.index].personalPayWay = val
                    }
                  }
                }, optionList)
              }
            }
          },
          {
            title: '个人金额',
            key: 'personalAmount',
            minWidth: 55,
            align: 'center'
          },
          {
            title: '申报开始月',
            key: 'startDate',
            minWidth: 90,
            align: 'center',
            render: (h, params) => {
              // 年调时申报开始月不允许修改
              if (this.changeType === 'empAdjustYearly') {
                return h('div', [
                  h('span', new Date(params.row.startDate).pattern('yyyy-MM-dd'))
                ])
              }

              if (!this.$commons.isEmpty(this.socialStartDate)) {
                let self = this
                return h('div', [
                  h('DatePicker', {
                    props: {
                      type: 'month',
                      value: params.row.startDate,
                      format: 'yyyy-MM',
                      clearable: false,
                      transfer: true,
                      options: {
                        disabledDate(date) {
                          if (self.agreementChangeType === 'empAgreementAdjustNew') {
                            let momentDate = self.$moment(date)
                            let currentDate = self.$moment(self.inDate).set('date', 1);
                            return  momentDate.isBefore(currentDate)
                          } else {
                            return false
                          }
                        }
                      }
                    },
                    on: {
                      'on-change': (val) => {
                        // 如果是险种合一 统一修改社保类基数
                        if (self.allEqualsBase && params.row.policyType == '1') {
                          self.importSocialData.forEach(function (infoItem) {
                            if (infoItem.policyType === params.row.policyType) {
                              infoItem.startDate = new Date(val + '-01')
                            }
                          })
                        } else {
                          this.importSocialData[params.index].startDate = new Date(val + '-01')
                        }
                        this.startDateChange(params.row.itemCode)
                      }
                    }
                  })
                ])
              } else {
                return h('div', [
                  h('span', new Date(params.row.startDate).pattern('yyyy-MM-dd'))
                ])
              }
            }
          },
          {
            title: '申报停止月',
            key: 'endDate',
            minWidth: 90,
            align: 'center',
            render: (h, params) => {
              let self = this
              return h('div', [
                h('DatePicker', {
                  props: {
                    type: 'month',
                    value: params.row.endDate,
                    format: 'yyyy-MM',
                    clearable: false,
                    transfer: true,
                    options: {
                      disabledDate (date) {
                        if (self.disabledEndDate) {
                          return date && date.valueOf() < new Date('1970-01-01 00:00:00').valueOf()
                        } else {
                          let checkDate
                          if (self.minSocialMonth) {
                            self.minSocialMonth.some(function (item) {
                              if (item.itemCode === params.row.itemCode) {
                                checkDate = self.yearMonthToDate(item.startDate)
                                return true
                              }
                            })
                            if (checkDate) {
                              return date && date.valueOf() >= checkDate.valueOf()
                            } else {
                              return date && date.valueOf() >= Date.now() - 86400000
                            }
                          }
                        }
                      }
                    }
                  }
                })
              ])
            }
          },
          {
            title: '实缴开始月',
            key: 'startConfirmDate',
            minWidth: 90,
            align: 'center',
            render: (h, params) => {
              if (params.row.startConfirmDate) {
                return h('div', [
                  h('span', new Date(params.row.startConfirmDate).pattern('yyyy-MM-dd'))
                ])
              }
            }
          },
          {
            title: '实际停止月',
            key: 'endConfirmDate',
            minWidth: 90,
            align: 'center',
            render: (h, params) => {
              if (params.row.endConfirmDate) {
                return h('div', [
                  h('span', new Date(params.row.endConfirmDate).pattern('yyyy-MM-dd'))
                ])
              }
            }
          },
          {
            title: '合计',
            key: 'total',
            minWidth: 45,
            align: 'center'
          }
        ]
      }
    },
    methods: {
      setHideColumns: function () {
        if (this.configs !== undefined && this.configs.hideColums !== undefined) {
          let self = this
          this.configs.hideColums.forEach(function (hideItem) {
            self.socialInfoColumns.forEach(function (columnItem, index) {
              if (columnItem.key === hideItem) {
                self.socialInfoColumns.splice(index, 1)
              }
            })
          })
        }
      },
      // 金额计算
      async autoCalculate () {
        if (!this.$commons.isEmpty(this.importSocialData) && this.importSocialData.length > 0) {
          if (this.$commons.isEmpty(this.socialStartDate)) {
            this.$Message.error('请选择开始时间。')
            return false
          }

          let hasSocialFundItem = this.checkSocialData()
          if (hasSocialFundItem) {
            return
          }

          await this.startDateChange()

          // let self = this
          // return new Promise(resolve => {
          //   this.axios.post(this.$store.SITE_PORT + '/afCompanyCenter/afEmployee/checkSocial', {
          //     socialRuleId: this.socialRuleId,
          //     fundSocialRuleId: this.fundRuleId,
          //     socialItems: self.importSocialData
          //   })
          //     .then(function (response) {
          //       if (!self.$commons.isEmpty(response.data.data) && response.data.data.length > 0) {
          //         response.data.data.forEach(function (item) {
          //           self.importSocialData.forEach(function (infoItem, index) {
          //             let thisRowSocailData = self.importSocialData[index]
          //             if (infoItem.itemCode === item.itemCode) {
          //               thisRowSocailData.empCompanyBase = item.empCompanyBase
          //               thisRowSocailData.companyBase = item.companyBase
          //               thisRowSocailData.personalBase = item.personalBase
          //               thisRowSocailData.companyAmount = item.companyAmount
          //               thisRowSocailData.personalAmount = item.personalAmount
          //               thisRowSocailData.total = item.total
          //             }
          //           })
          //         })
          //       } else {
          //         self.$Modal.warning({
          //           title: '系统提示',
          //           content: response.data.message
          //         })
          //       }
          //       resolve()
          //     })
          // })
        }
      },
      /**
       * 验证社保数据
       */
      checkSocialData () {
        let self = this
        let hasSocialFundItemName
        let hasSocialFundItem = this.importSocialData.some(function (item) {
          let empCompanyBase = item.empCompanyBase
          // 提交数据时判断社保公积金数据是否完整
          let personalRatio = item.personalRatio
          let companyRatio = item.companyRatio
          let companyBase = item.companyBase
          let personalBase = item.personalBase
          if (self.$commons.isEmpty(empCompanyBase) || self.$commons.isEmpty(companyBase) || self.$commons.isEmpty(personalBase) ||
            self.$commons.isEmpty(personalRatio) || self.$commons.isEmpty(companyRatio)) {
            hasSocialFundItemName = item.policyName
            return true
          }
        })
        if (hasSocialFundItem) {
          this.$Message.error({content: hasSocialFundItemName + '：请确保数据填写完整。', duration: 5})
        }
        return hasSocialFundItem
      },
      setStartDate (newStartDate) {
        let errMonth = false
        this.importSocialData.forEach(function (infoItem) {
          if (infoItem) {
            infoItem.startDate = new Date(newStartDate)
            if (infoItem.endDate && infoItem.endDate !== null) {
              if (infoItem.startDate > infoItem.endDate) {
                infoItem.startDate = ''
                errMonth = true
              }
            }
          }
        })
        if (errMonth) {
          this.$Message.error('结束时间不能小于开始时间')
        }
      },
      setEndDate (endDate) {
        let errMonth = false
        this.importSocialData.forEach(function (infoItem) {
          if (infoItem) {
            infoItem.endDate = new Date(endDate)
            if (infoItem.endDate && infoItem.startDate > infoItem.endDate) {
              infoItem.endDate = ''
              errMonth = true
            }
          }
        })
        if (errMonth) {
          this.$Message.error('结束时间不能小于开始时间')
        }
      },
      yearMonthToDate (yearMonth) {
        if (yearMonth) {
          yearMonth = yearMonth + ''
          let dateStr = yearMonth.substring(0, 4) + '-' + yearMonth.substring(4, 6) + '-01 00:00:00.000'
          return new Date(dateStr)
        }
      },
      /**
       * [reloadList 重新刷新列表]
       *
       * @method reloadList
       * @param  {[Array]}   socialList
       */
      reloadList (socialList) {
        this.importSocialData = socialList
      },
      async reloadListByAgreementId (empAgreementId) {
        let self = this
        return new Promise(resolve => {
          this.axios.get(self.$store.SITE_PORT + '/afCompanyCenter/empSocial/getByEmpAgreement/' + empAgreementId).then(
            function (response) {
              if (response.data) {
                self.importSocialData = response.data.empSocialList
                self.$emit('setSocialData', response.data.empSocialList)
                resolve()
              }
            }).catch(function (error) {
            self.$Notice.error({title: '系统提示', desc: error})
          })
        })
      },
      rowClassName(row, index) {
        if (row.endDate) {
          // 产品缴纳开始时间
          var startTime = new Date(Date.parse(row.startDate))
          // 产品缴纳结束时间
          var endTime = new Date(Date.parse(row.endDate))
          if (startTime > endTime) {
            return 'demo-table-red-row'
          }
        }
      },
      companyPayWayChange (val) {
        this.importSocialData.forEach((v) => {
          v.companyPayWay = val
        })
      },
      personalPayWayChange (val) {
        this.importSocialData.forEach((v) => {
          v.personalPayWay = val
        })
      },
      async startDateChange(itemCode) {
        let paramJSON = {
          type: 0,
          socialRuleId: this.socialRuleId,
          fundRuleId: this.fundRuleId,
          startDate: this.socialStartDate,
          empSocial: this.importSocialData
        }
        let self = this
        let matchSocialData = await this.$refs.empProductComponent.getSocialItemData(paramJSON)
        if (matchSocialData) {
          self.importSocialData.forEach(function (infoItem) {
            // if (infoItem.itemCode === itemCode) {
            matchSocialData.list.forEach(function (element) {
              if (element.itemCode === infoItem.itemCode) {
                infoItem.companyRatioList = element.companyRatioList
                infoItem.companyRatio = element.companyRatio

                // if (element.companyRatioList) {
                //   infoItem.companyRatioList = element.companyRatioList
                // } else {
                //   infoItem.companyRatio = element.companyRatio
                // }

                infoItem.companyCheckTailFlag = element.companyCheckTailFlag
                infoItem.companyCalculateMethod = element.companyCalculateMethod
                infoItem.companyFixedAmount = element.companyFixedAmount

                infoItem.personalRatioList = element.personalRatioList
                infoItem.personalRatio = element.personalRatio

                // if (element.personalRatioList) {
                //   infoItem.personalRatioList = element.personalRatioList
                // } else {
                //   infoItem.personalRatio = element.personalRatio
                // }

                infoItem.personalCheckTailFlag = element.personalCheckTailFlag
                infoItem.personalCalculateMethod = element.personalCalculateMethod
                infoItem.personalFixedAmount = element.personalFixedAmount

                infoItem.companyBase = element.companyBase
                infoItem.personalBase = element.personalBase
                infoItem.companyAmount = element.companyAmount
                infoItem.personalAmount = element.personalAmount
                infoItem.total = element.total
              }
            })
            // }
          })
          try {
            this.$emit('selectDataTotal', self.importSocialData)
          } catch (err) { }
        }
      },
      init () {
        if (this.companyDefPayWay) {
          this.companyPayWayDisable = true
          this.companyPayWayRowDisable = true
          this.importSocialData.forEach((v) => {
            if (v.policyType == '1') {
              v.companyPayWay = this.companyDefPayWay
            }
            // 设置缺省值
            if (!v.companyPayWay) {
              v.companyPayWay = '1'
            }
            // 设置缺省值
            if (!v.personalPayWay) {
              v.personalPayWay = '1'
            }
          })
        } else {
          this.importSocialData.forEach((v) => {
            // 设置缺省值
            if (!v.companyPayWay) {
              v.companyPayWay = '1'
            }
            // 设置缺省值
            if (!v.personalPayWay) {
              v.personalPayWay = '1'
            }
          })
        }
        // 只有管理费才参与合计
        if (this.importSocialData) {
          this.importSocialData.forEach((v) => {
            let companyAmount = v.companyPayWay == '1' ? v.companyAmount : 0
            let personalAmount = v.personalPayWay == '1' ? v.personalAmount : 0
            v.total = math.round(companyAmount + personalAmount, 2)
          })
        }
      },
      /**
       * 公积金或补充公积金联动变化
       * @param row 当前行数据
       * @param type 雇员基数列/公司基数列/个人基数列
       * @param changeValue 当前改变的值
       */
      syncFundBase(row, type, changeValue) {
        const self = this
        if (row.policyType === 2) {
          this.importSocialData.forEach(function (infoItem) {
            if (infoItem.policyType === 2 && infoItem.itemCode !== row.itemCode) {
              if (type === 'all' && infoItem.empCompanyBase != 0 && self.fundBaseChange === 0) {
                infoItem.empCompanyBase = changeValue
                infoItem.companyBase = changeValue
                infoItem.personalBase = changeValue

                self.fundBaseChange = 1
                self.fundBaseChangeCompamy = 1
                self.fundBaseChangePersonal = 1
              }

              if (type === 'company' && infoItem.companyBase != 0 && self.fundBaseChangeCompamy === 0) {
                infoItem.companyBase = changeValue
                self.fundBaseChangeCompamy = 1
              }

              if (type === 'personal' && infoItem.personalBase != 0 && self.fundBaseChangePersonal === 0) {
                infoItem.personalBase = changeValue
                self.fundBaseChangePersonal = 1
              }
            }
          })
        }
      }
    },
    watch: {
      socialBase: function (newSocialBase) {
        const regex = /^(([1-9]\d*)|0)(\.\d{1,2})?$/
        const flag = regex.test(this.socialBase)
        if (flag && this.importSocialData && newSocialBase) {
          this.importSocialData.forEach(function (infoItem) {
            infoItem.empCompanyBase = newSocialBase
            infoItem.companyBase = newSocialBase
            infoItem.personalBase = newSocialBase
          })
        }
      },
      importSocialData: function (val) {
        this.init()
      }
    },
    mounted () {
      this.setHideColumns()
    }
  }
</script>
<style>
  .demo-table-red-row div{
    color: red;
  }
  #newEmpSocialList .ivu-table-cell {
    padding-left: 2px;
    padding-right: 2px;
  }
</style>
