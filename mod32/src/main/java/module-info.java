module com.example.mod32 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mod32 to javafx.fxml;
    exports com.example.mod32;
}