package com.spotify.oauth2.duplicates;

import com.spotify.oauth2.api.RestResource;
import com.spotify.oauth2.pojo.Playlist;
import io.restassured.response.Response;

import static com.spotify.oauth2.api.TokenManager.getToken;


public class PlaylistApiSecond {

   // static String access_token="BQBLMUxa4e2GDzJ2ss09vO4x6c4-Y_XSt_AyrtcQnpX4tCqmz8pBlN2ucZfVAOexGF0278098RfCtdpqafax8RCp8SFmU6boX06lhRevGCEp8EZAGzZqdsftphxj76V6nSFJ4OzO9u9H3mazuCFi2EZEWlGeNXzvNiSWWTEfOUqHZpCrgWV1JMNKHNNqrqihB6PbTp1hUGG96TzwbS4jObx35LDsBqQ4fINsuwtTMhdt";

    public static Response post(Playlist requestPlaylist) {
        return RestResource.post("/users/zyntzzhi99iy1a6aa6a92o78s/playlists",getToken(),requestPlaylist);
    }

    public static Response post(String token,Playlist requestPlaylist) {
        return RestResource.post("/users/zyntzzhi99iy1a6aa6a92o78s/playlists",token,requestPlaylist);


    }

    public static Response get(String playlistId){
        return RestResource.get("/playlists/"+playlistId,getToken());

    }

    public static Response update(String playlistId,Playlist requestPlaylist){
        return RestResource.update("/playlists/"+playlistId,getToken(),requestPlaylist);

        }
}
