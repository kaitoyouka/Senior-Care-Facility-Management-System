package com.cy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cy.domain.Bed;
import com.cy.domain.Room;
import com.cy.mapper.BedMapper;
import com.cy.mapper.RoomMapper;
import com.cy.service.IRoomService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cy.utils.ResultVo;
import com.cy.vo.ShowBedVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ChadYang
 * @since 2025-06-26
 */
@Service
@Transactional
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements IRoomService {
    @Autowired
    private BedMapper bedMapper;
    @Override
    public ResultVo findShowBedVo(String floor) {
        // 统计床位
        ShowBedVo showBedVo = bedMapper.selectBedCount();
        LambdaQueryWrapper<Room> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Room::getRoomFloor,floor);
        // 查询所有房间
        List<Room> roomList = list(lqw);
        for (Room room : roomList) {
            // 查询每个房间的床位信息
            LambdaQueryWrapper<Bed> listBedLqw = new LambdaQueryWrapper<>();
            listBedLqw.eq(Bed::getRoomNo,room.getRoomNo());
            room.setBedList(bedMapper.selectList(listBedLqw));
        }
        showBedVo.setRoomList(roomList);
        return ResultVo.ok(showBedVo);
    }
}
