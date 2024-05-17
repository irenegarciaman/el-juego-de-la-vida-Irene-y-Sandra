module com.example.demojavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.logging;
    requires java.desktop;
    requires org.apache.logging.log4j;
    requires com.google.gson;
    requires plantuml;


    opens com.example.demojavafx to javafx.fxml, com.google.gson;
    exports com.example.demojavafx;
    exports com.example.demojavafx.ed;
    opens com.example.demojavafx.ed to javafx.fxml, com.google.gson;
    opens com.example.demojavafx.individuos to javafx.fxml, com.google.gson;
    opens com.example.demojavafx.recursos to javafx.fxml, com.google.gson;
}