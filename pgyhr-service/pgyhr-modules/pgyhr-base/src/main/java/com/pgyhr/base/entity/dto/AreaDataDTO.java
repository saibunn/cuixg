package com.pgyhr.base.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 地区码表
 * </p>
 *
 * @author cuixiaoguang
 * @since 2020-04-08
 */
public class AreaDataDTO extends Model<AreaDataDTO> {

    private static final long serialVersionUID=1L;

    /**
     * 地区Id
     */
    private Integer areaId;

    /**
     * 地区编码
     */
    private String areaCode;
    /**
     * 地区名
     */
    private String areaName;

    private List<AreaDTO> areaDTOList;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public List<AreaDTO> getAreaDTOList() {
        return areaDTOList;
    }

    public void setAreaDTOList(List<AreaDTO> areaDTOList) {
        this.areaDTOList = areaDTOList;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }
}
