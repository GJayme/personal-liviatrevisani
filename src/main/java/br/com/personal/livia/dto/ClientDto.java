package br.com.personal.livia.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class ClientDto {

    @NotBlank
    @Size(max = 130)
    private String name;

    @NotBlank
    @Size(max = 1)
    private String gender;

    @NotBlank
    private String birthday;

    @NotBlank
    @Size(max = 11)
    private String celPhone;

    @NotBlank
    @Size(max = 11)
    private String cpf;

    @NotBlank
    @Size(max = 130)
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCelPhone() {
        return celPhone;
    }

    public void setCelPhone(String celPhone) {
        this.celPhone = celPhone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
