package com.majiang.community.service;

import com.majiang.community.DTO.NotificationDTO;
import com.majiang.community.DTO.PaginationDTO;
import com.majiang.community.enums.NotificationStatusEnum;
import com.majiang.community.enums.NotificationTypeEnum;
import com.majiang.community.exception.CustomizeErrorCode;
import com.majiang.community.exception.CustomizeException;
import com.majiang.community.mapper.NotificationMapper;
import com.majiang.community.mapper.UserMapper;
import com.majiang.community.model.Notification;
import com.majiang.community.model.NotificationExample;
import com.majiang.community.model.User;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * @author jack
 * @version 1.0.0
 * @ClassName NotificationService.java
 * @Description TODO
 * @createTime 2022年03月24日 12:15:00
 */
@Service
public class NotificationService {

    @Autowired
    private NotificationMapper notificationMapper;

    public PaginationDTO list(Long id, Integer page, Integer size) {
        PaginationDTO<NotificationDTO> paginationDTO = new PaginationDTO<>();

        //计算总记录数
        NotificationExample notificationExample = new NotificationExample();
        notificationExample.createCriteria().andReceiverEqualTo(id);
        Integer totalCount = (int) notificationMapper.countByExample(notificationExample);

        //计算总页数
        Integer totalPage;
        Integer quotient = totalCount / size;
        Integer residue = totalCount % size;
        if (residue == 0) totalPage = quotient;
        else totalPage = quotient + 1;

        if (page < 1) page = 1;
        if (page > totalPage && totalPage != 0) page = totalPage;

        paginationDTO.setPagination(totalPage, page);

        Integer offset = (page - 1) * size;
        NotificationExample example = new NotificationExample();
        example.setOrderByClause("gmt_create DESC");
        example.createCriteria().andReceiverEqualTo(id);

        List<Notification> notifications = notificationMapper.selectByExampleWithRowbounds(example, new RowBounds(offset, size));

        if (notifications.size() == 0) {
            return paginationDTO;
        }
        List<NotificationDTO> notificationDTOS = new ArrayList<>();

        for (Notification notification : notifications) {
            NotificationDTO notificationDTO = new NotificationDTO();
            BeanUtils.copyProperties(notification, notificationDTO);
            notificationDTO.setTypeName(NotificationTypeEnum.nameOfType(notification.getType()));
            notificationDTOS.add(notificationDTO);
        }

        paginationDTO.setData(notificationDTOS);
        return paginationDTO;
    }

    public Long unreadCount(Long userId) {
        NotificationExample notificationExample = new NotificationExample();
        notificationExample.createCriteria()
                .andReceiverEqualTo(userId)
                .andStatusEqualTo(NotificationStatusEnum.UNREAD.getStatus());
        return notificationMapper.countByExample(notificationExample);
    }

    public NotificationDTO read(Long id, User user) {
        Notification notification = notificationMapper.selectByPrimaryKey(id);
        if (null == notification) {
            throw new CustomizeException(CustomizeErrorCode.NOTIFICATION_NOT_FOUND);
        }
        if (!Objects.equals(notification.getReceiver(), user.getId())) {
            throw new CustomizeException(CustomizeErrorCode.READ_NOTIFICATION_FAIL);
        }
        notification.setStatus(NotificationStatusEnum.READ.getStatus());
        notificationMapper.updateByPrimaryKey(notification);

        NotificationDTO notificationDTO = new NotificationDTO();
        BeanUtils.copyProperties(notification, notificationDTO);
        notificationDTO.setTypeName(NotificationTypeEnum.nameOfType(notification.getType()));
        return notificationDTO;
    }
}
