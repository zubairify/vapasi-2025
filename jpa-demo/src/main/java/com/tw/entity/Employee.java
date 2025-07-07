package com.tw.entity;

import lombok.*;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "emp")

@NamedQuery(name = "empPune5k", query = "SELECT e FROM Employee e JOIN Department d ON e.dept.deptNo = d.deptNo " +
                "WHERE d.location='Pune' AND e.salary>5000")
@NamedNativeQuery(name = "dept20", query = "SELECT count(*) FROM emp WHERE dept_no=20")
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

    @Override
    public String toString() {
        return "Emp Id: " + empId + ", EmpName: " + empName + ", Salary: " + salary;
    }
}
