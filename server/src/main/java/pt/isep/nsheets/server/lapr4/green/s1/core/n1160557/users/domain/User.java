package pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.domain;

/**
 *
 * @author alexandrebraganca
 */
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import eapli.framework.domain.AggregateRoot;
import pt.isep.nsheets.shared.services.UserDTO;

/**
 * Contact
 *
 * @author ATB
 *
 */
@Entity
public class User implements AggregateRoot<Long>, Serializable {

    // ORM primary key
    @Id
    @GeneratedValue
    private Long pk = null;

    private String email;
    private String name;
    private String nickname;

    public User(String email, String name, String nickname) throws IllegalArgumentException {
        if (email == null || name == null || nickname == null)
            throw new IllegalArgumentException("email or name or nickname must be non-null");
        
        this.email = email;
        this.name = name;
        this.nickname = nickname;
    }

    // It is mandatory to have a default constructor with no arguments to be
    // serializable and for ORM!
    protected User() {
        this.email = "";
        this.name = "";
        this.nickname = "";
    }

    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.name;
    }

    public String getNickname() {
        return this.nickname;
    }

    @Override
    public String toString() {
        if (this.email == null)
            return super.toString();
        else
            return this.email + " " + this.name + " " + this.nickname;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof User)) {
            return false;
        }

        final User that = (User) other;
        if (this == that) 
            return true;
        
        if (!this.email.equals(that.email))
            return false;
        
        if (!this.name.equals(that.name))
            return false;
        
        if (!this.nickname.equals(that.nickname))
            return false;
        
        return true;
    }

    @Override
    public boolean is(Long id) {
        return (this.pk.compareTo(id) == 0);
    }

    @Override
    public Long id() {
        return this.pk;
    }

    public UserDTO toDTO() {
            return new UserDTO(this.email, this.name, this.nickname);
    }

    public static User fromDTO(UserDTO dto) throws IllegalArgumentException {
            return new User(dto.getEmail(), dto.getName(), dto.getNickname());
    }
}