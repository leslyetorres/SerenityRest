package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;
import io.restassured.http.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PutPeticion extends RestInteraction {
    private final String recurso;
    private final String cuerpo;
    private static final Logger logger = LoggerFactory.getLogger(PostPeticion.class);

    public PutPeticion(String recurso, String cuerpo) {
        this.recurso = recurso;
        this.cuerpo = cuerpo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        logger.info("Iniciando solicitud PUT al recurso: {}", recurso);
        logger.debug("Cuerpo de la solicitud: {}", cuerpo);
        rest().log().all().contentType(ContentType.JSON)
                .body(cuerpo)
                .put(as(actor).resolve(recurso))
                .then().log().all();
        logger.info("Solicitud PUT exitosa a: {}", recurso);
    }

    public static PutPeticion recursoConCuerpo(String recurso, String cuerpo) {
        return instrumented(PutPeticion.class, recurso, cuerpo);
    }
}
