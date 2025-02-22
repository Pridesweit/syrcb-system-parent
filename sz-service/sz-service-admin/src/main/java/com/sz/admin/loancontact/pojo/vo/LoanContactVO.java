package com.sz.admin.loancontact.pojo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import cn.idev.excel.annotation.ExcelIgnore;
import cn.idev.excel.annotation.ExcelProperty;

/**
 * <p>
 * LoanContact返回vo
 * </p>
 *
 * @author sz-admin
 * @since 2025-02-22
 */
@Data
@Schema(description = "LoanContact返回vo")
public class LoanContactVO {

    @ExcelIgnore
    @Schema(description =  "主键ID")
    private Long id;

    @ExcelProperty(value = "签约机构")
    @Schema(description =  "签约机构")
    private String signingInstitution;

    @ExcelProperty(value = "客户类型")
    @Schema(description =  "客户类型")
    private String customerType;

    @ExcelProperty(value = "客户名称")
    @Schema(description =  "客户名称")
    private String customerName;

    @ExcelProperty(value = "证件号码")
    @Schema(description =  "证件号码")
    private String idNumber;

    @ExcelProperty(value = "客户号")
    @Schema(description =  "客户号")
    private String customerNumber;

    @ExcelProperty(value = "业务品种")
    @Schema(description =  "业务品种")
    private String businessType;

    @ExcelProperty(value = "合同编号")
    @Schema(description =  "合同编号")
    private String contractId;

    @ExcelProperty(value = "合同类型")
    @Schema(description =  "合同类型")
    private String contractType;

    @ExcelProperty(value = "合同金额")
    @Schema(description =  "合同金额")
    private BigDecimal contractAmount;

    @ExcelProperty(value = "已使用额度")
    @Schema(description =  "已使用额度")
    private BigDecimal usedQuota;

    @ExcelProperty(value = "可用额度")
    @Schema(description =  "可用额度")
    private BigDecimal availableQuota;

    @ExcelProperty(value = "合同起始日")
    @Schema(description =  "合同起始日")
    private LocalDate contractStartDate;

    @ExcelProperty(value = "合同到期日")
    @Schema(description =  "合同到期日")
    private LocalDate contractEndDate;

    @ExcelProperty(value = "签约日期")
    @Schema(description =  "签约日期")
    private LocalDate signedDate;

    @ExcelProperty(value = "终止日期")
    @Schema(description =  "终止日期")
    private LocalDate terminationDate;

    @ExcelProperty(value = "还款周期")
    @Schema(description =  "还款周期")
    private String repaymentCycle;

    @ExcelProperty(value = "还款方式")
    @Schema(description =  "还款方式")
    private String repaymentMethod;

    @ExcelProperty(value = "签约利率")
    @Schema(description =  "签约利率")
    private BigDecimal signedRate;

    @ExcelProperty(value = "担保方式")
    @Schema(description =  "担保方式")
    private String guaranteeMethod;

    @ExcelProperty(value = "抵押/质押/保证合同编号")
    @Schema(description =  "抵押/质押/保证合同编号")
    private String guaranteeContractId;

    @ExcelProperty(value = "他项权证号码")
    @Schema(description =  "他项权证号码")
    private String encumbranceCertificateNumber;

    @ExcelProperty(value = "借款原因")
    @Schema(description =  "借款原因")
    private String loanPurpose;

    @ExcelProperty(value = "客户经理")
    @Schema(description =  "客户经理")
    private String customerManager;

    @ExcelProperty(value = "信贷业务编号")
    @Schema(description =  "信贷业务编号")
    private String creditBusinessId;

    @ExcelProperty(value = "合同状态")
    @Schema(description =  "合同状态")
    private String contractStatus;

    @ExcelProperty(value = "贷款视频路径")
    @Schema(description =  "贷款视频路径")
    private String loanVideoPath;

    @ExcelProperty(value = "电话录音路径")
    @Schema(description =  "电话录音路径")
    private String telRecordingPath;

    @ExcelProperty(value = "贷款资料路径")
    @Schema(description =  "贷款资料路径")
    private String loanDataPath;

}