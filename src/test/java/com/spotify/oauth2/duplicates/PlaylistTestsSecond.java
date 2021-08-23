package com.spotify.oauth2.duplicates;

import com.spotify.oauth2.api.applicationAPI.PlaylistApi;
import com.spotify.oauth2.pojo.Error;
import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.utils.DataLoader;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class PlaylistTestsSecond {

   /* public Playlist playlistBuilder(String name, String description, boolean _public){
        return new Playlist().
                setName(name).
                setDescription(description).
                setPublic(_public);
    }

    public void assertPlaylistEqual(Playlist responsePlaylist,Playlist requestPlaylist){
        assertThat(responsePlaylist.getName(),is(equalTo(requestPlaylist.getName())));
        assertThat(responsePlaylist.getDescription(),is(equalTo(requestPlaylist.getDescription())));
        assertThat(responsePlaylist.getPublic(),is(equalTo(requestPlaylist.getPublic())));

    }

    public void assertStatusCode(int actualStatusCode, int expectedStatusCode){
        assertThat(actualStatusCode,is(equalTo(expectedStatusCode)));

    }

    public void assertContentType(String actualContentType, String expectedContentType){
        assertThat(actualContentType,is(equalTo(expectedContentType)));

    }


    @Test
    public void ShouldBeAbleToCreateAPlaylist(){

        Playlist requestPlaylist = playlistBuilder("New Playlist","New playlist description",false);

        Response response=PlaylistApi.post(requestPlaylist);

        assertContentType(response.contentType(),"application/json; charset=utf-8");
        assertStatusCode(response.statusCode(),201);

        assertPlaylistEqual(response.as(Playlist.class),requestPlaylist);

    }

    @Test
    public void ShouldBeAbleToGetAPlaylist(){

        Playlist requestPlaylist = playlistBuilder("Updated Playlist Name Mahesh Madhugiri",
                "Updated playlist description",false);

        Response response=PlaylistApi.get(DataLoader.getInstance().getPlaylistId());

        assertContentType(response.contentType(),"application/json; charset=utf-8");
        assertStatusCode(response.statusCode(),200);

        assertPlaylistEqual(response.as(Playlist.class),requestPlaylist);

    }

    @Test
    public void ShouldBeAbleToUpdateAPlaylist() {

        Playlist requestPlaylist = playlistBuilder("New Playlist","New playlist description",false);

        Response response=PlaylistApi.update(DataLoader.getInstance().updatePlaylistId(), requestPlaylist);

        assertStatusCode(response.statusCode(),200);



    }

    @Test
    public void ShouldNotBeAbleToCreateAPlaylistWithoutName(){

        Playlist requestPlaylist = playlistBuilder("","New playlist description",false);

        Response response=PlaylistApi.post(requestPlaylist);

        assertContentType(response.contentType(),"application/json; charset=utf-8");
        assertStatusCode(response.statusCode(),400);

        assertThat(response.contentType(),is(equalTo("application/json; charset=utf-8")));
        assertThat(response.statusCode(),is(equalTo(400)));

        Error errorResponse = response.as(Error.class);
                assertThat(errorResponse.getError().getStatus(),is(equalTo(400)));
                assertThat(errorResponse.getError().getMessage(),is(equalTo("Missing required field: name")));


    }

    @Test
    public void ShouldNotBeAbleToCreateAPlaylistWithExiredToken(){

        String invalid_token="12345";

        Playlist requestPlaylist = new Playlist().
                setName("New Playlist").
                setDescription("New playlist description").
                setPublic(false);

        Response response=PlaylistApi.post(invalid_token,requestPlaylist);
        assertThat(response.contentType(),is(equalTo("application/json")));
        assertThat(response.statusCode(),is(equalTo(401)));

        Error errorResponse = response.as(Error.class);

        assertThat(errorResponse.getError().getStatus(),is(equalTo(401)));
        assertThat(errorResponse.getError().getMessage(),is(equalTo("Invalid access token")));



    }*/



}
