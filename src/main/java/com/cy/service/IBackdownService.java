package com.cy.service;

import com.cy.domain.Backdown;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cy.dto.BackdownDto;
import com.cy.utils.ResultVo;
import com.cy.vo.BackdownVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ChadYang
 * @since 2025-06-27
 */
public interface IBackdownService extends IService<Backdown> {
    ResultVo examineBackdown(Backdown backdown);

    ResultVo listBackdownVo(BackdownDto backdownDto);
}
