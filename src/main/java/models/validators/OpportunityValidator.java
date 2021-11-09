package models.validators;

import java.util.ArrayList;
import java.util.List;

import actions.views.OpportunityView;
import constants.MessageConst;

public class OpportunityValidator {

    public static List<String> validate(OpportunityView ov) {
        List<String> errors = new ArrayList<String>();

        String titleError = validateTitle(ov.getTitle());
        if (!titleError.equals("")) {
            errors.add(titleError);
        }

        return errors;
    }

    private static String validateTitle(String title) {
        if (title == null || title.equals("")) {
            return MessageConst.E_NOTITLE.getMessage();
        }

        return "";
    }
}