package task6.Parts;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class Task {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        RGB rgb = new RGB();
        rgb.setR(255);
        rgb.setG(128);
        rgb.setB(0);

        ColorPalette palette = new ColorPalette();
        palette.setPrimary(true);
        palette.setRgb(rgb);

        session.save(palette);

        List<ColorPalette> palettes = session.createQuery("from ColorPalette", ColorPalette.class).list();
        for (ColorPalette p : palettes) {
            System.out.println("ID: " + p.getId() + ", Primary: " + p.isPrimary() +
                    ", RGB: (" + p.getRgb().getR() + ", " + p.getRgb().getG() + ", " + p.getRgb().getB() + ")");
        }

        ColorPalette toUpdate = palettes.getFirst();
        toUpdate.setPrimary(false);
        session.update(toUpdate);

        session.delete(toUpdate);

        transaction.commit();
        session.close();

        HibernateUtil.shutdown();
    }
}
