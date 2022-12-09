package starter.UserInterface;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;


@DefaultUrl("https://www.banistmo.com/wps/portal/banistmo/personas/")
public class SitioPersonas extends PageObject {
    public static final Target PRODUCTOS_SERVICIOS = Target.the("Menu Productos y Servicios")
            .located(By.cssSelector(".dropdown-toggle"));
    public static final Target PRESTAMOS = Target.the("Link prestamos")
            .located(By.cssSelector(".col-sm-6:nth-child(2) li:nth-child(4) > a"));

    public static final Target PRESTAMO_AUTO = Target.the("Link prestamo auto")
                    .located(By.cssSelector(".col-md-6:nth-child(3) .imagen"));

    public static final Target TASASYTARIFAS = Target.the("Link Tasas y Tarifas")
            .located(By.cssSelector(".none:nth-child(4) > a"));

    public static final Target DOCUMENTOPDF = Target.the("Link PDF")
            .located(By.cssSelector("#tab4 tr:nth-child(2) img"));

    public static final String PAGINAS = "3";
}
