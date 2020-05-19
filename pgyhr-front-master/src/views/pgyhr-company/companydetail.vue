<style scoped>

    .form {
        /*width: 80%;*/
        margin: 30px 200px 0px 200px;
        padding: 40px 70px 30px 70px;
        /*margin-left: 50px;*/
        /*border:1px solid #F00;*/
        background:#ffffff;
    }

</style>

<template>
    <div class="form" >
        <Row style="margin-top: 10px">
            <Form ref="formCompanyDate" :model="formCompanyDate" :rules="ruleCompanyDate" :label-width="120" label-position="right">
                <Row style="margin:15px 0px 10px 0px">
                <i-col span="24">
                    <Card dis-hover>
                        <p slot="title">基本信息：</p>
                        <Row style="margin-top: 20px">
                            <i-col span="7">
                                <Form-item label="公司类型" prop="companyLevel">
                                    <RadioGroup v-model="formCompanyDate.companyLevel"  @on-change="companyLevelType">
                                        <Radio :label="0">母公司</Radio>
                                        <Radio :label="1">子公司</Radio>
                                    </RadioGroup>
                                </Form-item>
                            </i-col>
                            <i-col span="7" offset="1">
                                <Form-item label="母公司" prop="companyParentid">
                                    <i-select v-model.sync="formCompanyDate.companyParentid" placeholder="无" v-bind:disabled="companyty">
                                        <i-option  v-for="item in controllingCompany" v-bind:value="item.companyCode">{{item.companyName}}</i-option>
                                    </i-select>
                                </Form-item>
                            </i-col>
                        </Row>

                        <Row>
                        <i-col span="7">
                            <Form-item label="客户名称" prop="companyName">
                                <i-input v-model="formCompanyDate.companyName" placeholder="请输入客户名称"></i-input>
                            </Form-item>
                        </i-col>
                        <i-col span="7" offset="1">
                            <Form-item label="纳税类型" prop="taxTypes">
                                <i-select v-model="formCompanyDate.taxTypes" placeholder="请选择纳税类型">
                                    <i-option value="1">一般纳税人</i-option>
                                    <i-option value="2">小规模企业</i-option>
                                </i-select>
                            </Form-item>
                        </i-col>
                        <i-col span="7" offset="1">
                            <Form-item label="营业执照复印件" prop="name">
                                <Button icon="ios-cloud-upload-outline">上传附件</Button>
                            </Form-item>
                        </i-col>
                        </Row>

                        <Row>
                        <i-col span="7">
                            <Form-item label="注册地址所在地" prop="companyRegisteredLocation">
                                <Cascader
                                        v-model="formCompanyDate.companyRegisteredLocation"
                                        :data="areaData"
                                        not-found-text="无匹配数据"
                                ></Cascader>
                            </Form-item>
                        </i-col>
                        <i-col span="15" offset="1">
                            <Form-item label="详情地址" prop="name">
                                <i-input v-model.sync="formCompanyDate.detailedAddressRegistered" placeholder="请输入详情地址"></i-input>
                            </Form-item>
                        </i-col>
                        </Row>

                        <Row>
                            <i-col span="7">
                                <Form-item label="实际办公地点" prop="companyRealityLocation">
                                    <Cascader
                                            v-model="formCompanyDate.companyRealityLocation"
                                            :data="areaData"
                                            not-found-text="无匹配数据"
                                    ></Cascader>
                                </Form-item>
                            </i-col>
                            <i-col span="15" offset="1">
                                <Form-item label="详情地址" prop="name">
                                    <i-input v-model.sync="formCompanyDate.detailedAddressReality" placeholder="请输入详情地址"></i-input>
                                </Form-item>
                            </i-col>
                        </Row>
                    </Card>
                </i-col>
                </Row>


                <Row style="margin:10px 0px 40px 0px">
                    <Card span="24" dis-hover>
                        <Row style="margin-top: 15px">
                            <i-col span="7">
                                <Form-item label="社保账户" prop="socialSecurityAgent">
                                    <Checkbox v-model.sync="socialSecurityAgentBoole">是否社保代办</Checkbox>
                                </Form-item>
                            </i-col>
                            <i-col span="7" offset="1">
                                <Form-item label="养老账户" prop="pensionAccount">
                                    <i-input v-model.sync="formCompanyDate.pensionAccount" placeholder="请输入养老账户"></i-input>
                                </Form-item>
                            </i-col>
                            <i-col span="7" offset="1">
                                <Form-item label="医疗账号" prop="medicalAccount">
                                    <i-input v-model.sync="formCompanyDate.medicalAccount" placeholder="请输入医疗账号"></i-input>
                                </Form-item>
                            </i-col>

                            <i-col span="7">
                                <Form-item label="失业账户" prop="unemploymentAccount">
                                    <i-input v-model.sync="formCompanyDate.unemploymentAccount" placeholder="请输入失业账户"></i-input>
                                </Form-item>
                            </i-col>
                            <i-col span="7" offset="1">
                                <Form-item label="工伤账户" prop="inductrialInjuryAccounts">
                                    <i-input v-model.sync="formCompanyDate.inductrialInjuryAccounts" placeholder="请输入工伤账户"></i-input>
                                </Form-item>
                            </i-col>
                            <i-col span="7" offset="1">
                                <Form-item label="生育账号" prop="familyAccount">
                                    <i-input v-model.sync="formCompanyDate.familyAccount" placeholder="请输入生育账号"></i-input>
                                </Form-item>
                            </i-col>

                            <i-col span="7">
                                <Form-item label="公积金账户" prop="housingFundAgent">
                                    <Checkbox v-model.sync="housingFundAgentBoole">是否公积金代办</Checkbox>
                                </Form-item>
                            </i-col>
                            <i-col span="7" offset="1">
                                <Form-item label="基本公积金账户" prop="basicHousingFundAgent">
                                    <i-input v-model.sync="formCompanyDate.basicHousingFundAgent" placeholder="请输入基本公积金账户"></i-input>
                                </Form-item>
                            </i-col>
                            <i-col span="7" offset="1">
                                <Form-item label="补充公积金账号" prop="replenishHousingFundAgent">
                                    <i-input v-model.sync="formCompanyDate.replenishHousingFundAgent" placeholder="请输入补充公积金账号"></i-input>
                                </Form-item>
                            </i-col>
                        </Row>
                    </Card>
                </Row>



                <Row style="margin:15px 0px -15px 0px" v-for="(item,index) in formCompanyDate.companyContactsDTOList">
