package com.tw.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "dept")
public class Department {
    @Id @Column(name = "dept_no")
    private int deptNo;
    @Column(length = 20)
    private String deptName;
    @Column(length = 20)
    private String location;

    @OneToMany(mappedBy = "dept", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Employee> emps;

    public Department(int deptNo, String deptName, String location) {
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Dept No: " + deptNo + ", DeptName: " + deptName + ", Location: " + location;
    }
}
