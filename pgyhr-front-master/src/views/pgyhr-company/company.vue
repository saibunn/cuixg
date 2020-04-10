<style scoped>

  .form {
    width: 80%;
  }

  .pageSize{
    width: 100%;
    text-align: center;
    margin: 20px auto;
  }



</style>

<template>
    
    <div class="form" >
        <Form :model="companyItem" :label-width="100">
          
          <Row>

            <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
              <Form-item label="城市" prop="companyAreaId">
                <Cascader
                        :value.sync="companyItem.companyAreaId"
                        :data="areaData"
                        trigger="hover"
                        not-found-text="无匹配数据"
                ></Cascader>
              </Form-item>
            </i-col>

            <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
              <Form-item label="公司编号" prop="companyCode" >
                <i-input v-model="companyItem.companyCode"></i-input>
              </Form-item>
            </i-col>

            <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
              <Form-item label="公司名称" prop="companyName" class="ivu-form-item-batch">
                <i-input v-model="companyItem.companyName"></i-input>
              </Form-item>
            </i-col>

            <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
              <Form-item label="使用状态" prop="active">
                <Select v-model="companyItem.active"  :label-in-value="true" :clearable="true">
                  <Option v-for="item in useStateList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                </Select>
              </Form-item>
            </i-col>
  
            <i-col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}" >
              <i-button type="primary" style="margin-left: 50px" @click="queryByPage">查询</i-button>
              <i-button type="warning"  style="margin-left: 50px" @click="resetSearchItem">重置</i-button>
            </i-col>
          </Row>
          
        
          <Row>
            <i-col span="15" align="right">
              <Button type="primary" style="width: 80px" @click="this.showAddCompanyModel">新增</Button>
            </i-col>
          </Row>
          
          <Row style="margin-top: 10px">
            <i-col span="22">
              <Table border :columns="companyColumns" :data="companyData" width="800"   ref="companyDataTable"></Table>
            </i-col>
          </Row>
        
          <Row>
            <i-col span="14" align="center">
              <Page
                @on-change="this.handleCurrentChange"
                :current="companyPage.currentPage"
                :page-size="companyPage.size"
                :total="companyPage.total"
                show-total
                show-elevator>
              </Page>
            </i-col>
          </Row>
        </Form>
  
      <Modal
        v-model="addCompanyModelFlg"
        title="新增客户"
        width="600">
        <add-company-model ref="addCompanyModal"></add-company-model>
        <div slot="footer">
          <Row>
            <i-col span="24" >
              <i-button type="ghost"  @click="this.closeAddCompanyModel">关闭</i-button>
              <i-button type="primary" @click="this.addCompany" >保存</i-button>

            </i-col>
          </Row>
        </div>
      </Modal>
      </div>
</template>


<script>
  import addCompanyModel from "./company-components/addCompanyModel.vue";
  import {mapState, mapGetters, mapActions} from 'vuex';
  import companyTypes from "../../store/event-types/pgyhr-company/company-types.js";
  export default {
    components: {addCompanyModel},
    name: 'Company',
    data () {
      return {
        addCompanyModelFlg: false,
        showDetail: false,
  
        companyItem: {
          companyAreaId:[],
          companyCode:'',
          companyName:'',
          active:'',
          currentPage:'',
          size:'',
        },
        
        useStateList: [
          {
            value: 'true',
            label: '在用'
          },
          {
            value: 'false',
            label: '禁用'
          }
        ],
  
        companyColumns: [
          {
            title: '序号',
            key: 'companyId',
            width: 100,
          },
          {
            title: '城市',
            key: 'companyCityName',
            width: 100,
          },
          {
            title: '使用状态',
            key: 'active',
            render: (h, params) => {
              return params.row.active? "在用" : "禁用";
            }
          },
          {
            title: '公司名称',
            key: 'companyName',
          },
          {
            title: '操作',
            key: 'action',
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
                      this.$router.push({
                        name: 'companyDetail',
                        params: {
                          data: this.companyData[params.index]
                        }
                      });
                    }
                  }
                }, '详细'),
              ]);
            }
          }
        ],
      }
      
    },
  
    created(){
      this.queryByPage();
    },
  
    computed: {
  
      ...mapState('companyModule', {
        title: state => state.title,
        companyPage: state => state.companyPage,
        companyData: state => state.rows,
    
      }),

      ...mapState('areaModule', {
        areaData: state => state.areaData
      }),

    },
    
    methods: {
      ...mapActions('companyModule', [companyTypes.ADD_COMPANY,
        companyTypes.COMPANY_PAGE,
      ]),

      
      reload: function () {
        this.showDetail = false;
      },
  
      showCompany () {
        this.showDetail=true;
      },
  
      backSearch () {
        this.showDetail=false;
      },
  
      showAddCompanyModel(){
        this.addCompanyModelFlg = true;
      },
  
  
  
      queryByPage(){
        this.handleCurrentChange(1);
      },
  
      resetSearchItem(){
        this.companyItem.companyCode = null;
        this.companyItem.companyName = null;
        this.companyItem.useStatus = null;
      },
  
      handleCurrentChange(val) {
        this.companyPage.pageNum = val;
        this.finds();
      },
  
      // query
      finds(){
        this.companyItem.currentPage = this.companyPage.currentPage;
        this.companyItem.size = this.companyPage.size;

//
//        this.companyItem = this.companyItem.companyCityId.length > 1 ? this.companyItem.companyCityId[1] : this.companyItem.companyCityId[0];
       var params = this.companyItem;

        let submitForm = {...this.companyItem};
        submitForm.companyAreaId = submitForm.companyAreaId.length > 1 ? submitForm.companyAreaId[1] : submitForm.companyAreaId[0];

        console.log("params:================="+JSON.stringify(submitForm));
        
        this[companyTypes.COMPANY_PAGE](submitForm);
      },
  
  
      async addCompany(){
        this.$refs.addCompanyModal.validateInput();
        if (this.$refs.addCompanyModal.validateResult) {
            this.addCompanyModelFlg = false;
  
            var params = this.$refs.addCompanyModal.addCompanyItem;
            console.log("addCompanyItem:================="+JSON.stringify(this.$refs.addCompanyModal.addCompanyItem));
            var type = '新增';
            var title = this.title + type;
            this[CompanyType.ADD_COMPANY](params).then((response) => {
              if (response.data.code == 0) {
                this.$Notice.success({
                  title: title,
                  desc: title + '成功',
                });
                this.handleCurrentChange(1);
              } else {
                this.$Notice.error({
                  title: title,
                  content: title + "错误"
                });
              }
            }).catch((error) => {
              this.$Notice.error({
                title: title,
                content: title + "错误"
              });
            });
//
//        this.handleCurrentChange(1);
          }

    
      },

      closeAddCompanyModel(){
        this.addCompanyModelFlg = false;
      },
      
    }
  }


</script>


