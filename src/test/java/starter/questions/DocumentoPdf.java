package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import net.serenitybdd.screenplay.questions.TextValue;
import starter.search.PdfGenerado;

import static starter.UserInterface.SitioPersonas.*;

public class DocumentoPdf{
    public static Question<String> Titulo(){
        return actor -> PdfGenerado.Documento;
    }
    public static  Question<String> Contenido(){
        return actor -> PdfGenerado.Documento;
    }
}
