package questions;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CodigoRespuesta implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        JsonPath jsonPath = SerenityRest.lastResponse().jsonPath();
        Integer responseCode = jsonPath.getInt("responseCode");
        return responseCode;
    }
    public static CodigoRespuesta codigoRespuesta() {
        return new CodigoRespuesta();
    }
}
