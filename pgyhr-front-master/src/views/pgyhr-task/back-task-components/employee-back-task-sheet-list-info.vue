<template>
      <Tabs :value="name" type="card" v-bind:style="tabStyle" >
        <Tab-pane label="委托单详情" name="entrustTab">
          <employee-back-task-sheet-list-info-tab></employee-back-task-sheet-list-info-tab>
        </Tab-pane>
      </Tabs>
</template>

<script>
  import employeeBackTaskSheetListInfoTab from "./employee-back-task-sheet-list-info-tab";
  import { mapActions, mapState } from 'vuex';
  import empBackTaskSheetTypes from "../../../store/event-types/pgyhr-task/emp_back_task_sheet_types.js";

  // const { mapActions } = createNamespacedHelpers('employeeBackTaskSheetModule')
  export default {
    components: {employeeBackTaskSheetListInfoTab},
    name: 'employeeBackTaskSheetListInfo',
    props:{
      taskSheetId:{
        default:''
      }
    },
    data () {
      return {
        name: "entrustTab",
        tabStyle:  {
          height: '100%'
        },
      }
    },

    methods: {
      ...mapActions('employeeBackTaskSheetModule', {
        getSocialFeeInfo: empBackTaskSheetTypes.GET_TASK_SHEET_SOCIAL_FEE_INFO,
        getSocialInfoList: empBackTaskSheetTypes.GET_TASK_SHEET_SOCIAL_INFO_LIST,
        getHistory: empBackTaskSheetTypes.GET_TASK_SHEET_HISTORY,
        getUndoneReason: empBackTaskSheetTypes.GET_TASK_SHEET_UNDONE_REASON,
        getServiceAgreement: empBackTaskSheetTypes.GET_TASK_SHEET_SERVICE_AGREEMENT,
        getAfProductService: empBackTaskSheetTypes.GET_TASK_SHEET_AF_SERVICE_PRODUCT,
        getServiceProduct: empBackTaskSheetTypes.GET_TASK_SHEET_SERVICE_PRODUCT,
      }),

    },

    computed: {
      ...mapState('employeeBackTaskSheetModule', {
        cityId: state => state.taskSheetDetail.executeCityId
      })
    },

    mounted() {

    },

    created() {

    }
  }

</script>
