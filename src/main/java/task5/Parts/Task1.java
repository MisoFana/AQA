package task5.Parts;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

class ColorPalette {
    public List<String> colors;
    public boolean isPrimary;
    public RGB rgb;
}

class RGB {
    public int r;
    public int g;
    public int b;
}

public class Task1 {

    public static void main(String[] args) throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        File inputJsonFile = new File("input.json");
        ColorPalette palette = jsonMapper.readValue(inputJsonFile, ColorPalette.class);

        palette.isPrimary = false;
        palette.rgb.g = 128;

        jsonMapper.writeValue(new File("output.json"), palette);
        xmlMapper.writeValue(new File("output.xml"), palette);
    }
}
