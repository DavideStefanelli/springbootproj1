package sys.entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "springbootjpa", uniqueConstraints = { @UniqueConstraint(name = "UNIQUE_EMAIL", columnNames="email") })
public class UserEntity extends BasicEntity {

    private int id;
    private String email;
    private String cf;
    private String name;
    private String surname;
    private Date birthdate;
    private String password;
    private String salt;
    private Timestamp creationdate;
    private String gender;
    private ShopEntity shop;
    private Collection<PurchaseEntity> purchases;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "cf")
    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "birthdate")
    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "salt")
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Basic
    @Column(name = "creationdate")
    public Timestamp getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Timestamp creationdate) {
        this.creationdate = creationdate;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id &&
                Objects.equals(email, that.email) &&
                Objects.equals(cf, that.cf) &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(birthdate, that.birthdate) &&
                Objects.equals(password, that.password) &&
                Objects.equals(salt, that.salt) &&
                Objects.equals(creationdate, that.creationdate) &&
                Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, email, cf, name, surname, birthdate, password, salt, creationdate, gender);
    }

    @OneToOne(mappedBy = "owner")
    public ShopEntity getShop() {
        return shop;
    }

    public void setShop(ShopEntity shop) {
        this.shop = shop;
    }

    @OneToMany(mappedBy = "buyer")
    public Collection<PurchaseEntity> getPurchases() {
        return purchases;
    }

    public void setPurchases(Collection<PurchaseEntity> purchases) {
        this.purchases = purchases;
    }

}
