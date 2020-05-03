<template>


  <Collapse v-model="employeeInfo">
    <Panel name="1">
      雇员基本信息
      <div class="form" slot="content">
        <employee-front-task-base-info></employee-front-task-base-info>
      </div>
    </Panel>
    <Panel name="2">
      任务单信息
        <div class="form" slot="content">
          <emp-task-sheet-list-info></emp-task-sheet-list-info>
        </div>
    </Panel>
    <Panel name="3">
      <div class="form" slot="content">
          <Row>
            <i-col span="24" align="right">
              <Button type="warning" style="width: 100px" @click="backSearch" >返回</Button>
            </i-col>
          </Row>
      </div>
    </Panel>
  </Collapse>


</template>

<script >
  // import { createNamespacedHelpers } from 'vuex';
  import {mapState, mapGetters, mapActions} from 'vuex';
  import employeeFrontTaskBaseInfo from "./front-task-components/employee-front-task-base-info.vue";
  import empTaskSheetListInfo from "./front-task-components/emp-task-sheet-list-info.vue";
  import employeeFrontTaskSheetTypes from "../../store/event-types/pgyhr-task/employee_front_task_sheet_types";

  export default {
    components: {employeeFrontTaskBaseInfo, empTaskSheetListInfo},
    name: 'employFrontTaskSheetDetail',
    data () {
      return {
        employeeInfo: [1, 2, 3],
        submitting: false,
        formItem: {
          date: '',
          time: ''
        }
      }
    },
    props: ['showDetail'],
    methods: {
      ...mapActions('employeeFrontTaskModule', {
        getEmpTaskSheetDetail: employeeFrontTaskSheetTypes.GET_EMPLOYEE_TASK_SHEET_DETAIL,
        getEmpTaskSheetSocialFeeSegment: employeeFrontTaskSheetTypes.GET_EMPLOYEE_TASK_SHEET_SOCIAL_FEE_SEGMENT,
        getEmpTaskSheetEmployeeInfo: employeeFrontTaskSheetTypes.GET_EMP_TASK_SHEET_EMPLOYEE_INFO,
      }),

      ...mapActions('employeeFrontTaskModule',{
        getEmployeeFrontTaskSheetPageData: employeeFrontTaskSheetTypes.SEARCH_EMPLOYEE_TASK_SHEET_PAGE,
      }),


      backSearch () {
        this.$router.push({
          name: 'employee-front-task-sheet'
        })
      },

      initializeData() {
        this.getEmpTaskSheetDetail();
      }
    },

    computed: {
      ...mapState({
        selectedEmpTaskInfo: state => state.selectedEmpTaskInfo,
      }),
    },

    created () {
      this.initializeData()
    }

  }
</script>
