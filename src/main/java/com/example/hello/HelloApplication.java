package com.example.hello;


import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Mesh;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Objects;

public class HelloApplication extends Application {

    private static final double MODEL_SCALE_FACTOR = 2;
    private static final int VIEWPORT_SIZE = 800;

    private static final Color lightColor = Color.rgb(244, 255, 250);

    static MeshView[] loadMeshViews() throws URISyntaxException {
        File file = new File(Objects.requireNonNull(HelloApplication.class.getResource("/model/ROSE_EUROREPRAP_EU_UNTEXTED_20140224.stl")).toURI());
        StlMeshImporter importer = new StlMeshImporter();
        importer.read(file);
        Mesh mesh = importer.getImport();

        return new MeshView[] { new MeshView(mesh) };
    }

    private Group buildScene() throws URISyntaxException {
        MeshView[] meshViews = loadMeshViews();
        for (int i = 0; i < meshViews.length; i++) {
            Bounds bounds = meshViews[i].getBoundsInLocal();
            double centerX = (bounds.getMinX() + bounds.getMaxX()) / 2;
            double centerY = (bounds.getMinY() + bounds.getMaxY()) / 2;
            double centerZ = (bounds.getMinZ() + bounds.getMaxZ()) / 2;

            meshViews[i].setScaleX(MODEL_SCALE_FACTOR);
            meshViews[i].setScaleY(MODEL_SCALE_FACTOR);
            meshViews[i].setScaleZ(MODEL_SCALE_FACTOR);

            meshViews[i].setTranslateX(centerX + VIEWPORT_SIZE / 2);
            meshViews[i].setTranslateY(centerY + VIEWPORT_SIZE / 2);
            meshViews[i].setTranslateZ(centerZ + VIEWPORT_SIZE / 2);

            PhongMaterial phongMaterial = new PhongMaterial(Color.DARKRED);
            phongMaterial.setSpecularColor(Color.WHITE);
            phongMaterial.setSpecularPower(32);
            meshViews[i].setMaterial(phongMaterial);

            meshViews[i].setDrawMode(DrawMode.FILL);
            meshViews[i].setCullFace(CullFace.BACK);

            meshViews[i].getTransforms().setAll(new Rotate(38, Rotate.Z_AXIS), new Rotate(20, Rotate.X_AXIS));
        }

        PointLight pointLight = new PointLight(lightColor);
        pointLight.setTranslateX(VIEWPORT_SIZE * 3 / 4);
        pointLight.setTranslateY(VIEWPORT_SIZE / 2);
        pointLight.setTranslateZ(VIEWPORT_SIZE / 2);
        PointLight pointLight2 = new PointLight(lightColor);
        pointLight2.setTranslateX(VIEWPORT_SIZE * 1 / 4);
        pointLight2.setTranslateY(VIEWPORT_SIZE * 3 / 4);
        pointLight2.setTranslateZ(VIEWPORT_SIZE * 3 / 4);
        PointLight pointLight3 = new PointLight(lightColor);
        pointLight3.setTranslateX(VIEWPORT_SIZE * 5 / 8);
        pointLight3.setTranslateY(VIEWPORT_SIZE / 2);
        pointLight3.setTranslateZ(0);

        pointLight = new PointLight(lightColor.darker());

        Color ambientColor = Color.rgb(30, 30, 30, 0);
        AmbientLight ambient = new AmbientLight(ambientColor);

        Group root = new Group(meshViews);
        root.getChildren().add(pointLight);
        root.getChildren().add(pointLight2);
        root.getChildren().add(pointLight3);
        root.getChildren().add(ambient);

        return root;
    }


    private PerspectiveCamera addCamera(Scene scene) {
        PerspectiveCamera perspectiveCamera = new PerspectiveCamera();
        System.out.println("Near Clip: " + perspectiveCamera.getNearClip());
        System.out.println("Far Clip:  " + perspectiveCamera.getFarClip());
        System.out.println("FOV:       " + perspectiveCamera.getFieldOfView());

        scene.setCamera( perspectiveCamera);
        return perspectiveCamera;
    }

    @Override
    public void start(Stage primaryStage) throws URISyntaxException {
        Group group = buildScene();
        group.setScaleX(2);
        group.setScaleY(2);
        group.setScaleZ(2);
        group.setTranslateX(50);
        group.setTranslateY(50);

        Scene scene = new Scene(group, VIEWPORT_SIZE, VIEWPORT_SIZE, true);
        scene.setFill(Color.rgb(10, 10, 40));
        Rotate rotateX = new Rotate(0, Rotate.X_AXIS);
        Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);
        group.getTransforms().addAll(rotateX, rotateY);

        scene.setOnMouseDragged(event -> {
            double deltaX = event.getSceneX() - VIEWPORT_SIZE / 2;
            double deltaY = event.getSceneY() - VIEWPORT_SIZE / 2;

            for (Node node : group.getChildren()) {
                node.getTransforms().add(new Rotate(deltaX / 500, Rotate.Y_AXIS));
                node.getTransforms().add(new Rotate(-deltaY / 500, Rotate.X_AXIS));
            }
        });
        addCamera(scene);
        primaryStage.setTitle("Jewel Viewer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        System.setProperty("prism.dirtyopts", "false");
        launch(args);
    }
}