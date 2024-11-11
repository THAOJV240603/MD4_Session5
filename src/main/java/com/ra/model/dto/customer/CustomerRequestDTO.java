package com.ra.model.dto.customer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ra.validate.CustomerUnique;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerRequestDTO {
    @NotBlank(message = "Không rỗng")
    private String fullName;
    @NotBlank(message = "Không rỗng")
    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}",
            message = "Email không đúng định dạng")
    @CustomerUnique(message = "Email đã tồn tại")
    private String email;
    @NotBlank(message = "Không rỗng")
    @Size(min = 8, message = "Tối thiểu 8 ký tự")
    private String password;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Past(message = "Ngày sinh phải là ngày trong quá khứ")
    private LocalDate birthday;
}
