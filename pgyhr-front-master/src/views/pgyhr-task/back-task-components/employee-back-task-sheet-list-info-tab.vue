<template>
    <Form :model="formItem" :label-width="130">
      <Row>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="合同开始日期" prop="contractStartDate">
          {{$dateUtils.stdFormatDate(taskSheetDetail.contractStartDate)}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="合同结束日期" prop="contractEndDate">
          {{$dateUtils.stdFormatDate(taskSheetDetail.contractEndDate)}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="社保账号" prop="employeeSecurityAccount">
          {{taskSheetDetail.employeeSecurityAccount}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="公积金账号" prop="employeeFundAccount">
          {{taskSheetDetail.employeeFundAccount}}
        </Form-item>
        </i-col>

        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="档案所在地" prop="fileLocation">
          {{taskSheetDetail.fileAddress}}
        </Form-item>
        </i-col>

      </Row>
      <Row>
        <i-col span="24">
          <Form-item align="right">
            <Checkbox v-model="tnsuranceType">险种合一</Checkbox>
          </Form-item>
        </i-col>
      </Row>
      <Row>
        <i-col span="24">
        <Table border :columns="insuranceItemsColumns" :data="taskSheetSocialFeeInfo" ref="insuranceItemsTable"></Table>
        </i-col>
      </Row>

      <Row style="margin-top: 10px">
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="企业缴费总计" prop="enterpriseTotalPay">
          <!--{{parseFloat(_.sumBy(taskSheetSocialFeeInfo, i => i.companyAmount).toFixed(2))}}-->
          {{formItem.enterpriseTotalPay}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="个人缴费总计" prop="personalTotalPay">
          <!--{{parseFloat(_.sumBy(taskSheetSocialFeeInfo, i => i.personalAmountLabel).toFixed(2))}}-->
          {{formItem.personalTotalPay}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="其中社保" prop="socialSecurityPay">
          {{formItem.socialSecurityPay}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="其中公积金" prop="providentFundPay">
          {{formItem.providentFundPay}}
        </Form-item>
        </i-col>
      </Row>
      <Row style="margin-top: 10px">
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="前道服务费"  prop="frontServiceFee">
          {{taskSheetDetail.frontServiceFee}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="实际工资" prop="realWages">
          {{taskSheetDetail.actualWage}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="总计" prop="totalCost">
          {{formItem.totalCost}}
        </Form-item>
        </i-col>

        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
          <Form-item label="服务费"  prop="serviceFee">
            <i-input v-model="taskSheetDetail.serviceFee" :disabled ="!this.getControlDisabled(3)" ></i-input>
          </Form-item>
        </i-col>

        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="备注"  prop="trustRemarks">
          <i-input v-model="taskSheetDetail.remark"  type="textarea" :rows="4" :disabled ="!this.getControlDisabled(3)" ></i-input>
        </Form-item>
        </i-col>
      </Row>
      <Row>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="终止原因" prop="terminationReasonLabel">
          {{taskSheetDetail.terminationReasonLabel}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="终止日期"  prop="terminationDate">
          {{$dateUtils.stdFormatDate(taskSheetDetail.terminationDate)}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="批退原因" prop="retreatReason">
          {{taskSheetDetail.retreatReason}}
        </Form-item>
        </i-col>
        <!--<i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">-->
        <!--<Form-item  prop="retreat">-->
          <!--<Checkbox v-model="formItem.retreat" disabled>批退</Checkbox>-->
        <!--</Form-item>-->
        <!--</i-col>-->
      </Row>


    </Form>
</template>

<script>
  /**
   * Created by cuixiaoguang on 2020/5/8.
   */
  import { createNamespacedHelpers } from 'vuex';
  import empBackTaskSheetTypes from "../../../store/event-types/pgyhr-task/emp_back_task_sheet_types.js";


  const { mapState, mapActions, mapMutations, mapGetters } = createNamespacedHelpers('employeeBackTaskSheetModule');
  import editableTableCell from "./editable-table-cell";

  export default {
    components: {},
    name: 'employeeBackTaskSheetListInfoTab',
    data () {
      return {
        serviceAgreement:[],
        agreementName: '',
        agreement:{
        },
        tnsuranceType:false,
        socialSecurityModal: false,
        serviceProductVModel:false,
        selectedServiceProduct: [],
        selectedCity:'',
        formItem: {
          contractStartDate: '',
          contractEndDate: '',
          socialSecurityAccount: '',
          providentFundAccount: '',
          tnsuranceType: null,
          serviceType:'',
          enterpriseTotalPay: '',
          personalTotalPay: '',
          socialSecurityPay: '',
          providentFundPay: '',
        },
        serviceAgreementTypes:[],
        serviceProductColumns: [
          {
            type: 'selection',
            width: 60,
            align: 'center'
          },
          {
            title: '服务产品序号',
            key: 'productId',
            width: 150
          },
          {
            title: '服务产品',
            key: 'serviceProductName',
            width: 200
          },
          {
            title: '标的',
            key: 'serviceProductObject',
            width: 100
          },
          {
            title: '服务产品金额',
            key: 'serviceProductAmount',
            width: 120,
          },
          {
            title: '备注',
            key: 'remark',
          }
        ],

        serviceTransferTitle:['前道服务产品', '已选择服务产品'],
        listStyle: {
          width: '400px',
          height: '200px'
        },

        insuranceItemsColumns: [
          {
            title: '项目',
            key: 'itemName',
            width: 100,
            sortable: true,
            fixed: 'left'
          },
          {
            fixed: 'left',
            title: '执行城市',
            width: 100,
            key: 'cityName',
          },
          {
            title: '企业基数',
            width: 100,
            key: 'companyBase'
          },
          {
            title: '企业实缴基数',
            key: 'companyConfirmBase',
            width: 130,
            minWidth: 55,
            align: 'center',
            render: (h, params) => {
              if (this.getControlDisabled(3)) {
                let self = this;
                return h('div', [
                  h('Input', {
                    props: {
                      value: self.$math.eval(params.row.companyConfirmBase)
                    },
                    on: {
                      'on-blur': (val) => {
                        // 如果是险种合一 统一修改社保类基数
                        if (self.tnsuranceType && params.row.policyType == '1') {
                          self.taskSheetSocialFeeInfo.forEach(function (infoItem) {
                            if (infoItem.policyType === params.row.policyType) {
                              infoItem.companyConfirmBase = val.target.value
                            }
                          })
                        } else {
                          self.taskSheetSocialFeeInfo[params.index].companyConfirmBase = val.target.value
                        }
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
            title: '人个基数',
            width: 100,
            key: 'personalBase'
          },
          {
            title: '个人实缴基数',
            key: 'personalConfirmBase',
            width: 130,
            minWidth: 55,
            align: 'center',
            render: (h, params) => {
              if (this.getControlDisabled(3)) {
                let self = this;
                return h('div', [
                  h('Input', {
                    props: {
                      value: self.$math.eval(params.row.personalConfirmBase)
                    },
                    on: {
                      'on-blur': (val) => {
                        // 如果是险种合一 统一修改社保类基数
                        if (self.tnsuranceType && params.row.policyType == '1') {
                          self.taskSheetSocialFeeInfo.forEach(function (infoItem) {
                            if (infoItem.policyType === params.row.policyType) {
                              infoItem.personalConfirmBase = val.target.value
                            }
                          })
                        } else {
                          self.taskSheetSocialFeeInfo[params.index].personalConfirmBase = val.target.value
                        }

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
            title: '缴纳开始月',
            width: 110,
            key: 'startDate',
            render: (h, params) => {
              return h('div', this.$dateUtils.stdFormatDate(params.row.startDate));
            }
          },
          {
            title: '缴纳开始确认月',
            key: 'startConfirmDate',
            minWidth: 140,
            align: 'center',
            render: (h, params) => {

              if (this.getControlDisabled(3)) {
                let self = this
                return h('div', [
                  h('DatePicker', {
                    props: {
                      type: 'month',
                      value: params.row.startConfirmDate,
                      format: 'yyyy-MM',
                      clearable: false,
                      transfer: true,
                    },
                    on: {
                      'on-change': (val) => {
                        // 如果是险种合一 统一修改社保类基数
                        if (self.tnsuranceType && params.row.policyType == '1') {
                          self.taskSheetSocialFeeInfo.forEach(function (infoItem) {
                            if (infoItem.policyType === params.row.policyType) {
                              infoItem.startConfirmDate = new Date(val + '-01')
                            }
                          })
                        } else {
                          this.taskSheetSocialFeeInfo[params.index].startConfirmDate = new Date(val + '-01')
                        }
                      }
                    }
                  })
                ])
              } else {
                return h('div', [
                  h('span', new Date(params.row.startConfirmDate).pattern('yyyy-MM-dd'))
                ])
              }
            }
          },
          {
            title: '缴纳结束月',
            width: 110,
            key: 'endDate',
            render: (h, params) => {
              return h('div', this.$dateUtils.stdFormatDate(params.row.endDate));
            }
          },
          {
            title: '缴纳结束确认月',
            key: 'endConfirmDate',
            minWidth: 140,
            align: 'center',
            render: (h, params) => {

              if (this.getControlDisabled(3)) {
                let self = this;
                return h('div', [
                  h('DatePicker', {
                    props: {
                      type: 'month',
                      value: params.row.endConfirmDate,
                      format: 'yyyy-MM',
                      clearable: false,
                      transfer: true,
                    },
                    on: {
                      'on-change': (val) => {
                        // 如果是险种合一 统一修改社保类基数
                        if (self.tnsuranceType && params.row.policyType == '1') {
                          self.taskSheetSocialFeeInfo.forEach(function (infoItem) {
                            if (infoItem.policyType === params.row.policyType) {
                              infoItem.endConfirmDate = new Date(val + '-01')
                            }
                          })
                        } else {
                          this.taskSheetSocialFeeInfo[params.index].endConfirmDate = new Date(val + '-01')
                        }
                      }
                    }
                  })
                ])
              } else {
                return h('div', [
                  h('span', new Date(params.row.endConfirmDate).pattern('yyyy-MM-dd'))
                ])
              }
            }
          },
          {
            title: '企业收费方式',
            key: 'companyPayMethodLabel',
            minWidth: 130,
            align: 'center',
            // render: (h, params) => {
            //   if (!this.getControlDisabled(3)) {
            //     return h('div', [
            //       h('span', this.baseDic.companyPayWay[this.taskSheetSocialFeeInfo[params.index].companyPayMethod])
            //     ])
            //   } else {
            //     // 组装下拉
            //     let optionList = []
            //     for (let key in this.baseDic.companyPayWay) {
            //       optionList.push(
            //               h('Option', {
            //                 props: {
            //                   value: key,
            //                   label: this.baseDic.companyPayWay[key],
            //                   transfer: true
            //                 }
            //               })
            //       )
            //     }
            //     return h('Select', {
            //       props: {
            //         value: this.taskSheetSocialFeeInfo[params.index].companyPayMethod,
            //         disabled:!this.getControlDisabled(3)
            //       },
            //       on: {
            //         'on-change': (val) => {
            //           this.taskSheetSocialFeeInfo[params.index].companyPayMethod = val
            //         }
            //       }
            //     }, optionList)
            //   }
            // }

          },
          {
            title: '个人收费方式',
            key: 'employeePayMethodLabel',
            minWidth: 130,
            // align: 'center',
            // render: (h, params) => {
            //   let self = this
            //   if (!this.getControlDisabled(3)) {
            //     return h('div', [
            //       h('span', this.baseDic.personalpayWay[this.taskSheetSocialFeeInfo[params.index].employeePayMethod])
            //     ])
            //   } else {
            //     // 组装下拉
            //     let optionList = []
            //     for (let key in this.baseDic.personalpayWay) {
            //       optionList.push(
            //               h('Option', {
            //                 props: {
            //                   value: key,
            //                   label: this.baseDic.personalpayWay[key],
            //                   transfer: true
            //                 }
            //               })
            //       )
            //     }
            //     return h('Select', {
            //       props: {
            //         value: this.taskSheetSocialFeeInfo[params.index].employeePayMethod,
            //         disabled:!this.getControlDisabled(3)
            //       },
            //       on: {
            //         'on-change': (val) => {
            //           self.taskSheetSocialFeeInfo[params.index].employeePayMethod = val
            //         }
            //       }
            //     }, optionList)
            //   }
            // }
          },
          {
            title: '企业比例',
            width: 100,
            key: 'companyRatio',
            render: (h, params) => {
              return h('div', parseFloat((params.row.companyRatio*100).toFixed(4)) + '%')
            }
          },
          {
            title: '人个比例',
            width: 100,
            key: 'personalScale',
            render: (h, params) => {
              return h('div', parseFloat((params.row.personalRatio*100).toFixed(4)) + '%')
            }
          },

          {
            title: '企业缴费',
            width: 100,
            key: 'companyAmount'
          },
          {
            title: '人个缴费',
            width: 100,
            key: 'personalAmount'
          },
          {
            title: '缴费合计',
            width: 100,
            key: 'totalAmount'
          },
        ],


        frontServiceProductsColumns: [
          {
            title: '序号',
            type: 'index',
            width: 60,
            align: 'center',
          },
          {
            title: '服务产品',
            key: 'serviceProductName',
            width: 350,

          },
          {
            title: '服务产品金额',
            key: 'serviceProductAmount',
            width: 350,

          }
        ],

      }
    },

    methods: {
      ...mapActions({
      }),

      ...mapMutations({
      }),

      getControlDisabled(modelType){
        var result = false;
        if(modelType === 3){
          if(this.selectedEmpBackTaskInfo.taskStatus === 3){
            result = true;
          }
        }
        if(modelType === 2){
          if(this.selectedEmpBackTaskInfo.taskStatus === 2 ){
            result = true;
          }
        }
        if(modelType === 1){
          if(this.selectedEmpBackTaskInfo.taskStatus === 1 ){
            result = true;
          }
        }
        if(modelType === 12){
          if(this.selectedEmpBackTaskInfo.taskStatus === 1 ||
                  this.selectedEmpBackTaskInfo.taskStatus ===2){
            result = true;
          }
        }

        return result;
      },

      serviceSelectHandler(selection) {
        this.selectedServiceProduct = selection;
      },

      show (city) {
        this.selectedCity = city;
        this.socialSecurityModal = true;
      },

      ok () {
        let serviceProductList = [...this.taskSheetServiceProductList];
        this.selectedServiceProduct.forEach(i => {
          if (serviceProductList.find(j => j.productId === i.productId) == undefined) {
            serviceProductList.push(i);
          }
        });
        this.mutateServiceProductList(serviceProductList);
      },

      cancel () {
        this.$Message.info('点击了取消');
      },

      renderFormat (item) {
        return item.label + ' - ' + item.description;
      },

      close(){
        this.socialSecurityModal = false;
      },

      getServiceAgreementTypes() {
        EntrustSearchApi.getServiceAgreementTypes().then(response => {
          const responseData = response.data;
          if (responseData.code === 0) {
            this.serviceAgreementTypes = responseData.object;
          } else {
            throw(responseData.message);
          }
        }).catch(error => {
          console.log(error);
        })
      },

      agreementChangeHandler(item) {
        this.agreement = this.serviceAgreement.find(
          i => i.serviceOrganizationAgreementId === item
        );
        console.log("this.agreement111"+JSON.stringify(this.agreement));
        this.mutateServiceAgreementId(item);
      }

    },

    watch:{
//      taskSheetSocialFeeInfo:function(val,oldval){
//        if(this.taskSheetSocialFeeInfo){
//          console.log("taskSheetSocialFeeInfo======"+JSON.stringify(this.taskSheetSocialFeeInfo));
//            this.formItem.personalTotalPay = parseFloat(_.sumBy(this.taskSheetSocialFeeInfo, i => i.personalAmountLabel).toFixed(2))
//        }
//      }

      taskSheetSocialFeeInfo:{
        handler(curVal,oldVal){
          if(this.taskSheetSocialFeeInfo){
            //console.log("taskSheetSocialFeeInfo======"+JSON.stringify(this.taskSheetSocialFeeInfo));
//            this.formItem.personalTotalPay = parseFloat(_.sumBy(this.taskSheetSocialFeeInfo, i => i.personalAmountLabel).toFixed(2));
//            this.formItem.enterpriseTotalPay = parseFloat(_.sumBy(this.taskSheetSocialFeeInfo, i => i.companyAmountLabel).toFixed(2));
//
            this.formItem.personalTotalPay = this.formItem.socialSecurityPay = parseFloat(_.sumBy(this.taskSheetSocialFeeInfo, i => {
              if(i.personalAmount != null){
                return i.employeePayMethod == 1?i.personalAmount:0;
              }else{
                return 0;
              }
            }).toFixed(2));


            this.formItem.enterpriseTotalPay = this.formItem.socialSecurityPay = parseFloat(_.sumBy(this.taskSheetSocialFeeInfo, i => {
              if(i.companyAmount != null){
                return i.companyPayMethod == 1?i.companyAmount:0;
              }else{
                return 0;
              }
            }).toFixed(2));

            this.formItem.socialSecurityPay = parseFloat(_.sumBy(this.taskSheetSocialFeeInfo, i => {
              if(i.companyAmount != null && i.personalAmount != null){
                let companyAmount = i.companyPayMethod == 1?i.companyAmount:0;
                let personalAmount = i.employeePayMethod == 1?i.personalAmount:0;
                return i.policyType == 1 ? companyAmount + personalAmount : 0;
              }else{
                return 0;
              }
            }).toFixed(2));
            this.formItem.providentFundPay = parseFloat(_.sumBy(this.taskSheetSocialFeeInfo, i => {
              if(i.companyAmount != null && i.personalAmount != null){
                  let companyAmount = i.companyPayMethod == 1?i.companyAmount:0;
                  let personalAmount = i.employeePayMethod == 1?i.personalAmount:0;
                return i.policyType == 2 ? companyAmount + personalAmount : 0;
              }else{
                return 0;
              }
            }).toFixed(2));

          }
        },
        deep:true
      }
    },

    computed: {
      ...mapState({
        taskSheetDetail: state => state.empBackTaskSheetDetail,
        taskSheetSocialFeeInfo: state => state.empBackTaskSheetSocialFeeInfo,
        selectedEmpBackTaskInfo :state=> state.selectedEmpBackTaskInfo,
      }),
      ...mapGetters([

      ]),
    },

    created() {
    }

  }

</script>
