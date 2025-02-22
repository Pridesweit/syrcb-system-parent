package com.sz.admin.loancontact.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.sz.admin.loancontact.service.LoanContactService;
import com.sz.admin.loancontact.pojo.po.LoanContact;
import com.sz.admin.loancontact.mapper.LoanContactMapper;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.query.QueryChain;
import com.sz.core.common.enums.CommonResponseEnum;
import com.sz.core.util.PageUtils;
import com.sz.core.util.BeanCopyUtils;
import com.sz.core.util.Utils;
import com.sz.core.common.entity.PageResult;
import com.sz.core.common.entity.SelectIdsDTO;
import java.io.Serializable;
import java.util.List;
import com.sz.admin.loancontact.pojo.dto.LoanContactCreateDTO;
import com.sz.admin.loancontact.pojo.dto.LoanContactUpdateDTO;
import com.sz.admin.loancontact.pojo.dto.LoanContactListDTO;
import com.sz.admin.loancontact.pojo.dto.LoanContactImportDTO;
import com.sz.core.common.entity.ImportExcelDTO;
import com.sz.excel.core.ExcelResult;
import java.io.OutputStream;
import jakarta.servlet.http.HttpServletResponse;
import com.sz.core.util.FileUtils;
import com.sz.excel.utils.ExcelUtils;
import lombok.SneakyThrows;
import com.sz.admin.loancontact.pojo.vo.LoanContactVO;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sz-admin
 * @since 2025-02-22
 */
@Service
@RequiredArgsConstructor
public class LoanContactServiceImpl extends ServiceImpl<LoanContactMapper, LoanContact> implements LoanContactService {
    @Override
    public void create(LoanContactCreateDTO dto){
        LoanContact loanContact = BeanCopyUtils.copy(dto, LoanContact.class);
        save(loanContact);
    }

    @Override
    public void update(LoanContactUpdateDTO dto){
        LoanContact loanContact = BeanCopyUtils.copy(dto, LoanContact.class);
        QueryWrapper wrapper;
        // id有效性校验
        wrapper = QueryWrapper.create()
            .eq(LoanContact::getId, dto.getId());
        CommonResponseEnum.INVALID_ID.assertTrue(count(wrapper) <= 0);

        saveOrUpdate(loanContact);
    }

    @Override
    public PageResult<LoanContactVO> page(LoanContactListDTO dto){
        Page<LoanContactVO> page = pageAs(PageUtils.getPage(dto), buildQueryWrapper(dto), LoanContactVO.class);
        return PageUtils.getPageResult(page);
    }

    @Override
    public List<LoanContactVO> list(LoanContactListDTO dto){
        return listAs(buildQueryWrapper(dto), LoanContactVO.class);
    }

    @Override
    public void remove(SelectIdsDTO dto){
        CommonResponseEnum.INVALID_ID.assertTrue(dto.getIds().isEmpty());
        removeByIds(dto.getIds());
    }

    @Override
    public LoanContactVO detail(Object id){
        LoanContact loanContact = getById((Serializable) id);
        CommonResponseEnum.INVALID_ID.assertNull(loanContact);
        return BeanCopyUtils.copy(loanContact, LoanContactVO.class);
    }

    @SneakyThrows
    @Override
    public void importExcel(ImportExcelDTO dto) {
        ExcelResult<LoanContactImportDTO> excelResult = ExcelUtils.importExcel(dto.getFile().getInputStream(), LoanContactImportDTO.class, true);
        List<LoanContactImportDTO> list = excelResult.getList();
        List<String> errorList = excelResult.getErrorList();
        String analysis = excelResult.getAnalysis();
        System.out.println(" analysis : " + analysis);
        System.out.println(" isCover : " + dto.getIsCover());
    }

    @SneakyThrows
    @Override
    public void exportExcel(LoanContactListDTO dto, HttpServletResponse response) {
        List<LoanContactVO> list = list(dto);
        String fileName = "模板";
        OutputStream os = FileUtils.getOutputStream(response, fileName + ".xlsx");
        ExcelUtils.exportExcel(list, "", LoanContactVO.class, os);
    }

