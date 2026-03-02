package dev.archety.springboot_docker_mysql_demo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserCreateRequest {
    @NotBlank @Size(max = 100)
    public String firstName;

    @NotBlank @Size(max = 100)
    public String lastName;

    @NotBlank @Email @Size(max = 255)
    public String email;
}