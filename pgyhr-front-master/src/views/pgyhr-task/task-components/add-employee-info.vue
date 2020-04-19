<style lang="less">
    @import "../../../styles/table-common.less";
    @import "./add-employee-info.less";
</style>

<template>
  <div id="newEmployeeIn" class="search">
      <p>雇员基本信息</p>
      <Card>
          <Row>
            <Form ref="empInfo" :model="empInfo" :rules="empInfoRuleValidate" inline :label-width="150">
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="姓名：" prop="employeeName">
                  <Input v-model="empInfo.employeeName" type="text" placeholder="请输入"/>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="证件类型：" prop="idCardType">
                  <Select v-model="empInfo.idCardType" @on-change="resetEmpStatus">
                    <Option v-for="(value,key) in this.baseDic.idCardType" :value="key" :key="key">{{ value }}</Option>
                  </Select>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="证件号：" prop="idNum">
                  <Input type="text" v-model="empInfo.idNum" placeholder="请输入">
                  </Input>
                </Form-item>
                </Col>
                <span v-if="drop">
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="性别：" prop="gender">
                  <RadioGroup v-model="empInfo.gender">
                    <Radio v-for="(value,key) in this.baseDic.gender" :label="key" :key="key">{{ value }}</Radio>
                  </RadioGroup>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="出生年月：" prop="birthday">
                  <DatePicker transfer v-model="empInfo.birthday" type="date" placement="bottom" placeholder="选择日期" style="width: 100%;"></DatePicker>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="国籍：" prop="countryCode">
                  <Select v-model="empInfo.countryCode" :disabled="isCountryCode" filterable>
                    <Option v-for="item in countryData" :value="item.code" :key="item.code">{{ item.name }}</Option>
                  </Select>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="手机号：" prop="mobile">
                  <Input type="text" v-model="empInfo.mobile" placeholder="请输入"/>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="邮箱：" prop="email">
                  <Input type="text" v-model="empInfo.email" placeholder="请输入"/>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="联系地址：">
                  <Input type="text" v-model="empInfo.address" placeholder="请输入"/>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="户口性质：" prop="residentType">
                  <Select v-model="empInfo.residentType">
                    <Option v-for="(value,key) in this.baseDic.residentType" :value="key" :key="key">{{ value }}</Option>
                  </Select>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="婚姻状况：" prop="marriageStatus">
                  <RadioGroup v-model="empInfo.marriageStatus">
                    <Radio v-for="(value,key) in this.baseDic.marriageStatus" :label="key" :key="key">{{ value }}
                    </Radio>
                  </RadioGroup>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="紧急联系人：">
                  <Input type="text" v-model="empInfo.emergencyContactName" placeholder="请输入"/>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="紧急联系人电话：">
                  <Input type="text" v-model="empInfo.emergencyMobile" placeholder="请输入"/>
                </Form-item>
                </Col>
                </span>

                <Form-item style="margin-left:-35px;" class="br">
                    <a class="drop-down" @click="dropDown">
                        {{dropDownContent}}
                        <Icon :type="dropDownIcon"></Icon>
                    </a>
                </Form-item>

            </Form>
          </Row>
      </Card>
      <p>雇员入职信息</p>
       <Card >
          <Row>
            <Form ref="empCompanyInfo" :model="empCompanyInfo" :rules="empCompanyInfoRuleValidate" :label-width=150>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="入职日期：" prop="inDate">
                  <DatePicker transfer v-model="empCompanyInfo.inDate" type="date" placement="bottom" @on-change="changeInDate" placeholder="选择日期" style="width: 100%;"></DatePicker>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="用工形式：" prop="employStyle">
                  <Select v-model="empCompanyInfo.employStyle">
                    <Option v-for="(value, key) in this.baseDic.employStyle" :value="key" :key="key">{{ value}}</Option>
                  </Select>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="入职类型：" prop="postType">
                  <Select v-model="empCompanyInfo.postType" filterable>
                    <Option v-for="(value, key) in this.baseDic.postType" :value="key" :key="key">{{value}}</Option>
                  </Select>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="薪资：" prop="salary">
                  <Input type="text" v-model="empCompanyInfo.salary" @on-blur="salaryChange" placeholder="请输入"/>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="合同开始时间：" prop="laborStartDate">
                  <DatePicker transfer v-model="empCompanyInfo.laborStartDate" type="date" placement="bottom" placeholder="选择日期" style="width: 100%;"></DatePicker>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="合同结束时间：" prop="laborEndDate">
                  <DatePicker transfer v-model="empCompanyInfo.laborEndDate" :disabled="laborEndDateDisabled" type="date" placement="bottom" placeholder="选择日期" style="width: 70%;"></DatePicker>
                  <Checkbox v-model="isEndDate" @on-change="isEndDateChange">
                    无固定期限
                  </Checkbox>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="试用期工资：" prop="trySalary">
                  <Input type="text" v-model="empCompanyInfo.trySalary" placeholder="请输入"/>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="试用期开始时间：" prop="tryStartDate">
                  <DatePicker transfer v-model="empCompanyInfo.tryStartDate" type="date" placement="bottom" disabled placeholder="选择日期" style="width: 100%;"></DatePicker>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="试用期结束时间：" prop="tryEndDate">
                  <DatePicker transfer v-model="empCompanyInfo.tryEndDate" type="date" placement="bottom" placeholder="选择日期" style="width: 100%;"></DatePicker>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="工资支付方式：" prop="salaryPayType">
                  <Select v-model="empCompanyInfo.salaryPayType">
                    <Option v-for="(value,key) in this.baseDic.salaryPayType" :value="key" :key="key">{{ value }}</Option>
                  </Select>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="工时：" prop="workType">
                  <Select v-model="empCompanyInfo.workType">
                    <Option v-for="(value,key) in this.baseDic.workType" :value="key" :key="key">{{ value }}</Option>
                  </Select>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="劳动合同模板：" class="mb5">
                  <Select v-model="laborContractId">
                    <Option v-for="item in empLaborContract"
                            :value="item.id"
                            :key="item.id">{{ item.contractName }}</Option>
                  </Select>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="派遣期限(年)：" prop="dispatchingTerm">
                  <InputNumber v-model="empCompanyInfo.dispatchingTerm" :editable="false" :max="100" :min="0" :step="0.5" :disabled="dispatchingTermFlag"></InputNumber>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="员工工号：">
                  <Input type="text" v-model="empCompanyInfo.empCode" placeholder="请输入"/>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="工作地点：">
                  <Select v-model="empCompanyInfo.workCityCode" filterable>
                      <Option v-for="item in areaAllData" :value="item.areaCode" :key="item.areaCode">{{ item.areaName }}</Option>
                  </Select>
                </Form-item>
                </Col>
                <!--<Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                  <Form-item label="是否代办银行卡：">
                    <RadioGroup v-model="social_city_codeempCompanyInfo.isTransActBankCard">
                      <Radio v-for="(value,key) in this.baseDic.trueOrFalse" :label="key" :key="key" :disabled="isBank">{{ value }}</Radio>
                    </RadioGroup>
                  </Form-item>
                </Col>-->
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="职务：">
                  <Input type="text" v-model="empCompanyInfo.position" placeholder="请输入"/>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="部门：">
                  <Input type="text" v-model="empCompanyInfo.deptName" placeholder="请输入"/>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="合同签订方：">
                  <Select v-model="empCompanyInfo.laborSide">
                    <Option v-for="(value,key) in this.baseDic.laborSide" :value="key" :key="key">{{ value }}</Option>
                  </Select>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="需要雇员服务联系：">
                  <Checkbox v-model="empCompanyInfo.isNotice"/>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="是否需要银行卡信息：">
                  <RadioGroup v-model="empCompanyInfo.isNeedBankCard">
                    <Radio v-for="(value,key) in this.baseDic.trueOrFalse" :label="key" :key="key">{{ value }}</Radio>
                  </RadioGroup>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="银行卡种类：">
                  <Select v-model="empCompanyInfo.bankCode" :disabled="isSelectBank">
                    <Option v-for="item in bankCardList" :value="item.bankId+''" :key="item.bankId+''">{{ item.bankName }}</Option>
                  </Select>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 22}" :lg="{span: 24}">
                <Form-item label="备注：">
                  <Input type="text" v-model="empCompanyInfo.remark" placeholder="请输入"/>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 22}" :lg="{span: 24}">
                <Form-item label="工作内容：" prop="jobContent">
                  <Input type="text" v-model="empCompanyInfo.jobContent" placeholder="请输入"/>
                </Form-item>
                </Col>
            </Form>
          </Row>
        </Card>


    <div v-if="addConfNext===2">
      <div class="tc mt10">
        <Button type="warning" @click="addConfNext=1">上一步</Button>
        <Button type="success" @click="commitForm">提交</Button>
        <Button type="warning" @click="returnList">取消</Button>
      </div>
    </div>


    <Modal v-model="errModal" style="z-index: 999;">
      <p slot="header" style="color:#f60;text-align:center">
        <Icon type="information-circled"></Icon>
        <span>系统警告</span>
      </p>
      <div>
        <template v-for="(item,index) in errModalContext">
          <p>{{index+1}} : {{ item }}</p>
        </template>
      </div>
      <div slot="footer">
        <Button type="error" size="large" long @click="errModalClick">返回</Button>
      </div>
    </Modal>

    <Modal title="系统提示" v-model="peRulesModal" :closable="false" width="416">
      <p slot="header" style="color:#f60;text-align:center">
        <Icon type="information-circled"></Icon>
        <span>系统警告</span>
      </p>
      <div>
        <p style="color: red">由于该客户选择了体检产品，而尚未配置体检发放规则，故无法雇员新增，请预先配置雇员体检规则!</p>
      </div>
      <div slot="footer">
        <Button @click="closePeRulesModal">关闭</Button>
      </div>
    </Modal>
  </div>
