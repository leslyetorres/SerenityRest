package tasks;

import interactions.GetPeticion;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumirServicioGet implements Task {

    public ConsumirServicioGet conRecurso(String recurso) {
        this.recurso = recurso;
        return this;
    }
    private String recurso;
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                GetPeticion.recurso(recurso)
                        .with(
                                requestSpecification -> requestSpecification
                                        .contentType(ContentType.JSON)
                                        .relaxedHTTPSValidation()
                        )
        );
    }
    public static ConsumirServicioGet hacerConsumoGet(){
        return instrumented(ConsumirServicioGet.class);
    }
}
