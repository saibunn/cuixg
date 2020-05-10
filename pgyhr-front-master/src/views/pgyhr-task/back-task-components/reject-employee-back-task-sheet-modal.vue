<style scoped>




</style>

<template>


  <div>
    <Form ref="returnCustomerServiceForm" :model="returnCustomerServiceItem" :label-width="120" :rules="ruleValidate">
      <Row>
        <i-col span="20">
          <Form-item label="后道退单原因" prop="retreatReason">
            <i-input v-model="returnCustomerServiceItem.retreatReason" type="textarea" :rows="4"></i-input>
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
          retreatReason:'',
        },

        ruleValidate: {
          retreatReason: [
            {
              required: true, message: '退单原因不能为空', trigger: 'blur'
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

