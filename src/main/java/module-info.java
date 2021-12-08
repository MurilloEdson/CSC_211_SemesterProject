module com.mycompany.semesterproject {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.semesterproject to javafx.fxml;
    exports com.mycompany.semesterproject;
}
