package config;

import io.qameta.allure.Attachment;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;

public class VideoRecorder {

    private static ScreenRecorder screenRecorder;

    public static void startRecording(String testName) throws Exception {
        File file = new File("videos/");
        if (!file.exists()) {
            file.mkdirs();
        }
        screenRecorder = new ScreenRecorder(
                GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration()
        );
        screenRecorder.start();
    }

    @Attachment(value = "Test Video", type = "video/mp4")
    public static byte[] stopRecording() throws Exception {
        screenRecorder.stop();
        File videoFile = screenRecorder.getCreatedMovieFiles().get(0);
        return java.nio.file.Files.readAllBytes(videoFile.toPath());
    }
}

