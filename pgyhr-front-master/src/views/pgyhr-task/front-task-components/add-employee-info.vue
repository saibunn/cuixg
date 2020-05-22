<style lang="less">
    @import "../../../styles/table-common.less";
    @import "./add-employee-info.less";
</style>

<template>
  <div id="newEmployeeIn" class="search">
      <p>雇员基本信息</p>
      <Card>
          <Row>
            <Form ref="empInfoForm" :model="empInfo" :rules="empInfoRuleValidate" inline :label-width="150">
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="姓名：" prop="employeeName">
                  <Input v-model="empInfo.employeeName" type="text" placeholder="请输入"/>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="证件类型：" prop="idCardType">
                  <Select v-model="empInfo.idCardType">
                    <Option v-for="(value,key) in this.baseDic.idCardType" :value="key" :key="key">{{ value }}</Option>
                  </Select>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="证件号：" prop="idNum">
                  <Input type="text" v-model="empInfo.idNum" @on-blur="idNumChange" placeholder="请输入">
                  </Input>
                </Form-item>
                </Col>
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
                  <Select v-model="empInfo.countryCode" :label-in-value="true" @on-change="countrySelected" :disabled="isCountryCode" filterable>
                    <Option v-for="item in countryData" :value="item.code" :key="item.code">{{ item.name }}</Option>
                  </Select>
                </Form-item>
                </Col>

                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                    <Form-item label="民族：" prop="nationality">
                        <Select v-model="empInfo.nationality" filterable>
                            <Option v-for="item in this.baseDic.nationData" :value="item.name" :key="item.id">{{ item.name }}</Option>
                        </Select>
                    </Form-item>
                </Col>

                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="手机号：" prop="employeeMobile">
                  <Input type="text" v-model="empInfo.employeeMobile" placeholder="请输入"/>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="邮箱：" prop="employeeEmail">
                  <Input type="text" v-model="empInfo.employeeEmail" placeholder="请输入"/>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="现居住地址：" prop="employeeAddress">
                  <Input type="text" v-model="empInfo.employeeAddress" placeholder="请输入"/>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                    <Form-item label="参加工作时间：" prop="workDate">
                        <DatePicker transfer v-model="empInfo.workDate" type="date" placement="bottom"  placeholder="选择日期" style="width: 100%;"></DatePicker>
                    </Form-item>
                </Col>

                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                    <Form-item label="社保账号：" prop="socialAccount">
                        <Input type="text" v-model="empInfo.socialAccount" placeholder="请输入"/>
                    </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                    <Form-item label="公积金账号：" prop="fundAccount">
                        <Input type="text" v-model="empInfo.fundAccount" placeholder="请输入"/>
                    </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                    <Form-item label="补充公积金账号：" prop="addFundAccount">
                        <Input type="text" v-model="empInfo.addFundAccount" placeholder="请输入"/>
                    </Form-item>
                </Col>

                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                    <Form-item label="文化程度：" prop="eduLevel">
                        <Select v-model="empInfo.eduLevel">
                            <Option v-for="(value,key) in this.baseDic.eduLevel" :value="key" :key="key">{{ value }}</Option>
                        </Select>
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
                    <Form-item label="户口所在地地址：" prop="residenceAddress">
                        <Input type="text" v-model="empInfo.residenceAddress" placeholder="请输入"/>
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
                    <Form-item label="人员类别：" prop="empType">
                        <Select v-model="empInfo.empType">
                            <Option v-for="(value,key) in this.baseDic.empType" :value="key" :key="key">{{ value }}</Option>
                        </Select>
                    </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                    <Form-item label="个人身份：" prop="empIdentity">
                        <Select v-model="empInfo.empType">
                            <Option v-for="(value,key) in this.baseDic.empIdentity" :value="key" :key="key">{{ value }}</Option>
                        </Select>
                    </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="紧急联系人：">
                  <Input type="text" v-model="empInfo.emergencyContactName" placeholder="请输入"/>
                </Form-item>
                </Col>
                <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                <Form-item label="紧急联系人电话：" prop="emergencyMobile">
                  <Input type="text" v-model="empInfo.emergencyMobile" placeholder="请输入"/>
                </Form-item>
                </Col>

<!--                <Form-item style="margin-left:-35px;" class="br">-->
<!--                    <a class="drop-down" @click="dropDown">-->
<!--                        {{dropDownContent}}-->
<!--                        <Icon :type="dropDownIcon"></Icon>-->
<!--                    </a>-->
<!--                </Form-item>-->

            </Form>
          </Row>
      </Card>

      <Row class="operation">
          <Button type="info"  @click="addEmployeeInfo()">保存并下一步</Button>
      </Row>

  </div>
</template>

