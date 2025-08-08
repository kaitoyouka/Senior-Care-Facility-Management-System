package com.cy.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.cy.domain.Customer;
import com.cy.domain.Customernurseitem;
import com.cy.dto.CustomerNurseItemDto;
import com.cy.mapper.CustomerMapper;
import com.cy.mapper.CustomernurseitemMapper;
import com.cy.service.ICustomernurseitemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cy.utils.ResultVo;
import com.cy.vo.CountVo;
import com.cy.vo.CustomerNurseItemVo;
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
 * @since 2025-06-27
 */
@Service
@Transactional
public class CustomernurseitemServiceImpl extends ServiceImpl<CustomernurseitemMapper, Customernurseitem> implements ICustomernurseitemService {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private CustomernurseitemMapper customernurseitemMapper;
    @Override
    public ResultVo addItemToCustomer(List<Customernurseitem> customernurseitems) {
        if (customernurseitems.size() > 0) {
            // 判断是选择级别添加级别中的护理项目，还是单独购买护理项目
            if (customernurseitems.get(0).getLevelId() != null) { // 级别附带项目
                // 设置客户护理级别
                Customer customer = new Customer();
                customer.setId(customernurseitems.get(0).getCustormerId());
                customer.setLevelId(customernurseitems.get(0).getLevelId());
                int count1 = customerMapper.updateById(customer);
                // 批量给用户添加护理项目
                boolean temp = saveBatch(customernurseitems);
                if (!(count1 > 0 && temp)) {
                    return ResultVo.fail("护理项目配置失败");
                }
            } else {    // 单独购买护理项目
                saveBatch(customernurseitems);
            }
            return ResultVo.ok("护理项目配置成功");
        }
        return ResultVo.fail("请选择需要添加的护理项目");
    }

    @Override
    public ResultVo removeCustomerLevelAndItem(Integer levelId, Integer customerId) {
        // 更新客户级别为null
        LambdaUpdateWrapper<Customer> luw = new LambdaUpdateWrapper<>();
        luw.eq(Customer::getId, customerId).set(Customer::getLevelId, null);
        int count1 = customerMapper.update(null, luw);
        // 删除客户当前级别的所有护理项目
        LambdaUpdateWrapper<Customernurseitem> luw2 = new LambdaUpdateWrapper<>();
        luw2.eq(Customernurseitem::getCustormerId, customerId).eq(Customernurseitem::getLevelId, levelId);
        int count2 = customernurseitemMapper.delete(luw2);
        if (!(count1 > 0 && count2 > 0)) {
            return ResultVo.fail("移除失败");
        }
        return ResultVo.ok("移除成功");
    }

    @Override
    public ResultVo listCustomerItem(CustomerNurseItemDto customerNurseItemDto) {
        Map<String, Object> map = new HashMap<>();
        map.put("current", customerNurseItemDto.getCurrentPage());
        customerNurseItemDto.setCurrentPage((customerNurseItemDto.getCurrentPage() - 1) * customerNurseItemDto.getPageSize());
        List<CustomerNurseItemVo> customerNurseItemVoList = customernurseitemMapper.listCustomerItem(customerNurseItemDto);
        CountVo countVo = customernurseitemMapper.selectCustomerItemCount(customerNurseItemDto);
        map.put("records", customerNurseItemVoList);
        map.put("total", countVo.getCount());
        map.put("size", customerNurseItemDto.getPageSize());
        map.put("pages", Math.ceil((double) countVo.getCount() / customerNurseItemDto.getPageSize()));
        return ResultVo.ok(map);
    }


}
