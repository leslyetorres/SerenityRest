package stepdefinitions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static utils.Constantes.ACTOR;
import static utils.Constantes.BASE_URL;

public class EstablecerServicioStepDefinition {
    protected static final Actor actor = new Actor(ACTOR);

    protected void establecerServicios(String baseURL){
        actor.can(CallAnApi.at(baseURL));
    }
}
