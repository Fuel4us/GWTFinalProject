package pt.isep.nsheets.shared.lapr4.red.s2.ipc.n1161292.users;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import eapli.util.Strings;

/**
 * a password of a user.
 *
 * passwords must be at least 6 characters long and have at least one digit and
 * one capital letter
 *
 * TODO passwords should never be stored in plain format
 *
 * @author Paulo Gandra Sousa
 */
@Embeddable
public class Password implements ValueObject, Serializable {

    private static final long serialVersionUID = 1L;
    
    private String password;

    protected Password() {
        // for ORM only
    }

    public Password(String password) {
        if (!meetsMinimumRequirements(password)) {
            throw new IllegalArgumentException();
        }
        this.password = password;
    }

    private boolean meetsMinimumRequirements(String password) {
        // sanity check
        if (Strings.isNullOrEmpty(password)) {
            return false;
        }

        // at least 6 characters long
        if (password.length() < 6) {
            return false;
        }

        // at least one digit
        if (!Strings.containsDigit(password)) {
            return false;
        }

        // at least one capital letter
        if (!Strings.containsCapital(password)) {
            return false;
        }

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Password)) {
            return false;
        }

        final Password password1 = (Password) o;

        return password.equals(password1.password);

    }

    @Override
    public int hashCode() {
        return password.hashCode();
    }

    /**
     * Check how strong a password is
     *
     * @return how strong a password is
     */
    public PasswordStrength strength() {
        PasswordStrength passwordStrength = PasswordStrength.Weak;
        if (3 > password.length()) {
            passwordStrength = PasswordStrength.Weak;
        }
        return passwordStrength;
        // TODO implement the rest of the method
    }

    @Override
    public String toString() {
        return password;
    }

    public enum PasswordStrength {
        Weak, Good, Excelent,
    }
}