package com.ra.model.dto.customer;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerResponseDTO {
    private Long id;
    private String fullName;
    private String email;
    private LocalDate birthday;
}
