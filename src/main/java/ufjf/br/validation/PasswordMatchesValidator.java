package ufjf.br.validation;

import ufjf.br.models.Usuario;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
        final Usuario usuario = (Usuario) obj;
        return usuario.getPassword().equals(usuario.getMatchingPassword());
    }
}
