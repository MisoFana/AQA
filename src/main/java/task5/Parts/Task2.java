package task5.Parts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        List<ColorPalette> palettes = generateRandomPalettes(10);

        List<ColorPalette> sortedPalettes = palettes.stream()
                .sorted(Comparator.comparing((ColorPalette p) -> p.rgb.r)
                        .thenComparing(p -> p.rgb.g))
                .filter(p -> p.isPrimary && p.rgb.r > 100)
                .toList();

        sortedPalettes.forEach(p -> System.out.println(p.colors));
    }

    private static List<ColorPalette> generateRandomPalettes(int count) {
        List<ColorPalette> palettes = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            ColorPalette palette = new ColorPalette();
            palette.isPrimary = random.nextBoolean();
            palette.rgb = new RGB();
            palette.rgb.r = random.nextInt(256);
            palette.rgb.g = random.nextInt(256);
            palette.rgb.b = random.nextInt(256);
            palette.colors = List.of("red", "green", "blue");
            palettes.add(palette);
        }
        return palettes;
    }
}

