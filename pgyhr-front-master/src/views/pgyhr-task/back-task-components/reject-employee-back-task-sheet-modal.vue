<style scoped>




</style>

<template>


  <div>
    <Form ref="returnCustomerServiceForm" :model="returnCustomerServiceItem" :label-width="100" :rules="ruleValidate">
      <Row>
        <i-col span="20">
          <Form-item label="委托退单原因" prop="entrustRetreatReason">
            <i-input v-model="returnCustomerServiceItem.entrustRetreatReason" type="textarea" :rows="4"></i-input>
          </Form-item>
        </i-col>
      </Row>
    </Form>
  </div>
</template>

<script>
  export default {
    name: 'rejectEmployeeBackTaskSheetModal',
    data () {
      return {
        validateConfrimResult:false,
        returnCustomerServiceItem:{
          entrustRetreatReason:'',
        },

        ruleValidate: {
          retreatExamineResult: [
            {
              required: true, message: '委托退单原因不能为空', trigger: 'blur'
            },
          ],
        },
      }
    },

    methods: {
      validateInput(){
        this.$refs['returnCustomerServiceForm'].validate((valid) => {
          this.validateConfrimResult = valid;
        })
      },
    }

  }
</script>

