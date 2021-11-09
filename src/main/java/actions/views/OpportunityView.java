package actions.views;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OpportunityView {

    private Integer id;


    private ClientView client;


    private EmployeeView employee;


    private String title;


    private LocalDateTime createdAt;


    private LocalDateTime updatedAt;
}