package com.senlainc.mappers.message;

import com.senlainc.dto.message.SaveMessageRequest;
import com.senlainc.entity.Message;
import com.senlainc.mappers.comment.UserById;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {UserById.class})
public interface MessageMapper {

    @Mapping(source = "request.userFrom", target = "userFrom")
    @Mapping(source = "request.userTo", target = "userTo")
    Message fromSaveMessageRequestToMessage(SaveMessageRequest request);
}
