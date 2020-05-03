<style lang="less">
  @import "../../styles/table-common.less";
  @import "./employee-front-task-sheet.less";
</style>

<template>

  <div>
    <div class="search">
      <div slot="content" >
        <employee-task-sheet-condition></employee-task-sheet-condition>
      </div>

      <Row class="operation">
        <Button type="info"  @click="addEmployee()"><Icon type="ios-download-outline"></Icon> 雇员新增</Button>
        <Button type="info"  @click="exportData()"><Icon type="ios-download-outline"></Icon> 导出</Button>
      </Row>

      <Row>
        <Table border :columns="employeeTaskColumns" :data="empTaskListData" width="1300" @on-row-dblclick="show()"   ref="entrustTable"></Table>
      </Row>
      <Row>
        <i-col span="20">
          <Page
                  :total="totalRecords"
                  :current="currentPage"
                  :page-size ="pageSize"
                  :page-size-opts="[5, 10]"
                  show-sizer
                  show-total
                  @on-page-size-change="changePageSize"
                  @on-change="changePage"
                  class="pageSize"></Page>
        </i-col>
      </Row>
    </div>
  </div>

</template>


<script>
  /**
   * Created by cuixiaoguang on 2020/4/18
   */
  import { createNamespacedHelpers } from 'vuex';
  import employeeTaskSheetCondition from "./front-task-components/employee-task-sheet-condition.vue";
  import employeeTaskSheetTypes from "../../store/event-types/pgyhr-task/employee_front_task_sheet_types.js";
  import employeeTaskApi from "../../api/pgyhr-task/employee_front_task_api.js";
  import companyTypes from "../../store/event-types/pgyhr-company/company-types";
  //import {connect, disconnect,send} from '@/lib/agent_socket';

  const { mapState, mapActions } = createNamespacedHelpers('employeeFrontTaskModule');

  export default {
    components: {
      employeeTaskSheetCondition
    },

    data() {
      return {
        entrustSearch: [1, 2],
        model1: 'solve',
        showDetail: false,
        entrustCity: '',
        formValidate: {
          name: '',
          date: ''
        },
        employeeTaskColumns: [
          {
            type: 'index',
            width: 60,
            align: 'center',
            fixed: 'left'
          },
          {
            title: '雇员编号',
            width: 150,
            key: 'employeeId'
          },
          {
            title: '雇员姓名',
            width: 100,
            key: 'employeeName'
          },
          {
            title: '公司名称',
            width: 150,
            key: 'companyName'
          },
          {
            title: '公司编号',
            width: 120,
            key: 'companyId'
          },
        ],
      }
    },
    methods: {
      ...mapActions({
        getEmployeeTaskSheetPageData: employeeTaskSheetTypes.SEARCH_EMPLOYEE_TASK_SHEET_PAGE
      }),
      handleSubmit(name) {
        this.$Message.success('这是一条成功的提示');
      },
      handleReset(name) {
        this.$Message.warning('这是一条警告的提示');
      },

      handleCurrentChange(val) {
        this.empTaskPage.pageNum = val;
        //this.finds();
      },


      exportData() {
        // let iframe = document.createElement('iframe');
        // iframe.style.display = 'none';
        // console.log(this.searchForm);
        // iframe.src = EntrustApi.downloadEntrustTaskSheetList_URL + JSON.stringify(this.searchForm)+'?token='+encodeURIComponent(window.sessionStorage.getItem('user_token'));
        // iframe.onload = function () {
        //   document.body.removeChild(iframe)
        // }
        // document.body.appendChild(iframe)
      },

      addEmployee(){
        this.$router.push({
          name: "add_employee_info"
        });
      },

      reload: function() {
        this.showDetail = true;
      },
      show(id) {
        //双击跳转任务单明细 todo
        // this.showDetail = true;
        //disconnect(); // 关闭 Websocket
        // this.$router.push({
        //   name: "entrustDetail",
        //   params: {
        //     id:id
        //   }
        // })
      },
      backSearch() {
        this.showDetail = false;
      },
      remove(index) {
        this.empTaskListData.splice(index, 1);
      },
      changePageSize(size) {
        this.$store.commit("employeeFrontTaskModule/" + employeeTaskSheetTypes.MUTATE_EMPLOYEE_TASK_SHEET_PAGE_SIZE, size);
        this.getEmployeeTaskSheetPageData();
      },
      changePage(page) {
        this.$store.commit("employeeFrontTaskModule/" + employeeTaskSheetTypes.MUTATE_EMPLOYEE_TASK_SHEET_CURRENT_PAGE, page);
        //this.getEmployeeTaskSheetPageData();
      },
    },
    computed: {
      ...mapState({
        empTaskListData: state => state.empTaskList,
        totalRecords: state => state.empTaskPage.total,
        pageSize: state => state.empTaskPage.size,
        currentPage: state => state.empTaskPage.currentPage,
        searchForm: state => state.searchForm
      }),
    },
    created() {
      let submitForm = {...this.form};
      //this.getEmployeeTaskSheetPageData();
    }
  }

</script>
