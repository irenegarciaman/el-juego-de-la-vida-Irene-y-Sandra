module com.example.demojavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;


    opens com.example.demojavafx to javafx.fxml;
    exports com.example.demojavafx;
    exports com.example.demojavafx.matriz;
    opens com.example.demojavafx.matriz to javafx.fxml;
    exports com.example.demojavafx.ed;
    opens com.example.demojavafx.ed to javafx.fxml;
}