    private static QueryWrapper buildQueryWrapper(LoanContactListDTO dto) {
        QueryWrapper wrapper = QueryWrapper.create().from(LoanContact.class);
        if (Utils.isNotNull(dto.getSigningInstitution())) {
            wrapper.eq(LoanContact::getSigningInstitution, dto.getSigningInstitution());
        }
        if (Utils.isNotNull(dto.getCustomerType())) {
            wrapper.eq(LoanContact::getCustomerType, dto.getCustomerType());
        }
        if (Utils.isNotNull(dto.getCustomerName())) {
            wrapper.like(LoanContact::getCustomerName, dto.getCustomerName());
        }
        if (Utils.isNotNull(dto.getIdNumber())) {
            wrapper.eq(LoanContact::getIdNumber, dto.getIdNumber());
        }
        if (Utils.isNotNull(dto.getCustomerNumber())) {
            wrapper.eq(LoanContact::getCustomerNumber, dto.getCustomerNumber());
        }
        if (Utils.isNotNull(dto.getBusinessType())) {
            wrapper.eq(LoanContact::getBusinessType, dto.getBusinessType());
        }
        if (Utils.isNotNull(dto.getContractId())) {
            wrapper.eq(LoanContact::getContractId, dto.getContractId());
        }
        if (Utils.isNotNull(dto.getContractType())) {
            wrapper.eq(LoanContact::getContractType, dto.getContractType());
        }
        if (Utils.isNotNull(dto.getContractAmount())) {
            wrapper.eq(LoanContact::getContractAmount, dto.getContractAmount());
        }
        if (Utils.isNotNull(dto.getUsedQuota())) {
            wrapper.eq(LoanContact::getUsedQuota, dto.getUsedQuota());
        }
        if (Utils.isNotNull(dto.getAvailableQuota())) {
            wrapper.eq(LoanContact::getAvailableQuota, dto.getAvailableQuota());
        }
        if (Utils.isNotNull(dto.getContractStartDateStart()) && Utils.isNotNull(dto.getContractStartDateEnd())) {
            wrapper.between(LoanContact::getContractStartDate, dto.getContractStartDateStart(), dto.getContractStartDateEnd());
        }
        if (Utils.isNotNull(dto.getContractEndDateStart()) && Utils.isNotNull(dto.getContractEndDateEnd())) {
            wrapper.between(LoanContact::getContractEndDate, dto.getContractEndDateStart(), dto.getContractEndDateEnd());
        }
        if (Utils.isNotNull(dto.getSignedDateStart()) && Utils.isNotNull(dto.getSignedDateEnd())) {
            wrapper.between(LoanContact::getSignedDate, dto.getSignedDateStart(), dto.getSignedDateEnd());
        }
        if (Utils.isNotNull(dto.getTerminationDateStart()) && Utils.isNotNull(dto.getTerminationDateEnd())) {
            wrapper.between(LoanContact::getTerminationDate, dto.getTerminationDateStart(), dto.getTerminationDateEnd());
        }
        if (Utils.isNotNull(dto.getRepaymentCycle())) {
            wrapper.eq(LoanContact::getRepaymentCycle, dto.getRepaymentCycle());
        }
        if (Utils.isNotNull(dto.getRepaymentMethod())) {
            wrapper.eq(LoanContact::getRepaymentMethod, dto.getRepaymentMethod());
        }
        if (Utils.isNotNull(dto.getSignedRate())) {
            wrapper.eq(LoanContact::getSignedRate, dto.getSignedRate());
        }
        if (Utils.isNotNull(dto.getGuaranteeMethod())) {
            wrapper.eq(LoanContact::getGuaranteeMethod, dto.getGuaranteeMethod());
        }
        if (Utils.isNotNull(dto.getGuaranteeContractId())) {
            wrapper.eq(LoanContact::getGuaranteeContractId, dto.getGuaranteeContractId());
        }
        if (Utils.isNotNull(dto.getEncumbranceCertificateNumber())) {
            wrapper.eq(LoanContact::getEncumbranceCertificateNumber, dto.getEncumbranceCertificateNumber());
        }
        if (Utils.isNotNull(dto.getLoanPurpose())) {
            wrapper.eq(LoanContact::getLoanPurpose, dto.getLoanPurpose());
        }
        if (Utils.isNotNull(dto.getCustomerManager())) {
            wrapper.eq(LoanContact::getCustomerManager, dto.getCustomerManager());
        }
        if (Utils.isNotNull(dto.getCreditBusinessId())) {
            wrapper.eq(LoanContact::getCreditBusinessId, dto.getCreditBusinessId());
        }
        if (Utils.isNotNull(dto.getContractStatus())) {
            wrapper.eq(LoanContact::getContractStatus, dto.getContractStatus());
        }
        if (Utils.isNotNull(dto.getLoanVideoPath())) {
            wrapper.eq(LoanContact::getLoanVideoPath, dto.getLoanVideoPath());
        }
        if (Utils.isNotNull(dto.getTelRecordingPath())) {
            wrapper.eq(LoanContact::getTelRecordingPath, dto.getTelRecordingPath());
        }
        if (Utils.isNotNull(dto.getLoanDataPath())) {
            wrapper.eq(LoanContact::getLoanDataPath, dto.getLoanDataPath());
        }
        return wrapper;
    }
}