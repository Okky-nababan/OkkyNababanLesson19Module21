package pages;

import helper.Endpoint;
import helper.utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static helper.Models.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiPage {

    private static Response res;

    String setURL, global_user_id = null;

    public String setupURL(String url) {
        switch (url) {
            case "USER_GOREST":
                setURL = Endpoint.USER_GOREST;
                break;
            default:
                System.out.println("input right url");
        }
        return setURL;
    }

    public void hitGetListUser() {
        res = getListUsers(setURL);
    }

    public void hitPostCreateUser() {
        res = postCreateUsers(setURL);
        System.out.println(res.getBody().asString());
    }

    public void validationStatusCode(int status_code) {
        assertThat(res.statusCode()).isEqualTo(status_code);
    }

    public void validationBodyGetListUsers() {
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");

        assertThat(id.get(0)).isNotNull();
        assertThat(name.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
        assertThat(gender.get(0)).isIn("female", "male");
        assertThat(status.get(0)).isIn("active", "inactive");
    }

    public void validationBodyPostCreateNewUsers() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");

        global_user_id = Integer.toString(id);
    }

    public void hitDeleteUsers() {
        res = deleteUser(setURL, global_user_id);
    }

    public void hitUpdateUser() {
        res = updateUser(setURL, global_user_id);
    }

    public void validationJSONSChema(String filename) {
        File JSONFile = utility.getJSONSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public void validationBodyUpdateUsers() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");
    }
}

