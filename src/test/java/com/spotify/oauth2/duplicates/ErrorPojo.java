package com.spotify.oauth2.duplicates;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotify.oauth2.pojo.InnerError;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorPojo {


        @JsonProperty("error")
        private InnerError error;

        @JsonProperty("error")
        public InnerError getError() {
            return error;
        }

        @JsonProperty("error")
        public void setError(InnerError error) {
            this.error = error;
        }

    }

