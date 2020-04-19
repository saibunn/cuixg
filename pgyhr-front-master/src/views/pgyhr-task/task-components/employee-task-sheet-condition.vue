

<template>
  <div class="smList">
    <Collapse v-model="collapseInfo">
      <Panel name="1">
        雇员任务单查询
        <div slot="content">
          <Form ref="searchCondition" :model="searchCondition" :label-width="150">
            <Row justify="start">
              <Col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="客户编号：" prop="companyId">
                  <Input v-model="searchCondition.companyId" placeholder="请输入客户编号"/>
                </Form-item>
              </Col>
              <Col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="客户名称：" prop="title">
                  <Input v-model="searchCondition.title" placeholder="请输入客户名称"/>
                </Form-item>
              </Col>
              <Col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="雇员姓名：" prop="empName">
                  <Input v-model="searchCondition.empName" placeholder="请输入雇员姓名"/>
                </Form-item>
              </Col>
              <Col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="雇员编号：" prop="employeeId">
                  <Input v-model="searchCondition.employeeId" placeholder="请输入雇员编号"/>
                </Form-item>
              </Col>
              <Col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="证件号：" prop="idNum">
                  <Input v-model="searchCondition.idNum" placeholder="请输入证件号"/>
                </Form-item>
              </Col>
              <Col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="雇员类型：" prop="templateType">
                  <Select v-model="searchCondition.templateType" filterable>
                    <Option v-for="(value,key) in this.baseDic.templateTypes" :value="key" :key="key">{{ value }}</Option>
                  </Select>
                </Form-item>
              </Col>
              <Col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="状态：" prop="status">
                  <Select v-model="searchCondition.status" filterable>
                    <Option v-for="item in statusOptions" :value="item.id" :key="item.id">{{ item.name }}</Option>
                  </Select>
                </Form-item>
              </Col>
              <Col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="入职时间：" prop="inDateStart">
                  <DatePicker type="date" transfer v-model="searchCondition.inDateStart" placeholder="入职开始时间"
                              style="width: 44%;"></DatePicker>
                  至
                  <DatePicker type="date" transfer v-model="searchCondition.inDateEnd" placeholder="入职结束时间"
                              style="width: 44%;"></DatePicker>
                </Form-item>
              </Col>

              <Col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="离职时间：" prop="outDateStart">
                  <DatePicker type="date" transfer v-model="searchCondition.outDateStart" placeholder="离职开始时间"
                              style="width: 44%;"></DatePicker>
                  至
                  <DatePicker type="date" transfer v-model="searchCondition.outDateEnd" placeholder="离职结束时间"
                              style="width: 44%;"></DatePicker>
                </Form-item>
              </Col>

              <Col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="社保缴纳地：" prop="socialCityCode">
                  <Select v-model="searchCondition.socialCityCode" multiple  filterable style="width:260px">
                    <Option v-for="item in areaAllData" :value="item.areaCode" :key="item.areaCode">{{ item.areaName }}</Option>
                  </Select>
                </Form-item>
              </Col>

              <Col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="公积金缴纳地：" prop="fundCityCode">
                  <Select v-model="searchCondition.fundCityCode" class="ml5" filterable>
                    <Option v-for="item in areaAllData" :value="item.areaCode" :key="item.areaCode">{{ item.areaName }}</Option>
                  </Select>
                </Form-item>
              </Col>

              <Col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}" v-show="showStyle.createdTime.isShow">
                <Form-item :label="showStyle.createdTime.title" prop="createdTime">
                  <DatePicker type="date" transfer v-model="searchCondition.createdTimeStart" :placeholder="showStyle.createdTime.placeholder + '开始时间'"
                              style="width: 44%;"></DatePicker>
                  至
                  <DatePicker type="date" transfer v-model="searchCondition.createdTimeEnd" :placeholder="showStyle.createdTime.placeholder + '结束时间'"
                              style="width: 44%;"></DatePicker>
                </Form-item>
              </Col>

              <Col :sm="{span:22}" :md="{span: 12}" :lg="{span: 8}" v-show="showStyle.modifiedTime.isShow">
                <Form-item :label="showStyle.modifiedTime.title" prop="modifiedTime">
                  <DatePicker type="date" transfer v-model="searchCondition.modifiedTimeStart" :placeholder="showStyle.modifiedTime.placeholder + '开始时间'"
                              style="width: 44%;"></DatePicker>
                  至
                  <DatePicker type="date" transfer v-model="searchCondition.modifiedTimeEnd" :placeholder="showStyle.modifiedTime.placeholder + '结束时间'"
                              style="width: 44%;"></DatePicker>
                </Form-item>
              </Col>

              <Col :sm="{span:22}" :md="{span: 22}" :lg="{span: 22}" align="right" style="margin-left: 100px" class="br">
                <Button type="primary" icon="ios-search" @click="search()">查询</Button>
                <Button type="warning" icon="ios-refresh" @click="reset('searchCondition')" class="ml10">重置</Button>
              </Col>

            </Row>

          </Form>

        </div>
      </Panel>
    </Collapse>
  </div>
