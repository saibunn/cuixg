<template>
    <Form :model="formItem" :label-width="120">
      <Row>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="社保账号" prop="employeeSecurityAccount">
          {{taskSheetDetail.employeesSocialAccount}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="公积金账号" prop="employeeFundAccount">
          {{taskSheetDetail.employeesAddFundAccount}}
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
        <Form-item label="服务费"  prop="serviceFee">
          {{taskSheetDetail.serviceFee}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="实际工资" prop="actualWage">
          {{taskSheetDetail.actualWage}}
        </Form-item>
        </i-col>

        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="备注" prop="remark">
          {{taskSheetDetail.remark}}
        </Form-item>
        </i-col>
      </Row>
      <Row>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="终止原因" prop="outReasonLabel">
          {{taskSheetDetail.outReasonLabel}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="终止日期"  prop="outDate">
          {{$dateUtils.stdFormatDate(taskSheetDetail.outDate)}}
        </Form-item>
        </i-col>
        <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="批退原因" prop="retreatReason">
          {{taskSheetDetail.retreatReason}}
        </Form-item>
        </i-col>
      </Row>
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

        listStyle: {
          width: '400px',
          height: '200px'
        },

        insuranceItemsColumns: [
          {
            title: '反馈状态',
            width: 100,
            key: 'socialStatusLabel'
          },
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
            width: 120,
            key: 'cityName',
            ellipsis: true
          },
          {
            title: '企业基数',
            width: 100,
            key: 'companyBase'
          },
          {
            title: '企业实缴基数',
            width: 100,
            key: 'companyConfirmBase'
          },
          {
            title: '人个基数',
            width: 100,
            key: 'personalBase'
          },
          {
            title: '个人实缴基数',
            width: 100,
            key: 'personalConfirmBase'
          },
          {
            title: '企业比例',
            width: 100,
            key: 'companyScale',
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
            width: 140,
            key: 'startConfirmDate',
            render: (h, params) => {
              return h('div', this.$dateUtils.stdFormatDate(params.row.startConfirmDate));
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
            width: 140,
            key: 'endConfirmDate',
            render: (h, params) => {
              return h('div', this.$dateUtils.stdFormatDate(params.row.endConfirmDate));
            }
          }
        ],
      }
    },

    methods: {




    },

    computed: {
      ...mapState({
        taskSheetDetail: state => state.empFrontTaskSheetDetail,
        taskSheetSocialFeeInfo: state => state.taskSheetSocialFeeInfo
      }),
    },

    created () {
    }

  }

</script>
