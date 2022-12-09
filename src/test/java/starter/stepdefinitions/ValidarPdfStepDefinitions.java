package starter.stepdefinitions;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;
import org.jetbrains.annotations.NotNull;
import starter.abilities.ReadPdf;
import starter.questions.DocumentoPdf;
import starter.search.PdfGenerado;
import starter.tasks.Navegar;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Map;


public class ValidarPdfStepDefinitions {
    @Managed(driver = "chrome")
    private WebDriver navegador;
    private Actor alberto = Actor.named("Alberto");
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Before
    public void configuracionInicial(){
        alberto.can(BrowseTheWeb.with(navegador));
    }



    String downloadFolder = "src/test";
    String fileName = "prohibiciones.pdf";

    @Given("^(.*) navega hasta la pagina de tasas y tarifas")
    public void albertoNavegaHastaLaPaginaDeTasasYTarifas(String actor) {
        theActorCalled(actor).attemptsTo(Navegar.aLaPaginaTasasTarifas());
    }
    @When("el abre el pdf")
    public void elAbreElPdf() throws IOException {
        String statementFilePath = String.format("%s/%s", downloadFolder, fileName);

        alberto.whoCan(ReadPdf.downloadedInPath(statementFilePath));

       // String pdfText = ReadPdf.as(alberto).getText();
        PdfGenerado.Documento = ReadPdf.as(alberto).getText();


    }

    @Then("^el Pdf tiene la informacion siguiente:$")
    public void elPdfTieneLaInformacionSiguiente(Map<String,String> pdf) {
        alberto.should(
                seeThat(DocumentoPdf.Titulo(),containsString(pdf.get("Titulo"))),
                seeThat(DocumentoPdf.Contenido(), containsString(pdf.get("Acuerdo")))
        );
    }
}