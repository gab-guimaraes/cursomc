package com.johnwick.cursomc.resources.exceptions;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandartError  implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Integer status, String msg, Long timeStamp) {
        super(status, msg, timeStamp);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addErrort(String fieldName, String messagem) {
        errors.add(new FieldMessage(fieldName,messagem));
    }
}
