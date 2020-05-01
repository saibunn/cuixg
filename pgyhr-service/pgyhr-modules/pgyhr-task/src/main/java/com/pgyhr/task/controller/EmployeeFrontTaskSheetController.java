package com.pgyhr.task.controller;

import com.pgyhr.core.common.utils.CommonTransform;
import com.pgyhr.core.common.utils.CommonUtil;
import com.pgyhr.core.common.utils.ResultUtil;
import com.pgyhr.core.common.vo.Result;
import com.pgyhr.task.entity.CodePrefixUtil;
import com.pgyhr.task.entity.dto.*;
import com.pgyhr.task.entity.po.*;
import com.pgyhr.task.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author cuixg
 * @title: EmployeeTaskSheetController
 * @projectName pgyhr-module
 * @description: TODO
 * @date 2020/4/20 19:50
 */
@Slf4j
@RestController
@Api(description = "雇员前道任务单")
@RequestMapping("/pgyhr/front/task")
@Transactional
public class EmployeeFrontTaskSheetController<E, ID extends Serializable>{

    @Autowired
    private EmployeeInfoService employeeInfoService;

    @Autowired
    private EmpCompanyService empCompanyService;

    @Autowired
    private EmpFrontTaskSheetServiceAgreementService empFrontTaskSheetServiceAgreementService;

    @Autowired
    private EmpFrontTaskSheetService  empFrontTaskSheetService;

    @Autowired
    private SocialPolicyTemplateItemService socialPolicyTemplateItemService;

    @Autowired
    private EmpFrontTaskSheetSocialFeeSegmentService empFrontTaskSheetSocialFeeSegmentService;

    @RequestMapping(value = "/getEmployeeInfoById",method = RequestMethod.GET)
    @ApiOperation(value = "根据雇员ID取雇员信息")
    public Result<EmployeeInfoPO> getEmployeeInfoById(EmployeeInfoRequsetDTO employeeInfoRequsetDTO){
        EmployeeInfoPO employeeInfoPO = employeeInfoService.getById(employeeInfoRequsetDTO.getEmployeeId());
        return new ResultUtil<EmployeeInfoPO>().setData(employeeInfoPO);
    }

    @ApiOperation(value = "新增雇员信息")
    @PostMapping(value = "/addEmployeeInfo")
    public Result<E> addEmployeeInfoById(@RequestBody EmployeeInfoRequsetDTO employeeInfoRequsetDTO){
        EmployeeInfoPO employeeInfoPO = CommonTransform.convertToDTO(employeeInfoRequsetDTO,EmployeeInfoPO.class);
        if(employeeInfoService.save(employeeInfoPO)){
            return new ResultUtil<E>().setSuccessMsg("新增雇员成功！");
        }else{
            return new ResultUtil<E>().setErrorMsg("新增雇员失败！");
        }
    }


