package com.cognizant.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeProjection {
    
    Long getId();
    String getName();
    
    @Value("#{target.department.name}")
    String getDepartmentName();
}
