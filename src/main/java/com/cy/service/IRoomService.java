package com.cy.service;

import com.cy.domain.Room;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cy.utils.ResultVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ChadYang
 * @since 2025-06-26
 */
public interface IRoomService extends IService<Room> {
    ResultVo findShowBedVo(String floor);
}
