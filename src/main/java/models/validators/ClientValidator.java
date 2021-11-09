package models.validators;

import java.util.ArrayList;
import java.util.List;

import actions.views.ClientView;
import constants.MessageConst;

public class ClientValidator {

    public static List<String> validate(ClientView cv) {
        List<String> errors = new ArrayList<String>();

        String codeError = validateCode(cv.getCode());
        if (!codeError.equals("")) {
            errors.add(codeError);
        }

        String nameError = validateName(cv.getName());
        if (!nameError.equals("")) {
            errors.add(nameError);
        }

        String contentError = validateContent(cv.getContent());
        if (!contentError.equals("")) {
            errors.add(contentError);
        }

        String average_salesError = validateAverage_sales(cv.getAverage_sales());
        if (!average_salesError.equals("")) {
            errors.add(average_salesError);
        }

        String text = validateText(cv.getText());
        if (!text.equals("")) {
            errors.add(text);
        }

        return errors;
    }

    private static String validateCode(String code) {

        if (code == null || code.equals("")) {
            return MessageConst.E_NOCLI_CODE.getMessage();
        }
        return "";
    }

    private static String validateName(String name) {
        if (name == null || name.equals("")) {
            return MessageConst.E_NOCOMPANYNAME.getMessage();
        }

        return "";
    }

    private static String validateContent(String content) {
        if (content == null || content.equals("")) {
            return MessageConst.E_NOCONTENT.getMessage();
        }
        return "";
    }

    private static String validateAverage_sales(String Average_sales) {
        if (Average_sales == null || Average_sales.equals("")) {
            return MessageConst.E_NOAVEGACE.getMessage();
        }
        return "";
    }

    private static String validateText(String Text) {
        if (Text == null || Text.equals("")) {
            return MessageConst.E_NOCONTENT.getMessage();
        }
        return "";
    }
}