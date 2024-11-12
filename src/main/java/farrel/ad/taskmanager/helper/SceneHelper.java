package farrel.ad.taskmanager.helper;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

import java.util.HashMap;
import java.util.Map;

public class SceneHelper {
    public static Map<String, Double> getSceneDimension(double desiredSize) {
        // Get the screen size
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        double screenWidth = screenBounds.getWidth();
        double screenHeight = screenBounds.getHeight();

        // Set scene dimensions to 80% of screen size
        double sceneWidth = screenWidth * desiredSize;
        double sceneHeight = screenHeight * desiredSize;

        Map<String, Double> dimensions = new HashMap<>();
        dimensions.put("width", sceneWidth);
        dimensions.put("height", sceneHeight);

        return dimensions;
    }
}
