package com.senai.eli.Validator.Usuario;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UsuarioValidator implements ConstraintValidator<Usuario, String>{

@Override
public boolean isValid(String value, ConstraintValidatorContext context){
    if (value ==null || value.trim().isEmpty()){
    return false;
}

return value.length() >= 8
&& value.length() <= 16
&& !value.contains(" ")
&& value.matches("[a-zA-Z0-9]+$");
    }
    
}
