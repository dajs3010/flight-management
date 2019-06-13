package com.evolutivo.flightmanagement.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "table_name")
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "sometext", nullable = false)
    private String someText;

    public long getId() {
        return id;
    }

    public String getSomeText() {
        return someText;
    }
}
