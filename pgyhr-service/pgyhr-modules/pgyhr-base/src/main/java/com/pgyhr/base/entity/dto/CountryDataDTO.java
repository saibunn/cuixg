package com.pgyhr.base.entity.dto;

import lombok.Data;

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
@Data
public class CountryDataDTO implements Serializable {


    private static final long serialVersionUID = -1875219915515928286L;
    private Integer id;

    private String name;

    private String code;

    private Integer pid;

    private Integer layer;


}
