package com.viezure.programareWeb.model;

import org.aspectj.weaver.ast.Or;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_ORDER_STATUS", allocationSize = 1)
public class OrderStatus extends BaseEntity {

    @Column(name = "code")
    @NotBlank(message = "Status code must not be blank!")
    public String code;

    @Column(name = "description")
    public String description;

    @OneToMany(mappedBy = "orderStatus")
    public Set<Order> orderSet;

}
