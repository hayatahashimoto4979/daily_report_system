package actions.views;

import java.util.ArrayList;
import java.util.List;

import models.Progress;

public class ProgressConverter {


    public static Progress toModel(ProgressView pv) {
        return new Progress(
                pv.getId(),
                EmployeeConverter.toModel(pv.getEmployee()),
                ClientConverter.toModel(pv.getClient()),
                OpportunityConverter.toModel(pv.getOpportunity()),
                pv.getProgressDate(),
                pv.getItem(),
                pv.getProspect(),
                pv.getStatus(),
                pv.getContent(),
                pv.getCreatedAt(),
                pv.getUpdatedAt());



    }


    public static ProgressView toView(Progress p) {

        if(p == null) {
            return null;
        }

        return new ProgressView(
                p.getId(),
                EmployeeConverter.toView(p.getEmployee()),
                ClientConverter.toView(p.getClient()),
                OpportunityConverter.toView(p.getOpportunity()),
                p.getProgressDate(),
                p.getItem(),
                p.getProspect(),
                p.getStatus(),
                p.getContent(),
                p.getCreatedAt(),
                p.getUpdatedAt());


    }


    public static List<ProgressView> toViewList(List<Progress> list) {
        List<ProgressView> evs = new ArrayList<>();

        for (Progress p : list) {
            evs.add(toView(p));
        }

        return evs;
    }


    public static void copyViewToModel(Progress p, ProgressView pv) {
        p.setId(pv.getId());
        p.setEmployee(EmployeeConverter.toModel(pv.getEmployee()));
        p.setClient(ClientConverter.toModel(pv.getClient()));
        p.setOpportunity(OpportunityConverter.toModel(pv.getOpportunity()));
        p.setProgressDate(pv.getProgressDate());
        p.setItem(pv.getItem());
        p.setProspect(pv.getProspect());
        p.setStatus(pv.getStatus());
        p.setContent(pv.getContent());
        p.setCreatedAt(pv.getCreatedAt());
        p.setUpdatedAt(pv.getUpdatedAt());




    }

}
