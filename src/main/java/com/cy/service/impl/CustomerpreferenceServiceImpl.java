package com.cy.service.impl;

import com.cy.domain.Customerpreference;
import com.cy.dto.CustomerpreferenceDto;
import com.cy.mapper.CustomerpreferenceMapper;
import com.cy.service.ICustomerpreferenceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cy.utils.ResultVo;
import com.cy.vo.CountVo;
import com.cy.vo.CustomerpreferenceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ChadYang
 * @since 2025-06-25
 */
@Service
@Transactional
public class CustomerpreferenceServiceImpl extends ServiceImpl<CustomerpreferenceMapper, Customerpreference> implements ICustomerpreferenceService {
    @Autowired
    private CustomerpreferenceMapper customerpreferenceMapper;
    @Override
    public ResultVo selectCustomerpreferenceVo(CustomerpreferenceDto customerpreferenceDto) {
        Map<String, Object> map = new HashMap<>();
        map.put("current", customerpreferenceDto.getCurrentPage());
        customerpreferenceDto.setCurrentPage((customerpreferenceDto.getCurrentPage() - 1) * customerpreferenceDto.getPageSize());
        List<CustomerpreferenceVo> customerpreferenceVoList = customerpreferenceMapper.selectCustomerpreferenceVo(customerpreferenceDto);
        CountVo countVo = customerpreferenceMapper.selectCustomerpreferenceCount(customerpreferenceDto);
        map.put("total", countVo.getCount());
        map.put("records", customerpreferenceVoList);
        map.put("size", customerpreferenceDto.getPageSize());
        map.put("pages", Math.ceil((double) countVo.getCount() / customerpreferenceDto.getPageSize()));
        return ResultVo.ok(map);
    }
}
