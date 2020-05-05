<style scoped>
  .ivu-form-item-baseInfo {
    margin-bottom: 24px;
    vertical-align: top;
    height: 18px;
    zoom: 1;
  }
</style>
<template>

  <Form :model="formItem" :label-width="120" >
    <Row>
      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="雇员姓名：" prop="employeeName" class="ivu-form-item-baseInfo">
          <label>{{taskSheetDetail.employeeName}}</label>
        </Form-item>
      </i-col>

      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="公司名称：" prop="companyName" class="ivu-form-item-baseInfo">
          <label>{{taskSheetDetail.companyName}}</label>
        </Form-item>
      </i-col>

      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="雇员电话：" prop="employeeMobile" class="ivu-form-item-baseInfo">
          <label>{{employeeInfo.employeeMobile}}</label>
        </Form-item>
      </i-col>
      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="证件类型：" prop="idType" class="ivu-form-item-baseInfo">
          <label>{{employeeInfo.idCardTypeLabel}}</label>
        </Form-item>
      </i-col>
      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="证件号码：" prop="idNo" class="ivu-form-item-baseInfo">
          <label>{{employeeInfo.idNum}}</label>
        </Form-item>
      </i-col>

      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="出生日期：" prop="processingFeedbackDate" class="ivu-form-item-baseInfo">
          <label>{{$dateUtils.stdFormatDate(taskSheetDetail.birthday)}}</label>
        </Form-item>
      </i-col>
      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="国籍：" prop="nationality" class="ivu-form-item-baseInfo">
          <label>{{employeeInfo.countryCode}}</label>
        </Form-item>
      </i-col>
      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="户口性质：" prop="accountType" class="ivu-form-item-baseInfo">
          <label>{{employeeInfo.residentTypeLabel}}</label>
        </Form-item>
      </i-col>

      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="性别：" prop="sex" class="ivu-form-item-baseInfo">
          <label>{{employeeInfo.genderLabel}}</label>
        </Form-item>
      </i-col>
      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="雇员邮箱：" prop="employMail" class="ivu-form-item-baseInfo">
          <label>{{employeeInfo.employeeEmail}}</label>
        </Form-item>
      </i-col>

      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="办理用工日期：" prop="employmentDate" class="ivu-form-item-baseInfo">
          <label>{{$dateUtils.stdFormatDate(taskSheetDetail.employmentDate)}}</label>
        </Form-item>
      </i-col>

      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="合同开始日期：" prop="contractStartDate" class="ivu-form-item-baseInfo">
          <label>{{$dateUtils.stdFormatDate(taskSheetDetail.contractStartDate)}}</label>
        </Form-item>
      </i-col>

      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="合同结束日期：" prop="contractEndDate" class="ivu-form-item-baseInfo">
          <label>{{$dateUtils.stdFormatDate(taskSheetDetail.contractEndDate)}}</label>
        </Form-item>
      </i-col>
    </Row>
  </Form>

</template>

<script>
  import { createNamespacedHelpers } from 'vuex'
  const { mapState, mapActions, mapMutations, mapGetters  } = createNamespacedHelpers('employeeFrontTaskModule')
  /**
   * Created by cuixiaoguang on 2020/5/4.
   */
  export default {
    name: 'employeeFrontTaskBaseInfo',
    data () {
      return {
        formItem: {
        }
      }
    },
    methods: {
    },
    computed: {
      ...mapState({
        taskSheetDetail: state => state.empFrontTaskSheetDetail,
        employeeInfo: state => state.employeeInfo
      }),
    }
  }
</script>
