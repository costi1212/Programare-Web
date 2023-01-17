package com.viezure.programareWeb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Setter
@Getter
@Entity
@SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_ORDER_STATUS", allocationSize = 1)
public class OrderStatus extends BaseEntity {

    @Column(name = "code")
    @NotBlank(message = "Status code must not be blank!")
    private String code;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "orderStatus")
    @JsonIgnore
    private Set<Order> orderSet;

}
