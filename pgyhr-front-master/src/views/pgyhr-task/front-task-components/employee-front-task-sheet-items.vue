<style lang="less">
    @import "../../../styles/table-common.less";
    @import "./employee-front-task-sheet-items.less";
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
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                    <Form-item label="社保缴纳地：" @on-change="socialCityChange">
                        <span> {{ socialCityName }}</span>
                    </Form-item>
                </Col>

                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                    <Form-item label="公积金缴纳地：">
                        <span> {{ fundCityName }}</span>
                    </Form-item>
                </Col>

                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                    <Form-item label="社保规则：" class="mb5" prop="socialRuleId">
                        <Select v-model="empAgreementInfo.socialPolicyCode"   filterable style="width:260px">
                            <Option v-for="item in socialPolicyList" :value="item.socialPolicyCode" :key="item.socialPolicyCode">{{ item.socialPolicyName }}</Option>
                        </Select>

                    </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                    <Form-item label="公积金规则：" class="mb5" prop="fundlPolicyCode">
                        <Select v-model="empAgreementInfo.fundlPolicyCode"   filterable style="width:260px">
                            <Option v-for="item in fundPolicyList" :value="item.socialPolicyCode" :key="item.socialPolicyCode">{{ item.socialPolicyName }}</Option>
                        </Select>
                    </Form-item>
                </Col>

                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                    <Form-item label="社保办理方：" prop="socialUnit">
                        <Select v-model="empCompanyInfo.socialUnit" filterable>
                            <Option v-for="(value, key) in this.baseDic.unitMap" :value="key" :key="key">{{value}}</Option>
                        </Select>
                    </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                    <Form-item label="公积金办理方：" prop="fundUnit">
                        <Select v-model="empCompanyInfo.fundUnit" filterable>
                            <Option v-for="(value, key) in this.baseDic.unitMap" :value="key" :key="key">{{value}}</Option>
                        </Select>
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
                                'totalSocialData':empFrontTaskSheetSocialFeeSegmentList,
                                'salary' : empCompanyInfo.salary,
                                'allEqualsBase':allEqualsBase,
                                'socialStartDate' : empCompanyInfo.inDate,
                                'socialUnit':empCompanyInfo.socialUnit,
                                'fundUnit' : empCompanyInfo.fundUnit,
                                'socialConfigs' : socialConfigs,
                                'socialPolicyCode':empAgreementInfo.socialPolicyCode,
                                'fundlPolicyCode' : empAgreementInfo.fundlPolicyCode
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

  </div>
</template>