    @ApiOperation(value = "根据条件取社保政策")
    @RequestMapping(value = "/getEmpFrontTaskSheetSocialFeeSegmentByParam",method = RequestMethod.GET)
    public Result<List<EmpFrontTaskSheetSocialFeeSegmentForSocialInfoDTO>> getEmpFrontTaskSheetSocialFeeSegmentByParam(EmpFrontTaskSheetSocialFeeSegmentRequestDTO empFrontTaskSheetSocialFeeSegmentRequestDTO){

        List<EmpFrontTaskSheetSocialFeeSegmentForSocialInfoDTO> empFrontTaskSheetSocialFeeSegmentForSocialInfoDTOList = new ArrayList<>();
        if(empFrontTaskSheetSocialFeeSegmentRequestDTO.getRequestType() == 0){
            List<SocialPolicyTemplateItemPO> socialPolicyTemplateItemPOList =
                    socialPolicyTemplateItemService.getSocialPolicyTemplateItemByParentIds(empFrontTaskSheetSocialFeeSegmentRequestDTO);

            if(!CollectionUtils.isEmpty(socialPolicyTemplateItemPOList)){
                String socials[] = new String[] {
                        "养老保险","医疗保险","工伤保险","生育保险","失业保险","公积金","补充公积金"
                };
                String itemCodes[] = new String[] {
                        "DIT00042","DIT00043","DIT00044","DIT00045","DIT00046","DIT00057","DIT00058"
                };

                //没有历史任务单机构社保的情况，添加五险二金空数据
                for (int i = 0;i<socials.length;i++) {
                    //公司
                    SocialPolicyTemplateItemPO comSocialPolicyTemplateItemPO = getSocialPolicyTemplateItemPOByParam(socialPolicyTemplateItemPOList,itemCodes[i],1);

                    //个人
                    SocialPolicyTemplateItemPO perSocialPolicyTemplateItemPO = getSocialPolicyTemplateItemPOByParam(socialPolicyTemplateItemPOList,itemCodes[i],2);

                    EmpFrontTaskSheetSocialFeeSegmentForSocialInfoDTO frontTaskSheetSocialFeeSegmentForSocialInfoDTO = new EmpFrontTaskSheetSocialFeeSegmentForSocialInfoDTO();
                    //数据字典CODE
                    frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setItemCode(itemCodes[i]);
                    //社保项目名称
                    frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setItemName(socials[i]);
                    //社保类型
                    if ("DIT00057".equals(itemCodes[i])) {
                        frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setPolicyType(2);
                    } else if ("DIT00058".equals(itemCodes[i])) {
                        frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setPolicyType(3);
                    } else {
                        frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setPolicyType(1);
                    }
                    //缴纳开始月(yyyy-MM格式)
                    frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setStartDate(empFrontTaskSheetSocialFeeSegmentRequestDTO.getStarDate());
                    //公司基数
                    frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setCompanyBase(new BigDecimal(0));
                    //公司比例
                    if(comSocialPolicyTemplateItemPO.getRateType() == 1){
                        frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setCompanyRatio(comSocialPolicyTemplateItemPO.getFixedRate());
                    }
                    //公司金额
                    frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setCompanyAmount(new BigDecimal(0));
                    //公司固定金额
                    frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setCompanyFixAmount(comSocialPolicyTemplateItemPO.getFixedValue());
                    //雇员基数
                    frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setEmpCompanyBase(new BigDecimal(0));
                    //个人基数
                    frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setPersonalBase(new BigDecimal(0));
                    //个人比例
                    if(perSocialPolicyTemplateItemPO.getRateType() == 1){
                        frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setPersonalRatio(perSocialPolicyTemplateItemPO.getFixedRate());
                    }
                    //个人金额
                    frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setPersonalAmount(new BigDecimal(0));
                    //个人固定金额
                    frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setPersonalFixAmount(perSocialPolicyTemplateItemPO.getFixedValue());
                    //总金额
                    frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setTotalAmount(new BigDecimal(0));

                    //市平均工资
                    frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setCityAvgSalary(comSocialPolicyTemplateItemPO.getCityAvgSalary());
                    //省平均工资
                    frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setProvinceAvgSalary(comSocialPolicyTemplateItemPO.getProvinceAvgSalary());
                    //最低工资
                    frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setMinSalary(comSocialPolicyTemplateItemPO.getMinSalary());
                    //公司基数上限，如果无上限则存null
                    frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setCompanyBaseMax(comSocialPolicyTemplateItemPO.getBaseMax());
                    //公司基数下限,当IsCombined=1时有效
                    frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setCompanyBaseMin(comSocialPolicyTemplateItemPO.getBaseMin());
                    //个人基数上限，如果无上限则存null
                    frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setPersonalBaseMax(perSocialPolicyTemplateItemPO.getBaseMax());
                    //个人基数下限,当IsCombined=1时有效
                    frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setPersonalBaseMin(perSocialPolicyTemplateItemPO.getBaseMin());
                    //公司缴费比例类型 :1-固定比例,2-区间比例(有上下限,3-多值(多个比例值中选一个)
                    frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setCompanyRateType(comSocialPolicyTemplateItemPO.getRateType());
                    //个人缴费比例类型 :1-固定比例,2-区间比例(有上下限,3-多值(多个比例值中选一个)
                    frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setPersonalRateType(perSocialPolicyTemplateItemPO.getRateType());
                    //公司比例多值,RateType=3时有效
                    if(perSocialPolicyTemplateItemPO.getRateType() == 3){
                        frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setCompanyRatioList(Arrays.asList(comSocialPolicyTemplateItemPO.getMultiRate().split(",")));
                    }

                    //个人比例多值,RateType=3时有效
                    if(perSocialPolicyTemplateItemPO.getRateType() == 3){
                        frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setCompanyRatioList(Arrays.asList(perSocialPolicyTemplateItemPO.getMultiRate().split(",")));
                    }
                    //公司小数进位方式:1见分进角，2见角进元，3进位到元，4进位偶数，5舍去角，6舍去分，7舍去厘，8四舍五入到分，9四舍五入到角，10四舍五入到元
                    frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setCompanyRoundType(comSocialPolicyTemplateItemPO.getRoundType());
                    //个人小数进位方式:1见分进角，2见角进元，3进位到元，4进位偶数，5舍去角，6舍去分，7舍去厘，8四舍五入到分，9四舍五入到角，10四舍五入到元
                    frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setPersonalRoundType(perSocialPolicyTemplateItemPO.getRoundType());
                    //生效月份,当IsCombined=1时有效
                    frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setEffectiveMonth(comSocialPolicyTemplateItemPO.getEffectiveMonth());
                    //所属社保年份
                    frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setPolicyYear(comSocialPolicyTemplateItemPO.getPolicyYear());
                    //固定支付月份：1-12的数字，如果每月支付就是0
                    frontTaskSheetSocialFeeSegmentForSocialInfoDTO.setPayMonth(comSocialPolicyTemplateItemPO.getPayMonth());


                    empFrontTaskSheetSocialFeeSegmentForSocialInfoDTOList.add(frontTaskSheetSocialFeeSegmentForSocialInfoDTO);
                }

            }

        }else{
            //todo 取费用段数据
        }
        return new ResultUtil<List<EmpFrontTaskSheetSocialFeeSegmentForSocialInfoDTO>>().setData(empFrontTaskSheetSocialFeeSegmentForSocialInfoDTOList);
    }

