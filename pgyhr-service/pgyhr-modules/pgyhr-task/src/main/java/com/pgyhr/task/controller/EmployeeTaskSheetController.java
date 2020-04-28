package com.pgyhr.task.controller;

import com.pgyhr.core.common.utils.CommonTransform;
import com.pgyhr.core.common.utils.ResultUtil;
import com.pgyhr.core.common.vo.Result;
import com.pgyhr.task.entity.dto.EmpFrontTaskSheetSocialFeeSegmentForSocialInfoDTO;
import com.pgyhr.task.entity.dto.EmpFrontTaskSheetSocialFeeSegmentRequestDTO;
import com.pgyhr.task.entity.dto.EmployeeInfoRequsetDTO;
import com.pgyhr.task.entity.dto.SocialPolicyTemplateResponeDTO;
import com.pgyhr.task.entity.po.EmpFrontTaskSheetSocialFeeSegmentPO;
import com.pgyhr.task.entity.po.EmployeeInfoPO;
import com.pgyhr.task.entity.po.SocialPolicyTemplateItemPO;
import com.pgyhr.task.service.EmpFrontTaskSheetSocialFeeSegmentService;
import com.pgyhr.task.service.EmployeeInfoService;
import com.pgyhr.task.service.SocialPolicyTemplateItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api(description = "雇员任务单")
@RequestMapping("/pgyhr/task")
@Transactional
public class EmployeeTaskSheetController<E, ID extends Serializable>{

    @Autowired
    private EmployeeInfoService employeeInfoService;

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
}