<script>
  import IDValidator from 'id-validator'
  import {mapState, mapGetters, mapActions} from 'vuex';
  import Checkbox from '../../../../node_modules/iview/src/components/checkbox/checkbox.vue'
  import empProductGroupList from './emp-product-group-list'
  import employeeFrontTaskSheetTypes from "../../../store/event-types/pgyhr-task/employee_front_task_sheet_types";
  import empFrontTaskSheetSocialFeeSegmentTypes from "../../../store/event-types/pgyhr-task/emp_front_task_sheet_social_fee_segment_types";
  import socialPolicyTypes from "../../../store/event-types/pgyhr-task/social_policy_types";
  import util from "../../../libs/util";

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
        // 雇员公司关系
        empCompanyInfo: {
          companyId: '',
          employeeId:'',
          managementId: '',
          templateType: '',
          inDate: null,
          isTransActBankCard:0,
          isNeedBankCard: 0,
          bankCode: '',
          salary: '',
          salaryPayType: '',
          laborStartDate: null,
          laborEndDate: null,
          laborSide:'',
          deptName:'',
          empCode:'',
          position: '',
          trySalary: '',
          tryStartDate: null,
          tryEndDate: null,
          workType: '',
          postType: '1',
          employStyle: '1',
          socialUnit: '',
          fundUnit: '',
          hireUnit: '',
          workCityCode: '320400',
          socialCityCode: '320400',
          fundCityCode: '320400',
          workCityName: '常州市',
          socialCityName: '常州市',
          fundCityName: '常州市',
          jobContent: '',
          remark: '',
          dispatchingTerm: null
        },

        empAgreementInfo: {
          empAgreementId: '',
          templateType: '',
          employeeId: '',
          companyId: '',
          empCompanyId: '',
          startDate: '',
          fundlPolicyCode: '',
          socialPolicyCode: '',
          empBase: ''
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
              required: true,
              message: '请选择工资支付方式',
              trigger: 'change'
            }
          ],
          workType: [
            {
              required: true,
              message: '请选择工时',
              trigger: 'change'
            }
          ],
            socialUnit: [
                {
                    required: true,
                    message: '请选择社保办理方',
                    trigger: 'change'
                }
            ],
            fundUnit: [
                {
                    required: true,
                    message: '请选择公积金办理方',
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

            templateType: [
                {
                    required: true,
                    message: '请选择雇员类型',
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

            laborSide: [
                {
                    required: true,
                    message: '请选择合同签定方',
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
        peRulesFlag: true,

          // 雇员
          empFrontTaskSheetSocialFeeSegmentParam: {
              socialPolicyCode: '',
              fundlPolicyCode: '',
              requestType: '',
              cityCode: '',
              starDate: ''
          },
      }

    },

    computed: {
      ...mapState('areaModule', {
          areaAllData: state => state.areaAllData
      }),

        ...mapState('countryModule', {
            countryData: state => state.countryData
        }),

        ...mapState('socialPolicyModule', {
            socialPolicyList: state => state.socialPolicyList,
            fundPolicyList:state => state.fundPolicyList,
        }),

        ...mapState('empFrontTaskSheetSocialFeeSegmentModule', {
            empFrontTaskSheetSocialFeeSegmentList: state => state.empFrontTaskSheetSocialFeeSegmentList,
        }),

        ...mapState('employeeFrontTaskModule', {
            addEmployeeInfo: state => state.addEmployeeInfo,
        }),

    },
    methods: {
        ...mapActions('empFrontTaskSheetSocialFeeSegmentModule', {
            getEmpFrontTaskSheetSocialFeeSegmentByInput: empFrontTaskSheetSocialFeeSegmentTypes.SEARCH_EMP_FRONT_TASK_SHEET_SOCIAL_FEE_SEGMENT
        }),

        ...mapActions('socialPolicyModule', {
            getSocialPolicyByCity: socialPolicyTypes.SEARCH_SOCIAL_POLICY_BY_PARAM
        }),

        ...mapActions('employeeFrontTaskModule', [employeeFrontTaskSheetTypes.SAVE_EMPLOYEE_TASK_SHEET_INFO
        ]),


        initData(){
            this.getSocialPolicyByCity("320400");
        },

        async socialCityChange(){

        },

        errModalClick () {
        },

        async commitForm () {
            //console.log("totalSocialData"+JSON.stringify(this.empFrontTaskSheetSocialFeeSegmentList));

            this.$refs['empCompanyInfo'].validate((valid) => {
                if (valid) {

                    var params = {
                        employeeInfoPO: this.addEmployeeInfo,
                        empCompanyPO: this.empCompanyInfo,
                        empFrontTaskSheetSocialFeeSegmentForSocialInfoDTOList: this.empFrontTaskSheetSocialFeeSegmentList
                    };
                    var type = '新增';
                    var title = "雇员任务单" + type;
                    this[employeeFrontTaskSheetTypes.SAVE_EMPLOYEE_TASK_SHEET_INFO](params).then((response) => {
                        console.log("MUTATE_SAVE_EMPLOYEE_INFO======result============"+JSON.stringify(response));
                        if (response.code == 200) {
                            this.$Notice.success({
                                title: title,
                                desc: title + '成功',
                            });
                            // this.$router.push({
                            //     name: "employee_front_task_sheet_items"
                            // });

                        }else{
                            this.$Notice.error({
                                title: title,
                                content: response.message
                            });
                        }
                    }).catch((error) => {
                        this.$Notice.error({
                            title: title,
                            content: title + "错误"
                        });
                    });
                }
            })

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
                this.empCompanyInfo.laborStartDate = this.empCompanyInfo.inDate;
                this.empCompanyInfo.tryStartDate = this.empCompanyInfo.inDate;
                let checkStartDate = this.$dateUtils.checkNextMonth(this.empCompanyInfo.inDate, 'start');
                this.empAgreementInfo.startDate = checkStartDate;
                //console.log("getSocialItemData type====="+this.empAgreementInfo.startDate);
                this.getSocialItemData(0, this.empAgreementInfo.socialPolicyCode, this.empAgreementInfo.fundlPolicyCode)
            }
        },

        async getSocialItemData (requestType, socialPolicyCode, fundlPolicyCode) {

            this.empFrontTaskSheetSocialFeeSegmentParam.socialPolicyCode = socialPolicyCode;
            this.empFrontTaskSheetSocialFeeSegmentParam.fundlPolicyCode = fundlPolicyCode;
            this.empFrontTaskSheetSocialFeeSegmentParam.requestType = requestType;
            this.empFrontTaskSheetSocialFeeSegmentParam.cityCode = '320400';
            this.empFrontTaskSheetSocialFeeSegmentParam.starDate = this.$dateUtils.stdFormatDateByFormat(this.empAgreementInfo.startDate,'YYYY-MM-DD');
            this.getEmpFrontTaskSheetSocialFeeSegmentByInput(this.empFrontTaskSheetSocialFeeSegmentParam);
            console.log("getSocialItemData type====="+JSON.stringify(this.empFrontTaskSheetSocialFeeSegmentParam));

            // let paramJSON = {
            //     type: type,
            //     socialPolicyCode: socialPolicyCode,
            //     fundRuleId: fundlPolicyCode,
            //     empSocial: this.buildSocialParamData(type)
            // }
            // console.log("getSocialItemData type====="+JSON.stringify(paramJSON));
            // let matchSocialData = this.socialPolicyList;
            // let self = this
            // let tempSocialData = [];
            // //社保模板选择时
            // // self.totalSocialData.forEach(function (item) {
            // //     if (type === 1 && item.policyType === 2) {
            // //         tempSocialData.push(item)
            // //     } else if (type === 2 && item.policyType === 1) {
            // //         tempSocialData.push(item)
            // //     }
            // // })
            // console.log("matchSocialData====="+JSON.stringify(matchSocialData));
            // if (matchSocialData) {
            //     let startDate = this.$dateUtils.checkNextMonth(new Date(this.empCompanyInfo.inDate), 'start');
            //     self.allEqualsBase = matchSocialData.combined;
            //     matchSocialData.forEach(function (item) {
            //         item['empCompanyBase'] = item.empCompanyBase;
            //         item['companyBase'] = item.companyBase;
            //         item['personalBase'] = item.personalBase;
            //         item['startDate'] = startDate;
            //     })
            //     self.totalSocialData = [];
            //     self.totalSocialData = matchSocialData.list.concat(tempSocialData)
            // } else {
            //     self.totalSocialData = Object.assign(tempSocialData, [])
            // }
            // self.totalSocialData = productApi.sortSocialData(self.totalSocialData)
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
        this.initData();
    },
    mounted () {

    }
  }
</script>
