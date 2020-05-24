package com.example.myapp;

import java.util.List;

class RestJokeResponse {

    private String type;
    private List<Joke> value;

    public String getType()
    {
        return type;
    }

    public List<Joke> getValue() {
        return value;
    }
}
