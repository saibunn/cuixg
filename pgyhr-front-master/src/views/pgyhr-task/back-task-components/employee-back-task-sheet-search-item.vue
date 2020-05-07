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
        <Form-item prop="entrustCityId" label="委托城市" class="ivu-form-item-batch">
          <Select v-model="entrustSearchFormItem.entrustCityIdArr" multiple  filterable style="width:260px">
            <Option v-for="item in cityAllData" :value="item.cityCode" :key="item.cityCode">{{ item.cityName }}</Option>
          </Select>
        </Form-item>
      </i-col>
      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item prop="beEntrustCityIdArr" label="受托城市" class="ivu-form-item-batch">
          <Select v-model="entrustSearchFormItem.beEntrustCityIdArr" multiple  filterable style="width:260px">
            <Option v-for="item in cityUserData" :value="item.cityCode" :key="item.cityCode">{{ item.cityName }}</Option>
          </Select>
        </Form-item>
      </i-col>
      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="任务单状态" prop="taskStatus" class="ivu-form-item-batch">
          <Select v-model="entrustSearchFormItem.taskStatus" :clearable="true">
            <Option v-for="item in taskStatusList" :value="item.value" :key="item.value">{{ item.label }}</Option>
          </Select>
        </Form-item>
      </i-col>

      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="任务单类型" prop="taskType" class="ivu-form-item-batch">
          <Select v-model="entrustSearchFormItem.taskType" :clearable="true">
            <Option v-for="item in taskSheetTypeList" :value="item.value" :key="item.value">{{ item.label }}</Option>
          </Select>
        </Form-item>
      </i-col>
      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="处理反馈日期" prop="beEntrustDate" class="ivu-form-item-batch">
          <Date-picker v-model="entrustSearchFormItem.beEntrustDate" type="date" :options="dateOptions" placeholder="选择日期" ></Date-picker>
        </Form-item>
      </i-col>
      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="委托确认日期" prop="entrustDate" class="ivu-form-item-batch">
          <Date-picker v-model="entrustSearchFormItem.entrustDate" type="date" :options="dateOptions" placeholder="选择日期" ></Date-picker>
        </Form-item>
      </i-col>

      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="受托机构序号" prop="beEntrustOrganizationId" class="ivu-form-item-batch">
          <i-input v-model="entrustSearchFormItem.beEntrustOrganizationId" ></i-input>
        </Form-item>
      </i-col>
      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="受托机构名称" prop="beEntrustOrganizationName" class="ivu-form-item-batch">
          <i-input v-model="entrustSearchFormItem.beEntrustOrganizationName"></i-input>
        </Form-item>
      </i-col>
      <!--<i-col span="4">-->
        <!--<Form-item label="委托雇员编号" prop="entrustEmployeesNo" class="ivu-form-item-batch">-->
          <!--<i-input v-model="entrustEmployeesNo"></i-input>-->
        <!--</Form-item>-->
      <!--</i-col>-->


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
      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="执行城市" prop="executeCityId" class="ivu-form-item-batch">
          <Select v-model="entrustSearchFormItem.executeCityIdArr" multiple  filterable style="width:260px">
            <Option v-for="item in cityUserData" :value="item.cityCode" :key="item.cityCode">{{ item.cityName }}</Option>
          </Select>
        </Form-item>
      </i-col>

      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="委托操作员" prop="entrustUser" class="ivu-form-item-batch">
          <i-input v-model="entrustSearchFormItem.entrustUser"></i-input>
        </Form-item>
      </i-col>

      <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
        <Form-item label="受托操作员" prop="beEntrustUser" class="ivu-form-item-batch">
          <i-input v-model="entrustSearchFormItem.beEntrustUser"></i-input>
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
  import ICol from "../../../../node_modules/iview/src/components/grid/col";
  //import { createNamespacedHelpers } from 'vuex';
  import EntrustTaskSheetTypes from "../../../store/event_types/entrust_task_sheet_types";
  import CommonApi from "../../../api/agent_dictionary_service/common_api";
  import EntrustSearchApi from "../../../api/entrust_service/entrust_search_api";
  import config from "../../../lib/config";
  import {connect, disconnect,send} from '@/lib/agent_socket';

  //const { mapState, mapActions } = createNamespacedHelpers('entrustTaskSheetModule');
  //const { mapState,mapGetters,mapActions } = createNamespacedHelpers('cityModule');

  export default {
    components: {ICol},
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
          entrustCityIdArr:[],
          beEntrustCityIdArr:[],
          entrustCityIds:'',
          beEntrustCityIds:'',
          taskStatus:'',
          taskType:'',
          beEntrustDate:null,
          entrustDate:null,
          beEntrustOrganizationId:'',
          beEntrustOrganizationName:'',
          employeeId:'',
          employeeName:'',
          companyName:'',
          companyId:'',
          executeCityIdArr:[],
          executeCityIds:'',
          entrustUser:'',
          beEntrustUser:'',
        },
  
        entrustTaskStatus: {
          statusVal: 0, // 0 无更新，1 新任务单
        },
  
        isSubmit:false,
        //entrustCityIdArr: [],
        beEntrustCityIdArr: [],
        taskStatusList: [],
        taskSheetTypeList: [],
        entrustConfirmTypeList: [],
        dateOptions: {
          shortcuts: [
            {
              text: '今天',
              value () {
                return new Date();
              }
            },
            {
              text: '昨天',
              value () {
                const date = new Date();
                date.setTime(date.getTime() - 3600 * 1000 * 24);
                return date;
              }
            },
            {
              text: '一周前',
              value () {
                const date = new Date();
                date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
                return date;
              }
            }
          ]
        },
      }

    },
  
    computed: {
      ...mapState('cityModule', {
        cityAllData: state => state.cityAllData,
        cityUserData: state => state.cityUserData
      }),
      ...mapState('entrustTaskSheetModule', {
        searchForm: state => state.searchForm
      }),
    },

    methods: {
      ...mapActions('entrustTaskSheetModule',{
        getTaskSheetPageData: EntrustTaskSheetTypes.SEARCH_TASK_SHEET_PAGE,
      }),
      search() {
        let submitForm = {...this.entrustSearchFormItem};
        if(submitForm.entrustCityIdArr.length > 0){
          submitForm.entrustCityIds = "'"+submitForm.entrustCityIdArr.join("','")+"'";
        }
        if(submitForm.beEntrustCityIdArr.length > 0){
          submitForm.beEntrustCityIds = "'"+submitForm.beEntrustCityIdArr.join("','")+"'";
        }
        if(submitForm.executeCityIdArr.length > 0){
          submitForm.executeCityIds = "'"+submitForm.executeCityIdArr.join("','")+"'";
        }
        this.$store.commit("entrustTaskSheetModule/" + EntrustTaskSheetTypes.MUTATE_SEARCH_FORM, submitForm);
        this.$store.commit("entrustTaskSheetModule/" + EntrustTaskSheetTypes.MUTATE_CURRENT_PAGE, 1);
        this.getTaskSheetPageData();
      },

      handleReset(name) {
        this.$refs[name].resetFields();
      },

      getTaskStatusList() {
        EntrustSearchApi.getTaskStatusEnums().then(response => {
          const responseData = response.data;
          if (responseData.code === 0) {
            this.taskStatusList = responseData.object;
          } else {
            throw(responseData.message);
          }
        }).catch(error => {
          console.log(error);
        })
      },

      getTaskTypeList() {
        EntrustSearchApi.getTaskTypeEnums().then(response => {
          const responseData = response.data;
          if (responseData.code === 0) {
            this.taskSheetTypeList = responseData.object;
          } else {
            throw(responseData.message);
          }
        }).catch(error => {
          console.log(error);
        })
      },

//      getProvinceList() {
//        const countryCode = "CN";
//        CommonApi.getProvinceList(countryCode)
//        .then(response => {
//          const responseData = response.data;
//          if (responseData.code === 0) {
//            this.cityData = [];
//            const list = responseData.object;
//            list.forEach(i => {
//              const cityArr=[];
//              const cityList = i.citys;
//              cityList.forEach(j => {
//                cityArr.push({
//                  value: j.cityCode,
//                  label: j.cityName,
//                })
//              });
//              this.cityData.push({
//                value: i.provinceCode,
//                label: i.provinceName,
//                children: cityArr
//              });
//
//
//
//            });
//            console.log("cityDatadgfdgfdgfd==="+JSON.stringify(this.cityData));
//          } else {
//            throw(responseData.message);
//          }
//        }).catch(error => {
//          console.log(error);
//        })
//      },
//
//      loadCity(item, callback) {
//        item.loading = true;
//        const provinceCode = item.value;
//        CommonApi.getCityList(provinceCode)
//        .then(response => {
//          const responseData = response.data;
//          if (responseData.code === 0) {
//            const list = responseData.object
//            list.forEach(i => {
//              item.children.push({
//                value: i.cityCode,
//                label: i.cityName,
//              })
//            })
//          } else {
//            throw(responseData.message);
//          }
//        }).catch(error => {
//          console.log(error);
//        }).finally(() => {
//          item.loading = false;
//          callback();
//        })
//      },

      // entrustCityChangeHandler(value, selectedData) {
      //   console.log(value);
      // }

      
      initWebSocket(){
        connect("/agentsite/getEntrustTask",this.entrustTaskStatus); //链接websocket服务端
      },
//      doCompute() {
//        console.log("订阅 Websocket");
//        send("/agentsite/getEntrustTask"); // 订阅 Websocket
//      }

    },

    created() {
      //this.getProvinceList();
      this.form = this.searchForm;
      this.getTaskStatusList();
      this.getTaskTypeList();
      this.initWebSocket();
    },
  
    watch: {
      'entrustTaskStatus.statusVal':function(val,oldVal) {
        let taskStatus = parseInt(val);
        if (taskStatus === 1) { //新任务单
          this.entrustTaskStatus.statusVal = 0;
          this.$Message.info('有新委托任务单!');
          this.search()
        }
      },
    }
  
    
  }


</script>
