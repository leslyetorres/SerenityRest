package stepdefinitions;

import interactions.PutPeticion;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import questions.CodigoRespuesta;
import tasks.ConsumirServicioPut;

import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.*;
import static org.apache.http.HttpStatus.SC_METHOD_NOT_ALLOWED;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static utils.Constantes.BASE_URL;

import static org.hamcrest.CoreMatchers.equalTo;

public class putStepDefinition extends EstablecerServicioStepDefinition{

    @Dado("que el usuario tiene acceso a la API de marcas")
    public void queElUsuarioTieneAccesoALaApiDeMarcas() {
        OnStage.setTheStage(new OnlineCast());
        establecerServicios(BASE_URL);
    }

    @Cuando("realiza una petición al consumir el recurso {string} con el body:")
    public void realizaUnaPeticionAlConsumirElRecursoConElBody(String recurso, String body) {
        actor.attemptsTo(ConsumirServicioPut.hacerConsumoPut().conRecurso(recurso).conCuerpo(body));

    }

    @Entonces("la respuesta de la actualizacion debe tener un código de metodo de solicitud no es soportado")
    public void laRespuestaDebeTenerUnCodigoDeMetodoDeSolicitudNoEsSoportado() {
        actor.should(
                seeThat(
                        "el código de respuesta",
                        CodigoRespuesta.codigoRespuesta(), equalTo(SC_METHOD_NOT_ALLOWED)  // 405
                )
        );

    }
}