</template>

<script>
  import IDValidator from 'id-validator'
  import {mapState, mapGetters, mapActions} from 'vuex';
  import Checkbox from '../../../../node_modules/iview/src/components/checkbox/checkbox.vue'

  export default {
    components: {
      Checkbox,
    },
    data: function () {
      return {
        drop: false,
        dropDownContent: "展开",
        dropDownIcon: "ios-arrow-down",
        addConfNext: 1, // addConfNext=1时可以下一步，addConfNext=2时可以提交
        tryDate: '',
        tabValue: '',
        socialConfigs: {
          hideColums: ['endDate', 'startConfirmDate', 'endConfirmDate'],
          readonly: true,
          companyId: ''
        },
        productConfigs: {
          hideColums: ['endDate','fristDate' ,'basicProductId','productTo']
        },
        empSocialFundConfigs:{
          companyId : ''
        },
        minSocialMonth: [],
        minProductMonth: [],
        addProductModal: false,
        companyProductDataList: [],

        empPackageDataList: [],
        packageDataList: [],

        personalOutsourcingData: [],
        healthManagementData: [],
        elasticWelfareData: [],

        adjustType:3,

        addProductConfigs: {
          hideColums: ['lastAmount', 'productTo', 'endDate'],
          operationType: 2,
          companyId: '',
          readonly: false
        },
        selectProductConfigs: {
          productHideColums: ['fristAmount', 'lastAmount'],
          showContent: 'product',
          readonly: false
        },
        priviewConfigs: {
          socialHideColums: ['startConfirmDate', 'endConfirmDate'],
          productHideColums: ['fristAmount', 'lastAmount', 'action_'],
          showContent: 'both',
          readonly: false,
          queryDetailParams: {}
        },
        sheetModal: false,
        sheetSelection: Object,
        sheetIsDisabled: true,
        sheetTitle: '',
        existsKeys: [],
        sheetData: [],
        errModal: false,
        errModalContext: [],
        isTax: '',
        rateTax: '',
        // 国籍是否必填
        isCountryCode: false,
        country: this.baseDic.country,

        // 是否需要银行卡信息
        isBank: true,
        isSelectBank: true,
        selectBankCardList:[],
        defaultBankCardList:[],
        bankCardList: [],
        // 雇员类型下拉数据
        templateTypeList: [],

        // 险种合一
        allEqualsBase: false,
        companyDefPayWay:'',
        // personalDefPayWay:'',
        cityList: [],
        socialCityName: '',
        fundCityName: '',
        isEndDate: '0',
        laborEndDateDisabled: false,
        // 终身雇员
        empInfo: {
          employeeId: '',
          employeeName: '',
          gender: '',
          birthday: '',
          idCardType: '1',
          idNum: '',
          countryCode: 'CN',
          marriageStatus: '',
          residentType: '',
          email: '',
          mobile: '',
          address: ''
        },
        // 雇员公司关系
        empCompanyInfo: {
          workCityCode: '',
          companyId: '',
          managementId: '',
          templateType: '',
          inDate: '',
          isNeedBankCard: '',
          bankCode: '',
          isNotice: true,
          salary: '',
          salaryPayType: '',
          tryStartDate: '',
          tryEndDate: '',
          trySalary: '',
          position: '',
          laborStartDate: '',
          laborEndDate: '',
          workType: '',
          postType: '1',
          employStyle: '1',
          hireUnit: '',
          socialUnit: '',
          fundUnit: '',
          socialCityCode: '',
          fundCityCode: '',
          remark: '',
          jobContent: '',
          dispatchingTerm: null
        },

        empAgreementInfo: {
          empAgreementId: '',
          templateType: '',
          employeeId: '',
          companyId: '',
          empCompanyId: '',
          startDate: '',
          fundSocialRuleId: '',
          socialRuleId: '',
          empBase: ''
        },

        empAgreementInfoRuleValidate: {
          companyId: [
            {
              required: true,
              message: '请选择所属客户',
              trigger: 'change'
            }
          ],
          templateType: [
            {
              required: true,
              message: '请选择雇员类型',
              trigger: 'change'
            }
          ],
          socialRuleId: [
            {
              type: 'integer',
              required: true,
              message: '请选择社保规则模板',
              trigger: 'change'
            }
          ],
          fundSocialRuleId: [
            {
              type: 'integer',
              required: true,
              message: '请选择公积金规则模板',
              trigger: 'change'
            }
          ]
        },
        empInfoRuleValidate: {
          employeeName: [
            {
              required: true,
              message: '请输入雇员姓名',
              trigger: 'blur'
            }
          ],
          gender: [
            {
              required: true,
              message: '请选择性别',
              trigger: 'change'
            }
          ],
          idCardType: [
            {
              required: true,
              message: '请选择证件类型',
              trigger: 'change'
            }
          ],
          idNum: [
            {
              type: 'string',
              required: true,
              message: '请输入证件号',
              trigger: 'blur'
            },
            {
              pattern: '^[A-Za-z0-9]+$',
              message: '证件号只允许字母与数字组成',
              trigger: 'blur'
            }
          ],
          mobile: [
            {
              type: 'string',
              required: true,
              message: '请输入手机号',
              trigger: 'blur'
            },
            {
              pattern: '^\\d{11}$',
              message: '请输入正确的手机号',
              trigger: 'blur'
            }
          ],
          email: [
            {
              type: 'email',
              message: '输入的邮箱地址不符合标准',
              trigger: 'blur'
            }
          ],
          birthday: [
            {
              type: 'date',
              required: true,
              message: '请选择出生年月',
              trigger: 'blur'
            }
          ],
          countryCode: [
            {
              required: true,
              message: '请选择国籍',
              trigger: 'change'
            }
          ]
        },
        empCompanyInfoRuleValidate: {
          trySalary: [
            {
              required: false,
              message: '请输入试用期薪资',
              trigger: 'blur'
            },
            {
              pattern: '^(([1-9]\\d*)|0)(\\.\\d{1,2})?$',
              message: '试用期工资只能以数字组成',
              trigger: 'blur'
            }
          ],
          tryStartDate: [
            {
              required: false,
              message: '请选择试用期开始时间',
            }
          ],
          tryEndDate: [
            {
              required: false,
              message: '请选择试用期结束时间',
            }
          ],
          salaryPayType: [
            {
              required: false,
              message: '请选择工资支付方式',
              trigger: 'change'
            }
          ],
          workType: [
            {
              required: false,
              message: '请选择工时',
              trigger: 'change'
            }
          ],
          dispatchingTerm: [
            {
              required: false,
              type: 'number',
              message: '请选择派遣期限',
              trigger: 'change'
            }
          ],
          jobContent: [
            {
              required: false,
              message: '请输入工作内容',
              trigger: 'blur'
            }
          ],
          salary: [
            {
              required: true,
              message: '请输入薪资',
              trigger: 'blur'
            },
            {
              pattern: '^(([1-9]\\d*)|0)(\\.\\d{1,2})?$',
              message: '薪资只能以数字组成',
              trigger: 'blur'
            }
          ],
          inDate: [
            {
              type: 'date',
              required: true,
              message: '请选择入职日期',
              trigger: 'change'
            }
          ],
          laborStartDate: [
            {
              type: 'date',
              required: true,
              message: '请选择合同开始时间',
              trigger: 'change'
            }
          ],
          laborEndDate: [
            {
              type: 'date',
              required: true,
              message: '请选择合同结束时间',
              trigger: 'change'
            }
          ],
          postType: [
            {
              required: true,
              message: '请选择入职类型',
              trigger: 'change'
            }
          ],
          employStyle: [
            {
              required: true,
              message: '请选择用工形式',
              trigger: 'change'
            }
          ]
        },
        // 社保规则
        socialRuleInfo: {
          id: '',
          template: '',
          name: ''
        },

        view: ['panel1', 'panel2', 'panel3'],
        empGroup: '',
        empGroupList: [],

        socialInfoColumns: [],

        socialInfoData: [],
        fundInfoData: [],
        totalSocialData: [],

        productDataColumns: [],
        productDataList: [],
        packageDataList: [],

        // 当前用户的客户
        myCompanyList: [],
        socialRuleTemplateGroup: [],
        socialRuleTemplateList: [],
        fundRuleTemplateGroup: [],
        fundRuleTemplateList: [],
        getEmpStatus: false,
        laborContractId: '',
        empLaborContract: [],
        dispatchingTermFlag: true,
        peRulesModal: false,
        peRulesFlag: true
      }
    },

    computed: {
      ...mapState('areaModule', {
          areaAllData: state => state.areaAllData
      }),

        ...mapState('countryModule', {
            countryData: state => state.countryData
        }),

    },
    methods: {
      errModalClick () {
      },

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
    },
    watch: {

    },
    created () {

    },
    mounted () {

    }
  }
</script>
