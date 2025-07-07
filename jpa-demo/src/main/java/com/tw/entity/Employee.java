package com.tw.entity;

import lombok.*;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor @ToString
@Entity
@Table(name = "emp")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    @Column(length = 30, nullable = false)
    private String empName;
    private double salary;

    @ManyToOne
    @JoinColumn(name = "dept_no")
    private Department dept;

    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
    }
}