<!--                    <i-col span="24" style="padding-bottom: 15px;">-->
                        <Card dis-hover>
                            <p slot="title">联系人【{{index+1}}】:</p>
                            <Row style="margin-top: 20px">
                            <i-col span="7">
                                <Form-item label="业务对接联系人" prop="contactName">
                                    <i-input v-model.sync="item.contactName" placeholder="请输入业务对接联系人"></i-input>
                                </Form-item>
                            </i-col>
                            <i-col span="7" offset="1">
                                <Form-item label="手机号码" prop="mobile">
                                    <i-input v-model.sync="item.mobile" placeholder="请输入手机号码"></i-input>
                                </Form-item>
                            </i-col>
                            <i-col span="7" offset="1">
                                <Form-item label="固定电话" prop="telephone">
                                    <i-input v-model.sync="item.telephone" placeholder="请输入固定电话"></i-input>
                                </Form-item>
                            </i-col>
                            <i-col span="7">
                                <Form-item label="职务" prop="duty">
                                    <i-input v-model.sync="item.duty" placeholder="请输入业务对接联系人"></i-input>
                                </Form-item>
                            </i-col>
                            <i-col span="7" offset="1">
                                <Form-item label="QQ号" prop="qqnumber">
                                    <i-input v-model.sync="item.qqnumber" placeholder="请输入手机号码"></i-input>
                                </Form-item>
                            </i-col>
                            <i-col span="7" offset="1">
                                <Form-item label="邮箱" prop="mail">
                                    <i-input v-model.sync="item.mail" placeholder="请输入固定电话"></i-input>
                                </Form-item>
                            </i-col>

                            <i-col span="7">
                                <Form-item label="联系人的上级" prop="companySupName">
                                    <i-input v-model.sync="item.companySupName" placeholder="请输入联系人的上级"></i-input>
                                </Form-item>
                            </i-col>
                            <i-col span="7" offset="1">
                                <Form-item label="手机号码" prop="mobileSup">
                                    <i-input v-model.sync="item.mobileSup" placeholder="请输入手机号码"></i-input>
                                </Form-item>
                            </i-col>
                            <i-col span="7" offset="1">
                                <Form-item label="固定电话" prop="telephoneSup">
                                    <i-input v-model.sync="item.telephoneSup" placeholder="请输入固定电话"></i-input>
                                </Form-item>
                            </i-col>
                            <i-col span="7">
                                <Form-item label="职务" prop="dutySup">
                                    <i-input v-model.sync="item.dutySup" placeholder="请输入业务对接联系人"></i-input>
                                </Form-item>
                            </i-col>
                            <i-col span="7" offset="1">
                                <Form-item label="QQ号" prop="qqnumberSup">
                                    <i-input v-model.sync="item.qqnumberSup" placeholder="请输入手机号码"></i-input>
                                </Form-item>
                            </i-col>
                            <i-col span="7" offset="1">
                                <Form-item label="邮箱" prop="mailSup">
                                    <i-input v-model.sync="item.mailSup" placeholder="请输入固定电话"></i-input>
                                </Form-item>
                            </i-col>

                            <i-col span="7">
                                <Form-item label="城市" prop="contactLocation">
                                    <Cascader
                                            v-model="item.contactLocation"
                                            :data="areaData"
                                            not-found-text="无匹配数据"
                                    ></Cascader>
                                </Form-item>
                            </i-col>
                            <i-col span="15" offset="1">
                                <Form-item label="详情地址" prop="contactDetailedAddress">
                                    <i-input v-model.sync="item.contactDetailedAddress" placeholder="请输入详情地址"></i-input>
                                </Form-item>
                            </i-col>
                            </Row>
                        </Card>
