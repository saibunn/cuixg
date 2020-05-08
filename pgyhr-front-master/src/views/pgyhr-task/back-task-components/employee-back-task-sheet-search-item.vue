<style scoped>
  .ivu-form-item-batch {
    margin-bottom: 24px;
    vertical-align: top;
    height: 18px;
    zoom: 1;
  }
</style>

<template>

  <Form :model="entrustSearchFormItem" :label-width="100" ref="entrustSearchForm">
    <Row>
      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item prop="executeCityId" label="执行城市" class="ivu-form-item-batch">

          <Select v-model="entrustSearchFormItem.executeCityId" filterable>
            <Option v-for="item in areaAllData" :value="item.areaCode" :key="item.areaCode">{{ item.areaName }}</Option>
          </Select>

        </Form-item>
      </i-col>
      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="任务单状态" prop="taskStatus" class="ivu-form-item-batch">
          <Select v-model="entrustSearchFormItem.taskStatus" :clearable="true">
            <Option v-for="item in taskStatusOptions" :value="item.id" :key="item.id">{{ item.name }}</Option>
          </Select>
        </Form-item>
      </i-col>

      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="任务单类型" prop="taskType" class="ivu-form-item-batch">
          <Select v-model="entrustSearchFormItem.taskType" :clearable="true">
            <Option v-for="item in taskTypeOptions" :value="item.id" :key="item.id">{{ item.name }}</Option>
          </Select>
        </Form-item>
      </i-col>

      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="雇员编号" prop="employeeId" class="ivu-form-item-batch">
          <i-input v-model="entrustSearchFormItem.employeeId"></i-input>
        </Form-item>
      </i-col>
      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="雇员姓名" prop="employeeName" class="ivu-form-item-batch">
          <i-input v-model="entrustSearchFormItem.employeeName"></i-input>
        </Form-item>
      </i-col>

      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="公司名称" prop="companyName" class="ivu-form-item-batch">
          <i-input v-model="entrustSearchFormItem.companyName" ></i-input>
        </Form-item>
      </i-col>
      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="公司编号" prop="companyId" class="ivu-form-item-batch">
          <i-input v-model="entrustSearchFormItem.companyId"></i-input>
        </Form-item>
      </i-col>

      <i-col :sm="{span:22}" :md="{span: 22}" :lg="{span: 22}" align="right" style="margin-left: 100px">
        <i-button type="primary" @click="search" :loading="isSubmit">查询</i-button>
        <i-button type="warning" @click="handleReset('entrustSearchForm')" >重置</i-button>
      </i-col>

    </Row>

  </Form>

</template>

<script>
  import {mapState, mapGetters, mapActions} from 'vuex';
  //import { createNamespacedHelpers } from 'vuex';
  import empBackTaskSheetTypes from "../../../store/event-types/pgyhr-task/emp_back_task_sheet_types.js";
  //import {connect, disconnect,send} from '@/lib/agent_socket';

  //const { mapState, mapActions } = createNamespacedHelpers('employeeBackTaskSheetModule');
  //const { mapState,mapGetters,mapActions } = createNamespacedHelpers('cityModule');

  export default {
    components: {},
    name: 'employeeBackTaskSheetSearchItem',
    data () {
      return {
  
        cityList: [
          {
            value: 'New York',
            label: 'New York'
          },
          {
            value: 'London',
            label: 'London'
          },
          {
            value: 'Sydney',
            label: 'Sydney'
          },
          {
            value: 'Ottawa',
            label: 'Ottawa'
          },
          {
            value: 'Paris',
            label: 'Paris'
          },
          {
            value: 'Canberra',
            label: 'Canberra'
          }
        ],
        model10: [],
  
        entrustSearchFormItem: {
          executeCityId:'',
          taskStatus:'',
          taskType:'',
          employeeId:'',
          employeeName:'',
          companyName:'',
          companyId:'',
        },
  
        entrustTaskStatus: {
          statusVal: 0, // 0 无更新，1 新任务单
        },

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
  
        isSubmit:false,
      }

    },
  
    computed: {
      ...mapState('areaModule', {
        areaAllData: state => state.areaAllData
      }),
      ...mapState('employeeBackTaskSheetModule', {
        searchForm: state => state.searchForm
      }),
    },

    methods: {
      ...mapActions('employeeBackTaskSheetModule',{
        getTaskSheetPageData: empBackTaskSheetTypes.SEARCH_TASK_SHEET_PAGE,
      }),
      search() {
        let submitForm = {...this.entrustSearchFormItem};
        this.$store.commit("employeeBackTaskSheetModule/" + empBackTaskSheetTypes.MUTATE_SEARCH_FORM, submitForm);
        this.$store.commit("employeeBackTaskSheetModule/" + empBackTaskSheetTypes.MUTATE_CURRENT_PAGE, 1);
        this.getTaskSheetPageData();
      },

      handleReset(name) {
        this.$refs[name].resetFields();
      },

    },

    created() {
      //this.getProvinceList();
      this.form = this.searchForm;
      //this.initWebSocket();
    },
  
    watch: {
    }
  
    
  }


</script>
