package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import org.jetbrains.annotations.NotNull;
import starter.UserInterface.SitioPersonas;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static starter.UserInterface.SitioPersonas.*;

public class Navegar implements Task {
    public static Performable aLaPaginaTasasTarifas() {
        return instrumented(Navegar.class);
    }

    @Override
    public <T extends Actor> void performAs(@NotNull T actor) {
        actor.attemptsTo(
                Open.browserOn().the(SitioPersonas.class),
                Click.on(PRODUCTOS_SERVICIOS),
                Click.on(PRESTAMOS),
                Click.on(PRESTAMO_AUTO),
                Click.on(TASASYTARIFAS),
                Click.on(DOCUMENTOPDF)
        );
    }
}