<!--                    </i-col>-->
                    <Row style="margin-top: 20px">
                        <Form-item>
                            <Row>
                                <i-col span="22">
                                    <i-button type="dashed" long @click="handleRemove(item,index)" icon="plus-round">删除联系人【{{index+1}}】</i-button>
                                </i-col>
                            </Row>
                        </Form-item>
                    </Row>
                </Row>
                <Form-item>
                    <Row>
                        <i-col span="22">
                            <i-button type="dashed" long @click="handleAdd" icon="plus-round">新增业务对接联系人</i-button>
                        </i-col>
                    </Row>
                </Form-item>






                <!--<Row  style="margin:30px 0px 30px 0px">
                    <h3>签约信息：</h3>
                </Row>
                <Row>
                    <i-col span="7">
                        <Form-item label="签约销售" prop="name">
                            <i-select v-model.sync="formCompanyDate.signedSalesId" placeholder="请选择签约销售">
                                <i-option value="beijing">一般纳税人</i-option>
                                <i-option value="shanghai">小规模企业</i-option>
                            </i-select>
                        </Form-item>
                    </i-col>
                    <i-col span="7" offset="1">
                        <Form-item label="合同扫描件" prop="contractScanning">
                            <Button icon="ios-cloud-upload-outline">上传附件</Button>
                        </Form-item>
                    </i-col>
                </Row>

                <Row>
                    <i-col span="7">
                        <Form-item label="合同编号" prop="contractNo">
                            <i-input :value.sync="formCompanyDate.contractNo" placeholder="请输入合同编号"></i-input>
                        </Form-item>
                    </i-col>
                    <i-col span="7" offset="1">
                        <Form-item label="合同开始时间" prop="contractStartTime">
                            <Date-picker type="date" placeholder="选择日期" :value.sync="formCompanyDate.contractStartTime"></Date-picker>
                        </Form-item>
                    </i-col>
                    <i-col span="7" offset="1">
                        <Form-item label="合同结束时间" prop="contractEndTime">
                            <Date-picker type="date" placeholder="选择日期" :value.sync="formCompanyDate.contractEndTime"></Date-picker>
                        </Form-item>
                    </i-col>
                </Row>

                <Row>
                    <i-col span="7">
                        <Form-item label="签约公司" prop="contractingCompany">
                            <i-select v-model.sync="formCompanyDate.contractingCompany" placeholder="请选择所在地">
                                <i-option value="beijing">一般纳税人</i-option>
                                <i-option value="shanghai">小规模企业</i-option>
                            </i-select>
                        </Form-item>
                    </i-col>
                    <i-col span="7" offset="1">
                        <Form-item label="服务公司" prop="serviceCompany">
                            <i-select v-model.sync="formCompanyDate.serviceCompany" placeholder="请选择所在地">
                                <i-option value="beijing">一般纳税人</i-option>
                                <i-option value="shanghai">小规模企业</i-option>
                            </i-select>
                        </Form-item>
                    </i-col>
                    <i-col span="7" offset="1">
                        <Form-item label="承接城市" prop="undertakeCity">
                            <i-select v-model.sync="formCompanyDate.undertakeCity" placeholder="请选择所在地">
                                <i-option value="beijing">一般纳税人</i-option>
                                <i-option value="shanghai">小规模企业</i-option>
                            </i-select>
                        </Form-item>
                    </i-col>
                </Row>

                <Row>
                    <i-col span="23">
                        <Form-item label="备注：大协议特殊要求，客户要求，请留问题说明等" prop="comment">
                            <i-input v-model.sync="formCompanyDate.comment" type="textarea" :autosize="{minRows: 3,maxRows: 7}" placeholder="请输入..."></i-input>
                        </Form-item>
                    </i-col>
                </Row>-->

                <Row style="margin:35px 0px 30px 0px">
                    <i-col span="24">
                        <Card dis-hover>
                            <p slot="title">业务内容：</p>
                            <Row style="margin-top: 20px">
                                <i-col span="7">
                                    <Form-item label="责任客服" prop="responsibilityService">

                                        <i-input disabled placeholder="请选择..." v-model.sync="formCompanyDate.responsibilityService">
                                            <i-button slot="append" icon="ios-search" @click="queryUserModelFlg=true"></i-button>
                                        </i-input>
                                    </Form-item>
                                </i-col>
                                <i-col span="7" offset="1">
                                    <Form-item label="社代内部价格" prop="socialSecurityInteriorCharge">
                                        <i-input v-model.sync="formCompanyDate.socialSecurityInteriorCharge" placeholder="请输入社保代理内部价格"></i-input>
                                    </Form-item>
                                </i-col>
                                <i-col span="7" offset="1">
                                    <Form-item label="社代外部价格" prop="socialSecurityExternalCharge">
                                        <i-input v-model.sync="formCompanyDate.socialSecurityExternalCharge" placeholder="请输入社保代理外部价格"></i-input>
                                    </Form-item>
                                </i-col>
                            </Row>

                            <Row>
                                <i-col span="7">
                                    <Form-item label="开户行名称" prop="openingBank">
                                        <i-input v-model.sync="formCompanyDate.openingBank" placeholder="请输入开户行名称"></i-input>
                                    </Form-item>
                                </i-col>
                                <i-col span="7" offset="1">
                                    <Form-item label="银行账号" prop="bankAccount">
                                        <i-input v-model.sync="formCompanyDate.bankAccount" placeholder="请输入银行账号"></i-input>
                                    </Form-item>
                                </i-col>
                                <i-col span="7" offset="1">
                                    <Form-item label="收费方式" prop="chargeType">
                                        <i-select v-model.sync="formCompanyDate.chargeType" placeholder="请选择收费方式">
                                            <i-option :value="1">预收款</i-option>
                                            <i-option :value="2">垫款</i-option>
                                        </i-select>
                                    </Form-item>
                                </i-col>
                            </Row>

                            <Row>
                                <i-col span="7">
                                    <Form-item label="开具发票类型" prop="invoiceType">
                                        <i-select v-model.sync="formCompanyDate.invoiceType" placeholder="请选择开具发票类型">
                                            <i-option :value="1">收据</i-option>
                                            <i-option :value="2">增值税专用发票</i-option>
                                            <i-option :value="3">增值税普通纸质发票</i-option>
                                            <i-option :value="4">增值税普通电子发票</i-option>
                                        </i-select>
                                    </Form-item>
                                </i-col>
                                <i-col span="7" offset="1">
                                    <Form-item label="开票周期" prop="invoicePeriod">
                                        <i-select v-model.sync="formCompanyDate.invoicePeriod" placeholder="请选择开票周期">
                                            <i-option :value="1">月结</i-option>
                                            <i-option :value="2">季结</i-option>
                                        </i-select>
                                    </Form-item>
                                </i-col>
                                <i-col span="7" offset="1">
                                    <Form-item label="开票联系方式" prop="invoiceContacter">
                                        <i-input v-model.sync="formCompanyDate.invoiceContacter" placeholder="请输入开票联系方式"></i-input>
                                    </Form-item>
                                </i-col>
                            </Row>
                        </Card>
                    </i-col>
                </Row>
                <Row>
                    <Form-item align="right" style="margin:50px 45px 45px 0px">
                        <i-button type="primary" @click="handleSubmit('ruleCompanyDate')">提交</i-button>
                        <i-button @click="handleReset()" style="margin-left: 30px">重置</i-button>
                    </Form-item>
                </Row>
            </Form>
        </Row>




        <Modal
                title="选择用户"
                v-model="queryUserModelFlg"
                :mask-closable="false"
                :width="700"
                :styles="{top: '30px'}">
                <Form ref="searchForm" :model="searchForm" inline :label-width="70">
                    <Form-item label="用户名称" prop="username"  style="margin-left:25px;">
                        <Input
                                type="text"
                                v-model="searchForm.username"
                                clearable
                                placeholder="请输入用户名"
                                style="width: 150px"
                        />
                    </Form-item>

                    <Form-item label="部门" prop="department">
                        <department-choose @on-change="handleSelectDep" style="width: 200px" ref="dep"></department-choose>
                    </Form-item>

                    <Form-item style="margin-left:-35px;" class="br">
                        <Button @click="handleSearch" type="primary" icon="ios-search">搜索</Button>
                    </Form-item>
                </Form>

                <Row>
                    <Table
                            border
                            :columns="columns"
                            :data="data"
                            sortable="custom"
                            ref="table"
                            highlight-row
                            @on-current-change="thisUser"
                    ></Table>

                </Row>
                <Row type="flex" justify="end" class="page" style="margin-top:15px;">
                    <Page
                            :current="searchForm.pageNumber"
                            :total="total"
                            :page-size="searchForm.pageSize"
                            @on-change="changePage"
                            @on-page-size-change="changePageSize"
                            :page-size-opts="[10,20,50]"
                            size="small"
                            show-total
                            show-elevator
                            show-sizer
                    ></Page>
                </Row>

                <div slot="footer">
                    <Row>
                        <i-col span="24" >
                            <i-button @click="queryUserModelFlg=false">关闭</i-button>
                            <i-button @click="confirmUser">选择</i-button>
                        </i-col>
                    </Row>
                </div>
        </Modal>

    </div>
