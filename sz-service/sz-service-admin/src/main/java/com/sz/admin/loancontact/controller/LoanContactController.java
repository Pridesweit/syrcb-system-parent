package com.sz.admin.loancontact.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import com.sz.core.common.entity.ApiPageResult;
import com.sz.core.common.entity.ApiResult;
import com.sz.core.common.constant.GlobalConstant;
import com.sz.core.common.entity.PageResult;
import com.sz.core.common.entity.SelectIdsDTO;
import com.sz.admin.loancontact.service.LoanContactService;
import com.sz.admin.loancontact.pojo.dto.LoanContactCreateDTO;
import com.sz.admin.loancontact.pojo.dto.LoanContactUpdateDTO;
import com.sz.admin.loancontact.pojo.dto.LoanContactListDTO;
import com.sz.admin.loancontact.pojo.vo.LoanContactVO;
import com.sz.core.common.entity.ImportExcelDTO;
import jakarta.servlet.http.HttpServletResponse;

/**
 * <p>
 *  Controller
 * </p>
 *
 * @author sz-admin
 * @since 2025-02-22
 */
@Tag(name =  "")
@RestController
@RequestMapping("loan-contact")
@RequiredArgsConstructor
public class LoanContactController  {

    private final LoanContactService loanContactService;

    @Operation(summary = "新增")
    @SaCheckPermission(value = "loan.contact.create")
    @PostMapping
    public ApiResult<Void> create(@RequestBody LoanContactCreateDTO dto) {
        loanContactService.create(dto);
        return ApiResult.success();
    }

    @Operation(summary = "修改")
    @SaCheckPermission(value = "loan.contact.update")
    @PutMapping
    public ApiResult<Void> update(@RequestBody LoanContactUpdateDTO dto) {
        loanContactService.update(dto);
        return ApiResult.success();
    }

    @Operation(summary = "删除")
    @SaCheckPermission(value = "loan.contact.remove")
    @DeleteMapping
    public ApiResult<Void> remove(@RequestBody SelectIdsDTO dto) {
        loanContactService.remove(dto);
        return ApiResult.success();
    }

    @Operation(summary = "列表查询")
    @SaCheckPermission(value = "loan.contact.query_table")
    @GetMapping
    public ApiResult<PageResult<LoanContactVO>> list(LoanContactListDTO dto) {
        return ApiPageResult.success(loanContactService.page(dto));
    }

    @Operation(summary = "详情")
    @SaCheckPermission(value = "loan.contact.query_table")
    @GetMapping("/{id}")
    public ApiResult<LoanContactVO> detail(@PathVariable Object id) {
        return ApiResult.success(loanContactService.detail(id));
    }

    @Operation(summary = "导入")
    @Parameters({
      @Parameter(name = "file", description = "上传文件", schema = @Schema(type = "string", format = "binary"), required = true),
    })
    @SaCheckPermission(value = "loan.contact.import")
    @PostMapping("/import")
    public void importExcel(@ModelAttribute ImportExcelDTO dto) {
        loanContactService.importExcel(dto);
    }

    @Operation(summary = "导出")
    @SaCheckPermission(value = "loan.contact.export")
    @PostMapping("/export")
    public void exportExcel(@RequestBody LoanContactListDTO dto, HttpServletResponse response) {
        loanContactService.exportExcel(dto, response);
    }
}