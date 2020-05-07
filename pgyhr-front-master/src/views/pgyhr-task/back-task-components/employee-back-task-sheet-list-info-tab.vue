<template>
    <Form :model="formItem" :label-width="130">
      <Row>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="合同开始日期" prop="contractStartDate">
          {{$dateUtils.stdFormatDate(taskSheetDetail.contractStartDate)}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="合同结束日期" prop="employeeName">
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

      <Row style="display:inline-block">
        <i-col  :sm="{span:22}" :md="{span: 12}" :lg="{span: 10}">
          <Table stripe :columns="frontServiceProductsColumns" :data="taskSheetAfProductService" height="260"></Table>
        </i-col>

        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 12}" style="margin-left: 10px">
          <Row style="display:inline-block">
            <Table stripe :columns="serviceProductsSelectColumns" :data="taskSheetServiceProductList" height="260"></Table>
          </Row>
         <Row style="margin-top: 10px">
           <i-col span="12">
             <i-button type="primary" @click="this.showServiceProduct" :disabled="isTaskSheetProcessed">添加服务产品</i-button>
           </i-col>
         </Row>

        </i-col>

      </Row>

      <Row style="margin-top: 10px">
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="服务产品费" prop="serviceProductCost">
          {{taskSheetDetail.serviceProductCost}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="服务产品执行年月"  prop="serviceProductStartDate">
          {{$dateUtils.stdFormatDate(taskSheetDetail.serviceProductStartDate)}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="服务产品结束年月"  prop="serviceProductEndDate">
          {{$dateUtils.stdFormatDate(taskSheetDetail.serviceProductEndDate)}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="服务产品反馈状态" prop="serviceProductStatus">
          {{taskSheetDetail.serviceProductStatusLabel}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="服务产品反馈日期" prop="serviceProductStatusDate">
          {{$dateUtils.stdFormatDate(taskSheetDetail.serviceProductStatusDate)}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="服务产品反馈人" prop="serviceProductBackUser">
          {{formItem.serviceProductBackUser}}
        </Form-item>
        </i-col>


        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="账单月份" prop="billMonth">
          {{formItem.billYm}}
        </Form-item>
        </i-col>
        <!--<i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">-->
        <!--<Form-item label="服务费"  prop="serviceCost">-->
          <!--{{taskSheetDetail.serviceFee}}-->
        <!--</Form-item>-->
        <!--</i-col>-->
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
        <Form-item label="委托方备注" prop="entrustRemarks">
          <i-input v-model="taskSheetDetail.entrustRemark" :disabled="isTaskSheetProcessed" @on-change="entrustRemarkChangeHandler" type="textarea" :rows="4" ></i-input>
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="受托方备注"  prop="trustRemarks">
          <i-input v-model="taskSheetDetail.beEntrustRemark"  type="textarea" :rows="4" disabled></i-input>
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

      <Modal
        v-model="socialSecurityModal"
        title="社保公积金基数"
        width="1000"
        @on-ok="ok"
        @on-cancel="cancel">
        <Pay-base :selectedCity="selectedCity"></Pay-base>
        <div slot="footer">
          <Row>
            <i-col span="24" align="right">
              <i-button type="primary" @click="this.close" >确认</i-button>
            </i-col>
          </Row>
        </div>
      </Modal>

      <Modal
        v-model="serviceProductVModel"
        title="服务产品选择" width="800"
        ok-text="确认"
        @on-ok="ok"
        @on-cancel="cancel">
        <Table ref="serviceProductTable"
          @on-selection-change="serviceSelectHandler"
          border highlight-row
          :columns="serviceProductColumns"
          :data="entrustCityServiceProductList"
          ></Table>
      </Modal>

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
            type: 'index',
            width: 60,
            align: 'center',
            fixed: 'left'
          },
          {
            title: '项目',
            key: 'socialSecurityName',
            width: 100,
            sortable: true,
            fixed: 'left'
          },
          {
            fixed: 'left',
            title: '执行城市',
            width: 100,
            key: 'socialCityName',
          },
//          {
//            title: '智翼通社保选择',
//            key: 'zytSiId',
//            width: 200,
//            align: 'center',
//            render: (h, params) => {
//              return h('Select', {
//                  props:{
//                    value: params.row.zytSiId,
//                    disabled: this.isTaskSheetProcessed
//                  },
//                  on: {
//                    'on-change':(event) => {
//                      console.log("event============"+event);
//                      if(this.tnsuranceType){
//                        for (var i=0;i<this.taskSheetSocialFeeInfo.length;i++) {
//                          this.taskSheetSocialFeeInfo[i].zytSiId = event;
//                        }
//                      }else{
//                        this.taskSheetSocialFeeInfo[params.index].zytSiId = event;
//                      }
//                      console.log("event============"+event);
//                      this.mutateTaskSheetSocialFeeInfo(this.taskSheetSocialFeeInfo);
//                    }
//                  },
//                },
//                this.taskSheetSocialInfoList.map(function(item){
//                  return h('Option', {
//                    props: {value:item.SIId,label:item.SIName}
//                    }, item.SIName);
//                })
//              );
//            },
//          },

//          {
//            title: '城市备注',
//            width: 120,
//            key: 'cityRemarks',
//            ellipsis:true,
//            render: (h, params) => {
//              return h('div', [
//                h('Tooltip', {
//                  props: {
//                    content: params.row.cityRemarks
//                  },
//                }, params.row.cityRemarks)
//              ]);
//            }
//          },
//          {
//            title: '城市序号',
//            width: 100,
//            key: 'socialCityId'
//          },
          {
            title: '企业基数',
            width: 100,
            key: 'companyBase'
          },
          {
            title: '人个基数',
            width: 100,
            key: 'personalBase'
          },
          {
            title: '企业比例',
            width: 100,
            key: 'companyScale',
            render: (h, params) => {
              return h('div', params.row.companyScale + "%");
            }
          },
          {
            title: '人个比例',
            width: 100,
            key: 'personalScale',
            render: (h, params) => {
              return h('div', params.row.personalScale + "%");
            }
          },
          {
            title: '企业缴费',
            width: 100,
            key: 'companyAmountLabel',
          },
          {
            title: '人个缴费',
            width: 100,
            key: 'personalAmountLabel'
          },
          {
            title: '缴费合计',
            width: 100,
            key: 'totalAmountLabel'
          },
          {
            title: '开始年月',
            width: 110,
            key: 'startDate',
            render: (h, params) => {
              return h('div', this.$dateUtils.stdFormatDate(params.row.startDate));
            }
          },
          {
            title: '结束年月',
            width: 110,
            key: 'endDate',
            render: (h, params) => {
              return h('div', this.$dateUtils.stdFormatDate(params.row.endDate));
            }
          },
          {
            title: '反馈状态',
            width: 100,
            key: 'socialSecurityStatusLabel'
          },
          {
            title: '企业收款方式',
            width: 120,
            key: 'companyPayMethod',
            render: (h, params) => {
              return h('div', [
                  h('Select', {
                      props: {
                        value: params.row.companyPayMethod,
                        disabled: this.isTaskSheetProcessed
                      },
                      on: {
                          'on-change':(event) => {
                            if(this.tnsuranceType){
                              for (var i=0;i<this.taskSheetSocialFeeInfo.length;i++) {
                                this.taskSheetSocialFeeInfo[i].companyPayMethod = event;
                                if(event !=1){
                                  this.taskSheetSocialFeeInfo[i].companyAmountLabel = 0;
                                }else{
                                  this.taskSheetSocialFeeInfo[i].companyAmountLabel = this.taskSheetSocialFeeInfo[i].companyAmount;
                                }
                                this.taskSheetSocialFeeInfo[i].totalAmountLabel = this.taskSheetSocialFeeInfo[i].companyAmountLabel +  this.taskSheetSocialFeeInfo[i].personalAmountLabel;
                              }
                            }else{
                              this.taskSheetSocialFeeInfo[params.index].companyPayMethod = event;
                              if(event !=1){
                                this.taskSheetSocialFeeInfo[params.index].companyAmountLabel = 0;
                              }else{
                                this.taskSheetSocialFeeInfo[params.index].companyAmountLabel = params.row.companyAmount;
                              }
                              this.taskSheetSocialFeeInfo[params.index].totalAmountLabel = this.taskSheetSocialFeeInfo[params.index].companyAmountLabel +  this.taskSheetSocialFeeInfo[params.index].personalAmountLabel;
                            }
                            this.mutateTaskSheetSocialFeeInfo(this.taskSheetSocialFeeInfo);
                          }
                        },
                    },
                    [
                      h('Option', {
                          props: {
                            value: 1,
                            label:'服务费',
                          },
                        },'服务费'
                      ),
                      h('Option', {
                          props: {
                            value: 2,
                            label: '公司自付',
                          },
                        },'公司自付'
                      ),
                      h('Option', {
                          props: {
                            value: 3,
                            label: '个人工资自付',
                          },
                        },'个人工资自付'
                      ),
                    ]
                  )
                ]
              );
            }
          },
          {
            title: '个人收款方式',
            width: 120,
            key: 'employeePayMethod',
            render: (h, params) => {
              return h('div', [
                  h('Select', {
                    props: {
                        value: params.row.employeePayMethod,
                        disabled: this.isTaskSheetProcessed
                      },
                    on: {
                        'on-change':(event) => {
                          if(this.tnsuranceType){
                            for (var i=0;i<this.taskSheetSocialFeeInfo.length;i++) {
                              this.taskSheetSocialFeeInfo[i].employeePayMethod = event;
                              if(event !=1){
                                this.taskSheetSocialFeeInfo[i].personalAmountLabel = 0;
                              }else{
                                this.taskSheetSocialFeeInfo[i].personalAmountLabel = this.taskSheetSocialFeeInfo[i].personalAmount;
                              }
                              this.taskSheetSocialFeeInfo[i].totalAmountLabel = this.taskSheetSocialFeeInfo[i].companyAmountLabel +  this.taskSheetSocialFeeInfo[i].personalAmountLabel;
                            }
                          }else{
                            this.taskSheetSocialFeeInfo[params.index].employeePayMethod = event;
                            if(event !=1){
                              this.taskSheetSocialFeeInfo[params.index].personalAmountLabel = 0;
                            }else{
                              this.taskSheetSocialFeeInfo[params.index].personalAmountLabel = params.row.personalAmount;
                            }
                            this.taskSheetSocialFeeInfo[params.index].totalAmountLabel = this.taskSheetSocialFeeInfo[params.index].companyAmountLabel +  this.taskSheetSocialFeeInfo[params.index].personalAmountLabel;
                          }
                          this.mutateTaskSheetSocialFeeInfo(this.taskSheetSocialFeeInfo);
                        }
                      },
                    },
                    [
                      h('Option', {
                          props: {
                            value: 1,
                            label:'服务费',
                          },
                        },'服务费'
                      ),
                      h('Option', {
                          props: {
                            value: 2,
                            label: '公司自付',
                          },
                        },'公司自付'
                      ),
                      h('Option', {
                          props: {
                            value: 3,
                            label: '个人工资自付',
                          },
                        },'个人工资自付'
                      ),
                    ]
                  )
                ]
              );
            }
          }
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

        serviceProductsSelectColumns: [
          {
            title: '序号',
            type: 'index',
            width: 100,
            align: 'center',
          },
          {
            title: '操作',
            key: 'action',
            align: 'center',
            width: 200,

            render: (h, params) => {
              return h('div', [

                h('Button', {
                  props: {
                    type: 'error',
                    size: 'small',
                    disabled: this.isTaskSheetProcessed
                  },
                  on: {
                    click: () => {
                      this.remove(params.index)
                    }
                  }
                }, '删除')
              ]);
            }
          }
        ],
      }
    },

    methods: {
      ...mapActions({
        getServiceProductByTaskSheetCity: empBackTaskSheetTypes.GET_SERVICE_PRODUCT_BY_TASK_SHEET_CITY,
      }),

      ...mapMutations({
        mutateTaskSheetSocialFeeInfo: empBackTaskSheetTypes.MUTATE_TASK_SHEET_SOCIAL_FEE_INFO,
        mutateServiceProductList: empBackTaskSheetTypes.MUTATE_TASK_SHEET_SERVICE_PRODUCT,
        mutateServiceProductAmount: empBackTaskSheetTypes.MUTATE_TASK_SHEET_SERVICE_PRODUCT_AMOUNT,
        deleteServiceProduct: empBackTaskSheetTypes.DELETE_TASK_SHEET_SERVICE_PRODUCT,
        mutateServiceAgreementType: empBackTaskSheetTypes.MUTATE_SUBMIT_SERVICE_AGREEMENT_TYPE,
        mutateEntrustRemark: empBackTaskSheetTypes.MUTATE_SUBMIT_ENTRUST_REMARK
      }),

      serviceSelectHandler(selection) {
        this.selectedServiceProduct = selection;
      },

      show (city) {
        this.selectedCity = city;
        this.socialSecurityModal = true;
      },

      showServiceProduct () {
        //this.getServiceProductByTaskSheetCity();

        this.$refs.serviceProductTable.selectAll(false);
        this.serviceProductVModel = true;
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

      remove(index) {
        this.deleteServiceProduct(index);
      },

      serviceAgreementTypeSelectHandler(value) {
        this.mutateServiceAgreementType(value);
      },

      entrustRemarkChangeHandler(event) {
        this.mutateEntrustRemark(event.target.value);
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
        taskSheetDetail: state => state.taskSheetDetail,
        taskSheetSocialFeeInfo: state => state.taskSheetSocialFeeInfo,
        taskSheetAfProductService: state => state.taskSheetAfProductService,
        entrustCityServiceProductList: state => state.entrustCityServiceProductList,
        taskSheetServiceProductList: state => state.taskSheetServiceProductList,
      }),
      ...mapGetters([
        'isTaskSheetProcessed',
      ]),
    },

    created() {
    }

  }

</script>
