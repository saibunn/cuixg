<template>


  <Collapse v-model="employeeInfo">
    <Panel name="1">
      雇员基本信息
      <div class="form" slot="content">
        <employee-back-task-base-info></employee-back-task-base-info>
      </div>
    </Panel>
    <Panel name="2">
      委托单信息
        <div class="form" slot="content">
          <employee-back-task-sheet-list-info></employee-back-task-sheet-list-info>
        </div>
    </Panel>
    <Panel name="3">
      <div class="form" slot="content">
          <Row>
            <i-col span="24" align="right">
              <Button type="warning" style="width: 100px" @click="backSearch" >返回</Button>
              <!--<Button type="info" style="width: 150px">委托合同预览打印</Button>-->
              <Button
                type="primary"
                style="width: 100px"
                :disabled="isTaskSheetProcessed"
                :loading="submitting"
                @click="submit">提交</Button>
              <Button type="primary"
                style="width: 100px"
                @click="this.showrejectEmployeeBackTaskSheetModal"
                :disabled="isTaskSheetProcessed">退前道</Button>
            </i-col>
          </Row>
      </div>

      <Modal
        v-model="returnCustomerServiceModel"
        title="退前道确认"
        width="500">
        <reject-employee-back-task-sheet-modal ref="rejectEmployeeBackTaskSheetModalRef"></reject-employee-back-task-sheet-modal>
        <div slot="footer">
          <Row>
            <i-col span="24" >
              <i-button type="ghost"  @click="this.closeReturnCustomerServiceModel">关闭</i-button>
              <i-button type="primary" @click="this.returnCustomerService" >确认</i-button>

            </i-col>
          </Row>
        </div>
      </Modal>

    </Panel>
  </Collapse>


</template>