<script>
  import IDValidator from 'id-validator'
  import {mapState, mapGetters, mapActions} from 'vuex';
  import employeeTaskSheetTypes from "../../../store/event-types/pgyhr-task/employee_front_task_sheet_types";

  export default {
    components: {
    },
    data: function () {
      return {


        // 国籍是否必填
        isCountryCode: false,
        // 雇员信息
          empInfo:{
              // employeeId: '',
              // employeeName: '',
              idCardType: '1',
              // idNum: '',
              // gender: '',
              // workDate:null,
              // birthday: null,
              countryCode: '',
              countryName: '',
              // nationality:'',
              // socialAccount:'',
              // fundAccount:'',
              // addFundAccount:'',
              // employeeMobile: '',
              // employeeEmail: '',
              // employeeAddress: '',
              // residentType: '',
              // marriageStatus: '',
              // emergencyContactName:'',
              // emergencyMobile:''
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
              trigger: 'blur'
            }
          ],
          idCardType: [
            {
              required: true,
              message: '请选择证件类型',
              trigger: 'blur'
            }
          ],
        workDate: [
              {
                  type: 'date',
                  required: true,
                  message: '请选择参加工作时间',
                  trigger: 'blur'
              }
          ],
          residentType: [
              {
                  required: true,
                  message: '请选择户口性质',
                  trigger: 'blur'
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
              trigger: 'blur'
            }
          ],
          nationality: [
              {
                  required: true,
                  message: '请选择民族',
                  trigger: 'blur'
              }
          ],

          socialAccount: [
              {
                  required: true,
                  message: '请输入雇员社保账号',
                  trigger: 'blur'
              }
          ],
          fundAccount: [
              {
                  required: true,
                  message: '请输入雇员公积金账号',
                  trigger: 'blur'
              }
          ],
          employeeAddress: [
              {
                  required: true,
                  message: '请输入现居住地址',
                  trigger: 'blur'
              }
          ],
          residenceAddress: [
              {
                  required: true,
                  message: '请输入户口所在地地址',
                  trigger: 'blur'
              }
          ],
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

    },
    methods: {

      ...mapActions('employeeFrontTaskModule', [employeeTaskSheetTypes.SAVE_EMPLOYEE_INFO
      ]),

      ...mapActions('employeeFrontTaskModule', [employeeTaskSheetTypes.SEARCH_EMPLOYEE_INFO
      ]),

      errModalClick () {
      },

        async countrySelected (selectValue) {
            // console.log("companySelected type====="+selectValue.value);
            // console.log("companySelected type====="+selectValue.label);
            this.empInfo.countryCode = selectValue.value;
            this.empInfo.countryName = selectValue.label;
            console.log("MUTATE_SAVE_EMPLOYEE_INFO======result============"+JSON.stringify(empInfo));
        },

        //雇员证件号带入数据
        idNumChange () {
            //console.log("this.SEARCH_EMPLOYEE_INFO====dsdfds=============="+JSON.stringify(this.empInfo));

          if(this.empInfo != null && this.empInfo  != undefined){
              if(this.empInfo.idCardType != "" && this.empInfo.idCardType  != undefined && this.empInfo.idCardType  != null &&
                  this.empInfo.idNum != "" && this.empInfo.idNum  != undefined && this.empInfo.idNum  != null )
              this[employeeTaskSheetTypes.SEARCH_EMPLOYEE_INFO](this.empInfo).then((response) => {
                  console.log("MUTATE_SAVE_EMPLOYEE_INFO======result============"+JSON.stringify(response));
                  if (response.code == 200){
                      if(response.result != null){
                          this.empInfo = response.result;
                          if(this.empInfo.idCardType){
                              this.empInfo.idCardType = this.empInfo.idCardType.toString();
                          }
                          if(this.empInfo.residentType){
                              this.empInfo.residentType = this.empInfo.residentType.toString();
                          }
                          if(this.empInfo.marriageStatus){
                              this.empInfo.marriageStatus = this.empInfo.marriageStatus.toString();
                          }
                          if(this.empInfo.empType){
                              this.empInfo.empType = this.empInfo.empType.toString();
                          }
                          if(this.empInfo.gender){
                              this.empInfo.gender = this.empInfo.gender.toString();
                          }
                          if(this.empInfo.eduLevel){
                              this.empInfo.eduLevel = this.empInfo.eduLevel.toString();
                          }
                          if(this.empInfo.empIdentity){
                              this.empInfo.empIdentity = this.empInfo.empIdentity.toString();
                          }
                          console.log(" this.empInfo=============="+JSON.stringify(this.empInfo));
                      }
                  }
              });
          }

        },

      addEmployeeInfo() {
          // this.$router.push({
          //     name: "employee_front_task_sheet_items"
          // });

          this.$refs['empInfoForm'].validate((valid) => {
              if (valid) {
                  var params = this.empInfo;
                  var type = '新增';
                  var title = "雇员信息" + type;
                  this[employeeTaskSheetTypes.SAVE_EMPLOYEE_INFO](params).then((response) => {
                      //console.log("MUTATE_SAVE_EMPLOYEE_INFO======result============"+JSON.stringify(response));
                      if (response.code == 200){
                          this.$store.commit("employeeFrontTaskModule/" + employeeTaskSheetTypes.MUTATE_ADD_EMPLOYEE_INFO, response.result);
                          this.$Notice.success({
                              title: title,
                              desc: response.message,
                          });
                          this.$router.push({
                              name: "employee_front_task_sheet_items"
                          });

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

    // dropDown() {
    //     if (this.drop) {
    //         this.dropDownContent = "展开";
    //         this.dropDownIcon = "ios-arrow-down";
    //     } else {
    //         this.dropDownContent = "收起";
    //         this.dropDownIcon = "ios-arrow-up";
    //     }
    //     this.drop = !this.drop;
    // },
    },
    watch: {

    },
    created () {

    },
    mounted () {

    }
  }
</script>
