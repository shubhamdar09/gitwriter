package com.writer.cymmetri.apibasedsso.service;

import java.io.IOException;

public interface ApiService {

    String callApi(String urlStr, String inputStr) throws IOException;

}
