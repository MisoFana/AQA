package task6.Parts;

import jakarta.persistence.*;

@Entity
@Table(name = "RGB")
public class RGB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int r;
    private int g;
    private int b;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
