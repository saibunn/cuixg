package com.pgyhr.task.entity.dto;


import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author cuixg
 * @title: CommonListDTO
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/5  12:33
 */
@Data
public class CommonListDTO {
    @NotNull(message = "当前页不能为空")
    @Min(value = 1, message = "当前页不能小于1")
    private Integer currentPage = 1;

    @NotNull(message = "每页显示数量不能为空")
    @Max(value = 50, message = "每页显示数量最多为50")
    private Integer size = 10;

}
