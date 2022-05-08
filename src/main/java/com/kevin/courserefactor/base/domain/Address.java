package com.kevin.courserefactor.base.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String cep;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address city = (Address) o;
        return Objects.equals(id, city.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
