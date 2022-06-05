package com.exalt.car.rental.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.*;
import java.time.LocalDate;

@Document(indexName = "cars")
@Getter
@Setter
@Entity
@Table(name = "car")
public class Car extends BaseEntity {
    @Field(type = FieldType.Text)
    private String name;
    @Column(name = "customer_id", insertable = false, updatable = false)
    private Integer customerId;
    @Column(name = "rent_end_date")
    private LocalDate rentEndDate;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @Field(type = FieldType.Nested)
    private Customer customer;
}
