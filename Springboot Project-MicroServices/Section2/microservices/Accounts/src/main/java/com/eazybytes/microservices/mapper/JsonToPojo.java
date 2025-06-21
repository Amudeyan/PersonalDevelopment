package com.arav.junit.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

public class JsonToPojo {

    public static void main(String[] args) {
        String json = "{\n" +
                "  \"id\": 123456,\n" +
                "  \"name\": \"John Doe\",\n" +
                "  \"profile\": {\n" +
                "    \"address\": {\n" +
                "      \"street\": \"123 Main St\",\n" +
                "      \"city\": \"New York\",\n" +
                "      \"country\": \"USA\"\n" +
                "    },\n" +
                "    \"contact\": {\n" +
                "      \"email\": \"johndoe@example.com\",\n" +
                "      \"phone\": {\n" +
                "        \"mobile\": \"123-456-7890\",\n" +
                "        \"home\": \"987-654-3210\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"preferences\": {\n" +
                "      \"notifications\": {\n" +
                "        \"email\": true,\n" +
                "        \"sms\": false\n" +
                "      },\n" +
                "      \"language\": \"English\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"status\": \"active\",\n" +
                "  \"history\": [\n" +
                "    {\n" +
                "      \"date\": \"2021-01-01\",\n" +
                "      \"event\": \"Account Created\",\n" +
                "      \"details\": {\n" +
                "        \"type\": \"sign-up\",\n" +
                "        \"source\": \"web\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": \"2021-05-15\",\n" +
                "      \"event\": \"Subscription Upgraded\",\n" +
                "      \"details\": {\n" +
                "        \"type\": \"plan-change\",\n" +
                "        \"source\": \"app\"\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        try {
            // Initialize ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Convert JSON string to User POJO
            User user = objectMapper.readValue(json, User.class);

            Optional<String> street = user.getStreet();
            street.ifPresent(System.out::println);  // Prints the street if present, otherwise does nothing

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

