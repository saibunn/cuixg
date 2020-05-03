<template>
      <Tabs :value="name" type="card" v-bind:style="tabStyle" >
        <Tab-pane label="社保详情" name="empTaskSheetSocialListInfo">
          <emp-task-sheet-social-list-info></emp-task-sheet-social-list-info>
        </Tab-pane>
      </Tabs>
</template>

<script>
  import empTaskSheetSocialListInfo from './emp-task-sheet-social-list-info.vue'
  import { mapActions, mapState } from 'vuex'
  import employeeTaskSheetTypes from "../../../store/event-types/pgyhr-task/employee_front_task_sheet_types.js";
  export default {
    components: {empTaskSheetSocialListInfo},
    name: 'empTaskSheetListInfo',
    props: {
      taskSheetId: {
        default: ''
      }
    },
    data () {
      return {
        name: 'empTaskSheetSocialListInfo',
        tabStyle: {
          height: '100%'
        }
      }
    },

    methods: {

    },

    computed: {

    },

    mounted () {

    },

    created () {

    }
  }

</script>
