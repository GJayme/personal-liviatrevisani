package br.com.personal.livia.domain.entity;

import br.com.personal.livia.domain.exception.ClientException;
import br.com.personal.livia.domain.vo.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;
import java.util.UUID;

public class Client {

    private final UUID id;
    private final String name;
    private final Gender gender;
    private final LocalDate birthday;
    private final String celPhone;
    private final String cpf;
    private final String email;
    private final LocalDateTime createDate;
    private LocalDateTime updateDate;

    public Client(String name, Gender gender, LocalDate birthday, String celPhone, String cpf, String email) {
        this.id = UUID.randomUUID();
        validOrThrow(name == null, "Client name doesn't should be null.");
        this.name = name;

        validOrThrow(gender == null, "Client gender doesn't should be null.");
        this.gender = gender;

        validOrThrow(birthday == null, "Client birthday doesn't should be null.");
        this.birthday = birthday;

        validCelPhoneOrThrow(celPhone);
        this.celPhone = celPhone;

        validCpfOrThrow(cpf);
        this.cpf = cpf;

        validOrThrow(email == null, "Client email doesn't should be null.");
        this.email = email;

        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("UTC"));
        this.createDate = localDateTime;
        this.updateDate = localDateTime;
    }

    private void validCpfOrThrow(String cpf) {
        if (cpf == null) {
            throw new ClientException("Client cpf doesn't should be null.");
        }
        if (cpf.length() != 11) {
            throw new ClientException("Client cpf doesn't had the correct length.");
        }
    }

    private void validCelPhoneOrThrow(String celPhone) {
        if (celPhone == null) {
            throw new ClientException("Client celPhone doesn't should be null.");
        }
        if (celPhone.length() != 11) {
            throw new ClientException("Client celPhone doesn't had the correct length.");
        }
    }

    private void validOrThrow(boolean field, String message) {
        if (field) {
            throw new ClientException(message);
        }
    }

    public void updateClient() {
        this.updateDate = LocalDateTime.now(ZoneId.of("UTC"));
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getCelPhone() {
        return celPhone;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(name, client.name) && gender == client.gender && Objects.equals(birthday, client.birthday) && Objects.equals(celPhone, client.celPhone) && Objects.equals(cpf, client.cpf) && Objects.equals(email, client.email) && Objects.equals(createDate, client.createDate) && Objects.equals(updateDate, client.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, birthday, celPhone, cpf, email, createDate, updateDate);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", celPhone='" + celPhone + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }

    public static class ClientBuilder {
        private String name;
        private Gender gender;
        private LocalDate birthday;
        private String celPhone;
        private String cpf;
        private String email;

        public ClientBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ClientBuilder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public ClientBuilder setBirthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        public ClientBuilder setCelPhone(String celPhone) {
            this.celPhone = celPhone;
            return this;
        }

        public ClientBuilder setCpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public ClientBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Client build() {
            return new Client(name, gender, birthday, celPhone, cpf, email);
        }
    }
}
