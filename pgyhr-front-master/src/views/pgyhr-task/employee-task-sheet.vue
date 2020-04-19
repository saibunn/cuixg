<style lang="less">
  @import "../../styles/table-common.less";
  @import "./employee-task.less";
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
        <Table border stripe :columns="employeeTaskColumns" :data="empTaskListData"  @on-row-dblclick="show()"   ref="empTaskTable"></Table>
        <Table :columns="exportColumns" :data="exportData" ref="exportTable" style="display:none"></Table>
      </Row>
      <Row type="flex" justify="end" class="page">
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
      </Row>
    </div>
  </div>

</template>


<script>
  /**
   * Created by cuixiaoguang on 2020/4/18
   */
  import { createNamespacedHelpers } from 'vuex';
  import employeeTaskSheetCondition from "./task-components/employee-task-sheet-condition.vue";
  import employeeTaskSheetTypes from "../../store/event-types/pgyhr-task/employee_task_sheet_types.js";
  import employeeTaskApi from "../../api/pgyhr-task/employee_task_api.js";
  //import {connect, disconnect,send} from '@/lib/agent_socket';

  const { mapState, mapActions } = createNamespacedHelpers('employeeTaskModule');

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
            title: '处理状态',
            key: 'taskStatusLabel',
            width: 100,
            sortable: true,
            fixed: 'left'
          },
          {
            title: '受托机构名称',
            width: 120,
            key: 'beEntrustOrganizationName'
          },
          {
            title: '执行城市',
            width: 100,
            key: 'executeCityName',
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
            title: '委托类型',
            width: 100,
            key: 'taskTypeLabel'
          },
          {
            title: '委托日期',
            width: 150,
            key: 'entrustDate',
            render:(h, params) => {
              if (params.row.entrustDate === undefined || params.row.entrustDate === null) {
                return;
              }
              const date = params.row.entrustDate;
              return h('div', this.$moment(date).format('YYYYMMDD'))
            }
          },
          {
            title: '委托操作员',
            width: 100,
            key: 'entrustUser'
          },
          {
            title: '受托批退日期',
            width: 150,
            key: 'trustReturnDate',
            render:(h, params) => {
              if (params.row.trustReturnDate === undefined || params.row.trustReturnDate === null) {
                return;
              }
              const date = params.row.trustReturnDate;
              return h('div', this.$moment(date).format('YYYYMMDD'))
            }
          },
          {
            title: '受托操作员',
            width: 100,
            key: 'beEntrustUser'
          },
          {
            title: '操作',
            key: 'action',
            width: 80,
            fixed: 'right',
            align: 'center',
            render: (h, params) => {
              return h('div', [
                h('Button', {
                  props: {
                    type: 'success',
                    size: 'small'
                  },
                  style: {
                    marginRight: '5px'
                  },
                  on: {
                    click: () => {
                      this.show(params.row.taskSheetId)
                    }
                  }
                }, '查看')
              ]);
            }
          }
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

      exportData() {
        let iframe = document.createElement('iframe');
        iframe.style.display = 'none';
        console.log(this.searchForm);
        iframe.src = EntrustApi.downloadEntrustTaskSheetList_URL + JSON.stringify(this.searchForm)+'?token='+encodeURIComponent(window.sessionStorage.getItem('user_token'));
        iframe.onload = function () {
          document.body.removeChild(iframe)
        }
        document.body.appendChild(iframe)
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
        this.$store.commit("employeeTaskModule/" + employeeTaskSheetTypes.MUTATE_EMPLOYEE_TASK_SHEET_PAGE_SIZE, size);
        this.getEmployeeTaskSheetPageData();
      },
      changePage(page) {
        this.$store.commit("employeeTaskModule/" + employeeTaskSheetTypes.MUTATE_EMPLOYEE_TASK_SHEET_CURRENT_PAGE, page);
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
