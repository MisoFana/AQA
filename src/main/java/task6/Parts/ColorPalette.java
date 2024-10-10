package task6.Parts;
import jakarta.persistence.*;

@Entity
@Table(name = "ColorPalette")
public class ColorPalette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean isPrimary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rgb_id", referencedColumnName = "id")
    private RGB rgb;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public RGB getRgb() {
        return rgb;
    }

    public void setRgb(RGB rgb) {
        this.rgb = rgb;
    }
}

