package com.example.seminar.dto;

import jakarta.validation.constraints.Pattern;

public record PostRequestV2(

        //정규식을 추가해서 검증을 수행함 
        @Pattern(regexp = "^[a-zA-Z0-9가-힣\\s]*$", message = "제목은 한글, 영문, 숫자만 입력 가능합니다.")
        String title,

        String content
) {

}
