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
public class ClientView {

    //id
    private Integer id;

    //お客様番号
    private String code;

    //会社名
    private String name;

    //事業内容
    private String content;

    //担当者名
    private EmployeeView employeeRepresentative;

    //月間平均売上
    private String average_sales;

    private String text;

    //作成日
    private LocalDateTime createdAt;

    //更新日
    private LocalDateTime updatedAt;

}