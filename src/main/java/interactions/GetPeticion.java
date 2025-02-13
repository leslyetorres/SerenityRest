package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GetPeticion extends RestInteraction {
    private final String recurso;
    private static final Logger logger = LoggerFactory.getLogger(GetPeticion.class);

    public GetPeticion(String recurso) {
        this.recurso = recurso;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        logger.info("Iniciando solicitud GET a recurso: {}", recurso);
        rest().log().all().get(as(actor).resolve(recurso)).then().log().all();
        logger.info("Solicitud GET a recurso {} completada", recurso);
    }
    public static GetPeticion recurso(String recurso){
        return instrumented(GetPeticion.class, recurso);
    }
}
