package com.tophyuk.dateRecord.validation.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignupForm {
    @Size(min = 2, max = 10)
    @NotEmpty(message = "이름은 필수항목입니다.")
    private String name;

    @Size(min = 8, max=18)
    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String password;

    @Size(min = 8, max=18)
    @NotEmpty(message = "비밀번호 확인는 필수항목입니다.")
    private String password2;

    @NotEmpty(message = "지역 선택은 필수항목입니다.")
    private String region; // 지역

    @Size(max = 30)
    @NotEmpty(message = "이메일은 필수항목입니다.")
    @Email
    private String email;
}
