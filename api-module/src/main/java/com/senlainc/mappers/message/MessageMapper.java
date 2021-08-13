package com.senlainc.mappers.message;

import com.senlainc.dto.message.SaveMessageRequest;
import com.senlainc.entity.Message;
import com.senlainc.mappers.comment.UserByIdMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {UserByIdMapper.class})
public interface MessageMapper {

    Message fromSaveMessageRequestToMessage(SaveMessageRequest request);
}
