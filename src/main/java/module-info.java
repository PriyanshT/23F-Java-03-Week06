module com.georgiancollege.week06 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.georgiancollege.week06 to javafx.fxml;
    exports com.georgiancollege.week06;
    exports com.georgiancollege.week06.Model;
    opens com.georgiancollege.week06.Model to javafx.fxml;
    exports com.georgiancollege.week06.Controller;
    opens com.georgiancollege.week06.Controller to javafx.fxml;
    exports com.georgiancollege.week06.Utilities;
    opens com.georgiancollege.week06.Utilities to javafx.fxml;
}