package com.sz.admin.loancontact.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * <p>
 * LoanContact添加DTO
 * </p>
 *
 * @author sz-admin
 * @since 2025-02-22
 */
@Data
@Schema(description = "LoanContact添加DTO")
public class LoanContactCreateDTO {

   @Schema(description =  "签约机构")
   private String signingInstitution;

   @Schema(description =  "客户类型")
   private String customerType;

   @Schema(description =  "客户名称")
   private String customerName;

   @Schema(description =  "证件号码")
   private String idNumber;

   @Schema(description =  "客户号")
   private String customerNumber;

   @Schema(description =  "业务品种")
   private String businessType;

   @Schema(description =  "合同编号")
   private String contractId;

   @Schema(description =  "合同类型")
   private String contractType;

   @Schema(description =  "合同金额")
   private BigDecimal contractAmount;

   @Schema(description =  "已使用额度")
   private BigDecimal usedQuota;

   @Schema(description =  "可用额度")
   private BigDecimal availableQuota;

   @Schema(description =  "合同起始日")
   private LocalDate contractStartDate;

   @Schema(description =  "合同到期日")
   private LocalDate contractEndDate;

   @Schema(description =  "签约日期")
   private LocalDate signedDate;

   @Schema(description =  "终止日期")
   private LocalDate terminationDate;

   @Schema(description =  "还款周期")
   private String repaymentCycle;

   @Schema(description =  "还款方式")
   private String repaymentMethod;

   @Schema(description =  "签约利率")
   private BigDecimal signedRate;

   @Schema(description =  "担保方式")
   private String guaranteeMethod;

   @Schema(description =  "抵押/质押/保证合同编号")
   private String guaranteeContractId;

   @Schema(description =  "他项权证号码")
   private String encumbranceCertificateNumber;

   @Schema(description =  "借款原因")
   private String loanPurpose;

   @Schema(description =  "客户经理")
   private String customerManager;

   @Schema(description =  "信贷业务编号")
   private String creditBusinessId;

   @Schema(description =  "合同状态")
   private String contractStatus;

   @Schema(description =  "贷款视频路径")
   private String loanVideoPath;

   @Schema(description =  "电话录音路径")
   private String telRecordingPath;

   @Schema(description =  "贷款资料路径")
   private String loanDataPath;

}