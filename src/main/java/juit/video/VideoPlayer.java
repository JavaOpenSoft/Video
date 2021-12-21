package juit.video;
import java.io.File;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
public class VideoPlayer {
    String filePathWithName = "";
    File file;
    int width,height;
    public VideoPlayer(String filePathWithName,int width,int height)
    {
        this.filePathWithName = filePathWithName;
        this.width = width;
        this.height = height;

    }
    Media media = new Media(new File(filePathWithName).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(this.media);
    MediaView mediaView = new MediaView (this.mediaPlayer);
    StackPane root = new StackPane();
    Scene scene = new Scene(root,width,height);
    Stage primaryStage = new Stage();

    public void startPlaying() {
        this.mediaPlayer.setAutoPlay(true);
        this.root.getChildren().add(mediaView);
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        mediaPlayer.play();

    }
    public  void stopPlaying() {
        mediaPlayer.setAutoPlay(false);
        mediaPlayer.stop();
    }

    public Media getMedia() {
        return media;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public MediaView getMediaView() {
        return mediaView;
    }

    public String getFilePath() {
        return filePathWithName;
    }

}
