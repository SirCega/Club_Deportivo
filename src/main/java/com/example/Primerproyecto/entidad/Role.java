package com.example.Primerproyecto.entidad;

import com.example. Primerproyecto.enums. RoleList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Role {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@Column(nullable = false)
private RoleList name;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public RoleList getName() {
	return name;
}

public void setName(RoleList name) {
	this.name = name;
}


}

