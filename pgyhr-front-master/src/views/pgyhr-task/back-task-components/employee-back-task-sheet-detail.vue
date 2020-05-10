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
          <Row >
            <i-col span="24" align="right">
              <Button type="warning" style="width: 100px;margin-left: 20px" @click="backSearch" >返回</Button>
              <Button
                type="primary"
                v-if="this.getControlDisabled(3)"
                style="width: 100px;margin-left: 20px"
                :loading="submitting"
                @click="submit">提交</Button>
              <Button type="primary" v-if="this.getControlDisabled(12)" style="width: 100px;margin-left: 20px"
                @click="this.showrejectEmployeeBackTaskSheetModal" >退前道</Button>

              <Button type="primary" v-if="this.getControlDisabled(1)" style="width: 120px;margin-left: 20px"
                      @click="this.backServiceConfirm" >后道客服确认</Button>

              <Button type="primary" v-if="this.getControlDisabled(2)" style="width: 120px;margin-left: 20px"
                      @click="this.backCommissionerConfirm" >后道专员确认</Button>
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
              <i-button  @click="this.closeReturnCustomerServiceModel">关闭</i-button>
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
  import employeeFrontTaskSheetTypes from "../../../store/event-types/pgyhr-task/employee_front_task_sheet_types";

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
        getEmpBackTaskSheetDetail: empBackTaskSheetTypes.GET_EMPLOYEE_BACK_TASK_SHEET_DETAIL,
        submitTaskSheet: empBackTaskSheetTypes.SUBMIT_TASK_SHEET,
        rejecteTaskSheet: empBackTaskSheetTypes.BACK_TASK_SHEET_TO_FRONT,
        backServiceConfirmTaskSheet: empBackTaskSheetTypes.BACK_SERVICE_CONFIRM_BACK_TASK_SHEET,
        backCommissionerConfirmTaskSheet: empBackTaskSheetTypes.BACK_COMMISSIONER_CONFIRM_BACK_TASK_SHEET,
      }),

      ...mapMutations('employeeBackTaskSheetModule', {
        mutateEntrustRetreatReason: empBackTaskSheetTypes.MUTATE_SUBMIT_BACK_TASK_SHEET_RETREAT_REASON
      }),


      backSearch () {
        this.$router.push({
          name: 'employee-back-manage'
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

      //后道客服确认
      async backServiceConfirm(){

        var type = '后道客服确认';
        var title = "任务单" + type;
        this.backServiceConfirmTaskSheet().then((response) => {
          if (response.code == 200){
            this.$Notice.success({
              title: title,
              desc: title + '成功',
            });
            this.$router.push({
              name: "employee-back-manage"
            });

          }else{
            this.$Notice.error({
              title: title,
              content: response.message
            });
          }
        }).catch((error) => {
          this.$Notice.error({
            title: title,
            content: title + "错误"
          });
        });
      },

      //后道专员确认
      async backCommissionerConfirm(){
        var type = '后道专员确认';
        var title = "任务单" + type;
        this.backCommissionerConfirmTaskSheet().then((response) => {
          if (response.code == 200){
            this.$Notice.success({
              title: title,
              desc: title + '成功',
            });
            this.$router.push({
              name: "employee-back-manage"
            });

          }else{
            this.$Notice.error({
              title: title,
              content: response.message
            });
          }
        }).catch((error) => {
          this.$Notice.error({
            title: title,
            content: title + "错误"
          });
        });
      },

      async submit() {

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
        this.getEmpBackTaskSheetDetail();
      },

      getControlDisabled(modelType){
        var result = false;
        console.log("modelType=================="+this.selectedEmpBackTaskInfo.taskStatus);
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

      showrejectEmployeeBackTaskSheetModal(){
        this.returnCustomerServiceModel = true;
      },

      closeReturnCustomerServiceModel(){
        this.returnCustomerServiceModel = false;
      },

      async returnCustomerService() {
        this.$refs.rejectEmployeeBackTaskSheetModalRef.validateInput();
        if (this.$refs.rejectEmployeeBackTaskSheetModalRef.validateConfrimResult) {
          this.returnCustomerServiceModel = false;
          this.mutateEntrustRetreatReason(this.$refs.rejectEmployeeBackTaskSheetModalRef.returnCustomerServiceItem.retreatReason);
          var title = '后道退单';
          this.rejecteTaskSheet().then(response => {
            if (response.code == 200) {
              this.$Notice.success({
                title: title,
                desc: title + '成功',
              });
              this.$router.push({
                name: "employee-back-manage"
              });

            } else {
              this.$Notice.error({
                title: title,
                content: response.message
              });
            }
          }).catch((error) => {
            this.$Notice.error({
              title: title,
              content: title + "错误"
            });
          });
        }
      }
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
        selectedEmpBackTaskInfo :state=> state.selectedEmpBackTaskInfo,
      })
    },

    created() {
      this.initializeData();
    }

  }
</script>
