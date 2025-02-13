package stepdefinitions;

import interactions.GetPeticion;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.CodigoRespuesta;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static tasks.ConsumirServicioGet.hacerConsumoGet;
import static utils.Constantes.BASE_URL;

public class GetStepDefinition extends EstablecerServicioStepDefinition{

    @Dado("que el usuario tiene acceso a la API de productos para GET")
    public void queElUsuarioTieneAccesoAlaAPIDeProductos() {
        OnStage.setTheStage(new OnlineCast());
        establecerServicios(BASE_URL);
    }

    @Cuando("realiza una petición GET al consumir el recurso {string}")
    public void realizaUnaPeticiónAlConsumirElRecurso(String recurso) {
        actor.attemptsTo(
                hacerConsumoGet().conRecurso(recurso)
        );
    }

    @Entonces("la respuesta debe tener un código de estado exitosa")
    public void laRespuestaDebeTenerUnCodigoDeEstadoExitosa() {
        actor.should(
                seeThat(
                        "el código de respuesta",
                        CodigoRespuesta.codigoRespuesta(), equalTo(SC_OK)
                )
        );
    }
}