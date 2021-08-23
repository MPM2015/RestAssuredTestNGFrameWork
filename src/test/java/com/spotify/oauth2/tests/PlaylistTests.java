package com.spotify.oauth2.tests;

import com.spotify.oauth2.api.StatusCode;
import com.spotify.oauth2.api.applicationAPI.PlaylistApi;
import com.spotify.oauth2.pojo.Error;
import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.utils.DataLoader;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.spotify.oauth2.utils.FakerUtils.generateDescription;
import static com.spotify.oauth2.utils.FakerUtils.generateName;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@Epic("Spotify Oauth 2.0")
@Feature("Playlist API")
public class PlaylistTests extends BaseTest {

    @Story("Creation of Playlist Story")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @TmsLink("777")
    @Issue("999")
    @Description("First Testcases in Line")
    @Test(description = "Create a Playlist")
    public void ShouldBeAbleToCreateAPlaylist(){

        Playlist requestPlaylist = playlistBuilder(generateName(),generateDescription(),false);

        Response response=PlaylistApi.post(requestPlaylist);

        assertContentType(response.contentType(),"application/json; charset=utf-8");
        //assertStatusCode(response.statusCode(), StatusCode.CODE_201.getCode());
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);

        assertPlaylistEqual(response.as(Playlist.class),requestPlaylist);

    }

    @Test
    public void ShouldBeAbleToGetAPlaylist(){

        Playlist requestPlaylist = playlistBuilder("Updated Playlist Name Mahesh Madhugiri",
                "Updated playlist description",false);

        Response response=PlaylistApi.get(DataLoader.getInstance().getPlaylistId());

        assertContentType(response.contentType(),"application/json; charset=utf-8");
        assertStatusCode(response.statusCode(),StatusCode.CODE_200);

        assertPlaylistEqual(response.as(Playlist.class),requestPlaylist);

    }

    @Test
    public void ShouldBeAbleToUpdateAPlaylist() {

        Playlist requestPlaylist = playlistBuilder(generateName(),generateDescription(),false);

        Response response=PlaylistApi.update(DataLoader.getInstance().updatePlaylistId(), requestPlaylist);

        assertStatusCode(response.statusCode(),StatusCode.CODE_200);

    }

    @Story("Creation of Playlist Story")
    @Test
    public void ShouldNotBeAbleToCreateAPlaylistWithoutName(){

        Playlist requestPlaylist = playlistBuilder("",generateDescription(),false);

        Response response=PlaylistApi.post(requestPlaylist);

        assertContentType(response.contentType(),"application/json; charset=utf-8");
        assertStatusCode(response.statusCode(),StatusCode.CODE_400);

        assertError(response.as(Error.class),StatusCode.CODE_400);

    }

    @Story("Creation of Playlist Story")
    @Test
    public void ShouldNotBeAbleToCreateAPlaylistWithExiredToken(){

        String invalid_token="12345";

        Playlist requestPlaylist = playlistBuilder(generateName(),generateDescription(),false);

        Response response=PlaylistApi.post(invalid_token,requestPlaylist);

        assertContentTypeExclusion(response.contentType(),"application/json");
        assertStatusCode(response.statusCode(),StatusCode.CODE_401);

        assertError(response.as(Error.class),StatusCode.CODE_401);

    }

    @Step
    public Playlist playlistBuilder(String name, String description, boolean _public){

        return Playlist.builder().
                name(name).
                description(description).
                _public(_public).
                build();

        /*Playlist playlist = new Playlist();
        playlist.setName(name);
        playlist.setDescription(description);
        playlist.set_public(_public);
        return playlist;*/

    }

    @Step
    public void assertPlaylistEqual(Playlist responsePlaylist,Playlist requestPlaylist){
        assertThat(responsePlaylist.getName(),is(equalTo(requestPlaylist.getName())));
        assertThat(responsePlaylist.getDescription(),is(equalTo(requestPlaylist.getDescription())));
        assertThat(responsePlaylist.get_public(),is(equalTo(requestPlaylist.get_public())));

    }

    /*public void assertStatusCode(int actualStatusCode, int expectedStatusCode){
        assertThat(actualStatusCode,is(equalTo(expectedStatusCode)));

    }*/

      public void assertStatusCode(int actualStatusCode, StatusCode statusCode){
        assertThat(actualStatusCode,is(equalTo(statusCode.code)));

    }

    @Step
    public void assertContentType(String actualContentType, String expectedContentType){
        assertThat(actualContentType,is(equalTo(expectedContentType)));

    }

    @Step
    public void assertContentTypeExclusion(String actualContentType, String expectedContentType){
        assertThat(actualContentType,is(equalTo(expectedContentType)));

    }

    @Step
    public void assertError(Error errorResponse,StatusCode statusCode ){
        assertThat(errorResponse.getError().getStatus(),is(equalTo(statusCode.code)));
        assertThat(errorResponse.getError().getMessage(),is(equalTo(statusCode.msg)));

    }


}
