<style scoped>
  .ivu-form-item-baseInfo {
    margin-bottom: 24px;
    vertical-align: top;
    height: 18px;
    zoom: 1;
  }
</style>
<template>

  <Form :model="formItem" :label-width="100" >
    <Row>
      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
      <Form-item label="委托单号：" prop="taskSheetId" class="ivu-form-item-baseInfo">
        <label>{{taskSheetDetail.taskSheetId}}</label>
      </Form-item>
      </i-col>
      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
      <Form-item label="雇员姓名：" prop="employeesName" class="ivu-form-item-baseInfo">
        <label>{{taskSheetDetail.employeesName}}</label>
      </Form-item>
      </i-col>
      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="委托方编号：" prop="entrustNo" class="ivu-form-item-baseInfo">
          <label>{{entrustNo}}</label>
        </Form-item>
      </i-col>

      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
      <Form-item label="受托方编号：" prop="trustNo" class="ivu-form-item-baseInfo">
        <label>{{trustNo}}</label>
      </Form-item>
      </i-col>

      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="公司名称：" prop="companyName" class="ivu-form-item-baseInfo">
          <label>{{taskSheetDetail.companyName}}</label>
        </Form-item>
      </i-col>
      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="委托公司编号：" class="ivu-form-item-baseInfo">
          <!-- <label>{{entrustCompanyNo}}</label> -->
        </Form-item>
      </i-col>

      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="受托公司编号：" class="ivu-form-item-baseInfo">
          <!-- <label>{{trustCompanyNo}}</label> -->
        </Form-item>
      </i-col>

      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="雇员电话：" prop="employTel" class="ivu-form-item-baseInfo">
          <label>{{employeeInfo.mobile}}</label>
        </Form-item>
      </i-col>
      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="公司电话：" prop="companyTel" class="ivu-form-item-baseInfo">
          <label>{{companyTel}}</label>
        </Form-item>
      </i-col>
      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="证件类型：" prop="idType" class="ivu-form-item-baseInfo">
          <label>{{employeeInfo.idCardName}}</label>
        </Form-item>
      </i-col>
      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="证件号码：" prop="idNo" class="ivu-form-item-baseInfo">
          <label>{{employeeInfo.idNum}}</label>
        </Form-item>
      </i-col>

      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="出生日期：" prop="processingFeedbackDate" class="ivu-form-item-baseInfo">
          <label>{{employeeInfo.birthday}}</label>
        </Form-item>
      </i-col>
      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="国籍：" prop="nationality" class="ivu-form-item-baseInfo">
          <label>{{employeeInfo.countryName}}</label>
        </Form-item>
      </i-col>
      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="户口性质：" prop="accountType" class="ivu-form-item-baseInfo">
          <label>{{employeeInfo.residentName}}</label>
        </Form-item>
      </i-col>

      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
      <Form-item label="性别：" prop="sex" class="ivu-form-item-baseInfo">
        <label>{{employeeInfo.genderValue}}</label>
      </Form-item>
      </i-col>
      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
      <Form-item label="雇员邮箱：" prop="employMail" class="ivu-form-item-baseInfo">
        <label>{{employeeInfo.email}}</label>
      </Form-item>
      </i-col>
      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="中心：" prop="core" class="ivu-form-item-baseInfo">
          <label></label>
        </Form-item>
      </i-col>
      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="团队：" prop="team" class="ivu-form-item-baseInfo">
          <label></label>
        </Form-item>
      </i-col>

      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
      <Form-item label="办理用工日期：" prop="employmentDate" class="ivu-form-item-baseInfo">
        <label>{{formatDate(taskSheetDetail.employmentDate)}}</label>
      </Form-item>
      </i-col>

      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="合同开始日期：" prop="contractStartDate" class="ivu-form-item-baseInfo">
          <label>{{formatDate(taskSheetDetail.contractStartDate)}}</label>
        </Form-item>
      </i-col>

      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="合同结束日期：" prop="contractEndDate" class="ivu-form-item-baseInfo">
          <label>{{formatDate(taskSheetDetail.contractEndDate)}}</label>
        </Form-item>
      </i-col>

      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="委托确认日期：" prop="entrustSubmitDate" class="ivu-form-item-baseInfo">
          <label>{{formatDate(taskSheetDetail.entrustDate)}}</label>
        </Form-item>
      </i-col>
    </Row>
  </Form>

</template>

<script>
import { createNamespacedHelpers } from 'vuex';
import EntrustTaskSheetTypes from "../../../store/event_types/entrust_task_sheet_types";
const { mapState, mapActions, mapMutations, mapGetters  } = createNamespacedHelpers('employeeBackTaskSheetModule');
  /**
   * Created by cuixiaoguang on 2020/5/7.
   */
  export default {
    name: 'employeeBackTaskBaseInfo',
    data () {
      return {

        formItem: {
          date: '',
          time: ''
        }
      }
    },

    methods: {

      formatDate(date) {
        if(date != '' && date != undefined) {
          return this.$moment(date).format('YYYY-MM-DD');
        }
        return '';
      }
    },

    computed: {
      ...mapState({
        taskSheetDetail: state => state.taskSheetDetail
      }),

      ...mapState({
        employeeInfo: state => state.employeeInfo
      }),

      ...mapState('serviceAgreementModule', {
        serviceAgreement: state => state.serviceAgreementByTaskCityData,
      }),
    }

  }
</script>
