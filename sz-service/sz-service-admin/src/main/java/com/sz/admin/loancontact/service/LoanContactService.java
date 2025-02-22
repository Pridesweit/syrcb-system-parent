package com.sz.admin.loancontact.service;

import com.mybatisflex.core.service.IService;
import com.sz.admin.loancontact.pojo.po.LoanContact;
import com.sz.core.common.entity.SelectIdsDTO;
import com.sz.core.common.entity.PageResult;
import java.util.List;
import com.sz.admin.loancontact.pojo.dto.LoanContactCreateDTO;
import com.sz.admin.loancontact.pojo.dto.LoanContactUpdateDTO;
import com.sz.admin.loancontact.pojo.dto.LoanContactListDTO;
import com.sz.admin.loancontact.pojo.vo.LoanContactVO;
import com.sz.core.common.entity.ImportExcelDTO;
import jakarta.servlet.http.HttpServletResponse;

/**
 * <p>
 *  Service
 * </p>
 *
 * @author sz-admin
 * @since 2025-02-22
 */
public interface LoanContactService extends IService<LoanContact> {

    void create(LoanContactCreateDTO dto);

    void update(LoanContactUpdateDTO dto);

    PageResult<LoanContactVO> page(LoanContactListDTO dto);

    List<LoanContactVO> list(LoanContactListDTO dto);

    void remove(SelectIdsDTO dto);

    LoanContactVO detail(Object id);

    void importExcel(ImportExcelDTO dto);

    void exportExcel(LoanContactListDTO dto, HttpServletResponse response);
}