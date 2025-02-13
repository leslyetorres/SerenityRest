package stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import interactions.PostPeticion;  // Clase personalizada para el POST
import questions.CodigoRespuesta;
import tasks.ConsumirServicioPost;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static tasks.ConsumirServicioGet.hacerConsumoGet;
import static tasks.ConsumirServicioPost.hacerConsumoPost;
import static utils.Constantes.BASE_URL;

public class PostStepDefinition extends EstablecerServicioStepDefinition {

    @Dado("que el usuario tiene acceso a la API de productos para POST")
    public void accesoAlRecursoPost() {
        OnStage.setTheStage(new OnlineCast());
        establecerServicios(BASE_URL);
    }

    @Cuando("realiza una solicitud POST al recurso {string} con el body:")
    public void postToResource(String recurso, String body) {
        actor.attemptsTo(ConsumirServicioPost.hacerConsumoPost().conRecurso(recurso).conCuerpo(body));
    }

    @Entonces("la respuesta de la insercion debe tener un código de metodo de solicitud no es soportado")
    public void verifyStatusCode() {
        actor.should(
                seeThat(
                        "el código de respuesta",
                        CodigoRespuesta.codigoRespuesta(), equalTo(SC_METHOD_NOT_ALLOWED)
                )
        );
    }
}