package sys.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "category", schema = "springbootjpa")
public class CategoryEntity extends BasicEntity {
    private int id;
    private String name;
    private String description;
    private String image;
    private Collection<ProductEntity> products;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description, image);
    }

    @OneToMany(mappedBy = "category")
    public Collection<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(Collection<ProductEntity> products) {
        this.products = products;
    }
}
