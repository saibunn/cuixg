<style lang="less">
    @import "../../../styles/table-common.less";
</style>

<template>
    <div class="search">
        <Card>
            <Form inline :label-width="90">
                <Row>
                  <Form-item label="雇员名称" prop="employeeName" class="ivu-form-item-batch">
                    <i-input style="width: 250px"  v-model="employeeItem.employeeName"></i-input>
                  </Form-item>

                  <Form-item label="证件号码" prop="idNum" >
                    <i-input style="width: 250px"  v-model="employeeItem.idNum"></i-input>
                  </Form-item>


                  <Form-item style="margin-left:-35px;" class="br">
                        <i-button type="primary" icon="ios-search" @click="queryByPage">查询</i-button>
                        <i-button type="warning" >重置</i-button>
                  </Form-item>
                </Row>
            </Form>

            <Row style="margin-top: 10px">
                <i-col span="24">
                        <Table border :columns="employeeColumns" :data="empTaskData" ref="companyDataTable"></Table>
                </i-col>
            </Row>

            <Row>
                <i-col span="14" align="center">
                    <Page
                            @on-change="this.handleCurrentChange"
                            :current="empTaskPage.currentPage"
                            :page-size="empTaskPage.size"
                            :total="empTaskPage.total"
                            show-total
                            show-elevator>
                    </Page>
                </i-col>
            </Row>
        </Card>


        <Modal
                title="编辑雇员信息"
                v-model="editEmployeeModelFlg"
                :mask-closable="false"
                :width="900"
                :styles="{top: '30px'}">
            <Row>
                <Form ref="empInfo" :model="empInfo" :rules="empInfoRuleValidate" inline :label-width="150">
                    <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                        <Form-item label="姓名：" prop="employeeName">
                            <Input v-model="empInfo.employeeName" type="text" placeholder="请输入"/>
                        </Form-item>
                    </Col>
                    <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                        <Form-item label="出生年月：" prop="birthday">
                            <DatePicker transfer v-model="empInfo.birthday" value-format="yyyy-MM-dd" type="date" placement="bottom" placeholder="选择日期" style="width: 100%;"></DatePicker>
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
                        <Form-item label="曾用名：" prop="formerName">
                            <Input v-model="empInfo.formerName" type="text" placeholder="请输入"/>
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
                        <Form-item label="国籍：" prop="countryCode">
                            <Select v-model="empInfo.countryCode" :disabled="isCountryCode" filterable>
                                <Option v-for="item in countryData" :value="item.code" :key="item.code">{{ item.name }}</Option>
                            </Select>
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
                        <Form-item label="紧急联系人：">
                            <Input type="text" v-model="empInfo.emergencyContactName" placeholder="请输入"/>
                        </Form-item>
                    </Col>
                    <Col :sm="{span: 22}" :md="{span: 12}" :lg="{span: 8}">
                        <Form-item label="紧急联系人电话：" prop="emergencyMobile">
                            <Input type="text" v-model="empInfo.emergencyMobile" placeholder="请输入"/>
                        </Form-item>
                    </Col>
                </Form>
            </Row>
            <div slot="footer">
                <Button type="text" @click="editEmployeeModelFlg = false">取消</Button>
                <Button type="primary" :loading="submitLoading" @click="submitEmployee">提交</Button>
            </div>
        </Modal>
    </div>
</template>

