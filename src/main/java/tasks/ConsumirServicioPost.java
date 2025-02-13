package tasks;
import interactions.PostPeticion;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumirServicioPost implements Task {

    private String recurso;
    private String cuerpo;

    public ConsumirServicioPost conRecurso(String recurso) {
        this.recurso = recurso;
        return this;
    }

    public ConsumirServicioPost conCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PostPeticion.recursoConCuerpo(recurso, cuerpo)
                        .with(
                                requestSpecification -> requestSpecification
                                        .contentType(ContentType.JSON)
                                        .relaxedHTTPSValidation()
                        )
        );
    }

    public static ConsumirServicioPost hacerConsumoPost() {
        return instrumented(ConsumirServicioPost.class);
    }
}