    private SocialPolicyTemplateItemPO getSocialPolicyTemplateItemPOByParam(List<SocialPolicyTemplateItemPO> socialPolicyTemplateItemPOList,String itemCode,Integer payer){

        SocialPolicyTemplateItemPO socialPolicyTemplateItemPO = socialPolicyTemplateItemPOList.stream().filter(a -> (a.getPayer() == payer && itemCode.equals(a.getItemCode()))).findFirst().orElse(null);
        return socialPolicyTemplateItemPO==null?new SocialPolicyTemplateItemPO():socialPolicyTemplateItemPO;
    }

    @ApiOperation(value = "新增雇员前道任务单")
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @PostMapping(value = "/saveNewEmployeeTaskSheetInfo")
    public Result<E> saveNewEmployeeTaskSheetInfo(@RequestBody EmpFrontTaskSaveRequestDTO empFrontTaskSaveRequestDTO){
        Boolean saveResult = false;
        EmpCompanyPO addEmpCompanyPO = empFrontTaskSaveRequestDTO.getEmpCompanyPO();
        addEmpCompanyPO.setEmpCompanyId(CommonUtil.buildId(CodePrefixUtil.ECO_CODE_PREFIX));
        //雇员公司信息表保存
        boolean saveEmpCompanyResult = empCompanyService.save(addEmpCompanyPO);
        if(saveEmpCompanyResult){
            //生成雇员任务单
            EmpFrontTaskSheetPO addEmpFrontTaskSheetPO = new EmpFrontTaskSheetPO();
            //雇员前道任务单ID
            addEmpFrontTaskSheetPO.setEmpFrontTaskSheetCode(CommonUtil.buildId(CodePrefixUtil.EFT_CODE_PREFIX));
            //任务单域
            addEmpFrontTaskSheetPO.setTaskArea(0);
            //任务单状态:0-后道批退,1-前道提交,2-后道处理,3-后道部分完成,4-后道完成,
            addEmpFrontTaskSheetPO.setTaskStatus(1);
            //任务单类型:0-新增,1-调整,2-年度调整,3-终止,4-一次性费用,5-服务费调整
            addEmpFrontTaskSheetPO.setTaskType(0);
            //社保城市code
            addEmpFrontTaskSheetPO.setSocialCityCode(addEmpCompanyPO.getSocialCityCode());
            //社保城市名称
            addEmpFrontTaskSheetPO.setSocialCityName(addEmpCompanyPO.getSocialCityName());
            //公积金城市code
            addEmpFrontTaskSheetPO.setFundCityCityCode(addEmpCompanyPO.getFundCityCode());
            //公积金城市名称
            addEmpFrontTaskSheetPO.setFundCityCityName(addEmpCompanyPO.getFundCityName());
            //补充公积金城市code
            addEmpFrontTaskSheetPO.setAddFundCityCityCode(addEmpCompanyPO.getFundCityCode());
            //补充公积金社保城市名称
            addEmpFrontTaskSheetPO.setAddFundCityCityName(addEmpCompanyPO.getFundCityName());
            //委托机构ID
            //addEmpFrontTaskSheetPO.setEntrustOrganizationId();
            //委托机构名称
            //addEmpFrontTaskSheetPO.setEntrustOrganizationName();
            //客户雇员ID
            addEmpFrontTaskSheetPO.setEmpCompanyId(addEmpCompanyPO.getEmpCompanyId());
            //雇员编号
            addEmpFrontTaskSheetPO.setEmployeeId(addEmpCompanyPO.getEmployeeId());
            //雇员姓名
            addEmpFrontTaskSheetPO.setEmployeeName(addEmpCompanyPO.getEmployeeName());
            //公司ID
            addEmpFrontTaskSheetPO.setCompanyId(addEmpCompanyPO.getCompanyId());
            //公司名称
            addEmpFrontTaskSheetPO.setCompanyName(addEmpCompanyPO.getCompanyName());
            //办理用工日期
            addEmpFrontTaskSheetPO.setEmploymentDate(addEmpCompanyPO.getInDate());
            //合同开始日期
            addEmpFrontTaskSheetPO.setContractStartDate(addEmpCompanyPO.getLaborStartDate());
            //合同结束日期
            addEmpFrontTaskSheetPO.setContractEndDate(addEmpCompanyPO.getLaborEndDate());
            //雇员社保账号
            addEmpFrontTaskSheetPO.setEmployeesSocialAccount(empFrontTaskSaveRequestDTO.getEmployeeInfoPO().getSocialAccount());
            //雇员公积金账号
            addEmpFrontTaskSheetPO.setEmployeesFundAccount(empFrontTaskSaveRequestDTO.getEmployeeInfoPO().getFundAccount());
            //雇员补充公积金账号
            addEmpFrontTaskSheetPO.setEmployeesAddFundAccount(empFrontTaskSaveRequestDTO.getEmployeeInfoPO().getAddFundAccount());
            //社保福利办理方:1: 独立户, 2: 大库
            addEmpFrontTaskSheetPO.setSocialUnit(addEmpCompanyPO.getSocialUnit());
            //公积金福利办理方:1: 独立户, 2: 大库
            addEmpFrontTaskSheetPO.setFundUnit(addEmpCompanyPO.getFundUnit());
            //用退工福利办理方:1: 独立户, 2: 大库
            addEmpFrontTaskSheetPO.setHireUnit(addEmpCompanyPO.getHireUnit());
            //todo 服务产品
//            //服务产品反馈状态:0-取消委托，1-委托成功，2-委托办理
//            addEmpFrontTaskSheetPO.setServiceProductStatus(2);
//            //服务产品反馈日期
//            addEmpFrontTaskSheetPO.setServiceProductStatusDate();
//            //服务产品执行年月
//            addEmpFrontTaskSheetPO.setServiceProductStartDate();
//            //服务产品结束年月
//            addEmpFrontTaskSheetPO.setServiceProductEndDate();
            //档案所在地
            addEmpFrontTaskSheetPO.setFileAddress(empFrontTaskSaveRequestDTO.getEmployeeInfoPO().getFileAddress());
            //todo 档案和额外费用
//            //档案保管费
//            addEmpFrontTaskSheetPO.setFileKeepFee();
//            //档案保管费反馈状态:0-取消委托，1-委托成功，2-委托办理
//            addEmpFrontTaskSheetPO.setFileKeepFeeStatus();
//            //档案保管费反馈日期
//            addEmpFrontTaskSheetPO.setFileKeepFeeStatusDate();
//            //档案费执行年月
//            addEmpFrontTaskSheetPO.setFileKeepFeeStartDate();
//            //档案费结束年月
//            addEmpFrontTaskSheetPO.setFileKeepFeeEndDate();
//            //额外费用
//            addEmpFrontTaskSheetPO.setOtherFee();
//            //额外费用反馈状态:0-取消委托，1-委托成功，2-委托办理
//            addEmpFrontTaskSheetPO.setOtherFeeStatus();
//            //额外费用反馈日期
//            addEmpFrontTaskSheetPO.setOtherFeeStatusDate();
//            //额外费用执行年月
//            addEmpFrontTaskSheetPO.setOtherFeeStartDate();
//            //额外费用结束年月
//            addEmpFrontTaskSheetPO.setOtherFeeEndDate();
            //实际工资
            addEmpFrontTaskSheetPO.setActualWage(addEmpCompanyPO.getSalary());
            //服务费
            addEmpFrontTaskSheetPO.setServiceFee(new BigDecimal(20));

            boolean saveAddEmpFrontTaskSheetPOResult = empFrontTaskSheetService.save(addEmpFrontTaskSheetPO);

            if(saveAddEmpFrontTaskSheetPOResult){
                //前道任务单服务约定表
                if(empFrontTaskSheetServiceAgreementService.saveEmpFrontTaskSheetServiceAgreement(addEmpCompanyPO,addEmpFrontTaskSheetPO) != 1){
                    log.error("前道任务单服务约定表保存失败:" + addEmpFrontTaskSheetPO.toString());
                }
                //前道任务单社保费用段表
                List<EmpFrontTaskSheetSocialFeeSegmentPO> empFrontTaskSheetSocialFeeSegmentPOList =
                        CommonTransform.convertToDTOs(empFrontTaskSaveRequestDTO.getEmpFrontTaskSheetSocialFeeSegmentForSocialInfoDTOList(),EmpFrontTaskSheetSocialFeeSegmentPO.class);

                if(!CollectionUtils.isEmpty(empFrontTaskSheetSocialFeeSegmentPOList)){

                    empFrontTaskSheetSocialFeeSegmentPOList.stream().forEach(item->item.setEmpFrontTaskSheetCode(addEmpFrontTaskSheetPO.getEmpFrontTaskSheetCode()));
                    if(!empFrontTaskSheetSocialFeeSegmentService.saveBatch(empFrontTaskSheetSocialFeeSegmentPOList)){
                        log.error("前道任务单社保费用段表表保存失败:" + addEmpFrontTaskSheetPO.toString());
                    }
                }
                saveResult = true;
            }
        }

        if(saveResult){
            return new ResultUtil<E>().setSuccessMsg("雇员新增任务单成功！");
        }else{
            return new ResultUtil<E>().setErrorMsg("雇员新增任务单失败！");
        }
    }
}
