package actions.views;

import java.util.ArrayList;
import java.util.List;

import models.Client;

public class ClientConverter {

    public static Client toModel(ClientView cv) {
        return new Client(
                cv.getId(),
                cv.getCode(),
                cv.getName(),
                cv.getContent(),
                EmployeeConverter.toModel(cv.getEmployeeRepresentative()),
                cv.getAverage_sales(),
                cv.getText(),
                cv.getCreatedAt(),
                cv.getUpdatedAt());

    }

    public static ClientView toView(Client c) {

        if (c == null) {
            return null;
        }

        return new ClientView(
                c.getId(),
                c.getCode(),
                c.getName(),
                c.getContent(),
                EmployeeConverter.toView(c.getEmployeeRepresentative()),
                c.getAverage_sales(),
                c.getText(),
                c.getCreatedAt(),
                c.getUpdatedAt());

    }

    public static List<ClientView> toViewList(List<Client> list) {
        List<ClientView> evs = new ArrayList<>();

        for (Client c : list) {
            evs.add(toView(c));
        }

        return evs;
    }

    public static void copyViewToModel(Client c, ClientView cv) {
        c.setId(cv.getId());
        c.setCode(cv.getCode());
        c.setName(cv.getName());
        c.setContent(cv.getContent());
        c.setEmployeeRepresentative(EmployeeConverter.toModel(cv.getEmployeeRepresentative()));
        c.setAverage_sales(cv.getAverage_sales());
        c.setText(cv.getText());
        c.setCreatedAt(cv.getCreatedAt());
        c.setUpdatedAt(cv.getUpdatedAt());

    }

}