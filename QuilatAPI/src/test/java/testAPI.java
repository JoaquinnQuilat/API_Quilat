import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class testAPI {

    @Test
    public void testpost() {
        JSONObject posting = new JSONObject();

        posting.put("name", "Diamond");
        posting.put("job", "Escort");

        System.out.println(posting.toJSONString());

        given().
                body(posting.toJSONString()).
        when().
                post ("https://reqres.in/api/users").
        then().
            statusCode(201);
    }

    @Test
    public void testpatch() {
        JSONObject patching = new JSONObject();

        patching.put("name", "Karma");
        patching.put("job", "Stripper");

        System.out.println(patching.toJSONString());

        given().
                body(patching.toJSONString()).
        when().
                patch ("https://reqres.in/api/users/2").
        then().
            statusCode(200);
    }

    @Test
    public void testget() {

        when().
                get ("https://reqres.in/api/users/2").
        then().
            statusCode(200).log().all();
    }

    @Test
    public void testdelete() {

        when().
                delete ("https://reqres.in/api/users/2").
        then().
            statusCode(204).log().all();
    }

}