</template>


<script>
  import {mapState, mapGetters, mapActions} from 'vuex';
  export default {
    components: {},
    name: 'employeeTaskSheetCondition',
    props: {
      conditionForm: {
        type: Object
      }
    },
    data () {
      return {
        collapseInfo: [1],
        companyId: '',
        cityData: [],
        searchCondition: {
          companyId: '',
          socialCityCode: '',
          fundCityCode: '',
          title: '',
          empName: '',
          employeeId: '',
          idNum: '',
          templateType: '',
          status: '',
          inDateStart: '',
          inDateEnd: '',
          outDateStart: '',
          outDateEnd: '',
          defStatus: [],
          createdTimeStart : '',
          createdTimeEnd : '',
          modifiedTimeStart : '',
          modifiedTimeEnd : ''
        },
        myCompanyList: [],
        isFristSearch: true,
        statusOptions: [
          {id: 0, name: '预录用'},
          {id: 1, name: '雇员信息确认中'},
          {id: 2, name: '在职'},
          {id: 3, name: '离职'}
        ],
        showStyle : {
          createdTime:{
            isShow : false,
            title : '创建时间：',
            placeholder:'创建'
          },
          modifiedTime:{
            isShow : false,
            title : '修改时间：',
            placeholder:'修改'
          }
        }
      }
    },

    computed: {
      ...mapState('areaModule', {
        areaAllData: state => state.areaAllData
      }),

    },

    methods: {
      reset (name) {
        let self = this
        self.$refs[name].resetFields();
        self.searchCondition.inDateEnd = ''
        self.searchCondition.outDateEnd = ''
      },
      getMyCompany (token) {
        let self = this
        this.axios.get(this.$store.SITE_PORT + '/afCompanyCenter/company/getAccessCompany/' + encodeURIComponent(token))
                .then(function (response) {
                  if (response.data) {
                    self.myCompanyList = response.data
                  }
                })
                .catch(function (error) {
                  self.$Notice.error({title: '系统提示', desc: error})
                })
      },
      formatConditionForm () {
        let self = this
        if (this.conditionForm) {
          if (this.conditionForm.status) {
            let newStatusOptions = []
            this.conditionForm.status.forEach(function (parentItem) {
              self.statusOptions.forEach(function (statusItem) {
                if (statusItem.id === parentItem) {
                  newStatusOptions.push(statusItem)
                }
              })
            })

            if (self.conditionForm.statusAutoSelected) {
              self.searchCondition.defStatus = self.conditionForm.status.join(',')
            }
            self.statusOptions = newStatusOptions
          }
        }
      },
      search () {
        this.$storage.setItem('searchCondition_companyId', this.searchCondition.companyId)
        this.$storage.setItem('searchCondition_empName', this.searchCondition.empName)
        this.$storage.setItem('searchCondition_employeeId', this.searchCondition.employeeId)
        this.$storage.setItem('searchCondition_idNum', this.searchCondition.idNum)
        this.$storage.setItem('searchCondition_title', this.searchCondition.title)
        this.$emit('getSearchCondition', this.searchCondition)
      },
      selectCity () {
        let self = this
        this.axios.get(this.$store.SITE_PORT + '/afCompanyCenter/commons/getCityList/').then(
                function (response) {
                  self.cityData = response.data
                })
      },
      setStyle(){
        let style = {
          EmployeeInIndex : {
            createdTime:{
              isShow : true,
              title : '预录用时间：',
              placeholder:'预录用'
            }
          },
          EmployeeChangeIndex : {
            createdTime:{
              isShow : true,
              title : '录入时间：',
              placeholder:'录入'
            }
          },
          EmployeeMoveIndex : {
            modifiedTime:{
              isShow : true,
              title : '翻牌操作时间：',
              placeholder:'翻牌操作'
            }
          },
          EmpInOutList : {
            createdTime:{
              isShow : true,
              title : '录入时间：',
              placeholder:'录入'
            },
            modifiedTime:{
              isShow : true,
              title : '离职操作时间：',
              placeholder:'离职操作'
            }
          },
          EmployeeOutIndex : {
            createdTime:{
              isShow : true,
              title : '录入时间：',
              placeholder:'录入'
            }
          }
        }
        let pageName = this.$parent.$options.name
        let pageStyle = style[pageName]
        if(pageStyle){
          Object.assign(this.showStyle,pageStyle)
        }
      }
    },
    mounted () {
      // this.formatConditionForm()
      // this.searchCondition.companyId = this.$storage.getItem('searchCondition_companyId')
      // this.searchCondition.empName = this.$storage.getItem('searchCondition_empName')
      // this.searchCondition.employeeId = this.$storage.getItem('searchCondition_employeeId')
      // this.searchCondition.idNum = this.$storage.getItem('searchCondition_idNum')
      // this.searchCondition.title = this.$storage.getItem('searchCondition_title')
      // this.getMyCompany()
      // this.selectCity()
      // this.setStyle()
    }
  }
</script>


