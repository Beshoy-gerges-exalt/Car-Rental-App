package com.exalt.car.rental.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Document(indexName = "cars")
@Getter
@Setter
@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "rent_end_date")
    private LocalDate rentEndDate;
    @LastModifiedDate
    private Date updatedAt;
    @CreatedDate
    private Date createdAt;
}
