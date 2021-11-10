package actions.views;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProgressView {


    private Integer id;


    private EmployeeView employee;


    private ClientView client;


    private OpportunityView opportunity;


    private LocalDate progressDate;


    private String item;


    private String prospect;


    private String status;


    private String content;


    private LocalDateTime createdAt;


    private LocalDateTime updatedAt;





}
