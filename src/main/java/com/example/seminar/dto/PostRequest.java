package com.example.seminar.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Size;

public record PostRequest(

        @Size(min = 1, max = 50, message = "제목은 1자 이상, 50자 이하로 작성해주세요.")
        String title,

        String content
) {

    //true일때는 코드가 정상적으로 돌아가고, false일때는 예외를 던짐 -> 메소드명은 is로 시작해야함!
    @AssertTrue(message = "내용은 10자 이상으로 작성해주세요.")
    public boolean isValidContent() {
        try {
            return this.content.length() >= 10;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public void validateTitle() {
        if (this.title.isBlank()) {
            throw new IllegalArgumentException("제목은 공백으로만 이뤄질 수 없습니다.");
        }
    }
}
