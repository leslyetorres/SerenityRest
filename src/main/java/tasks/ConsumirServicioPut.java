package tasks;

import interactions.PutPeticion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import io.restassured.http.ContentType;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumirServicioPut implements Task {
    private String recurso;
    private String cuerpo;

    public ConsumirServicioPut conRecurso(String recurso) {
        this.recurso = recurso;
        return this;
    }
    public ConsumirServicioPut conCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PutPeticion.recursoConCuerpo(recurso, cuerpo)
                        .with(
                                requestSpecification -> requestSpecification
                                        .contentType(ContentType.JSON)
                                        .relaxedHTTPSValidation()
                        )
        );
    }

    public static ConsumirServicioPut hacerConsumoPut() {
        return instrumented(ConsumirServicioPut.class);
    }
}
