package com.example.sina.dictionary.Database;

import java.util.UUID;

public class Word {

    private UUID id;
    private String wordEnglish;
    private String wordFrench;
    private String wordSpain;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getWordEnglish() {
        return wordEnglish;
    }

    public void setWordEnglish(String wordEnglish) {
        this.wordEnglish = wordEnglish;
    }

    public String getWordFrench() {
        return wordFrench;
    }

    public void setWordFrench(String wordFrench) {
        this.wordFrench = wordFrench;
    }

    public String getWordSpain() {
        return wordSpain;
    }

    public void setWordSpain(String wordSpain) {
        this.wordSpain = wordSpain;
    }
}
