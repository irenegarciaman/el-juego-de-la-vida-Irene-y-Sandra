package com.example.demojavafx.ed;
import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;
import net.sourceforge.plantuml.UmlDiagram;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class GenerarUML {

        public static void generarDiagrama(String codigoUML) throws IOException {
            SourceStringReader reader = new SourceStringReader(codigoUML);
            System.out.println(1);
            OutputStream outputStream = new FileOutputStream("arbol.png");
            System.out.println(2);
            reader.generateImage(outputStream,new FileFormatOption(FileFormat.PNG));
            System.out.println(3);
            /***
            File file = new File("arbol.png");
            reader.generateImage(file);*/

        }

        public static void main(String[] args) throws IOException {
            String codigoUML = "@startuml\n" +
                    "class Cliente\n" +
                    "class Producto\n" +
                    "Cliente -- Producto : Compra\n" +
                    "@enduml";

            generarDiagrama(codigoUML);
        }
}
