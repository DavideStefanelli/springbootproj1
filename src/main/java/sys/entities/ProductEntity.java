package sys.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "springbootjpa")
public class ProductEntity extends BasicEntity {
    private int id;
    private String name;
    private String description;
    private String image;
    private ShopEntity shop;
    private CategoryEntity category;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        ProductEntity that = (ProductEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description, image);
    }

    @ManyToOne
    @JoinColumn(name = "shop", referencedColumnName = "id", nullable = false)
    public ShopEntity getShop() {
        return shop;
    }

    public void setShop(ShopEntity shop) {
        this.shop = shop;
    }

    @ManyToOne
    @JoinColumn(name = "cat_id", referencedColumnName = "id", nullable = false)
    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    @OneToMany(mappedBy = "product")
    public Collection<PurchaseEntity> getPurchases() {
        return purchases;
    }

    public void setPurchases(Collection<PurchaseEntity> purchases) {
        this.purchases = purchases;
    }
}
