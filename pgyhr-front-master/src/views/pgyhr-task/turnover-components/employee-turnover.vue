<style lang="less">
    @import "../../../styles/table-common.less";
</style>

<template>
    <div class="search">
        <Card>
            <Form inline :label-width="100">
                <Row>
                    <Form-item label="客户雇员编号" prop="employeeName" class="ivu-form-item-batch">
                        <i-input style="width: 250px"  v-model="empCompanyItem.empCompanyId"></i-input>
                    </Form-item>

                    <Form-item label="雇员名称" prop="employeeName" class="ivu-form-item-batch">
                        <i-input style="width: 250px"  v-model="empCompanyItem.employeeName"></i-input>
                    </Form-item>

                    <Form-item label="公司名称" prop="companyName" class="ivu-form-item-batch">
                        <i-input style="width: 250px"  v-model="empCompanyItem.companyName"></i-input>
                    </Form-item>


                    <Form-item style="margin-left:-35px;" class="br">
                        <i-button type="primary" icon="ios-search" @click="queryByPage">查询</i-button>
                        <i-button type="warning" >重置</i-button>
                    </Form-item>
                </Row>
            </Form>

            <Row style="margin-top: 10px">
                <i-col span="24">
                    <Table border :columns="empCompanyColumns" :data="empCompanyData" ref="empCompanyDataTable"></Table>
                </i-col>
            </Row>

            <Row>
                <i-col span="14" align="center">
                    <Page
                            @on-change="this.handleCurrentChange"
                            :current="empCompanyItem.currentPage"
                            :page-size="empCompanyItem.size"
                            :total="empCompanyItem.total"
                            show-total
                            show-elevator>
                    </Page>
                </i-col>
            </Row>
        </Card>
    </div>
</template>

<script>
    import {mapState, mapGetters, mapActions} from 'vuex';
    import employeeTaskSheetTypes from "../../../store/event-types/pgyhr-task/employee_task_sheet_types";

    export default {
        name: "employee-turnover",
        data () {
            return {
                empCompanyItem:{
                    empCompanyId:'',
                    companyName:'',
                    employeeName:'',
                    currentPage:'',
                    size:'',
                },
                empCompanyColumns:[
                    {
                        type: "selection",
                        width: 60,
                        align: "center",
                        fixed: "left"
                    },
                    {
                        title: '客户雇员编号',
                        key: 'empCompanyId',
                        align: "center",
                        width: 200,
                    },
                    {
                        title: '公司名称',
                        key: 'companyName',
                        align: "center",
                        width: 200,
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
                        title: '雇员证件号',
                        key: 'idNum',
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
                        title: '雇员类型',
                        key: 'templateType',
                        align: "center",
                        width: 150,
                        render: (h, params) => {
                            if (params.row.templateType == 1) {
                                return h("span", [
                                    "派遣"
                                ]);
                            } else if (params.row.templateType == 2) {
                                return h("span", [
                                    "代理"
                                ]);
                            } else if (params.row.templateType == 3) {
                                return h("span", [
                                    "业务外包"
                                ]);
                            }
                        }
                    },
                    {
                        title: '雇员状态',
                        key: 'status',
                        align: "center",
                        width: 150,
                        render: (h, params) => {
                            if (params.row.status == 1) {
                                return h("span", [
                                    "预录入"
                                ]);
                            } else if (params.row.status == 2) {
                                return h("span", [
                                    "雇员信息确认中"
                                ]);
                            } else if (params.row.status == 3) {
                                return h("span", [
                                    "在职"
                                ]);
                            } else if (params.row.status == 4) {
                                return h("span", [
                                    "离职"
                                ]);
                            }
                        }
                    },
                    {
                        title: '入职日期',
                        key: 'inDate',
                        align: "center",
                        width: 200,
                    },
                    {
                        title: '离职日期',
                        key: 'outDate',
                        align: "center",
                        width: 200,
                        render: (h, params) => {
                            if (params.row.outDate == null) {
                                return h("span", [
                                    "在职"
                                ]);
                            } else {
                                return h("span", [
                                    params.row.outDate
                                ]);
                            }
                        }
                    },
                ]
            }
        },
        created(){
            this.queryByPage();
        },
        computed: {
            ...mapState('employeeTaskModule', {
                title: state => state.title,
                empTaskPage: state => state.empTaskPage,
                empCompanyData: state => state.empCompany,

            }),
        },
        methods: {
            ...mapActions('employeeTaskModule', [
                employeeTaskSheetTypes.EMPCOMPANY_PAGE
            ]),
            queryByPage(){
                this.handleCurrentChange(1);
            },
            handleCurrentChange(val) {
                this.empTaskPage.currentPage = val;
                this.finds();
            },
            finds(){
                this.empCompanyItem.currentPage = this.empTaskPage.currentPage;
                this.empCompanyItem.size = this.empTaskPage.size;

                let submitForm = {...this.empCompanyItem};
                console.log("params:================="+JSON.stringify(submitForm));

                this[employeeTaskSheetTypes.EMPCOMPANY_PAGE](submitForm);
            },
        }
    }
</script>