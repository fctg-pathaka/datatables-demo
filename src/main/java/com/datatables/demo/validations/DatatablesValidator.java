package com.datatables.demo.validations;

import com.datatables.demo.beans.Datatables;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class DatatablesValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Datatables.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Datatables slider = (Datatables) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty");


    }
}