</template>

<script>
    import {mapState, mapGetters, mapActions} from 'vuex';
    import companyTypes from "../../store/event-types/pgyhr-company/company-types";

    import {
        getUserListData
    } from "@/api/index";
    import departmentChoose from "../my-components/pgyhr/department-choose";
    import expandRow from "../sys/user-manage/expand";
    import areaTypes from "../../store/event-types/common/area_types";
    import countryTypes from "../../store/event-types/common/country_types";
    export default {
        components: {
            departmentChoose
        },
        data() {
            return {
                socialSecurityAgentBoole:false,
                housingFundAgentBoole:false,
                companyty:false ,
                level:0,
                queryUserModelFlg:false,
                controllingCompany:{

                },
                /*from内容*/
                formCompanyDate: {
                    companyLevel:1,
                    companyParentid:'',
                    companyName: '',
                    taxTypes: '',
                    companyRegisteredLocation: [],
                    detailedAddressRegistered:'',
                    companyRealityLocation:[],
                    detailedAddressReality:'',

                    socialSecurityAgent:0,
                    pensionAccount:'',
                    medicalAccount:'',
                    unemploymentAccount:'',
                    inductrialInjuryAccounts:'',
                    familyAccount:'',
                    housingFundAgent:0,
                    basicHousingFundAgent:'',
                    replenishHousingFundAgent:'',

                    /*signedSalesId:'',
                    contractNo:'',
                    contractStartTime:'',
                    contractEndTime:'',
                    contractingCompany:'',
                    serviceCompany:'',
                    undertakeCity:'',
                    comment:'',*/

                    responsibilityServiceId:'',
                    responsibilityService:'',
                    socialSecurityInteriorCharge:'',
                    socialSecurityExternalCharge:'',
                    openingBank:'',
                    bankAccount:'',
                    chargeType:1,
                    invoiceType:'',
                    invoicePeriod:'',
                    invoiceContacter:'',

                    /*业务对接联系人*/
                    companyContactsDTOList: [
                        /*{
                            companyCode: this.$route.query.data,
                            contactName: '',
                            mobile:'',
                            telephone:'',
                            duty:'',
                            qqnumber:'',
                            mail:'',
                            companySupName:'',
                            mobileSup:'',
                            telephoneSup:'',
                            dutySup:'',
                            qqnumberSup:'',
                            mailSup:'',
                            contactLocation:[],
                            contactDetailedAddress:''
                        }*/
                    ],

                },
                ruleCompanyDate:{
                    companyName: [
                        { required: true, message: "客户名称不能为空", trigger: "blur" }
                    ],
                },


                /*用户*/
                searchForm: {
                    username: "",
                    departmentId: "",
                    pageNumber: 1,
                    pageSize: 5,
                },
                columns: [
                    {
                        title: "用户名",
                        key: "username",
                        width: 150,
                        align: "center",
                    },
                    {
                        title: "头像",
                        key: "avatar",
                        width: 95,
                        align: "center",
                        render: (h, params) => {
                            return h("Avatar", {
                                props: {
                                    src: params.row.avatar
                                }
                            });
                        }
                    },
                    {
                        title: "所属部门",
                        key: "departmentTitle",
                        width: 150,
                        align: "center",
                    },
                    {
                        title: "性别",
                        key: "sex",
                        width: 120,
                        align: "center"
                    },
                    {
                        title: "状态",
                        key: "status",
                        align: "center",
                        width: 150,
                        render: (h, params) => {
                            if (params.row.status == 0) {
                                return h("div", [
                                    h("Badge", {
                                        props: {
                                            status: "success",
                                            text: "正常启用"
                                        }
                                    })
                                ]);
                            } else if (params.row.status == -1) {
                                return h("div", [
                                    h("Badge", {
                                        props: {
                                            status: "error",
                                            text: "禁用"
                                        }
                                    })
                                ]);
                            }
                        },
                        filters: [
                            {
                                label: "正常启用",
                                value: 0
                            },
                            {
                                label: "禁用",
                                value: -1
                            }
                        ],
                        filterMultiple: false,
                        filterMethod(value, row) {
                            if (value == 0) {
                                return row.status == 0;
                            } else if (value == -1) {
                                return row.status == -1;
                            }
                        }
                    },
                ],
                data: [],
                total: 0,
                thisId:"",
                thisName:""
            }
        },
        created(){
            this.getCompanyLevel()
            if(this.$route.query.data!=""&&this.$route.query.data!=undefined){
                this.getCompanyAndContactsByCode()
            }
        },
        computed: {
            ...mapState('areaModule', {
                areaData: state => state.areaData
            }),
            companyLevelType(){
                if(this.formCompanyDate.companyLevel==0){
                    this.companyty=true;
                    this.formCompanyDate.companyParentid="";
                }else{
                    this.companyty=false;
                    this.formCompanyDate.companyParentid="";
                }
            },
        },
        methods: {
            ...mapActions('companyModule', [
                companyTypes.ADD_COMPANY,
                companyTypes.COMPANY_PAGE,
                companyTypes.COMPANY_LEVEL,
                companyTypes.COMPANY_CODE,
                companyTypes.UPDATE_COMPANY
            ]),
            ...mapActions('areaModule', [areaTypes.AREA_DATA,areaTypes.ALL_AREA_DATA]),
            async areasData(){
                await this[areaTypes.AREA_DATA]("CN");
                await this[areaTypes.ALL_AREA_DATA]("CN");
            },

            getCompanyLevel(){
                this[companyTypes.COMPANY_LEVEL]({level:this.level}).then((response)=>{
                    this.controllingCompany=response.result;
                    console.log(response.result)
                })
            },

            //根据code带出客户主从表信息
            getCompanyAndContactsByCode(){
                this[companyTypes.COMPANY_CODE]({compamyCode:this.$route.query.data}).then((response)=>{
                    response.result.companyRegisteredLocation=JSON.parse(response.result.companyRegisteredLocation);
                    response.result.companyRealityLocation=JSON.parse(response.result.companyRealityLocation);
                    if(response.result.companyContactsDTOList.length!=null){
                        for (var i=0;i<response.result.companyContactsDTOList.length;i++){
                            response.result.companyContactsDTOList[i].contactLocation = JSON.parse(response.result.companyContactsDTOList[i].contactLocation)
                        }
                    }
                    this.formCompanyDate = response.result;
                })
            },

            handleSubmit (name) {
                let data = this.formCompanyDate;
                data.companyRegisteredLocation = JSON.stringify(this.formCompanyDate.companyRegisteredLocation);
                data.companyRealityLocation = JSON.stringify(this.formCompanyDate.companyRealityLocation);
                if(this.formCompanyDate.companyContactsDTOList.length!=null) {
                    for (var i = 0; i < this.formCompanyDate.companyContactsDTOList.length; i++) {
                        data.companyContactsDTOList[i].contactLocation = JSON.stringify(this.formCompanyDate.companyContactsDTOList[i].contactLocation);
                    }
                }
                console.log(data.companyContactsDTOList)
                if(this.$route.query.data!=""&&this.$route.query.data!=undefined){
                    this[companyTypes.UPDATE_COMPANY](data).then((response)=>{
                        if(response.code==200){
                            this.$Message.success('修改成功');
                            this.$router.push("/company/company-manage");
                        }
                    }).catch((error) => {
                        this.$Notice.error({
                            title: title,
                            content: title + "错误"
                        });
                    });
                }else{
                    this[companyTypes.ADD_COMPANY](data).then((response)=>{
                        if(response.code==200){
                            this.$Message.success('新增成功');
                            this.$router.push("/company/company-manage");
                        }
                    }).catch((error) => {
                        this.$Notice.error({
                            title: title,
                            content: title + "错误"
                        });
                    });
                }
            },

            handleAdd () {
                this.formCompanyDate.companyContactsDTOList.push({
                    companyCode: this.$route.query.data,
                    contactName: '',
                    mobile:'',
                    telephone:'',
                    duty:'',
                    qqnumber:'',
                    mail:'',
                    companySupName:'',
                    mobileSup:'',
                    telephoneSup:'',
                    dutySup:'',
                    qqnumberSup:'',
                    mailSup:'',
                    contactLocation:[],
                    contactDetailedAddress:''
                });
            },
            handleRemove (item,index) {
                console.log(item);
                console.log(this.formCompanyDate.companyContactsDTOList);
                this.formCompanyDate.companyContactsDTOList.splice(index,1);
            },
            handleSelectDep(v) {
                this.searchForm.departmentId = v;
            },
            getUserList() {
                // 多条件搜索用户列表
                this.loading = true;
                // 避免后端默认值
                if (!this.searchForm.type) {
                    this.searchForm.type = " ";
                }
                if (!this.searchForm.status) {
                    this.searchForm.status = " ";
                }
                getUserListData(this.searchForm).then(res => {
                    this.loading = false;
                    if (res.success) {
                        this.data = res.result.content;
                        //this.total = res.result.totalElements;
                    }
                });
            },
            handleSearch() {
                this.searchForm.pageNumber = 1;
                this.searchForm.pageSize = 5;
                this.getUserList();
            },
            changePage(v) {
                this.searchForm.pageNumber = v;
                this.getUserList();
                this.clearSelectAll();
            },
            changePageSize(v) {
                this.searchForm.pageSize = v;
                this.getUserList();
            },
            thisUser(currentRow, oldCurrentRow){
                this.thisId=currentRow.id;
                this.thisName=currentRow.username;
            },
            confirmUser(){
                this.formCompanyDate.responsibilityServiceId=this.thisId;
                this.formCompanyDate.responsibilityService=this.thisName;
                this.queryUserModelFlg=false;
            }
        },
        watch: {
            socialSecurityAgentBoole() {
                if(this.socialSecurityAgentBoole==false){
                    this.formCompanyDate.socialSecurityAgent=0;
                }else {
                    this.formCompanyDate.socialSecurityAgent=1;
                }
                console.log(this.formCompanyDate.socialSecurityAgent);
            },
            housingFundAgentBoole(){
                if(this.housingFundAgentBoole==false){
                    this.formCompanyDate.housingFundAgent=0;
                }else {
                    this.formCompanyDate.housingFundAgent=1;
                }
                console.log(this.formCompanyDate.housingFundAgent);
            }
        },
        mounted() {
            this.getUserList();
            this.areasData();
        }
    }

</script>