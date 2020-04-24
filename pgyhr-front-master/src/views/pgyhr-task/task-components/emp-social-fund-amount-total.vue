<template>
  <div style="margin-top: 10px">
    <Card dis-hover>
      <Form :label-width="150">
        <Row>
          <Col :sm="{span: 20}" :md="{span: 12}" :lg="{span: 4}">
            <FormItem label="社保合计:" class="formItemMB">
              {{socialTotal}}
            </FormItem>
          </Col>
          <Col :sm="{span: 20}" :md="{span: 12}" :lg="{span: 4}">
            <FormItem label="公积金合计:" class="formItemMB">
               {{fundTotal}}
            </FormItem>
          </Col>
          <Col :sm="{span: 20}" :md="{span: 12}" :lg="{span: 4}">
            <FormItem label="人事外包合计:" class="formItemMB">
              {{productTotal}}
            </FormItem>
          </Col>
          <Col :sm="{span: 20}" :md="{span: 12}" :lg="{span: 4}">
            <FormItem label="健康管理合计:" class="formItemMB">
              {{healthTotal}}
            </FormItem>
          </Col>
          <Col :sm="{span: 20}" :md="{span: 12}" :lg="{span: 4}">
            <FormItem label="弹性福利合计:" class="formItemMB">
              {{welfareTotal}}
            </FormItem>
          </Col>
          <Col :sm="{span: 20}" :md="{span: 12}" :lg="{span: 4}">
            <FormItem label="套餐合计:" class="formItemMB">
              {{packageTotal}}
            </FormItem>
          </Col>
          <Col :sm="{span: 20}" :md="{span: 12}" :lg="{span: 4}">
            <FormItem label="增值税: " class="formItemMB">
              {{productTaxRate}}
            </FormItem>
          </Col>
          <Col :sm="{span: 20}" :md="{span: 12}" :lg="{span: 4}">
            <FormItem label="附加费:" class="formItemMB">
              {{productExtraRate}}
            </FormItem>
          </Col>
          <Col :sm="{span: 20}" :md="{span: 12}" :lg="{span: 4}">
            <FormItem label="合计:" class="formItemMB">
              {{allTotal}}
            </FormItem>
          </Col>
        </Row>
      </Form>
    </Card>
  </div>

</template>
<script>
  export default {
    computed: {

    },
    props: {
      amountTotal:{}
    },
    data () {
      return {
        socialTotal: 0,
        fundTotal: 0,
        healthTotal: 0,
        productTotal: 0,
        welfareTotal: 0,
        packageTotal: 0,
        productTaxRate : 0,
        productExtraRate : 0,
        allTotal: 0
      }
    },
    methods: {

    },
    watch: {
      'amountTotal' : function(total){
        if(total){
          this.socialTotal = total.socialTotal.toFixed(2)
          this.fundTotal =  total.fundTotal.toFixed(2)
          this.healthTotal =  total.healthTotal.toFixed(2)
          this.productTotal = total.productTotal.toFixed(2)
          this.welfareTotal = total.welfareTotal.toFixed(2)
          this.packageTotal = total.packageTotal.toFixed(2)
          this.productTaxRate = total.productTaxRate.toFixed(2)
          this.productExtraRate = total.productExtraRate.toFixed(2)
          this.allTotal =  total.allTotal.toFixed(2)
        }
      }
    }
  }
</script>
<style scoped>
  .formItemMB {
    margin-bottom: 5px!important;
  }
</style>