<script >
  // import { createNamespacedHelpers } from 'vuex';
  import { mapActions, mapGetters, mapState,mapMutations } from 'vuex';
  import employeeBackTaskBaseInfo from "./employee-back-task-base-info.vue";
  import employeeBackTaskSheetListInfo from "./employee-back-task-sheet-list-info";
  import empBackTaskSheetTypes from "../../../store/event-types/pgyhr-task/emp_back_task_sheet_types.js";
  import rejectEmployeeBackTaskSheetModal from "./reject-employee-back-task-sheet-modal.vue";

  // const { mapActions, mapGetters } = createNamespacedHelpers('employeeBackTaskSheetModule')

  export default {
    components: {employeeBackTaskBaseInfo,employeeBackTaskSheetListInfo,rejectEmployeeBackTaskSheetModal},
    name: 'employeeBackTaskSheetDetail',
    data () {
      return {
        returnCustomerServiceModel: false,
        employeeInfo: [1,2,3],
        submitting: false,
        formItem: {
          date: '',
          time: ''
        }
      }
    },
    props:['showDetail'],
    methods: {
      ...mapActions('employeeBackTaskSheetModule', {
        getTaskSheetDetail: empBackTaskSheetTypes.GET_TASK_SHEET_DETAIL,
        submitTaskSheet: empBackTaskSheetTypes.SUBMIT_TASK_SHEET,
        getSocialFeeInfo: empBackTaskSheetTypes.GET_TASK_SHEET_SOCIAL_FEE_INFO,
//        getSocialInfoList: empBackTaskSheetTypes.GET_TASK_SHEET_SOCIAL_INFO_LIST,
        getHistory: empBackTaskSheetTypes.GET_TASK_SHEET_HISTORY,
        getUndoneReason: empBackTaskSheetTypes.GET_TASK_SHEET_UNDONE_REASON,
        getServiceAgreement: empBackTaskSheetTypes.GET_TASK_SHEET_SERVICE_AGREEMENT,
        getAfProductService: empBackTaskSheetTypes.GET_TASK_SHEET_AF_SERVICE_PRODUCT,
        getServiceProduct: empBackTaskSheetTypes.GET_TASK_SHEET_SERVICE_PRODUCT,
        getEmployeeInfo: empBackTaskSheetTypes.GET_TASK_SHEET_EMPLOYEE_INFO,
        backTaskSheetToAf: empBackTaskSheetTypes.BACK_TASK_SHEET_TO_AF,
        getCitySocialDetails: empBackTaskSheetTypes.GET_SOCIAL_SECURITY_DETAILS,
        getServiceProductByTaskSheetCity:empBackTaskSheetTypes.GET_SERVICE_PRODUCT_BY_TASK_SHEET_CITY,
      }),

      ...mapMutations('employeeBackTaskSheetModule', {
        mutateEntrustRetreatReason: empBackTaskSheetTypes.MUTATE_SUBMIT_ENTRUST_RETREAT_REASON
      }),


      backSearch () {
        this.$router.push({
          name: 'entrustSearch'
        })
        // this.$emit('entrustDetailBack');
      },

//      backToAf() {
//        this.backTaskSheetToAf().then(response => {
//          const responseData = response.data;
//          if (responseData.code === 0) {
//            this.$Message.info("任务单退回前道");
//            // this.getTaskSheetDetail(this.$route.params.id);
//            // this.getHistory();
//            this.backSearch();
//          } else {
//            throw(responseData.message);
//          }
//        }).catch(error => {
//          console.log(error)
//        }).finally(
//          this.submitting = false
//        )
//      },

      submit() {

        console.log("taskSheetSocialFeeInfo=====filter====="+this.taskSheetSocialFeeInfo.filter(function(item){ return item.zytSiId === ''; }).length);


        console.log("this.formForSubmit.serviceAgreementId====="+!this.formForSubmit.serviceAgreementId);

        console.log("this.formForSubmit.organizationAgreementProductRelationRequestDTOList.length====="+this.formForSubmit.organizationAgreementProductRelationRequestDTOList.length);
        //服务协议必须选择
        if(!this.formForSubmit.serviceAgreementId || this.formForSubmit.organizationAgreementProductRelationRequestDTOList.length == 0){
          this.$Modal.error({
            title: "<p><h3>错误</h3></p>",
            content: "<p><h3>服务协议必须选择！</h3></p>",
          });
          return;
        }


        this.submitTaskSheet().then(response => {
          const responseData = response.data
          if (responseData.code === 0) {
            this.$Message.info("提交了任务单");
            // this.getTaskSheetDetail(this.$route.params.id);
            // this.getHistory();
            this.backSearch();
          } else {
            throw(responseData.message);
          }
        }).catch(error => {
          console.log(error)
        })

      },

      initializeData() {
        const taskSheetId = this.$route.params.id;
        this.getTaskSheetDetail(taskSheetId).then(response => {
          this.getSocialFeeInfo(taskSheetId);
//          this.getSocialInfoList(taskSheetId);
          this.getCitySocialDetails("310000");
          this.getAfProductService(taskSheetId);
          this.getServiceProduct(taskSheetId);
          this.getServiceProductByTaskSheetCity();
          this.getEmployeeInfo(taskSheetId);
          //this.getOrgAgreement(this.cityId,this.companyId);
          this.getServiceAgreement(taskSheetId);
          this.getHistory();
          this.getUndoneReason(taskSheetId);
        });
      },

      showrejectEmployeeBackTaskSheetModal(){
        this.returnCustomerServiceModel = true;
      },

      closeReturnCustomerServiceModel(){
        this.returnCustomerServiceModel = false;
      },

      async returnCustomerService(){
        this.$refs.rejectEmployeeBackTaskSheetModalRef.validateInput();
        if (this.$refs.rejectEmployeeBackTaskSheetModalRef.validateConfrimResult) {
          this.returnCustomerServiceModel = false;
          this.mutateEntrustRetreatReason(this.$refs.rejectEmployeeBackTaskSheetModalRef.returnCustomerServiceItem.entrustRetreatReason);
          var title = '委托退单';
          this.backTaskSheetToAf().then(response => {
            if (response.data.code == 0) {
              this.$Notice.success({
                title: title,
                desc: title + '成功',
              });
              this.handleCurrentChange(1);
            } else if (response.data.code == 200) {
              this.$Notice.error({
                title: title,
                desc: response.data.message,
              });
            }else if (response.data.code == 300) {
              this.$Notice.error({
                title: title,
                desc: response.data.message,
              });
            }else if (response.data.code == 404) {
              this.$Notice.error({
                title: title,
                desc: title + "接口不存在",
              });
            }
          }).catch((error) => {
            this.$Notice.error({
              title: title,
              content: title + "错误"
            });
          });
        }
      },

    },

    computed: {
      ...mapGetters('employeeBackTaskSheetModule',[
        'isTaskSheetProcessed'
      ]),
      ...mapState('employeeBackTaskSheetModule', {
        //cityId: state => state.taskSheetDetail.executeCityId,
        //companyId: state => state.taskSheetDetail.companyId,
        taskSheetSocialFeeInfo: state => state.taskSheetSocialFeeInfo,
        formForSubmit: state => state.formForSubmit,
      })
    },

    created() {
      console.log(this.$route.params.id);
      this.initializeData();
    }

  }
</script>
