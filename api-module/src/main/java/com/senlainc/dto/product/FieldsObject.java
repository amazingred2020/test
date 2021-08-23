package com.senlainc.dto.product;

import com.senlainc.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class FieldsObject {

    private User user;
    private String[] productFields;
}
