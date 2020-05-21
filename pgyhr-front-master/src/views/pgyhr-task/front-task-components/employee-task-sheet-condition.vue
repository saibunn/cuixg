

<template>
  <div class="smList">
    <Collapse v-model="collapseInfo">
      <Panel name="1">
        雇员任务单查询
        <div slot="content">
          <Form ref="searchCondition" :model="searchCondition" :label-width="150">
            <Row justify="start">
              <Col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="客户编号：" prop="companyId">
                  <Input v-model="searchCondition.companyId" placeholder="请输入客户编号"/>
                </Form-item>
              </Col>
              <Col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="客户名称：" prop="companyName">
                  <Input v-model="searchCondition.companyName" placeholder="请输入客户名称"/>
                </Form-item>
              </Col>
              <Col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="雇员编号：" prop="employeeId">
                  <Input v-model="searchCondition.employeeId" placeholder="请输入雇员编号"/>
                </Form-item>
              </Col>
              <Col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="雇员姓名：" prop="employeeName">
                  <Input v-model="searchCondition.employeeName" placeholder="请输入雇员姓名"/>
                </Form-item>
              </Col>
              <Col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="任务单状态：" prop="taskStatus">
                  <Select v-model="searchCondition.taskStatus" filterable>
                    <Option v-for="item in taskStatusOptions" :value="item.id" :key="item.id">{{ item.name }}</Option>
                  </Select>
                </Form-item>
              </Col>
              <Col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="任务单类型" prop="taskType" >
                  <Select v-model="searchCondition.taskType" :clearable="true">
                    <Option v-for="item in taskTypeOptions" :value="item.id" :key="item.id">{{ item.name }}</Option>
                  </Select>
                </Form-item>
              </Col>
<!--              <Col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">-->
<!--                <Form-item label="入职时间：" prop="contractStartDate">-->
<!--                  <DatePicker type="date" transfer v-model="searchCondition.employmentDateStart" placeholder="入职开始时间"-->
<!--                              style="width: 44%;"></DatePicker>-->
<!--                  至-->
<!--                  <DatePicker type="date" transfer v-model="searchCondition.employmentDateEnd" placeholder="入职结束时间"-->
<!--                              style="width: 44%;"></DatePicker>-->
<!--                </Form-item>-->
<!--              </Col>-->

<!--              <Col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">-->
<!--                <Form-item label="离职时间：" prop="outDateStart">-->
<!--                  <DatePicker type="date" transfer v-model="searchCondition.outDateStart" placeholder="离职开始时间"-->
<!--                              style="width: 44%;"></DatePicker>-->
<!--                  至-->
<!--                  <DatePicker type="date" transfer v-model="searchCondition.outDateEnd" placeholder="离职结束时间"-->
<!--                              style="width: 44%;"></DatePicker>-->
<!--                </Form-item>-->
<!--              </Col>-->

              <Col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="社保缴纳地：" prop="socialCityCode">
                  <Select v-model="searchCondition.socialCityCode" multiple  filterable style="width:260px">
                    <Option v-for="item in areaAllData" :value="item.areaCode" :key="item.areaCode">{{ item.areaName }}</Option>
                  </Select>
                </Form-item>
              </Col>

              <Col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="公积金缴纳地：" prop="fundCityCode">
                  <Select v-model="searchCondition.fundCityCode" class="ml5" filterable>
                    <Option v-for="item in areaAllData" :value="item.areaCode" :key="item.areaCode">{{ item.areaName }}</Option>
                  </Select>
                </Form-item>
              </Col>

<!--              <Col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}" v-show="showStyle.createdTime.isShow">-->
<!--                <Form-item :label="showStyle.createdTime.title" prop="createdTime">-->
<!--                  <DatePicker type="date" transfer v-model="searchCondition.createdTimeStart" :placeholder="showStyle.createdTime.placeholder + '开始时间'"-->
<!--                              style="width: 44%;"></DatePicker>-->
<!--                  至-->
<!--                  <DatePicker type="date" transfer v-model="searchCondition.createdTimeEnd" :placeholder="showStyle.createdTime.placeholder + '结束时间'"-->
<!--                              style="width: 44%;"></DatePicker>-->
<!--                </Form-item>-->
<!--              </Col>-->

