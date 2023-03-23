module com.example.scenebuild {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.scenebuild to javafx.fxml;
    exports com.example.scenebuild;
}