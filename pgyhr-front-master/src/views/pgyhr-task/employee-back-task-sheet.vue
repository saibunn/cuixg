<style scoped>
  .ivu-form-item-batch {
    margin-bottom: 24px;
    vertical-align: top;
    height: 18px;
    zoom: 1;
  }
</style>

<template>

  <div>
      <div class="form" v-show="!showDetail">
        <Collapse v-model="entrustSearch">
          <Panel name="1">
            检索条件
            <div class="form" slot="content" style="height: 260px">
            <employee-back-task-sheet-search-item></employee-back-task-sheet-search-item>
          </div>
          </Panel>

          <Panel name="2">
            检索结果
              <div class="form" slot="content">
            <Form  :label-width="100">
              <Row>
                <i-col :sm="{span:22}" :md="{span: 22}" :lg="{span: 22}" align="right" style="margin-left: 100px">
                  <Button type="info"  @click="exportData()"><Icon type="ios-download-outline"></Icon> 导出</Button>
                </i-col>
              </Row>

              <Row style="margin-top: 10px">
                <i-col span="4">
                  <Table border :columns="backTaskSheetColumns" :data="backTaskSheetList" width="1300" @on-row-dblclick="show()"   ref="backTaskSheetTable"></Table>
                </i-col>
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
            </Form>
          </div>
          </Panel>
        </Collapse>
      </div>
    <!-- <div v-show="showDetail">
        <entrust-detail v-on:entrustDetailBack="backSearch"></entrust-detail>
    </div> -->

  </div>

</template>


<script>
  /**
   * Created by cuixiaoguang on 2020/5/7
   */
  import { createNamespacedHelpers } from 'vuex';
  import employeeBackTaskSheetSearchItem from "./back-task-components/employee-back-task-sheet-search-item.vue";
  import empBackTaskSheetTypes from "../../store/event-types/pgyhr-task/emp_back_task_sheet_types.js";
  import employeeTaskSheetTypes from "../../store/event-types/pgyhr-task/employee_front_task_sheet_types";

  const { mapState, mapActions } = createNamespacedHelpers('employeeBackTaskSheetModule');

  export default {
    components: {
      employeeBackTaskSheetSearchItem
    },

    data() {
      return {
        entrustSearch: [1, 2],
        model1: 'solve',
        showDetail: false,
        formValidate: {
          name: '',
          date: ''
        },
        backTaskSheetColumns: [
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
                      this.show(params.row)
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
        getTaskSheetPageData: empBackTaskSheetTypes.SEARCH_TASK_SHEET_PAGE
      }),

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

      reload: function() {
        this.showDetail = false;
      },
      show(empBackTaskSheetInfo) {


        this.$store.commit("employeeBackTaskSheetModule/" + empBackTaskSheetTypes.MUTATE_SELECTED_EMPLOYEE_BACK_TASK_SHEET_INFO, empBackTaskSheetInfo);

        this.$router.push({
          name: "employee_back_task_sheet_detail",
        })
      },
      backSearch() {
        this.showDetail = false;
      },
      remove(index) {
        this.entrustDate.splice(index, 1);
      },
      changePageSize(size) {
        this.$store.commit("employeeBackTaskSheetModule/" + empBackTaskSheetTypes.MUTATE_PAGE_SIZE, size);
        this.getTaskSheetPageData();
      },
      changePage(page) {
        this.$store.commit("employeeBackTaskSheetModule/" + empBackTaskSheetTypes.MUTATE_CURRENT_PAGE, page);
        this.getTaskSheetPageData();
      },
    },
    computed: {
      ...mapState({
        backTaskSheetList: state => state.taskSheetList,
        totalRecords: state => state.pagination.total,
        pageSize: state => state.pagination.size,
        currentPage: state => state.pagination.currentPage,
        searchForm: state => state.searchForm
      }),
    },
    created() {
      let submitForm = {...this.form};
      submitForm.entrustCityId = '';
      submitForm.beEntrustCityId = '';
      submitForm.executeCityId = '';
      this.getTaskSheetPageData();
    }
  }

</script>
