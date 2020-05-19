<style lang="less">
  @import "../../styles/table-common.less";
</style>

<template>
    
    <div class="search">
        <Card>
          <Form :model="companyItem"  inline :label-width="90">
              <Row>
<!--                <Form-item label="城市" prop="companyAreaId">-->
<!--                  <Cascader-->
<!--                        v-model="companyItem.companyCityCode"-->
<!--                        :data="areaData"-->
<!--                        not-found-text="无匹配数据"-->
<!--                        style="width: 250px"-->
<!--                        change-on-select-->
<!--                        @on-change="handleChangeDep"-->
<!--                  ></Cascader>-->
<!--                </Form-item>-->

                <Form-item label="公司名称" prop="companyName" class="ivu-form-item-batch">
                  <i-input v-model="companyItem.companyName" style="width: 250px"></i-input>
                </Form-item>
                <span v-if="drop">
                  <Form-item label="公司编号" prop="companyCode" >
                    <i-input v-model="companyItem.companyCode" style="width: 250px"></i-input>
                  </Form-item>

                  <Form-item label="签约销售" prop="signedSales" class="ivu-form-item-batch">
                    <i-input v-model="companyItem.signedSales" style="width: 250px"></i-input>
                  </Form-item>

                  <Form-item label="责任客服" prop="responsibilityService" class="ivu-form-item-batch">
                    <i-input v-model="companyItem.responsibilityService" style="width: 250px"></i-input>
                  </Form-item>

                  <Form-item label="使用状态" prop="isActive">
                    <Select v-model="companyItem.isActive"  :label-in-value="true" :clearable="true" style="width: 250px">
                      <Option v-for="item in useStateList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                    </Select>
                  </Form-item>
                </span>


                <Form-item style="margin-left:-35px;" class="br">
                  <i-button type="primary" @click="queryByPage" icon="ios-search">查询</i-button>
                  <i-button type="warning" @click="resetSearchItem">重置</i-button>
                  <a class="drop-down" @click="dropDown">
                    {{dropDownContent}}
                    <Icon :type="dropDownIcon"></Icon>
                  </a>
                </Form-item>
              </Row>
          </Form>


            <Row class="operation">
              <Button style="float:right" type="primary" @click="this.showAddCompanyModel" icon="md-add">新增客户</Button>
            </Row>

            <Row style="margin-top: 10px">
              <i-col span="24">
                <Table border :columns="companyColumns" :data="companyData"  ref="companyDataTable"></Table>
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
        </Card>
      </div>
</template>


<script>
  import addCompanyModel from "./company-components/addCompanyModel.vue";
  import {mapState, mapGetters, mapActions} from 'vuex';
  import companyTypes from "../../store/event-types/pgyhr-company/company-types.js";
  import expandRow from "../sys/user-manage/expand";
  export default {
    components: {addCompanyModel},
    name: 'Company',
    data () {
      return {
        addCompanyModelFlg: false,
        showDetail: false,
        drop: false,
        dropDownContent: "展开",
        dropDownIcon: "ios-arrow-down",

        companyItem: {
          // companyCityCode:"",
          companyCode:'',
          companyName:'',
          signedSales:'',
          responsibilityService:'',
          isActive:'',
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
            type: "selection",
            width: 60,
            align: "center",
            fixed: "left"
          },
          {
            title: '客户编号',
            key: 'companyCode',
            align: "center",
            width: 170,
          },
          {
            title: '公司名称',
            key: 'companyName',
            align: "center",
            width: 220,
          },
          /*{
            title: '城市',
            key: 'companyCityName',
            align: "center",
            width: 210,
              render: (h, params) => {
                  if (params.row.active == true) {
                      return h("div", [
                          h("Cascader", {
                              props: {
                                  status: "success",
                                  text: "正常"
                              }
                          })
                      ]);
                  }
              }
          },*/
          {
            title: '签约销售',
            key: 'signedSales',
            align: "center",
            width: 150,
          },
          {
            title: '责任客服',
            key: 'responsibilityService',
            align: "center",
            width: 150,
          },
          {
            title: '应收费用',
            key: '',
            align: "center",
            width: 150,
            // sortable: true,
            // sortType: "desc"
          },
          {
            title: '使用状态',
            key: 'active',
            align: "center",
            width: 150,
            render: (h, params) => {
              if (params.row.active == true) {
                return h("div", [
                  h("Badge", {
                    props: {
                      status: "success",
                      text: "正常"
                    }
                  })
                ]);
              } else if (params.row.active == false) {
                return h("div", [
                  h("Badge", {
                    props: {
                      status: "error",
                      text: "禁用"
                    }
                  })
                ]);
              }
            }
          },
          {
            title: '操作',
            key: 'action',
            align: 'center',
            width: 200,
            render: (h, params) => {
              return h('div', [
                h('Button', {
                  props: {
                    type: 'primary',
                    size: 'small'
                  },
                  style: {
                    marginRight: '5px'
                  },
                  on: {
                    click: () => {
                      this.$router.push({
                        name:"add-company-info",
                        query: {
                          data: this.companyData[params.index].companyCode
                        }
                      });
                    }
                  }
                }, '查看'),
                h('Button', {
                  props: {
                    type: 'error',
                    size: 'small'
                  },
                  style: {
                    marginRight: '5px',
                    marginLeft: '10px'
                  },
                  on: {
                    click: () => {

                      if(confirm('确定要删除吗')==true){
                        this.deleteCompany(this.companyData[params.index].companyCode);
                      }

                    }
                  }
                }, '删除'),
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
      ...mapActions('companyModule', [
              companyTypes.ADD_COMPANY,
              companyTypes.COMPANY_PAGE,
              companyTypes.DELETE_COMANY,
      ]),

      dropDown() {
        if (this.drop) {
          this.dropDownContent = "展开";
          this.dropDownIcon = "ios-arrow-down";
        } else {
          this.dropDownContent = "收起";
          this.dropDownIcon = "ios-arrow-up";
        }
        this.drop = !this.drop;
      },
      handleChangeDep(value, selectedData) {
        let companyCityCode = "";
        // 获取最后一个值
        if (value && value.length > 0) {
          companyCityCode = value[value.length - 1];
        }
        this.companyCityCode=companyCityCode;
        //console.log(selectedData[1].__label);
      },

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
        //this.addCompanyModelFlg = true;
        this.$router.push({name:"add-company-info"});
      },
  
  
  
      queryByPage(){

        this.handleCurrentChange(1);
      },
  
      resetSearchItem(){
        this.companyItem.companyCode = '';
        this.companyItem.companyName = '';
        this.companyItem.useStatus = '';
        this.companyItem.responsibilityService = '';
        this.companyItem.signedSales = '';
        this.isActive = '';
      },
  
      handleCurrentChange(val) {
        this.companyPage.currentPage = val;
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
        // submitForm.companyCityCode = submitForm.companyCityCode.length > 1 ? submitForm.companyCityCode[1] : submitForm.companyCityCode[0];
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
            this[companyTypes.ADD_COMPANY](params).then((response) => {
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

      deleteCompany(code){
        console.log(code);
        this[companyTypes.DELETE_COMANY]({compamyCode:code}).then((response)=>{
            console.log(response)
            if(response.code==200){
                this.$Message.success('删除成功');
                this.queryByPage();
            }
        }).catch((error) => {
            this.$Notice.error({
                title: title,
                content: title + "错误"
            });
        });
      }
      
    }
  }


</script>


