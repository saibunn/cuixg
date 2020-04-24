<style lang="less">
    @import "../../../styles/table-common.less";
    @import "./add-employee-info.less";
</style>

<template>
  <div id="newEmployeeIn" class="search">
      <p>雇员入职信息</p>
       <Card >
          <Row>
            <Form ref="empCompanyInfo" :model="empCompanyInfo" :rules="empCompanyInfoRuleValidate" :label-width=150>

                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                    <Form-item label="客户：" class="mb5" prop="companyId">
                        <Select v-model="empCompanyInfo.companyId" filterable @on-change="companySelected">
                            <Option v-for="item in myCompanyList" :value="item.companyId" :key="item.companyId">{{ item.title }}</Option>
                        </Select>
                    </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                    <Form-item label="雇员类型：" prop="templateType">
                        <Select v-model="empCompanyInfo.templateType" @on-change="templateTypeChange">
                            <Option v-for="(value, key) in this.baseDic.templateTypes" :value="key" :key="key">{{ value}}</Option>
                        </Select>

                    </Form-item>
                </Col>
<!--                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">-->
<!--                    <Form-item label="社保规则模板：" class="mb5" prop="socialRuleId">-->
<!--                        <Select v-model="empAgreementInfo.socialRuleId" filterable @on-change="socialRuleSelected">-->
<!--                            <OptionGroup v-for="groupItem in socialRuleTemplateGroup" :label="groupItem.cityName" :key="groupItem.cityCode">-->
<!--                                <Option v-for="item in groupItem.dataList"-->
<!--                                        :value="item.id"-->
<!--                                        :key="item.id">{{ item.name }}</Option>-->
<!--                            </OptionGroup>-->
<!--                        </Select>-->
<!--                    </Form-item>-->
<!--                </Col>-->
<!--                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">-->
<!--                    <Form-item label="公积金规则模板：" class="mb5" prop="fundSocialRuleId">-->
<!--                        <Select v-model="empAgreementInfo.fundSocialRuleId" filterable @on-change="fundRuleSelected">-->
<!--                            <OptionGroup v-for="groupItem in fundRuleTemplateGroup" :label="groupItem.cityName" :key="groupItem.cityCode">-->
<!--                                <Option v-for="item in groupItem.dataList"-->
<!--                                        :value="item.id"-->
<!--                                        :key="item.id">{{ item.name }}</Option>-->
<!--                            </OptionGroup>-->
<!--                        </Select>-->
<!--                    </Form-item>-->
<!--                </Col>-->
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                    <Form-item label="社保缴纳地：">
                        <span> {{ socialCityName }}</span>
                    </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                    <Form-item label="公积金缴纳地：">
                        <span> {{ fundCityName }}</span>
                    </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                    <Form-item label="社保办理方：">
                        {{ this.baseDic.unitMap[empCompanyInfo.socialUnit] }}
                    </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                    <Form-item label="公积金办理方：">
                        {{ this.baseDic.unitMap[empCompanyInfo.fundUnit] }}
                    </Form-item>
                </Col>

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
<!--                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">-->
<!--                <Form-item label="试用期工资：" prop="trySalary">-->
<!--                  <Input type="text" v-model="empCompanyInfo.trySalary" placeholder="请输入"/>-->
<!--                </Form-item>-->
<!--                </Col>-->
<!--                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">-->
<!--                <Form-item label="试用期开始时间：" prop="tryStartDate">-->
<!--                  <DatePicker transfer v-model="empCompanyInfo.tryStartDate" type="date" placement="bottom" disabled placeholder="选择日期" style="width: 100%;"></DatePicker>-->
<!--                </Form-item>-->
<!--                </Col>-->
<!--                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">-->
<!--                <Form-item label="试用期结束时间：" prop="tryEndDate">-->
<!--                  <DatePicker transfer v-model="empCompanyInfo.tryEndDate" type="date" placement="bottom" placeholder="选择日期" style="width: 100%;"></DatePicker>-->
<!--                </Form-item>-->
<!--                </Col>-->
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
           <Row>
               <emp-product-group-list class="mt10" ref="empProductList" :configs="{
                                productHideColums: ['fristAmount', 'lastAmount'],
                                showContent: 'product',
                                tabValue: tabValue,
                                edit:'edit',
                                readonly: false,
                                companyId: empAgreementInfo.companyId,
                                'totalSocialData':totalSocialData,
                                'salary' : empCompanyInfo.salary,
                                'allEqualsBase':allEqualsBase,
                                'socialStartDate' : empCompanyInfo.inDate,
                                'socialUnit':empCompanyInfo.socialUnit,
                                'fundUnit' : empCompanyInfo.fundUnit,
                                'socialConfigs' : socialConfigs,
                                'socialRuleId':empAgreementInfo.socialRuleId,
                                'fundRuleId' : empAgreementInfo.fundSocialRuleId
                      }">
               </emp-product-group-list>
           </Row>

        </Card>


      <Row class="operation">
          <Button type="success" @click="commitForm">提交</Button>
          <Button type="warning" @click="returnList">取消</Button>
      </Row>


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
  import empProductGroupList from './emp-product-group-list'

  export default {
    components: {
        empProductGroupList,
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
        socialCityName: '常州',
        fundCityName: '常州',
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
          employeeEmail: '',
          employeeMobile: '',
          employeeAddress: ''
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
          socialCityCode: '320400',
          fundCityCode: '320400',
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
        empInfoRuleValidate: {
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
            ],
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
          employeeMobile: [
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
          employeeEmail: [
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

        async commitForm () {

        },

        returnList () {
            //this.$router.go(-1)
        },

        async companySelected (selectValue) {
            this.empCompanyInfo.companyId = selectValue;
            this.empAgreementInfo.companyId = selectValue;
            this.empSocialFundConfigs.companyId = selectValue;
            this.socialConfigs.companyId = selectValue;
        },


        // 雇员类型下拉变化时,更新雇员组的数据
        async templateTypeChange (selectValue) {
            this.empCompanyInfo.templateType = selectValue;
        },

        //雇员入职时间改变
        changeInDate (selectDate) {
            if (selectDate) {
                this.empCompanyInfo.laborStartDate = selectDate;
                this.empCompanyInfo.tryStartDate = selectDate;
                let checkStartDate = this.$dateUtils.checkNextMonth(new Date(selectDate), 'start')
                this.empAgreementInfo.startDate = checkStartDate
                this.getSocialItemData(0, this.empAgreementInfo.socialRuleId, this.empAgreementInfo.fundSocialRuleId)
            }
        },

        async getSocialItemData (type, socialRuleId, fundSocialRuleId) {
            let paramJSON = {
                type: type,
                socialRuleId: socialRuleId,
                fundRuleId: fundSocialRuleId,
                empSocial: this.buildSocialParamData(type)
            }
            let matchSocialData = await this.$refs.empProductComponent.getSocialItemData(paramJSON)
            let self = this
            let tempSocialData = []
            self.totalSocialData.forEach(function (item) {
                if (type === 1 && item.policyType === 2) {
                    tempSocialData.push(item)
                } else if (type === 2 && item.policyType === 1) {
                    tempSocialData.push(item)
                }
            })

            if (matchSocialData) {
                let startDate = this.$dateUtils.checkNextMonth(new Date(this.empCompanyInfo.inDate), 'start')
                self.allEqualsBase = matchSocialData.combined
                matchSocialData.list.forEach(function (item) {
                    item['empCompanyBase'] = item.empCompanyBase
                    item['companyBase'] = item.companyBase
                    item['personalBase'] = item.personalBase
                    item['startDate'] = startDate
                })
                self.totalSocialData = []
                self.totalSocialData = matchSocialData.list.concat(tempSocialData)
            } else {
                self.totalSocialData = Object.assign(tempSocialData, [])
            }
            self.totalSocialData = productApi.sortSocialData(self.totalSocialData)
        },


        //雇员薪资变更
        salaryChange () {
            const regex = /^(([1-9]\d*)|0)(\.\d{1,2})?$/i;
            if (this.empCompanyInfo.salary && this.empCompanyInfo.salary.match(regex)) {
                //this.$refs.addProductModalRef.setDefaultAmount_salary(this.empCompanyInfo.salary)
            }
        },

        isEndDateChange(val){
            // 否
            if(val){
                this.laborEndDateDisabled = true
                this.empCompanyInfo.laborEndDate = '2099-12-31T00:00:00.000+0800'
            }else{
                this.laborEndDateDisabled = false
                this.empCompanyInfo.laborEndDate = ''
            }
        },

        closePeRulesModal() {
            this.peRulesModal = false
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
          'empCompanyInfo.isNeedBankCard': function (val) {
              if (val === '0') {
                  this.isBank = true
                  this.isSelectBank = true
                  this.empCompanyInfo.bankCode = ''
              } else if (val === '1') {
                  this.isBank = false
                  this.isSelectBank = false
              }
          },
          'empCompanyInfo.bankCode': function (val) {
              if (val === '1' || val === '3') {
                  this.isBank = false
              } else if (val != '') {
                  this.isBank = true
              }
          },
          'empInfo.birthday': function (value) {
              let aDate = new Date()
              let thisYear = aDate.getFullYear()
              let bDate = new Date(value)
              let brith = bDate.getFullYear()
              let age = (thisYear - brith)
              this.$refs.addProductModalRef.setDefaultAmount_age(age)
          },
          'empInfo.idCardType': function (val) {
              // '1': '身份证', '2': '护照', '3': '军(警)官证', '4': '士兵证', '5': '台胞证', '6': '回乡证', '7': '其他'
              // 证件类型为 身份证/军(警)官证/士兵证 时国籍只能为中国
              if (val === '1' || val === '3' || val === '4') {
                  this.isCountryCode = true
                  this.empInfo.countryCode = 'CN'
              } else if (val === '5') {
                  this.isCountryCode = true
                  this.empInfo.countryCode = 'TW'
              } else if (val === '6') {
                  this.isCountryCode = false
                  this.empInfo.countryCode = ''

                  for (let key in this.country) {
                      this.country[key].disabled = true
                  }
                  this.country['HK'].disabled = false
                  this.country['MO'].disabled = false
              } else {
                  this.isCountryCode = false
                  this.empInfo.countryCode = ''

                  for (let key in this.country) {
                      this.country[key].disabled = false
                  }
                  // this.country['CN'].disabled = true
                  // this.country['HK'].disabled = true
                  // this.country['MO'].disabled = true
                  // this.country['TW'].disabled = true
              }
          }
      },
    created () {

    },
    mounted () {

    }
  }
</script>
