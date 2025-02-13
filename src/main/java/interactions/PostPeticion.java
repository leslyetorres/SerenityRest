package interactions;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class PostPeticion extends RestInteraction {
    private static final Logger logger = LoggerFactory.getLogger(PostPeticion.class);
    private final String recurso;
    private final String cuerpo;

    public PostPeticion(String recurso, String cuerpo) {
        this.recurso = recurso;
        this.cuerpo = cuerpo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        logger.info("Realizando solicitud POST a recurso: {}", recurso);
        rest().log().all()
                .contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .body(cuerpo)
                .post(as(actor).resolve(recurso))
                .then().log().all();
        logger.info("Solicitud POST realizada con éxito a recurso: {}", recurso);
    }

    public static PostPeticion recursoConCuerpo(String recurso, String cuerpo) {
        return instrumented(PostPeticion.class, recurso, cuerpo);
    }
}