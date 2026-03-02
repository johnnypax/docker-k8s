package dev.archety.springboot_docker_mysql_demo;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name", nullable=false, length=100)
    private String firstName;

    @Column(name="last_name", nullable=false, length=100)
    private String lastName;

    @Column(nullable=false, unique=true, length=255)
    private String email;

    @Column(length = 20)
    private String telefono;

    @Column(length = 200)
    private String userid;

    public String getUserid() { return userid; }
    public void setUserid(String userid) { this.userid = userid; }
    

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }

    public void setId(Long id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
}