<script>
    import {mapState, mapGetters, mapActions} from 'vuex';
    import employeeTaskSheetTypes from "../../../store/event-types/pgyhr-task/employee_task_sheet_types";
    import companyTypes from "../../../store/event-types/pgyhr-company/company-types";
    import countryTypes from "../../../store/event-types/common/country_types";
    import areaTypes from "../../../store/event-types/common/area_types";

    export default {
        data () {
            return {
                employeeItem: {
                    employeeName:'',
                    idNum:'',
                    currentPage:'',
                    size:'',
                },
                editEmployeeModelFlg:false,
                submitLoading: false,
                employeeColumns:[
                    {
                        type: "selection",
                        width: 60,
                        align: "center",
                        fixed: "left"
                    },
                    {
                        title: '雇员编号',
                        key: 'employeeId',
                        align: "center",
                        width: 200,
                    },
                    {
                        title: '雇员名称',
                        key: 'employeeName',
                        align: "center",
                        width: 150,
                    },
                    {
                        title: '雇员性别',
                        key: 'gender',
                        align: "center",
                        width: 120,
                        render: (h, params) => {
                            if (params.row.gender == 1) {
                                return h("span", [
                                    "男"
                                ]);
                            } else if (params.row.gender == 0) {
                                return h("span", [
                                    "女"
                                ]);
                            }
                        }
                    },
                    {
                        title: '证件类型',
                        key: 'idCardType',
                        align: "center",
                        width: 130,
                        render: (h, params) => {
                            if (params.row.idCardType == 1) {
                                return h("span", [
                                    "身份证"
                                ]);
                            } else if (params.row.idCardType == 2) {
                                return h("span", [
                                    "护照"
                                ]);
                            } else if (params.row.idCardType == 3) {
                                return h("span", [
                                    "军(警)官证"
                                ]);
                            } else if (params.row.idCardType == 4) {
                                return h("span", [
                                    "士兵证"
                                ]);
                            } else if (params.row.idCardType == 5) {
                                return h("span", [
                                    "台胞证"
                                ]);
                            } else if (params.row.idCardType == 6) {
                                return h("span", [
                                    "回乡证"
                                ]);
                            } else if (params.row.idCardType == 7) {
                                return h("span", [
                                    "其他"
                                ]);
                            }
                        }
                    },
                    {
                        title: '证件号码',
                        key: 'idNum',
                        align: "center",
                        width: 230,
                    },
                    {
                        title: '出生日期',
                        key: 'birthday',
                        align: "center",
                        width: 200,
                    },
                    {
                        title: '手机号码',
                        key: 'employeeMobile',
                        align: "center",
                        width: 200,
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
                            let enableOrDisable = "";
                            if (params.row.active == true) {
                                enableOrDisable = h(
                                    "Button",
                                    {
                                        props: {
                                            size: "small"
                                        },
                                        style: {
                                            marginRight: "5px"
                                        },
                                        on: {
                                            click: () => {
                                                this.disable(params.row);
                                            }
                                        }
                                    },
                                    "禁用"
                                );
                            } else {
                                enableOrDisable = h(
                                    "Button",
                                    {
                                        props: {
                                            type: "success",
                                            size: "small"
                                        },
                                        style: {
                                            marginRight: "5px"
                                        },
                                        on: {
                                            click: () => {
                                                this.enable(params.row);
                                            }
                                        }
                                    },
                                    "启用"
                                );
                            }
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
                                            this[employeeTaskSheetTypes.QUERY_EMPLOYEE_ID]({employeeId:this.empTaskData[params.index].employeeId}).then((response) => {
                                                this.empInfo=response.result
                                                this.editEmployeeModelFlg=true;
                                            });
                                            //this.empInfo.employeeId=this.empTaskData[params.index].employeeId;
                                        }
                                    }
                                }, '编辑'),
                                enableOrDisable

                            ]);
                        }
                    }
                ],
                // 国籍是否必填
                isCountryCode: false,
                // 雇员
                empInfo: {
                    employeeId: '',
                    employeeName: '',
                    idCardType: 1,
                    formerName: '',
                    idNum: '',
                    gender: '',
                    birthday: null,
                    countryCode: '',
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
                    emergencyMobile: [
                        {
                            pattern: '^\\d{11}$',
                            message: '请输入正确紧急联系人手机号',
                            trigger: 'blur'
                        }
                    ],
                },
            }
        },
        created(){
            this.queryByPage();
        },
        computed: {

            ...mapState('employeeTaskModule', {
                title: state => state.title,
                empTaskPage: state => state.empTaskPage,
                empTaskData: state => state.rows,

            }),
            ...mapState('countryModule', {
                countryData: state => state.countryData
            }),

        },
        methods: {
            ...mapActions('employeeTaskModule', [
                employeeTaskSheetTypes.EMPLOYEE_PAGE,
                employeeTaskSheetTypes.QUERY_EMPLOYEE_ID,
                employeeTaskSheetTypes.UPDATE_EMPLOYEE_INFO,
            ]),
            ...mapActions('countryModule', [countryTypes.COUNTRY_DATA]),
            async initData(){
                await this[countryTypes.COUNTRY_DATA]("");
            },

            queryByPage(){
                this.handleCurrentChange(1);
            },

            handleCurrentChange(val) {
                this.empTaskPage.currentPage = val;
                this.finds();
            },
            finds(){
                this.employeeItem.currentPage = this.empTaskPage.currentPage;
                this.employeeItem.size = this.empTaskPage.size;

                let submitForm = {...this.employeeItem};
                console.log("params:================="+JSON.stringify(submitForm));

                this[employeeTaskSheetTypes.EMPLOYEE_PAGE](submitForm);
            },
            ok () {
            },
            cancel () {
                this.$Message.info('点击了取消');
            },
            submitEmployee(){
                this.$refs.empInfo.validate(valid => {
                    if (valid) {
                        this.submitLoading = true;
                        console.log(JSON.stringify(this.empInfo));
                        this[employeeTaskSheetTypes.UPDATE_EMPLOYEE_INFO](this.empInfo).then((response) => {
                            this.submitLoading = false;
                            if (response.code==200) {
                                this.$Notice.success({
                                    title: title,
                                    desc: title + '成功',
                                });
                                this.queryByPage();
                                this.editEmployeeModelFlg = false;
                            }
                        });
                    }
                });
            },
            enable(v) {
                this.$Modal.confirm({
                    title: "确认启用",
                    content: "您确认要启用雇员 " + v.employeeName + " ?",
                    loading: true,
                    onOk: () => {
                        v.active=true;
                        console.log(v);
                        this[employeeTaskSheetTypes.UPDATE_EMPLOYEE_INFO](v).then((response) => {
                            this.$Modal.remove();
                            if (res.success) {
                                this.$Message.success("操作成功");
                                this.queryByPage();
                            }
                        });
                    }
                });
            },
            disable(v) {
                this.$Modal.confirm({
                    title: "确认禁用",
                    content: "您确认要禁用雇员 " + v.employeeName + " ?",
                    loading: true,
                    onOk: () => {
                        v.active=false;
                        console.log(v);
                        this[employeeTaskSheetTypes.UPDATE_EMPLOYEE_INFO](v).then((response) => {
                            this.$Modal.remove();
                            if (res.success) {
                                this.$Message.success("操作成功");
                                this.queryByPage();
                            }
                        });
                    }
                });
            },
        },
        mounted() {
            this.initData();
        }
    }
</script>