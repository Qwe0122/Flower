package com.example.hello;

import com.example.hello.utils.SecondPageUtils;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;


public class HelloController {

    @FXML
    private MediaView mediaView;

    @FXML
    private Text text;

    @FXML
    private ImageView image;
    @FXML
    private AnchorPane anchorPane;

    public void initialize() throws URISyntaxException {
        if (this.mediaView != null) {
            Media media = new Media(HelloController.class.getResource("/videos/M.mp4").toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);
            mediaPlayer.play();
        }
        if (this.image != null) {
            Image randomImage = new SecondPageUtils().getRandomImage();
            String randomText = new SecondPageUtils().getRandomText();
            image = new ImageView();
            image.setImage(randomImage);
            image.setFitWidth(anchorPane.getPrefWidth());
            image.setFitHeight(anchorPane.getPrefHeight());
            text.setText(randomText);
            text.setFill(Color.BLACK);
            text.setFont(Font.font("Serif", FontPosture.ITALIC, 22));
            text.setOpacity(1.0);

            AnchorPane.setTopAnchor(text, (anchorPane.getPrefHeight() - text.getBoundsInLocal().getHeight()) / 2);
            AnchorPane.setLeftAnchor(text, (anchorPane.getPrefWidth() - text.getBoundsInLocal().getWidth()) / 2);
            ObservableList<Node> children = anchorPane.getChildren();
            children.clear();
            children.add(image);
            children.add(text);
        }
    }
    @FXML
    public void onClick(ActionEvent actionEvent) throws IOException, URISyntaxException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("SecondWindow.fxml"));
        Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 720, 480);
        stage.setScene(scene);
        stage.show();
    }
}