package com.sz.core.common.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 分页查询基础类
 *
 * @author sz
 * @since 2022/8/25 15:58
 */
@Data
public class PageQuery {

    {
        page = 1;
        limit = 10;
    }

    @Schema(description = "页数", example = "1")
    private Integer page;

    @Schema(description = "每页条数", example = "10")
    private Integer limit;

}
