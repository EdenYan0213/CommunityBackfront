package com.community.yccc.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


public class RegisterDTO {

    @NotEmpty(message = "请输入账号")
    @Length(min = 2, max = 15, message = "长度在2-15")
    private String name;

    @NotEmpty(message = "请输入密码")
    @Length(min = 6, max = 20, message = "长度在6-20")
    private String pass;

    @NotEmpty(message = "请再次输入密码")
    @Length(min = 6, max = 20, message = "长度在6-20")
    private String checkPass;

    @NotEmpty(message = "请输入电子邮箱")
    @Email(message = "邮箱格式不正确")
    private String email;

    public @NotEmpty(message = "请输入账号") @Length(min = 2, max = 15, message = "长度在2-15") String getName() {

        return name;
    }

    public void setName(@NotEmpty(message = "请输入账号") @Length(min = 2, max = 15, message = "长度在2-15") String name) {
        this.name = name;
    }

    public @NotEmpty(message = "请输入密码") @Length(min = 6, max = 20, message = "长度在6-20") String getPass() {
        return pass;
    }

    public void setPass(@NotEmpty(message = "请输入密码") @Length(min = 6, max = 20, message = "长度在6-20") String pass) {
        this.pass = pass;
    }

    public @NotEmpty(message = "请再次输入密码") @Length(min = 6, max = 20, message = "长度在6-20") String getCheckPass() {
        return checkPass;
    }

    public void setCheckPass(@NotEmpty(message = "请再次输入密码") @Length(min = 6, max = 20, message = "长度在6-20") String checkPass) {
        this.checkPass = checkPass;
    }

    public @NotEmpty(message = "请输入电子邮箱") @Email(message = "邮箱格式不正确") String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty(message = "请输入电子邮箱") @Email(message = "邮箱格式不正确") String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "RegisterDTO{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", checkPass='" + checkPass + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}