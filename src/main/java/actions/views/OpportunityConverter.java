package actions.views;

import java.util.ArrayList;
import java.util.List;

import models.Opportunity;

public class OpportunityConverter {

    public static Opportunity toModel(OpportunityView ov) {

            return new Opportunity(
                    ov.getId(),
                    ClientConverter.toModel(ov.getClient()),
                    EmployeeConverter.toModel(ov.getEmployee()),
                    ov.getTitle(),
                    ov.getCreatedAt(),
                    ov.getUpdatedAt());

        }


        public static OpportunityView toView(Opportunity o) {

            if (o == null) {
                return null;
            }

            return new OpportunityView(
                    o.getId(),
                    ClientConverter.toView(o.getClient()),
                    EmployeeConverter.toView(o.getEmployee()),
                    o.getTitle(),
                    o.getCreatedAt(),
                    o.getUpdatedAt());

        }


        public static List<OpportunityView> toViewList(List<Opportunity> list) {
            List<OpportunityView> evs = new ArrayList<>();

            for (Opportunity o : list) {
                evs.add(toView(o));
            }

            return evs;
        }


        public static void copyViewToModel(Opportunity o, OpportunityView ov) {
            o.setId(ov.getId());
            o.setClient(ClientConverter.toModel(ov.getClient()));
            o.setEmployee(EmployeeConverter.toModel(ov.getEmployee()));
            o.setTitle(ov.getTitle());
            o.setCreatedAt(ov.getCreatedAt());
            o.setUpdatedAt(ov.getUpdatedAt());
        }


        public static void copyModelToView(Opportunity o, OpportunityView ov) {
            ov.setId(o.getId());
            ov.setClient(ClientConverter.toView(o.getClient()));
            ov.setEmployee(EmployeeConverter.toView(o.getEmployee()));
            ov.setTitle(o.getTitle());
            ov.setCreatedAt(o.getCreatedAt());
            ov.setUpdatedAt(o.getUpdatedAt());
        }
}