package models.validators;

import java.util.ArrayList;
import java.util.List;

import actions.views.ProgressView;
import constants.MessageConst;

public class ProgressValidator {

    public static List<String> validate(ProgressView pv) {
        List<String> errors = new ArrayList<String>();

        String itemError = validateItem(pv.getItem());
        if (!itemError.equals("")) {
            errors.add(itemError);
        }


        String prospectError = validateProspect(pv.getProspect());
        if (!prospectError.equals("")) {
            errors.add(prospectError);
        }


        String statusError = validateStatus(pv.getStatus());
        if (!statusError.equals("")) {
            errors.add(statusError);
        }


        String contentError = validateContent(pv.getContent());
        if (!contentError.equals("")) {
            errors.add(contentError);
        }

        return errors;
    }


    private static String validateItem(String item) {
        if (item == null || item.equals("")) {
            return MessageConst.E_NOITEM.getMessage();
        }


        return "";
    }


    private static String validateProspect(String prospect) {
        if (prospect == null || prospect.equals("")) {
            return MessageConst.E_NOPROSPECT.getMessage();
        }


        return "";
    }


    private static String validateStatus(String status) {
        if (status == null || status.equals("")) {
            return MessageConst.E_NOSTATUS.getMessage();
        }


        return "";
    }


    private static String validateContent(String content) {
        if (content == null || content.equals("")) {
            return MessageConst.E_NOCONTENT.getMessage();
        }


        return "";
    }



}