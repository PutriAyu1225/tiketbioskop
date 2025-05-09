package com.uasjava.tiketbioskop.dto;


import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterUserDto {
    private int id;
    private String username;
    private String password;
    private String email;
    private String nomor;
    private LocalDate tanggal_lahir;
    private List<RoleDto> roles;
}