<!--              <Col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}" v-show="showStyle.modifiedTime.isShow">-->
<!--                <Form-item :label="showStyle.modifiedTime.title" prop="modifiedTime">-->
<!--                  <DatePicker type="date" transfer v-model="searchCondition.modifiedTimeStart" :placeholder="showStyle.modifiedTime.placeholder + '开始时间'"-->
<!--                              style="width: 44%;"></DatePicker>-->
<!--                  至-->
<!--                  <DatePicker type="date" transfer v-model="searchCondition.modifiedTimeEnd" :placeholder="showStyle.modifiedTime.placeholder + '结束时间'"-->
<!--                              style="width: 44%;"></DatePicker>-->
<!--                </Form-item>-->
<!--              </Col>-->

              <Col :sm="{span:22}" :md="{span: 22}" :lg="{span: 22}" align="right" style="margin-left: 100px" class="br">
                <Button type="primary" icon="ios-search" @click="search()">查询</Button>
                <Button type="warning" icon="ios-refresh" @click="reset('searchCondition')" class="ml10">重置</Button>
              </Col>

            </Row>

          </Form>

        </div>
      </Panel>
    </Collapse>
  </div>
</template>


<script>
  import {mapState, mapGetters, mapActions} from 'vuex';
  import employeeFrontTaskSheetTypes from "../../../store/event-types/pgyhr-task/employee_front_task_sheet_types";
  export default {
    components: {},
    name: 'employeeTaskSheetCondition',
    props: {
      conditionForm: {
        type: Object
      }
    },
    data () {
      return {
        collapseInfo: [1],
        companyId: '',
        cityData: [],
        searchCondition: {
          companyId: '',
          companyName:'',
          socialCityCode: '',
          fundCityCode: '',
          employeeName: '',
          employeeId: '',
          taskStatus: '',
          taskType:'',
          employmentDateStart: '',
          employmentDateEnd: '',
        },
        myCompanyList: [],
        isFristSearch: true,
        taskStatusOptions: [
          {id: 0, name: '后道批退'},
          {id: 1, name: '前道提交'},
          {id: 2, name: '后道处理'},
          {id: 3, name: '后道部分完成'},
          {id: 4, name: '后道完成'}
        ],
        taskTypeOptions: [
          {id: 0, name: '新增'},
          {id: 1, name: '调整'},
          {id: 2, name: '年度调整'},
          {id: 3, name: '终止'},
          {id: 4, name: '一次性费用'}
        ],
        showStyle : {
          createdTime:{
            isShow : false,
            title : '创建时间：',
            placeholder:'创建'
          },
          modifiedTime:{
            isShow : false,
            title : '修改时间：',
            placeholder:'修改'
          }
        }
      }
    },

    computed: {
      ...mapState('areaModule', {
        areaAllData: state => state.areaAllData
      }),

    },

    methods: {
      ...mapActions('employeeFrontTaskModule',{
        getEmployeeFrontTaskSheetPageData: employeeFrontTaskSheetTypes.SEARCH_EMPLOYEE_TASK_SHEET_PAGE,
      }),

      reset (name) {
        let self = this
        self.$refs[name].resetFields();
        self.searchCondition.employmentDateStart = '';
        self.searchCondition.employmentDateEnd = '';
      },
      search () {
        let submitForm = {...this.searchCondition};
        this.$store.commit("employeeFrontTaskModule/" + employeeFrontTaskSheetTypes.MUTATE_SEARCH_EMPLOYEE_TASK_SHEET_PARAM, submitForm);
        this.$store.commit("employeeFrontTaskModule/" + employeeFrontTaskSheetTypes.MUTATE_EMPLOYEE_TASK_SHEET_CURRENT_PAGE, 1);
        this.getEmployeeFrontTaskSheetPageData();
      },
    },
    mounted () {
      // this.formatConditionForm()
      // this.searchCondition.companyId = this.$storage.getItem('searchCondition_companyId')
      // this.searchCondition.empName = this.$storage.getItem('searchCondition_empName')
      // this.searchCondition.employeeId = this.$storage.getItem('searchCondition_employeeId')
      // this.searchCondition.idNum = this.$storage.getItem('searchCondition_idNum')
      // this.searchCondition.title = this.$storage.getItem('searchCondition_title')
      // this.getMyCompany()
      // this.selectCity()
    }
  }
</script>


