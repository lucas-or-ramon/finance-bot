package br.com.devcanoa.financebot;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WhatsappRequest(@JsonProperty("Body") String body, @JsonProperty("From") String from, @JsonProperty("ProfileName") String profileName) {}
