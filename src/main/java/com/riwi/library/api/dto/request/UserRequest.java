package com.riwi.library.api.dto.request;

import com.riwi.library.utils.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NotBlank(message = "Username is required")
    @Size(min = 1, max = 50, message = "The username must have a maximum of 50 characters.")
    private String username;


    @NotBlank(message = "Password is required")
    private String password;


    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    @Size(min = 1, max = 100, message = "The email must have a maximum of 100 characters.")
    private String email;


    @Size(min = 1, max = 100, message = "The full name must have a maximum of 100 characters.")
    private String fullName;

    @NotNull(message = "Required role")
    private Role role;
}
