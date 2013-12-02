package com.xrigau.droidcon.core.debug;

import java.io.IOException;
import java.util.Collections;

import retrofit.client.Client;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;

public class MockClient implements Client {

    private static final String APPLICATION_JSON = "application/json";
    private static final String SUCCESS = "Success";

    @Override
    public Response execute(Request request) throws IOException {
        return new Response(200, SUCCESS, Collections.EMPTY_LIST, new TypedByteArray(APPLICATION_JSON, MOCK_RESPONSE_JSON.getBytes()));
    }

    private static final String MOCK_RESPONSE_JSON = "[\n" +
            "  {\n" +
            "    \"id\": \"6826809\",\n" +
            "    \"title\": \"PS4 Jailbreaking (with OrbisOS 0day).\",\n" +
            "    \"url\": \"http://pastebin.com/QDeRQiMY\",\n" +
            "    \"domain\": \"pastebin.com\",\n" +
            "    \"points\": 38,\n" +
            "    \"user\": \"teawithcarl\",\n" +
            "    \"time_ago\": \"1 hour ago\",\n" +
            "    \"comments_count\": 17,\n" +
            "    \"type\": \"link\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"6826660\",\n" +
            "    \"title\": \"Why are there so many tunnels under London?\",\n" +
            "    \"url\": \"http://www.economist.com/blogs/economist-explains/2013/11/economist-explains-17\",\n" +
            "    \"domain\": \"economist.com\",\n" +
            "    \"points\": 42,\n" +
            "    \"user\": \"kevbin\",\n" +
            "    \"time_ago\": \"2 hours ago\",\n" +
            "    \"comments_count\": 28,\n" +
            "    \"type\": \"link\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"6826819\",\n" +
            "    \"title\": \"The Open Source Bikeshed\",\n" +
            "    \"url\": \"http://blog.jooq.org/2013/12/01/the-open-source-bikeshed/\",\n" +
            "    \"domain\": \"jooq.org\",\n" +
            "    \"points\": 9,\n" +
            "    \"user\": \"lukaseder\",\n" +
            "    \"time_ago\": \"56 minutes ago\",\n" +
            "    \"comments_count\": 11,\n" +
            "    \"type\": \"link\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"6825196\",\n" +
            "    \"title\": \"Mangalyaan, India's Mars Orbiter, has successfully commenced its journey to Mars\",\n" +
            "    \"url\": \"http://www.isro.gov.in/mars/updates.aspx\",\n" +
            "    \"domain\": \"isro.gov.in\",\n" +
            "    \"points\": 262,\n" +
            "    \"user\": \"middleclick\",\n" +
            "    \"time_ago\": \"12 hours ago\",\n" +
            "    \"comments_count\": 54,\n" +
            "    \"type\": \"link\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"6825998\",\n" +
            "    \"title\": \"Why Vagrant?\",\n" +
            "    \"url\": \"http://docs.vagrantup.com/v2/why-vagrant/index.html\",\n" +
            "    \"domain\": \"vagrantup.com\",\n" +
            "    \"points\": 93,\n" +
            "    \"user\": \"shawndumas\",\n" +
            "    \"time_ago\": \"7 hours ago\",\n" +
            "    \"comments_count\": 73,\n" +
            "    \"type\": \"link\"\n" +
            "  }\n" +
            "]";
}