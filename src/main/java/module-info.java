module com.georgiancollege.week06 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.georgiancollege.week06 to javafx.fxml;
    exports com.georgiancollege.week06;
}