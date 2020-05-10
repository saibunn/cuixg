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
                  <Select v-model="empInfo.idCardType">
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
                <Form-item label="联系地址：">
                  <Input type="text" v-model="empInfo.employeeAddress" placeholder="请输入"/>
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
        // 雇员
        empInfo: {
          employeeId: '',
          employeeName: '',
          idCardType: '1',
          idNum: '',
          gender: '',
          birthday: null,
          countryCode: '',
          nationality:'',
          socialAccount:'',
          fundAccount:'',
          addFundAccount:'',
          employeeMobile: '',
          employeeEmail: '',
          employeeAddress: '',
          residentType: '',
          marriageStatus: '',
          emergencyContactName:'',
          emergencyMobile:''
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
          ],
          nationality: [
              {
                  required: true,
                  message: '请选择民族',
                  trigger: 'change'
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

            // emergencyMobile: [
            //     {
            //         pattern: '^\\d{11}$',
            //         message: '请输入正确紧急联系人手机号',
            //         trigger: 'blur'
            //     }
            // ],
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

      errModalClick () {
      },

      addEmployeeInfo() {
          this.$router.push({
              name: "employee_front_task_sheet_items"
          });

          // this.$refs['empInfo'].validate((valid) => {
          //     if (valid) {
          //         var params = this.empInfo;
          //         var type = '新增';
          //         var title = "雇员信息" + type;
          //         this[employeeTaskSheetTypes.SAVE_EMPLOYEE_INFO](params).then((response) => {
          //             //console.log("MUTATE_SAVE_EMPLOYEE_INFO======result============"+JSON.stringify(response));
          //             if (response.code == 200){
          //                 this.$store.commit("employeeFrontTaskModule/" + employeeTaskSheetTypes.MUTATE_ADD_EMPLOYEE_INFO, response.result);
          //                 this.$Notice.success({
          //                     title: title,
          //                     desc: title + '成功',
          //                 });
          //                 this.$router.push({
          //                     name: "employee_front_task_sheet_items"
          //                 });
          //
          //             }else{
          //                 this.$Notice.error({
          //                     title: title,
          //                     content: response.message
          //                 });
          //             }
          //         }).catch((error) => {
          //             this.$Notice.error({
          //                 title: title,
          //                 content: title + "错误"
          //             });
          //         });
          //     }
          // })
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
