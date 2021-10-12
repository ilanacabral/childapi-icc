package br.com.diolabs.childapi.utils;

import br.com.diolabs.childapi.dto.PhoneDTO;
import br.com.diolabs.childapi.enums.PhoneTypeEnum;
import br.com.diolabs.childapi.model.Phone;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "869999-9999";
    private static final PhoneTypeEnum PHONE_TYPE = PhoneTypeEnum.HOME;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}