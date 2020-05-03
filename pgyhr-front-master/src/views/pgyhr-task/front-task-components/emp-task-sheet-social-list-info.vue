<template>
    <Form :model="formItem" :label-width="120">
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
        <i-col span="20">
        <Table border :columns="insuranceItemsColumns" :data="taskSheetSocialFeeInfo" ref="insuranceItemsTable"></Table>
        </i-col>
      </Row>

      <Row style="margin-top: 10px">
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="企业缴费总计" prop="enterpriseTotalPay">
          {{parseFloat(_.sumBy(taskSheetSocialFeeInfo, i => i.companyAmount).toFixed(2))}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="个人缴费总计" prop="personalTotalPay">
          {{parseFloat(_.sumBy(taskSheetSocialFeeInfo, i => i.personalAmount).toFixed(2))}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="其中社保" prop="socialSecurityPay">
          {{
          parseFloat(_.sumBy(taskSheetSocialFeeInfo, i => {
              if(i.companyAmount != null && i.personalAmount != null){
              return i.policyType == 1 ? i.companyAmount + i.personalAmount : 0;
              }else{
                return 0;
              }
            }).toFixed(2))
          }}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="其中公积金" prop="providentFundPay">
          {{
          parseFloat(_.sumBy(taskSheetSocialFeeInfo, i => {
              if(i.companyAmount != null && i.personalAmount != null){
                return i.policyType == 2 ? i.companyAmount + i.personalAmount : 0;
              }else{
                return 0;
              }
            }).toFixed(2))
          }}
        </Form-item>
        </i-col>
      </Row>


      <Row style="margin-top: 10px">
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
        <Form-item label="档案保管费" prop="fileKeepingCost">
          {{taskSheetDetail.fileKeepFee}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="档案费执行年月"  prop="fileCostStartDate">
          {{$dateUtils.stdFormatDate(taskSheetDetail.fileKeepFeeStartDate)}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="档案费结束年月"  prop="fileCostEndDate">
          {{$dateUtils.stdFormatDate(taskSheetDetail.fileKeepFeeEndDate)}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="档案费反馈状态" prop="fileKeepFeeStatus">
          {{taskSheetDetail.fileKeepFeeStatusLabel}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="档案费反馈日期" prop="fileKeepFeeStatusDate">
          {{$dateUtils.stdFormatDate(taskSheetDetail.fileKeepFeeStatusDate)}}
        </Form-item>
        </i-col>
        <!--<i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">-->
        <!--<Form-item label="档案费反馈人" prop="fileCostBackUser">-->
          <!--{{formItem.fileCostBackUser}}-->
        <!--</Form-item>-->
        <!--</i-col>-->

        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="额外费用" prop="etcCost">
          {{taskSheetDetail.otherFee}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="额外费用执行年月"  prop="etcCostStartDate">
          {{$dateUtils.stdFormatDate(taskSheetDetail.otherFeeStartDate)}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="额外费用结束年月"  prop="etcCostEndDate">
          {{$dateUtils.stdFormatDate(taskSheetDetail.otherFeeEndDate)}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="额外费用反馈状态" prop="otherFeeStatus">
          {{taskSheetDetail.otherFeeStatusLabel}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="额外费用反馈日期" prop="otherFeeStatusDate">
          {{$dateUtils.stdFormatDate(taskSheetDetail.otherFeeStatusDate)}}
        </Form-item>
        </i-col>
        <!--<i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">-->
        <!--<Form-item label="额外费用反馈人" prop="etcCostBackUser">-->
          <!--{{formItem.etcCostBackUser}}-->
        <!--</Form-item>-->
        <!--</i-col>-->

        <!--<i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">-->
        <!--<Form-item label="账单月份" prop="billMonth">-->
          <!--{{formItem.billMonth}}-->
        <!--</Form-item>-->
        <!--</i-col>-->
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="服务费"  prop="serviceCost">
          {{taskSheetDetail.serviceFee}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="实际工资" prop="realWages">
          {{taskSheetDetail.actualWage}}
        </Form-item>
        </i-col>
        <!--<i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">-->
        <!--<Form-item label="总计" prop="totalCost">-->
          <!--{{formItem.totalCost}}-->
        <!--</Form-item>-->
        <!--</i-col>-->

        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="委托方备注" prop="entrustRemarks">
          <i-input v-model="taskSheetDetail.entrustRemark" :disabled="true" @on-change="entrustRemarkChangeHandler" type="textarea" :rows="4" ></i-input>
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

      <!--<Modal-->
        <!--v-model="socialSecurityModal"-->
        <!--title="社保公积金基数"-->
        <!--width="1000"-->
        <!--@on-ok="ok"-->
        <!--@on-cancel="cancel">-->
        <!--<Pay-base :selectedCity="selectedCity"></Pay-base>-->
        <!--<div slot="footer">-->
          <!--<Row>-->
            <!--<i-col span="24" align="right">-->
              <!--<i-button type="primary" @click="this.close" >确认</i-button>-->
            <!--</i-col>-->
          <!--</Row>-->
        <!--</div>-->
      <!--</Modal>-->

      <!--<Modal-->
        <!--v-model="serviceProductVModel"-->
        <!--title="服务产品选择" width="800"-->
        <!--ok-text="确认"-->
        <!--@on-ok="ok"-->
        <!--@on-cancel="cancel">-->
        <!--<Table-->
          <!--@on-selection-change="serviceSelectHandler"-->
          <!--border highlight-row-->
          <!--:columns="serviceProductColumns"-->
          <!--:data="entrustCityServiceProductList"-->
          <!--ref="entrustTable"></Table>-->
      <!--</Modal>-->

    </Form>
</template>

<script>
  /**
   * Created by cuixiaoguang on 2020/5/4.
   */
  import { createNamespacedHelpers } from 'vuex'
  const { mapState, mapActions, mapMutations, mapGetters } = createNamespacedHelpers('employeeFrontTaskModule')

  export default {
    components: {},
    name: 'entrustListInfoTab1',
    data () {
      return {
        socialSecurityModal: false,
        serviceProductVModel: false,
        selectedServiceProduct: [],
        selectedCity: '',
        formItem: {
          contractStartDate: '',
          contractEndDate: '',
          socialSecurityAccount: '',
          providentFundAccount: '',
          tnsuranceType: null,
          serviceType: '',
          enterpriseTotalPay: '',
          personalTotalPay: '',
          socialSecurityPay: '',
          providentFundPay: ''
        },
        serviceAgreementTypes: [],
        serviceProductColumns: [
          {
            type: 'selection',
            width: 60,
            align: 'center'
          },
          {
            title: '服务产品序号',
            key: 'serviceProductId',
            width: 120
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
            width: 150
          },
          {
            title: '备注',
            key: 'remark'
          }
        ],

        serviceTransferTitle: ['前道服务产品', '已选择服务产品'],
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
            width: 120,
            key: 'socialCityName',
            ellipsis: true
          },
          {
            title: '城市备注',
            width: 120,
            key: 'cityRemarks',
            ellipsis: true,
            render: (h, params) => {
              return h('div', [
                h('Tooltip', {
                  props: {
                    content: params.row.cityRemarks
                  }
                }, params.row.cityRemarks)
              ])
            }
          },
          {
            title: '城市序号',
            width: 100,
            key: 'socialCityId'
          },
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
              return h('div', parseFloat((params.row.companyScale*100).toFixed(4)) + '%')
            }
          },
          {
            title: '人个比例',
            width: 100,
            key: 'personalScale',
            render: (h, params) => {
              return h('div', parseFloat((params.row.personalScale*100).toFixed(4)) + '%')
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
          }
        ],
        frontServiceProductsColumns: [
          {
            title: '前道服务产品',
            key: 'serviceProductName',
            width: 200
          },
          {
            title: '前道服务产品金额',
            key: 'serviceProductAmount'
          }
        ]}
    },

    methods: {




    },

    computed: {
      ...mapState({
        taskSheetDetail: state => state.empFrontTaskSheetDetail,
        taskSheetSocialFeeInfo: state => state.empFrontTaskSheetSocialFeeSegment
      }),
    },

    created () {
    }

  }

</script>
