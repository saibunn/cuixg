<style scoped>




</style>

<template>
  <div>
    <Form ref="formAddCompany" :model="addCompanyItem" :label-width="100" :rules="ruleValidate">
      <Row>
        <i-col span="22">
          <Form-item label="城市" prop="companyCityArr" >
            <Cascader
              :value.sync="companyCityArr" @on-change="selectCityChange"
              :data="areaData"
              trigger="hover"
              not-found-text="无匹配数据"
            ></Cascader>
          </Form-item>
        </i-col>
      </Row>
      
      <Row>
        <i-col span="22">
          <Form-item label="外服公司名称" prop="companyName" >
            <i-input v-model="addCompanyItem.companyName" ></i-input>
          </Form-item>
        </i-col>
      </Row>
    </Form>
  </div>
</template>


<script>
  import {mapState, mapGetters, mapActions} from 'vuex';
  export default {
    data () {
  
      const validateCompanyCity = (rule, value, callback) => {
        if (this.addCompanyItem.companyCityId === '' && this.addCompanyItem.companyCityId.length === 0) {
          callback(new Error('城市不能为空'));
        } else {
          console.log(value);
          callback();
        }
      };
      return {
  
        validateResult:false,
        addCompanyItem:{
          companyCityId:'',
          companyCityName:'',
          companyName:'',
        },
  
        companyCityArr:[],
  
        ruleValidate: {
          companyCityArr: [
            { validator: validateCompanyCity }
          ],
          companyName: [
            {required: true, message: '机构名称不能为空', trigger: 'blur'}
          ],
        },
        

        
      }
    },
  
    mounted(){
    },
    created(){
    },
    computed: {
      ...mapState('areaModule', {
        areaData: state => state.areaData
      }),
    },
  
    methods: {
      selectCityChange(value, selectedData){
        
        this.addCompanyItem.companyCityId = value.length > 1 ? value[1] : value[0];
        
        this.addCompanyItem.companyCityName = selectedData.map(o => o.label)[selectedData.map(o => o.label).length-1];
        
      },
  
      validateInput(){
        this.$refs['formAddCompany'].validate((valid) => {
          this.validateResult = valid;
        })
      },
    
    }
    
  }
</script>
