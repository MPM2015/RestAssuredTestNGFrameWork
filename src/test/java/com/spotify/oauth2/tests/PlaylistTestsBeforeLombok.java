package com.spotify.oauth2.tests;

import com.spotify.oauth2.api.applicationAPI.PlaylistApi;
import com.spotify.oauth2.pojo.Error;
import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.utils.DataLoader;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class PlaylistTestsBeforeLombok {

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

    public void assertContentTypeExclusion(String actualContentType, String expectedContentType){
        assertThat(actualContentType,is(equalTo(expectedContentType)));

    }

    public void assertError(Error errorResponse,int expectedStatusCode,String expectedMsg){
        assertThat(errorResponse.getError().getStatus(),is(equalTo(expectedStatusCode)));
        assertThat(errorResponse.getError().getMessage(),is(equalTo(expectedMsg)));

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

        assertError(response.as(Error.class),400,"Missing required field: name");

    }

    @Test
    public void ShouldNotBeAbleToCreateAPlaylistWithExiredToken(){

        String invalid_token="12345";

        Playlist requestPlaylist = playlistBuilder("New Playlist","New playlist description",false);

        Response response=PlaylistApi.post(invalid_token,requestPlaylist);

        assertContentTypeExclusion(response.contentType(),"application/json");
        assertStatusCode(response.statusCode(),401);

        assertError(response.as(Error.class),401,"Invalid access token");

    }
*/
}
