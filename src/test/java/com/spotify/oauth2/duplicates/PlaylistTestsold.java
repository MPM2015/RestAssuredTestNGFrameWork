package com.spotify.oauth2.duplicates;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class PlaylistTestsold {

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    String access_token="BQCae3buyvF6PNZjDKbPRJr-rg8moQ7Rg4tV_Oo3px1dTVyHCHMBl_YNma-PD8u4vzbg-uOZuNocs_LJmWhJ70AgBrt_ClSGYVjiWrYGXBYnZioQnfT9m6esucmibePPT_lI0bK0_B3koopMRD6SVpX744A6ZkUl9Y8jw2ZxmlCTCytLYXg-WfWi1VF183S8O4KQHUOauUX8ewV09-jk_w4kfvYkT70PcAaTUDHuJTB9";

    @BeforeClass
    public void beforeclass() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
                requestSpecBuilder.setBaseUri("https://api.spotify.com").
                setBasePath("/v1").
                addHeader("Authorization","Bearer "+access_token).
                setContentType(ContentType.JSON).
                log(LogDetail.ALL);
        requestSpecification= requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
                //responseSpecBuilder.expectContentType(ContentType.JSON).
        responseSpecBuilder.log(LogDetail.ALL);
        responseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void ShouldBeAbleToCreateAPlaylist(){

        String payload="{\n" +
                "  \"name\": \"New Playlist\",\n" +
                "  \"description\": \"New playlist description\",\n" +
                "  \"public\": false\n" +
                "}";

        given(requestSpecification).
                body(payload).
        when().
                post("/users/zyntzzhi99iy1a6aa6a92o78s/playlists").
        then().
                spec(responseSpecification).
                assertThat().
                statusCode(201).
                contentType("application/json").
                body("name", is(equalTo("New Playlist")),
                        "description",is(equalTo("New playlist description")),
                        "public",is(equalTo(false)));


    }

    @Test
    public void ShouldBeAbleToGetAPlaylist(){

        given(requestSpecification).

        when().
                get("/playlists/2og0Z8ssv5rLmXVTEOqmLW").
        then().
                spec(responseSpecification).
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("name", is(equalTo("Updated Playlist Name Mahesh Madhugiri")),
                        "description",is(equalTo("Updated playlist description")),
                        "public",is(equalTo(false)));
    }

    @Test
    public void ShouldBeAbleToUpdateAPlaylist() {

        String payload = "{\n" +
                "  \"name\": \"New Playlist\",\n" +
                "  \"description\": \"New playlist description MPM\",\n" +
                "  \"public\": false\n" +
                "}";

        given(requestSpecification).
                body(payload).

                when().
                put("/playlists/3sMEzbKCaZAj65WhEnujOm").
                then().
                spec(responseSpecification).
                assertThat().
                statusCode(200);

    }

    @Test
    public void ShouldNotBeAbleToCreateAPlaylistWithoutName(){

        String payload="{\n" +
                "  \"name\": \"\",\n" +
                "  \"description\": \"New playlist description\",\n" +
                "  \"public\": false\n" +
                "}";

        given(requestSpecification).
                body(payload).
        when().
                post("/users/zyntzzhi99iy1a6aa6a92o78s/playlists").
        then().
                spec(responseSpecification).
                assertThat().
                statusCode(400).
                contentType("application/json").
                body("error.status", is(equalTo(400)),
                        "error.message",is(equalTo("Missing required field: name")));

    }

    @Test
    public void ShouldNotBeAbleToCreateAPlaylistWithExiredToken(){

        String payload="{\n" +
                "  \"name\": \"Name Playlist\",\n" +
                "  \"description\": \"New playlist description\",\n" +
                "  \"public\": false\n" +
                "}";

        given().
                baseUri("https://api.spotify.com").
                basePath("/v1").
                header("Authorization","Bearer "+"1234").
                contentType(ContentType.JSON).
                log().all().
                body(payload).
        when().
                post("/users/zyntzzhi99iy1a6aa6a92o78s/playlists").
        then().
                spec(responseSpecification).
                assertThat().
                statusCode(401).
                contentType("application/json").
                body("error.status", is(equalTo(401)),
                        "error.message",is(equalTo("Invalid access token")));

    }



}
