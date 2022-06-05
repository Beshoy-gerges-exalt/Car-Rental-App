package com.exalt.car.rental.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Entity;

@Document(indexName = "customers")
@Getter
@Setter
@Entity
public class Customer extends BaseEntity {
    @Field(type = FieldType.Text)
    private String name;
    @Field(type = FieldType.Text)
    private String email;

}
