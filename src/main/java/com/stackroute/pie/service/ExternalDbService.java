package com.stackroute.pie.service;

import com.stackroute.pie.domain.Policy;
import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.*;

public interface ExternalDbService {

    List<Policy> getPolicies(String insurerName) throws ClassNotFoundException, SQLException, UnsupportedEncodingException, JSONException;
}
